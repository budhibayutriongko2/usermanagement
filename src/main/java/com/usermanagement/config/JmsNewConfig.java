package com.usermanagement.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.destination.JndiDestinationResolver;
import org.springframework.jndi.JndiObjectFactoryBean;
import org.springframework.jndi.JndiTemplate;

import javax.jms.ConnectionFactory;
import java.util.Properties;

@Configuration
@EnableJms
public class JmsNewConfig {

    @Autowired
    private JmsErrorHandler jmsErrorHandler;

    @Autowired
    private JmsPropertiesConfig jmsPropertiesConfig;

    @Bean
    public JndiTemplate jndiTemplate(){
        JndiTemplate jndiTemplate =new JndiTemplate();
        Properties properties = new Properties();
        properties.setProperty("java.naming.factory.initial","weblogic.jndi.WLInitialContextFactory");
        properties.setProperty("java.naming.provider.url", jmsPropertiesConfig.getUrl());
        if(jmsPropertiesConfig.getUsername()!=null){
            properties.setProperty("username", jmsPropertiesConfig.getUsername());
        }
        if(jmsPropertiesConfig.getPassword()!=null){
            properties.setProperty("password", jmsPropertiesConfig.getPassword());
        }
        jndiTemplate.setEnvironment(properties);
        return jndiTemplate;
    }

    @Bean
    public JndiDestinationResolver jmsDestionationProvider() {
        JndiDestinationResolver destinationResolver = new JndiDestinationResolver();
        destinationResolver.setJndiTemplate(jndiTemplate());
        return destinationResolver;
    }

    @Bean
    public JndiObjectFactoryBean connectionFactory(){
        JndiObjectFactoryBean cf = new JndiObjectFactoryBean();
        cf.setJndiTemplate(jndiTemplate());
        cf.setJndiName(jmsPropertiesConfig.getConnectionFactoryName());
        return cf;
    }

    @Bean
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory((ConnectionFactory) connectionFactory().getObject());
        template.setSessionAcknowledgeModeName("AUTO_ACKNOWLEDGE");
        template.setSessionTransacted(true);
        template.setDestinationResolver(jmsDestionationProvider());
        return template;
    }

    @Bean
    public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory((ConnectionFactory) connectionFactory().getObject());
        factory.setDestinationResolver(jmsDestionationProvider());
        factory.setErrorHandler(jmsErrorHandler);
        factory.setSessionAcknowledgeMode(0);
        return factory;
    }
}

