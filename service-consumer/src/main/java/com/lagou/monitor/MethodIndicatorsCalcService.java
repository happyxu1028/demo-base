package com.lagou.monitor;

import com.lagou.domain.AnimalCommandExecuteInfo;

/**
 * @Description: 方法性能指标计算器
 * @Author: 长灵
 * @Date: 2020-07-19 23:50
 */
public interface MethodIndicatorsCalcService {


    /**
     * 指标结算
     * @param behaviorName
     * @param rate
     * @return
     */
    AnimalCommandExecuteInfo calc(String behaviorName, Double rate);

}
