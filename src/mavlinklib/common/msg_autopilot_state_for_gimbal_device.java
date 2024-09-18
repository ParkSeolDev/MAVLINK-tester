/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GIMBAL_DEVICE_ATTITUDE_STATUS PACKING
package tcpserver.src.mavlinklib.common;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;

/**
 * Low level message containing autopilot state relevant for a gimbal device. This message is to be sent from the autopilot to the gimbal device component. The data of this message are for the gimbal device's estimator corrections, in particular horizon compensation, as well as indicates autopilot control intentions, e.g. feed forward angular control in the z-axis.
 */
public class msg_autopilot_state_for_gimbal_device extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE = 286;
    public static final int MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE_CRC = 210;
    public static final int MAVLINK_MSG_LENGTH = 57;
    private static final long serialVersionUID = MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE;

    
    /**
     * Timestamp (time since system boot).
     */
    public long time_boot_us;
    
    /**
     * Quaternion components of autopilot attitude: w, x, y, z (1 0 0 0 is the null-rotation, Hamilton convention).
     */
    public float q[] = new float[4];
    
    /**
     * Estimated delay of the attitude data. 0 if unknown.
     */
    public long q_estimated_delay_us;
    
    /**
     * X Speed in NED (North, East, Down). NAN if unknown.
     */
    public float vx;
    
    /**
     * Y Speed in NED (North, East, Down). NAN if unknown.
     */
    public float vy;
    
    /**
     * Z Speed in NED (North, East, Down). NAN if unknown.
     */
    public float vz;
    
    /**
     * Estimated delay of the speed data. 0 if unknown.
     */
    public long v_estimated_delay_us;
    
    /**
     * Feed forward Z component of angular velocity (positive: yawing to the right). NaN to be ignored. This is to indicate if the autopilot is actively yawing.
     */
    public float feed_forward_angular_velocity_z;
    
    /**
     * Bitmap indicating which estimator outputs are valid.
     */
    public int estimator_status;
    
    /**
     * System ID
     */
    public short target_system;
    
    /**
     * Component ID
     */
    public short target_component;
    
    /**
     * The landed state. Is set to MAV_LANDED_STATE_UNDEFINED if landed state is unknown.
     */
    public short landed_state;
    
    /**
     * Z component of angular velocity in NED (North, East, Down). NaN if unknown.
     */
    public float angular_velocity_z;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
//        packet.sysid = sysid;
//        packet.compid = compid;
        packet.sysid = 255;
        packet.compid = 190;
        
        packet.msgid = MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE;
        packet.crc_extra = MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE_CRC;
        packet.payload.putUnsignedLong(time_boot_us);
        
        for (int i = 0; i < q.length; i++) {
            packet.payload.putFloat(q[i]);
        }
                    
        packet.payload.putUnsignedInt(q_estimated_delay_us);
        packet.payload.putFloat(vx);
        packet.payload.putFloat(vy);
        packet.payload.putFloat(vz);
        packet.payload.putUnsignedInt(v_estimated_delay_us);
        packet.payload.putFloat(feed_forward_angular_velocity_z);
        packet.payload.putUnsignedShort(estimator_status);
        packet.payload.putUnsignedByte(target_system);
        packet.payload.putUnsignedByte(target_component);
        packet.payload.putUnsignedByte(landed_state);
        
//        if (isMavlink2) {
             packet.payload.putFloat(angular_velocity_z);
//        }
        return packet;
    }

    /**
     * Decode a autopilot_state_for_gimbal_device message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.time_boot_us = payload.getUnsignedLong();
        
        for (int i = 0; i < this.q.length; i++) {
            this.q[i] = payload.getFloat();
        }
                
        this.q_estimated_delay_us = payload.getUnsignedInt();
        this.vx = payload.getFloat();
        this.vy = payload.getFloat();
        this.vz = payload.getFloat();
        this.v_estimated_delay_us = payload.getUnsignedInt();
        this.feed_forward_angular_velocity_z = payload.getFloat();
        this.estimator_status = payload.getUnsignedShort();
        this.target_system = payload.getUnsignedByte();
        this.target_component = payload.getUnsignedByte();
        this.landed_state = payload.getUnsignedByte();
        
//        if (isMavlink2) {
             this.angular_velocity_z = payload.getFloat();
            
//        }
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_autopilot_state_for_gimbal_device() {
        this.msgid = MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_autopilot_state_for_gimbal_device( long time_boot_us, float[] q, long q_estimated_delay_us, float vx, float vy, float vz, long v_estimated_delay_us, float feed_forward_angular_velocity_z, int estimator_status, short target_system, short target_component, short landed_state, float angular_velocity_z) {
        this.msgid = MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE;

        this.time_boot_us = time_boot_us;
        this.q = q;
        this.q_estimated_delay_us = q_estimated_delay_us;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.v_estimated_delay_us = v_estimated_delay_us;
        this.feed_forward_angular_velocity_z = feed_forward_angular_velocity_z;
        this.estimator_status = estimator_status;
        this.target_system = target_system;
        this.target_component = target_component;
        this.landed_state = landed_state;
        this.angular_velocity_z = angular_velocity_z;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_autopilot_state_for_gimbal_device( long time_boot_us, float[] q, long q_estimated_delay_us, float vx, float vy, float vz, long v_estimated_delay_us, float feed_forward_angular_velocity_z, int estimator_status, short target_system, short target_component, short landed_state, float angular_velocity_z, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE;
        this.sysid = sysid;
        this.compid = compid;

        this.time_boot_us = time_boot_us;
        this.q = q;
        this.q_estimated_delay_us = q_estimated_delay_us;
        this.vx = vx;
        this.vy = vy;
        this.vz = vz;
        this.v_estimated_delay_us = v_estimated_delay_us;
        this.feed_forward_angular_velocity_z = feed_forward_angular_velocity_z;
        this.estimator_status = estimator_status;
        this.target_system = target_system;
        this.target_component = target_component;
        this.landed_state = landed_state;
        this.angular_velocity_z = angular_velocity_z;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_autopilot_state_for_gimbal_device(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE;

        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        unpack(mavLinkPacket.payload);
    }

                              
    /**
     * Returns a string with the MSG name and data
     */
    @Override
    public String toString() {
        return "MAVLINK_MSG_ID_AUTOPILOT_STATE_FOR_GIMBAL_DEVICE - sysid:"+sysid+" compid:"+compid+" time_boot_us:"+time_boot_us+" q:"+q+" q_estimated_delay_us:"+q_estimated_delay_us+" vx:"+vx+" vy:"+vy+" vz:"+vz+" v_estimated_delay_us:"+v_estimated_delay_us+" feed_forward_angular_velocity_z:"+feed_forward_angular_velocity_z+" estimator_status:"+estimator_status+" target_system:"+target_system+" target_component:"+target_component+" landed_state:"+landed_state+" angular_velocity_z:"+angular_velocity_z+"";
    }

}
       