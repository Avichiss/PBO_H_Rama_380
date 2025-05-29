package com.praktikum.users;

import com.praktikum.actions.*;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaActions {
    Scanner scan = new Scanner(System.in);

    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void displayInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
    }

    @Override
    public void displayAppMenu() {
        boolean loop = true;

        while (loop) {
            System.out.println("|=================================|");
            System.out.println("|          MENU MAHASISWA         |");
            System.out.println("|=================================|");
            System.out.println("| 1. Laporkan Barang Hilang       |");
            System.out.println("| 2. Lihat Daftar Laporan         |");
            System.out.println("| 0. Keluar                       |");
            System.out.println("|=================================|");
            int pilih;
            try {
                System.out.print("========   Pilih Menu:  =======\n");
                pilih = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Input Harus Berupa Angka!!!");
                scan.nextLine();
                continue;
            }
            switch (pilih) {
                case 1:
                    reportItem();
                    break;
                case 2:
                    viewReportedItems();
                    break;
                case 0:
                    loop = false;
                    LoginSystem.main(null);
                    break;
                default:
                    System.err.println("Pilihan Tidak Valid!!!");
                    break;
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

        LoginSystem.reportedItems.add(new Item(namaBarang, deskripsiBarang, lokasiTerakhir));

        System.out.println("\n|-------------------------------|");
        System.out.println("|       LAPORAN BARANG          |");
        System.out.println("|-------------------------------|");
        System.out.println(" Nama Barang   :" + namaBarang);
        System.out.println("|-------------------------------|");
        System.out.println(" Deskripsi     :" + deskripsiBarang);
        System.out.println("|-------------------------------|");
        System.out.println(" Lokasi Terakhir:" + lokasiTerakhir);
        System.out.println("|-------------------------------|");
    }

    @Override
    public void viewReportedItems() {
        Iterator<Item> iterator = LoginSystem.reportedItems.iterator();
        int index = 1;
        boolean adaLaporan = false;

        while (iterator.hasNext()) {
            Item barang = iterator.next();
            System.out.println("Cek Status Barang: '" + barang.getStatus() + "'");
            if (barang.getStatus().equals("Reported")) {
                System.out.println("Laporan ke-" + index++);
                System.out.println("Nama Barang   : " + barang.getItemName());
                System.out.println("Deskripsi     : " + barang.getDescription());
                System.out.println("Lokasi        : " + barang.getLocation());
                System.out.println("---------------------------------");
                adaLaporan = true;
            }
        }

        if (!adaLaporan) {
            System.out.println("Tidak ada barang berstatus 'Reported'.");
        }
    }
}