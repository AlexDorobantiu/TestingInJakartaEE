package org.testinginjakartaee.servlet;

import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.testinginjakartaee.common.VisitorDto;
import org.testinginjakartaee.ejb.VisitorCountBean;
import org.testinginjakartaee.ejb.VisitorsBean;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "Visitors", value = "/Visitors")
public class Visitors extends HttpServlet {
    @Inject
    VisitorCountBean visitorCountBean;

    @Inject
    VisitorsBean visitorsBean;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<VisitorDto> visitors = visitorsBean.getVisitors();
        req.setAttribute("visitors", visitors);
        req.setAttribute("visitorMessage", visitorCountBean.getVisitorMessage(visitors.size()));
        req.getRequestDispatcher("/WEB-INF/visitors.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        visitorsBean.addVisitor(name);
        resp.sendRedirect(req.getContextPath() + "/Visitors");
    }
}
