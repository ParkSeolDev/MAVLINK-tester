/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SET_MODE PACKING
package tcpserver.src.mavlinklib.common;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* Set the system mode, as defined by enum MAV_MODE. There is no target component id as the mode is by definition for the overall aircraft, not only for one component.
*/
public class msg_set_mode extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_SET_MODE = 11;
    public static final int MAVLINK_MSG_ID_SET_MODE_CRC = 89;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SET_MODE;


      
    /**
    * The new autopilot-specific mode. This field can be ignored by an autopilot.
    */
    public long custom_mode;
      
    /**
    * The system setting the mode
    */
    public short target_system;
      
    /**
    * The new base mode.
    */
    public short base_mode;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_SET_MODE;
        packet.crc_extra = MAVLINK_MSG_ID_SET_MODE_CRC;
              
        packet.payload.putUnsignedInt(custom_mode);
              
        packet.payload.putUnsignedByte(target_system);
              
        packet.payload.putUnsignedByte(base_mode);
        
        return packet;
    }

    /**
    * Decode a set_mode message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.custom_mode = payload.getUnsignedInt();
              
        this.target_system = payload.getUnsignedByte();
              
        this.base_mode = payload.getUnsignedByte();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_set_mode(){
        msgid = MAVLINK_MSG_ID_SET_MODE;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_set_mode(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_SET_MODE;
        unpack(mavLinkPacket.payload);
    }

          
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_SET_MODE - sysid:"+sysid+" compid:"+compid+" custom_mode:"+custom_mode+" target_system:"+target_system+" base_mode:"+base_mode+"";
    }
}
        