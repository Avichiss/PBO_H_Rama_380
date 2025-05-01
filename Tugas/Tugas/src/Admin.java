class Admin extends User {
    private String username = "Admin380";
    private String password = "password380";

    public Admin(String nama, String nim) {
        super(nama, nim);
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
        System.out.println("Nama: " + super.getNama());
        System.out.println("NIM : " + super.getNim());
        System.out.println("Login sukses!");
    }
}