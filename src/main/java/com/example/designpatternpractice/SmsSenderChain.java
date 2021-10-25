package com.example.designpatternpractice;

public class SmsSenderChain extends MessageSenderChain {
    @Override
    protected void execute(User user, MessageDetail messageDetail) {
        System.out.println("SMS 메시지 전송");
    }
}
