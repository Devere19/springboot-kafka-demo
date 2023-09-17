package com.example.consumer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author abner.guo
 * @Date 2023/9/17 11:07
 */
@Service
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "default-group")
    public String consume(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());

        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            System.out.println("message是：" + message);
            return "消费成功";
        }
        return "消费失败";
    }

}

