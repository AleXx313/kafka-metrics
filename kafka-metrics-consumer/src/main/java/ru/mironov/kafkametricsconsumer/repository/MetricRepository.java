package ru.mironov.kafkametricsconsumer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.mironov.kafkametricsconsumer.model.ActuatorMetric;

import java.util.List;

@Repository
public interface MetricRepository extends JpaRepository<ActuatorMetric, Long> {

    @Query("""
            SELECT DISTINCT am.name
            FROM ActuatorMetric AS am
            """)
    List<String> getMetrics();

    List<ActuatorMetric> findActuatorMetricByName(String metricName);

    ActuatorMetric findActuatorMetricById(Long id);
}
