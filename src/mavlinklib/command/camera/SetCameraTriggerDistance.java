package tcpserver.src.mavlinklib.command.camera;


import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class SetCameraTriggerDistance implements FlightCommand {
	
	public SetCameraTriggerDistance(int index, int distance){
		// MAV_CMD_DO_SET_CAM_TRIGG_DIST 
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_DO_SET_CAM_TRIGG_DIST ; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = distance;     // 72            	//_param1: // trigger distance
		message.param2 = 0;						//_param2: // 카메라 셔텨 통합시간 not shutter integration
		message.param3 = 1;						//_param3:  // trigger immediately
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
