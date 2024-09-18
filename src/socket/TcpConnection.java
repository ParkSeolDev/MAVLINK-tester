package tcpserver.src.socket;

import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Parser;
import tcpserver.src.mavlinklib.command.Arm;
import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.command.Takeoff;
import tcpserver.src.mavlinklib.command.camera.custom.DoDigicamBelowMode;
import tcpserver.src.mavlinklib.command.camera.custom.DoDigicamFaceMode;
import tcpserver.src.mavlinklib.command.camera.custom.DoDigicamLocalPitchControl;
import tcpserver.src.mavlinklib.command.camera.custom.DoDigicamLocalRollControl;
import tcpserver.src.mavlinklib.common.msg_command_ack;
import tcpserver.src.mavlinklib.common.msg_sys_status;
import tcpserver.src.mavlinklib.enums.MAV_CMD;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.*;

public class TcpConnection implements Connection {
    private InputStream inputStream;
    private OutputStream outputStream;
    private Socket socket;
    private List<Listener> listeners = new ArrayList<>();
    private BufferedReader br;
    private PrintWriter pw;
//    private Parser mParser = new Parser();
Queue<FlightCommand> queue = new LinkedList<>();

    public TcpConnection(Socket socket) {
        this.socket = socket;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public InetAddress getAddress() {
        return socket.getInetAddress();
    }

    @Override
    public void send(Object objectToSend) throws IOException {
        new Thread(() -> {
            if (objectToSend instanceof byte[]) {
                byte[] data = (byte[]) objectToSend;
                try {
                    outputStream.write(data);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            br = new BufferedReader(new InputStreamReader(inputStream));
            pw = new PrintWriter(outputStream);
            pw.println(objectToSend);
            pw.flush();
        }).start();
    }

    @Override
    public void addListener(Listener listener) {
        listeners.add(listener);
    }

    @Override
    public void start() {
        new Thread(() -> {

            Parser mParser = new Parser();

            FlightCommand nadirMode = new DoDigicamBelowMode(3);
            FlightCommand stowMode = new DoDigicamFaceMode(3);
            FlightCommand pitch = new DoDigicamLocalPitchControl(3, 30);
            FlightCommand roll = new DoDigicamLocalRollControl(3, 90);
            FlightCommand arm = new Arm(9, true);
            FlightCommand takeoff = new Takeoff(9,20);

            queue.add(nadirMode);
            queue.add(stowMode);
            queue.add(pitch);
            queue.add(roll);
//            queue.add(arm);
//            queue.add(takeoff);

            /*
            while (!queue.isEmpty()) {
                byte buf[] = new byte[4096];
                try {
                    int count = inputStream.read(buf);
                    if (count > 0) {
                        byte[] bytes = Arrays.copyOf(buf, count);
                        for (Listener listener : listeners) {
                            listener.messageReceived(this, bytes);
                        }

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

                    } else {
                        socket.close();
                        for (Listener listener : listeners) {
                            listener.disconnected(this);
                        }
                        break;
                    }



                } catch (IOException e) {
//                    e.printStackTrace();
                    for (Listener listener : listeners) {
                        listener.disconnected(this);
                    }
                    break;
                }
            }

             */
        }).start();
    }

    @Override
    public void close() {
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
