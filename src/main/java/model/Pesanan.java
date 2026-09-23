/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Pesanan {
    public int idPesanan;
    private Pelanggan pelanggan;
    private Layanan layanan; 
    private String jenisPakaian;
    private String ukuran;
    private int jumlah;
    public String statusPesanan;

    public Pesanan(int idPesanan, Pelanggan pelanggan, Layanan layanan, String jenisPakaian, String ukuran, int jumlah) {
        this.idPesanan = idPesanan;
        this.pelanggan = pelanggan;
        this.layanan = layanan;
        this.jenisPakaian = jenisPakaian;
        this.ukuran = ukuran;
        this.jumlah = jumlah;
        this.statusPesanan = "Diproses";
    }
    
    public void tampilkanInvoice() {
        System.out.println("==============================================");
        System.out.println("ID Pesanan     : " + idPesanan);
        System.out.println("Nama           : " + pelanggan.getNama());
        System.out.println("No. Telepon    : " + pelanggan.getNomorTelepon());
        System.out.println("Alamat         : " + pelanggan.getAlamat());
        System.out.println("Jenis Pakaian  : " + jenisPakaian);
        System.out.println("Ukuran         : " + ukuran);
        System.out.println("Jumlah         : " + jumlah + " pcs");
        layanan.tampilkanDetailLayanan();
        System.out.println("Total Bayar    : Rp " + layanan.hitungTotalBiaya(jumlah));
        System.out.println("Status         : " + statusPesanan);
        System.out.println("==============================================");
    }
    
    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }
}
