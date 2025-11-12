package store.esgseed.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@SpringBootApplication
public class ConfigServerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApiApplication.class, args);
	}

}
