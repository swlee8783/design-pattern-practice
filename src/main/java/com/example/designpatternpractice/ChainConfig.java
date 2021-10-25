package com.example.designpatternpractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ChainConfig {
    //adaptor
    //repository

    @Bean
    public MessageSenderChain chain() {
        MessageSenderChain chain = new SmsSenderChain();

        chain.next(new PushSenderChain())
                .next(new EmailSenderChain());

        return chain;
    }
}
