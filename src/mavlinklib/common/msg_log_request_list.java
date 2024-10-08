/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE LOG_REQUEST_LIST PACKING
package tcpserver.src.mavlinklib.common;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* Request a list of available logs. On some systems calling this may stop on-board logging until LOG_REQUEST_END is called.
*/
public class msg_log_request_list extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_LOG_REQUEST_LIST = 117;
    public static final int MAVLINK_MSG_ID_LOG_REQUEST_LIST_CRC = 128;
    public static final int MAVLINK_MSG_LENGTH = 6;
    private static final long serialVersionUID = MAVLINK_MSG_ID_LOG_REQUEST_LIST;


      
    /**
    * First log id (0 for first available)
    */
    public int start;
      
    /**
    * Last log id (0xffff for last available)
    */
    public int end;
      
    /**
    * System ID
    */
    public short target_system;
      
    /**
    * Component ID
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
        packet.msgid = MAVLINK_MSG_ID_LOG_REQUEST_LIST;
        packet.crc_extra = MAVLINK_MSG_ID_LOG_REQUEST_LIST_CRC;
              
        packet.payload.putUnsignedShort(start);
              
        packet.payload.putUnsignedShort(end);
              
        packet.payload.putUnsignedByte(target_system);
              
        packet.payload.putUnsignedByte(target_component);
        
        return packet;
    }

    /**
    * Decode a log_request_list message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.start = payload.getUnsignedShort();
              
        this.end = payload.getUnsignedShort();
              
        this.target_system = payload.getUnsignedByte();
              
        this.target_component = payload.getUnsignedByte();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_log_request_list(){
        msgid = MAVLINK_MSG_ID_LOG_REQUEST_LIST;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_log_request_list(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_LOG_REQUEST_LIST;
        unpack(mavLinkPacket.payload);
    }

            
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_LOG_REQUEST_LIST - sysid:"+sysid+" compid:"+compid+" start:"+start+" end:"+end+" target_system:"+target_system+" target_component:"+target_component+"";
    }
}
        