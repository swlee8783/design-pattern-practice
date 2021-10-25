package com.example.designpatternpractice.templatemethod.keyboard;

import com.example.designpatternpractice.templatemethod.key.KeyboardKey;

public abstract class Keyboard {
    public void press(KeyboardKey key) {
        keyDown(key);
        System.out.println("입력된 키 : " + key);
        keyUp(key);
    }

    protected abstract void keyUp(KeyboardKey key);

    protected abstract void keyDown(KeyboardKey key);
}
