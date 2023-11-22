package com.cf.forward.dh.lib;

import com.cf.forward.dh.common.ErrorCode;
import com.cf.forward.dh.common.PaintPanel;
import com.cf.forward.dh.module.LoginModule;
import com.cf.forward.dh.lib.NetSDKLib.LLong;
import com.sun.jna.Memory;
import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import com.sun.jna.ptr.IntByReference;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.*;
import java.text.SimpleDateFormat;

public class ToolKits {
	static NetSDKLib netsdkapi = NetSDKLib.NETSDK_INSTANCE;
	static NetSDKLib configapi = NetSDKLib.CONFIG_INSTANCE;
	
  	/***************************************************************************************************
  	 *                          				工具方法       	 										   *
  	 ***************************************************************************************************/
	public static void GetPointerData(Pointer pNativeData, Structure pJavaStu)
	{
		GetPointerDataToStruct(pNativeData, 0, pJavaStu);
	}

	public static void GetPointerDataToStruct(Pointer pNativeData, long OffsetOfpNativeData, Structure pJavaStu) {
		pJavaStu.write();
		Pointer pJavaMem = pJavaStu.getPointer();
		pJavaMem.write(0, pNativeData.getByteArray(OffsetOfpNativeData, pJavaStu.size()), 0,
				pJavaStu.size());
		pJavaStu.read();
	}
	
	public static void GetPointerDataToStructArr(Pointer pNativeData, Structure []pJavaStuArr) {
		long offset = 0;
		for (int i=0; i<pJavaStuArr.length; ++i)
		{
			GetPointerDataToStruct(pNativeData, offset, pJavaStuArr[i]);
			offset += pJavaStuArr[i].size();
		}
	}
	
	/**
	 * 将结构体数组拷贝到内存
	 * @param pNativeData 
	 * @param pJavaStuArr
	 */
	public static void SetStructArrToPointerData(Structure []pJavaStuArr, Pointer pNativeData) {
		long offset = 0;
		for (int i = 0; i < pJavaStuArr.length; ++i) {
			SetStructDataToPointer(pJavaStuArr[i], pNativeData, offset);
			offset += pJavaStuArr[i].size();
		}
	}
	
	public static void SetStructDataToPointer(Structure pJavaStu, Pointer pNativeData, long OffsetOfpNativeData){
		pJavaStu.write();
		Pointer pJavaMem = pJavaStu.getPointer();
		pNativeData.write(OffsetOfpNativeData, pJavaMem.getByteArray(0, pJavaStu.size()), 0, pJavaStu.size());
	}
	
	public static void savePicture(byte[] pBuf, String sDstFile) throws IOException
	{
		FileOutputStream fos=null;
        try
        {
          	fos = new FileOutputStream(sDstFile);
        	fos.write(pBuf);	
        } catch (Exception e){
        	e.printStackTrace();
        }finally{
        	fos.close();	
        }
	}
	
	public static void savePicture(byte[] pBuf, int dwBufOffset, int dwBufSize, String sDstFile) throws IOException
	{
		FileOutputStream fos=null;
        try
        {       	
        	fos = new FileOutputStream(sDstFile);
        	fos.write(pBuf, dwBufOffset, dwBufSize);
        } catch (Exception e){
        	e.printStackTrace();
        }finally{
        	fos.close();	
        }
	}
	
	public static void savePicture(Pointer pBuf, int dwBufSize, String sDstFile) throws IOException
	{
		FileOutputStream fos=null;
        try
        {
          	fos = new FileOutputStream(sDstFile);
        	fos.write(pBuf.getByteArray(0, dwBufSize), 0, dwBufSize);
        } catch (Exception e){
        	e.printStackTrace();
        }finally{
        	fos.close();	
        }
	}
	
	public static void savePicture(Pointer pBuf, int dwBufOffset, int dwBufSize, String sDstFile) throws IOException
	{
		FileOutputStream fos=null;
        try
        {
        	fos = new FileOutputStream(sDstFile);
        	fos.write(pBuf.getByteArray(dwBufOffset, dwBufSize), 0, dwBufSize);
        } catch (Exception e){
        	e.printStackTrace();
        }finally{
        	fos.close();	
        }
	}
	
	// 将Pointer值转为byte[]
	public static String GetPointerDataToByteArr(Pointer pointer) {	
		String str = "";
		if(pointer == null) {
			return str;
		}

		int length = 0;
		byte[] bufferPlace = new byte[1];

		for(int i = 0; i < 2048; i++) {		
			pointer.read(i, bufferPlace, 0, 1);		
			if(bufferPlace[0] == '\0') {
				length = i;
				break;
			}
		}
				
		if(length > 0) {
			byte[] buffer = new byte[length];
			pointer.read(0, buffer, 0, length);
			try {
				str = new String(buffer, "GBK").trim();
			} catch (UnsupportedEncodingException e) {
				return str;
			}
		} 

		return str;
	}
	
	// 获取当前时间
	public static String getDate() {
		SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	    String date = simpleDate.format(new java.util.Date()).replace(" ", "_").replace(":", "-");
	    
	    return date;
	}
	
	// 获取当前时间
	public static String getDay() {
			SimpleDateFormat simpleDate = new SimpleDateFormat("yyyy-MM-dd");
		    String date = simpleDate.format(new java.util.Date());		
		    return date;
	}

	
	// 限制JTextField 长度，以及内容
	public static void limitTextFieldLength(final JTextField jTextField, final int size) {
		jTextField.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {			
				String number = "0123456789" + (char)8;	
				if(number.indexOf(e.getKeyChar()) < 0 || jTextField.getText().trim().length() >= size) {
					e.consume();
					return;
				}		
			}
			
			@Override
			public void keyReleased(KeyEvent e) {		
			}
			
			@Override
			public void keyPressed(KeyEvent e) {	
			}
		});
	}
	
    // 获取当前窗口
	public static JFrame getFrame(ActionEvent e) {
		JButton btn = (JButton)e.getSource();
		JFrame frame = (JFrame)btn.getRootPane().getParent();
		
		return frame;
	}
	
	// 获取操作平台信息
	public static String getLoadLibrary(String library) {
		String path = "";
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("win")) {
			path = "./libs/";
		} else if(os.toLowerCase().startsWith("linux")) {
			path = "";
		}

		return (path + library);
	}
		
	public static String getOsName() {
		String osName = "";
		String os = System.getProperty("os.name");
		if(os.toLowerCase().startsWith("win")) {
			osName = "win";
		} else if(os.toLowerCase().startsWith("linux")) {
			osName = "linux";
		}
		
		return osName;
	}
	
	/**
	 * 读取图片大小
	 * @param filePath  图片路径
	 * @return
	 */
	public static long GetFileSize(String filePath) {
		File f = new File(filePath);
		if (f.exists() && f.isFile()) {
			return f.length();
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * 读取图片数据
	 * @param file 图片路径
	 * @param memory 图片数据缓存  
	 * @return
	 * @throws IOException 
	 */
	public static boolean ReadAllFileToMemory(String file, Memory memory) throws IOException {
		if (memory != Memory.NULL)
		{
			long fileLen = GetFileSize(file);
			if (fileLen <= 0)
			{
				return false;
			}
			FileInputStream in =null;
			try {
				File infile = new File(file);
				if (infile.canRead())
				{
					in = new FileInputStream(infile);
					int buffLen = 1024; 
					byte[] buffer = new byte[buffLen];
					long currFileLen = 0;
					int readLen = 0;
					while (currFileLen < fileLen)
					{
						readLen = in.read(buffer);
						memory.write(currFileLen, buffer, 0, readLen);
						currFileLen += readLen;
					}										
					return true;
				}
		        else
		        {
		        	System.err.println("Failed to open file %s for read!!!\n");
		            return false;
		        }
			}catch (Exception e)
			{
				System.err.println("Failed to open file %s for read!!!\n");
				e.printStackTrace();
			}finally{
				if(in!=null){
					in.close();
				}				
			}
		}
		
		return false;
	}
	
	static class JPGFilter extends FileFilter {
		public boolean accept(File f) {
			if(f.getName().toLowerCase().endsWith(".JPG")
					|| f.getName().toLowerCase().endsWith(".jpg") 
					|| f.isDirectory()) {
				return true;
			}
			return false;
		}

		@Override
		public String getDescription() {
			return "*.jpg; *.JPG";
		}
	}
	
	/*
	 * 用选择器选择图片, 获取图片路径，并在界面显示
	 */
	public static String openPictureFile(PaintPanel paintPanel) {	
    	try {
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (Exception e) {
        	e.printStackTrace();
        } 
    	
		String picPath = "";
		
		// 读取图片
		JFileChooser jfc = new JFileChooser("d:/");
		jfc.setMultiSelectionEnabled(false);    // 不可以拖选多个文件
		jfc.setAcceptAllFileFilterUsed(false);  // 关闭显示所有

		//添加过滤器
		JPGFilter filter = new JPGFilter();
		jfc.addChoosableFileFilter(filter);
		jfc.setFileFilter(filter);
		
        if( jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
        	picPath = jfc.getSelectedFile().getAbsolutePath();
        	
        	/*
        	 * 读取本地图片, 并在面板上显示
        	 */
        	BufferedImage bufferedImage = null;
			if(picPath == null || picPath.equals("")) {
				return "";
			}
			
			File file = new File(picPath);
			if(!file.exists()) {
				return "";
			}
			
			try {
				bufferedImage = ImageIO.read(file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			if(bufferedImage == null) {
				paintPanel.setOpaque(true);
				paintPanel.repaint();
				
				System.err.println("打开图片失败，请重新选择！");
				return "";
			} else {
				paintPanel.setOpaque(false);
				paintPanel.setImage(bufferedImage);
				paintPanel.repaint();
			}
		}
        
    	try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
        	e.printStackTrace();
        } 
        return picPath;
	}
	
	/*
	 * 传入图片路径, 打开图片, 并在面板显示
	 */
	public static File openPictureFile(String picPath, PaintPanel paintPanel) {		
    	/*
    	 * 读取本地图片, 并在面板上显示
    	 */
    	BufferedImage bufferedImage = null;
		if(picPath == null || picPath.equals("")) {
			return null;
		}
		
		File file = new File(picPath);
		if(!file.exists()) {
			return null;
		}
		
		try {
			bufferedImage = ImageIO.read(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		if(bufferedImage == null) {
			paintPanel.setOpaque(true);
			paintPanel.repaint();
			
			System.err.println("打开图片失败，请重新选择！");
			return null;
		} else {
			paintPanel.setOpaque(false);
			paintPanel.setImage(bufferedImage);
			paintPanel.repaint();
		}
		
        return file;
	}
	
	/**
	 * 读取图片
	 * @return 图片缓存
	 * @throws IOException 
	 */
	public static Memory readPictureFile(String picPath) throws IOException {
		int nPicBufLen = 0;
		Memory memory = null;
			
	    /*
	     * 读取本地图片大小
	     */
		nPicBufLen = (int)ToolKits.GetFileSize(picPath);   
		
		// 读取文件大小失败
		if (nPicBufLen <= 0) {
			System.err.println("读取图片大小失败，请重新选择！");
            return null;
		}

		/*
		 * 读取图片缓存
		 */
		memory = new Memory(nPicBufLen);   // 申请缓存
		memory.clear();
		
		if (!ToolKits.ReadAllFileToMemory(picPath,  memory)) {
			System.err.println("读取图片数据，请重新选择！");
            return null;
		}
	
        return memory;
	}

	/**
	 * 登录设备设备错误状态, 用于界面显示
	 */
	public static String getErrorCodeShow() {
		return ErrorCode.getErrorCode(LoginModule.netsdk.CLIENT_GetLastError());
	}

	/**
	 * 获取接口错误码和错误信息，用于打印
	 * @return
	 */
	public static String getErrorCodePrint() {
		return "\n{error code: (0x80000000|" + (LoginModule.netsdk.CLIENT_GetLastError() & 0x7fffffff) +").参考  NetSDKLib.java }"
				+ " - {error info:" + ErrorCode.getErrorCode(LoginModule.netsdk.CLIENT_GetLastError()) + "}\n";
	}
	
	/**
	 * 获取单个配置
	 * @param hLoginHandle 登陆句柄
	 * @param nChn 通道号，-1 表示全通道
	 * @param strCmd 配置名称
	 * @param cmdObject 配置对应的结构体对象
	 * @return 成功返回 true 
	 */
	public static boolean GetDevConfig(LLong hLoginHandle, int nChn, String strCmd, Structure cmdObject) {
		boolean result = false;
		IntByReference error = new IntByReference(0);
		int nBufferLen = 2*1024*1024;
	    byte[] strBuffer = new byte[nBufferLen];
	   
	    if(netsdkapi.CLIENT_GetNewDevConfig( hLoginHandle, strCmd , nChn, strBuffer, nBufferLen,error,3000)) {  
	    	cmdObject.write();
			if (configapi.CLIENT_ParseData(strCmd, strBuffer, cmdObject.getPointer(),
					cmdObject.size(), null)) {
				cmdObject.read();
	     		result = true;
	     	} else {
	     		System.err.println("Parse " + strCmd + " Config Failed!" + ToolKits.getErrorCodePrint());
	     		result = false;
		 	}
	    } else {
			 System.err.printf("Get %s Config Failed!Last Error = %s\n" , strCmd , getErrorCodePrint());
			 result = false;
		}
			
	    return result;
	}
	
	/**
	 * 设置单个配置
	 * @param hLoginHandle 登陆句柄
	 * @param nChn 通道号，-1 表示全通道
	 * @param strCmd 配置名称
	 * @param cmdObject 配置对应的结构体对象
	 * @return 成功返回 true
	 */
	public static boolean SetDevConfig(LLong hLoginHandle, int nChn, String strCmd, Structure cmdObject) {
        boolean result = false;
    	int nBufferLen = 2*1024*1024;
        byte szBuffer[] = new byte[nBufferLen];
        for(int i=0; i<nBufferLen; i++)szBuffer[i]=0;
    	IntByReference error = new IntByReference(0);
    	IntByReference restart = new IntByReference(0); 

		cmdObject.write();
		if (configapi.CLIENT_PacketData(strCmd, cmdObject.getPointer(), cmdObject.size(),
				szBuffer, nBufferLen)) {	
			cmdObject.read();
        	if( netsdkapi.CLIENT_SetNewDevConfig(hLoginHandle, strCmd , nChn , szBuffer, nBufferLen, error, restart, 3000)) {
        		result = true;
        	} else {
        		 System.err.printf("Set %s Config Failed! Last Error = %s\n" , strCmd , getErrorCodePrint());
	        	 result = false;
        	}
        } else {
        	System.err.println("Packet " + strCmd + " Config Failed!" + getErrorCodePrint());
         	result = false;
        }
        
        return result;
    }
	
    // Win下，将GBK String类型的转为Pointer
    public static Pointer GetGBKStringToPointer(String src) {	
    	Pointer pointer = null;
    	try {
			byte[] b = src.getBytes("GBK");
			pointer = new Memory(b.length+1);
			pointer.clear(b.length+1);
			
			pointer.write(0, b, 0, b.length);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	return pointer;
    }
    
    /**
     * 字符串拷贝，用于先获取，再设置(src → dst)
     * @param src 
     * @param dst
     */
	public static void StringToByteArray(String src, byte[] dst) {
		for(int i = 0; i < dst.length; i++) {
			dst[i] = 0;
		}
		
		System.arraycopy(src.getBytes(), 0, dst, 0, src.getBytes().length);
	}
	
	/**
	 * 数组拷贝， 用于先获取，再设置(src → dst)
	 * @param b
	 * @param dst
	 */
	public static void ByteArrayToByteArray(byte[] src, byte[] dst) {
		for(int i = 0; i < dst.length; i++) {
			dst[i] = 0;
		}
		
		System.arraycopy(src, 0, dst, 0, src.length);
	}
}
