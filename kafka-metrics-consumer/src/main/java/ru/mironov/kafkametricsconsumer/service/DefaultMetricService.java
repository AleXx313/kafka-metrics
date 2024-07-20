package ru.mironov.kafkametricsconsumer.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.mironov.kafkametricsconsumer.model.ActuatorMetric;
import ru.mironov.kafkametricsconsumer.repository.MetricRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DefaultMetricService implements MetricService {

    private final MetricRepository metricRepository;

    @Override
    public List<ActuatorMetric> saveAll(List<ActuatorMetric> actuatorMetrics) {
        return metricRepository.saveAll(actuatorMetrics);
    }

    @Override
    public List<String> getMetrics() {
        return metricRepository.getMetrics();
    }

    @Override
    public List<ActuatorMetric> getMetricsByName(String metricName) {
        return metricRepository.findActuatorMetricByName(metricName);
    }

    @Override
    public ActuatorMetric getMetricById(Long id) {
        return metricRepository.findActuatorMetricById(id);
    }
}
