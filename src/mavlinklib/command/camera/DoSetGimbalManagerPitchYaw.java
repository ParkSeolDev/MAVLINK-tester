package tcpserver.src.mavlinklib.command.camera;

import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.command.camera.enums.GIMBAL_FLAG;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.common.msg_gimbal_manager_set_pitchyaw;
import tcpserver.src.mavlinklib.enums.GIMBAL_DEVICE_FLAGS;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;


/**
 *'''
 *+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *    Copyright (c) 2022 DROW PROJECT <http://www.clrobur.com>
 *+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *|                                                               |
 *|    DROW Project is licensed according to CLROBUR STUDIO Inc.  |
 *|                    All rights reserved.                       |
 *|                                                               |
 *+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +
 *|    @author       Seong Won Jo(Cho) , Paul Schwartz            |
 *+ - - - - - - - - - - - - - - - +-------------------------------+
 *|    @email   <swjo0330@gmail.com>  <sw.jo@clrobur.com>         |
 *+---------------------------------------------------------------+
 * -  -
 *'''
 *
 */
public class DoSetGimbalManagerPitchYaw implements FlightCommand {
	/**
	 * controlMode is GIMBAL_FLAG ,,, GIMBAL_FOLLOW_MODE GIMBAL_LOCK_MODE
	 * @param index
	 * @param pitch
	 * @param yaw
	 * @param controlMode
	 */
	public DoSetGimbalManagerPitchYaw(int index, float pitch, float yaw, float pitchRate, float yawRate, int controlMode) {
		
		msg_gimbal_manager_set_pitchyaw message = new msg_gimbal_manager_set_pitchyaw();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_ALL;   // MAV_COMP_ID_GIMBAL
		message.flags = (GIMBAL_DEVICE_FLAGS.GIMBAL_DEVICE_FLAGS_ROLL_LOCK | GIMBAL_DEVICE_FLAGS.GIMBAL_DEVICE_FLAGS_PITCH_LOCK |
				((controlMode == GIMBAL_FLAG.GIMBAL_LOCK_MODE) ? GIMBAL_DEVICE_FLAGS.GIMBAL_DEVICE_FLAGS_YAW_LOCK : 0));
		
		message.pitch = pitch;
		message.yaw = yaw;
		
		// TODO Rate
		message.pitch_rate = pitchRate;
		message.yaw_rate = yawRate; // IcpUtil.ICP_NAN;
		message.gimbal_device_id = GIMBAL_FLAG.GIMBAL_PRIMARY; 
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
//	target_system	uint8_t	System ID of flight controller or just 0
//	target_component	uint8_t	Component ID of flight controller or just 0
//	command	uint16_t	MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW=1000
//	confirmation	uint8_t	0
//	param1	float	Pitch angle in deg (positive is up) or NaN if unused
//	param2	float	Yaw angle in deg (positive is clockwise) or NaN if unused
//	param3	float	Pitch rate in deg/s (positive is up) or NaN if unused
//	param4	float	Yaw rate in deg/s (positive is clockwise) or NaN if unused
//	param5	float	Flags (0=Yaw is body-frame/follow, 16=Yaw is earth-frame/lock)
//	param6	float	not used
//	param7	float	Gimbal device ID (0 is primary gimbal, 1 is 1st gimbal, 2 is 2nd gimbal)
	
	public DoSetGimbalManagerPitchYaw(int index, float pitch, float yaw, float pitchRate, float yawRate
			, int gimbalManagerFlags, boolean isCmd
			) {
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_ALL;   // MAV_COMP_ID_GIMBAL
		message.command = MAV_CMD.MAV_CMD_DO_GIMBAL_MANAGER_PITCHYAW;  // GIMBAL_MANAGER_PITCHYAW
		message.param1 = pitch;         
		message.param2 = yaw;         		
		message.param3 = pitchRate;			
		message.param4 = yawRate;						
		message.param5 = gimbalManagerFlags; // GIMBAL_MANAGER_FLAGS.GIMBAL_MANAGER_FLAGS_BODY_FOLLOW;						
		message.param6 = 0; // not use			
		message.param7 = GIMBAL_FLAG.GIMBAL_PRIMARY;  
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
