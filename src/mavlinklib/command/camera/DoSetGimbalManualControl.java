package tcpserver.src.mavlinklib.command.camera;

import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.command.camera.enums.GIMBAL_FLAG;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_gimbal_manager_set_manual_control;
import tcpserver.src.mavlinklib.enums.GIMBAL_DEVICE_FLAGS;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;


public class DoSetGimbalManualControl implements FlightCommand {
	
	
	public DoSetGimbalManualControl(int index, float pitch, float yaw, float pitchRate, float yawRate, int controlMode) {
		
		msg_gimbal_manager_set_manual_control message = new msg_gimbal_manager_set_manual_control();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_ALL;   // MAV_COMP_ID_GIMBAL
		message.flags = (GIMBAL_DEVICE_FLAGS.GIMBAL_DEVICE_FLAGS_ROLL_LOCK | GIMBAL_DEVICE_FLAGS.GIMBAL_DEVICE_FLAGS_PITCH_LOCK |
				((controlMode == GIMBAL_FLAG.GIMBAL_LOCK_MODE) ? GIMBAL_DEVICE_FLAGS.GIMBAL_DEVICE_FLAGS_YAW_LOCK : 0));
		message.pitch = pitch;
		message.yaw = yaw;
		
		// TODO Rate
//		message.pitch_rate = IcpUtil.ICP_NAN;
//		message.yaw_rate = IcpUtil.ICP_NAN;
		message.gimbal_device_id = GIMBAL_FLAG.GIMBAL_PRIMARY; 
		
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
