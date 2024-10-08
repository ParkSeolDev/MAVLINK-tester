/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE TRAJECTORY_REPRESENTATION_BEZIER PACKING
package tcpserver.src.mavlinklib.common;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* Describe a trajectory using an array of up-to 5 bezier points in the local frame.
*/
public class msg_trajectory_representation_bezier extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_BEZIER = 333;
    public static final int MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_BEZIER_CRC = 231;
    public static final int MAVLINK_MSG_LENGTH = 109;
    private static final long serialVersionUID = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_BEZIER;


      
    /**
    * Timestamp (UNIX Epoch time or time since system boot). The receiving end can infer timestamp format (since 1.1.1970 or since system boot) by checking for the magnitude the number.
    */
    public long time_usec;
      
    /**
    * X-coordinate of starting bezier point, set to NaN if not being used
    */
    public float pos_x[] = new float[5];
      
    /**
    * Y-coordinate of starting bezier point, set to NaN if not being used
    */
    public float pos_y[] = new float[5];
      
    /**
    * Z-coordinate of starting bezier point, set to NaN if not being used
    */
    public float pos_z[] = new float[5];
      
    /**
    * Bezier time horizon, set to NaN if velocity/acceleration should not be incorporated
    */
    public float delta[] = new float[5];
      
    /**
    * Yaw, set to NaN for unchanged
    */
    public float pos_yaw[] = new float[5];
      
    /**
    * Number of valid points (up-to 5 waypoints are possible)
    */
    public short valid_points;
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_BEZIER;
        packet.crc_extra = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_BEZIER_CRC;
              
        packet.payload.putUnsignedLong(time_usec);
              
        
        for (int i = 0; i < pos_x.length; i++) {
            packet.payload.putFloat(pos_x[i]);
        }
                    
              
        
        for (int i = 0; i < pos_y.length; i++) {
            packet.payload.putFloat(pos_y[i]);
        }
                    
              
        
        for (int i = 0; i < pos_z.length; i++) {
            packet.payload.putFloat(pos_z[i]);
        }
                    
              
        
        for (int i = 0; i < delta.length; i++) {
            packet.payload.putFloat(delta[i]);
        }
                    
              
        
        for (int i = 0; i < pos_yaw.length; i++) {
            packet.payload.putFloat(pos_yaw[i]);
        }
                    
              
        packet.payload.putUnsignedByte(valid_points);
        
        return packet;
    }

    /**
    * Decode a trajectory_representation_bezier message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
        this.time_usec = payload.getUnsignedLong();
              
         
        for (int i = 0; i < this.pos_x.length; i++) {
            this.pos_x[i] = payload.getFloat();
        }
                
              
         
        for (int i = 0; i < this.pos_y.length; i++) {
            this.pos_y[i] = payload.getFloat();
        }
                
              
         
        for (int i = 0; i < this.pos_z.length; i++) {
            this.pos_z[i] = payload.getFloat();
        }
                
              
         
        for (int i = 0; i < this.delta.length; i++) {
            this.delta[i] = payload.getFloat();
        }
                
              
         
        for (int i = 0; i < this.pos_yaw.length; i++) {
            this.pos_yaw[i] = payload.getFloat();
        }
                
              
        this.valid_points = payload.getUnsignedByte();
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_trajectory_representation_bezier(){
        msgid = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_BEZIER;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_trajectory_representation_bezier(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_BEZIER;
        unpack(mavLinkPacket.payload);
    }

                  
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_TRAJECTORY_REPRESENTATION_BEZIER - sysid:"+sysid+" compid:"+compid+" time_usec:"+time_usec+" pos_x:"+pos_x+" pos_y:"+pos_y+" pos_z:"+pos_z+" delta:"+delta+" pos_yaw:"+pos_yaw+" valid_points:"+valid_points+"";
    }
}
        