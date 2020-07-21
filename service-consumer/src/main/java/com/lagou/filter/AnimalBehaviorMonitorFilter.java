package com.lagou.filter;

import com.lagou.domain.AnimalCommandExecuteInfo;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @Description: 动物行为监控
 * @Author: 长灵
 * @Date: 2020-07-19 23:39
 */
@Activate(group = {CommonConstants.CONSUMER})
public class AnimalBehaviorMonitorFilter implements Filter  {

    /**
     * key=run/eat/slepp
     * value=存储的执行的数据
     */
    private static Map<String, List<AnimalCommandExecuteInfo>> map = new ConcurrentHashMap();

    public AnimalBehaviorMonitorFilter() {
        System.out.println("aaaaaa");
    }

    /**
     * 过滤逻辑
     * @param invoker
     * @param invocation
     * @return
     * @throws RpcException
     */
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {

        String methodName = invocation.getMethodName();
        Long start = System.currentTimeMillis();
        Long end = null;

        try {
            Result result = invoker.invoke(invocation);

            end = System.currentTimeMillis();
            return result;
        } catch (RpcException e) {
            e.printStackTrace();
            end = System.currentTimeMillis();
            throw e;
        } finally {

            List<AnimalCommandExecuteInfo> methodInfoList = map.get(methodName);
            if(CollectionUtils.isEmpty(methodInfoList)){
                methodInfoList = new ArrayList<>();
                map.put(methodName,methodInfoList);
            }

            methodInfoList.add(new AnimalCommandExecuteInfo(methodName,start,end,end-start));
        }
    }

    /**
     * 计算逻辑
     * @param behaviorName
     * @param rate
     * @return
     */
    public static AnimalCommandExecuteInfo calc(String behaviorName, Double rate) {
        List<AnimalCommandExecuteInfo> executeInfoList = map.get(behaviorName);
        if(CollectionUtils.isEmpty(executeInfoList)){
            return null;
        }

        // 当前时间作为终点
        long thisEndTime = System.currentTimeMillis();

        // 当前时间往前推1分钟作为起点
        long thisStartTime = thisEndTime-60000L;

        List<AnimalCommandExecuteInfo> collect = executeInfoList.stream()

                // 选择一分钟之类的
                .filter(animalCommandExecuteInfo -> {
                    boolean result = thisStartTime <= animalCommandExecuteInfo.getStartTime() && animalCommandExecuteInfo.getStartTime() <= thisEndTime;
                    return result;
                })
                // 排序
                .sorted((o1, o2) -> (int) (o1.getCostTime() - o2.getCostTime())).collect(Collectors.toList());


        if(CollectionUtils.isEmpty(collect)){
            return null;
        }

        // 取值
        int index = BigDecimal.valueOf(collect.size() * rate).intValue();
        return collect.get(index-1);
    }
}
