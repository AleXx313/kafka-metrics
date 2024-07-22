package ru.mironov.kafkametricsconsumer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(
        name = "Контроллер для получения сведений о собранных метриках",
        description = "Контроллер для получения сведений о собранных метриках")
public class MetricController {

    private final MetricService metricService;

    @GetMapping("names")
    @Operation(
            summary = "Список метрик",
            description = "Позволяет получить список наименований имеющихся метрик"
    )
    public List<String> getMetrics() {
        return metricService.getMetrics();
    }

    @GetMapping("names/{name}")
    @Operation(
            summary = "Список метрик по имени",
            description = "Позволяет получить список сохраненных метрик по наименованию"
    )
    public List<ActuatorMetric> getMetricsByName(@PathVariable @Parameter(description = "Наименование метрики") String name) {
        return metricService.getMetricsByName(name);
    }

    @GetMapping("{id}")
    @Operation(
            summary = "Метрика по ID",
            description = "Позволяет получить конкретную метрику по id"
    )
    public ActuatorMetric getMetricById(@PathVariable Long id) {
        return metricService.getMetricById(id);
    }
}
