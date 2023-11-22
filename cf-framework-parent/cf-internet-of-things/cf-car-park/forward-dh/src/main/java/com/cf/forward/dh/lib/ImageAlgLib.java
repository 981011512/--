package com.cf.forward.dh.lib;

import com.sun.jna.Library;
import com.sun.jna.Native;

/**
 * SDK JNA接口封装
 */
public interface ImageAlgLib extends Library {
	ImageAlgLib IMAGEALG_INSTANCE = (ImageAlgLib)Native.loadLibrary(Utils.getLoadLibrary("ImageAlg"), ImageAlgLib.class);
	
	
	/*******************************************************************************
	* 函数名  : drcTable
	* 描  述  : raw数据转换成Y数据
	* 输  入  : - pRaw: 14bit裸数据
	* 输  入  : - height: 输入裸数据的高
	* 输  入  : - width:  输入裸数据的宽
	* 输  入  : - sel:  默认填0
	* 输  入  : - lut:  当sel为1时，该参数为本地drc表，默认填0
	* 输  出  : pYData：转换后的Y数据
	* 返回值  : 0  : 成功
	*           -1: 失败
	*******************************************************************************/
	int drcTable(short[] pRaw, short width, short height, int sel, byte[] pYData, short[] lut);

}