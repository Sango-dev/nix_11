package ua.com.alevel.db;

import ua.com.alevel.arraylist.CustomArrayList;
import ua.com.alevel.entity.Phone;

public interface PhoneDB {
    void create(Phone phone);
    void update(Phone phone);
    void delete(String id);
    Phone findById(String id);
    CustomArrayList<Phone> findAll();
}
