package com.lagou;


import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.io.IOException;

@Configuration
@EnableDubbo(scanBasePackages = "com.lagou.service.impl")
@PropertySource("classpath:/dubbo-provider.properties")
@SpringBootApplication
public class DubboProviderMain {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(DubboProviderMain.class);
    }

    private void run() throws IOException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.in.read();
    }


    static class ProviderConfiguration {
        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("zookeeper://121.43.175.170:2181?timeout=10000");
            //registryConfig.setTimeout(10000);
            return registryConfig;
        }
    }

}
