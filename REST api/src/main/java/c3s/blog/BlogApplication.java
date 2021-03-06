package c3s.blog;

import c3s.blog.entity.User;
import c3s.blog.service.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
public class BlogApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BlogApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
    }

}
