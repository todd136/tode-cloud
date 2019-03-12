package me.tode.cloud.democlient.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignHystrixServiceFallbackFactory implements FallbackFactory<FeignHystrixService> {

    @Override
    public FeignHystrixService create(Throwable throwable) {
        return () -> "getFromServerByFeignHystrix fallback, reason is " + throwable.getCause();
    }
}
