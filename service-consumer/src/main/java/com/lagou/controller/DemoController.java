package com.lagou.controller;

import com.lagou.monitor.MethodIndicatorsStatisticsService;
import com.lagou.service.ComsumerComponet;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description:
 * @Author: 长灵
 * @Date: 2020-07-19 21:57
 */
@RestController
public class DemoController {

    @Resource
    private ComsumerComponet comsumerComponet;


    @Resource
    private MethodIndicatorsStatisticsService methodIndicatorsStatisticsService;



    @RequestMapping("/demo/{name}")
    public Object demo(@PathVariable("name")String name){
        return comsumerComponet.sayHello(name);
    }



    @RequestMapping("/run")
    public void run(){
        methodIndicatorsStatisticsService.start();
    }


}
