package tcpserver.src.mavlinklib.command.camera;


import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class StopVideoStreaming implements FlightCommand {
	// VIDEO_STREAM_INFORMATION   msg
	// VIDEO_STREAM_STATUS   msg
	public StopVideoStreaming(int index){
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_VIDEO_STOP_STREAMING ; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = 0;                 	//_param1: Video Stream ID (0 for all streams, 1 for first, 2 for second, etc.)
		message.param2 = 0;						//_param2: // 
		message.param3 = 0;						//_param3: 
		message.param4 = 0;						//_param4: 
		message.param5 = 0;  //_param5: Reserved
		message.param6 = 0;  //_param6: Reserved
		message.param7 = 0;  //_param7: Reserved
		message.confirmation = 0;
		
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	private MAVLinkPacket packet;
	private byte[] rawData;
	
}
