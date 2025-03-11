class rekeningBank{
    String nomorRekening;
    String namaPemilik;
    double saldo;

    void tampilkanInfo(){
        System.out.println("Nomor Rekening: " + nomorRekening);
        System.out.println("Nama Pemilik: " + namaPemilik);
        System.out.println("Saldo: Rp" + saldo);
    }

    void setorUang(double stor){
        saldo += stor;
        System.out.println(namaPemilik + " menyetor Rp." + stor +" Saldo sekarang: Rp." + saldo);
    }

    void tarikUang(double tarik) {

        if (saldo < tarik)
        {
            System.out.println(namaPemilik + " Menarik Rp." + tarik + " (Gagal, Saldo tidak mencukkupi) Saldo saat ini: Rp." + saldo);
        }
        else
        {
            saldo -= tarik;
            System.out.println(namaPemilik + " Menarik Rp." + tarik + " (Berhasi) Saldo sekarang: Rp." + saldo);
        }
    }
        void tampilanAkhir() {
            System.out.println("Nomor Rekening: " + nomorRekening);
            System.out.println("Nama Pemilik: " + namaPemilik);
            System.out.println("Saldo: " + saldo);
        }
}


public class codelab2
{
    public static void main(String[] args)
    {
        rekeningBank bank1 = new rekeningBank();
        rekeningBank bank2 = new rekeningBank();

        bank1.nomorRekening = "202410370110380";
        bank1.namaPemilik = "Ramanda Bagus Prabowo";
        bank1.saldo = 500000;

        bank2.nomorRekening = "202410370110335";
        bank2.namaPemilik = "Moch Syaiful Azril";
        bank2.saldo = 1000000;

        bank1.tampilkanInfo();
        System.out.println();
        bank2.tampilkanInfo();
        System.out.println();
        bank1.setorUang(200000);
        bank2.setorUang(500000);
        System.out.println();
        bank1.tarikUang(800000);
        bank2.tarikUang(300000);
        System.out.println();
        bank1.tampilanAkhir();
        System.out.println();
        bank2.tampilanAkhir();
    }
}