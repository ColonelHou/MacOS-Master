package org.macos.java.config;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.TopicPartition;

import java.util.List;
import java.util.Optional;

public class ListenerConsume {


//    @KafkaListener(id = "id0", topicPartitions = { @TopicPartition(topic = "spring.kafka.template.default-topic", partitions = "0")})
    @KafkaListener(id = "id00", topics = {"test_topic"})
    public void testTopic(List<ConsumerRecord<?, ?>> recordList) {
        System.out.println("消费kafka==========");

        for (ConsumerRecord<?, ?> record: recordList) {
            Optional<?> kafkaMaessage = Optional.ofNullable(record.value());
            System.out.println(kafkaMaessage.get());
        }
    }
}
