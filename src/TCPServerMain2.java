@Slf4j
public class TCPServerMain2 {
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	private static final String HOST = "127.0.0.1";
	private static final int PORT = 6760;  //서버 포트 번호
	private static final int READ_TIME_OUT = 60;  //읽기 타임아웃 설정(클라 -> 서버)
	private static final int WRITE_TIME_OUT = 30; //쓰기 타임아웃 설정(서버 -> 클라)
	public static Queue<byte[]> commandQueue = new LinkedList<byte[]>();
	//    private msg_sys_status statusVar;
	Parser mParser = new Parser();
	private byte[] countRawData;
	private MAVLinkPacket packetVar;

	private int countSeq = 10;
	private int[] countNum = new int[countSeq];
	ItemTimer itemTimer = null;

	public TCPServerMain2() {

	}


	public static void main(String[] args) throws IOException {

		//        Server tcpServer = new TcpServer();
		//        tcpServer.setPort(6760);
		//        tcpServer.start();
		TCPServerMain2 app = new TCPServerMain2();
		MyServerHandler handler = app.makeCallbackToTransmission();
		app.init(handler);
	}

	public MyServerHandler makeCallbackToTransmission() {

		return new MyServerHandler(new MyCallBack() {
			@Override
			public void channelRegistered(ChannelHandlerContext channelHandlerContext){

				//        FlightCommand stowMode = new DoDigicamFaceMode(3);
				FlightCommand cameraZoomIn = new DoDigicamZoomInMode(1);
				//        FlightCommand cameraZoomOut = new DoDigicamZoomOutMode(1);
				FlightCommand cameraZoomStop = new DoDigicamZoomStopMode(1);
				//        FlightCommand cameraEOMode = new DoDigicamEOMode(1);
				//        FlightCommand cameraIRMode = new DoDigicamIRMode(1);
				//        FlightCommand cameraDoNUCControl = new DoDigicamDoNUCControl(1);
				//        FlightCommand pitch = new DoDigicamLocalPitchControl(3, 30);
				//        FlightCommand roll = new DoDigicamLocalRollControl(3, 90);
				//        FlightCommand pitchRoll = new DoDigicamLocalPitchRollControl(3, 0,0);
				//        commandQueue.add(stowMode.getRawData());
				//        commandQueue.add(cameraZoomOut.getRawData());
				commandQueue.add(cameraZoomIn.getRawData());
				commandQueue.add(cameraZoomStop.getRawData());
				//        commandQueue.add(cameraIRMode.getRawData());
				//        commandQueue.add(cameraDoNUCControl.getRawData());
				//        commandQueue.add(cameraDoNUCControl.getRawData());
				//        commandQueue.add(cameraEOMode.getRawData());
				//        commandQueue.add(pitch.getRawData());
				//        commandQueue.add(roll.getRawData());
				//        commandQueue.add(pitchRoll.getRawData());


				//        FlightCommand nadirMode = new DoDigicamBelowMode(3);
				//        FlightCommand stowMode = new DoDigicamFaceMode(3);
				//        FlightCommand pitch = new DoDigicamLocalPitchControl(3, 30);
				//        FlightCommand roll = new DoDigicamLocalRollControl(3, 90);
				//        FlightCommand arm = new Arm(9, true);
				//        FlightCommand takeoff = new Takeoff(9,20);

				//        commandQueue.add(nadirMode.getRawData());
				//        commandQueue.add(stowMode.getRawData());
				//        commandQueue.add(pitch.getRawData());
				//        commandQueue.add(roll.getRawData());
				//        commandQueue.add(arm.getRawData());
				//        commandQueue.add(takeoff.getRawData());
				//                SendWaypointCount count = new SendWaypointCount(9, countSeq);
				//                countRawData = count.getRawData();
				//                commandQueue.add(countRawData);
				channelHandlerContext.fireChannelRegistered();
			}

			@Override
			public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
				if(this != null){
					this.afterClose(ctx);
				}
				ctx.disconnect(promise);
			}

			@Override
			public void read(byte[] bytes) {    //요청에 따른 처리

				MAVLinkPacket packet;
				for (int i = 0; i < bytes.length; i++) {
					packet = mParser.mavlink_parse_char(bytes[i] & 0xff);
					if (packet != null) {
						packetVar = packet;
						//                        msg_sys_status status = new msg_sys_status(packet);
						//                        System.out.println(status);

						if (packet.msgid == msg_command_ack.MAVLINK_MSG_ID_COMMAND_ACK) {
							logger.info("msg_command_ack : {}", packet);
						}
						if (packet.msgid == msg_mission_ack.MAVLINK_MSG_ID_MISSION_ACK) {
							logger.info("msg_mission_ack : {}", packet);
						}

						if (packetVar.msgid == msg_mission_request.MAVLINK_MSG_ID_MISSION_REQUEST) {

							SendWaypointTakeoff sendWaypointTakeoff = new SendWaypointTakeoff(9, 20, 0);
							SendWaypointChangeSpeed sendWaypointChangeSpeed1 = new SendWaypointChangeSpeed(9, 10, 1);
							SendWaypointChangeSpeed sendWaypointChangeSpeed2 = new SendWaypointChangeSpeed(9, 20, 2);
							SendWaypointChangeSpeed sendWaypointChangeSpeed3 = new SendWaypointChangeSpeed(9, 30, 3);
							SendWaypointRetureToLaunch sendWaypointRetureToLaunch = new SendWaypointRetureToLaunch(9, 4);
							SendWaypointChangeSpeed sendWaypointChangeSpeed4 = new SendWaypointChangeSpeed(9, 10, 5);
							SendWaypointChangeSpeed sendWaypointChangeSpeed5 = new SendWaypointChangeSpeed(9, 20, 6);
							SendWaypointChangeSpeed sendWaypointChangeSpeed6 = new SendWaypointChangeSpeed(9, 30, 7);
							SendSetHome sendSetHome = new SendSetHome(9, 8);
							SendWaypointRetureToLaunch sendWaypointRetureToLaunch2 = new SendWaypointRetureToLaunch(9, 9);

							msg_mission_request_int msgMissionRequestInt = new msg_mission_request_int(packetVar);
							countNum[msgMissionRequestInt.seq] = 1;
							if (msgMissionRequestInt.seq == 0) {
								commandQueue.add(sendWaypointTakeoff.getRawData());
							} else if (msgMissionRequestInt.seq == 1) {
								commandQueue.add(sendWaypointChangeSpeed1.getRawData());
							} else if (msgMissionRequestInt.seq == 2) {
								commandQueue.add(sendWaypointChangeSpeed2.getRawData());
							} else if (msgMissionRequestInt.seq == 3) {
								commandQueue.add(sendWaypointChangeSpeed3.getRawData());
							} else if (msgMissionRequestInt.seq == 4) {
								commandQueue.add(sendWaypointRetureToLaunch.getRawData());
							} else if (msgMissionRequestInt.seq == 5) {
								commandQueue.add(sendWaypointChangeSpeed4.getRawData());
							} else if (msgMissionRequestInt.seq == 6) {
								commandQueue.add(sendWaypointChangeSpeed5.getRawData());
							} else if (msgMissionRequestInt.seq == 7) {
								commandQueue.add(sendWaypointChangeSpeed6.getRawData());
							} else if (msgMissionRequestInt.seq == 8) {
								commandQueue.add(sendSetHome.getRawData());
							} else if (msgMissionRequestInt.seq == 9) {
								commandQueue.add(sendWaypointRetureToLaunch2.getRawData());
								countRawData = new byte[]{0};
								itemTimer.interrupt();
								isCountAck = false;
								isThreadStop = true;
								logger.debug("countRawData : {}", countRawData);
							}
							logger.info("msg_mission_request_int : {}", msgMissionRequestInt);
						}
						//                        logger.info("client : {}", packet);
						//                        logger.debug("isCountAck : {}", isCountAck);
					}
				}

			}

			@Override
			public void write(ChannelHandlerContext channelHandlerContext) throws InterruptedException {
				if (packetVar != null) {
					if (commandQueue.size() != 0) {
						//                        stop();
						//                        if (commandQueue.peek() == countRawData) {
						//                            isCountPoll = true;
						//                        }
						ByteBuf bytes = Unpooled.wrappedBuffer(commandQueue.poll());
						channelHandlerContext.writeAndFlush(bytes);
						System.out.println("^^^^^^^^^^^^^^^^^^^^^write^^^^^^^^^^^^^^^^^^^^");
						//                        if (isCountPoll) {
						//                            isCountAck = true;
						//                            isCountPoll = false;
						//                        }
					}
				}
			}

			//            public ByteBuf write(byte[] msg) {   //응답할 내용
			//                ByteBuf bytes = Unpooled.wrappedBuffer(msg);
			//                return bytes;
			//            }
			@Override
			public void afterClose(ChannelHandlerContext ctx) { //커넥션 끊기면 할 내용
				packetVar = null;
				System.out.println("커넥션이 끊기면 동작하는 메소드 입니다.");
			}

			@Override
			public void stop() throws InterruptedException {
				System.out.println("------------------------------sleep------------------------------------");
				TimeUnit.SECONDS.sleep(1);

			}


		});
	}

	public void init(final MyServerHandler handler) {

		MissionItemCreator creator = new MissionItemCreator();
		Marker marker = new Marker();
		DoCommand_t doCommand_t = new DoCommand_t();
		WaypointInformation wpInfo = creator.createDoCommandMissionItem(9, doCommand_t, marker, true);
		WaypointInformation wpInfo2 = creator.createCommonMissionItem(MissionItemCreator.MissionTypeAPM_t.valueOf(22), true, 9, 0, 22, (short) 3, 0.00, 0.00, 0.00, 0.0f, 0, 0, 20.0f, (short) 1, (short) 0, marker, true);
		WaypointInformation wpInfo3 = creator.createCommonMissionItem(MissionDoCommandChangeSpeed, true, 9, 0, 178, (short) 3, 0.00, 0.00, 0.00, 0.0f, 0, 0, 20.0f, (short) 1, (short) 0, marker, true);

		//        SendWaypointCount count = new SendWaypointCount(9, 10);
		//        countRawData = count.getRawData();
		//        commandQueue.add(countRawData);

		//        commandQueue.add(wpInfo2.getRawData());
		//        commandQueue.add(wpInfo3.getRawData());


		//        MissionItem missionItem2 = new MissionItem(9);
		//        MissionItem missionItem = new MissionItem(9, true, 0, 22, (short) 3, 0.00, 0.00, 0.00, 0.0f, 0, 0, 20.0f, (short) 1, (short) 0);
		//        MissionItem missionItem2 = new MissionItem(9, true, 2, MAV_CMD.MAV_CMD_DO_CHANGE_SPEED, (short) 3, 1.0, 1.0, 1.0, 1.0, 1.0, 1.0, 0.0f, (short) 1, (short) 1);

		//        commandQueue.add(missionItem.getPacket().encodePacket());
		//        commandQueue.add(missionItem2.getRawData());

		EventLoopGroup group = new NioEventLoopGroup();
		try {
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
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				group.shutdownGracefully().sync();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}


}
