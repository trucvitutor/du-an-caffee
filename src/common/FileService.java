package common;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import model.CustomerType;
import repository.CustomerTypeRepository;

public class FileService<E> {
    public void writeFile(String file, List<E> orderList) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(orderList);
            fileOutputStream.close();
            objectOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  List<E> readFile(String file) {
        List<E> orderList = new ArrayList<>();
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            orderList = (List<E>) objectInputStream.readObject();
            fileInputStream.close();
            objectInputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return orderList;
    }


}
