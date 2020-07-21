package com.lagou.service.impl;

import com.lagou.service.HelloService;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.RpcContext;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        try {
            System.out.println("recv req");
            printRequestIp();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "replay: hello  :" + name;
    }

    /**
     * 打印请求的客户端的ip
     */
    private void printRequestIp() {
        RpcContext context = RpcContext.getContext();
        String requestHostIp = (String) context.getAttachment("request_host_ip");
        System.out.println(">>>> 客户端请求ip: " + requestHostIp);
    }
}
