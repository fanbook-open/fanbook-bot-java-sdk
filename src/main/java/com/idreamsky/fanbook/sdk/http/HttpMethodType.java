package com.idreamsky.fanbook.sdk.http;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum HttpMethodType {
    /**
     * GET
     * PUT
     * POST
     * DELETE
     * HEAD
     * OPTIONS
     */
    GET(),
    PUT(),
    POST(),
    DELETE(),
    HEAD(),
    OPTIONS();
}
