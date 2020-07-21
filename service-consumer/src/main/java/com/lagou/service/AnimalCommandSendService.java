package com.lagou.service;

/**
 * @Description: 发送动物行为的命令
 * @Author: 长灵
 * @Date: 2020-07-19 23:25
 */
public interface AnimalCommandSendService {

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
