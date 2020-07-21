package com.lagou.service;

/**
 * @Description: 动物
 * @Author: 长灵
 * @Date: 2020-07-19 23:25
 */
public interface AnimalCommandExecuteService {

    /**
     * 奔跑
     */
    void run();

    /**
     * 进食
     */
    void eat();

    /**
     * 睡觉
     */
    void sleep();

}
