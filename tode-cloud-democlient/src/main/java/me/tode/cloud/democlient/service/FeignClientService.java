package me.tode.cloud.democlient.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 添加@FeignClient接口，create a Ribbon load balancer，discover the physical addresses for the "tode-cloud-demoservice" service.
 * If your application is a Eureka client then it will resolve the service in the Eureka service registry.
 * If you don’t want to use Eureka, you can simply configure a list of servers in your external configuration。
 *
 */
@FeignClient(name = "tode-cloud-demoservice", fallback = FeignClientServiceFallback.class)
public interface FeignClientService {

    /**
     * 调用服务端的接口
     * @return
     */
    @RequestMapping(value = "/microservice/test", method = RequestMethod.GET)
    String getFromServerByFeign();
}