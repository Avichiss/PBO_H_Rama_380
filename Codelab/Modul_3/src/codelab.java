class PemainGame{
    private String nama;
    private int kesehatan;

    public PemainGame(String nama, int kesehatan){
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void serang(PemainGame target){
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan shoot thunder");
        target.setKesehatan(target.getKesehatan() - 100);
    }
}

 class Pahlawan extends PemainGame{

    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(PemainGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan bijudama");
        target.setKesehatan(target.getKesehatan() - 20);
    }

}

class Musuh extends PemainGame{

    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(PemainGame target) {
        System.out.println(getNama() + " menyerang " + target.getNama() + " menggunakan domain kegelapan");
        target.setKesehatan(target.getKesehatan() - 15);
    }
}


public class codelab {
    public static void main(String[] args) {
    PemainGame pemaingame = new PemainGame("Ronaldo", 100 );
    Pahlawan pahlawan1 = new Pahlawan("Slankman", 150);
    Pahlawan pahlawan2 = new Pahlawan("Solomon", 500);
    Musuh musuh = new Musuh("LordGrim", 200);


        System.out.println("Status Awal :");
        System.out.println(pemaingame.getNama() + " memiliki kesehatan : " + pemaingame.getKesehatan());
        System.out.println(pahlawan1.getNama() + " memiliki kesehatan : " + pahlawan1.getKesehatan());
        System.out.println(musuh.getNama() + " memiliki kesehatan : " + musuh.getKesehatan());
        pahlawan1.serang(musuh);
        pahlawan2.serang(musuh);
        pemaingame.serang(musuh);
        System.out.println(musuh.getNama() + " sekarang memiliki kesehatan" + musuh.getKesehatan());
        musuh.serang(pahlawan1);
        System.out.println(pahlawan1.getNama() + " sekarang memiliki kesehatan" + pahlawan1.getKesehatan());
        }

    }
