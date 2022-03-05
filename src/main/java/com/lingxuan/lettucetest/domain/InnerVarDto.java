package com.lingxuan.lettucetest.domain;

import lombok.Data;


@Data
public class InnerVarDto {

    /**
     * 变量编码：用于替换句子中的varDisplayCode，然后传输给后端的
     */
    private String varCode;

    /**
     * 变量显示编码:后端处理过后返回给前端的格式
     */
    private String varDisplayCode;

    /**
     * 原始的编码
     */
    private String code;

    /**
     * 变量名称
     */
    private String varName;

    /**
     * 变量类型编码
     */
    private String varTypeCode;

    /**
     * 变量类型名称
     */
    private String varTypeName;

    /**
     * 老数据中的类型： a、b
     */
    private String type;

    /**
     * 是否是老数据 得到的配置参数
     */
    private Boolean isOld;

    /**
     * 是否有效
     */
    private Boolean isValid = Boolean.TRUE;
}
