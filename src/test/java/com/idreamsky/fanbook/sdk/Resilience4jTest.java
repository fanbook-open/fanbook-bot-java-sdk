package com.idreamsky.fanbook.sdk;

import com.idreamsky.fanbook.sdk.bot.method.v20220429.GetMeMethod;
import com.idreamsky.fanbook.sdk.bot.model.v20220429.User;
import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import com.idreamsky.fanbook.sdk.profile.ClientProfile;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.vavr.CheckedFunction0;
import io.vavr.control.Try;
import lombok.extern.slf4j.Slf4j;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

@Slf4j
public class Resilience4jTest {
    CircuitBreakerRegistry circuitBreakerRegistry;
    private ClientProfile clientProfile;
    private IFanbookBotClient fanbookClient;
    private CircuitBreaker circuitBreaker;

    public void initFanbookBotClient() {
        clientProfile = ClientProfile.getDefaultProfile();
        clientProfile.setBotToken("249732ee451de5551db07b0d9f1780f67b2bb204c542a2c8a164f02e0d02ec71c7d0ecb4f89b8051326a8026d5be5851");
        clientProfile.setClientKey("384905094069620736");
        clientProfile.setClientSecret("5A0aq9ek3sFPQXJPcAn6ATBOQ0FL8nup");
        clientProfile.setBotId(379899470315257856L);
        clientProfile.setDomain("a111111.fanbook.mobi");
        fanbookClient = new DefaultFanbookBotClient(clientProfile);
    }

    @Before
    public void init() {
        CircuitBreakerConfig circuitBreakerConfig = CircuitBreakerConfig.custom()
                .minimumNumberOfCalls(10)
                .failureRateThreshold(80)
                .waitDurationInOpenState(Duration.ofMillis(15000))
                .enableAutomaticTransitionFromOpenToHalfOpen()
                .permittedNumberOfCallsInHalfOpenState(2)
                .slidingWindowSize(2)
                .ignoreExceptions(BotArgumentException.class, BotApiRequestException.class, BotApiRequestException.class)
                .build();
        circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);
        circuitBreaker = circuitBreakerRegistry.circuitBreaker("GetMeMethod");
        initFanbookBotClient();
    }


    @Test
    public void testMethod() {
        for (int i = 0; i < 100; i++) {
            try {

                CheckedFunction0<User> userCheckedFunction0 = CircuitBreaker.decorateCheckedSupplier(circuitBreaker, this::invoke);
                Try<User> tryOf = Try.of(userCheckedFunction0).recover(CallNotPermittedException.class,
                        throwable -> {
                            log.warn("限流断路器已经打开,策略{}将执行单机版本的限流方法");
                            throw new RuntimeException("限流断路器已经打开,策略{}将执行单机版本的限流方法");
                        });
                User user = tryOf.get();
                log.info("tryOf:{}", user);
            } catch (Exception e) {
                log.error("e:{}", e.getMessage(), e);
            }
        }
    }

    public User invoke() {
        GetMeMethod getMeMethod = new GetMeMethod();
        if (true) {
            throw new RuntimeException("我是一个异常");
        }
        return fanbookClient.getBotResponse(getMeMethod);
    }
}
