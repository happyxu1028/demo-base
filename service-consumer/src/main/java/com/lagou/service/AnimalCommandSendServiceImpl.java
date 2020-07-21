package com.lagou.service;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: 长灵
 * @Date: 2020-07-19 23:37
 */
@Service
public class AnimalCommandSendServiceImpl implements AnimalCommandSendService{


    @Reference
    private AnimalCommandExecuteService animalCommandExecuteService;

    @Override
    public void run() {
        animalCommandExecuteService.run();
    }

    @Override
    public void eat() {
        animalCommandExecuteService.eat();
    }

    @Override
    public void sleep() {
        animalCommandExecuteService.sleep();

    }
}
