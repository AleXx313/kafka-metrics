package ru.mironov.kafkametricsconsumer.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.mironov.kafkametricsconsumer.model.ActuatorMetric;
import ru.mironov.kafkametricsconsumer.service.MetricService;

import java.util.List;

@RestController
@RequestMapping("metric")
@RequiredArgsConstructor
public class MetricController {

    private final MetricService metricService;

    @GetMapping("list")
    public List<String> getMetrics(){
        return metricService.getMetrics();
    }

    @GetMapping("list/name/{name}")
    public List<ActuatorMetric> getMetricsByName(@PathVariable String name){
        return metricService.getMetricsByName(name);
    }
    @GetMapping("{id}")
    public ActuatorMetric getMetricById(@PathVariable Long id){
        return metricService.getMetricById(id);
    }
}
