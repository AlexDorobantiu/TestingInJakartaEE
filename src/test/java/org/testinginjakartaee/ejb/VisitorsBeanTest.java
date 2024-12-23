package org.testinginjakartaee.ejb;

import de.hilling.junit.cdi.CdiTestJunitExtension;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;


@ExtendWith(CdiTestJunitExtension.class)
class VisitorsBeanTest {

    @Inject
    VisitorsBean visitorsBean;

    @Test
    void addVisitor() {
        visitorsBean.addVisitor("John Doe");
        Assertions.assertEquals(1, visitorsBean.getVisitors().size());
    }
}