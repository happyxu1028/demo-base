package com.lagou.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Component
public class ComsumerComponet {

    @Reference(loadbalance = "random", timeout = 1000, check = true, mock = "fail:return error")
    private HelloService helloService;

    public String sayHello(String name) {
        return helloService.sayHello(name);
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
    }

}
