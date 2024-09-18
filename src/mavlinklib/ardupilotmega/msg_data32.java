/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE DATA32 PACKING
package tcpserver.src.mavlinklib.ardupilotmega;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* Data packet, size 32.
*/
public class msg_data32 extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_DATA32 = 170;
    public static final int MAVLINK_MSG_ID_DATA32_CRC = 73;
    public static final int MAVLINK_MSG_LENGTH = 34;
    private static final long serialVersionUID = MAVLINK_MSG_ID_DATA32;


      
    /**
    * Data type.
    */
    public short type;
      
    /**
    * Data length.
    */
    public short len;
      
    /**
    * Raw data.
    */
    public short data[] = new short[32];
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_DATA32;
        packet.crc_extra = MAVLINK_MSG_ID_DATA32_CRC;
              
        packet.payload.putUnsignedByte(type);
              
        packet.payload.putUnsignedByte(len);
              
        
        for (int i = 0; i < data.length; i++) {
            packet.payload.putUnsignedByte(data[i]);
        }
                    
        
        return packet;
    }

    /**
    * Decode a data32 message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.type = payload.getUnsignedByte();
              
        this.len = payload.getUnsignedByte();
              
         
        for (int i = 0; i < this.data.length; i++) {
            this.data[i] = payload.getUnsignedByte();
        }
                
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_data32(){
        msgid = MAVLINK_MSG_ID_DATA32;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_data32(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_DATA32;
        unpack(mavLinkPacket.payload);
    }

          
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_DATA32 - sysid:"+sysid+" compid:"+compid+" type:"+type+" len:"+len+" data:"+data+"";
    }
}
        