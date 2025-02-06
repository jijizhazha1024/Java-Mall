package trade.client;


import org.springframework.web.bind.annotation.*;
import trade.domain.dto.OrderFormDTO;
import trade.domain.pojo.Order;
import utils.Result;

@FeignClient(name="order-service")
public interface OrderClient {
    /**
     * 创建订单接口
     */
    @PostMapping
     Result createOrder(@RequestBody OrderFormDTO orderFormDTO);
    /**
     * 获取订单接口
     */
    @GetMapping("{/id}")
     Result getOrderById(@PathVariable Long id);
    /**
     * 标记订单已支付
     */
    @PutMapping("{/id}")
     Result markOrderPaid(@PathVariable Long id);
    /**
     * 更新订单接口
     */
    @PutMapping
     Result updateOrder(@RequestBody Order order);
    /**
     * 超时订单取消接口
     */
    @PostMapping ("/timeCancel")
     Result timeoutCancel(@RequestParam Long id);
}
