package tcpserver.src.mavlinklib.command.camera;


import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.common.msg_gimbal_manager_information;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class RequestGimbalManagerInfo implements FlightCommand {
	
	
	public RequestGimbalManagerInfo(int index, int compId) {
		// GIMBAL_MANAGER_INFORMATION
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		//message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //(short) compId; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_ALL; // MAV_COMP_ID_GIMBAL;
		message.command = MAV_CMD.MAV_CMD_REQUEST_MESSAGE; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
//		* param1 = message ID of the requested message
//	     147: send BATTERY_STATUS message
//	     148: send AUTOPILOT_VERSION message
//	     253: send STATUSTEXT message with firmware and board type information
//	     259: send CAMERA_INFORMATION message
//	     260: send CAMERA_SETTINGS message
//	     261: send STORAGE_INFORMATION message
//	     262: send CAMERA_CAPTURE_STATUS message
//	     263: (CAMERA_IMAGE_CAPTURED) returns COMMAND_ACK with MAV_CMD_ACK_DENIED
//	     300: send PROTOCOL_VERSION message
//	     397: send COMPONENT_METADATA message
	     
		message.param1 = msg_gimbal_manager_information.MAVLINK_MSG_ID_GIMBAL_MANAGER_INFORMATION;                            //_param1: request MAVLINK_MSG_ID_GIMBAL_MANAGER_INFORMATION
		//message.param1 = 259; // msg_camera_information.MAVLINK_MSG_ID_CAMERA_INFORMATION
		message.param2 = 0;					        //_param2: 
		message.param3 = 0;							//_param3:
		message.param4 = 0;							//_param4: 
		message.param5 = 0;							//_param5:
		message.param6 = 0;							//_param6: 
		message.param7 = 0;							//_param7: 
//		* param7 = response target
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
