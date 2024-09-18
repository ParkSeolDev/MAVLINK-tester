package tcpserver.src.socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Parser;
import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.common.msg_command_ack;
import tcpserver.src.mavlinklib.common.msg_sys_status;
import tcpserver.src.mavlinklib.enums.MAV_CMD;

public class TcpServer implements Server, Connection.Listener {

    private ServerSocket serverSocket;
    private volatile boolean isStop;
    private List<Connection> connections = new ArrayList<>();
    private List<Connection.Listener> listeners = new ArrayList<>();


    public void setPort(Integer port) {
        try {
            if (port == null) {
                port = 6760;
            }
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getConnectionsCount() {
        return connections.size();
    }

    @Override
    public void start() {
        new Thread(() -> {
            while (!isStop) {
                try {
                    Socket socket = serverSocket.accept();
                    if (socket.isConnected()) {
                        TcpConnection tcpConnection = new TcpConnection(socket);
                        tcpConnection.start();
                        tcpConnection.addListener(this);
                        connected(tcpConnection);

                        System.out.println("client connected");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void stop() {
        isStop = true;
    }

    @Override
    public List<Connection> getConnections() {
        return connections;
    }

    @Override
    public void addListener(Connection.Listener listener) {
        listeners.add(listener);
    }
/*
    @Override
    public void messageReceived(Connection connection, Object message, Queue queue) throws IOException {
        for (Connection.Listener listener : listeners) {
            listener.messageReceived(connection, message, queue);
        }
        Parser mParser = new Parser();
        byte[] bytes = Arrays.copyOf(message, 4096);

        MAVLinkPacket packet;
        for (int i = 0; i < bytes.length; i++) {
            packet = mParser.mavlink_parse_char(bytes[i] & 0xff);
            if (packet != null) {

                if (packet.msgid == msg_command_ack.MAVLINK_MSG_ID_COMMAND_ACK) {
                    msg_sys_status status = new msg_sys_status(packet);
                    System.out.println(status);

                    if (!queue.isEmpty() && (status.onboard_control_sensors_present != MAV_CMD.MAV_CMD_DO_DIGICAM_CONTROL)) {

                        send(queue.poll().getRawData());
                    }

                    for (int j = 0; j < 10000000; j++) {
                        System.out.print(5);
                    }

                    if(!queue.isEmpty() && (status.onboard_control_sensors_present == MAV_CMD.MAV_CMD_COMPONENT_ARM_DISARM)){
                        send(queue.poll().getRawData());
                    }

                }
                System.out.println("client : " + packet);

            }
        }
    }

 */
    @Override
    public void messageReceived(Connection connection, Object message, Queue<FlightCommand> queue) throws IOException {
        for (Connection.Listener listener : listeners) {
            listener.messageReceived(connection, message, queue);
        }
        Parser mParser = new Parser();

        byte[] bytes = Arrays.copyOf((byte[]) message, 4096);

                MAVLinkPacket packet;
                for (int i = 0; i < bytes.length; i++) {
                    packet = mParser.mavlink_parse_char(bytes[i] & 0xff);
                    if (packet != null) {

                        if (packet.msgid == msg_command_ack.MAVLINK_MSG_ID_COMMAND_ACK) {
                            msg_sys_status status = new msg_sys_status(packet);
                            System.out.println(status);

                            if (!queue.isEmpty() && (status.onboard_control_sensors_present != MAV_CMD.MAV_CMD_DO_DIGICAM_CONTROL)) {

                                connection.send(queue.poll().getRawData());
                            }

                            for (int j = 0; j < 10000000; j++) {
                                System.out.print(5);
                            }

                            if(!queue.isEmpty() && (status.onboard_control_sensors_present == MAV_CMD.MAV_CMD_COMPONENT_ARM_DISARM)){
                                connection.send(queue.poll().getRawData());
                            }

                        }
                        System.out.println("client : " + packet);

                    }
                }
    }

    @Override
    public void connected(Connection connection) {
        connections.add(connection);
        for (Connection.Listener listener : listeners) {
            listener.connected(connection);
        }
    }

    @Override
    public void disconnected(Connection connection) {
        connections.remove(connection);
        for (Connection.Listener listener : listeners) {
            listener.disconnected(connection);
        }
    }
}