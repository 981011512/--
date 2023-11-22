package com.cf.forward.dh.lib.enumeration;

public enum EM_RADAR_POINTTYPE {
	EM_RADAR_POINTTYPE_UNKNOWN(0,"未知"),                          
	EM_RADAR_POINTTYPE_ALARMPOINT(1,"当前点是报警区的报警点"),                       
	EM_RADAR_POINTTYPE_LINKMONITORPOINT(2,"当前点是正在被联动监控的点"),                 
	EM_RADAR_POINTTYPE_DISAPPEARTRACKPOINT(3,"当前点是消失的轨迹点");

	private int value;
    private String note;
    
	EM_RADAR_POINTTYPE(int givenValue, String note) {
		// TODO Auto-generated constructor stub
		this.value = givenValue;
        this.note = note;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}    
	
	
}
