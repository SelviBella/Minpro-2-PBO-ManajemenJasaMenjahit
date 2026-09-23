/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;
import model.*;
import java.util.ArrayList;
/**
 *
 * @author ASUS
 */
public class Controller {
    private ArrayList<Pesanan> daftarPesanan = new ArrayList<>();
    private int counterId = 1;
    
    public Controller() {
        Pelanggan p1 = new Pelanggan("Bella", "0812345", "Jl. Pramuka");
        Layanan l1 = new LayananJahitBaru(150000, "Sutra");
        daftarPesanan.add(new Pesanan(counterId++, p1, l1, "Gaun", "M", 2));

        Pelanggan p2 = new Pelanggan("Clara", "0898765", "Jl. Perjuangan");
        Layanan l2 = new LayananPermak(50000, "Ringan");
        daftarPesanan.add(new Pesanan(counterId++, p2, l2, "Kemeja", "L", 1));

        Pelanggan p3 = new Pelanggan("Ridho", "0852443", "Jl. M. Yamin");
        Layanan l3 = new LayananPermak(50000, "Berat");
        daftarPesanan.add(new Pesanan(counterId++, p3, l3, "Celana", "XL", 1));
    }
    
    //Create
    public void tambahPesanan(Pelanggan pelanggan, Layanan layanan, String jenis, String ukuran, int jumlah) {
        Pesanan baru = new Pesanan(counterId++, pelanggan, layanan, jenis, ukuran, jumlah);
        daftarPesanan.add(baru);
    }
    
    //Read
    public ArrayList<Pesanan> getDaftarPesanan() {
        return daftarPesanan;
    }
    
    //Update
    public boolean updateStatus(int id, String statusBaru) {
        for (Pesanan p : daftarPesanan) {
            if (p.idPesanan == id) {
                p.statusPesanan = statusBaru;
                return true;
            }
        }
        return false;
    }
    
    //Delete
    public boolean hapusPesanan(int id) {
        for (int i = 0; i < daftarPesanan.size(); i++) {
            if (daftarPesanan.get(i).idPesanan == id) {
                daftarPesanan.remove(i);
                return true;
            }
        }
        return false;
    }
}
