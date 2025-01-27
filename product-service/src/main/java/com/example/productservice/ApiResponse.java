package com.example.productservice;

import java.util.Map;

/**
 * 通用的 API 响应实体类，用于封装接口的响应信息，方便统一处理和返回结果。
 */
public class ApiResponse {
    private int code; // 响应状态码，用于标识请求处理结果的状态
    private String msg; // 响应消息，提供关于请求处理结果的简要描述
    private Map<String, Object> data; // 响应数据，存储具体的业务数据

    // Getters 和 Setters 方法
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}