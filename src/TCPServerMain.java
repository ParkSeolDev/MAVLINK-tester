package tcpserver.src;

import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Parser;
import tcpserver.src.mavlinklib.ardupilotmega.msg_power_pack_data;
import tcpserver.src.mavlinklib.command.*;
import tcpserver.src.mavlinklib.command.camera.DoDigcamControl;
import tcpserver.src.mavlinklib.command.camera.custom.DoDigicamBelowMode;
import tcpserver.src.mavlinklib.command.camera.custom.DoDigicamFaceMode;
import tcpserver.src.mavlinklib.command.camera.custom.DoDigicamLocalPitchControl;
import tcpserver.src.mavlinklib.command.camera.custom.DoDigicamLocalRollControl;
import tcpserver.src.mavlinklib.common.msg_command_ack;
import tcpserver.src.mavlinklib.common.msg_sys_status;
import tcpserver.src.mavlinklib.enums.MAV_CMD;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.LinkedList;
import java.util.Queue;


public class TCPServerMain {

    public static void main(String[] args) throws IOException {

        boolean isWorking = true;
        Drone drone = new Drone();

        ServerSocket ss = new ServerSocket(6760);
        Socket s = null;
        try {
            s = ss.accept();
            Parser mParser = new Parser();

            System.out.println("client connected");
            OutputStream outputStream = s.getOutputStream();
            Queue<FlightCommand> queue = new LinkedList<>();

//            long a = System.currentTimeMillis();
//            for (int i = 0; i < 10000000; i++) {
//                System.out.print(1);
//            }
//            long b = System.currentTimeMillis();
//            System.out.println(b-a);

            MAVLinkPacket packet;
            int maxBufferSize = 4096;
            byte[] recvBuffer = new byte[maxBufferSize];
            InputStream is = s.getInputStream();
            int nReadSize = is.read(recvBuffer);


//            FlightCommand arm = new Arm(drone.getSystemID(8), true);
//            outputStream.write(arm.getRawData());
//            outputStream.flush();
            FlightCommand doDigicamControl = new DoDigcamControl(3);
            FlightCommand nadirMode = new DoDigicamBelowMode(3);
            FlightCommand stowMode = new DoDigicamFaceMode(3);
            FlightCommand pitch = new DoDigicamLocalPitchControl(3,30);
            FlightCommand roll = new DoDigicamLocalRollControl(3,90);
            queue.add(doDigicamControl);
            queue.add(nadirMode);
            queue.add(stowMode);
            queue.add(pitch);
            queue.add(roll);

//            FlightCommand doMountControl = new DoMountControl(3,0,0,0);
//            outputStream.write(doMountControl.getRawData());
//            outputStream.flush();


//            long c = System.currentTimeMillis();
//            for (int i = 0; i < 5000000; i++) {
//                System.out.print(2);
//            }
//            long d = System.currentTimeMillis();
//            System.out.println(c-d);

            if (nReadSize > 0) {
                System.out.println("---------------------------------------------------------------------------------------");
                for (int i = 0; i < recvBuffer.length; i++) {
                    packet = mParser.mavlink_parse_char(recvBuffer[i] & 0xff);

                    if (packet != null) {

                        if (packet.msgid == msg_power_pack_data.MAVLINK_MSG_ID_POWER_PACK_DATA) {
                            msg_power_pack_data powerPack = new msg_power_pack_data(packet);
                        } else if (packet.msgid == msg_command_ack.MAVLINK_MSG_ID_COMMAND_ACK) {
                            msg_sys_status status = new msg_sys_status(packet);
                            System.out.println(status);
                            System.out.println("----------------ACK 받아서 들어옴요11111111----------------------");
                            if (status.onboard_control_sensors_present == MAV_CMD.MAV_CMD_COMPONENT_ARM_DISARM) {
                                System.out.println("---------------무장상태일 때111111111--------------------");
                                FlightCommand takeoff = new Takeoff(drone.getSystemID(8), 50);
                                outputStream.write(takeoff.getRawData());
                                outputStream.flush();
                                System.out.println("---------이륙한다아아아아아11111111------------------------------------------");


                            }
                        }
                    }
                }
            }

            while (isWorking) {

                is = s.getInputStream();
                nReadSize = is.read(recvBuffer);

                if (nReadSize > 0) {
                    for (int i = 0; i < recvBuffer.length; i++) {
                        packet = mParser.mavlink_parse_char(recvBuffer[i] & 0xff);

                        if (packet != null) {
                            if (packet.msgid == msg_power_pack_data.MAVLINK_MSG_ID_POWER_PACK_DATA) {
                                msg_power_pack_data powerPack = new msg_power_pack_data(packet);

                            } else if (packet.msgid == msg_command_ack.MAVLINK_MSG_ID_COMMAND_ACK) {
                                msg_sys_status status = new msg_sys_status(packet);
                                System.out.println(status);

                                if(!queue.isEmpty() && (status.onboard_control_sensors_present != MAV_CMD.MAV_CMD_DO_DIGICAM_CONTROL)) {
                                    outputStream.write(queue.poll().getRawData());
                                    outputStream.flush();
                                }

                                System.out.println("----------------ACK 받아서 들어옴요2222----------------------");
                                if (status.onboard_control_sensors_present == MAV_CMD.MAV_CMD_COMPONENT_ARM_DISARM) {
                                    System.out.println("---------------무장상태일 때222222----------------------");
                                    FlightCommand takeoff = new Takeoff(drone.getSystemID(8), 20);
                                    outputStream.write(takeoff.getRawData());
                                    outputStream.flush();
                                    System.out.println("---------이륙한다아아아아아22222-----------------------------------------------");

                                }

                                for (int j = 0; j < 9000000; j++) {
                                    System.out.print(5);
                                }

                            }
                            System.out.println("client : " + packet);
                        }
                    }


                }
                recvBuffer = new byte[maxBufferSize];
                PrintWriter pw = new PrintWriter(s.getOutputStream());
                pw.println("yes");
                pw.flush();
            }

        } catch (SocketException e) {

        } finally {
            if (s != null) {

                try {

                    s.close();

                } catch (IOException ex) {

                }

            }
        }

    }
}
