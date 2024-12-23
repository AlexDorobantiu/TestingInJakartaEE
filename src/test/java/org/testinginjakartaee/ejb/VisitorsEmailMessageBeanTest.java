package org.testinginjakartaee.ejb;

import de.hilling.junit.cdi.CdiTestJunitExtension;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.testinginjakartaee.common.VisitorDto;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(CdiTestJunitExtension.class)
@ExtendWith(MockitoExtension.class)
class VisitorsEmailMessageBeanTest {

    @Mock
    VisitorsBean visitorsBean;

    @Inject
    VisitorsEmailMessageBean visitorEmailingBean;

    @Test
    void composeEmailText() {
        when(visitorsBean.getVisitors()).thenReturn(
                Arrays.asList(
                        new VisitorDto("John Doe"),
                        new VisitorDto("Jane Doe")
                )
        );
        String result = visitorEmailingBean.composeEmailText();
        verify(visitorsBean).getVisitors();
        assertEquals("Your page has been visited by John Doe, Jane Doe", result);
    }
}