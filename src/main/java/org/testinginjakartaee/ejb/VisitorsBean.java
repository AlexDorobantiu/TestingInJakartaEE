package org.testinginjakartaee.ejb;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.testinginjakartaee.common.VisitorDto;
import org.testinginjakartaee.entity.Visitor;

import java.util.List;

@Stateless
public class VisitorsBean {

    @PersistenceContext
    EntityManager entityManager;

    public void addVisitor(String name) {
        Visitor visitor = new Visitor();
        visitor.setName(name);
        entityManager.persist(visitor);
    }

    public List<VisitorDto> getVisitors() {
        return entityManager.createQuery("select v from Visitor v", Visitor.class)
                .getResultList()
                .stream()
                .map((Visitor v) -> new VisitorDto(v.getName()))
                .toList();
    }

}
