package com.zql.rabbitmq.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.jws.soap.SOAPBinding;

import static org.junit.Assert.*;

/**
 * Created by  @ZQL  on 2019/5/31.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProducerTest {
    @Autowired
    private AnnoProducer producer;

    @Autowired
    private AnnoConsumer consumer;

    @Test
    public void sender() throws Exception {
        producer.sender("spingboot整合rabbitmq");
    }

}