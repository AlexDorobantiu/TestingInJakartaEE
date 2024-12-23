package org.testinginjakartaee.ejb;

import jakarta.ejb.Stateless;
import jakarta.inject.Inject;
import org.testinginjakartaee.common.VisitorDto;

@Stateless
public class VisitorsEmailMessageBean {

    @Inject
    private VisitorsBean visitorsBean;

    public String composeEmailText() {
        String text = visitorsBean.getVisitors().stream()
                .map(VisitorDto::getName)
                .reduce((a, b) -> a + ", " + b)
                .orElse("no visitors");
        return "Your page has been visited by " + text;
    }
}
