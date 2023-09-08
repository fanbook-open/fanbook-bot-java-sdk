package com.idreamsky.fanbook.sdk.http;

import com.idreamsky.fanbook.sdk.exception.BotApiRequestException;
import com.idreamsky.fanbook.sdk.exception.BotArgumentException;
import io.github.resilience4j.circuitbreaker.CircuitBreaker;
import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 断路器设置
 */
public class CircuitBreakerFactory {
    private static Logger logger = LoggerFactory.getLogger(CircuitBreakerFactory.class);

    private static CircuitBreakerRegistry circuitBreakerRegistry;

    private final static Map<String, CircuitBreaker> circuitBreakerPool = new ConcurrentHashMap<>();

    private final static Object LOCK = new Object();


    public static CircuitBreakerConfig defaultCircuitBreakerConfig() {
        return CircuitBreakerConfig.custom()
                .minimumNumberOfCalls(10)
                .slidingWindowSize(10)
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofMillis(30000))
                .enableAutomaticTransitionFromOpenToHalfOpen()
                .permittedNumberOfCallsInHalfOpenState(3)
                .ignoreExceptions(BotArgumentException.class, BotApiRequestException.class)
                .build();
    }


    public CircuitBreakerFactory(CircuitBreakerConfig circuitBreakerConfig) {
        circuitBreakerRegistry = CircuitBreakerRegistry.of(circuitBreakerConfig);
    }

    /**
     * 创建熔断器
     *
     * @param name 熔断器名称
     * @return 熔断器
     */
    public CircuitBreaker getCircuitBreaker(String name) {
        CircuitBreaker circuitBreaker = circuitBreakerPool.get(name);
        if (null == circuitBreaker) {
            synchronized (LOCK) {
                circuitBreaker = circuitBreakerPool.get(name);
                if (null == circuitBreaker) {
                    circuitBreaker = circuitBreakerRegistry.circuitBreaker(name);
                }
            }
        }
        return circuitBreaker;
    }

    /**
     * 重置熔断器
     *
     * @param name 熔断器名称
     */
    public void restCircuitBreaker(String name) {
        CircuitBreaker circuitBreaker = circuitBreakerPool.get(name);
        if (null != circuitBreaker) {
            circuitBreaker.reset();
        }
    }
}
