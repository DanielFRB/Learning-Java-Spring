package com.dfrb.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

/**
 * @author danfe
 */

@Service
public class StringKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaProducer.class);
    private KafkaTemplate<String, String> template;

    public StringKafkaProducer(KafkaTemplate<String, String> template) {
        this.template = template;
    }
    
    public void enviaMensaje(String mensaje) {
        LOGGER.info(String.format("Mensaje enviado %s", mensaje));
        template.send("tema-ejemplo", mensaje);
    }
}
