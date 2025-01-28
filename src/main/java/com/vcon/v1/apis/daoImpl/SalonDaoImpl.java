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
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Salon.class, id);
    }

    @Override
    public void save(Salon salon) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(salon);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Salon salon = currentSession.get(Salon.class, id);
        if (salon != null) {
            currentSession.delete(salon);
        }
    }

    @Override
    public List<Salon> getSalonsByLocation(String address) {
        Session currentSession = entityManager.unwrap(Session.class);
        // Use a LIKE query to match the address and find salons near the provided address
        Query query = currentSession.createQuery("from Salon where address like :address", Salon.class);
        query.setParameter("address", "%" + address + "%");
        return query.getResultList();
    }

    @Override
    public void updateImageUrls(int id, String imageUrls) {
        Session currentSession = entityManager.unwrap(Session.class);
        Salon salon = currentSession.get(Salon.class, id);
        if (salon != null) {
            salon.setImageUrls(imageUrls);
            currentSession.update(salon);  // Update the salon with new imageUrls
        }
    }


}
