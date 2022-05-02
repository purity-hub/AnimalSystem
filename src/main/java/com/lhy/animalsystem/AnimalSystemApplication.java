package com.lhy.animalsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

import javax.annotation.ManagedBean;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class AnimalSystemApplication {

    public static void main(String[] args) throws UnknownHostException {
        //引入局部变量获取运行时参数
        ConfigurableApplicationContext application = SpringApplication.run(AnimalSystemApplication.class, args);
        ConfigurableEnvironment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");//获取yml配置文件参数
        //Logger logger = LoggerFactory.getLogger("AnimalSystemApplication.class");
        //logger.info("http://"+ip+":"+port);
        System.out.println("http://"+ip+":"+port);
    }

}
