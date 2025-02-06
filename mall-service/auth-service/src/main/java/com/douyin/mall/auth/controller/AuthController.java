package com.douyin.mall.auth.controller;

import com.douyin.mall.auth.service.AuthService;
import com.douyin.mall.auth.util.JwtUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/douyin/auth")
@Api(tags = "认证接口", description = "提供用户认证相关的 API，包括令牌生成、续期和验证等功能。")
public class AuthController {
    @Autowired
    private AuthService authService;

    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 当用户成功登录后，认证中心生成并分发令牌，供后续请求进行身份认证。
     * @param userId 用户ID
     * @return 包含生成的令牌的响应
     */
    @ApiOperation(value = "生成令牌", notes = "根据用户ID生成 JWT 令牌。")
    @PostMapping("/tokens")
    public Map<String, Object> generateToken(Integer userId) {
        log.info("Token generation request received for user_id: {}", userId);
        // 这里假设authService.authenticate可以根据userId进行认证
        if (authService.authenticate(userId)) {
            String token = jwtUtil.generateToken(userId.toString());
            Map<String, Object> response = new HashMap<>();
            response.put("Code", 200);
            response.put("Msg", "Success");
            Map<String, String> data = new HashMap<>();
            data.put("Token", token);
            response.put("Data", data);
            return response;
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("Code", 401);
            response.put("Msg", "Invalid credentials");
            return response;
        }
    }

    /**
     * 提供令牌续期功能，确保长期活动的用户无需频繁重新登录。
     * @param token 要续期的令牌
     * @return 包含新令牌的响应
     */
    @ApiOperation(value = "令牌续期", notes = "对有效的 JWT 令牌进行续期，生成新的令牌。")

    @PostMapping("/tokens/renew")
    public Map<String, Object> renewToken(String token) {
        if (jwtUtil.validateToken(token)) {
            String userId = jwtUtil.getUserIdFromToken(token);
            String newToken = jwtUtil.generateRefreshToken(userId);
            Map<String, Object> response = new HashMap<>();
            response.put("Code", 200);
            response.put("Msg", "Success");
            Map<String, String> data = new HashMap<>();
            data.put("Token", newToken);
            response.put("Data", data);
            return response;
        } else {
            Map<String, Object> response = new HashMap<>();
            response.put("Code", 401);
            response.put("Msg", "Invalid token");
            return response;
        }
    }

    /**
     * 验证用户提供的令牌是否有效，确保请求安全。
     * @param token 要验证的令牌
     * @return 包含验证结果的响应
     */
    @ApiOperation(value = "验证令牌", notes = "验证 JWT 令牌的有效性。")
    @PostMapping("/tokens/verify")
    public Map<String, Object> verifyToken(String token) {
        boolean isValid = jwtUtil.validateToken(token);
        Map<String, Object> response = new HashMap<>();
        response.put("Code", 200);
        response.put("Msg", "Success");
        Map<String, Boolean> data = new HashMap<>();
        data.put("Valid", isValid);
        response.put("Data", data);
        return response;
    }
}