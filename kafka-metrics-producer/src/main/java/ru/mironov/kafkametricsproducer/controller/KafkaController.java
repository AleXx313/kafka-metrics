package ru.mironov.kafkametricsproducer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.mironov.kafkametricsproducer.client.ActuatorMetricsClient;
import ru.mironov.kafkametricsproducer.service.KafkaService;

@RestController
@RequestMapping("/metric")
@RequiredArgsConstructor
public class KafkaController {

    private final KafkaService kafkaService;
    private final ActuatorMetricsClient actuatorMetricsClient;
    @PostMapping
    public void sendMetrics(){
        kafkaService.sendMessage(actuatorMetricsClient.getMetrics());
    }

}
