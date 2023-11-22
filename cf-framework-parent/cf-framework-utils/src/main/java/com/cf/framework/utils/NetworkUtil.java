package com.cf.framework.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;

/**
 * 网络工具
 */
public class NetworkUtil {

    /**
     * 获取本地ip列表  列出所有网卡的ip
     * @return
     */
    public static ArrayList<String> getLocalIpAddr()
    {
        ArrayList<String> ipList = new ArrayList<String>();
        InetAddress[] addrList;
        try
        {
            Enumeration interfaces= NetworkInterface.getNetworkInterfaces();
            while(interfaces.hasMoreElements())
            {
                NetworkInterface ni=(NetworkInterface)interfaces.nextElement();
                Enumeration ipAddrEnum = ni.getInetAddresses();
                while(ipAddrEnum.hasMoreElements())
                {
                    InetAddress addr = (InetAddress)ipAddrEnum.nextElement();
                    if (addr.isLoopbackAddress() == true)
                    {
                        continue;
                    }

                    String ip = addr.getHostAddress();
                    if (ip.indexOf(":") != -1)
                    {
                        //skip the IPv6 addr
                        continue;
                    }
                    ipList.add(ip);
                }
            }

            Collections.sort(ipList);
        }
        catch (Exception e)
        {
            throw new RuntimeException("Failed to get local ip list");
        }
        return ipList;
    }
}
