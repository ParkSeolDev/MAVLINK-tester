package tcpserver.src.mavlinklib.command.camera.custom.list;



/**
 * 
 *'''
 *+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *    Copyright (c) 2022 DROW PROJECT <http://www.clrobur.com>
 *+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+
 *|                                                               |
 *|    DROW Project is licensed according to CLROBUR STUDIO Inc.  |
 *|                    All rights reserved.                       |
 *|                                                               |
 *+ - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - +
 *|    @author       Seong Won Jo(Cho) , Paul Schwartz            |
 *+ - - - - - - - - - - - - - - - +-------------------------------+
 *|    @email   <swjo0330@gmail.com>  <sw.jo@clrobur.com>         |
 *+---------------------------------------------------------------+
 * -  -
 *'''
 * from CUSTOM_CAMERA_MODE mavlink + custom
 */
public class CUSTOM_CAMERA_MODE {  
	   public static final int CAMERA_MODE_IMAGE = 0; /* Camera is in image/photo capture mode. | */
	   public static final int CAMERA_MODE_VIDEO = 1; /* Camera is in video capture mode. | */
	   public static final int CAMERA_MODE_IMAGE_SURVEY = 2; /* Camera is in image survey capture mode. It allows for camera controller to do specific settings for surveys. | */
	   public static final int CAMERA_MODE_ENUM_END = 3; /*  | */
	   
	   public static final int CAMERA_MODE_VIDEO_LAYOUT_0 = 3; /*  | */
	   public static final int CAMERA_MODE_VIDEO_LAYOUT_1 = 4; /*  | */
	   public static final int CAMERA_MODE_VIDEO_LAYOUT_2 = 5; /*  | */
	   public static final int CAMERA_MODE_VIDEO_LAYOUT_3 = 6; /*  | */
	   
	   public static final int CAMERA_MODE_IMAGE_LAYOUT_0 = 7; /*  | */
	   public static final int CAMERA_MODE_IMAGE_LAYOUT_1 = 8; /*  | */
	   public static final int CAMERA_MODE_IMAGE_LAYOUT_2 = 9; /*  | */
	   public static final int CAMERA_MODE_IMAGE_LAYOUT_3 = 10; /*  | */
	   
	   
	   public static final int CAMERA_MODE_EO_MAIN_VIDEO = 11; /*  | */
	   public static final int CAMERA_MODE_IR_MAIN_VIDEO = 12; /*  | */
	   public static final int CAMERA_MODE_EO_MAIN_IMAGE = 13; /*  | */
	   public static final int CAMERA_MODE_IR_MAIN_IMAGE = 14; /*  | */
}