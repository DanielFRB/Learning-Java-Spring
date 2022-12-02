package com.dfrb.springboot.kafka;

import com.dfrb.springboot.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

/**
 * @author danfe
 */

@Service
public class JsonKafkaProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
    private KafkaTemplate<String, Usuario> template;

    @Autowired
    public JsonKafkaProducer(KafkaTemplate<String, Usuario> template) {
        this.template = template;
    }
    
    public void enviarObjeto(Usuario u) {
        LOGGER.info(String.format("Objeto enviado: %s", u.toString()));
        Message<Usuario> message = MessageBuilder
                .withPayload(u)
                .setHeader(KafkaHeaders.TOPIC, "tema-ejemplo-json")
                .build();
        
        template.send(message);
    }
}
