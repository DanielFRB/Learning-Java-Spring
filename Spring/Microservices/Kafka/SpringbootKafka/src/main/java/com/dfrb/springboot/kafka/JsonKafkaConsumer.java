package com.dfrb.springboot.kafka;

import com.dfrb.springboot.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

/**
 * @author danfe
 */

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);
    
    @KafkaListener(topics = "tema-ejemplo-json", groupId = "miGrupoConsum")
    public void leerMensajeJson(Usuario u) {
        LOGGER.info(String.format("Mensaje recibido: %s", u.toString()));
    }
}
