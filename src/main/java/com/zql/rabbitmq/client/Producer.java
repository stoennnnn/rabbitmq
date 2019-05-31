package com.zql.rabbitmq.client;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.zql.rabbitmq.config.MqConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created by  @ZQL  on 2019/5/31.
 * 发送端
 */
@Component
public class Producer {
    private final static String QUEUE_NAME="TEST_QUEUE";

    @Autowired
    private MqConnUtil connUtil;

    @Autowired
    private MqConfig mqConfig;

    public void sendMsg(String msg) throws IOException, TimeoutException {
        Connection conn = connUtil.getConnection();
        Channel channel = connUtil.getChannel(conn);
        try {
            //channel.basicPublish(mqConfig.getExchange(),mqConfig.getRouting(),null,msg.getBytes());
            channel.basicPublish("", mqConfig.getQueues(), null, msg.getBytes("utf-8"));
            System.out.println("已经成功发送到队列："+mqConfig.getQueues());
        } catch (IOException e) {
            e.printStackTrace();
        }
        connUtil.closeConnection(conn);

    }
}