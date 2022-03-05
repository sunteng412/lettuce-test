package com.lingxuan.lettucetest.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Description: zd-manager-web
 * @User: Cjs
 * @Time: 2020-11-10 19:06
 */
@Data
public class CommodityVo implements Serializable {

    private static final long serialVersionUID = -3521419103136311325L;

    /**
     * 指定商品Id
     */
    private String commodityId;

    /**
     * 指定商品SKU列表
     */
    private List<String> skuIds;

}
