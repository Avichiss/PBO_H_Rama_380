package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {

        Buku bukuFiksi = new Fiksi("Selalu Bersinar", "Tatang", "Dongeng");
        Buku bukuNonFiksi = new NonFiksi("Konspirasi Matahari", "Panther", "Ilmu Pengetahuan");

        System.out.println("========== INFORMASI ==============================");
        bukuNonFiksi.displayinfo();
        bukuFiksi.displayinfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Ramanda Bagus P", "380");
        Anggota anggot2 = new Anggota("M Radya I", "370");
        Anggota anggota3 = new Anggota("M Syaiful Azril", "335");

        System.out.println("========== AKTIVITAS ==============================");
        anggota1.displayInfo();
        anggot2.displayInfo();
        anggota3.displayInfo();
        System.out.println();
        
        anggota1.pinjamBuku("Selalu Bersinar");
        anggot2.pinjamBuku("Konspirasi Matahari", 10);
        System.out.println();

        anggota1.kembalikanBuku("Selalu Bersinar");
        anggot2.kembalikanBuku("Konspirasi Matahari");
        System.out.println("===================================================");
    }
}