package tcpserver.src.mavlinklib.command.camera;


import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class StopVideoCapture implements FlightCommand {
	
	public StopVideoCapture(int index){
	
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_VIDEO_STOP_CAPTURE ; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = 0;                 	//_param1: reserved(set to 0)
		message.param2 = 0;						//_param2: interval - 연속되는 두 개의 사진 사이의 경과 시간(일반적으로 2초이상)
		message.param3 = 0;						//_param3: capture count (총 캡처 할 이미지 수)
		message.param4 = 0;						//_param4: sequence number (1부터 시작하는 캡처 시퀀스 번호) 무시하려면 : 0
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
