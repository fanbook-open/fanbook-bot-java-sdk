package com.idreamsky.fanbook.sdk;

import com.idreamsky.fanbook.sdk.oauth2.api.v20220429.GetMeApi;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClients;
import org.junit.Test;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/**
 * @author: peng.gan
 * @description:
 * @date: 2022/11/28 10:14
 * @version: 1.0
 */
@Slf4j
public class FtTest {
    CloseableHttpAsyncClient httpAsyncClient = HttpAsyncClients.createDefault();


    @Test
    public void test() throws ExecutionException, InterruptedException {

    }

}
