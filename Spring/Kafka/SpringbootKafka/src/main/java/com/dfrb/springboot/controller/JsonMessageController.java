package com.dfrb.springboot.controller;

import com.dfrb.springboot.kafka.JsonKafkaProducer;
import com.dfrb.springboot.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author danfe
 */

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController {
    @Autowired
    private JsonKafkaProducer productor;

    public JsonMessageController(JsonKafkaProducer productor) {
        this.productor = productor;
    }
    
    @PostMapping("/publish")
    public ResponseEntity<String> publicarObjeto(@RequestBody Usuario u) {
        productor.enviarObjeto(u);
        return ResponseEntity.ok("JSON mensaje enviado al Topic");
    }  
}
