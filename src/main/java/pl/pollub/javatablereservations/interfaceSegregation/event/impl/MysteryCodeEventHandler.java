package pl.pollub.javatablereservations.interfaceSegregation.event.impl;

import pl.pollub.javatablereservations.interfaceSegregation.event.KeyboardEventHandler;

import java.util.List;

public class MysteryCodeEventHandler implements KeyboardEventHandler {

    @Override
    public void handleKeyboardEvents(List<String> characterList) {
        if (characterList.contains("B") && characterList.contains("A")) {
            System.out.println("Secret code entered");
        }
    }
}
