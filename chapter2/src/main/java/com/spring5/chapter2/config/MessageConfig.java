package com.spring5.chapter2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.spring5.chapter2.service.MessageCustomer;
import com.spring5.chapter2.service.MessageProvider;
import com.spring5.chapter2.service.impl.MessageCostomerImpl;
import com.spring5.chapter2.service.impl.MessageProviderImpl;

@Configuration
@ComponentScan("com.spring5.chapter2")
public class MessageConfig {
    
    @Bean
    public MessageProvider messageProvider() {
        return new MessageProviderImpl();
    }
    
    @Bean
    public MessageCustomer messageCustomer(MessageProvider provider) {
        return new MessageCostomerImpl(provider);
    }
}
