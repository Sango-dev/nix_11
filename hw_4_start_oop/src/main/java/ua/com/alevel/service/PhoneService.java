package ua.com.alevel.service;

import ua.com.alevel.arraylist.CustomArrayList;
import ua.com.alevel.dao.PhoneDao;
import ua.com.alevel.dao.impl.PhoneDaoImpl;
import ua.com.alevel.entity.Phone;

public class PhoneService {

    private final PhoneDao phoneDao = new PhoneDaoImpl();

    public void create(Phone phone) {
        phoneDao.create(phone);
    }

    private boolean checkExistId(String id) {
        if (findById(id) == null) {
            System.out.println("Phone with such id doesn't exist!!!");
            return false;
        }
        return true;
    }


    public void update(Phone phone) {
        if (checkExistId(phone.getId())) {
            phoneDao.update(phone);
        }
    }

    public void delete(String id) {
        if (checkExistId(id)) {
            phoneDao.delete(id);
        }
    }

    public Phone findById(String id) {
        return phoneDao.findById(id);
    }

    public CustomArrayList<Phone> findAll() {
        return phoneDao.findAll();
    }
}

