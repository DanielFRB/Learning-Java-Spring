package com.dfrb.springboot.controller;

import com.dfrb.springboot.kafka.StringKafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author danfe
 */

@RestController
@RequestMapping("/api/v1/kafka")
public class StringMessageController {
    @Autowired
    private StringKafkaProducer productor;

    public StringMessageController(StringKafkaProducer productor) {
        this.productor = productor;
    }
    
    @GetMapping("/publicacion")
    public ResponseEntity<String> publicarMensaje(@RequestParam("message") String message) {
        productor.enviaMensaje(message);
        return ResponseEntity.ok("Mensaje enviado al Topic");
    }
}
