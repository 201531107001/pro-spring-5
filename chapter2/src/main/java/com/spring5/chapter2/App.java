package com.spring5.chapter2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.spring5.chapter2.config.MessageConfig;
import com.spring5.chapter2.service.MessageCustomer;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = 
                new AnnotationConfigApplicationContext(MessageConfig.class);
        MessageCustomer customer = context.getBean(MessageCustomer.class);
        customer.render();
        context.close();
    }
}
