package ru.mironov.kafkametricsproducer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import ru.mironov.kafkametricsproducer.client.ActuatorMetricsClient;
import ru.mironov.kafkametricsproducer.service.KafkaService;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/metric")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaService kafkaService;
    private final ActuatorMetricsClient actuatorMetricsClient;

    @PostMapping
    @Scheduled(fixedRate = 60, initialDelay = 10, timeUnit = TimeUnit.SECONDS)
    public void sendMetrics() {
        kafkaService.sendMessage(actuatorMetricsClient.getMetrics());
    }
}
