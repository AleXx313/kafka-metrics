package ru.mironov.kafkametricsconsumer.model;

import lombok.Data;

import java.util.List;

@Data
public class ActuatorMetric {

    private String name;
    private String description;
    private String baseUnit;
    private List<Measurement> measurements;

}
