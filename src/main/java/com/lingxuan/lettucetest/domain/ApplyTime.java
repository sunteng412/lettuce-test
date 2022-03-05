//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.lingxuan.lettucetest.domain;

import java.io.Serializable;
import java.util.Date;

public class ApplyTime implements Serializable {
    private Integer applyTimeId;
    private String name;
    private Integer appId;
    private String businessId;
    private Date startTime;
    private Date endTime;
    private Integer createUserId;
    private Integer isDel;
    private Integer isVaild;
    private Date insertTime;
    private Date updateTime;
    private Integer isEffect;
    private String type;
    private String time;

    public ApplyTime() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return this.time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getApplyTimeId() {
        return this.applyTimeId;
    }

    public void setApplyTimeId(Integer applyTimeId) {
        this.applyTimeId = applyTimeId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAppId() {
        return this.appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getBusinessId() {
        return this.businessId;
    }

    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    public Date getStartTime() {
        return this.startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return this.endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Integer getCreateUserId() {
        return this.createUserId;
    }

    public void setCreateUserId(Integer createUserId) {
        this.createUserId = createUserId;
    }

    public Integer getIsDel() {
        return this.isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsVaild() {
        return this.isVaild;
    }

    public void setIsVaild(Integer isVaild) {
        this.isVaild = isVaild;
    }

    public Date getInsertTime() {
        return this.insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }

    public Date getUpdateTime() {
        return this.updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsEffect() {
        return this.isEffect;
    }

    public void setIsEffect(Integer isEffect) {
        this.isEffect = isEffect;
    }
}
