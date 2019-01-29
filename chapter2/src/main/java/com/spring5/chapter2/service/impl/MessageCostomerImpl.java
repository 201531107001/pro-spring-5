package com.spring5.chapter2.service.impl;

import com.spring5.chapter2.service.MessageCustomer;
import com.spring5.chapter2.service.MessageProvider;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessageCostomerImpl implements MessageCustomer {
    private MessageProvider provider;
    
    @Override
    public void render() {
        System.out.println(provider.message());
    }
}
