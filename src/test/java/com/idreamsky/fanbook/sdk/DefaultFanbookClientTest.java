package com.idreamsky.fanbook.sdk;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.http.HttpMethodType;
import com.idreamsky.fanbook.sdk.http.HttpResponse;
import com.idreamsky.fanbook.sdk.model.ApiResponse;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import org.junit.Test;

import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class DefaultFanbookClientTest {
    BotMethod botMethod = new BotMethod() {
        @Override
        public void validate() throws BotArgumentException {
            ;
        }


        /**
         * 获取接口的端点
         *
         * @return string
         */
        @Override
        protected String getEndpoint() {
            return "getMe";
        }

        @Override
        protected HttpMethodType getHttpMethodType() {
            return HttpMethodType.GET;
        }

        @Override
        public Serializable parseResponse(String responseBody) {
            Type fluentType = new TypeToken<ApiResponse<HashMap>>() {
            }.getType();
            ApiResponse<Map> apiResponse = gson.fromJson(responseBody, fluentType);
            if (null != apiResponse && null != apiResponse.getOk() && apiResponse.getOk()) {
                return (Serializable) apiResponse.getResult();
            } else {
                throw new BotApiRequestException(apiResponse.getErrorCode(), apiResponse.getDescription());
            }
        }
    };

    @Test
    public void testClient() {
        ClientProfile clientProfile = ClientProfile.getDefaultProfile();
        clientProfile.setBotToken("f2da539e8bb6db83073eec155809e449adfdaee4a3d012750c6aa3b8beb6d1d48d64ff6092879c88536af3e53249d61f");
        IFanbookBotClient client = new DefaultFanbookBotClient(clientProfile);
        HttpResponse invoke = client.invoke(botMethod);
        Object botResponse = client.getBotResponse(botMethod);
        System.out.println(new Gson().toJson(invoke));
    }




}