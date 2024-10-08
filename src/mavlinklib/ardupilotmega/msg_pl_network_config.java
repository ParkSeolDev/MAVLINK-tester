/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

// MESSAGE PL_NETWORK_CONFIG PACKING
package tcpserver.src.mavlinklib.ardupilotmega;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;
        
/**
* 2.4GHz wireless communication LAN network settings.
*/
public class msg_pl_network_config extends MAVLinkMessage{

    public static final int MAVLINK_MSG_ID_PL_NETWORK_CONFIG = 12001;
    public static final int MAVLINK_MSG_ID_PL_NETWORK_CONFIG_CRC = 41;
    public static final int MAVLINK_MSG_LENGTH = 23;
    private static final long serialVersionUID = MAVLINK_MSG_ID_PL_NETWORK_CONFIG;


      
    /**
    * Node Host Name
    */
    public byte host_name[] = new byte[10];
      
    /**
    * Node IP Address
    */
    public short ip_addr[] = new short[4];
      
    /**
    * Node Connection Type
    */
    public short connection_type;
      
    /**
    * Subnet Mask
    */
    public short subnet_mask[] = new short[4];
      
    /**
    * Default Gateway
    */
    public short default_gateway[] = new short[4];
    

    /**
    * Generates the payload for a mavlink message for a message of this type
    * @return
    */
    public MAVLinkPacket pack(){
        MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
        packet.sysid = 255;
        packet.compid = 190;
        packet.msgid = MAVLINK_MSG_ID_PL_NETWORK_CONFIG;
        packet.crc_extra = MAVLINK_MSG_ID_PL_NETWORK_CONFIG_CRC;
              
        
        for (int i = 0; i < host_name.length; i++) {
            packet.payload.putByte(host_name[i]);
        }
                    
              
        
        for (int i = 0; i < ip_addr.length; i++) {
            packet.payload.putUnsignedByte(ip_addr[i]);
        }
                    
              
        packet.payload.putUnsignedByte(connection_type);
              
        
        for (int i = 0; i < subnet_mask.length; i++) {
            packet.payload.putUnsignedByte(subnet_mask[i]);
        }
                    
              
        
        for (int i = 0; i < default_gateway.length; i++) {
            packet.payload.putUnsignedByte(default_gateway[i]);
        }
                    
        
        return packet;
    }

    /**
    * Decode a pl_network_config message into this class fields
    *
    * @param payload The message to decode
    */
    public void unpack(MAVLinkPayload payload) {
        payload.resetIndex();
              
         
        for (int i = 0; i < this.host_name.length; i++) {
            this.host_name[i] = payload.getByte();
        }
                
              
         
        for (int i = 0; i < this.ip_addr.length; i++) {
            this.ip_addr[i] = payload.getUnsignedByte();
        }
                
              
        this.connection_type = payload.getUnsignedByte();
              
         
        for (int i = 0; i < this.subnet_mask.length; i++) {
            this.subnet_mask[i] = payload.getUnsignedByte();
        }
                
              
         
        for (int i = 0; i < this.default_gateway.length; i++) {
            this.default_gateway[i] = payload.getUnsignedByte();
        }
                
        
    }

    /**
    * Constructor for a new message, just initializes the msgid
    */
    public msg_pl_network_config(){
        msgid = MAVLINK_MSG_ID_PL_NETWORK_CONFIG;
    }

    /**
    * Constructor for a new message, initializes the message with the payload
    * from a mavlink packet
    *
    */
    public msg_pl_network_config(MAVLinkPacket mavLinkPacket){
        this.sysid = mavLinkPacket.sysid;
        this.compid = mavLinkPacket.compid;
        this.msgid = MAVLINK_MSG_ID_PL_NETWORK_CONFIG;
        unpack(mavLinkPacket.payload);
    }

     
    /**
    * Sets the buffer of this message with a string, adds the necessary padding
    */
    public void setHost_Name(String str) {
        int len = Math.min(str.length(), 10);
        for (int i=0; i<len; i++) {
            host_name[i] = (byte) str.charAt(i);
        }

        for (int i=len; i<10; i++) {            // padding for the rest of the buffer
            host_name[i] = 0;
        }
    }

    /**
    * Gets the message, formated as a string
    */
    public String getHost_Name() {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < 10; i++) {
            if (host_name[i] != 0)
                buf.append((char) host_name[i]);
            else
                break;
        }
        return buf.toString();

    }
                                 
    /**
    * Returns a string with the MSG name and data
    */
    public String toString(){
        return "MAVLINK_MSG_ID_PL_NETWORK_CONFIG - sysid:"+sysid+" compid:"+compid+" host_name:"+host_name+" ip_addr:"+ip_addr+" connection_type:"+connection_type+" subnet_mask:"+subnet_mask+" default_gateway:"+default_gateway+"";
    }
}
        