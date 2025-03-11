class hewan
{
    String nama;
    String jenis;
    String suara;

    void tampilkaninfo()
    {
        System.out.println("Nama = " + nama);
        System.out.println("Jenis = " + jenis);
        System.out.println("Suara = " + suara);
    }
}
public class codelab1
{
    public static void main(String[] args)
    {
        hewan hewan1 = new hewan();
        hewan hewan2 = new hewan();

        hewan1.nama = "Kucing";
        hewan1.jenis = "Mamalia";
        hewan1.suara = "Nyann~~";

        hewan2.nama = "Anjing";
        hewan2.jenis = "Mamalia";
        hewan2.suara = "Woof-Woof!!";

        System.out.println("Macam - Macam Hewan\n");

        hewan1.tampilkaninfo();
        System.out.println();
        hewan2.tampilkaninfo();
    }
}
