import java.util.Scanner;
public class Mekanik {

    private String nama;
    private String jenisPerbaikan;
    private String statusKerja;
    private int jumlahServisHariIni;

    public Mekanik() {
        statusKerja = "Belum Selesai";
        jumlahServisHariIni = 0;
    }

    public Mekanik(String nama, String jenisPerbaikan) {
        this.nama = nama;
        this.jenisPerbaikan = jenisPerbaikan;
        this.statusKerja = "Belum Selesai";
        this.jumlahServisHariIni = 0;
    }

    public void inputData(Scanner input) {
        System.out.println("\n========================================");
        System.out.println("           FORM DATA MEKANIK");
        System.out.println("========================================");

        System.out.println("IDENTITAS MEKANIK");
        System.out.print("Nama Mekanik              : ");
        nama = input.nextLine();

        System.out.print("Jenis Perbaikan            : ");
        jenisPerbaikan = input.nextLine();

        do {
            System.out.print("Status Kerja (Selesai/Belum Selesai) : ");
            statusKerja = input.nextLine();

            if (!statusKerja.equalsIgnoreCase("Selesai") &&
                !statusKerja.equalsIgnoreCase("Belum Selesai")) {
                System.out.println("Status tidak valid! Silakan masukkan kembali.");
            }
        } while (!statusKerja.equalsIgnoreCase("Selesai") &&
                 !statusKerja.equalsIgnoreCase("Belum Selesai"));

        statusKerja = statusKerja.equalsIgnoreCase("Selesai")
                ? "Selesai" : "Belum Selesai";

        do {
            System.out.print("Jumlah Servis Hari Ini     : ");

            try {
                jumlahServisHariIni = Integer.parseInt(input.nextLine());

                if (jumlahServisHariIni < 0) {
                    System.out.println("Jumlah servis tidak boleh negatif!");
                }
            } catch (NumberFormatException e) {
                jumlahServisHariIni = -1;
                System.out.println("Masukkan angka yang valid!");
            }
        } while (jumlahServisHariIni < 0);

        System.out.println("========================================");
        System.out.println("        DATA BERHASIL DIINPUT");
        System.out.println("========================================");
    }

    public void setStatusKerja(String statusKerja) {
        if (statusKerja.equalsIgnoreCase("Selesai") ||
            statusKerja.equalsIgnoreCase("Belum Selesai")) {
            this.statusKerja = statusKerja.equalsIgnoreCase("Selesai")
                    ? "Selesai" : "Belum Selesai";
        }
    }

    public void tambahJumlahServis() {
        jumlahServisHariIni++;
    }

    public String getNama() {
        return nama;
    }

    public String getJenisPerbaikan() {
        return jenisPerbaikan;
    }

    public String getStatusKerja() {
        return statusKerja;
    }

    public int getJumlahServisHariIni() {
        return jumlahServisHariIni;
    }

    public void tampilkanInfo() {
        System.out.println("\n========================================");
        System.out.println("           DATA MEKANIK BENGKEL");
        System.out.println("========================================");
        System.out.printf("%-27s : %s%n", "Nama Mekanik", nama);
        System.out.printf("%-27s : %s%n", "Jenis Perbaikan", jenisPerbaikan);
        System.out.printf("%-27s : %s%n", "Status Kerja", statusKerja);
        System.out.printf("%-27s : %d%n", "Jumlah Servis Hari Ini", jumlahServisHariIni);
        System.out.println("========================================");
    }
    
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Mekanik mekanik = new Mekanik();
        mekanik.inputData(input);
        mekanik.tampilkanInfo();

        input.close();
    }
}
