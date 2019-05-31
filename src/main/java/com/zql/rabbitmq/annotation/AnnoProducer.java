package com.zql.rabbitmq.annotation;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by  @ZQL  on 2019/5/31.
 */
@Component
public class AnnoProducer {
    @Autowired
    private AmqpTemplate template;

    public void sender(String msg){
        template.convertAndSend("test",msg);
        System.out.println("发送消息到队列："+"test");
    }
}
