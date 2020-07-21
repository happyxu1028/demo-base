package com.lagou;

import com.lagou.service.ComsumerComponet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.io.IOException;

@SpringBootApplication
public class SpringbootConsumerMain {


    public static void main(String[] args) throws Exception {
        SpringApplication.run(SpringbootConsumerMain.class);
    }

    private static void run() throws IOException {
        System.out.println("-------------");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        // 获取消费者组件
        ComsumerComponet service = context.getBean(ComsumerComponet.class);
        while (true) {
            System.in.read();
            try {
                String hello = service.sayHello("world");
                System.out.println("result: " + hello);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
