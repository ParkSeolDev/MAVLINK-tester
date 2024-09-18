/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE VIDEO_STREAM_INFORMATION PACKING
package tcpserver.src.mavlinklib.common;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* Information about video stream
*/
public class msg_video_stream_information extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION = 269;
    public static final int MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION_CRC = 58;
    public static final int MAVLINK_MSG_LENGTH = 246;
    private static final long serialVersionUID = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;


      
    /**
    * Frame rate
    */
    public float framerate;
      
    /**
    * Bit rate in bits per second
    */
    public long bitrate;
      
    /**
    * Horizontal resolution
    */
    public int resolution_h;
      
    /**
    * Vertical resolution
    */
    public int resolution_v;
      
    /**
    * Video image rotation clockwise
    */
    public int rotation;
      
    /**
    * Camera ID (1 for first, 2 for second, etc.)
    */
    public short camera_id;
      
    /**
    * Current status of video streaming (0: not running, 1: in progress)
    */
    public short status;
      
    /**
    * Video stream URI
    */
    public byte uri[] = new byte[230];
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;
        packet.crc_extra = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION_CRC;
              
        packet.payload.putFloat(framerate);
              
        packet.payload.putUnsignedInt(bitrate);
              
        packet.payload.putUnsignedShort(resolution_h);
              
        packet.payload.putUnsignedShort(resolution_v);
              
        packet.payload.putUnsignedShort(rotation);
              
        packet.payload.putUnsignedByte(camera_id);
              
        packet.payload.putUnsignedByte(status);
              
        
        for (int i = 0; i < uri.length; i++) {
            packet.payload.putByte(uri[i]);
        }
                    
        
        return packet;
    }

    /**
    * Decode a video_stream_information message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.framerate = payload.getFloat();
              
        this.bitrate = payload.getUnsignedInt();
              
        this.resolution_h = payload.getUnsignedShort();
              
        this.resolution_v = payload.getUnsignedShort();
              
        this.rotation = payload.getUnsignedShort();
              
        this.camera_id = payload.getUnsignedByte();
              
        this.status = payload.getUnsignedByte();
              
         
        for (int i = 0; i < this.uri.length; i++) {
            this.uri[i] = payload.getByte();
        }
                
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_video_stream_information(){
        msgid = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_video_stream_information(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION;
        unpack(mavLinkPacket.payload);
    }

                   
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setUri(String str) {
        int len = Math.min(str.length(), 230);
        for (int i=0; i<len; i++) {
            uri[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<230; i++) {            // padding for the rest of the buffer
            uri[i] = 0;
        }
    }

    /**
    * Gets the message, formated as a string
    */
    public String getUri() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 230; i++) {
            if (uri[i] != 0)
                buf.append((char) uri[i]);
            else
                break;
        }
        return buf.toString();

    }
                         
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_VIDEO_STREAM_INFORMATION - sysid:"+sysid+" compid:"+compid+" framerate:"+framerate+" bitrate:"+bitrate+" resolution_h:"+resolution_h+" resolution_v:"+resolution_v+" rotation:"+rotation+" camera_id:"+camera_id+" status:"+status+" uri:"+uri+"";
    }
}
        