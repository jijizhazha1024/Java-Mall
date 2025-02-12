package com.douyin.mall.auth.util;

import lombok.Getter;

@Getter
public enum ErrorCode {
    AUTH_INFO_EMPTY(10000L, "认证信息为空"),
    TOKEN_EXPIRED_OR_NOT_EXIST(10001L, "令牌过期或不存在"),
    TOKEN_DISTRIBUTION_FAILED(10003L, "身份令牌分发失败"),
    TOKEN_RENEWAL_FAILED(10005L, "令牌续期失败"),
    TOKEN_INVALID(10007L, "令牌无效");

    private final Long code; // 错误码

    private final String msg; // 错误信息

    ErrorCode(Long code,String msg){
        this.code = code;
        this.msg = msg;
    }
}
