/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE LOG_ENTRY PACKING
package tcpserver.src.mavlinklib.common;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* Reply to LOG_REQUEST_LIST
*/
public class msg_log_entry extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_LOG_ENTRY = 118;
    public static final int MAVLINK_MSG_ID_LOG_ENTRY_CRC = 56;
    public static final int MAVLINK_MSG_LENGTH = 14;
    private static final long serialVersionUID = MAVLINK_MSG_ID_LOG_ENTRY;


      
    /**
    * UTC timestamp of log since 1970, or 0 if not available
    */
    public long time_utc;
      
    /**
    * Size of the log (may be approximate)
    */
    public long size;
      
    /**
    * Log id
    */
    public int id;
      
    /**
    * Total number of logs
    */
    public int num_logs;
      
    /**
    * High log number
    */
    public int last_log_num;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_LOG_ENTRY;
        packet.crc_extra = MAVLINK_MSG_ID_LOG_ENTRY_CRC;
              
        packet.payload.putUnsignedInt(time_utc);
              
        packet.payload.putUnsignedInt(size);
              
        packet.payload.putUnsignedShort(id);
              
        packet.payload.putUnsignedShort(num_logs);
              
        packet.payload.putUnsignedShort(last_log_num);
        
        return packet;
    }

    /**
    * Decode a log_entry message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.time_utc = payload.getUnsignedInt();
              
        this.size = payload.getUnsignedInt();
              
        this.id = payload.getUnsignedShort();
              
        this.num_logs = payload.getUnsignedShort();
              
        this.last_log_num = payload.getUnsignedShort();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_log_entry(){
        msgid = MAVLINK_MSG_ID_LOG_ENTRY;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_log_entry(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_LOG_ENTRY;
        unpack(mavLinkPacket.payload);
    }

              
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_LOG_ENTRY - sysid:"+sysid+" compid:"+compid+" time_utc:"+time_utc+" size:"+size+" id:"+id+" num_logs:"+num_logs+" last_log_num:"+last_log_num+"";
    }
}
        