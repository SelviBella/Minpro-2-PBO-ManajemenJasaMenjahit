/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;
import Controller.Controller;
import model.*;
import java.util.Scanner;
/**
 *
 * @author ASUS
 */
public class View {
    private final Controller controller = new Controller();
    private final Scanner input = new Scanner(System.in);
    
    public void tampilkanMenu() {
        int pilihan = 0;
        do {
            System.out.println("\n=== SISTEM MANAJEMEN JASA MENJAHIT ===");
            System.out.println("1. Tambah Pesanan Baru");
            System.out.println("2. Tampilkan Semua Pesanan");
            System.out.println("3. Ubah Status Pesanan");
            System.out.println("4. Batalkan Pesanan");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu: ");
        
            if (input.hasNextInt()) {
                pilihan = input.nextInt();
                input.nextLine(); 
            } else {
                System.out.println("[Error] Input menu harus berupa angka bulat!");
                input.nextLine(); 
                continue;
            }

            switch (pilihan) {
                case 1:
                    prosesTambah();
                    break;
                case 2:
                    prosesTampil();
                    break;
                case 3:
                    prosesUpdate();
                    break;
                case 4:
                    prosesHapus();
                    break;
                case 5:
                    System.out.println("Keluar dari program. Terima kasih!");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia!");
            }
        }   while (pilihan != 5);
    }
    
    private void prosesTambah() {
        System.out.print("Nama          : ");
        String nama = input.nextLine();
        System.out.print("Nomor Telepon : ");
        String telp = input.nextLine();
        System.out.print("Alamat        : ");
        String alamat = input.nextLine();
        Pelanggan pelanggan = new Pelanggan(nama, telp, alamat);

        System.out.println("Pilih Layanan: 1. Jahit Baru (150rb) | 2. Permak Pakaian (50rb)");
        System.out.print("Pilihan (1/2): ");
        int opsi = input.nextInt();
        input.nextLine();

        Layanan layananTerpilih;
        if (opsi == 1) {
            System.out.print("Jenis Bahan Kain (Biasa/Sutra): ");
            String bahan = input.nextLine();
            layananTerpilih = new LayananJahitBaru(150000, bahan);
        } else {
            System.out.print("Tingkat Kesulitan (Ringan/Berat): ");
            String sulit = input.nextLine();
            layananTerpilih = new LayananPermak(50000, sulit);
        }
        
        System.out.print("Jenis Pakaian (Kemeja/Gaun/Celana): ");
        String jenis = input.nextLine();
        System.out.print("Ukuran (S/M/L/XL): ");
        String ukuran = input.nextLine();
        
        System.out.print("Jumlah (pcs): ");
        int jumlah = input.nextInt();
        input.nextLine();

        controller.tambahPesanan(pelanggan, layananTerpilih, jenis, ukuran, jumlah);
        System.out.println("Pesanan Baru Berhasil Ditambahkan!");
    }

    private void prosesTampil() {
        System.out.println("\n--- DAFTAR ANTRIAN JAHITAN ---");
        if (controller.getDaftarPesanan().isEmpty()) {
            System.out.println("Antrean kosong.");
        } else {
            for (Pesanan p : controller.getDaftarPesanan()) {
                p.tampilkanInvoice();
            }
        }
    }
    
    private void prosesUpdate() {
        System.out.print("Masukkan ID Pesanan yang ingin diubah statusnya: ");
        int id = input.nextInt();
        input.nextLine();
        System.out.print("Masukkan Status Baru (Selesai/Diambil): ");
        String status = input.nextLine();

        if (controller.updateStatus(id, status)) {
            System.out.println("Status Pesanan Berhasil Diperbarui!");
        } else {
            System.out.println("ID Pesanan tidak ditemukan!");
        }
    }

    private void prosesHapus() {
        System.out.print("Masukkan ID Pesanan yang ingin dihapus: ");
        int id = input.nextInt();
        input.nextLine();

        if (controller.hapusPesanan(id)) {
            System.out.println("Pesanan Berhasil Dihapus dari Antrean!");
        } else {
            System.out.println("ID Pesanan tidak ditemukan!");
        }
    }
}