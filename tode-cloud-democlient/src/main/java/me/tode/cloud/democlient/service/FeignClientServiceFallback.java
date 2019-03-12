package me.tode.cloud.democlient.service;

import org.springframework.stereotype.Component;

@Component
public class FeignClientServiceFallback implements FeignClientService {
    @Override
    public String getFromServerByFeign() {
        return "message from ClientByFeignFallback";
    }
}
