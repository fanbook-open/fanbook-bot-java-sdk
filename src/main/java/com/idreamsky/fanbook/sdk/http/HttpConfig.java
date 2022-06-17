package com.idreamsky.fanbook.sdk.http;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * http请求参数配置项
 *
 * @author peng.gan
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HttpConfig {

    private int connectTimeout = 10000;

    private int socketTimeout = 20000;

    private int maxConn = 128;

    private int maxRoute = 5;

    private int maxIdleTimeMillis = 60 * 1000;

    private int maxRetryCount = 3;

}
