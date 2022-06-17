package com.idreamsky.fanbook.sdk;

import com.google.gson.Gson;
import com.idreamsky.fanbook.sdk.oauth2.api.v20220429.*;
import com.idreamsky.fanbook.sdk.oauth2.model.v20220429.*;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

@Slf4j
public class Oauth2ApiTest {

    private ClientProfile clientProfile;

    private IFanbookBotClient fanbookClient;

    @Before
    public void init() {
        clientProfile = ClientProfile.getDefaultProfile();
        clientProfile.setBotToken("ba6631a9cdd9846043654ec1f7ec0629fc2970a737bdc9ef40d66db051561f7a2832f0492be28e6a68d3a070ca6df253");
        clientProfile.setClientKey("358192862334160896");
        clientProfile.setClientSecret("unwnFs7BFieqb1Gntjh36llQp1cWiN3w");
        clientProfile.setBotId(358193373657432064L);
        fanbookClient = new DefaultFanbookBotClient(clientProfile);
    }

    @Test
    public void testGetToken() {
        GetTokenApi getTokenApi = new GetTokenApi();
        getTokenApi.setCode("u8kmwLKM75pJ4jzURE0cGA==");
        getTokenApi.setRedirectUri("http://127.0.0.1:2036/#/oauth");
        TokenResponse apiResponse = fanbookClient.getBotResponse(getTokenApi);
        log.info("apiResponse:{}", new Gson().toJson(apiResponse));
    }

    @Test
    public void testAuthorizeApi() {
        AuthorizeApi authorizeApi = new AuthorizeApi();
        authorizeApi.setAllow("true");
        authorizeApi.setClientId("356994553305239552");
        authorizeApi.setStatusCode("200");
        authorizeApi.setState("1");
        String botResponse = fanbookClient.getBotResponse(authorizeApi);
        log.info("apiResponse:{}", botResponse);
    }

    @Test
    public void testAppApi() {
        AppApi appApi = new AppApi();
        appApi.addAuthorization("c912b6f823d925c25d14e8855c04ef5b4b2cd3b71c78476fdd6af1f67f50b170a8d82f93620d5ab113c6f3cb7e42c145e5b23ad503263afe192948ef5a8efb2865675c56a3e4b445e6a4f86387842315a080cb2a7528754f82f66efcd8161c44");
        AppResponse botResponse = fanbookClient.getBotResponse(appApi);
        log.info("apiResponse:{}", botResponse);
    }

    @Test
    public void testSendCodeApi() {
        SendCodeApi sendCodeApi = new SendCodeApi();
        sendCodeApi.setDevice("ios");
        sendCodeApi.setMobile("18712341234");
        SendCodeResponse botResponse = fanbookClient.getBotResponse(sendCodeApi);
        log.info("apiResponse:{}", botResponse);
    }


    @Test
    public void testLoginApi() {
        LoginApi loginApi = new LoginApi();
        loginApi.setDevice("ios");
        loginApi.setMobile("18712341234");
        loginApi.setCode("525770");
        UserResponse botResponse = fanbookClient.getBotResponse(loginApi);
        log.info("apiResponse:{}", botResponse);
    }

    @Test
    public void testGetMeApi() {
        GetMeApi getMeApi = new GetMeApi();
        getMeApi.setAccessToken("L67hN7rHRiB/2UAcg603OQ==");
        UserResponse botResponse = fanbookClient.getBotResponse(getMeApi);
        log.info("apiResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testGetGuildsApi() {
        GetGuildsApi getGuildsApi = new GetGuildsApi();
        getGuildsApi.setAccessToken("Cxg/MxV9V8K5FR71HItwKA==");
        GuildsResponse botResponse = fanbookClient.getBotResponse(getGuildsApi);
        log.info("apiResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testLinkApi() {
        LinkApi linkApi = new LinkApi();
        linkApi.setAccessToken("bdrA4mDYm9lpJAbUxrrWog==");
        LinkResponse botResponse = fanbookClient.getBotResponse(linkApi);
        log.info("apiResponse:{}", new Gson().toJson(botResponse));
    }

    @Test
    public void testInviteCodeApi(){
        InviteCodeApi inviteCodeApi = InviteCodeApi.builder().c("3NDh5FIi").build();
        InviteCodeResponse botResponse = fanbookClient.getBotResponse(inviteCodeApi);
        log.info("apiResponse:{}", new Gson().toJson(botResponse));
    }
}
