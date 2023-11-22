package com.cf.forward.dh.lib.structure;

import com.cf.forward.dh.lib.NetSDKLib;
import com.sun.jna.Pointer;

public class NET_SYSTEM_STATUS extends NetSDKLib.SdkStructure {
    /**
     * dwSize;
     */
    public int dwSize;
    /**
     *  CPU状态 NET_CPU_STATUS
     */
    public Pointer pstuCPU;

    /**
     *  内存状态 NET_MEMORY_STATUS
     */
    public Pointer pstuMemory;

    /**
     *  风扇状态 NET_FAN_STATUS
     */
    public Pointer pstuFan;

    /**
     *  电源状态 NET_POWER_STATUS
     */
    public Pointer pstuPower;

    /**
     *  温度状态 NET_TEMPERATURE_STATUS
     */
    public Pointer pstuTemp;

    public NET_SYSTEM_STATUS(){
        this.dwSize = this.size();
    }
}
