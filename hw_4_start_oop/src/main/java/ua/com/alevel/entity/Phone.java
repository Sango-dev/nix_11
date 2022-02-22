package ua.com.alevel.entity;

public class Phone extends AbstractEntity {

    private String name;
    private PhoneColor color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhoneColor getColor() {
        return color;
    }

    public void setColor(PhoneColor color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Phone: {" +
                "id='" + getId() + '\'' +
                ", name='" + name + '\'' +
                ", color=" + color +
                '}';
    }


}
