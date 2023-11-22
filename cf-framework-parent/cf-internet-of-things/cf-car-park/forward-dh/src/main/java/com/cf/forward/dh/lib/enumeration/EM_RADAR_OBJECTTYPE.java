package com.cf.forward.dh.lib.enumeration;

public enum EM_RADAR_OBJECTTYPE {
	EM_RADAR_OBJECTTYPE_UNKNOWN(0,"未识别目标"),                         
	EM_RADAR_OBJECTTYPE_PERSON(1,"目标为人"),                          
	EM_RADAR_OBJECTTYPE_VEHICLE(2,"目标为交通工具"),                        
	EM_RADAR_OBJECTTYPE_TREE(3,"目标为树"),                             
	EM_RADAR_OBJECTTYPE_BUILIDING(4,"目标为建筑物"),                        
	EM_RADAR_OBJECTTYPE_SCREEN(5,"目标为屏幕");                          
	
	private int value;
    private String note;    
    
	private EM_RADAR_OBJECTTYPE(int value, String note) {
		this.value = value;
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
