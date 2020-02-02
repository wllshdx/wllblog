package com.wllnb.wllblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author WLLNB
 */
@SpringBootApplication
public class WllBlogApplication {

    public static void main(String[] args) {
        /**
         * ElasticSearch 所需的临时设置，待解决
         */
        System.setProperty("es.set.netty.runtime.available.processors", "false");
        SpringApplication.run(WllBlogApplication.class, args);
    }
}
