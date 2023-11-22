package com.cf.forward.dh.lib.enumeration;

public class NET_VOLUME_TYPE {
    public static final int VOLUME_TYPE_ALL = 0;    //所有卷
    public static final int VOLUME_TYPE_PHYSICAL = 1;    //物理卷
    public static final int VOLUME_TYPE_RAID = 2;    //Raid卷
    public static final int VOLUME_TYPE_VOLUME_GROUP = 3;    //VG虚拟卷组
    public static final int VOLUME_TYPE_ISCSI = 4;    //iSCSI卷
    public static final int VOLUME_TYPE_INVIDUAL_PHY = 5;    //独立物理卷（这个物理盘,没有加入到, RAID,虚拟卷组等等组中）
    public static final int VOLUME_TYPE_GLOBAL_SPARE = 6;    //全局热备卷
    public static final int VOLUME_TYPE_NAS = 7;    //NAS盘(包括FTP, SAMBA, NFS)
    public static final int VOLUME_TYPE_INVIDUAL_RAID = 8;    //独立RAID卷（指没有加入到，虚拟卷组等组中）
}
