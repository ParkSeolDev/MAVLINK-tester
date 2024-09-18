/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SET_MAG_OFFSETS PACKING
package tcpserver.src.mavlinklib.ardupilotmega;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* Set the magnetometer offsets
*/
public class msg_set_mag_offsets extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_SET_MAG_OFFSETS = 151;
    public static final int MAVLINK_MSG_ID_SET_MAG_OFFSETS_CRC = 219;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SET_MAG_OFFSETS;


      
    /**
    * Magnetometer X offset.
    */
    public short mag_ofs_x;
      
    /**
    * Magnetometer Y offset.
    */
    public short mag_ofs_y;
      
    /**
    * Magnetometer Z offset.
    */
    public short mag_ofs_z;
      
    /**
    * System ID.
    */
    public short target_system;
      
    /**
    * Component ID.
    */
    public short target_component;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_SET_MAG_OFFSETS;
        packet.crc_extra = MAVLINK_MSG_ID_SET_MAG_OFFSETS_CRC;
              
        packet.payload.putShort(mag_ofs_x);
              
        packet.payload.putShort(mag_ofs_y);
              
        packet.payload.putShort(mag_ofs_z);
              
        packet.payload.putUnsignedByte(target_system);
              
        packet.payload.putUnsignedByte(target_component);
        
        return packet;
    }

    /**
    * Decode a set_mag_offsets message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.mag_ofs_x = payload.getShort();
              
        this.mag_ofs_y = payload.getShort();
              
        this.mag_ofs_z = payload.getShort();
              
        this.target_system = payload.getUnsignedByte();
              
        this.target_component = payload.getUnsignedByte();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_set_mag_offsets(){
        msgid = MAVLINK_MSG_ID_SET_MAG_OFFSETS;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_set_mag_offsets(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_SET_MAG_OFFSETS;
        unpack(mavLinkPacket.payload);
    }

              
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_SET_MAG_OFFSETS - sysid:"+sysid+" compid:"+compid+" mag_ofs_x:"+mag_ofs_x+" mag_ofs_y:"+mag_ofs_y+" mag_ofs_z:"+mag_ofs_z+" target_system:"+target_system+" target_component:"+target_component+"";
    }
}
        