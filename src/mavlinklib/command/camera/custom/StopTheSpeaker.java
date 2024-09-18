package tcpserver.src.mavlinklib.command.camera.custom;

import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.command.camera.custom.list.CMD_USER_CONTROL_LIST;
import tcpserver.src.mavlinklib.command.camera.custom.list.CUSTOM_DEVICE_LIST;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;


public class StopTheSpeaker implements FlightCommand {
	
	public StopTheSpeaker(int index) {
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL; // MAV_COMP_ID_GIMBAL
		message.command = MAV_CMD.MAV_CMD_USER_1 ; // 프리뉴,, 암묵적 사용
		message.param1 = CUSTOM_DEVICE_LIST.PRENEU_SPEACKER.rawStateData;       			//_param1: speacker : 1, led : 2, search lite : 3 ...
		message.param2 = CMD_USER_CONTROL_LIST.USER_CONTROL_SPEAKER_STOP.rawStateData;				//_param2: control input
//		message.param3 = IcpUtil.ICP_NAN; // 0;		//_param3: trackNumber 0 : current mp
//		message.param4 = IcpUtil.ICP_NAN;		//_param4:
//		message.param5 = IcpUtil.ICP_NAN;  //_param5: roll input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
//		message.param6 = IcpUtil.ICP_NAN;  //_param6: pitch input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
//		message.param7 = IcpUtil.ICP_NAN;  //_param7: yaw input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
