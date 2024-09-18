package tcpserver.src.mavlinklib.command.camera.custom;


import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class ControlUserCmd implements FlightCommand {
	
	public ControlUserCmd(int index, int device, float control, float param3) {
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL; // MAV_COMP_ID_GIMBAL
		message.command = MAV_CMD.MAV_CMD_USER_1 ; // 프리뉴,, 규약적 사용
		message.param1 = device;       			//_param1: speacker : 1, led : 2, search lite : 3 ...
		message.param2 = control;				//_param2: control input
		message.param3 = param3;		    //_param3: trackNumber
//		message.param4 = IcpUtil.ICP_NAN;		//_param4:
//		message.param5 = IcpUtil.ICP_NAN;  //_param5:
//		message.param6 = IcpUtil.ICP_NAN;  //_param6:
//		message.param7 = IcpUtil.ICP_NAN;  //_param7:
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
