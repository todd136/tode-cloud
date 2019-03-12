package me.tode.cloud.democlient.web;

import me.tode.cloud.democlient.service.ClientService;
import me.tode.cloud.democlient.service.FeignClientService;
import me.tode.cloud.democlient.service.FeignHystrixService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    /**
     * 日志记录工具
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private ClientService clientService;

    @Autowired
    private FeignClientService feignClientService;

    @Autowired
    private FeignHystrixService feignHystrixService;

    @RequestMapping(value = "/test")
    public String produceMessage() {
        return clientService.productMessage();
    }

    @RequestMapping("/to-read")
    public String toRead() {
        return clientService.readingList();
    }

    @RequestMapping("/test-load-balancer")
    public String produceMessageByLoadBalancer() {
        return clientService.productMessageByLoadBalancer();
    }

    /**
     * 调用@FeignClient注解的接口中的方法
     * @return
     */
    @RequestMapping("/getFromServerByFeign")
    public String getFromFeignServer() {
        return feignClientService.getFromServerByFeign();
    }

    @RequestMapping("/getFromServerByFeignHystrix")
    public String getFromFeignHystrixServer() {
        return feignHystrixService.getFromServerByFeignHystrix();
    }
}
