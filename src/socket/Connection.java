package tcpserver.src.socket;

import tcpserver.src.mavlinklib.command.FlightCommand;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Queue;

public interface Connection {
    InetAddress getAddress();
    void send(Object objectToSend) throws IOException;
    void addListener(Listener listener);
    void start();
    void close();

    interface Listener {
        void messageReceived(Connection connection, Object message, Queue<FlightCommand> queue) throws IOException;
        void connected(Connection connection);
        void disconnected(Connection connection);
    }
}