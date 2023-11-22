package com.cf.forward.dh.yangbang;

import java.util.Calendar;
import java.util.Date;

public class BxCmdSystemClockCorrect extends BxCmd {
	private Date systemTime;
	
	protected int year;

    protected int month;

    protected int day;

    protected int hour;

    protected int minute;

    protected int second;

    protected int week;
	
	public BxCmdSystemClockCorrect(Date time) {
        super(BxCmdCode.CMD_SYSTEM_CLOCK_CORRECT.group, BxCmdCode.CMD_SYSTEM_CLOCK_CORRECT.code);
        this.systemTime = time;

        Calendar cal = Calendar.getInstance();
        cal.setTime(time);
        this.year = cal.get(Calendar.YEAR);
        this.month = cal.get(Calendar.MONTH) + 1;
        this.day = cal.get(Calendar.DAY_OF_MONTH);
        this.hour = cal.get(Calendar.HOUR_OF_DAY);
        this.minute = cal.get(Calendar.MINUTE);
        this.second = cal.get(Calendar.SECOND);
        switch (cal.get(Calendar.DAY_OF_WEEK)) {
            case Calendar.MONDAY:
                this.week = 1;
                break;
            case Calendar.TUESDAY:
                this.week = 2;
                break;
            case Calendar.WEDNESDAY:
                this.week = 3;
                break;
            case Calendar.THURSDAY:
                this.week = 4;
                break;
            case Calendar.FRIDAY:
                this.week = 5;
                break;
            case Calendar.SATURDAY:
                this.week = 6;
                break;
            case Calendar.SUNDAY:
                this.week = 7;
                break;
        }
        
        //时间转成BCD码
        String resultY = DecimaltoBcd(String.valueOf(this.year));
        String resultM = DecimaltoBcd(String.valueOf(this.month));
        String resultD = DecimaltoBcd(String.valueOf(this.day));
        String resultH = DecimaltoBcd(String.valueOf(this.hour));
        String resultm = DecimaltoBcd(String.valueOf(this.minute));
        String resultS = DecimaltoBcd(String.valueOf(this.second));
        String resultW = DecimaltoBcd(String.valueOf(this.week));
    	this.year = Integer.parseInt(resultY, 2);
    	this.month = Integer.parseInt(resultM, 2);
    	this.day = Integer.parseInt(resultD, 2);
    	this.hour = Integer.parseInt(resultH, 2);
    	this.minute = Integer.parseInt(resultm, 2);
    	this.second = Integer.parseInt(resultS, 2);
    	this.week = Integer.parseInt(resultW, 2);
	}
	
	/**
     * 10进制转bcd
     * @param str 10进制数字 String.valueOf(int number);将10进制数字转成字符串传入此参数
     * @return bcd码
     */
     public String DecimaltoBcd(String str){     
        String b_num="";
        for (int i = 0; i < str.length(); i++) {

            String b = Integer.toBinaryString(Integer.parseInt(str.valueOf(str.charAt(i))));

            int b_len=4-b.length();

            for(int j=0;j<b_len;j++){
                b="0"+b;                
            }
            b_num+=b;
        }

        return b_num;
    }
     
    @Override
    public byte[] build() {
        //
        BxByteArray array = new BxByteArray();

        // cmd
        //
        // cmd group
        array.add(getGroup());
        array.add(getCmd());

        //
        // response or not
        array.add(getReqResp());

        //
        // r0, r1
        array.add((byte)0x00);
        array.add((byte)0x00);

        //BCD码：年（2）+月（1）+日（1）+时（1）+分（1）+秒（1）+星期（1）；先地位再高位
        //年：低端发送，低位在前
    	byte[] contType = new byte[] {
                (byte) this.year,
                (byte) (this.year >>> 8),
                (byte) (this.year >>> 16),
                (byte) (this.year >>> 24) };
    	if(contType[0] == 0x00 && contType[1] == 0x00){
    		array.add(contType[2]);
    		array.add(contType[3]);
    	}
    	else{
    		array.add(contType[0]);
    		array.add(contType[1]);
    	}
    	//月
    	contType = new byte[] {
        (byte) this.month,
        (byte) (this.month >>> 8),
        (byte) (this.month >>> 16),
        (byte) (this.month >>> 24) };
    	array.add(contType[0]);
    	contType = new byte[] {
    	        (byte) this.day,
    	        (byte) (this.day >>> 8),
    	        (byte) (this.day >>> 16),
    	        (byte) (this.day >>> 24) };
    	array.add(contType[0]);
    	contType = new byte[] {
    	        (byte) this.hour,
    	        (byte) (this.hour >>> 8),
    	        (byte) (this.hour >>> 16),
    	        (byte) (this.hour >>> 24) };
    	array.add(contType[0]);
    	contType = new byte[] {
    	        (byte) this.minute,
    	        (byte) (this.minute >>> 8),
    	        (byte) (this.minute >>> 16),
    	        (byte) (this.minute >>> 24) };
    	array.add(contType[0]);
    	contType = new byte[] {
    	        (byte) this.second,
    	        (byte) (this.second >>> 8),
    	        (byte) (this.second >>> 16),
    	        (byte) (this.second >>> 24) };
    	array.add(contType[0]);
    	contType = new byte[] {
    	        (byte) this.week,
    	        (byte) (this.week >>> 8),
    	        (byte) (this.week >>> 16),
    	        (byte) (this.week >>> 24) };
    	array.add(contType[0]);

        return array.build();
    }
}
