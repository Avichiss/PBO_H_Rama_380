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

    }

}

 class Pahlawan extends PemainGame{

    public Pahlawan(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(PemainGame target) {

        super.serang(target);
    }
}

class Musuh extends PemainGame{

    public Musuh(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(PemainGame target) {

        super.serang(target);
    }
}



public class codelab {
    public static void main(String[] args) {
    Pahlawan pahlawan = new Pahlawan("Slankman", 150);
    Musuh musuh = new Musuh("LordGrim", 200);

        System.out.println("Status Awal :");
        System.out.println(pahlawan.getNama() + "memiliki kesehatan :" + pahlawan.getKesehatan());
        System.out.println(musuh.getKesehatan() + "memiliki kesehatan" + musuh.getKesehatan());
    }
}