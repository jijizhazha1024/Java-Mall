package trade.domain.pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("order")
public class Order {
    /**
     * 自动生成分布式系统中唯一的主键id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 订单总金额,单位：分
     */
    private Integer totalFee;
    /**
     * 用户id
     */
    private Long userId;
    /**
     * 支付方式：1.支付宝2.微信3.余额
     */
    private Integer paymentType;
    /**
     * 订单状态：1、未付款 2、已付款,未发货 3、已发货,未确认 4、确认收货，交易成功 5、交易取消，订单关闭 6、交易结束，已评价
     */
    private Integer status;
    /**
     * 订单创建时间
     */
    private LocalDateTime createTime;
    /**
     * 订单更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 订单评论的时间
     */
    private LocalDateTime commonTime;
    /**
     * 支付时间
     */
    private LocalDateTime payTime;
    /**
     * 发货时间
     */
    private LocalDateTime consingTime;
    /**
     *  交易完成时间
     */
    private LocalDateTime endTime;
    /**
     * 交易关闭时间
     */
    private LocalDateTime closeTime;
}
