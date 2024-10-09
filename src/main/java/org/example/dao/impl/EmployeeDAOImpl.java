package org.example.dao.impl;

import org.example.dao.EmployeeDAO;
import org.example.entities.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDAOImpl(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Employee> findAll(){
        Session session = sessionFactory.getCurrentSession();

        // Get the CriteriaBuilder from the session
        CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();

        // Create a CriteriaQuery for the Employee entity
        CriteriaQuery<Employee> criteriaQuery = criteriaBuilder.createQuery(Employee.class);

        // Specify the root class for the query
        Root<Employee> root = criteriaQuery.from(Employee.class);

        // Select the root in the criteria query
        criteriaQuery.select(root);

        // Create and execute the query
        return session.createQuery(criteriaQuery).getResultList();
    }
}
