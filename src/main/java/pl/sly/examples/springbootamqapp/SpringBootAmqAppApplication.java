package pl.sly.examples.springbootamqapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication(
		exclude = {
				ActiveMQAutoConfiguration.class
		})
public class SpringBootAmqAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootAmqAppApplication.class, args);
	}

}
