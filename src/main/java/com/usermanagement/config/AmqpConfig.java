package com.usermanagement.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


@Data
@Component
@ConfigurationProperties(prefix="notification")
@PropertySource("file:/file/tippers/amqp.properties")
public class AmqpConfig {
   
    private String queueName;
    private String username;
    private String pass;
}
