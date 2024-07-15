package ru.mironov.kafkametricsconsumer.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.support.JacksonUtils;

@Configuration
public class DeserializationConfig {

    @Bean
    public ObjectMapper objectMapper(){
        return JacksonUtils.enhancedObjectMapper();
    }
}
