package ru.mironov.kafkametricsconsumer.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.DltHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.RetryableTopic;
import org.springframework.kafka.retrytopic.DltStrategy;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class MetricsListener {

    private final ProducerApplicationMetricsLogger producerApplicationMetricsLogger;

    @RetryableTopic(attempts = "1", kafkaTemplate = "kafkaTemplate", dltStrategy = DltStrategy.FAIL_ON_ERROR)
    @KafkaListener(topics = "metrics", groupId = "${spring.kafka.client-id}")
    public void handleActuatorMessage(String message) {
        producerApplicationMetricsLogger.logMetrics(message);
    }

    @DltHandler
    public void handleDlt(String message, @Header(KafkaHeaders.RECEIVED_TOPIC) String topic) {
        log.info("Event on dlt topic={}, payload={}", topic, message);
    }
}
