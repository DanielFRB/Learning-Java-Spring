package com.dfrb.springboot.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author danfe
 */

@Configuration
public class KafkaTopicCofiguration {
    @Bean
    public NewTopic dfrbTopic() {
        return TopicBuilder.name("tema-ejemplo")
                .partitions(10)
                .build();
    }
    
    @Bean
    public NewTopic jsonTopic() {
        return TopicBuilder.name("tema-ejemplo-json")
                .partitions(10)
                .build();
    }
}
