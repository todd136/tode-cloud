package me.tode.cloud.democlient.service;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

@Component
public class FeignHystrixServiceFallbackFactory implements FallbackFactory<FeignHystrixService> {

    @Override
    public FeignHystrixService create(Throwable throwable) { // todo lambda
        return new FeignHystrixService() {
            @Override
            public String getFromServerByFeignHystrix() {
                return "getFromServerByFeignHystrix fallback, reason is " + throwable.getCause();
            }
        };
    }
}
