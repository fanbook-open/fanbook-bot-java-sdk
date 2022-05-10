package com.idreamsky.fanbook.sdk.http;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 通用的接口响应类
 *
 * @author peng.gan
 */
@Data
public class HttpResponse {

    /**
     * http状态码
     */
    private int status;

    /**
     * 请求头
     */
    protected Map<String, String> headers = new HashMap<String, String>();

    /**
     * http response boy
     */
    private String responseBody;
}
