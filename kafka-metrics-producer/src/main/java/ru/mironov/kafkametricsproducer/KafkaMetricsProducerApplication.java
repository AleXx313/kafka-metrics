package ru.mironov.kafkametricsproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class KafkaMetricsProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaMetricsProducerApplication.class, args);
    }

}
