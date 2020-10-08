package pl.sly.examples.springbootamqapp.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalTime;

@Profile("amqEnabled")
@Component
public class JmsMessageProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsMessageProducer.class);

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Value("${messaging.queue}")
    private String queueName;

    @Scheduled(
            initialDelay = 5000,
            fixedDelay = 2000)
    public void produceMessage() {
        LOGGER.debug("Produce new message...");
        String newMessage = String.format("New message from producer: %s", LocalTime.now());
        this.jmsMessagingTemplate.convertAndSend(queueName, newMessage);
    }

    @PostConstruct
    private void afterInit() {
        LOGGER.debug("@@@@@@@ Message producer will start in 5 sec. @@@@@@@");
    }
}
