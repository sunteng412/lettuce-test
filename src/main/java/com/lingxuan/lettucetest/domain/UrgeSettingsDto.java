package com.lingxuan.lettucetest.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

/**
 * @Description: zd-manager-web
 * @User: Cjs
 * @Time: 2020-11-10 19:04
 */
@Data
public class UrgeSettingsDto implements Serializable {
    private static final long serialVersionUID = 8175941345806568466L;

    /**
     * 任务主键id
     */
    private Long urgeSettingsId;

    /**
     * 任务名称
     */
    private String name;

    /**
     * 应用id
     */
    private Long appId;

    /**
     * 催发类型
     * 10智能催派 11预售催付 12催付提醒 13付款关怀 14核对地址 15发货提醒 16发货超时 17抵达同城 18派件提醒 19签收提醒 20 退款关怀 21催评提醒 22好评关怀
     */
    private Integer sendType;

    /**
     * 是否删除 true 删除，false未删除
     */
    private Boolean isDel;

    /**
     * 是否全部商品，true全部,false 指定商品
     */
    private Boolean isAllProduct;

    /**
     * 任务列表商品数量
     */
    private Long commodityCount;

    /**
     * 指定商品类别数量
     */
    private Long categoryCount;

    /**
     * 属性知识列表数量
     */
    private Long attrCount;

    /**
     * 指定商品列表
     */
    private List<String> commodityIds;

    /**
     * 指定商品Sku列表
     */
    private List<String> commoditySkuIds;

    /**
     * 指定商品（包含sku）
     */
    private List<CommodityVo> commodityVos;

    /**
     * 安全库存Vo
     */
    private SafeStockVo safeStockVo;

    /**
     * 指定商品类别
     */
    private List<String> sellerCatIds;

    /**
     * 具体属性知识列表
     */
    private List<UrgeSettingsAttrDo> relationProductItems;

    /**
     * 任务绑定类型 0：所有商品 1：指定商品 2：商品类别 3：商品属性
     */
    private Integer bindType;

    /**
     * 第一次发送时间：任务发生时间与第一次催发时间间隔，分钟为单位
     */
    private Integer firstSendTime;

    /**
     * 是否开启第二次发送0不开启1开启，默认不开启
     */
    private Boolean isSecondSend;

    /**
     * 第二次发送时间：第一次催发时间与第二次催发时间间隔，分钟为单位
     */
    private Integer secondSendTime;

    /**
     * 是否开启第三次发送0不开启1开启，默认不开启
     */
    private Boolean isThirdSend;

    /**
     * 第三次发送时间：第二次催发时间与第三次催发时间间隔，分钟为单位
     */
    private Integer thirdSendTime;

    /**
     * 第一次话术(列表页 会使用此字段展示)
     */
    private String firstMessage;

    /**
     * 第二次话术
     */
    private String secondMessage;

    /**
     * 第三次话术
     */
    private String thirdMessage;

    /**
     * 指定时间段开始时间
     */
    private LocalTime appointedStartTime;

    /**
     * 指定时间段开始时间
     */
    private LocalTime appointedEndTime;

    /**
     * 第一次话术
     */
    private UrgeMsg firstMsg = new UrgeMsg();

    /**
     * 第二次话术
     */
    private UrgeMsg secondMsg = new UrgeMsg();

    /**
     * 第三次话术
     */
    private UrgeMsg thirdMsg = new UrgeMsg();

    /**
     * 0随机
     * 1指定客服组
     * 2优先接待
     */
    private int sender;

    /**
     * 客服组id
     */
    private Long qnGroupId;


    /**
     * 是否过滤黑名单 true开启开关 false不开启开关
     */
    private Boolean isSkipBlacklist;

    /**
     * 多笔订单过滤 true开启开关 false不开启开关
     */
    private Boolean isSkipMoreOrder;

    /**
     * 是否过滤关键词， true开启开关 false 不开启开关
     */
    private Boolean isSkipKeyword = false;

    /**
     * 节点关键词，以逗号分割
     */
    private String nodeKeyword;

    /**
     * 全局关键词，以逗号分割
     */
    private String globalKeyword;

    /**
     * 用户群体
     */
    private Integer customerGroups;

    /**
     * 是否过滤售后买家 true开启开关 false不开启开关
     */
    private Boolean isSkipAfterSale;

    /**
     * 满足X天内下单并成功付款，且有售后意图
     */
    private Integer afterSaleDays;

    /**
     * 是否过滤恶意买家 true开启开关 false不开启开关
     */
    private Boolean isSkipBadSeller;

    /**
     * 是否过滤同一用户最大催单次数 true开启开关 false不开启开关
     */
    private Boolean isSkipMaxUrge;

    /**
     * 是否过滤同一用户最大催单次数 时间间隔
     */
    private Integer skipMaxUrgeTime;

    /**
     * 同一用户一天最多催单次数 默认1次
     */
    private Integer maxUrgeTime;

    /**
     * 是否过滤转出后没有人/机器人接待的买家 true开启开关 false不开启开关
     */
    private Boolean isSkipTransferNoserve;

    /**
     * 是否过滤没有人/机器人接待的买家 true开启开关 false不开启开关
     */
    private Boolean isSkipNoserve;

    /**
     * 是否过滤转出给没有使用智小点客服账号 true开启开关 false不开启开关
     */
    private Boolean isSkipTransferNonZd;

    /**
     * 备注
     */
    private String des;

    /**
     * 催付类型
     * 0:催付订金
     * 1:催付尾款
     */
    private Integer urgeType;

    /**
     * 实付金额最小值
     */
    private Double divideOrderFeeMin;

    /**
     * 实付金额最大值
     */
    private Double divideOrderFeeMax;

    /**
     * 备注旗帜类型
     */
    private String rateFlag;

    /**
     * 是否开启 true开启，false未开启
     */
    private Boolean state;

    /**
     * 退款类型，逗号分隔'
     * 1.仅退款 2.退货退款 3.未发货仅退款 4.已发货仅退款
     */
    private String refundType;

    /**
     * 退款原因，默认全部理由
     */
    private Boolean refundReasonType;

    /**
     * 具体退款原因,用逗号分隔
     */
    private String refundReason;

    /**
     * 评价类型，默认全部评价
     */
    private Boolean buyerRateType;

    /**
     * 评价详情，逗号分隔
     * 好评 good
     * 中评 middle
     * 差评 bad
     */
    private String buyerRateDetail;

    /**
     * 订单关闭类型,逗号分隔
     * 1: 订单未付款取消 TRADE_CLOSED_BY_TAOBAO
     * 2: 订单付款后关闭 TRADE_CLOSED
     */
    private String closedType;

    /**
     * 催拍接待判断
     * false 不开启,默认
     * true 开启
     */
    private Boolean isReception;

    /**
     * 转交判断
     *  false 不开启，默认
     *  true  开启
     */
    private Boolean isForward;

    /**
     * 买家介入后不再发送
     */
    private Boolean buyerInterposeNotSend;

    /**
     * 排序
     */
    private Integer sortNum;

    /**
     * 生效时间
     */
    private ApplyTime applyTime;

    /**
     * 当前消息包含的商品变量列表
     */
    private List<InnerVarDto> innerVarLists;

    /**
     * 用于尾款催付 催拍该时间段内付完定金的预售订单-开始
     * */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date urgeFrontTimeStart;

    /**
     * 用于尾款催付 催拍该时间段内付完定金的预售订单-结束
     * */
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone="GMT+8")
    private Date urgeFrontTimeEnd;

    /**
     * 新版消息内容配置
     */
    private String taskNodeConfig;

    /**
     * 消息保留
     */
    private Boolean isSaveMsg = Boolean.FALSE;

    /**
     * 拆包消息,部分发货通知
     */
    private String tradePartlySellerShipMsg;

    /**
     * 拆包消息,全部发货通知
     */
    private String tradeAllSellerShipMsg;

    /**
     * 拆包消息,部分发货通知pic
     */
    private String tradePartlySellerShipMsgPicUrl;

    /**
     * 拆包消息,全部发货通知pic
     */
    private String tradeAllSellerShipMsgPicUrl;

    /**
     *拆包消息,部分发货通知鲸奇
     */
    private String tradePartlySellerShipMsgJqUrlLabel;

    /**
     *拆包消息,全部发货通知鲸奇
     */
    private String tradeAllSellerShipMsgJqUrlLabel;

    /**
     * 订单备注符号
     */
    private String orderNotesSymbol;

    /**
     * 是否过滤同一用户最大催单次数 时间单位 1 2 3 分 小时 天
     */
    private Integer skipMaxUrgeTimeUnit;
}
