package com.lingxuan.lettucetest.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @Description:
 * @User: mfg
 * @Time: 2020-11-10 19:06
 */
@Data
public class SafeStockVo implements Serializable {

    private static final long serialVersionUID = -6148718560747438663L;

    /**
     * 是否开启安全库存
     */
    private Boolean isOpen;

    /**
     * 安全库存条件（大于，等于，小于） 0 1 2
     */
    private Integer op;

    /**
     * 安全库存数量
     */
    private Integer num;
}
