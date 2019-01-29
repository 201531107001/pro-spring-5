package com.spring5.chapter2.service.impl;

import com.spring5.chapter2.service.MessageProvider;

public class MessageProviderImpl implements MessageProvider {
    @Override
    public String message() {
        return "Hello World!";
    }
}
