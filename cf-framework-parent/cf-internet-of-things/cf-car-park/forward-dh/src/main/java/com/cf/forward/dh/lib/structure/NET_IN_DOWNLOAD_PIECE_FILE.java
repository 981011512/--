package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib.SdkStructure;

public class NET_IN_DOWNLOAD_PIECE_FILE extends SdkStructure{
	
	public int				dwSize;
	/**
	 * 需要下载的文件名,支持全路径
	 */
	public byte[]			szFileName= new byte[260];
	/**
	 * 下载偏移,单位字节
	 * 如果文件总长度为50KB,每次请求下载数据量为32KB,那么第一次请求时,nOffSet为0,第二次请求nOffSet为32KB
	 */
	public int				nOffSet;	
	/**
	 *  请求下载数据量,单位字节，建议为32KB,最大不超过4MB
	 */
	public int				nNeedLength;	
	 public NET_IN_DOWNLOAD_PIECE_FILE() {
         this.dwSize = this.size();
     }			  	
}
