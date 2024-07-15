package ru.mironov.kafkametricsconsumer.util;

import org.springframework.format.annotation.DateTimeFormat;
import ru.mironov.kafkametricsconsumer.model.ActuatorMetric;
import ru.mironov.kafkametricsconsumer.model.Measurement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MetricsLogHelper {

    public static String buildLog(List<ActuatorMetric> actuatorMetrics){
        StringBuilder sb = new StringBuilder();
        sb.append("================================")
                .append("Время получения метрики: ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN)))
                .append("\n");
        for (ActuatorMetric actuatorMetric : actuatorMetrics) {
            appendNewMetric(actuatorMetric, sb);
        }
        sb.append("================================");
        return sb.toString();
    }

    private static void appendNewMetric(ActuatorMetric actuatorMetric, StringBuilder sb) {
        List<Measurement> measurements = actuatorMetric.getMeasurements();
        boolean hasBaseUnit = actuatorMetric.getBaseUnit() != null && !actuatorMetric.getBaseUnit().isBlank();
        sb.append("Метрика: ")
                .append(actuatorMetric.getName())
                .append("   ")
                .append("Описание: " )
                .append(actuatorMetric.getDescription())
                .append("   ")
                .append("Значение: ");
        for (Measurement measurement : measurements) {
            sb.append(measurement.getStatistic()).append(" - ").append(measurement.getValue());
            if (hasBaseUnit){
                sb.append(actuatorMetric.getBaseUnit());
            }
            sb.append(" | ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("\n");
    }
}
