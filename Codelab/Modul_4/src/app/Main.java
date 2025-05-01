package app;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {

        Buku bukuFiksi = new Fiksi("Hainuwela: Sang Putri kelapa", "Lilis Hu", "Dongeng");
        Buku bukuNonFiksi = new NonFiksi("Madilog", "Tan Malaka", "Sejarah & Ilmu Pengetahuan");

        bukuNonFiksi.displayinfo();
        bukuFiksi.displayinfo();
        System.out.println();

        Anggota anggota1 = new Anggota("Ramanda Bagus P", "380");
        Anggota anggot2 = new Anggota("M Radya I", "370");

        anggota1.displayInfo();
        anggot2.displayInfo();
        System.out.println();
        
        anggota1.pinjamBuku("Madilog");
        anggot2.pinjamBuku("Hainuwela: Sang Putri kelapa", 7);
        System.out.println();

        anggota1.kembalikanBuku("Madilog");
        anggot2.kembalikanBuku("Hainuwela: Sang Putri kelapa");
    }
}