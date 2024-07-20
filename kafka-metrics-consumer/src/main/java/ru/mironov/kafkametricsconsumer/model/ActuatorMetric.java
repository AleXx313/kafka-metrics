package ru.mironov.kafkametricsconsumer.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "metric")
@Schema(description = "Метрика")
public class ActuatorMetric {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    @Schema(description = "Наименование")
    private String name;
    @Column(name = "description")
    @Schema(description = "Описание")
    private String description;
    @Column(name = "base_unit")
    @Schema(description = "Единица измерения")
    private String baseUnit;
    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "metric_id")
    @Schema(description = "Список значений")
    private List<Measurement> measurements;
}
