package com.zql.rabbitmq.client;

import com.rabbitmq.client.*;
import com.zql.rabbitmq.config.MqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by  @ZQL  on 2019/5/31.
 * 消费端
 */
@Component
public class Consumers {
    @Autowired
    private MqConnUtil connUtil;
    @Autowired
    private MqConfig mqConfig;

    public void receiveMsg() throws IOException, TimeoutException {
        Connection conn = connUtil.getConnection();
        Channel channel = connUtil.getChannel(conn);
        channel.queueDeclare(mqConfig.getQueues(),false,false,false,null);
        Consumer consumer = new DefaultConsumer(channel){
            //重写DefaultConsumer中handleDelivery方法，在方法中获取消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope,
                                       AMQP.BasicProperties properties,
                                       byte[] body) throws IOException{
                String message = new String(body, "UTF-8");
                System.out.println(" 收到了消息: '" + message + "'");
            }
        };
        channel.basicConsume(mqConfig.getQueues(), false,consumer);
        connUtil.closeConnection(conn);
    }

}
