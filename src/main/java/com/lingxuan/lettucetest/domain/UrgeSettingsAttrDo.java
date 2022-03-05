package com.lingxuan.lettucetest.domain;

import lombok.Data;

import java.io.Serializable;

@Data
public class UrgeSettingsAttrDo implements Serializable {

    private static final long serialVersionUID = -2726114295781050463L;
    /**
     * 主键id
     */
    private Long id;

    /**
     * 任务主键id
     */
    private Long urgeSettingsId;

    /**
     * 属性中文名
     */
    private String itemNameCn;

    /**
     * 属性英文名
     */
    private String itemNameEn;

    /**
     * 操作符
     */
    private String op;

    /**
     * 目标属性值
     */
    private String itemValues;

}