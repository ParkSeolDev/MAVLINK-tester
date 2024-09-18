package tcpserver.src.mavlinklib.command.camera.custom.list;


public enum CUSTOM_DEVICE_LIST {  // 
	DEFAULT_DEVICE(0),
	PRENEU_SPEACKER(1),
	PRENEU_LED(2),
	PRENEU_SEARCH_LIGHT(3),
	AMP_SEARCH_LIGHT(3),
	AMP_SPEACKER(1);
//	AMP_SEARCH_LIGHT(1),
//	AMP_SPEACKER(2);
	// TODO..
	public final int rawStateData;

	CUSTOM_DEVICE_LIST(int val) {
		this.rawStateData = val;
	}	
}