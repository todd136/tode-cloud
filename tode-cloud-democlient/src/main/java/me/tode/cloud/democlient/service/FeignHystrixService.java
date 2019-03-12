package me.tode.cloud.democlient.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 添加@FeignClient接口，create a Ribbon load balancer，discover the physical addresses for the "tode-cloud-demoservice" service.
 * If your application is a Eureka client then it will resolve the service in the Eureka service registry.
 * If you don’t want to use Eureka, you can simply configure a list of servers in your external configuration。
 *
 * fallbackFactory: provides the accessing to the cause that made the fallback trigger.
 */
@FeignClient(name = "tode-cloud-demoservice", fallbackFactory = FeignHystrixServiceFallbackFactory.class)
public interface FeignHystrixService {
    @RequestMapping(value = "/microservice/test")
    String getFromServerByFeignHystrix();
}
