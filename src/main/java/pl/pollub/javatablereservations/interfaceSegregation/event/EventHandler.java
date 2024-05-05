package pl.pollub.javatablereservations.interfaceSegregation.event;

import java.util.List;

//before interface segregation
public interface EventHandler {
    void handleMouseEvents(double x, double y);
    void handleKeyboardEvents(List<String> characterList);
    void handleSystemEvents(String systemMessage);
}

