package config;

import controller.RegisterController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import controller.HelloController;
import controller.IndexController;

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

    @Bean
    public RegisterController registerController() {
        return new RegisterController();
    }
}
