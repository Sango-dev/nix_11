package ua.com.alevel.arraylist;

public class CustomArrayList<E> {

    private int len;
    private Object Array[];


    public CustomArrayList() {
        len = 1;
        Array = new Object[len];
    }


    public void add(E elem) {
        if (len == 1 && Array[len-1] == null) {
            Array[len-1] = elem;
        } else {
            Object[] newArray = new Object[len];
            for (int i = 0; i < len; i++) {
                newArray[i] = Array[i];
            }
            len++;
            Array = new Object[len];
            for (int i = 0; i < len - 1; i++) {
                Array[i] = newArray[i];
            }
            Array[len-1] = elem;
        }
    }


    public void delete(E elem) {
        boolean flag = false;
        for (int i = 0; i < len; i++) {
            if (Array[i] == elem) {
                for (int j = i + 1; j < len; j++) {
                    Array[j - 1] = Array[j];
                }
                flag = true;
                break;
            }
        }
        if (flag) {
            if (len == 1) {
                Array[len-1] = null;
            } else {
                len--;
                Object[] newArray = new Object[len];
                for (int i = 0; i < len; i++) {
                    newArray[i] = Array[i];
                }
                Array = new Object[len];
                for (int i = 0; i < len; i++) {
                    Array[i] = newArray[i];
                }
            }
        }
    }

    public E getElemenentById(int id) {
        return (E) Array[id];
    }

    public int getLen() {
        return len;
    }
}
