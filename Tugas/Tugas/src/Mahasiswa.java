class Mahasiswa extends User {
    public Mahasiswa(String nama, String nim) {
        super(nama, nim);
    }

    @Override
    public void login(String inputNama, String inputNim) {
        if (inputNama.equals(getNama()) && inputNim.equals(getNim())) {
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