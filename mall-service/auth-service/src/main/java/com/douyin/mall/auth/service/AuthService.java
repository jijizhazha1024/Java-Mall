package com.douyin.mall.auth.service;

import org.springframework.stereotype.Service;

@Service
public class AuthService {
    // 模拟用户登录验证，实际应调用用户服务进行验证
    public boolean authenticate(double userId) {
        // 简单示例，假设用户id是0时验证通过
        return userId == 0;
    }
}