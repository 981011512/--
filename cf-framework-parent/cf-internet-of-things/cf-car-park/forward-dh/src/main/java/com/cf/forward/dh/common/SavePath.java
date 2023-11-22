package com.cf.forward.dh.common;

import com.cf.forward.dh.lib.ToolKits;

import java.io.File;

public class SavePath {
	private SavePath() {}
	
	private static class SavePathHolder {
		private static SavePath instance = new SavePath();
	}
	
	public static SavePath getSavePath() {
		return SavePathHolder.instance;
	}
	
	String s_captureSavePath = "./Capture/" + ToolKits.getDay() + "/";         // 抓拍图片保存路径
	String s_imageSavePath = "./Image/" + ToolKits.getDay() + "/";    		    // 图片保存路径
	String s_recordFileSavePath = "./RecordFile/" + ToolKits.getDay() + "/";   // 录像保存路径
	
	/*
	 * 设置抓图保存路径
	 */
	public String getSaveCapturePath() {	
		File path1 = new File("./Capture/");
        if (!path1.exists()) {
        	path1.mkdir();
        }
        
	    File path2 = new File(s_captureSavePath);
	    if (!path2.exists()) {
	        path2.mkdir();
	    }
	    
	    String strFileName = path2.getAbsolutePath() + "/" + ToolKits.getDate() + ".jpg";
		
	    return strFileName;
	}
	
	/*
	 * 设置智能交通图片保存路径
	 */
	public String getSaveTrafficImagePath() {
        File path1 = new File("./Image/");
        if (!path1.exists()) {
            path1.mkdir();
        }
    	
        File path = new File(s_imageSavePath);
        if (!path.exists()) {
            path.mkdir();
        }
        
        return s_imageSavePath;
	}
	
	
	/*
	 * 设置录像保存路径
	 */
	public String getSaveRecordFilePath() {	
        File path1 = new File("./RecordFile/");
        if (!path1.exists()) {
            path1.mkdir();
        }
        
	    File path2 = new File(s_recordFileSavePath);
	    if (!path2.exists()) {
	        path2.mkdir();
	    }
		String SavedFileName = s_recordFileSavePath + ToolKits.getDate() + ".dav"; // 默认保存路径
		return SavedFileName;
	}
	
}
