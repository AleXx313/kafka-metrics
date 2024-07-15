package ru.mironov.kafkametricsconsumer.util;

import ru.mironov.kafkametricsconsumer.model.ActuatorMetric;
import ru.mironov.kafkametricsconsumer.model.Measurement;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

public class MetricsLogHelper {

    public static String buildLog(List<ActuatorMetric> actuatorMetrics){
        StringBuilder sb = new StringBuilder();
        sb.append("\n================================================================================================================================\n")
                .append("Время получения метрики: ")
                .append(LocalDateTime.now().format(DateTimeFormatter.ofPattern(Constants.DATE_PATTERN)))
                .append("\n");
        for (ActuatorMetric actuatorMetric : actuatorMetrics) {
            appendNewMetric(actuatorMetric, sb);
        }
        sb.append("================================================================================================================================");
        return sb.toString();
    }

    private static void appendNewMetric(ActuatorMetric actuatorMetric, StringBuilder sb) {
        List<Measurement> measurements = actuatorMetric.getMeasurements();
        int startPosition = sb.length();
        boolean hasBaseUnit = actuatorMetric.getBaseUnit() != null && !actuatorMetric.getBaseUnit().isBlank();
        sb.append("\u001B[36m")
                .append("Метрика: ")
                .append("\u001B[0m")
                .append(actuatorMetric.getName());
        getRequiredSpaces(startPosition, sb.length(), 48, sb);
        startPosition = sb.length();
        sb.append("\u001B[32m")
                .append("Описание: " )
                .append("\u001B[0m")
                .append(actuatorMetric.getDescription() != null ? actuatorMetric.getDescription() : "Не предусмотрено spring-boot-actuator api");
        getRequiredSpaces(startPosition, sb.length(), 110, sb);
        sb.append("\u001B[33m").append("Значение:").append("\u001B[0m");
        for (Measurement measurement : measurements) {
            sb.append(measurement.getStatistic().equals("VALUE") ? "" : " " + measurement.getStatistic())
                    .append(" - ").append(measurement.getValue());
            if (hasBaseUnit){
                sb.append(" ")
                        .append(actuatorMetric.getBaseUnit());
            }
            sb.append(" | ");
        }
        sb.deleteCharAt(sb.length() - 2);
        sb.append("\n");
    }

    private static void getRequiredSpaces(int startPosition, int currentPosition, int required, StringBuilder sb) {
        int taken = currentPosition - startPosition;
        sb.append(" ".repeat(Math.max(0, required - taken)));
    }
}
