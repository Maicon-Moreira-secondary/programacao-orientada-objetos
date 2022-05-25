package Trabalho2.Trabalho2Java;

import Trabalho2.Trabalho2Java.Robot;

public class Main {
    public static void main(String[] args) {
        Robot robot = new Robot(1000, 1000, 0, 0, 1, 0.02, 20);
        int totalSteps = 1000;
        for (int i = 0; i < totalSteps; i++) {
            robot.simulate();
            System.out.println(
                    "Step " + i + ": x: " + robot.getX() + " y: " + robot.getY() + " energy: " + robot.getEnergy()
                            + " status: " + robot.getStatus());
        }
    }
}
