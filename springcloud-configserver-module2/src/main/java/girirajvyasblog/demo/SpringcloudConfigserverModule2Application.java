package girirajvyasblog.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringcloudConfigserverModule2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigserverModule2Application.class, args);
	}
}
