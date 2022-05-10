package com.idreamsky.fanbook.sdk.http;

import lombok.Data;

import java.util.Map;

/**
 * @author peng.gan
 */
@Data
public class HttpRequest {

    private String url;

    private HttpMethodType httpMethodType;

    private Map<String, String> headers;

    private String body;

    private Map<String, String> uriVariables;

}
