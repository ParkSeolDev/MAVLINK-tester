package tcpserver.src.mavlinklib.command.camera.custom;

import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.command.camera.custom.list.CMD_USER_CONTROL_LIST;
import tcpserver.src.mavlinklib.command.camera.custom.list.CUSTOM_DEVICE_LIST;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;


public class OnSearchLiteControlAmp implements FlightCommand {
	
	public OnSearchLiteControlAmp(int index) {
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_PERIPHERAL; //  MAV_COMPONENT.MAV_COMP_ID_ALL; //MAV_COMPONENT.MAV_COMP_ID_ALL; // MAV_COMP_ID_GIMBAL
		message.command = MAV_CMD.MAV_CMD_USER_1 ; // 프리뉴,, 암묵적 사용
		message.param1 = CUSTOM_DEVICE_LIST.AMP_SEARCH_LIGHT.rawStateData;       			//_param1: speacker : 1, led : 2, search lite : 3 ...
		message.param2 = CMD_USER_CONTROL_LIST.USER_CONTROL_LIGHT_ON.rawStateData;				//_param2: control input
		
//		message.param3 = IcpUtil.ICP_NAN;	
//		message.param4 = IcpUtil.ICP_NAN;		
//		message.param5 = IcpUtil.ICP_NAN; 
//		message.param6 = IcpUtil.ICP_NAN; 
//		message.param7 = IcpUtil.ICP_NAN;  
		
		message.param3 = 0;		
		message.param4 = 0;	
		message.param5 = 0; 
		message.param6 = 0; 
		message.param7 = 0; 
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
