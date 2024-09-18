package tcpserver.src.mavlinklib.command.camera;

import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.command.camera.enums.GIMBAL_FLAG;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_gimbal_device_set_attitude;
import tcpserver.src.mavlinklib.enums.GIMBAL_DEVICE_FLAGS;
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
public class DoSetGimbalDeviceAttitude implements FlightCommand {
	
	// GIMBAL_FLAG.GIMBAL_FOLLOW_MODE
	/**
	 * controlMode is GIMBAL_FLAG ,,, GIMBAL_FOLLOW_MODE GIMBAL_LOCK_MODE
	 * inputMode is GIMBAL_FLAG INPUT_ANGLE  INPUT_SPEED
	 * @param index
	 * @param roll
	 * @param pitch
	 * @param yaw
	 * @param controlMode
	 * @param inputMode
	 */
	public DoSetGimbalDeviceAttitude(int index,float roll, float pitch, float yaw, int controlMode, int inputMode) {
		
		msg_gimbal_device_set_attitude message = new msg_gimbal_device_set_attitude();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_ALL;   // MAV_COMP_ID_GIMBAL
		message.flags = (GIMBAL_DEVICE_FLAGS.GIMBAL_DEVICE_FLAGS_ROLL_LOCK | GIMBAL_DEVICE_FLAGS.GIMBAL_DEVICE_FLAGS_PITCH_LOCK |
				((controlMode == GIMBAL_FLAG.GIMBAL_LOCK_MODE) ? GIMBAL_DEVICE_FLAGS.GIMBAL_DEVICE_FLAGS_YAW_LOCK : 0));
		
        if (inputMode == GIMBAL_FLAG.INPUT_ANGLE) {
            /* Convert target to quaternion */
//          	message.q = this.mavlink_euler_to_quaternion(
//              		(float)IcpUtil.deg2Rad(roll)
//              		, (float)IcpUtil.deg2Rad(pitch)
//              		, (float)IcpUtil.deg2Rad(yaw)
//              		);
//            message.angular_velocity_x = IcpUtil.ICP_NAN;
//            message.angular_velocity_y = IcpUtil.ICP_NAN;
//            message.angular_velocity_z = IcpUtil.ICP_NAN;
//            message.angular_velocity_x = IcpUtil.ICP_NAN;
//            message.angular_velocity_y = IcpUtil.ICP_NAN;
//            message.angular_velocity_z = IcpUtil.ICP_NAN;
        } else {
//        	message.angular_velocity_x = (float)IcpUtil.deg2Rad(roll); // roll * MathHelper.deg2radf;
//        	message.angular_velocity_y = (float)IcpUtil.deg2Rad(pitch); // pitch * MathHelper.deg2radf;
//        	message.angular_velocity_z = (float)IcpUtil.deg2Rad(yaw); // yaw * MathHelper.deg2radf;
//        	message.q = new float[4];
//        	message.q[0] = IcpUtil.ICP_NAN;
//        	message.q[1] = IcpUtil.ICP_NAN;
//        	message.q[2] = IcpUtil.ICP_NAN;
//        	message.q[3] = IcpUtil.ICP_NAN;
        }
        
		packet  = message.pack();
		rawData = packet.encodePacket();
	}

//    public void SetOrientation(MAVLinkInterface mint, byte sysid, byte compid, float pitch, float roll, float yaw,
//        input_mode_t mode)
//    {
//        MAVLink.mavlink_gimbal_device_set_attitude_t attitude;
//        attitude.target_system = sysid;
//        attitude.target_component = compid;
//        attitude.flags = (ushort)(
//            MAVLink.GIMBAL_DEVICE_FLAGS.ROLL_LOCK | MAVLink.GIMBAL_DEVICE_FLAGS.PITCH_LOCK |
//                                  ((_control_mode == control_mode_t.GIMBAL_LOCK_MODE) ? MAVLink.GIMBAL_DEVICE_FLAGS.YAW_LOCK : (MAVLink.GIMBAL_DEVICE_FLAGS)0)
//                                      );
//
//        if (mode == input_mode_t.INPUT_ANGLE)
//        {
//            attitude.q = new float[4];
//            /* Convert target to quaternion */
//            mavlink_euler_to_quaternion((roll) * MathHelper.deg2radf, (pitch) * MathHelper.deg2radf,
//                (yaw) * MathHelper.deg2radf, attitude.q);
//            attitude.angular_velocity_x = float.NaN;
//            attitude.angular_velocity_y = float.NaN;
//            attitude.angular_velocity_z = float.NaN;
//
//        }
//        else
//        {
//            attitude.angular_velocity_x = roll * MathHelper.deg2radf;
//            attitude.angular_velocity_y = pitch * MathHelper.deg2radf;
//            attitude.angular_velocity_z = yaw * MathHelper.deg2radf;
//            attitude.q = new float[4];
//            attitude.q[0] = float.NaN;
//            attitude.q[1] = float.NaN;
//            attitude.q[2] = float.NaN;
//            attitude.q[3] = float.NaN;
//        }
//    }
    public float[] mavlink_euler_to_quaternion(float roll, float pitch, float yaw) {
    	float[] quaternion = new float[4];
        float cosPhi_2 = (float) Math.cos(roll / 2); // .cosf(roll / 2);
        float sinPhi_2 = (float) Math.sin(roll / 2); // .sinf(roll / 2);
        float cosTheta_2 = (float) Math.cos(pitch /2); //  Utils.cosf(pitch / 2);
        float sinTheta_2 = (float) Math.sin(pitch / 2);
        float cosPsi_2 = (float) Math.cos(yaw / 2);
        float sinPsi_2 = (float) Math.sin(yaw / 2);
        quaternion[0] = (cosPhi_2 * cosTheta_2 * cosPsi_2 +
                         sinPhi_2 * sinTheta_2 * sinPsi_2);
        quaternion[1] = (sinPhi_2 * cosTheta_2 * cosPsi_2 -
                         cosPhi_2 * sinTheta_2 * sinPsi_2);
        quaternion[2] = (cosPhi_2 * sinTheta_2 * cosPsi_2 +
                         sinPhi_2 * cosTheta_2 * sinPsi_2);
        quaternion[3] = (cosPhi_2 * cosTheta_2 * sinPsi_2 -
                         sinPhi_2 * sinTheta_2 * cosPsi_2);
        
        return quaternion;
    }
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
