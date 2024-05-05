package pl.pollub.javatablereservations.interfaceSegregation.event.impl;

import pl.pollub.javatablereservations.interfaceSegregation.event.MouseEventHandler;

import java.util.ArrayList;
import java.util.List;

public class MouseTracker implements MouseEventHandler {

    private final List<MousePosition> mousePositionList = new ArrayList<>();

    @Override
    public void handleMouseEvents(double x, double y) {
        this.mousePositionList.add(new MousePosition(x, y));
    }

    public class MousePosition {
        private final double x;
        private final double y;

        public MousePosition(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }
    }

}
