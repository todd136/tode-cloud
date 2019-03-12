package me.tode.cloud.democlient.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import me.tode.cloud.democlient.service.ClientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;

@Service
public class ClientServiceImpl implements ClientService {
    /**
     * 日志记录工具
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private LoadBalancerClient loadBalancer;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    @HystrixCommand(defaultFallback = "productMessageDefault")
    public String productMessage() {
        List<ServiceInstance> infos = discoveryClient.getInstances("tode-cloud-demoservice");
        logger.info("cloud service id = " + infos.get(0).getServiceId());
        ServiceInstance serviceInstance = infos.get(0);
//            String host = serviceInstance.getHost();
//            int port = serviceInstance.getPort();
        URI uri = serviceInstance.getUri();

        return "cloud service uri = " + uri;
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

    /**
     * use fallbackMethod & private fallback method
     * @return
     */
    @HystrixCommand(fallbackMethod = "reliable")
    public String readingList() {
        List<ServiceInstance> infos = discoveryClient.getInstances("tode-cloud-demoservice");
        ServiceInstance serviceInstance = infos.get(0);

        URI uri = URI.create(serviceInstance.getUri() + "/microservice/recommended");

        String result = this.restTemplate.getForObject(uri, String.class);

        return result;
    }

    /**
     * private fallback method.
     * @return
     */
    private String reliable(Throwable e) {
        logger.info(e.toString());
        return "Cloud Native Java (O'Reilly)";
    }

    @HystrixCommand(defaultFallback = "productMessageDefault")
    public String productMessageByLoadBalancer() {
        ServiceInstance serviceInstance = loadBalancer.choose("tode-cloud-demoservice");
        URI uri = URI.create(String.format("http://%s:%s", serviceInstance.getHost(), serviceInstance.getPort()) + "/microservice/test");

        return this.restTemplate.getForObject(uri, String.class);
    }
}
