package com.douyin.mall.auth.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient("auth-service")
public interface AuthClient {

    /**
     * 生成令牌
     * @param userId 用户 ID
     * @return 包含生成的令牌的响应
     */
    @PostMapping("/tokens")
    Map<String, Object> generateToken(@RequestParam("userId") Integer userId);

    /**
     * 令牌续期
     * @param token 要续期的令牌
     * @return 包含新令牌的响应
     */
    @PostMapping("/tokens/renew")
    Map<String, Object> renewToken(@RequestParam("token") String token);

    /**
     * 验证令牌
     * @param token 要验证的令牌
     * @return 包含验证结果的响应
     */
    @PostMapping("/tokens/verify")
    Map<String, Object> verifyToken(@RequestParam("token") String token);
}
