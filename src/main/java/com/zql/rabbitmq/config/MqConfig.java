package com.zql.rabbitmq.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * Created by  @ZQL  on 2019/5/31.
 */
@ConfigurationProperties(prefix = "mq")
@Data
@Component
public class MqConfig {
    private String host;

    private Integer port;

    private String account;

    private String password;

    private String queues;

    private String routing;

    private String exchange;
}
