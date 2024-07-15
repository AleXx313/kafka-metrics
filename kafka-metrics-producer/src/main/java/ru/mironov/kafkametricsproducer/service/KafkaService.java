package ru.mironov.kafkametricsproducer.service;

public interface KafkaService {

    void sendMessage(String message);
}
