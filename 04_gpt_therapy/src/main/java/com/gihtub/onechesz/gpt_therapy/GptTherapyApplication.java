package com.gihtub.onechesz.gpt_therapy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@PropertySources({
        @PropertySource("classpath:application.properties"),
        @PropertySource("classpath:environment.properties")
})
public class GptTherapyApplication {

    public static void main(String[] args) {
        SpringApplication.run(GptTherapyApplication.class, args);
    }

}
