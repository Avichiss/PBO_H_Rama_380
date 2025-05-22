package com.praktikum.users;

import com.praktikum.actions.*;
import com.praktikum.data.Item;
import com.praktikum.main.LoginSystem;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminActions {
    private String username = "Admin380";
    private String password = "Password380";

    public Admin(String nama, String nim) {
        super(nama, nim);
    }

    Scanner scan = new Scanner(System.in);

    @Override
    public void displayInfo() {
        System.out.println("Login Admin berhasil!");
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
    }

    @Override
    public void displayAppMenu() {
        boolean loop = true;

        while (loop) {
            System.out.println("|=============================|");
            System.out.println("|           MENU ADMIN        |");
            System.out.println("|=============================|");
            System.out.println("| 1. Kelola Barang            |");
            System.out.println("| 2. Kelola Mahasiswa         |");
            System.out.println("| 0. Keluar                   |");
            System.out.println("|=============================|");
            int pilih;
            try {
                System.out.print("========   PILIH MENU:  =======\n");
                pilih = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Input Harus Berupa Angka!!!");
                scan.nextLine();
                continue;
            }
            switch (pilih) {
                case 1:
                    manageItems();
                    break;
                case 2:
                    manageUsers();
                    break;
                case 0:
                    loop = false;
                    LoginSystem.main(null);
                    break;
                default:
                    System.err.println("Pilihan Tidak Valid!!!");
                    loop = false;
                    break;
            }
        }
    }

    @Override
    public void manageUsers() {
        boolean loop = true;

        while (loop) {
            System.out.println("|=============================|");
            System.out.println("|        KELOLA MAHASISWA     |");
            System.out.println("|=============================|");
            System.out.println("| 1. Tambah Mahasiswa         |");
            System.out.println("| 2. Hapus Mahasiswa          |");
            System.out.println("| 3. Kembali                  |");
            System.out.println("|=============================|");

            System.out.print("========   PILIH MENU:  =======\n");
            try {
                int pilih = scan.nextInt();
                scan.nextLine();

                switch (pilih) {
                    case 1:
                        System.out.println("Masukkan Nama Mahasiswa: ");
                        String nama = scan.nextLine();
                        System.out.println("Masukkan NIM Mahasiswa: ");
                        String nim = scan.nextLine();
                        LoginSystem.userList.add(new Mahasiswa(nama, nim));
                        System.out.println("Mahasiswa Berhasil Ditambahkan!");
                        break;

                    case 2:
                        System.out.println("Masukkan NIM Mahasiswa Yang Ingin Dihapus: ");
                        String targetNim = scan.nextLine();
                        boolean temukan = false;

                        Iterator<User> iterator = LoginSystem.userList.iterator();
                        while (iterator.hasNext()) {
                            User user = iterator.next();
                            if (user instanceof Mahasiswa && user.getNim().equals(targetNim)) {
                                iterator.remove();
                                temukan = true;
                                System.out.println("Mahasiswa Dengan NIM " + targetNim + " Berhasil Dihapus. ");
                                break;
                            }
                        }

                        if (!temukan) {
                            System.err.println("Mahasiswa Dengan NIM Tersebut Tidak Ditemukan");
                        }

                        break;

                    case 3:
                        loop = false;
                        break;

                    default:
                        System.err.println("Pilihan Tidak Valid!!!");
                }

            } catch (InputMismatchException e) {
                System.err.println("Input Harus Berupa Angka!!!");
                scan.nextLine();
            }
        }
    }

    @Override
    public void manageItems() {
        boolean loop = true;
        int pilih;
        while (loop) {
            try {
                System.out.println("|===============================|");
                System.out.println("|         KELOLA BARANG         |");
                System.out.println("|===============================|");
                System.out.println("| 1. Lihat Semua Laporan        |");
                System.out.println("| 2. Tandai Barang Yang Diambil |");
                System.out.println("| 3. Kembali                    |");
                System.out.println("|===============================|");
                System.out.print("========   MASUKAN PILIHAN  ======\n");
                pilih = scan.nextInt();
                scan.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Input Harus Berupa Angka!!!");
                scan.nextLine();
                continue;
            }

            switch (pilih) {
                case 1:
                    Iterator<Item> r_iterator = LoginSystem.reportedItems.iterator();

                    if (r_iterator.hasNext()) {
                        int index = 1;

                        while (r_iterator.hasNext()) {
                            Item barang = r_iterator.next();
                            System.out.println("Laporan ke-" + index++);
                            System.out.println("Nama Barang   : " + barang.getItemName());
                            System.out.println("Deskripsi     : " + barang.getDescription());
                            System.out.println("Lokasi        : " + barang.getLocation());
                            System.out.println("Status   : " + barang.getStatus());
                        }
                    } else {
                        System.err.println("Tidak Ada Barang!!!.");
                    }

                    break;
                case 2:
                    Iterator<Item> iterator = LoginSystem.reportedItems.iterator();
                    int index = 0;
                    boolean adaReported = false;

                    System.out.println("NO\tNAMA\t\t\tDESKRIPSI\t\t\t\tLOKASI\t\t\t\tSTATUS");
                    while (iterator.hasNext()) {
                        Item barang = LoginSystem.reportedItems.get(index);
                        if ("Reported".equalsIgnoreCase(barang.getStatus())) {
                            System.out.println(index + "\t"
                                    + barang.getItemName() + "\t\t"
                                    + barang.getDescription() + "\t\t"
                                    + barang.getLocation() + "\t\t"
                                    + barang.getStatus());
                            adaReported = true;
                        }
                        index++;
                        iterator.next();
                    }

                    if (!adaReported) {
                        System.out.println("Tidak ada barang yang masih berstatus 'Reported'.");
                        break;
                    }

                    try {
                        System.out.print("Masukkan nomor indeks barang yang ingin ditandai: ");
                        int inputIndex = scan.nextInt();
                        scan.nextLine();

                        Item barangDipilih = LoginSystem.reportedItems.get(inputIndex);

                        if ("Claimed".equalsIgnoreCase(barangDipilih.getStatus())) {
                            System.out.println("Barang sudah ditandai sebagai 'Claimed'.");
                        } else {
                            barangDipilih.setStatus("Claimed");
                            System.out.println("Barang berhasil ditandai sebagai 'Claimed'!");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("ERROR: Input harus berupa angka!");
                        scan.nextLine();
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("ERROR: Indeks tidak valid. Pastikan angka sesuai daftar!");
                    }

                    break;
                case 3:
                    loop = false;

                    break;
                default:
                    break;
            }
        }
    }
    public String getUsername() {
        return this.username;
    }

    public String getPassword() {
        return this.password;
    }
}



