package ru.mironov.kafkametricsproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KafkaMetricsProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaMetricsProducerApplication.class, args);
    }

}
