/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE MEMINFO PACKING
package tcpserver.src.mavlinklib.ardupilotmega;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* State of APM memory.
*/
public class msg_meminfo extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_MEMINFO = 152;
    public static final int MAVLINK_MSG_ID_MEMINFO_CRC = 208;
    public static final int MAVLINK_MSG_LENGTH = 8;
    private static final long serialVersionUID = MAVLINK_MSG_ID_MEMINFO;


      
    /**
    * Heap top.
    */
    public int brkval;
      
    /**
    * Free memory.
    */
    public int freemem;
      
    /**
    * Free memory (32 bit).
    */
    public long freemem32;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_MEMINFO;
        packet.crc_extra = MAVLINK_MSG_ID_MEMINFO_CRC;
              
        packet.payload.putUnsignedShort(brkval);
              
        packet.payload.putUnsignedShort(freemem);
              
        packet.payload.putUnsignedInt(freemem32);
        
        return packet;
    }

    /**
    * Decode a meminfo message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.brkval = payload.getUnsignedShort();
              
        this.freemem = payload.getUnsignedShort();
              
        this.freemem32 = payload.getUnsignedInt();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_meminfo(){
        msgid = MAVLINK_MSG_ID_MEMINFO;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_meminfo(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_MEMINFO;
        unpack(mavLinkPacket.payload);
    }

          
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_MEMINFO - sysid:"+sysid+" compid:"+compid+" brkval:"+brkval+" freemem:"+freemem+" freemem32:"+freemem32+"";
    }
}
        