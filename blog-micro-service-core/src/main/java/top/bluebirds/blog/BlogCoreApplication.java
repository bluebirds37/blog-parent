package top.bluebirds.blog;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableSwagger2Doc
@SpringBootApplication
@EnableMongoRepositories(basePackages = "top.bluebirds.blog.dao")
public class BlogCoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogCoreApplication.class, args);
	}
}
