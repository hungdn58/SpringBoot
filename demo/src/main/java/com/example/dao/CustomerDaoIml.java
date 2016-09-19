package com.example.dao;

import com.example.model.Customer;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by root on 19/09/2016.
 */
@Repository
public class CustomerDaoIml implements CustomerDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Customer> getAllCustomer() {
        String sql = "SELECT c FROM Customer c";
        TypedQuery<Customer> query = entityManager.createQuery(sql, Customer.class);
        return query.getResultList();
    }

    @Override
    public Customer getCustommerById(long id) {
        String sql = "SELECT c FROM Customer c WHERE c.id = :id";
        TypedQuery<Customer> query = entityManager.createQuery(sql, Customer.class).setParameter("id", id);
        return query.getSingleResult();
    }

    @Override
    public Customer getCustomerByLastName(String name) {
        String sql = "SELECT c FROM Customer c WHERE c.lastName = :lastName";
        TypedQuery<Customer> query = entityManager.createQuery(sql, Customer.class).setParameter("lastName",name);
        return query.getSingleResult();
    }

    @Override
    public void createCustomer(Customer customer) {
        entityManager.persist(customer);
    }
}
