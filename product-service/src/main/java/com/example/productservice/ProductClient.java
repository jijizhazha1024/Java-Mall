package com.example.productservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * 商品服务的 Feign 客户端接口，使用 Spring Cloud OpenFeign 实现对商品服务 API 的调用。
 */
@FeignClient(name = "product-service")
public interface ProductClient {
    /**
     * 创建商品的接口方法。
     * 管理员可通过此方法在系统中添加新商品。
     * @param product 包含商品详细信息的实体对象，通过请求体传递
     * @return 封装了响应信息的 ApiResponse 对象
     */
    @PostMapping("/douyin/products")
    ApiResponse createProduct(@RequestBody Product product);

    /**
     * 修改商品信息的接口方法。
     * 管理员可使用此方法更新商品的相关信息。
     * @param id 要修改的商品的 ID，通过路径变量传递
     * @param product 包含要更新的商品信息的实体对象，通过请求体传递
     * @return 封装了响应信息的 ApiResponse 对象
     */
    @PutMapping("/douyin/products/{id}")
    ApiResponse updateProduct(@PathVariable("id") Integer id, @RequestBody Product product);

    /**
     * 删除商品的接口方法。
     * 用于删除不再销售或存在的商品。
     * @param id 要删除的商品的 ID，通过路径变量传递
     * @return 封装了响应信息的 ApiResponse 对象
     */
    @DeleteMapping("/douyin/products/{id}")
    ApiResponse deleteProduct(@PathVariable("id") Integer id);

    /**
     * 查询商品信息的接口方法。
     * 用户或管理员可通过此方法获取单个商品的详细信息。
     * @param id 要查询的商品的 ID，通过路径变量传递
     * @return 封装了响应信息的 ApiResponse 对象
     */
    @GetMapping("/douyin/products/{id}")
    ApiResponse getProduct(@PathVariable("id") Integer id);
}