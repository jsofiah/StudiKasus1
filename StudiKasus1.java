import java.util.Scanner;
public class StudiKasus1 {
    static String[][] namaMahasiswa = new String[100][24];
    static int[][] nim = new int[100][24];
    static int[][] sks = new int[100][24];
    static int[] totalSks = new int[100];
    static int indexMahasiswa;
    static int indexMatkul;
    static String[][] kodeMatKul = new String[100][24];
    static String[][] namaMatKul = new String[100][24];

    static void tambahData(){
        Scanner kel4 = new Scanner(System.in);
        String tambahData;
        int indexMatkul = 0;
        
        System.out.println("=======Tambah Data KRS=======");
        System.out.print("Nama Mahasiswa: ");
        namaMahasiswa[indexMahasiswa][indexMatkul] = kel4.nextLine();
        System.out.print("NIM: ");
        nim[indexMahasiswa][indexMatkul] = kel4.nextInt();
        kel4.nextLine();

        do{
            if(totalSks[indexMahasiswa] >= 24){
                System.out.println("SKS Anda sudah mencapai batas maximum.");
                break;
            }
            
                System.out.print("Kode Mata Kuliah: ");
                kodeMatKul[indexMahasiswa][indexMatkul] = kel4.nextLine();
                System.out.print("Nama Mata Kuliah: ");
                namaMatKul[indexMahasiswa][indexMatkul] = kel4.nextLine();
                while (true) {
                    System.out.print("Jumlah SKS (1-3): ");
                    sks[indexMahasiswa][indexMatkul] = kel4.nextInt();
                    kel4.nextLine();
                    
                    if (sks[indexMahasiswa][indexMatkul] >=1 && sks[indexMahasiswa][indexMatkul] <= 3) {
                        if (totalSks[indexMahasiswa] + sks[indexMahasiswa][indexMatkul] > 24) {
                            System.out.println("SKS akan melebihi batas maximum. Silakan masukkan lagi");
                        }
                        else{
                            nim[indexMahasiswa][indexMatkul] = nim[indexMahasiswa][0];
                            namaMahasiswa[indexMahasiswa][indexMatkul] = namaMahasiswa[indexMahasiswa][0];
                            totalSks[indexMahasiswa] += sks[indexMahasiswa][indexMatkul];
                            indexMatkul++;
                            break;
                        }
                    }
                    else{
                        System.out.println("Jumlah SKS harus antara 1-3. Silakan masukkan lagi");
                    }
                }
            System.out.print("Tambah mata kuliah lain? (y/t): ");
            tambahData = kel4.nextLine();
            
        } while(tambahData.equalsIgnoreCase("y"));
        System.out.println("Total SKS yang diambil: " + totalSks[indexMahasiswa]);
        indexMahasiswa++;
    }
    static void tampilkanData(){
        Scanner kel4 = new Scanner(System.in);
        int nimKey;
        boolean temukan = false;
        System.out.print("Masukkan NIM Mahasiswa: ");
        nimKey = kel4.nextInt();

        for (int i = 0; i < indexMahasiswa; i++) {
            for (int j = 0; j < 24; j++) {
                if(nim[i][j]== nimKey){
                    temukan = true;
                    System.out.printf("%-10s %-10s %-10s %-25s %-3s\n", "NIM", "Nama", "Kode MK", "Nama Mata Kuliah", "SKS");
                    for (int k = 0; k < 24; k++) {
                        if (kodeMatKul[i][k] != null) {
                            System.out.printf("%-10d %-10s %-10s %-25s %-3d\n",
                                    nim[i][k], namaMahasiswa[i][k], kodeMatKul[i][k], namaMatKul[i][k], sks[i][k]);
                        }
                    }
                    System.out.println("Total SKS: " + totalSks[i]);
                    break;
                }
            }
        }
        if (temukan == false) {
            System.out.print("Data tidak ditemukan untuk NIM: " + nimKey);
        }
    }
    static void analisisData() {
        int jumlahMahasiswa = 0;
        for (int i = 0; i < indexMahasiswa; i++) {
            if (totalSks[i] < 20) {
                jumlahMahasiswa++;
            }
        }
        System.out.println("\n=====Analisis Data KRS=====");
        System.out.println("Jumlah mahasiswa yang mengambil SKS kurang dari 20: " + jumlahMahasiswa);
    }
    public static void main(String[] args) {
        Scanner kel4 = new Scanner(System.in);
        int menu;
        while (true) {
            System.out.println("\n==================================");
            System.out.println("| Sistem Pemantauan KRS Mahasiswa |");
            System.out.println("| 1. Tambah Data KRS");
            System.out.println("| 2. Tampilkan Daftar KRS Mahasiswa");
            System.out.println("| 3. Analisis Data KRS");
            System.out.println("| 4. Keluar");
            System.out.print("Pilih menu: ");
            menu = kel4.nextInt();

            if(menu == 1){
                tambahData();
            } 
            else if(menu == 2){
                tampilkanData();
            }
            else if (menu == 3) {
                analisisData();
            }
            else if(menu == 4){
                System.out.println("Terima kasih!");
                break;
            }
            else{
                System.out.println("Pilihan tidak valid, masukkan lagi");
            }
        }
    }
}