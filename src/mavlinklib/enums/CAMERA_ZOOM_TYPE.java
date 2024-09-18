/* AUTO-GENERATED FILE.  DO NOT MODIFY.
 *
 * This class was automatically generated by the
 * java mavlink generator tool. It should not be modified by hand.
 */

package tcpserver.src.mavlinklib.enums;


/**
 * Zoom types for MAV_CMD_SET_CAMERA_ZOOM
 */
public class CAMERA_ZOOM_TYPE {
	   public static final int ZOOM_TYPE_STEP = 0; /* Zoom one step increment (-1 for wide, 1 for tele) | */
	   public static final int ZOOM_TYPE_CONTINUOUS = 1; /* Continuous zoom up/down until stopped (-1 for wide, 1 for tele, 0 to stop zooming) | */
	   public static final int ZOOM_TYPE_RANGE = 2; /* Zoom value as proportion of full camera range (a percentage value between 0.0 and 100.0) | */
	   public static final int ZOOM_TYPE_FOCAL_LENGTH = 3; /* Zoom value/variable focal length in millimetres. Note that there is no message to get the valid zoom range of the camera, so this can type can only be used for cameras where the zoom range is known (implying that this cannot reliably be used in a GCS for an arbitrary camera) | */
	   public static final int CAMERA_ZOOM_TYPE_ENUM_END = 4; /*  | */
}
            