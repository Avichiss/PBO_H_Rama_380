package com.praktikum.main;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.praktikum.error.LoginException;
import com.praktikum.data.Item;
import com.praktikum.users.Admin;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.User;

public class LoginSystem {
    public static List<User> userList = new ArrayList<>();
    public static List<Item> reportedItems = new ArrayList<>();

    public static void main(String[] args) {
    userList.add(new Admin("Admin380", "Password380"));
    userList.add(new Mahasiswa("Ramanda Bagus Prabowo", "202410370110380"));

    Scanner scanner = new Scanner(System.in);
    User loggedInUser = null;

        System.out.println("========== System Login ==========");
        while (loggedInUser == null) {
            System.out.print("Masukkan username/nama: ");
            String username = scanner.nextLine();
            System.out.print("Masukkan password/NIM: ");
            String password = scanner.nextLine();

            try {
                loggedInUser = doLogin(username, password);

                if (loggedInUser == null) {
                    throw new LoginException("\nUser not found!");
                }

                System.out.println("Login berhasil!");

                loggedInUser.displayInfo();
                loggedInUser.displayAppMenu();
            } catch (LoginException e) {
                System.out.println("ERROR: " + e.getMessage());
                System.out.println("Silakan coba lagi.\n");
            }
        }

        scanner.close();
    }

    public static User doLogin(String userInput, String passInput) {
        for (User u : userList) {
            if (u instanceof Admin admin) {
                if (admin.getUsername().equals(userInput) && admin.getPassword().equals(passInput)) {
                    return admin;
                }
            } else if (u instanceof Mahasiswa mhs) {
                if (mhs.getNama().equals(userInput) && mhs.getNim().equals(passInput)) {
                    return mhs;
                }
            }
        }
        return null;
    }
}