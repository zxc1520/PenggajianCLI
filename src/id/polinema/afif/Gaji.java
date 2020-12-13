package id.polinema.afif;

import java.util.Scanner;

public class Gaji {

    static String nama[] = new String[0];
    static int [] gapok, gatun, lembur;
    static int total, option, sum, jam = 0;

    public static void main(String[] args) {

        do {
            menu();

            switch (option) {
                case 1:
                    data();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    gaji();
                    break;
                case 4:
                    cetak();
                    break;
                case 5:
                    carikan();
                    break;
                case 6:
                    report();
                    break;
                case 7:
                    tampilkan("Terimakasih !");
                    System.exit(0);
                    break;
                default:
                    tampilkan("Input Mismatch !");
                    break;
            }
        } while (option != 7);
    }

    private static void data() {
        tampilkan("=== List Data Karyawan ===");
        tampilkan("Masukkan Jumlah Karyawan");
        sum = pindai();

        nama = new String[sum];
        gapok = new int[sum];
        gatun = new int[sum];
        lembur = new int[sum];

        for (int i=0; i < nama.length; i++) {
            tampil((i+1) + " Masukkan Nama Karyawan ");
            nama[i] = pindaikan();
        }

        tampilkan("Data telah tersimpan !");
    }

    private static void view() {

        tampilkan("List Karyawan");
        tampilkan("No | Nama |");

        for(int i=0; i < nama.length; i++) {
            tampilkan((i + 1) + ".   " + nama[i] + "         | ");
        }
    }

    private static void gaji() {
        tampil("Masukkan nama karyawan: ");
        String id = pindaikan();

        for (int i=0; i < nama.length; i++) {

            if (nama[i].equals(id)) {
                tampilkan("Perhitungan Gaji " + nama[i]);

                tampil("Masukkan Gaji Pokok: ");
                gapok[i] = pindai();

                tampil("Masukkan Gaji Tunjangan: ");
                gatun[i] = pindai();

                tampil("Masukkan Lembur per-jam (1-8): ");
                lembur[i] = pindai();

//                gapok = new int[i];
//                gatun = new int[i];
//                lembur = new int[i];

                total = gapok[i] + gatun[i];
                tampilkan("Gaji Total: " + total);
            }
        }
    }

    private static void cetak() {
        tampilkan("=== Cetak Struk Gaji Karyawan ===");
        tampil("Masukkan nama karyawan: ");
        String id = pindaikan();

        for (int i=0; i < nama.length; i++) {
            if (nama[i].equals(id)) {
                tampilkan("------------------------");
                tampilkan("Struk Gaji PT. XXXX");
                tampilkan("------------------------");
                tampilkan("Nama             : \t" + "Rp. " +  nama[i]);
                tampilkan("Gaji Pokok       : \t" + "Rp. " + gapok[i]);
                tampilkan("Gaji Tunjangan   : \t" + "Rp. " + gatun[i]);
                tampilkan("Gaji Lembur      : \t" + "Rp. " + lembur[i]);
                tampilkan("-------------------------");
                tampilkan("\t\t Total Gaji: " + total);
            }
        }
    }

    private static void carikan() {
        tampilkan("=== Cari Karyawan ===");
        tampil("Masukkan nama karyawan");
        String id = pindaikan();

        for (int i=0; i < nama.length; i++) {
            if (nama[i].equals(id)) {
                tampilkan("No | Nama Karyawan |");
                tampilkan((i + 1) + ".   " + nama[i]);
            }
        }
    }

    private static void report() {
        tampilkan("Laporkan masalah");
    }

    private static void menu() {
        System.out.println("=== Program Penggajian PT XXXX ===");
        System.out.println("1. Input Data Pegawai ");
        System.out.println("2. Lihat Data Pegawai ");
        System.out.println("3. Perhitungan Gaji Pegawai");
        System.out.println("4. Cetak Slip Pegawai ");
        System.out.println("5. Cari Data Pegawai ");
        System.out.println("6. Laporan");
        System.out.println("7. Keluar");
        System.out.println("==================================");
        System.out.print("Pilihan anda: ");
        option = pindai();
    }

    /**
     *
     *
     * @return
     */
    private static int pindai() {
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();

        return val;
    }

    private static String pindaikan() {
        Scanner scanner = new Scanner(System.in);
        String val = scanner.next();

        return val;
    }

    private static void tampil(String val) {
        System.out.print(val);
    }

    private static void tampilkan(String val) {
        System.out.println(val);
    }

}
