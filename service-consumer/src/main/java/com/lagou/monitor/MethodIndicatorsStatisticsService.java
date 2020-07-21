package com.lagou.monitor;

import com.alibaba.fastjson.JSON;
import com.lagou.domain.AnimalCommandExecuteInfo;
import com.lagou.filter.AnimalBehaviorMonitorFilter;
import com.lagou.service.AnimalCommandSendService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @Description: 方法性能指标计算器
 * @Author: 长灵
 * @Date: 2020-07-19 23:50
 */
@Service
public class MethodIndicatorsStatisticsService {




    @Resource
    private AnimalCommandSendService sendService;

    ScheduledExecutorService statisticsThreadPool = Executors.newSingleThreadScheduledExecutor();

    ExecutorService callTaskThreadPool = Executors.newSingleThreadExecutor();


    /**
     * 开始启动
     */
    public void start(){
        callTaskThreadPool.submit(new CallTask());

        statisticsThreadPool.scheduleWithFixedDelay(new StatisticsTask(),5,5, TimeUnit.SECONDS);
    }


    /**
     * 统计的线程任务
     */
    class StatisticsTask implements  Runnable{

        @Override
        public void run() {
            statistics("run",0.99);
            statistics("eat",0.99);
            statistics("sleep",0.99);

        }

        private void statistics(String command,Double rate){
            AnimalCommandExecuteInfo run = AnimalBehaviorMonitorFilter.calc(command, rate);
            System.out.println(">>>> 行为:"+command+ ", TPN: "+(rate*100) +", 统计结果 = "+JSON.toJSONString(run));
        }


    }


    /**
     * 执行调用的线程任务
     */
    class CallTask implements  Runnable{

        @Override
        public void run() {

            int count = 100000;

            while((count--) > 0){
                try {
                    sendService.run();
                    sendService.eat();
                    sendService.sleep();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
