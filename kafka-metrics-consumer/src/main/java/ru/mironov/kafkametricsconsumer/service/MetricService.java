package ru.mironov.kafkametricsconsumer.service;

import ru.mironov.kafkametricsconsumer.model.ActuatorMetric;

import java.util.List;

public interface MetricService {

    List<ActuatorMetric> saveAll(List<ActuatorMetric> actuatorMetrics);

    List<String> getMetrics();

    List<ActuatorMetric> getMetricsByName(String metricName);

    ActuatorMetric getMetricById(Long id);
}
