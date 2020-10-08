package pl.sly.examples.springbootamqapp.config;

import org.springframework.boot.autoconfigure.jms.activemq.ActiveMQAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.annotation.EnableJms;

@Profile("amqEnabled")
@EnableJms
@Import(ActiveMQAutoConfiguration.class)
@Configuration
public class ActiveMQConfig {
}