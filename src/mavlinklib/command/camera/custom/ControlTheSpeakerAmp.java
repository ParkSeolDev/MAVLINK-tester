package tcpserver.src.mavlinklib.command.camera.custom;


import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class ControlTheSpeakerAmp implements FlightCommand {
	
	public ControlTheSpeakerAmp(int index, int device, float control, float trackNumber) {
		msg_command_long message = new msg_command_long();
		message.target_system = (short)index; //1;
		message.target_component = MAV_COMPONENT.MAV_COMP_ID_PERIPHERAL; //MAV_COMPONENT.MAV_COMP_ID_ALL; // MAV_COMP_ID_GIMBAL
		message.command = MAV_CMD.MAV_CMD_USER_1 ; //  규약적 사용
		message.param1 = device;       			//_param1: speacker : 1, led : 2, search lite : 3 ...
		message.param2 = control;				//_param2: control input
		message.param3 = trackNumber;		    //_param3: trackNumber
		message.param4 = 0;		//_param4: 
		message.param5 = 0;  //_param5: 
		message.param6 = 0;  //_param6: 
		message.param7 = 0;  //_param7: 
		message.confirmation = 0;
		packet  = message.pack();
		rawData = packet.encodePacket();
	}
	
	@Override
	public byte[] getRawData() { return this.rawData; }
	
	
	
	private MAVLinkPacket packet;
	private byte[] 		  rawData;
}
