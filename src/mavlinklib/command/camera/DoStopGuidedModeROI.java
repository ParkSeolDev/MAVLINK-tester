package tcpserver.src.mavlinklib.command.camera;

public class DoStopGuidedModeROI {
//    if (!roiModeSupported()) {
//        qgcApp()->showAppMessage(QStringLiteral("ROI mode not supported by Vehicle."));
//        return;
//    }
//    if (capabilityBits() & MAV_PROTOCOL_CAPABILITY_COMMAND_INT) {
//        sendMavCommandInt(
//            defaultComponentId(),
//            MAV_CMD_DO_SET_ROI_NONE,
//            MAV_FRAME_GLOBAL,
//            true,                           // show error if fails
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<double>(qQNaN()),   // Empty
//            static_cast<double>(qQNaN()),   // Empty
//            static_cast<float>(qQNaN()));   // Empty
//    } else {
//        sendMavCommand(
//            defaultComponentId(),
//            MAV_CMD_DO_SET_ROI_NONE,
//            true,                           // show error if fails
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<float>(qQNaN()),    // Empty
//            static_cast<float>(qQNaN()));   // Empty
//    }
	
//	void Vehicle::sendMavCommandInt(int component, MAV_CMD command, MAV_FRAME frame, bool showError, float param1, float param2, float param3, float param4, double param5, double param6, float param7)
//	{
//	    MavCommandQueueEntry_t entry;
//
//	    entry.commandInt = true;
//	    entry.component = component;
//	    entry.command = command;
//	    entry.frame = frame;
//	    entry.showError = showError;
//	    entry.rgParam[0] = static_cast<double>(param1);
//	    entry.rgParam[1] = static_cast<double>(param2);
//	    entry.rgParam[2] = static_cast<double>(param3);
//	    entry.rgParam[3] = static_cast<double>(param4);
//	    entry.rgParam[4] = param5;
//	    entry.rgParam[5] = param6;
//	    entry.rgParam[6] = static_cast<double>(param7);
//
//	    _mavCommandQueue.append(entry);
//
//	    if (_mavCommandQueue.count() == 1) {
//	        _mavCommandRetryCount = 0;
//	        _sendMavCommandAgain();
//	    }
//	}
	
}
