package tcpserver.src;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBufAllocator;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.WriteTimeoutHandler;
import io.netty.util.Attribute;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.EventExecutor;
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
import tcpserver.src.netty.MyCallBack;
import tcpserver.src.netty.MyServerHandler;
import tcpserver.src.socket.Connection;
import tcpserver.src.socket.Server;
import tcpserver.src.socket.TcpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class TCPServerMain2 {
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 6760;  //서버 포트 번호
    private static final int READ_TIME_OUT = 60;  //읽기 타임아웃 설정(클라 -> 서버)
    private static final int WRITE_TIME_OUT = 30; //쓰기 타임아웃 설정(서버 -> 클라)

    private AtomicInteger lock = new AtomicInteger(0);
    Parser mParser = new Parser();

    Queue<FlightCommand> queue = new ConcurrentLinkedQueue<>();

    public static void main(String[] args) throws IOException {

//        Server tcpServer = new TcpServer();
//        tcpServer.setPort(6760);
//        tcpServer.start();

        TCPServerMain2 app = new TCPServerMain2();
        MyServerHandler handler = app.makeCallbackToDo();
        app.init(handler);


    }
    public MyServerHandler makeCallbackToDo(){
        return new MyServerHandler(new MyCallBack() {
            public void read(byte[] bytes) {    //요청에 따른 처리
//                byte[] bytes = new byte[4096];
//                bytes = SerializationUtils.serialize(msg);
//                String str = read;
//                bytes = msg.getBytes();
                if(queue.size() == 4){
                    write(queue.poll().getRawData());
                    stop();
                }

                MAVLinkPacket packet;
                for (int i = 0; i < bytes.length; i++) {
                    packet = mParser.mavlink_parse_char(bytes[i] & 0xff);
                    if (packet != null) {

                        if (packet.msgid == msg_command_ack.MAVLINK_MSG_ID_COMMAND_ACK) {
                            msg_sys_status status = new msg_sys_status(packet);
                            System.out.println(status);

                            if (!queue.isEmpty() && (status.onboard_control_sensors_present != MAV_CMD.MAV_CMD_DO_DIGICAM_CONTROL)) {

                                write(queue.poll().getRawData());
                                stop();
                            }

                            if (!queue.isEmpty() && (status.onboard_control_sensors_present == MAV_CMD.MAV_CMD_COMPONENT_ARM_DISARM)) {
                                write(queue.poll().getRawData());
                                stop();
                            }



                        }
                        System.out.println("client : " + packet);

                    }
                }

            }
            public byte[] write(byte[] msg) {   //응답할 내용


//                byte[] bytes = new byte[4096];
//                bytes = SerializationUtils.serialize(bytes);
                return msg;
            }
            @Override
            public void afterClose(ChannelHandlerContext ctx) { //커넥션 끊기면 할 내용
                System.out.println("커넥션이 끊기면 동작하는 메소드 입니다.");
            }

            @Override
            public void stop() {

                while(lock.get() < 10000000){
                    lock.addAndGet(1);
                }
                lock.incrementAndGet();


            }


        });
    }

    public void init(final MyServerHandler handler){
        EventLoopGroup group = new NioEventLoopGroup();
        try{
            ServerBootstrap serverBootstrap = new ServerBootstrap();
            serverBootstrap.group(group);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.localAddress(new InetSocketAddress(HOST, PORT));
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast("ReadTimeoutHandler", new ReadTimeoutHandler(READ_TIME_OUT));
                            socketChannel.pipeline().addLast("WriteTimeoutHandler", new WriteTimeoutHandler(WRITE_TIME_OUT));
                            socketChannel.pipeline().addLast("myHandler", handler);
                        }
                    })
                    .option(ChannelOption.SO_BACKLOG, 128)//동시 접속 수
                    .childOption(ChannelOption.SO_KEEPALIVE, true);  //패킷여부
            ChannelFuture channelFuture = serverBootstrap.bind().sync();
            channelFuture.channel().closeFuture().sync();

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
//            queue.add(arm);
//            queue.add(arm);
//            queue.add(arm);
//            queue.add(arm);
//            queue.add(takeoff);

        } catch(Exception e){
            e.printStackTrace();
        } finally {
            try { group.shutdownGracefully().sync(); } catch (InterruptedException e) { e.printStackTrace(); }
        }
    }



}
