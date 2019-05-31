package com.zql.rabbitmq.annotation;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by  @ZQL  on 2019/5/31.
 */
@Component
@RabbitListener(queues = "test")
public class AnnoConsumer {

    @RabbitHandler
    public void receive(String msg){
        System.out.println("消费消息："+msg);

    }
}
