# kafka-metrics
## Практическое задание по теме Kafka.

### Описание проекта
В рамках задания было реализовано 2 сервиса: kafka-metrics-producer и kafka-metrics-consumer взаимодействующие друг с другом при помощи Apache Kafka.
<br>Producer - некое работающее приложение в котором с помощью spring boot actuator собираются метрики его работы. Список задается чеерз файл настроек приложения application.yaml.
```
actuator.metrics.include: ...(список метрик, предусмотренных spring boot actuator)
```
Согласно установленному расписанию все метрики собираются в одну строку String соответствующую формату JSON и отправляются через сервис Kafka в топик metrics.
Consumer - слушает топик metrics в сервисе Kafka и при получении сообщение преобразует полученную строку в список метрик актуатора (List<ActuatorMetric>).
Далее consumer обрабатывает полученный список метрик и выводит в лог сообщение содержащее метрики работы приложения kafka-metrics-producer в следующем формате:

![metrics-screen](https://github.com/user-attachments/assets/8ddfbd34-36da-485e-b0f9-8c2a06c976e4)

Помимо заданного расписания метрики могут быть отправлены мгновенно после отправки POST запроса по URI - http://localhost:8080/metric.

### Rest API
Помимо вывода в лог, получаемые метрики также сохраняются в базу данных для их последующего анализа. <br>
Для работы с сохраненными метриками реализован Rest сервис.<br> Подробная документация доступна по ссылке: http://localhost:8081/swagger-ui/index.html <br>
OAS доступна по ссылке: http://localhost:8081/v3/api-docs

### Запуск
Для запуска приложения, необходимо:
- Клонировать проект с удаленного репозитория
- Вызвать команду ``` mvn clean package ```
- Вызвать команду ``` docker-compose up -d ```


С помощью команды docker-compose up будут запущены собранные сервисы kafka-metrics-producer и kafka-metrics-consumer, будет скачен и запущен контейнер metrics-db с базой данных postgres, а также будут скачены и запущены сервисы:
- wurstmeister/zookeeper
- wurstmeister/kafka

### Используемые технологии
+ [Java](https://www.java.com/) (21)
+ [Spring Boot](https://spring.io/projects/spring-boot) (3)
+ [Apache Kafka](https://kafka.apache.org/)
+ [Apache Zookeeper](https://zookeeper.apache.org/)
+ [Apache Maven](https://maven.apache.org)
+ [Project Lombok](https://projectlombok.org)
+ [Hibernate](https://hibernate.org)
+ [PostgresSQL](https://www.postgresql.org)
