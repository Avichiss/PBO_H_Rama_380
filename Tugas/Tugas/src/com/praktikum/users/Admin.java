package com.praktikum.users;

import java.util.Scanner;
import com.praktikum.actions.*;

public class Admin extends User implements AdminActions {
    private String username = "Admin380";
    private String password = "Password380";

    public Admin(String nama, String nim) {
        super(nama, nim);
    }

    Scanner scan = new Scanner(System.in);

    @Override
    public void login(String username, String pass) {
        if (username.equals(this.username) && pass.equals(this.password)) {
            displayInfo();
            displayAppMenu();
        } else {
            System.out.println("Login gagal! Username atau Password salah.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
    }

    @Override
    public void displayAppMenu() {
        while (true) {
            System.out.println("|=============================|");
            System.out.println("|           MENU ADMIN        |");
            System.out.println("|=============================|");
            System.out.println("| 1.Kelola Barang             |");
            System.out.println("| 2.Kelola Mahasiswa          |");
            System.out.println("| 0.Logout                    |");
            System.out.println("|=============================|");

            System.out.print("========   Pilih Menu:  =======\n");
            int pilihan = scan.nextInt();
            scan.nextLine();

            if (pilihan == 1) {
                manageItems();
            } else if (pilihan == 2) {
                manageUsers();
            } else if (pilihan == 0) {
                System.out.println("Logout berhasil. Sampai jumpa, Admin.");
                break;
            } else {
                System.err.println("Pilihan tidak valid.");
            }
        }
    }

    @Override
    public void manageUsers() {
        System.err.println("\n>> Fitur Kelola Mahasiswa Belum Tersedia <<");
    }

    @Override
    public void manageItems() {
        System.err.println("\n>> Fitur Kelola Barang Belum Tersedia <<");
    }
}
