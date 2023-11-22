package com.cf.forward.hk.config;

import com.cf.forward.hk.hardware.hcsdk.HCNetSDK;
import com.sun.jna.Pointer;

public class DevInfoCallBack implements HCNetSDK.FRemoteConfigCallBack {
    @Override
    public void invoke(int dwType, Pointer lpBuffer, int dwBufLen, Pointer pUserData) {

    }
}
