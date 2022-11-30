package com.dfrb.springboot.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.kafka.annotation.*;

/**
 * @author danfe
 */

@Service
public class StringKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(StringKafkaConsumer.class);
    
    @KafkaListener(topics = "tema-ejemplo", groupId = "miGrupoConsum")
    public void leerMensaje(String message) {
        LOGGER.info(String.format("Mensaje recibido: %s", message));
    }
}
