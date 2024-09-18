package tcpserver.src.mavlinklib.command.camera;

import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;
import tcpserver.src.mavlinklib.enums.MAV_MOUNT_MODE;

public class DoMountControl implements FlightCommand {
	
//    sendMavCommand(
//            _defaultComponentId,
//            MAV_CMD_DO_MOUNT_CONTROL,
//            false,                               // show errors
//            static_cast<float>(pitch),           // Pitch 0 - 90
//            0,                                   // Roll (not used)
//            static_cast<float>(yaw),             // Yaw -180 - 180
//            0,                                   // Altitude (not used)
//            0,                                   // Latitude (not used)
//            0,                                   // Longitude (not used)
//            MAV_MOUNT_MODE_MAVLINK_TARGETING);   // MAVLink Roll,Pitch,Yaw
	
//	 plugin.Host.AddWPtoList(MAVLink.MAV_CMD.DO_MOUNT_CONTROL, -90, 0, 0, 0, 0, 0, 0, MAVLink.MAV_MOUNT_MODE.MAVLINK_TARGETING);
	
	public DoMountControl(int index,float roll, float pitch, float yaw) {
		//  4.3 이하 안됨
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1;   // MAV_COMP_ID_ALL MAV_COMP_ID_GIMBAL
		message.command = MAV_CMD.MAV_CMD_DO_MOUNT_CONTROL;
		message.param1 = pitch;             //_param1: pitch (degrees or degrees/second depending on pitch input).
		message.param2 = roll;         				  //_param2: roll (degrees or degrees/second depending on roll input).
		message.param3 = yaw;			  //_param3: yaw (degrees or degrees/second depending on yaw input).
		message.param4 = 0;							  //_param4: altitude       param 4~6 no used
		message.param5 = 0;							  //_param5: latitude
		message.param6 = 0;							  //_param6: longtitude
//		message.param7 = MAV_MOUNT_MODE.MAV_MOUNT_MODE_MAVLINK_TARGETING;  //_param7: mount mode
		message.param7 = MAV_MOUNT_MODE.MAV_MOUNT_MODE_NEUTRAL;  //_param7: mount mode
//		message.param7 = MAV_MOUNT_MODE.MAV_MOUNT_MODE_RETRACT;  //_param7: mount mode
		message.confirmation = 0;
		
//		msg_mount_control message = new msg_mount_control();
//		message.target_system = (short)index; //1;
//		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1;
//		boolean islatlng = false;
//        if (!islatlng)
//        {
//        	message.input_a = (int)90;
//        	message.input_b = (int)roll;
//        	message.input_c = (int)90;
//        }
//        else
//        {
////        	message.input_a = (int)(pa * 10000000.0);
////        	message.input_b = (int)(pb * 10000000.0);
////        	message.input_c = (int)(pc * 100.0);
//        }
		
		packet  = message.pack();
		rawData = packet.encodePacket();

		System.out.println(" DoMountControl Alt :: " + message.toString());
		System.out.println(" packet Alt :: " + packet.toString());
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
