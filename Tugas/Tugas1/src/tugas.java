import java.util.Scanner;

public class tugas {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String username = "Admin380";
        String password = "password380";
        String nama = "ramanda bagus prabowo";
        String nim = "202410370110380";

        System.out.println("Pilih login:");
        System.out.println("1. Admin\n2. Mahasiswa");
        System.out.print("Masukkan pilihan:");
        String pilihan = scanner.nextLine();


        if (pilihan.equals("1")) {
            System.out.print("Masukkan username:");
            String user = scanner.nextLine();
            System.out.print("Masukkan password:");
            String pass = scanner.nextLine();

            if (user.equals(username) && pass.equals(password)) {
                System.out.println("Login Admin berhasil!");
            }
            else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        }

        else if (pilihan.equals("2")) {
            System.out.print("Masukkan Nama:");
            String name = scanner.nextLine();
            System.out.print("Masukkan NIM:");
            String absen = scanner.nextLine();

            if (name.equals(nama) && absen.equals(nim)) {
                System.out.println("Login Mahasiswa berhasil!");
                System.out.println("Nama:" + nama);
                System.out.println("NIM:" + nim);
            }
            else {
                System.out.println("Login gagal! Nama atau NIM salah.");
            }
        }

        else {
            System.out.println("Pilihan tidak valid.");
        }

        scanner.close();
    }
}
