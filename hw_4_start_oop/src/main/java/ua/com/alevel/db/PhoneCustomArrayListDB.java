package ua.com.alevel.db;

import ua.com.alevel.arraylist.CustomArrayList;
import ua.com.alevel.entity.Phone;


public final class PhoneCustomArrayListDB implements PhoneDB{

    private final CustomArrayList<Phone> phones = new CustomArrayList<>();
    private static PhoneCustomArrayListDB instance;

    private PhoneCustomArrayListDB() {}

    public static PhoneCustomArrayListDB getInstance() {
        if (instance == null) {
            instance = new PhoneCustomArrayListDB();
        }
        return instance;
    }

    @Override
    public void create(Phone phone) {
        phone.setId(generateId());
        phones.add(phone);
    }

    @Override
    public void update(Phone phone) {
        Phone current = findById(phone.getId());
        current.setName(phone.getName());
        current.setColor(phone.getColor());
    }

    @Override
    public void delete(String id) {
        phones.delete(findById(id));
    }

    @Override
    public Phone findById(String id) {
        for (int i = 0; i < phones.getLen(); i++) {
            Phone phone = phones.getElemenentById(i);
            if (phone != null && phone.getId().equals(id)) {
                return phone;
            }
        }
        return null;
    }

    @Override
    public CustomArrayList<Phone> findAll() {
        return phones;
    }

    private String generateId() {
        String id = "";
        for (int i = 0; i < 20; i++ ) {
            int k = 48 + (int) (Math.random() * 45);
            id += (char) (k);
        }

        for (int i = 0; i < phones.getLen(); i++ ) {
            Phone phone = phones.getElemenentById(i);
            if (phone != null && phone.getId().equals(id)) {
                return generateId();
            }
        }
        return id;
    }
}
