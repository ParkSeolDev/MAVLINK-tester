package tcpserver.src.mavlinklib.command.camera;


import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class StopImageCapture implements FlightCommand {
	
	public StopImageCapture(int index)  {
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_IMAGE_STOP_CAPTURE; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = 0;                             //_param1: Reserved(Set to 0)
		message.param2 =  ( 0.0f/0.0f);          //_param2: Reserved
		message.param3 =  ( 0.0f/0.0f);			//_param3: Reserved
		message.param4 =  ( 0.0f/0.0f);			//_param4: Reserved
		message.param5 =  ( 0.0f/0.0f);			//_param5: Reserved
		message.param6 =  ( 0.0f/0.0f);			//_param6: Reserved
		message.param7 =  ( 0.0f/0.0f);			//_param7: Reserved
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
