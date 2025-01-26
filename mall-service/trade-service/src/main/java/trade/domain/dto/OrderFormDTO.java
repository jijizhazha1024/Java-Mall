package trade.domain.dto;

import lombok.Data;

import java.util.List;

@Data
public class OrderFormDTO {
    /**
     * 收货地址id
     */
    private Long deliveryAddressId;
    /**
     * 支付方式
     */
    private Integer paymentType;
    /**
     * 订单详情
     */
    private List<OrderDetailDTO> orderDetails;
}
