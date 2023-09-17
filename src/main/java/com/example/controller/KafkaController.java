package com.example.controller;

import com.example.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;

/**
 * @Author abner.guo
 * @Date 2023/9/17 10:58
 */
@RestController
public class KafkaController {


    @Resource
    private OrderService orderService;

    @PostMapping("/send")
    public void sendMessage(@RequestBody String message) throws ExecutionException, InterruptedException {
        orderService.saveOrder(message);
    }

}
