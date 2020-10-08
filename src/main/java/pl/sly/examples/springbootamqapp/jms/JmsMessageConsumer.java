package pl.sly.examples.springbootamqapp.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class JmsMessageConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JmsMessageConsumer.class);

    @JmsListener(destination = "${messaging.queue}")
    public void consumeMessage(String message) {
        LOGGER.debug("Consume message: {}", message);
    }
}
