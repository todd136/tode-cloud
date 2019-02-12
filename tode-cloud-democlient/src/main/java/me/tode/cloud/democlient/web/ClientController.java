package me.tode.cloud.democlient.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/client")
public class ClientController {
    @Autowired
    private DiscoveryClient discoveryClient;

    /**
     * 日志记录工具
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/test")
    public String produceMessage() {
        List<String> services = discoveryClient.getServices();
        List<ServiceInstance> infos = discoveryClient.getInstances("tode-cloud-demoservice");
        logger.info("中文cloud service id = " + infos.get(0).getServiceId());
        ServiceInstance serviceInstance = infos.get(0);
        String host = serviceInstance.getHost();
        int port = serviceInstance.getPort();
        URI uri = serviceInstance.getUri();

        return "中文cloud service uri = " + infos.get(0).getUri();
    }
}
