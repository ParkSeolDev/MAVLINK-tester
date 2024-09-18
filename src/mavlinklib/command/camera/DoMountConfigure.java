package tcpserver.src.mavlinklib.command.camera;

import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;
import tcpserver.src.mavlinklib.enums.MAV_MOUNT_MODE;

public class DoMountConfigure implements FlightCommand {
	
	public DoMountConfigure (int index, float roll, float pitch, float yaw ) {
		// mavlink_mount_configure_t
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL; // MAV_COMP_ID_GIMBAL
		message.command = MAV_CMD.MAV_CMD_DO_MOUNT_CONFIGURE ; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
		message.param1 = MAV_MOUNT_MODE.MAV_MOUNT_MODE_MAVLINK_TARGETING;       //_param1: Mount operation mode
		message.param2 = 1;					    //_param2: Stabilize roll(1=yes, 0=no)
		message.param3 = 1;					    //_param3: Stabilize pitch(1=yes, 0=no)
		message.param4 = 1;					    //_param4: Stabilize yaw(1=yes, 0=no)
		message.param5 = 0.0f/0.0f;  //_param5: roll input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
		message.param6 = 0.0f/0.0f;  //_param6: pitch input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
		message.param7 = 0.0f/0.0f;  //_param7: yaw input (0 = angle body frame, 1 = angular rate, 2 = angle absolute frame)
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();

		System.out.println(" DoMountConfigure Alt :: " + message.toString());
		System.out.println(" packet Alt :: " + packet.toString());
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
