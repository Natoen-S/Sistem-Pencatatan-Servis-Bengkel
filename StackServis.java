public class StackServis {
    private Servis[] data = new Servis[10];
    private int top = -1;

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == data.length - 1;
    }

    public boolean push(Servis servis) {
        if (isFull()) {
            System.out.println("Stack penuh! Riwayat tidak dapat ditambahkan.");
            return false;
        }

        data[++top] = servis;
        return true;
    }

    public Servis pop() {
        if (isEmpty()) {
            System.out.println("Stack kosong! Tidak ada riwayat untuk diambil.");
            return null;
        }

        return data[top--];
    }

    public Servis peek() {
        if (isEmpty()) {
            return null;
        }

        return data[top];
    }

    public void tampilkanStack() {
        System.out.println("\n========================================");
        System.out.println("             RIWAYAT SERVIS");
        System.out.println("========================================");

        if (isEmpty()) {
            System.out.println("Belum ada riwayat servis.");
            System.out.println("========================================");
            return;
        }

        for (int i = top; i >= 0; i--) {
            System.out.println("\nRiwayat ke-" + (top - i + 1));
            System.out.printf("%-18s : %s%n", "Nomor Antrean",
                    data[i].getNomorAntrean());
            System.out.printf("%-18s : %s%n", "Status",
                    data[i].getStatusServis());
            System.out.printf("%-18s : Rp%,d%n", "Total Biaya",
                    data[i].getTotalBiaya());
            System.out.println("----------------------------------------");
        }

        System.out.println("========================================");
    }
}
