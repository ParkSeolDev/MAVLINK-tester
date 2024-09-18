public class TcpServer implements Server, Connection.Listener {

    private ServerSocket serverSocket;
    private volatile boolean isStop;
    private List<Connection> connections = new ArrayList<>();
    private List<Connection.Listener> listeners = new ArrayList<>();
    Queue<msg_sys_status> statusQueue = new LinkedList<>();


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

    @Override
    public void messageReceived(Connection connection, Object message) throws IOException {
        System.out.println("*******************************************************");

        for (Connection.Listener listener : listeners) {
            listener.messageReceived(connection, message);
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


                    if (commandQueue.peek() != null && (status.onboard_control_sensors_present != MAV_CMD.MAV_CMD_DO_DIGICAM_CONTROL)) {
                        statusQueue.add(status);
                        //                                connection.sleep();
                        //                                connection.send(queue.poll());

                    }

                    //                            for (int j = 0; j < 10000000; j++) {
                    //                                System.out.print(5);
                    //                            }

                    //                    if (commandQueue.peek() != null && (status.onboard_control_sensors_present == MAV_CMD.MAV_CMD_COMPONENT_ARM_DISARM)) {
                    //                        connection.sleep();
                    //                        connection.send(commandQueue.poll());
                    //                    }

                }
                System.out.println("client : " + packet);

            }
        }
        if (statusQueue.poll() != null) {
            if (commandQueue.peek() != null) {
                System.out.println(Arrays.toString(commandQueue.peek()));
                connection.send(commandQueue.poll());

                connection.sleep();

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
