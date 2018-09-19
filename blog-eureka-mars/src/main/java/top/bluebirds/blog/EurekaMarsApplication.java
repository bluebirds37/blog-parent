package top.bluebirds.blog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaMarsApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaMarsApplication.class, args);
    }
}
