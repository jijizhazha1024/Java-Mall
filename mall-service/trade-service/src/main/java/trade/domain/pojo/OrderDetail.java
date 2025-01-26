package trade.domain.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@TableName("order_detail")
public class OrderDetail {
    /**
     * 订单详情id
     */
    @TableId(value = "id", type = IdType.ASSIGN_ID)
    private Long id;
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 订单id
     */
    private Long orderId;
    /**
     * 购买数量
     */
    private Integer num;
    /**
     * 商品标题
     */
    private String title;
    /**
     * 商品规格,如颜色，尺寸等
     */
    private String spec;
    /**
     * 商品图片
     */
    private String img;
    /**
     * 商品价格
     */
    private Integer price;
    /**
     * 创建时间
     */
    private LocalDateTime createTime;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
