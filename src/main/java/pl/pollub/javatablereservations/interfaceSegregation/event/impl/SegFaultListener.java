package pl.pollub.javatablereservations.interfaceSegregation.event.impl;

import pl.pollub.javatablereservations.interfaceSegregation.event.SystemEventHandler;

public class SegFaultListener implements SystemEventHandler {

    @Override
    public void handleSystemEvents(String systemMessage) {
        if (systemMessage.equals("SEG_FAULT")) {
            System.out.println("Sending email to system admin...");
        }
    }
}
