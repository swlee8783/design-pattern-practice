package com.example.designpatternpractice;

public class PushSenderChain extends MessageSenderChain {
    @Override
    protected void execute(User user, MessageDetail messageDetail) {
        System.out.println("Push 메시지 전송");
    }
}
