package com.lagou.service.impl;

import com.lagou.service.AnimalCommandExecuteService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: 长灵
 * @Date: 2020-07-19 23:27
 */
@Service
@org.springframework.stereotype.Service
public class AnimalCommandExecuteServiceImpl implements AnimalCommandExecuteService {

    @Value("${animal.behavior.time}")
    private Integer costTimeMills;

    @Override
    public void run( ) {
        System.out.println(">>>> 接收到指令: run");
        try {
            TimeUnit.MILLISECONDS.sleep(costTimeMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void eat() {
        System.out.println(">>>> 接收到指令: eat");
        try {
            TimeUnit.MILLISECONDS.sleep(costTimeMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sleep() {
        System.out.println(">>>> 接收到指令: sleep");
        try {
            TimeUnit.MILLISECONDS.sleep(costTimeMills);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
