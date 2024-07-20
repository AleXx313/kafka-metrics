package ru.mironov.kafkametricsconsumer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "measurement")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "statistic")
    private String statistic;
    @Column(name = "value")
    private String value;
    @ManyToOne
    @JoinColumn(name = "metric_id")
    @JsonIgnore
    private ActuatorMetric metric;
}
