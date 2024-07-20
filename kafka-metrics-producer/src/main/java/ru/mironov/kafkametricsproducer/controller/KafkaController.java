package ru.mironov.kafkametricsproducer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;
import ru.mironov.kafkametricsproducer.client.ActuatorMetricsClient;
import ru.mironov.kafkametricsproducer.service.KafkaService;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/metric")
@RequiredArgsConstructor
@Tag(
        name = "Контроллер для отправки метрик",
        description = "Контроллер для отправки метрик. Метрики могут отправляться как принудительно, так и по расписанию")
public class KafkaController {

    private final KafkaService kafkaService;
    private final ActuatorMetricsClient actuatorMetricsClient;

    @PostMapping
    @Scheduled(fixedRate = 60, initialDelay = 10, timeUnit = TimeUnit.SECONDS)
    @Operation(
            summary = "Отправить метрики",
            description = "Запрашивает метрики у actuator и отправляет их в kafka"
    )
    public void sendMetrics() {
        kafkaService.sendMessage(actuatorMetricsClient.getMetrics());
    }
}
