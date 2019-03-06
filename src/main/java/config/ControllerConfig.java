package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.HelloController;
import spring.IndexController;

@Configuration
public class ControllerConfig {

    @Bean
    public HelloController helloController() {
        return new HelloController();
    }

    @Bean
    public IndexController indexController() {
        return new IndexController();
    }
}
