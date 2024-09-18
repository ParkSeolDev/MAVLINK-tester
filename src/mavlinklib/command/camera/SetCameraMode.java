package tcpserver.src.mavlinklib.command.camera;


import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class SetCameraMode implements FlightCommand {
	
	public SetCameraMode(int index, int cameraMode) {
		// MAV_CMD_SET_CAMERA_MODE
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_SET_CAMERA_MODE; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = 0;                            //_param1: request 1
		message.param2 = cameraMode;					        //_param2:  CAMERA_MODE
		message.param3 = 0.0f/0.0f;							//_param3:
		message.param4 = 0.0f/0.0f;							//_param4: 
		message.param7 = 0.0f/0.0f;							//_param7: 
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	public SetCameraMode(int index, int compId, int cameraMode) {
		// MAV_CMD_SET_CAMERA_MODE
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_CAMERA; //(short) compId; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_SET_CAMERA_MODE; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = 0;                            //_param1: request 1
		message.param2 = cameraMode;					        //_param2:  CAMERA_MODE
		message.param3 = 0.0f/0.0f;						//_param3:
		message.param4 = 0.0f/0.0f;							//_param4: 
		message.param5 = 0.0f/0.0f;	
		message.param6 = 0.0f/0.0f;	
		message.param7 = 0.0f/0.0f;						//_param7: 
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	/**
	 * AMP Custom.
	 * @param index
	 * @param compId
	 * @param cameraRawMode
	 * @param customMainCamera
	 * @param customCameraLayout
	 */
	public SetCameraMode(int index, int compId, int cameraRawMode, int customMainCamera, int customCameraLayout) {
		// MAV_CMD_SET_CAMERA_MODE
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_CAMERA; //(short) compId; //MAV_COMPONENT.MAV_COMP_ID_ALL;
		message.command = MAV_CMD.MAV_CMD_SET_CAMERA_MODE; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = 0;                            //_param1: request 1
		message.param2 = cameraRawMode;					        //_param2:  CAMERA_MODE
//		message.param3 = IcpUtil.ICP_NAN;						//_param3:
//		message.param4 = IcpUtil.ICP_NAN;							//_param4:
		message.param5 = customMainCamera;	   // main cam custom
		message.param6 = customCameraLayout;	// cam layout custom
//		message.param7 = IcpUtil.ICP_NAN;						//_param7:
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
