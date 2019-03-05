package me.tode.cloud.democlient.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.tode.cloud.democlient.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    /**
     * 日志记录工具
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    @HystrixCommand(defaultFallback = "productMessageDefault")
    public String productMessage() {
        List<ServiceInstance> infos = discoveryClient.getInstances("tode-cloud-demoservice");
        logger.info("中文cloud service id = " + infos.get(0).getServiceId());
        ServiceInstance serviceInstance = infos.get(0);
//            String host = serviceInstance.getHost();
//            int port = serviceInstance.getPort();
        URI uri = serviceInstance.getUri();

        return "中文cloud service uri = " + uri;
    }

    /**
     * Hystrix command and fallback should be placed in the same class and have same method signature(optional parameter for failed execution exception)
     * Hystrix command and fallback 在同一个类中，同样的方法签名，仅可加异常处理的额外参数
     * @return
     */
    public String productMessageDefault(Throwable e) {
        logger.info(e.toString());
        return "message produced by hystrix default method";
    }
}
