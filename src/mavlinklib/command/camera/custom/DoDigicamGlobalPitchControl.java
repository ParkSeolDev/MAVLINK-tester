package tcpserver.src.mavlinklib.command.camera.custom;

import tcpserver.src.mavlinklib.MAVLinkPacket;
import tcpserver.src.mavlinklib.command.FlightCommand;
import tcpserver.src.mavlinklib.command.camera.custom.list.CUSTOM_CAMERA_TYPE;
import tcpserver.src.mavlinklib.common.msg_command_long;
import tcpserver.src.mavlinklib.enums.MAV_CMD;
import tcpserver.src.mavlinklib.enums.MAV_COMPONENT;

public class DoDigicamGlobalPitchControl implements FlightCommand {
    public DoDigicamGlobalPitchControl(int index, int pitch) {

        // mavlink_digicam_control_t
        // MAV_CMD_DO_DIGICAM_CONTROL
        msg_command_long message = new msg_command_long();

        message.target_system = (short)index; //1;
        message.target_component = MAV_COMPONENT.MAV_COMP_ID_AUTOPILOT1; //MAV_COMPONENT.MAV_COMP_ID_ALL;
        message.command = MAV_CMD.MAV_CMD_DO_DIGICAM_CONTROL; //MAV_CMD.MAV_CMD_REQUEST_CAMERA_INFORMATION ;
        message.param1 = 0;
        message.param2  = CUSTOM_CAMERA_TYPE.PRENUW_SMALLCAM_GLOBAL_POSITON_MODE.rawStateData;
        message.param3 = pitch ;							//_param3: Zoom Relative(줌 상대값)
        message.param4 = 0;							//_param4: 초점 잠금, 잠그 해제 또는 다시 잠금
        message.param5 = 0;							//_param5: Shoot Command
        message.param6 = 0;							//_param6: Command Identity
        message.param7 = 0;							//_param7: Shot ID(테스트 Shoot 식별자, 1로 설정하면 이미지만 캡처되고 내부 프레임 수는 포함x)
        // MP 	: DO_DIGICAM_CONTROL, 0, 0, 0, 0, 1, 0, 0)
        // QGCS : DO_DIGICAM_CONTROL, 0, 0, 0, 0, 1, 0, 1)
        message.confirmation = 0;
        packet  = message.pack();
        rawData = packet.encodePacket();

        System.out.println(" DoDigicamPitchControl Alt :: " + message.toString());
        System.out.println(" packet Alt :: " + packet.toString());
    }


    @Override
    public byte[] getRawData() { return this.rawData; }

    private MAVLinkPacket packet;
    private byte[] 		  rawData;
}
