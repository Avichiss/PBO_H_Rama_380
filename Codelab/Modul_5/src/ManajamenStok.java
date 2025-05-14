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
            System.out.println("#Menu Manajamen Stok Makanan#");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

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
                        System.out.println("Barang berhasil ditambahkan.");
                    } catch (InputMismatchException e) {
                        System.out.println("Input stok harus berupa angka!");
                        scan.nextLine();
                    }
                    break;

                case 2:
                    if (daftarBarang.isEmpty()) {
                        System.out.println("Stok barang kosong.");
                    } else {
                        System.out.println("\nDaftar Barang:");
                        Iterator<Barang> iterator = daftarBarang.iterator();
                        while (iterator.hasNext()) {
                            Barang barang = iterator.next();
                            System.out.println("- " + barang.getNama() + " (Stok: " + barang.getStok() + ")");
                        }
                    }
                    break;

                case 3:
                    try {
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Tidak ada barang untuk dikurangi.");
                            break;
                        }

                        System.out.println("Pilih barang yang ingin dikurangi:");
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            System.out.println(i + ". " + daftarBarang.get(i).getNama() + " (Stok: " + daftarBarang.get(i).getStok() + ")");
                        }

                        System.out.print("Masukkan indeks barang: ");
                        int indeks = scan.nextInt();
                        System.out.print("Masukkan jumlah yang ingin dikurangi: ");
                        int jumlah = scan.nextInt();
                        scan.nextLine();

                        Barang barangDipilih = daftarBarang.get(indeks);
                        if (jumlah > barangDipilih.getStok()) {
                            throw new StokTidakCukupException("Stok untuk " + barangDipilih.getNama() + " hanya tersisa " + barangDipilih.getStok());
                        }
                        barangDipilih.setStok(barangDipilih.getStok() - jumlah);
                        System.out.println("Stok berhasil dikurangi.");
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Indeks tidak valid.");
                    } catch (StokTidakCukupException e) {
                        System.out.println("Error: " + e.getMessage());
                    } catch (InputMismatchException e) {
                        System.out.println("Input harus berupa angka!");
                        scan.nextLine();
                    }
                    break;

                case 0:
                    System.out.println("Terima kasih!");
                    scan.close();
                    running = false;
                    break;
            }
        }
    }
}