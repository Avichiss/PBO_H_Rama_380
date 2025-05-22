import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;
import java.util.InputMismatchException;

public class ManajamenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        daftarBarang.add(new Barang("Nasi Goreng", 20));
        daftarBarang.add(new Barang("Nasi Ayam", 20));
        daftarBarang.add(new Barang("Takoyaki", 30));

        boolean running = true;
        while (running) {
            System.out.println("===== Menu Manajamen Stok =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Masukkan nama barang: ");
                    String nama = scan.nextLine();

                    try {
                        System.out.print("Masukkan stok awal: ");
                        int stok = scan.nextInt();
                        scan.nextLine();
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang " + nama + " berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.err.println("Input stok harus berupa angka!");
                        scan.nextLine();
                    }
                    break;

                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\n------- Daftar Barang ------");
                        Iterator<Barang> iterator = daftarBarang.iterator();
                        while (iterator.hasNext()) {
                            Barang barang = iterator.next();
                            System.out.println("Nama: " + barang.getNama() + " (Stok: " + barang.getStok() + ")");
                            System.out.println("----------------------------");
                        }
                    }
                    break;

                case 3:
                    try {
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Tidak ada barang untuk dikurangi.");
                            break;
                        }

                        System.out.println("--- Daftar Barang ( Pilih untuk Kurangi Stok ) ---");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            System.out.println(i + ". " + daftarBarang.get(i).getNama() + " (Stok: " + daftarBarang.get(i).getStok() + ")");
                        }

                        System.out.print("Masukkan nomor indeks barang: ");
                        int indeks = scan.nextInt();
                        System.out.print("Masukkan jumlah stok yang akan diambil: ");
                        int jumlah = scan.nextInt();
                        scan.nextLine();

                        Barang barangDipilih = daftarBarang.get(indeks);
                        if (jumlah > barangDipilih.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barangDipilih.getNama() + " hanya tersisa " + barangDipilih.getStok());
                        }
                        barangDipilih.setStok(barangDipilih.getStok() - jumlah);
                        System.out.println("Stok barang " + barangDipilih.getNama() + " berhasil dikurangi." + "Sisa stok: " + barangDipilih.getStok());
                    } catch (IndexOutOfBoundsException e) {
                        System.err.println("Indeks tidak valid.");
                    } catch (StokTidakCukupException e) {
                        System.err.println("Error: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.err.println("Input harus berupa angka!");
                        scan.nextLine();
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih! Program berakhir.");
                    scan.close();
                    running = false;
                    break;
            }
        }
    }
}