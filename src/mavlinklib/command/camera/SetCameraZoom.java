package tcpserver.src.mavlinklib.command.camera;


import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class SetCameraZoom implements FlightCommand {
	
	
	public SetCameraZoom(int index, int compId, int zoomType, int zoomValue) {
		// MAV_CMD_SET_CAMERA_MODE
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_ALL; //(short) compId; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_SET_CAMERA_ZOOM; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = zoomType;                      //_param1: CAMERA_ZOOM_TYPE Zoom Type=1 (step=0, continous=1, range=2, focal length=3)
		message.param2 = zoomValue;					    //_param2:  Zoom Value (zoom in=1, zoom out=-1, stop=0, %)
//		message.param3 = IcpUtil.ICP_NAN;						//_param3:
//		message.param4 = IcpUtil.ICP_NAN;							//_param4:
//		message.param5 = IcpUtil.ICP_NAN;
//		message.param6 = IcpUtil.ICP_NAN;
//		message.param7 = IcpUtil.ICP_NAN;						//_param7:
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
