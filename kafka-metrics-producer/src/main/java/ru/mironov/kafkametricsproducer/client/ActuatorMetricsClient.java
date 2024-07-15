package ru.mironov.kafkametricsproducer.client;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ActuatorMetricsClient {

    private final RestClient restClient;
    @Value("${actuator.metrics.include}")
    private List<String> metrics;

    public String getMetrics(){
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (String metric : metrics) {
            sb.append(restClient
                    .get()
                    .uri("http://localhost:8080/actuator/metrics/%s".formatted(metric))
                    .retrieve()
                    .body(String.class));
            sb.append(",");
        }
        sb.deleteCharAt(sb.length() -1);
        sb.append("]");
        return sb.toString();
    }

    public void testMetrics (){
        metrics.forEach(System.out::println);
    }
}
