package tcpserver.src.mavlinklib.command.camera.custom.list;


public enum CUSTOM_CAMERA_LAYOUT {  // 
	AMP_LAYOUT_0(0),  // main EO sub IR
	AMP_LAYOUT_1(1),  // main IR sub EO
	AMP_LAYOUT_2(2),  // main EO only
	AMP_LAYOUT_3(3);  // main IR only
	// TODO..
	public final int rawStateData;

	CUSTOM_CAMERA_LAYOUT(int val) {
		this.rawStateData = val;
	}	
}