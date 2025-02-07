package com.douyin.mall.auth.controller;

import com.douyin.mall.auth.service.AuthService;
import com.douyin.mall.auth.util.ErrorCode;
import com.douyin.mall.auth.util.JwtUtil;
import com.douyin.mall.auth.util.Result;
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
    public Result generateToken(Integer userId) {
        log.info("Token generation request received for user_id: {}", userId);

        if(userId == null){
            return Result.error(ErrorCode.AUTH_INFO_EMPTY); //认证信息为空
        }

        String token = jwtUtil.generateToken(userId.toString());
        Map<String, String> data = new HashMap<>();
        data.put("Token", token);

        return Result.success(data);
    }

    /**
     * 提供令牌续期功能，确保长期活动的用户无需频繁重新登录。
     * @param token 要续期的令牌
     * @return 包含新令牌的响应
     */
    @ApiOperation(value = "令牌续期", notes = "对有效的 JWT 令牌进行续期，生成新的令牌。")
    @PostMapping("/tokens/renew")
    public Result renewToken(String token) {
        if(token == null || token.isEmpty()){
            return Result.error(ErrorCode.TOKEN_EXPIRED_OR_NOT_EXIST); //令牌过期或不存在
        }

        if (jwtUtil.validateToken(token)) {
            String userId = jwtUtil.getUserIdFromToken(token);
            String newToken = jwtUtil.generateRefreshToken(userId);
            Map<String, String> data = new HashMap<>();
            data.put("Token", newToken);
            return Result.success(data);
        } else {
            return Result.error(ErrorCode.TOKEN_RENEWAL_FAILED); //令牌续期失败
        }
    }

    /**
     * 验证用户提供的令牌是否有效，确保请求安全。
     * @param token 要验证的令牌
     * @return 包含验证结果的响应
     */
    @ApiOperation(value = "验证令牌", notes = "验证 JWT 令牌的有效性。")
    @PostMapping("/tokens/verify")
    public Result verifyToken(String token) {
        if(token == null || token.isEmpty()){
            return Result.error(ErrorCode.TOKEN_EXPIRED_OR_NOT_EXIST);
        }

        boolean isValid = jwtUtil.validateToken(token);
        Map<String, Boolean> data = new HashMap<>();
        data.put("Valid", isValid);

        if(!isValid){
            return Result.error(ErrorCode.TOKEN_INVALID); //令牌无效
        }

        return Result.success(data);
    }
}