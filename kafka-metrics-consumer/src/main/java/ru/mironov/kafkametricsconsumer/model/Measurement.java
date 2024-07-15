package ru.mironov.kafkametricsconsumer.model;

import lombok.Data;

@Data
public class Measurement {

    private String statistic;
    private String value;
}
