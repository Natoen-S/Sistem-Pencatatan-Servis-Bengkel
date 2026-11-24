import java.util.Scanner;
public class Kendaraan {

    private String nomorPolisi;
    private String merek;
    private String tipe;
    private String namaPemilik;
    private int tahun;

    public Kendaraan() {
        this("Belum diisi", "Belum diisi",
             "Belum diisi", "Belum diisi", 0);
    }

    public Kendaraan(String nomorPolisi, String merek,
                     String tipe, String namaPemilik, int tahun) {
        setNomorPolisi(nomorPolisi);
        setMerek(merek);
        setTipe(tipe);
        setNamaPemilik(namaPemilik);
        setTahun(tahun);
    }

    public String getNomorPolisi() { return this.nomorPolisi; }
    public String getMerek() { return this.merek; }
    public String getTipe() { return this.tipe; }
    public String getNamaPemilik() { return this.namaPemilik; }
    public int getTahun() { return this.tahun; }

    public void setNomorPolisi(String nomorPolisi) {
        if (nomorPolisi != null && !nomorPolisi.trim().isEmpty())
            this.nomorPolisi = nomorPolisi.trim();
    }

    public void setMerek(String merek) {
        if (merek != null && !merek.trim().isEmpty())
            this.merek = merek.trim();
    }

    public void setTipe(String tipe) {
        if (tipe != null && !tipe.trim().isEmpty())
            this.tipe = tipe.trim();
    }

    public void setNamaPemilik(String namaPemilik) {
        if (namaPemilik != null && !namaPemilik.trim().isEmpty())
            this.namaPemilik = namaPemilik.trim();
    }

    public void setTahun(int tahun) {
        if (tahun >= 1900 && tahun <= 2100)
            this.tahun = tahun;
    }

    public void inputData(Scanner input) {
        System.out.println("\n=== INPUT DATA KENDARAAN ===");

        System.out.print("Nomor Polisi : ");
        setNomorPolisi(input.nextLine());

        System.out.print("Merek        : ");
        setMerek(input.nextLine());

        System.out.print("Tipe         : ");
        setTipe(input.nextLine());

        System.out.print("Nama Pemilik : ");
        setNamaPemilik(input.nextLine());

        System.out.print("Tahun        : ");
        try {
            setTahun(Integer.parseInt(input.nextLine()));
        } catch (NumberFormatException e) {
            System.out.println("Tahun harus berupa angka.");
        }
    }

    public void ubahPemilik(String namaBaru) {
        setNamaPemilik(namaBaru);
    }

    public void ubahTahun(int tahunBaru) {
        setTahun(tahunBaru);
    }

    public void tampilkanInfo() {
        System.out.println("\n=== HASIL DATA KENDARAAN ===");
        System.out.println("Nomor Polisi : " + nomorPolisi);
        System.out.println("Merek        : " + merek);
        System.out.println("Tipe         : " + tipe);
        System.out.println("Nama Pemilik : " + namaPemilik);
        System.out.println("Tahun        : " + tahun);
        System.out.println("============================");
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Kendaraan kendaraan = new Kendaraan();

        kendaraan.inputData(input);
        kendaraan.tampilkanInfo();

        input.close();
    }
}
