package com.lagou;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Description:
 * @Author: 长灵
 * @Date: 2020-06-21 16:37
 */
@Configuration
@PropertySource("classpath:/dubbo-consumer.properties")
@ComponentScan(basePackages = "com.lagou.service")
@EnableDubbo
public class ConsumerConfiguration {
}
