import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class File {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        ArrayList<Integer> nilaiSiswa = new ArrayList<>();
        HashMap <String, ArrayList<Integer>> dataSiswa = new HashMap<>();

        while (true) {
            System.out.println("=== Raport Digital ===");
            System.out.println("1. Tambah Siswa Baru");
            System.out.println("2. Input Nilai Ujian");
            System.out.println("3. Lihat Raport Kelas");
            System.out.println("4. Keluar");

            System.out.print(">> ");
            int opsi = scanner.nextInt();
            scanner.nextLine();

            if (opsi == 4) {
                System.out.println("Terimakasih!");
                break;
            }
            else if (opsi > 4 || opsi < 1) {
                System.out.println("Invalid input!");
                continue;
            }
            else {
                switch (opsi) {
                    case 1:
                        System.out.println("--- Penambahan Siswa Baru ---");
                        System.out.print("Masukkan nama siswa baru: ");
                        String namaSiswaBaru = scanner.nextLine();

                        if (dataSiswa.containsKey(namaSiswaBaru)) {
                            System.out.println("Siswa yang bernama '" + namaSiswaBaru + "' sudah ada di dalam sistem!");
                            break;
                        }
                        else {
                            dataSiswa.put(namaSiswaBaru, nilaiSiswa);
                            System.out.println("Siswa bernama '" + namaSiswaBaru + "' berhasil di-tambahkan ke sistem!");
                            break;
                        }
                }   
            }
        }
    }   
}
