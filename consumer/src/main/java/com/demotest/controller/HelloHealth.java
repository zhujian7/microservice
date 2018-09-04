package com.caicloud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @PACKAGE_NAME：com.hello.demohello.controller
 * @DATE: 2018/7/24
 * @AURH: shilei
 * @DESC:
 */
@RestController
public class HelloHealth {

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/health/{name}")
    public String health(@PathVariable("name") String name){

        return "consumer-: "+name;
    }

    @GetMapping("/k8s/{id}")
    public String findById(@PathVariable String id) {
        return this.restTemplate.getForObject("http://provider:8081/health/服务提供者-" + id, String.class);
    }

    @GetMapping("/local/{url}/{name}")
    public String findBybId(@PathVariable String url,  @PathVariable String port, @PathVariable String name) {
        return this.restTemplate.getForObject("http://"+url+":"+port +"/health/服务提供者-" + name, String.class);
    }
}
