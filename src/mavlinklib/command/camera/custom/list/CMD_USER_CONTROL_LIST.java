package tcpserver.src.mavlinklib.command.camera.custom.list;

public enum CMD_USER_CONTROL_LIST {  // 
	USER_CONTROL_INIT(0),
	USER_CONTROL_SPEAKER_PLAY(1), 			
	USER_CONTROL_SPEAKER_STOP(2), 				
	USER_CONTROL_SPEAKER_NEXT(3),                 
	USER_CONTROL_SPEAKER_PREVIOUS(4),         
	USER_CONTROL_SPEAKER_PLAY_AMP(1), 			
	USER_CONTROL_SPEAKER_STOP_AMP(2), 				
	USER_CONTROL_SPEAKER_NEXT_AMP(3),                 
	USER_CONTROL_SPEAKER_PREVIOUS_AMP(4),
//	USER_CONTROL_SPEAKER_PLAY_AMP(17), 			
//	USER_CONTROL_SPEAKER_STOP_AMP(16), 				
//	USER_CONTROL_SPEAKER_NEXT_AMP(18),                 
//	USER_CONTROL_SPEAKER_PREVIOUS_AMP(19),
	USER_CONTROL_LED_OFF(0),						// MAV_CMD_NAV_LAND  			// 현재위치 또는 지정한 위경도에 착륙함  경도 param5, 위도 param6
	USER_CONTROL_LED_ON(1),
	USER_CONTROL_LIGHT_OFF(0),
	USER_CONTROL_LIGHT_ON(1);
	// TODO..
	public final float rawStateData;

	CMD_USER_CONTROL_LIST(float val) {
		this.rawStateData = val;
	}	
}


