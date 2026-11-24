
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        Bengkel bengkel = new Bengkel();

        int pilihan;

        do {
            System.out.println("\n======================================");
            System.out.println("     SISTEM PENCATATAN SERVIS BENGKEL");
            System.out.println("======================================");
            System.out.println("1. Tambah Data Kendaraan");
            System.out.println("2. Tambah Data Mekanik");
            System.out.println("3. Tambah Transaksi Servis");
            System.out.println("4. Tampilkan Data Kendaraan");
            System.out.println("5. Tampilkan Data Mekanik");
            System.out.println("6. Tampilkan Data Servis");
            System.out.println("7. Selesaikan Transaksi Servis");
            System.out.println("8. Tampilkan Riwayat Servis");
            System.out.println("9. Tampilkan Laporan Bengkel");
            System.out.println("0. Keluar");
            System.out.println("======================================");

            pilihan = inputAngka(input, "Masukkan pilihan: ");

            switch (pilihan) {

                case 1: {
                    Kendaraan kendaraan = new Kendaraan();

                    kendaraan.inputData(input);
                    bengkel.tambahKendaraan(kendaraan);
                    break;
                }

                case 2: {
                    Mekanik mekanik = new Mekanik();

                    mekanik.inputData(input);
                    bengkel.tambahMekanik(mekanik);
                    break;
                }

                case 3: {
                    System.out.println("\n=== TAMBAH TRANSAKSI SERVIS ===");

                    System.out.print("Masukkan Nomor Polisi: ");
                    String nomorPolisi = input.nextLine();

                    Kendaraan kendaraanServis =
                            bengkel.cariKendaraan(nomorPolisi);

                    if (kendaraanServis == null) {
                        System.out.println("Kendaraan tidak ditemukan. Tambahkan kendaraan terlebih dahulu.");
                        break;
                    }

                    System.out.print("Masukkan Nama Mekanik: ");
                    String namaMekanik = input.nextLine();

                    Mekanik mekanikServis =
                            bengkel.cariMekanik(namaMekanik);

                    if (mekanikServis == null) {
                        System.out.println("Mekanik tidak ditemukan. Tambahkan mekanik terlebih dahulu.");
                        break;
                    }

                    Servis servis = new Servis();

                    servis.inputData(
                            input,
                            kendaraanServis,
                            mekanikServis
                    );

                    bengkel.tambahServis(servis);
                    break;
                }

                case 4: {
                    bengkel.tampilkanKendaraan();
                    break;
                }

                case 5: {
                    bengkel.tampilkanMekanik();
                    break;
                }

                case 6: {
                    bengkel.tampilkanServis();
                    break;
                }

                case 7: {
                    System.out.println("\n=== SELESAIKAN SERVIS ===");

                    System.out.print("Masukkan Nomor Antrean: ");
                    String nomorAntrean = input.nextLine();

                    bengkel.selesaikanServis(nomorAntrean);
                    break;
                }

                case 8: {
                    bengkel.getRiwayatServis().tampilkanStack();
                    break;
                }

                case 9: {
                    bengkel.tampilkanLaporan();
                    break;
                }

                case 0: {
                    System.out.println("\nTerima kasih telah menggunakan");
                    System.out.println("Sistem Pencatatan Servis Bengkel.");
                    break;
                }

                default: {
                    System.out.println("Pilihan tidak tersedia. Silakan coba kembali.");
                }
            }

        } while (pilihan != 0);

        input.close();
    }

    private static int inputAngka(Scanner input, String pesan) {

        while (true) {
            System.out.print(pesan);

            try {
                return Integer.parseInt(input.nextLine());

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka! Silakan masukkan kembali.");
            }
        }
    }
}
