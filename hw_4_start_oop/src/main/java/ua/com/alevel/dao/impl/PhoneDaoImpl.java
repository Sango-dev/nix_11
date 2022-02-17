package ua.com.alevel.dao.impl;

import ua.com.alevel.arraylist.CustomArrayList;
import ua.com.alevel.dao.PhoneDao;
import ua.com.alevel.db.PhoneCustomArrayListDB;
import ua.com.alevel.db.PhoneDB;
import ua.com.alevel.entity.Phone;

public class PhoneDaoImpl implements PhoneDao {
    private final PhoneDB phoneDB = PhoneCustomArrayListDB.getInstance();

    @Override
    public void create(Phone entity) {
        phoneDB.create(entity);
    }

    @Override
    public void update(Phone entity) {
        phoneDB.update(entity);
    }

    @Override
    public void delete(String id) {
        phoneDB.delete(id);
    }

    @Override
    public Phone findById(String id) {
        return phoneDB.findById(id);
    }

    @Override
    public CustomArrayList<Phone> findAll() {
        return phoneDB.findAll();
    }
}
