package com.vcon.v1.apis.daoImpl;

import com.vcon.v1.apis.dao.CategoriesServiceDao;
import com.vcon.v1.apis.model.Categories;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoriesServiceDaoImpl implements CategoriesServiceDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Categories> get() {
        Session currentsession = entityManager.unwrap(Session.class);
        Query query = currentsession.createQuery("from Categories", Categories.class);
        return query.getResultList();
    }

    @Override
    public Categories get(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        return currentSession.get(Categories.class, id);
    }

    @Override
    public void save(Categories categories) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(categories);
    }

    @Override
    public void delete(int id) {
        Session currentSession = entityManager.unwrap(Session.class);
        Categories categories = currentSession.get(Categories.class, id);
        if (categories != null) {
            currentSession.delete(categories);
        }
    }

}
