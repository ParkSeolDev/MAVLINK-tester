package tcpserver.src.mavlinklib.command.camera.custom.list;

public enum CMD_USER_COMMAND_TYPE {  // 
	USER_COMMAND_INIT(0),
	USER_COMMAND_SPEAKER_PLAY(1), 			
	USER_COMMAND_SPEAKER_STOP(2), 				
	USER_COMMAND_SPEAKER_NEXT(3),                 
	USER_COMMAND_SPEAKER_PREVIOUS(4),                
	USER_COMMAND_LED_OFF(5),						// MAV_CMD_NAV_LAND  			// 현재위치 또는 지정한 위경도에 착륙함  경도 param5, 위도 param6
	USER_COMMAND_LED_ON(6),
	USER_COMMAND_LIGHT_OFF(7),
	USER_COMMAND_LIGHT_ON(8),
	USER_COMMAND_SPEAKER_PLAY_AMP(9), 			
	USER_COMMAND_SPEAKER_STOP_AMP(10), 				
	USER_COMMAND_SPEAKER_NEXT_AMP(11),                 
	USER_COMMAND_SPEAKER_PREVIOUS_AMP(12);
	// TODO..
	public final int rawStateData;

	CMD_USER_COMMAND_TYPE(int val) {
		this.rawStateData = val;
	}	
	
	public static CMD_USER_COMMAND_TYPE getUserCommandType(int value) {
		CMD_USER_COMMAND_TYPE commandType = null;
    	switch (value) {
		case 0 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_INIT;
			break;
		case 1 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_SPEAKER_PLAY;
			break;
		case 2 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_SPEAKER_STOP;
			break;
		case 3 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_SPEAKER_NEXT;
			break;
		case 4 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_SPEAKER_PREVIOUS;
			break;
		case 5 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_LED_OFF;
			break;
		case 6 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_LED_ON;
			break;
		case 7 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_LIGHT_OFF;
			break;
		case 8 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_LIGHT_ON;
			break;
		case 9 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_SPEAKER_PLAY_AMP;
			break;
		case 10 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_SPEAKER_STOP_AMP;
			break;
		case 11 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_SPEAKER_NEXT_AMP;
			break;
		case 12 :
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_SPEAKER_PREVIOUS_AMP;
			break;
		default:
			commandType = CMD_USER_COMMAND_TYPE.USER_COMMAND_INIT;
			break;
		}
    	return commandType;
	}
}


