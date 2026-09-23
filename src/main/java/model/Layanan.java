/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class Layanan {
    protected String jenisLayanan;
    protected double hargaDasar;

    public Layanan(String jenisLayanan, double hargaDasar) {
        this.jenisLayanan = jenisLayanan;
        this.hargaDasar = hargaDasar;
    }

    public double hitungTotalBiaya(int jumlah) {
        return this.hargaDasar * jumlah;
    }

    public void tampilkanDetailLayanan() {
        System.out.println("Jenis Jasa     : " + jenisLayanan);
        System.out.println("Harga Dasar    : Rp " + hargaDasar);
    }
}
