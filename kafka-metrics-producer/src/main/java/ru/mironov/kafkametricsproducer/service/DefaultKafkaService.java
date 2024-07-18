package ru.mironov.kafkametricsproducer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
@RequiredArgsConstructor
@Slf4j
public class DefaultKafkaService implements KafkaService {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void sendMessage(String message) {
        CompletableFuture<SendResult<String, String>> future = kafkaTemplate.send("topic", message);
        future.whenComplete(((stringStringSendResult, throwable) -> {
            if (throwable == null) {
                log.info("Message send");
            } else {
                log.error("Message wasn't send");
            }
        }));
    }
}
