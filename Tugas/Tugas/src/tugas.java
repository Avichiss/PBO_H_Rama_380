import java.util.Scanner;

class User {
    private String nama;
    private String nim;

    public User(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {
        return nama;
    }

    public String getNim() {
        return nim;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

    public void login(String inputNama, String inputNim) {

    }

    void displayInfo() {
        System.out.println("Nama: " + nama);
        System.out.println("NIM : " + nim);
    }
}

class Admin extends User {
    private String username = "Admin380";
    private String password = "password380";

    public Admin() {
        super("Admin", "380");
    }

    @Override
    public void login(String user, String pass) {
        if (user.equals(username) && pass.equals(password)) {
            System.out.println("Login Admin berhasil!");
            displayInfo();
        } else {
            System.out.println("Login gagal! Username atau Password salah.");
        }
    }

    @Override
    void displayInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
        System.out.println("Login sukses!");
    }
}

class Mahasiswa extends User {
    public Mahasiswa() {
        super("Ramanda Bagus Prabowo", "202410370110380");
    }

    @Override
    public void login(String inputNama, String inputNim) {
        if (inputNama.equalsIgnoreCase(getNama()) && inputNim.equals(getNim())) {
            System.out.println("Login Mahasiswa berhasil!");
            displayInfo();
        } else {
            System.out.println("Login gagal! Nama atau NIM salah.");
        }
    }

    @Override
    void displayInfo() {
        System.out.println("Nama: " + getNama());
        System.out.println("NIM : " + getNim());
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
