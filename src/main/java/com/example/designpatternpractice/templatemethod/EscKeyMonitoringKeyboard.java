package com.example.designpatternpractice.templatemethod;

import com.example.designpatternpractice.templatemethod.key.KeyboardKey;
import com.example.designpatternpractice.templatemethod.keyboard.Keyboard;

public class EscKeyMonitoringKeyboard extends Keyboard {
    @Override
    protected void keyUp(KeyboardKey key) {
        if (isEscKey(key)) {
            System.out.println("logging...key up: " + key.getKey());
        }
    }

    private boolean isEscKey(KeyboardKey key) {
        return "ESC".equalsIgnoreCase(key.getKey());
    }

    @Override
    protected void keyDown(KeyboardKey key) {
        System.out.println("logging...key up: " + key.getKey());
    }
}
