package tcpserver.src.mavlinklib.ardupilotmega;

import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.Messages.MAVLinkMessage;
import tcpserver.src.mavlinklib.Messages.MAVLinkPayload;

/* AUTO-GENERATED FILE.  DO NOT MODIFY.
*
* This class was automatically generated by the
* java mavlink generator tool. It should not be modified by hand.
*/

//MESSAGE POWERPACK_USER_SETTING PACKING
       
/**
* PowerPackUserSetting
*/
public class msg_powerpack_user_setting extends MAVLinkMessage{

   public static final int MAVLINK_MSG_ID_POWERPACK_USER_SETTING = 427;
   public static final int MAVLINK_MSG_LENGTH = 5;
   public static final int MAVLINK_MSG_ID_POWERPACK_USER_SETTING_CRC = 66;
   private static final long serialVersionUID = MAVLINK_MSG_ID_POWERPACK_USER_SETTING;


     
   /**
   * powerpack_landing
   */
   public int landSetting;
     
   /**
   * powerpack_rtl
   */
   public int rthSetting;
     
   /**
   * zero_prevention
   */
   public short zero_prevention;
   

   /**
   * Generates the payload for a mavlink message for a message of this type
   * @return
   */
   public MAVLinkPacket pack(){
       MAVLinkPacket packet = new MAVLinkPacket(MAVLINK_MSG_LENGTH);
       packet.sysid = 255;
       packet.compid = 190;
       packet.msgid = MAVLINK_MSG_ID_POWERPACK_USER_SETTING;
       packet.crc_extra = MAVLINK_MSG_ID_POWERPACK_USER_SETTING_CRC;
             
       packet.payload.putUnsignedShort(landSetting);
             
       packet.payload.putUnsignedShort(rthSetting);
             
       packet.payload.putUnsignedByte(zero_prevention);
       
       return packet;
   }

   /**
   * Decode a powerpack_user_setting message into this class fields
   *
   * @param payload The message to decode
   */
   public void unpack(MAVLinkPayload payload) {
       payload.resetIndex();
             
       this.landSetting = payload.getUnsignedShort();
             
       this.rthSetting = payload.getUnsignedShort();
             
       this.zero_prevention = payload.getUnsignedByte();
       
   }

   /**
   * Constructor for a new message, just initializes the msgid
   */
   public msg_powerpack_user_setting(){
       msgid = MAVLINK_MSG_ID_POWERPACK_USER_SETTING;
   }

   /**
   * Constructor for a new message, initializes the message with the payload
   * from a mavlink packet
   *
   */
   public msg_powerpack_user_setting(MAVLinkPacket mavLinkPacket){
       this.sysid = mavLinkPacket.sysid;
       this.compid = mavLinkPacket.compid;
       this.msgid = MAVLINK_MSG_ID_POWERPACK_USER_SETTING;
       unpack(mavLinkPacket.payload);        
   }

         
   /**
   * Returns a string with the MSG name and data
   */
   public String toString(){
       return "MAVLINK_MSG_ID_POWERPACK_USER_SETTING - sysid:"+sysid+" compid:"+compid+" landSetting:"+landSetting+" rthSetting:"+rthSetting+" zero_prevention:"+zero_prevention+"";
   }
}
       