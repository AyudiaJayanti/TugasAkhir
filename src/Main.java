import java.util.Scanner;

public class Main {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Selamat Datang Di Aplikasi Rental Mobil");

        String coba = "y";
        int[][] data = {
                {500_000, 5, 4},
                {700_000, 5, 6}
        };

        do {
            System.out.print("Masukkan Nama : ");
            String nama = input.nextLine();

            System.out.println("Pilih Kapasitas\n" +
                    "1. 4 seat\n" +
                    "2. 6 seat");
            int kapasitas = 0;
            int harga = 0;
            do {
                System.out.print("Masukkan pilihan anda : ");
                kapasitas = input.nextInt();
                if (kapasitas == 4) {
                    System.out.println("Sisa Kendaraan : " + data[0][1]);
                    System.out.println("Kapasitas : 4");
                    harga = data[0][0];
                } else if (kapasitas == 6) {
                    System.out.println("Sisa Kendaraan : " + data[1][1]);
                    System.out.println("Kapasitas : 6");
                    harga = data[1][0];
                } else {
                    System.out.println("Tidak Ada");
                }
            }while (kapasitas != 4 && kapasitas != 6);

            byte lamahari = 0;
            do {
                System.out.print("Berapa Hari ? (Max 7 hari) : ");
                lamahari = input.nextByte();

                if (lamahari < 0 || lamahari > 7) {
                    System.out.println("Sewa tidak boleh kurang dari 1 hari dan lebih dari 7 hari");
                }
            } while (lamahari < 0 || lamahari > 7);

            long jumlah = lamahari * harga;
            System.out.println("Total : " + jumlah);

            System.out.print("Metode Pembayaran\n" +
                    "1. Cash\n" +
                    "2. Transfer\n" +
                    "Masukkan pilihan anda :");
            byte metodepembayaran = input.nextByte();

            String metode = null;
            long jumUang = 0;
            if (metodepembayaran == 1) {
                do {
                    metode = "Cash";
                    System.out.println("Masukkan jumlah uang : ");
                    jumUang = input.nextLong();

                    if (jumUang < jumlah) {
                        System.out.println("Uang Kurang");
                    }
                } while (jumUang < jumlah);
            } else if (metodepembayaran == 2) {
                metode = "Transfer";
                System.out.println("NO REKENING : 1332345664");
            } else {
                System.out.println("Tidak Tersedia");
            }

            System.out.println("Metode Pembayaran " + metode);
            System.out.println("Nama : " + nama);
            System.out.println("Kapasitas : " + kapasitas);
            System.out.println("Harga : " + harga + "/hari");
            System.out.println("Total : " + jumlah);
            if (metodepembayaran == 1) {
                System.out.println("Uang Anda : " + jumUang);
                System.out.println("Kembalian : " + (jumUang - jumlah));
            } else if (metodepembayaran == 2) {
                System.out.println("Silahkan Kirim Data Transfer");
            } else {
                System.out.println("Tidak Tersedia");
            }

            if (kapasitas == 1) {
                data[0][1]--;
            } else if (kapasitas == 2) {
                data[1][1]--;
            }
            input.nextLine();

            System.out.print("Mau ulang lagi ? (y/n)");
            coba = input.next();
        }while (coba.equalsIgnoreCase("y"));
    }
}