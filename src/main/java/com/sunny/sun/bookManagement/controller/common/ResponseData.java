package com.sunny.sun.bookManagement.controller.common;

import java.util.HashMap;
import java.util.Map;

/**
 * 接口响应类
 */
public class ResponseData {
    private int code;
    private int count;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    public ResponseData() {

    }

    private ResponseData(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public ResponseData putDataValue(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public static ResponseData ok() {
        return new ResponseData(200, "Ok");
    }

    public static ResponseData notFound() {
        return new ResponseData(404, "Not Found");
    }

    public static ResponseData badRequest() {
        return new ResponseData(400, "Bad Request");
    }

    public static ResponseData forbidden() {
        return new ResponseData(403, "Forbidden");
    }

    public static ResponseData unAuthorized() {
        return new ResponseData(401, "UnAuthorized");
    }

    public static ResponseData expired() {
        return new ResponseData(405, "Token Expired");
    }

    public static ResponseData unCorrectUserId() {
        return new ResponseData(406, "UnCorrectUserId");
    }

    public static ResponseData unCorrectName() {
        return new ResponseData(407, "UnCorrectName");
    }

    public static ResponseData loginFail() {
        return new ResponseData(408, "LoginFail");
    }

    public static ResponseData uploadFail() {
        return new ResponseData(409, "UploadFail");
    }

    public static ResponseData invokeWechatApiFail() {
        return new ResponseData(410, "调用微信接口获取信息失败");
    }


    public static ResponseData serverInternalError() {
        return new ResponseData(500, "Server Internal Error");
    }

    public static ResponseData customerError() {
        return new ResponseData(1001, "Customer Error");
    }

    @Override
    public String toString() {
        return "ResponseData{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
