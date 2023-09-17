package com.example.service.Impl;

import com.example.service.OrderService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @Author abner.guo
 * @Date 2023/9/17 11:29
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public int saveOrder(String message) {

        ListenableFuture<SendResult<String, String>> send = kafkaTemplate.send("my-topic", message);
        send.addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("订单生成失败");
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                System.out.println("订单生成成功");
                System.out.println(result);

            }
        });
        return 0;
    }
}
