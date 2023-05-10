package io.github.mihaildemidoff.reactive.tg.bots.examples.spring;

import io.github.mihaildemidoff.reactive.tg.bots.autoconfiguration.ReactiveTgBotsAutoconfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@ImportAutoConfiguration(ReactiveTgBotsAutoconfiguration.class)
@SpringBootApplication
public class ExampleSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleSpringApplication.class, args);
    }

}
