package me.tode.cloud.demoservice2.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/microservice")
public class MicroServiceController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping(value = "/test")
    public String produceMessage() {
        return "This message came from remote server through discovery server(中文) 8084";
    }
}
