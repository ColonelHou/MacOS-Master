package org.macos.java.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
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
//            String msg = kafkaMaessage.get().toString();
            if (kafkaMaessage.isPresent()) {
                Object message = record.value();
                System.out.println("-----> " + message.toString());
            }

//            parseKakfkaMsg(msg);
        }
    }

    /**
     * 解析Kafka返回数据
     * @param msg
     */
    public static void parseKakfkaMsg(String msg) {
        JSONObject obj = JSON.parseObject(msg);
        // TableKeyEnum中所有table为NEWS的数据要处理
        String strTbl = obj.getString("table");
        // 只处理INSERT / UPDATE
        String strType = obj.getString("type");
        String strID = obj.getString("id");

        if (strTbl.equals("news") && (strType.equals("insert") || strType.equals("update"))) {

        }

    }
}
