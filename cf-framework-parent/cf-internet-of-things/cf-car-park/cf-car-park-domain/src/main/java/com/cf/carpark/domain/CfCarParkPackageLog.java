package com.cf.carpark.domain;

import java.io.Serializable;

public class CfCarParkPackageLog implements Serializable {
    private String id;

    private String packageId;

    private String beforeCarParkId;

    private String afterCarParkId;

    private String beforeTypeKey;

    private String afterTypeKey;

    private Long beforeStartTime;

    private Long afterStartTime;

    private Long beforeEndTime;

    private Long afterEndTime;

    private Long beforeCreateTime;

    private Long afterCreateTime;

    private String beforeUid;

    private String afterUid;

    private String beforeNumberPlate;

    private String afterNumberPlate;

    private Byte beforeSpecialGive;

    private Byte afterSpecialGive;

    private String beforePackagePriceId;

    private String afterPackagePriceId;

    private Byte beforeTransRegional;

    private Byte afterTransRegional;

    private String beforeParentId;

    private String afterParentId;

    private String beforePhone;

    private String afterPhone;

    private String beforeMainCarParkId;

    private String afterMainCarParkId;

    private String beforeRemarks;

    private String afterRemarks;

    private String beforeCarOwnerName;

    private String afterCarOwnerName;

    private String beforeGroupFlag;

    private Byte beforeStatus;

    private Byte afterStatus;

    private String handleUid;

    private Long actionTime;

    private String afterGroupFlag;

    private String handleUserName;

    private String beforeCarParkName;

    private String afterCarParkName;

    private String beforeTypeKeyName;

    private String afterTypeKeyName;

    private static final long serialVersionUID = 1L;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getPackageId() {
        return packageId;
    }

    public void setPackageId(String packageId) {
        this.packageId = packageId == null ? null : packageId.trim();
    }

    public String getBeforeCarParkId() {
        return beforeCarParkId;
    }

    public void setBeforeCarParkId(String beforeCarParkId) {
        this.beforeCarParkId = beforeCarParkId == null ? null : beforeCarParkId.trim();
    }

    public String getAfterCarParkId() {
        return afterCarParkId;
    }

    public void setAfterCarParkId(String afterCarParkId) {
        this.afterCarParkId = afterCarParkId == null ? null : afterCarParkId.trim();
    }

    public String getBeforeTypeKey() {
        return beforeTypeKey;
    }

    public void setBeforeTypeKey(String beforeTypeKey) {
        this.beforeTypeKey = beforeTypeKey == null ? null : beforeTypeKey.trim();
    }

    public String getAfterTypeKey() {
        return afterTypeKey;
    }

    public void setAfterTypeKey(String afterTypeKey) {
        this.afterTypeKey = afterTypeKey == null ? null : afterTypeKey.trim();
    }

    public Long getBeforeStartTime() {
        return beforeStartTime;
    }

    public void setBeforeStartTime(Long beforeStartTime) {
        this.beforeStartTime = beforeStartTime;
    }

    public Long getAfterStartTime() {
        return afterStartTime;
    }

    public void setAfterStartTime(Long afterStartTime) {
        this.afterStartTime = afterStartTime;
    }

    public Long getBeforeEndTime() {
        return beforeEndTime;
    }

    public void setBeforeEndTime(Long beforeEndTime) {
        this.beforeEndTime = beforeEndTime;
    }

    public Long getAfterEndTime() {
        return afterEndTime;
    }

    public void setAfterEndTime(Long afterEndTime) {
        this.afterEndTime = afterEndTime;
    }

    public Long getBeforeCreateTime() {
        return beforeCreateTime;
    }

    public void setBeforeCreateTime(Long beforeCreateTime) {
        this.beforeCreateTime = beforeCreateTime;
    }

    public Long getAfterCreateTime() {
        return afterCreateTime;
    }

    public void setAfterCreateTime(Long afterCreateTime) {
        this.afterCreateTime = afterCreateTime;
    }

    public String getBeforeUid() {
        return beforeUid;
    }

    public void setBeforeUid(String beforeUid) {
        this.beforeUid = beforeUid == null ? null : beforeUid.trim();
    }

    public String getAfterUid() {
        return afterUid;
    }

    public void setAfterUid(String afterUid) {
        this.afterUid = afterUid == null ? null : afterUid.trim();
    }

    public String getBeforeNumberPlate() {
        return beforeNumberPlate;
    }

    public void setBeforeNumberPlate(String beforeNumberPlate) {
        this.beforeNumberPlate = beforeNumberPlate == null ? null : beforeNumberPlate.trim();
    }

    public String getAfterNumberPlate() {
        return afterNumberPlate;
    }

    public void setAfterNumberPlate(String afterNumberPlate) {
        this.afterNumberPlate = afterNumberPlate == null ? null : afterNumberPlate.trim();
    }

    public Byte getBeforeSpecialGive() {
        return beforeSpecialGive;
    }

    public void setBeforeSpecialGive(Byte beforeSpecialGive) {
        this.beforeSpecialGive = beforeSpecialGive;
    }

    public Byte getAfterSpecialGive() {
        return afterSpecialGive;
    }

    public void setAfterSpecialGive(Byte afterSpecialGive) {
        this.afterSpecialGive = afterSpecialGive;
    }

    public String getBeforePackagePriceId() {
        return beforePackagePriceId;
    }

    public void setBeforePackagePriceId(String beforePackagePriceId) {
        this.beforePackagePriceId = beforePackagePriceId == null ? null : beforePackagePriceId.trim();
    }

    public String getAfterPackagePriceId() {
        return afterPackagePriceId;
    }

    public void setAfterPackagePriceId(String afterPackagePriceId) {
        this.afterPackagePriceId = afterPackagePriceId == null ? null : afterPackagePriceId.trim();
    }

    public Byte getBeforeTransRegional() {
        return beforeTransRegional;
    }

    public void setBeforeTransRegional(Byte beforeTransRegional) {
        this.beforeTransRegional = beforeTransRegional;
    }

    public Byte getAfterTransRegional() {
        return afterTransRegional;
    }

    public void setAfterTransRegional(Byte afterTransRegional) {
        this.afterTransRegional = afterTransRegional;
    }

    public String getBeforeParentId() {
        return beforeParentId;
    }

    public void setBeforeParentId(String beforeParentId) {
        this.beforeParentId = beforeParentId == null ? null : beforeParentId.trim();
    }

    public String getAfterParentId() {
        return afterParentId;
    }

    public void setAfterParentId(String afterParentId) {
        this.afterParentId = afterParentId == null ? null : afterParentId.trim();
    }

    public String getBeforePhone() {
        return beforePhone;
    }

    public void setBeforePhone(String beforePhone) {
        this.beforePhone = beforePhone == null ? null : beforePhone.trim();
    }

    public String getAfterPhone() {
        return afterPhone;
    }

    public void setAfterPhone(String afterPhone) {
        this.afterPhone = afterPhone == null ? null : afterPhone.trim();
    }

    public String getBeforeMainCarParkId() {
        return beforeMainCarParkId;
    }

    public void setBeforeMainCarParkId(String beforeMainCarParkId) {
        this.beforeMainCarParkId = beforeMainCarParkId == null ? null : beforeMainCarParkId.trim();
    }

    public String getAfterMainCarParkId() {
        return afterMainCarParkId;
    }

    public void setAfterMainCarParkId(String afterMainCarParkId) {
        this.afterMainCarParkId = afterMainCarParkId == null ? null : afterMainCarParkId.trim();
    }

    public String getBeforeRemarks() {
        return beforeRemarks;
    }

    public void setBeforeRemarks(String beforeRemarks) {
        this.beforeRemarks = beforeRemarks == null ? null : beforeRemarks.trim();
    }

    public String getAfterRemarks() {
        return afterRemarks;
    }

    public void setAfterRemarks(String afterRemarks) {
        this.afterRemarks = afterRemarks == null ? null : afterRemarks.trim();
    }

    public String getBeforeCarOwnerName() {
        return beforeCarOwnerName;
    }

    public void setBeforeCarOwnerName(String beforeCarOwnerName) {
        this.beforeCarOwnerName = beforeCarOwnerName == null ? null : beforeCarOwnerName.trim();
    }

    public String getAfterCarOwnerName() {
        return afterCarOwnerName;
    }

    public void setAfterCarOwnerName(String afterCarOwnerName) {
        this.afterCarOwnerName = afterCarOwnerName == null ? null : afterCarOwnerName.trim();
    }

    public String getBeforeGroupFlag() {
        return beforeGroupFlag;
    }

    public void setBeforeGroupFlag(String beforeGroupFlag) {
        this.beforeGroupFlag = beforeGroupFlag == null ? null : beforeGroupFlag.trim();
    }

    public Byte getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(Byte beforeStatus) {
        this.beforeStatus = beforeStatus;
    }

    public Byte getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(Byte afterStatus) {
        this.afterStatus = afterStatus;
    }

    public String getHandleUid() {
        return handleUid;
    }

    public void setHandleUid(String handleUid) {
        this.handleUid = handleUid == null ? null : handleUid.trim();
    }

    public Long getActionTime() {
        return actionTime;
    }

    public void setActionTime(Long actionTime) {
        this.actionTime = actionTime;
    }

    public String getAfterGroupFlag() {
        return afterGroupFlag;
    }

    public void setAfterGroupFlag(String afterGroupFlag) {
        this.afterGroupFlag = afterGroupFlag == null ? null : afterGroupFlag.trim();
    }

    public String getHandleUserName() {
        return handleUserName;
    }

    public void setHandleUserName(String handleUserName) {
        this.handleUserName = handleUserName;
    }

    public String getBeforeCarParkName() {
        return beforeCarParkName;
    }

    public void setBeforeCarParkName(String beforeCarParkName) {
        this.beforeCarParkName = beforeCarParkName;
    }

    public String getAfterCarParkName() {
        return afterCarParkName;
    }

    public void setAfterCarParkName(String afterCarParkName) {
        this.afterCarParkName = afterCarParkName;
    }

    public String getBeforeTypeKeyName() {
        return beforeTypeKeyName;
    }

    public void setBeforeTypeKeyName(String beforeTypeKeyName) {
        this.beforeTypeKeyName = beforeTypeKeyName;
    }

    public String getAfterTypeKeyName() {
        return afterTypeKeyName;
    }

    public void setAfterTypeKeyName(String afterTypeKeyName) {
        this.afterTypeKeyName = afterTypeKeyName;
    }
}