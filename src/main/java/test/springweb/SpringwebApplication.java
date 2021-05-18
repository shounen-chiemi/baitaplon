package test.springweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringwebApplication {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringwebApplication.class, args);
    }

}
