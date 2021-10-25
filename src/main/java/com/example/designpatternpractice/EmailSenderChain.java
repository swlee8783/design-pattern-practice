package com.example.designpatternpractice;

public class EmailSenderChain extends MessageSenderChain {
    @Override
    protected void execute(User user, MessageDetail messageDetail) {
        System.out.println("Email 메시지 전송");
    }
}
