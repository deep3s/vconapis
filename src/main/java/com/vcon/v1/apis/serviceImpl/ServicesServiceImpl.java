package com.vcon.v1.apis.serviceImpl;

import com.vcon.v1.apis.dao.ServicesDao;
import com.vcon.v1.apis.model.Services;
import com.vcon.v1.apis.service.ServicesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ServicesServiceImpl implements ServicesService {
    @Autowired
    ServicesDao servicesDao;

    @Transactional
    @Override
    public List<Services> get() {
        return servicesDao.get();
    }

    @Transactional
    @Override
    public Services get(int id) {
        return servicesDao.get(id);
    }

    @Transactional
    @Override
    public void save(Services services){
        servicesDao.save(services);
    }

    @Transactional
    @Override
    public void delete(int id) {
        servicesDao.delete(id);
    }
}
