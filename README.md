Fanbook Bot SDK

Fanbook Bot SDK基于[Fanbook开发文档](https://open.fanbook.mobi/document/manage/doc/)，封装了包含Oauth2.0 API、Bot API等开放接口的Java集成开发工具包。SDK内部提供了一些简单的工具类，并加入了网络异常重试处理机制，能够简化部分Fanbook bot的开发流程。



## 更新日志

| 版本  | 更新日期 | 作者  | 变更记录 |
| --- | --- | --- | --- |
| 0.0.1 | 2022-05-09 | peng.gan | 第一个版本的Fanbook Bot Java SDK。包含大部分常用的Bot API和Oauth2 API。 |
| 0.0.2.RELEASE | 2022-05-18 | peng.gan | 新增两个频道接口 |
| 0.0.3.RELEASE | 2022-05-24 | peng.gan | 修正错误 |
| 0.0.4.RELEASE | 2022-06-14 | peng.gan | GuildRole新增多个字段；修改部分接口路径错误的bug |
| 0.0.5.RELEASE | 2022-06-15 | peng.gan | channel增加对象;修改部分接口路径错误的bug |
| 0.0.6.RELEASE | 2022-06-16 | peng.gan | 增加修改频道接口;接口实现构造模式 |
| 0.0.7.RELEASE | 2022-06-17 | peng.gan | Update对象增加多个Java Bean |
| 0.0.8.RELEASE | 2022-06-21 | peng.gan | 新增DeleteChannelMethod和ExistsMemberMethod接口 |
| 0.0.9.RELEASE | 2022-06-21 | peng.gan | Message对象新增三个圈子相关变量;UpdateUtil增加枚举类型 |
| 0.1.1.RELEASE | 2022-07-01 | peng.gan | Fanbook接口异常打印Error级别日志 |
| 0.1.3.RELEASE | 2022-07-01 | peng.gan | GetUpdates接口单独使用长轮询线程池，默认设置timeOut=60s |
| 0.1.4.RELEASE | 2022-08-18 | peng.gan | GetUpdates接口单独使用增加interactionMessageCardOperation字段；新增SearchGuildMemberByNameMethod接口; |
| 0.1.5.RELEASE | 2022-08-23 | peng.gan | 引入resilience4j的熔断器组件，用于保护内部应用安全；修改http config的默认超时时间；|

## 引入工具包

Maven GAV
```
<dependency>
    <groupId>io.github.fanbook-open</groupId>
    <artifactId>fanbook-bot-sdk</artifactId>
    <version>${latest.version}</version>
</dependency>
```

自行编译源码

```
git clone https://github.com/fanbook-open/fanbook-bot-java-sdk.git
cd fanbook-bot-java-sdk
mvn clean package -Dmaven.test.skip=true
```

## 使用样例

1. 初始化Fanbook Bot Clientlient

```
    ClientProfile clientProfile = ClientProfile.getDefaultProfile();
    clientProfile.setClientKey(clientID);
    clientProfile.setClientSecret(clientSecret);
    clientProfile.setBotToken(botToken);
    clientProfile.setBotId(botId));
    IFanbookBotClient client = new DefaultFanbookBotClient(clientProfile);
    return client;
```

2. Oauth2 API使用
   Oauth2 API工具类通常是以API为结尾的类。

```
    @Autowired
    private IFanbookBotClient fanbookBotClient;

    public TokenResponse getToken(String code) {
        GetTokenApi getTokenApi = new GetTokenApi();
        getTokenApi.setRedirectUri(redirectUri);
        getTokenApi.setCode(code);
        TokenResponse botResponse = fanbookBotClient.getBotResponse(getTokenApi);
        return botResponse;
    }

    public UserResponse getMe(String token) {
        GetMeApi getMeApi = new GetMeApi();
        getMeApi.setAccessToken(token);
        UserResponse botResponse = fanbookBotClient.getBotResponse(getMeApi);
        return botResponse;
    }
```

3. Fanbook Bot API使用
   Bot API工具类通常是以Method结尾的类。

```
    @Test
    public void testGetUpdates() {
        GetUpdatesMethod getUpdatesMethod = new GetUpdatesMethod();
        ArrayList<Update> botResponse = fanbookBotClient.getBotResponse(getUpdatesMethod);
        log.info("info:{}", botResponse);
        log.info("group:{}", UpdateUtil.messageGroup(botResponse));
    }
```

##

## 功能扩展

1. 接口扩展

由于开发平台版本迭代较快，SDK版本会出现滞后发布的场景。因此，开发者可以自行定义或修改SDK中旧版本的Bot API。

如果需要定义的Fanbook API是Bot风格的，可以通过实现“BotMethod”抽象类和自定义响应实体类来完成。

如果需要定义的Fanbook API是Restful风格，可以通过实现“FanbookRestfulApi”抽象类和自定义响应实体类完成。

2. 客户端 HTTP Client参数修改

开发者可以通过设置HttpConfig的参数，修改连接超时、读超时和连接池大小等参数。

```
        ClientProfile clientProfile = ClientProfile.getDefaultProfile();
        clientProfile.setClientKey(clientID);
        clientProfile.setClientSecret(clientSecret);
        clientProfile.setBotToken(botToken);
        clientProfile.setBotId(Long.valueOf(botId));
        com.idreamsky.fanbook.sdk.http.HttpConfig httpConfig = new com.idreamsky.fanbook.sdk.http.HttpConfig();
        httpConfig.setConnectTimeout(3000);
        httpConfig.setSocketTimeout(6000);
        clientProfile.setHttpConfig(httpConfig);
        IFanbookBotClient client = new DefaultFanbookBotClient(clientProfile);
        return client;
```
