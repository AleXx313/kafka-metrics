package ru.mironov.kafkametricsconsumer.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.mironov.kafkametricsconsumer.model.ActuatorMetric;
import ru.mironov.kafkametricsconsumer.util.MetricsLogHelper;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProducerApplicationMetricsLogger {

    private final ObjectMapper objectMapper;
    private final MetricService metricService;

    public void logMetrics(String kafkaMessage) {
        List<ActuatorMetric> actuatorMetrics = null;
        try {
            actuatorMetrics = objectMapper.readValue(kafkaMessage, new TypeReference<List<ActuatorMetric>>() {
            });
            log.info(MetricsLogHelper.buildLog(actuatorMetrics));
            metricService.saveAll(actuatorMetrics);
        } catch (JsonProcessingException e) {
            log.info("Ошибка парсинга json в List<ActuatorMetric>");
        }
    }
}
