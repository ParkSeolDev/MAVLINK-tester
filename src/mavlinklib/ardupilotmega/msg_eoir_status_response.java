/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE EOIR_STATUS_RESPONSE PACKING
package tcpserver.src.mavlinklib.ardupilotmega;

import jdk.jfr.Description;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;

/**
 * Response of REQUEST_EOIR_STATUS(TASK_EQUIPMENT_COMMAND)
 */
public class msg_eoir_status_response extends MAVLinkMessage {

    public static final int MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE = 12927;
    public static final int MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE_CRC = 77;
    public static final int MAVLINK_MSG_LENGTH = 13;
    private static final long serialVersionUID = MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE;

    
    /**
     * Camera Roll angle.
     */
    @Description("Camera Roll angle.")
//    @Units("deg")
    public float roll;
    
    /**
     * Camera Pitch angle.
     */
    @Description("Camera Pitch angle.")
//    @Units("deg")
    public float pitch;
    
    /**
     * Camera Yaw.
     */
    @Description("Camera Yaw.")
//    @Units("deg")
    public float yaw;
    
    /**
     * Zoom level
     */
    @Description("Zoom level")
//    @Units("")
    public short zoom_level;
    

    /**
     * Generates the payload for a mavlink message for a message of this type
     * @return
     */
    @Override
    public MAVLinkPacket pack() {
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = sysid;
        packet.compid = compid;
        packet.msgid = MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE;
        packet.crc_extra = MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE_CRC;
        
        packet.payload.putFloat(roll);
        packet.payload.putFloat(pitch);
        packet.payload.putFloat(yaw);
        packet.payload.putUnsignedByte(zoom_level);
        
        return packet;
    }

    /**
     * Decode a eoir_status_response message into this class fields
     *
     * @param payload The message to decode
     */
    @Override
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();

        this.roll = payload.getFloat();
        this.pitch = payload.getFloat();
        this.yaw = payload.getFloat();
        this.zoom_level = payload.getUnsignedByte();
        
    }

    /**
     * Constructor for a new message, just initializes the msgid
     */
    public msg_eoir_status_response() {
        this.msgid = MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE;
    }

    /**
     * Constructor for a new message, initializes msgid and all payload variables
     */
    public msg_eoir_status_response( float roll, float pitch, float yaw, short zoom_level) {
        this.msgid = MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE;

        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.zoom_level = zoom_level;
        
    }

    /**
     * Constructor for a new message, initializes everything
     */
    public msg_eoir_status_response( float roll, float pitch, float yaw, short zoom_level, int sysid, int compid, boolean isMavlink2) {
        this.msgid = MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE;
        this.sysid = sysid;
        this.compid = compid;

        this.roll = roll;
        this.pitch = pitch;
        this.yaw = yaw;
        this.zoom_level = zoom_level;
        
    }

    /**
     * Constructor for a new message, initializes the message with the payload
     * from a mavlink packet
     *
     */
    public msg_eoir_status_response(MAVLinkPacket mavLinkPacket) {
        this.msgid = MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE;

        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        unpack(mavLinkPacket.payload);
    }

            
    /**
     * Returns a string with the MSG name and data
     */
    @Override
    public String toString() {
        return "MAVLINK_MSG_ID_EOIR_STATUS_RESPONSE - sysid:"+sysid+" compid:"+compid+" roll:"+roll+" pitch:"+pitch+" yaw:"+yaw+" zoom_level:"+zoom_level+"";
    }

}
        