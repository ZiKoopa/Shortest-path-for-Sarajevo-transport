package stu.ssst.edu.ba;

import java.util.Objects;

public class Constraints {
    private final String place1;
    private final String place2;
    private final String constraint;
    private final Double prob;

    public Constraints(String place1, String place2, String constraint, Double prob) {
        this.place1 = place1;
        this.place2 = place2;
        this.constraint = constraint;
        this.prob = prob;
    }

    public String getPlace1() {
        return place1;
    }

    public String getPlace2() {
        return place2;
    }

    public boolean isRoadClosed() {
        switch (constraint) {
            case "medics helicopter":
            case "foggy":
            case "high constructions":
                return Math.random() <= prob;
            default:
                return false;
        }
    }
}