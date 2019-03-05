package me.tode.cloud.democlient.web;

import me.tode.cloud.democlient.service.ClientService;
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
    private ClientService clientService;
    /**
     * 日志记录工具
     */
    private final Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/test")
    public String produceMessage() {
        return clientService.productMessage();
    }
}
