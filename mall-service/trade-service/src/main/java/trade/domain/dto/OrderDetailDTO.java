package trade.domain.dto;

import lombok.Data;

@Data
public class OrderDetailDTO {
    /**
     * 商品id
     */
    private Long itemId;
    /**
     * 商品购买数量
     */
    private Integer num;
}
