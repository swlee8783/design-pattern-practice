package com.example.designpatternpractice;

import static java.util.Objects.nonNull;

public abstract class MessageSenderChain {
    private  MessageSenderChain next;

    public MessageSenderChain next(MessageSenderChain next) {
        this.next = next;
        return next;
    }

    public void send(User user, MessageDetail messageDetail) {
        execute(user, messageDetail);

        if(nonNull(next)){
            next.send(user, messageDetail);
        }
    }

    protected abstract void execute(User user, MessageDetail messageDetail);

    ;
}
