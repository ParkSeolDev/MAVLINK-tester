package tcpserver.src.mavlinklib.command.camera;


import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class RequestCameraInformation implements FlightCommand {
	
	public RequestCameraInformation(int index) {
		// MAV_CMD_REQUEST_CAMERA_INFORMATION
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = 1;                            //_param1: request 1
		message.param2 = 0;					        //_param2: 
		message.param3 = 0;							//_param3:
		message.param4 = 0;							//_param4: 
		message.param5 = 0;							//_param5:
		message.param6 = 0;							//_param6: 
		message.param7 = 0;							//_param7: 
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	public RequestCameraInformation(int index, int compId) {
		// MAV_CMD_REQUEST_CAMERA_INFORMATION
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		//message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //(short) compId; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_CAMERA; 
		message.command = MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		//message.command = 512; //MAV_CMD.MAV_CMD_REQUEST_MESSAGE;
		message.param1 = 1;                            //_param1: request 1
		//message.param1 = 259; // msg_camera_information.MAVLINK_MSG_ID_CAMERA_INFORMATION
		message.param2 = 0;					        //_param2: 
		message.param3 = 0;							//_param3:
		message.param4 = 0;							//_param4: 
		message.param5 = 0;							//_param5:
		message.param6 = 0;							//_param6: 
		message.param7 = 0;							//_param7: 
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
