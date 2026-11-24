
import java.util.ArrayList;
public class Bengkel {
    private ArrayList<Kendaraan> daftarKendaraan = new ArrayList<>();
    private ArrayList<Mekanik> daftarMekanik = new ArrayList<>();
    private ArrayList<Servis> daftarServis = new ArrayList<>();
    private StackServis riwayatServis = new StackServis();

    public void tambahKendaraan(Kendaraan kendaraan) {
        daftarKendaraan.add(kendaraan);
        System.out.println("Kendaraan berhasil ditambahkan.");
    }

    public void tambahMekanik(Mekanik mekanik) {
        daftarMekanik.add(mekanik);
        System.out.println("Mekanik berhasil ditambahkan.");
    }

    public void tambahServis(Servis servis) {
        if (daftarServis.size() < 10 && riwayatServis.push(servis)) {
            daftarServis.add(servis);
            System.out.println("Data servis berhasil ditambahkan.");
        } else {
            System.out.println("Gagal! Kapasitas data servis penuh.");
        }
    }

    public Kendaraan cariKendaraan(String nomor) {
        for (Kendaraan k : daftarKendaraan) {
            if (k.getNomorPolisi().equalsIgnoreCase(nomor)) {
                return k;
            }
        }
        return null;
    }

    public Mekanik cariMekanik(String nama) {
        for (Mekanik m : daftarMekanik) {
            if (m.getNama().equalsIgnoreCase(nama)) {
                return m;
            }
        }
        return null;
    }

    public Servis cariServis(String nomor) {
        for (Servis s : daftarServis) {
            if (s.getNomorAntrean().equalsIgnoreCase(nomor)) {
                return s;
            }
        }
        return null;
    }

    public void selesaikanServis(String nomor) {
        Servis servis = cariServis(nomor);

        if (servis != null) {
            if (servis.getStatusServis().equalsIgnoreCase("Selesai")) {
                System.out.println("Servis sudah diselesaikan sebelumnya.");
                return;
            }

            servis.ubahStatus("Selesai");
            servis.getMekanik().tambahJumlahServis();
            System.out.println("Servis berhasil diselesaikan.");
        } else {
            System.out.println("Servis tidak ditemukan.");
        }
    }

    public void tampilkanKendaraan() {
        System.out.println("\n========================================");
        System.out.println("             DAFTAR KENDARAAN");
        System.out.println("========================================");

        if (daftarKendaraan.isEmpty()) {
            System.out.println("Belum ada data kendaraan.");
            return;
        }

        for (int i = 0; i < daftarKendaraan.size(); i++) {
            System.out.println("\nData Kendaraan ke-" + (i + 1));
            daftarKendaraan.get(i).tampilkanInfo();
        }
    }

    public void tampilkanMekanik() {
        System.out.println("\n========================================");
        System.out.println("              DAFTAR MEKANIK");
        System.out.println("========================================");

        if (daftarMekanik.isEmpty()) {
            System.out.println("Belum ada data mekanik.");
            return;
        }

        for (int i = 0; i < daftarMekanik.size(); i++) {
            System.out.println("\nData Mekanik ke-" + (i + 1));
            daftarMekanik.get(i).tampilkanInfo();
        }
    }

    public void tampilkanServis() {
        System.out.println("\n========================================");
        System.out.println("              DAFTAR SERVIS");
        System.out.println("========================================");

        if (daftarServis.isEmpty()) {
            System.out.println("Belum ada data servis.");
            return;
        }

        for (Servis s : daftarServis) {
            s.tampilkanInfo();
        }
    }

    public void tampilkanLaporan() {
        System.out.println("\n========================================");
        System.out.println("             LAPORAN BENGKEL");
        System.out.println("========================================");
        System.out.printf("%-22s : %d%n", "Jumlah Kendaraan", daftarKendaraan.size());
        System.out.printf("%-22s : %d%n", "Jumlah Mekanik", daftarMekanik.size());
        System.out.printf("%-22s : %d%n", "Jumlah Servis", daftarServis.size());
        System.out.println("========================================");
    }

    public StackServis getRiwayatServis() {
        return riwayatServis;
    }
}
