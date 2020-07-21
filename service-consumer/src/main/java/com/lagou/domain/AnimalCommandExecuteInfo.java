package com.lagou.domain;

import java.util.Date;

/**
 * @Description:
 * @Author: 长灵
 * @Date: 2020-07-19 23:40
 */
public class AnimalCommandExecuteInfo {

    /**
     * 命令
     */
    private String command;

    /**
     * 开始时间
     */
    private Long startTime;

    /**
     * 结束时间
     */
    private Long endTime;

    /**
     * 耗时
     */
    private Long costTime;

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getCostTime() {
        return costTime;
    }

    public void setCostTime(Long costTime) {
        this.costTime = costTime;
    }

    public AnimalCommandExecuteInfo(String command, Long startTime, Long endTime, Long costTime) {
        this.command = command;
        this.startTime = startTime;
        this.endTime = endTime;
        this.costTime = costTime;
    }
}
