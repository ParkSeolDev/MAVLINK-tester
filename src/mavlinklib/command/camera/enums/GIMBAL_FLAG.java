package tcpserver.src.mavlinklib.command.camera.enums;

/**
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
 *
 */
public class GIMBAL_FLAG {

	  /**
	   * @brief Control gimbal Mode
	   * @details Mode LOCK/FOLLOW/RESET MODE
	   */
	   public static final int GIMBAL_OFF = 0;
	   public static final int GIMBAL_LOCK_MODE = 1; 
	   public static final int GIMBAL_FOLLOW_MODE = 2;  // yaw body follow
	   public static final int GIMBAL_RESET_MODE = 4;
     /**
      * @brief Input mode control gimbal
      *	 
      */
	   public static final int INPUT_ANGLE = 1;
	   public static final int INPUT_SPEED = 2;
	   
	   
	   // https://ardupilot.org/dev/docs/mavlink-gimbal-mount.html
	   public static final int GIMBAL_PRIMARY = 0; 
	   public static final int GIMBAL_1ST = 1;
	   public static final int GIMBAL_2ND = 2;
	   
}
