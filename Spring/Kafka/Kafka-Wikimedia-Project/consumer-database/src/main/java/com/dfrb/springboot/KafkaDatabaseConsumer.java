package com.dfrb.springboot;

import com.dfrb.springboot.entity.WikimediaDataTable;
import com.dfrb.springboot.repository.WikimediaDataRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaDatabaseConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaDatabaseConsumer.class);
    private WikimediaDataRepository dataRepository;

    public KafkaDatabaseConsumer(WikimediaDataRepository dataRepository) {
        this.dataRepository = dataRepository;
    }

    @KafkaListener(topics = "wikimedia_recentchange", groupId = "consumerGroup")
    public void consumidor(String eventoMensaje) {
        LOGGER.info(String.format("Evento Mensaje recivido -> %s", eventoMensaje));
        WikimediaDataTable dataTable = new WikimediaDataTable();
        dataTable.setWikiEventData(eventoMensaje);
        dataRepository.save(dataTable);
    }
}
