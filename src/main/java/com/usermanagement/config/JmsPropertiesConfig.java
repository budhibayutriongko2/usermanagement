package com.usermanagement.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("file:/file/tippers/jms.properties")
public class JmsPropertiesConfig {
    private String url;
    private String username;
    private String password;
    private String connectionFactoryName;
    private String sendSmsMessageQueue;
    private String sendEmailMessageQueue;
    private String sendPushMessageQueue;
    private String mssAckMessageQueue;


    public String getUrl() {
        return url;
    }

    @Value("${spring.wls.jms.url}")
    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    @Value("${spring.wls.jms.username}")
    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    @Value("${spring.wls.jms.password}")
    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnectionFactoryName() {
        return connectionFactoryName;
    }

    @Value("${spring.wls.jms.connectionFactoryName}")
    public void setConnectionFactoryName(String connectionFactoryName) {
        this.connectionFactoryName = connectionFactoryName;
    }

    public String getSendSmsMessageQueue() {
        return sendSmsMessageQueue;
    }
    @Value("${spring.wls.jms.message.sendSmsMessageQueue}")
    public void setSendSmsMessageQueue(String sendSmsMessageQueue) {
        this.sendSmsMessageQueue = sendSmsMessageQueue;
    }

    public String getSendEmailMessageQueue() {
        return sendEmailMessageQueue;
    }
    @Value("${spring.wls.jms.message.sendEmailMessageQueue}")
    public void setSendEmailMessageQueue(String sendEmailMessageQueue) {
        this.sendEmailMessageQueue = sendEmailMessageQueue;
    }

    public String getSendPushMessageQueue() {
        return sendPushMessageQueue;
    }
    @Value("${spring.wls.jms.message.sendPushMessageQueue}")
    public void setSendPushMessageQueue(String sendPushMessageQueue) {
        this.sendPushMessageQueue = sendPushMessageQueue;
    }

    public String getMssAckMessageQueue() {
        return mssAckMessageQueue;
    }
    @Value("${spring.wls.jms.message.mssAckMessageQueue}")
    public void setMssAckMessageQueue(String mssAckMessageQueue) {
        this.mssAckMessageQueue = mssAckMessageQueue;
    }

}
