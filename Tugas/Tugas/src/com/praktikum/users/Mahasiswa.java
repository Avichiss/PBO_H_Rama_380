package com.praktikum.users;

import java.util.Scanner;
import com.praktikum.actions.*;

public class Mahasiswa extends User implements MahasiswaActions {
    Scanner scan = new Scanner(System.in);

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void login(String inputNama, String inputNim) {
        if (inputNama.trim().equals(getNama()) && inputNim.trim().equals(getNim())) {
            System.out.println("Login Mahasiswa berhasil!");
            displayInfo();
            displayAppMenu();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
    }

    @Override
    public void displayAppMenu() {
        while (true) {
            System.out.println("|=================================|");
            System.out.println("|          MENU MAHASISWA         |");
            System.out.println("|=================================|");
            System.out.println("| 1.Laporkan Barang Hilang        |");
            System.out.println("| 2.Lihat Daftar Laporan          |");
            System.out.println("| 0.Logout                        |");
            System.out.println("|=================================|");

            System.out.print("========   Pilih Menu:  =======\n");
            int pilihan = scan.nextInt();
            scan.nextLine();

            if (pilihan == 1) {
                reportItem();
            } else if (pilihan == 2) {
                viewReportedItems();
            } else if (pilihan == 0) {
                break;
            } else {
                System.err.println("Pilihan Tidak Valid");
            }
        }
    }

    @Override
    public void reportItem() {
        System.out.print("Masukkan nama barang: ");
        String namaBarang = scan.nextLine();
        System.out.print("Masukkan deskripsi barang: ");
        String deskripsiBarang = scan.nextLine();
        System.out.print("Lokasi terakhir ditemukan: ");
        String lokasiTerakhir = scan.nextLine();

        System.out.println("\n|-------------------------------|");
        System.out.println("|       LAPORAN BARANG          |");
        System.out.println("|-------------------------------|");
        System.out.println("| Nama Barang   :" + namaBarang +"\t\t\t\t|");
        System.out.println("|-------------------------------|");
        System.out.println("| Deskripsi     :"  + deskripsiBarang +"\t\t\t\t|");
        System.out.println("|-------------------------------|");
        System.out.println("| Lokasi Terakhir:" + lokasiTerakhir +"\t\t\t\t|");
        System.out.println("|-------------------------------|");
    }

    @Override
    public void viewReportedItems() {
        System.err.println("\n>> Fitur Lihat Laporan Belum Tersedia <<");
    }
}
