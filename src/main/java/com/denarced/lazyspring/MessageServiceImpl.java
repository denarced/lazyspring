package com.denarced.lazyspring;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class MessageServiceImpl implements MessageService {
    @Resource(name = "message")
    private String message;

    @Override
    public String message() {
        return message;
    }
}
