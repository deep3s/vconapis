package com.vcon.v1.apis.daoImpl;

import com.vcon.v1.apis.dao.SalonDao;
import com.vcon.v1.apis.model.Salon;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalonDaoImpl implements SalonDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Salon> get() {
        Session currentsession = entityManager.unwrap(Session.class);
        Query query = currentsession.createQuery("from Salon", Salon.class);
        return query.getResultList();
    }

    @Override
    public Salon get(int id) {
        return null;
    }

    @Override
    public void save(Salon salon) {

    }

    @Override
    public void delete(int id) {

    }
}
