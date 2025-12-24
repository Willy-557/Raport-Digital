import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class File {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        HashMap <String, ArrayList<Integer>> dataSiswa = new HashMap<>();

        while (true) {
            System.out.println("\n=== Raport Digital ===");
            System.out.println("1. Tambah Siswa Baru");
            System.out.println("2. Input Nilai Ujian");
            System.out.println("3. Lihat Raport Kelas");
            System.out.println("4. Keluar");

            System.out.print(">> ");
            int opsi = scanner.nextInt();
            scanner.nextLine();

            if (opsi == 4) {
                System.out.println("\nTerimakasih!");
                break;
            }
            else if (opsi > 4 || opsi < 1) {
                System.out.println("\nInvalid input!");
                continue;
            }
            else {
                switch (opsi) {

                    // Tambah Siswa Baru
                    case 1:
                        System.out.println("\n--- Penambahan Siswa Baru ---");
                        System.out.print("Masukkan nama siswa baru: ");
                        String namaSiswaBaru = scanner.nextLine();

                        // Untuk cek apakah namanya siswa yang baru diinput sudah ada di sistem atau tidak.
                        if (dataSiswa.containsKey(namaSiswaBaru)) {
                            System.out.println("\nSiswa yang bernama '" + namaSiswaBaru + "' sudah ada di dalam sistem!");
                            break;
                        }
                        else {
                            ArrayList<Integer> nilaiSiswa = new ArrayList<>();
                            dataSiswa.put(namaSiswaBaru, nilaiSiswa);
                            System.out.println("\nSiswa bernama '" + namaSiswaBaru + "' berhasil di-tambahkan ke sistem!");
                            break;
                        }

                    // Input Nilai Ujian
                    case 2:
                        if (dataSiswa.isEmpty()){
                            System.out.println("\nData siswa masih kosong!");
                            break;
                        }
                        else {
                            System.out.println("\n--- Penambahan Nilai Siswa ---");
                            
                            System.out.println("\nDaftar siswa:");
                            for (String namaSiswa : dataSiswa.keySet()){
                                System.out.println("- " + namaSiswa);
                            }

                            System.out.print("\nPilih siswa yang ingin di-inputkan nilainya: ");
                            String pilihanSiswa = scanner.nextLine();


                            // Double check agar nilai yang akan di-input sesuai dengan nama siswa
                            if (!dataSiswa.containsKey(pilihanSiswa)) {
                                System.out.println("\nSiswa yang bernama '" + pilihanSiswa + "' tidak ada di dalam sistem!");
                                continue;
                            }
                            else {

                                // Double check untuk nilai (range 0-100)
                                while (true) {
                                    System.out.print("\nMasukkan nilai siswa: ");
                                    int nilai = scanner.nextInt();
                                    scanner.nextLine();

                                    if (nilai > 100 || nilai < 0) {
                                        System.out.println("\nInput nilai hanya antara 0 - 100.");
                                        continue;
                                    }
                                    else {
                                        dataSiswa.get(pilihanSiswa).add(nilai);
                                        System.out.println("\nPenambahan nilai terhadap siswa yang bernama '" + pilihanSiswa + "' dengan nilai '" + nilai + "' berhasil di-lakukan!");
                                        break;
                                    }
                                }
                                break;
                            }
                        }

                    // Lihat Raport Kelas
                    case 3:
                        if (dataSiswa.isEmpty()) {
                            System.out.println("\nData siswa masih kosong!");
                        }
                        else {
                            System.out.println("\n--- Raport Kelas ---");

                            // Untuk print output
                            for (String NamaSiswa : dataSiswa.keySet()){

                                // Validasi apakah nilai masih kosong atau ada isinya?
                                if (dataSiswa.get(NamaSiswa).isEmpty()) {
                                    System.out.println("\nData siswa '" + NamaSiswa + "' masih kosong!");
                                    continue;
                                }

                                else {
                                        System.out.println("\nSiswa: " + NamaSiswa);
                                    System.out.print("- Nilai : ");
                                    int totalNilai = 0;
                                    double hasil = 0;
                                    
                                    for (Integer nilai : dataSiswa.get(NamaSiswa)){
                                        System.out.print(nilai + ", ");
                                        totalNilai += nilai;
                                        }
                                    
                                    // Untuk print rata-rata dan menentukan lulus atau tidak
                                    hasil = totalNilai / dataSiswa.get(NamaSiswa).size();
                                    System.out.println("\n- Rata - rata : " + hasil);
                                    if (hasil >= 75) {
                                        System.out.println("- Status : LULUS");
                                    }
                                    else if (hasil < 75) {
                                        System.out.println("- Status : REMIDI");
                                    }
                                }
                            }
                        }
                }          
            }
        }
    }   
}
