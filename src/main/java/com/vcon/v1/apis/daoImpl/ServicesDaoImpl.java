package com.vcon.v1.apis.daoImpl;

import com.vcon.v1.apis.dao.ServicesDao;
import com.vcon.v1.apis.model.Categories;
import com.vcon.v1.apis.model.Services;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ServicesDaoImpl implements ServicesDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Services> get() {
        Session currentsession = entityManager.unwrap(Session.class);
        Query query = currentsession.createQuery("from Services", Services.class);
        return query.getResultList();
    }

    @Override
    public Services get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Services.class, id);
    }

    @Override
    public void save(Services services) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(services);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Services services = currentSession.get(Services.class, id);
        if (services != null) {
            currentSession.delete(services);
        }
    }
}
