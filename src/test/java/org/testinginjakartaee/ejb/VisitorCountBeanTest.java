package org.testinginjakartaee.ejb;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VisitorCountBeanTest {

    @Test
    void getVisitorMessage() {
        // arrange
        VisitorCountBean visitorCountBean = new VisitorCountBean();
        int count = 3;

        // act
        String message = visitorCountBean.getVisitorMessage(count);

        // assert
        assertEquals("You are the third visitor", message);
    }
}