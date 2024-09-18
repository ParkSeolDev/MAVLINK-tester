/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE SIMSTATE PACKING
package tcpserver.src.mavlinklib.ardupilotmega;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* Status of simulation environment, if used.
*/
public class msg_simstate extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_SIMSTATE = 164;
    public static final int MAVLINK_MSG_ID_SIMSTATE_CRC = 154;
    public static final int MAVLINK_MSG_LENGTH = 44;
    private static final long serialVersionUID = MAVLINK_MSG_ID_SIMSTATE;


      
    /**
    * Roll angle.
    */
    public float roll;
      
    /**
    * Pitch angle.
    */
    public float pitch;
      
    /**
    * Yaw angle.
    */
    public float yaw;
      
    /**
    * X acceleration.
    */
    public float xacc;
      
    /**
    * Y acceleration.
    */
    public float yacc;
      
    /**
    * Z acceleration.
    */
    public float zacc;
      
    /**
    * Angular speed around X axis.
    */
    public float xgyro;
      
    /**
    * Angular speed around Y axis.
    */
    public float ygyro;
      
    /**
    * Angular speed around Z axis.
    */
    public float zgyro;
      
    /**
    * Latitude.
    */
    public int lat;
      
    /**
    * Longitude.
    */
    public int lng;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_SIMSTATE;
        packet.crc_extra = MAVLINK_MSG_ID_SIMSTATE_CRC;
              
        packet.payload.putFloat(roll);
              
        packet.payload.putFloat(pitch);
              
        packet.payload.putFloat(yaw);
              
        packet.payload.putFloat(xacc);
              
        packet.payload.putFloat(yacc);
              
        packet.payload.putFloat(zacc);
              
        packet.payload.putFloat(xgyro);
              
        packet.payload.putFloat(ygyro);
              
        packet.payload.putFloat(zgyro);
              
        packet.payload.putInt(lat);
              
        packet.payload.putInt(lng);
        
        return packet;
    }

    /**
    * Decode a simstate message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.roll = payload.getFloat();
              
        this.pitch = payload.getFloat();
              
        this.yaw = payload.getFloat();
              
        this.xacc = payload.getFloat();
              
        this.yacc = payload.getFloat();
              
        this.zacc = payload.getFloat();
              
        this.xgyro = payload.getFloat();
              
        this.ygyro = payload.getFloat();
              
        this.zgyro = payload.getFloat();
              
        this.lat = payload.getInt();
              
        this.lng = payload.getInt();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_simstate(){
        msgid = MAVLINK_MSG_ID_SIMSTATE;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_simstate(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_SIMSTATE;
        unpack(mavLinkPacket.payload);
    }

                          
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_SIMSTATE - sysid:"+sysid+" compid:"+compid+" roll:"+roll+" pitch:"+pitch+" yaw:"+yaw+" xacc:"+xacc+" yacc:"+yacc+" zacc:"+zacc+" xgyro:"+xgyro+" ygyro:"+ygyro+" zgyro:"+zgyro+" lat:"+lat+" lng:"+lng+"";
    }
}
        