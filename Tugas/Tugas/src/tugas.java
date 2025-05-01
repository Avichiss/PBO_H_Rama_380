import java.util.Scanner;

public class tugas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin("Admin380", "password380");
        Mahasiswa siswa = new Mahasiswa("Ramanda Bagus Prabowo", "202410370110380");

    while (true) {
        System.out.println("Pilih login:");
        System.out.println("1. Admin\n2. Mahasiswa\n3. Keluar");
        System.out.print("Masukkan pilihan:");
        String pilihan = scanner.nextLine();

        if (pilihan.equals("1")) {
            System.out.print("Masukkan username:");
            String user = scanner.nextLine();
            System.out.print("Masukkan password:");
            String pass = scanner.nextLine();
            admin.login(user, pass);

        } else if (pilihan.equals("2")) {
            System.out.print("Masukkan Nama:");
            String nama = scanner.nextLine();
            System.out.print("Masukkan NIM:");
            String nim = scanner.nextLine();
            siswa.login(nama, nim);
        } else if (pilihan.equals("3")) {
            System.out.println("Terimakasih! Program selesai.");
            break;
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

        scanner.close();
    }
}
