import java.util.Scanner;

class Admin {
    String username = "Admin380";
    String password = "password380";

    void login(String user, String pass) {
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Admin berhasil!");
        } else {
            System.out.println("Login gagal! Username atau password salah.");
        }
    }
}

class Mahasiswa {
    String nama = "Ramanda Bagus Prabowo";
    String nim = "202410370110380";

    void login(String inputNama, String inputNim) {
        if (inputNama.equalsIgnoreCase(nama) && inputNim.equals(nim)) {
            System.out.println("Login Mahasiswa berhasil!");
            displayInfo();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
    }
}



public class tugas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Admin admin = new Admin();
        Mahasiswa siswa = new Mahasiswa();

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
