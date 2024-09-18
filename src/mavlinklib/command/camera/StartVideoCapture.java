package tcpserver.src.mavlinklib.command.camera;


import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class StartVideoCapture implements FlightCommand {
	// mavlink_video_stream_information_t
	// mavlink_video_stream_status_t
	public StartVideoCapture(int index){
		// CAMERA_CAPTURE_STATUS 주기적으로 받기 가능.
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_VIDEO_START_CAPTURE ; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = 0;                 	//_param1: reserved(set to 0)
		message.param2 = 0.2f;			//_param2: // CAMERA_CAPTURE_STATUS Frequency 0is no message // (default to every 5 seconds)
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
