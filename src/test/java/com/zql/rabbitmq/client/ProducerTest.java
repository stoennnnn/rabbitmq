package com.zql.rabbitmq.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by  @ZQL  on 2019/5/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {
    @Autowired
    private Producer producer;
    @Autowired
    private Consumers consumers;
    @Test
    public void sendMsg() throws Exception {
        producer.sendMsg("hello");
        consumers.receiveMsg();
    }

}