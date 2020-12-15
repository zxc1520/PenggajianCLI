package id.polinema.afif;

import java.util.Scanner;

public class Gaji {

    // Array Statis Untuk Nama Karyawan
    static String namaOrang[] = { "Ahmad", "Bagir", "Cindy", "Della", "Ellias", "Fuad", "Ghani"};
    static String nama[] = new String[0];
    static int [] gapok, gatun, lembur;
    static int option, sum;
    static double gajiTotal, total, gajiLembur = 0.06f;

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
                    help();
                    break;
                case 8:
                    tampilkan("Terimakasih !");
                    System.exit(0);
                    break;
                default:
                    tampilkan("Input Mismatch !");
                    break;
            }
        } while (option != 8);
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

        for (int i=0; i < namaOrang.length; i++) {
            tampilkan((i+1) + ".    " + namaOrang[i] + "     |");
        }

        for(int i=0; i < nama.length; i++) {

            tampilkan((i + 1) + ".   " + nama[i] + "         | ");
        }
    }

    private static void gaji() {
        tampil("Masukkan nama karyawan: ");
        String id = pindaikan();

        for (int i=0; i < nama.length &&  i < namaOrang.length; i++) {

            if (nama[i].equals(id) || namaOrang[i].equals(id)) {
                tampilkan("Perhitungan Gaji");

                tampil("Masukkan Gaji Pokok: ");
                gapok[i] = pindai();

                tampil("Masukkan Gaji Tunjangan: ");
                gatun[i] = pindai();

                tampil("Masukkan Lembur per-jam (1-8): ");
                lembur[i] = pindai();

                if (lembur[i] == 1) {
                    total = gajiLembur * 1;
                } else if (lembur[i] == 2) {
                    total = gajiLembur * 2;
                } else if (lembur[i] == 3) {
                    total = gajiLembur * 3;
                } else if (lembur[i] == 4) {
                    total = gajiLembur * 4;
                } else if (lembur[i] == 5) {
                    total = gajiLembur * 5;
                } else if (lembur[i] == 6) {
                    total = gajiLembur * 6;
                } else if (lembur[i] == 7) {
                    total = gajiLembur * 8;
                } else if (lembur[i] == 8) {
                    total = gajiLembur * 8;
                }

                gajiTotal = gapok[i] + gatun[i] + lembur[i];
                tampilkan("Gaji Total: " + gajiTotal);
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
                tampilkan("Nama             : \t" +  nama[i]);
                tampilkan("Gaji Pokok       : \t" + "Rp. " + gapok[i]);
                tampilkan("Gaji Tunjangan   : \t" + "Rp. " + gatun[i]);
                tampilkan("Gaji Lembur      : \t" + "Rp. " + lembur[i]);
                tampilkan("-------------------------");
                tampilkan("\t\t Total Gaji: " + " Rp. " + gajiTotal);
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

    private static void help() {
        tampilkan("=== Bantuan === ");
        tampilkan("Untuk bantuan selengkapnya");
        tampilkan("https://github.com/zxc1520/PenggajianCLI");
    }

    private static void menu() {
        tampilkan("=== Program Penggajian PT XXXX ===");
        tampilkan("1. Input Data Pegawai ");
        tampilkan("2. Lihat Data Pegawai ");
        tampilkan("3. Perhitungan Gaji Pegawai");
        tampilkan("4. Cetak Slip Pegawai ");
        tampilkan("5. Cari Data Pegawai ");
        tampilkan("6. Laporan");
        tampilkan("7. Bantuan");
        tampilkan("8. Keluar");
        tampilkan("==================================");
        tampil("Pilihan anda: ");
        option = pindai();
    }

    /**
     * io kecil bahasa indonesia
     *
     * @author Afif Ghulam
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
