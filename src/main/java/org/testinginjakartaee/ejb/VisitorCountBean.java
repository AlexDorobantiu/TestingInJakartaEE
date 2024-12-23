package org.testinginjakartaee.ejb;

import jakarta.ejb.Stateless;

@Stateless
public class VisitorCountBean {
    public String getVisitorMessage(int visitorCount) {
        String countString = switch (visitorCount) {
            case 1 -> "first";
            case 2 -> "second";
            case 3 -> "third";
            default -> "nth";
        };
        return "You are the " + countString + " visitor";
    }
}
