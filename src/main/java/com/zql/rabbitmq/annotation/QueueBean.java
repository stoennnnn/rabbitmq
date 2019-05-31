package com.zql.rabbitmq.annotation;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


/**
 * Created by  @ZQL  on 2019/5/31.
 */
@Component
public class QueueBean {

    @Bean
    public Queue testQueue(){
        return new Queue("test");
    }
}
