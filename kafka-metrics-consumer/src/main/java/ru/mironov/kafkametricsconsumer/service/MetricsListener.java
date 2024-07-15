package ru.mironov.kafkametricsconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetricsListener {

    private final ProducerApplicationMetricsLogger producerApplicationMetricsLogger;
    @KafkaListener(topics = "topic", groupId = "${spring.kafka.client-id}")
    public void listenGroupFoo(String message) {
//        log.info(message);
        producerApplicationMetricsLogger.logMetrics(message);
    }
}
