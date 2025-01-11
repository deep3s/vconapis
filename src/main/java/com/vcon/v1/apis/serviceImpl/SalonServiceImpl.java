package com.vcon.v1.apis.serviceImpl;

import com.vcon.v1.apis.dao.SalonDao;
import com.vcon.v1.apis.model.Salon;
import com.vcon.v1.apis.service.SalonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SalonServiceImpl implements SalonService {
    @Autowired
    SalonDao salonDao;

    @Transactional
    @Override
    public List<Salon> get() {

        return salonDao.get();
    }

    @Transactional
    @Override
    public Salon get(int id) {
        return null;
    }

    @Transactional
    @Override
    public void save(Salon salon) {

    }

    @Transactional
    @Override
    public void delete(int id) {

    }
}
