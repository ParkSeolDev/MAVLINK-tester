/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE GOPRO_HEARTBEAT PACKING
package tcpserver.src.mavlinklib.ardupilotmega;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* Heartbeat from a HeroBus attached GoPro.
*/
public class msg_gopro_heartbeat extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_GOPRO_HEARTBEAT = 215;
    public static final int MAVLINK_MSG_ID_GOPRO_HEARTBEAT_CRC = 101;
    public static final int MAVLINK_MSG_LENGTH = 3;
    private static final long serialVersionUID = MAVLINK_MSG_ID_GOPRO_HEARTBEAT;


      
    /**
    * Status.
    */
    public short status;
      
    /**
    * Current capture mode.
    */
    public short capture_mode;
      
    /**
    * Additional status bits.
    */
    public short flags;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_GOPRO_HEARTBEAT;
        packet.crc_extra = MAVLINK_MSG_ID_GOPRO_HEARTBEAT_CRC;
              
        packet.payload.putUnsignedByte(status);
              
        packet.payload.putUnsignedByte(capture_mode);
              
        packet.payload.putUnsignedByte(flags);
        
        return packet;
    }

    /**
    * Decode a gopro_heartbeat message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.status = payload.getUnsignedByte();
              
        this.capture_mode = payload.getUnsignedByte();
              
        this.flags = payload.getUnsignedByte();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_gopro_heartbeat(){
        msgid = MAVLINK_MSG_ID_GOPRO_HEARTBEAT;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_gopro_heartbeat(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_GOPRO_HEARTBEAT;
        unpack(mavLinkPacket.payload);
    }

          
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_GOPRO_HEARTBEAT - sysid:"+sysid+" compid:"+compid+" status:"+status+" capture_mode:"+capture_mode+" flags:"+flags+"";
    }
}
        