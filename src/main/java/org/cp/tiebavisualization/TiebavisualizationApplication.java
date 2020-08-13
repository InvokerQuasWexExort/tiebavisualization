package org.cp.tiebavisualization;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
@MapperScan(basePackages = "org.cp.tiebavisualization.mapper")
public class TiebavisualizationApplication {

    public static void main(String[] args) {
        SpringApplication.run(TiebavisualizationApplication.class, args);
    }

}
