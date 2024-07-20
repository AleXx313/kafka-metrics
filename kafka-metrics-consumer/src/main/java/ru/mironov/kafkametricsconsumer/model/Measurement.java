package ru.mironov.kafkametricsconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "measurement")
@Schema(description = "Возможные значения метрики")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "statistic")
    @Schema(description = "Полученная статистика")
    private String statistic;
    @Column(name = "value")
    @Schema(description = "Значение")
    private String value;
    @ManyToOne
    @JoinColumn(name = "metric_id")
    @JsonIgnore
    private ActuatorMetric metric;
}
