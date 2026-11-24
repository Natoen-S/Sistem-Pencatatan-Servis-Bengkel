
import java.util.ArrayList;
import java.util.Scanner;
public class Servis {
    private String nomorAntrean;
    private String jenisServis;
    private String statusServis;
    private Kendaraan kendaraan;
    private Mekanik mekanik;
    private ArrayList<String> sparepart = new ArrayList<>();
    private int totalBiaya;

    public Servis() {
        this.nomorAntrean = "-";
        this.jenisServis = "-";
        this.statusServis = "Belum Selesai";
    }

    public Servis(String nomorAntrean, String jenisServis,
                  Kendaraan kendaraan, Mekanik mekanik) {
        this();
        this.nomorAntrean = nomorAntrean;
        this.jenisServis = jenisServis;
        this.kendaraan = kendaraan;
        this.mekanik = mekanik;
    }

    public String getNomorAntrean() {
        return nomorAntrean;
    }

    public String getStatusServis() {
        return statusServis;
    }

    public Kendaraan getKendaraan() {
        return kendaraan;
    }

    public Mekanik getMekanik() {
        return mekanik;
    }

    public int getTotalBiaya() {
        return totalBiaya;
    }

    public void inputData(Scanner input, Kendaraan kendaraan, Mekanik mekanik) {
        this.kendaraan = kendaraan;
        this.mekanik = mekanik;

        System.out.print("Nomor Antrean : ");
        nomorAntrean = input.nextLine();

        System.out.print("Jenis Servis  : ");
        jenisServis = input.nextLine();

        System.out.print("Biaya Jasa    : Rp");
        totalBiaya = Integer.parseInt(input.nextLine());

        String tambah;
        do {
            System.out.print("Nama Sparepart (kosong jika selesai): ");
            String nama = input.nextLine();

            if (nama.isEmpty()) break;

            sparepart.add(nama);

            System.out.print("Harga Sparepart: Rp");
            totalBiaya += Integer.parseInt(input.nextLine());

            System.out.print("Tambah sparepart? (ya/tidak): ");
            tambah = input.nextLine();
        } while (tambah.equalsIgnoreCase("ya"));
    }

    public void ubahStatus(String status) {
        if (status.equalsIgnoreCase("Selesai") ||
            status.equalsIgnoreCase("Belum Selesai")) {
            this.statusServis = status;
        }
    }

    public void tampilkanInfo() {
        System.out.println("\n========================================");
        System.out.println("             DATA SERVIS");
        System.out.println("========================================");
        System.out.printf("%-18s : %s%n", "Nomor Antrean", nomorAntrean);
        System.out.printf("%-18s : %s%n", "Jenis Servis", jenisServis);
        System.out.printf("%-18s : %s%n", "Nomor Polisi",
                kendaraan != null ? kendaraan.getNomorPolisi() : "-");
        System.out.printf("%-18s : %s%n", "Nama Mekanik",
                mekanik != null ? mekanik.getNama() : "-");
        System.out.printf("%-18s : %s%n", "Status Servis", statusServis);
        System.out.printf("%-18s : Rp%,d%n", "Total Biaya", totalBiaya);
        System.out.println("========================================");
    }
}
