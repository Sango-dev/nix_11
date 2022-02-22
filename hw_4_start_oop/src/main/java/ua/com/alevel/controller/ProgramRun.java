package ua.com.alevel.controller;

import ua.com.alevel.arraylist.CustomArrayList;
import ua.com.alevel.entity.Phone;
import ua.com.alevel.entity.PhoneColor;
import ua.com.alevel.service.PhoneService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProgramRun {

    private final static PhoneService phoneService = new PhoneService();

    public static void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String opt;
            while (true) {
                navigation();
                opt = reader.readLine();
                doCrud(opt, reader);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void navigation() {
        System.out.println();
        System.out.println("1. Create phone.");
        System.out.println("2. Update phone.");
        System.out.println("3. Delete phone.");
        System.out.println("4. Find phone by id.");
        System.out.println("5. Find all phones.");
        System.out.println("0. Exit.");
        System.out.print("-> ");
    }

    private static void doCrud(String opt, BufferedReader reader) {
        switch (opt) {
            case "1" -> create(reader);
            case "2" -> update(reader);
            case "3" -> delete(reader);
            case "4" -> findById(reader);
            case "5" -> findAll();
            case "0" -> System.exit(0);
            default -> System.out.println("Incorrect input data!!!");
        }
    }

    private static void create(BufferedReader reader) {
        try {
            System.out.print("Type the phone name: ");
            String name = reader.readLine();
            System.out.print("Type the phone color (black, white, yellow, brown): ");
            String color = reader.readLine();
            PhoneColor phoneColor = PhoneColor.valueOf(color.toUpperCase());
            Phone phone = new Phone();
            phone.setName(name);
            phone.setColor(phoneColor);
            phoneService.create(phone);
        } catch (Exception e) {
            System.out.println("Trouble: " + e.getMessage());
        }
    }

    private static void update(BufferedReader reader) {
        try {
            System.out.print("Type the phone id: ");
            String id = reader.readLine();
            System.out.print("Type the phone name: ");
            String name = reader.readLine();
            System.out.print("Type the phone color (black, white, yellow, brown): ");
            String color = reader.readLine();
            PhoneColor phoneColor = PhoneColor.valueOf(color.toUpperCase());
            Phone phone = new Phone();
            phone.setId(id);
            phone.setName(name);
            phone.setColor(phoneColor);
            phoneService.update(phone);
        } catch (Exception e) {
            System.out.println("Trouble: " + e.getMessage());
        }
    }

    private static void delete(BufferedReader reader) {
        try {
            System.out.print("Type the phone id: ");
            String id = reader.readLine();
            phoneService.delete(id);
        } catch (Exception e) {
            System.out.println("Trouble: " + e.getMessage());
        }
    }

    private static void findById(BufferedReader reader) {
        try {
            System.out.print("Type the phone id: ");
            String id = reader.readLine();
            Phone phone = phoneService.findById(id);
            if (phone == null) {
                System.out.println("Phone with such id doesn't exist!!!");
            } else {
                System.out.println(phone);
            }
        } catch (Exception e) {
            System.out.println("Trouble: " + e.getMessage());
        }
    }

    private static void findAll() {
        boolean flag = false;
        CustomArrayList<Phone> phones = phoneService.findAll();
        for (int i = 0; i < phones.getLen(); i++) {
            Phone phone = phones.getElemenentById(i);
            if (phone != null) {
                flag = true;
                System.out.println(phone);
            }
        }
        if (!flag) {
            System.out.println("Phone's database is empty!!!");
        }
    }
}
