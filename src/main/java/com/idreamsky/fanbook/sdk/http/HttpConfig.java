package com.idreamsky.fanbook.sdk.http;

import lombok.Data;

/**
 * http请求参数配置项
 *
 * @author peng.gan
 */
@Data
public class HttpConfig {

    private int connectTimeout = 10000;

    private int socketTimeout = 20000;

    private int maxConn = 128;

    private int maxRoute = 5;

    private int maxIdleTimeMillis = 60 * 1000;

    private int maxRetryCount = 3;

}
