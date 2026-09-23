/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ASUS
 */
public class LayananJahitBaru extends Layanan {
    private String jenisBahan;
    
    public LayananJahitBaru(double hargaDasar, String jenisBahan) {
        super("Jahit Pakaian Baru", hargaDasar);
        this.jenisBahan = jenisBahan;
    }

    
    @Override
    public double hitungTotalBiaya(int jumlah) {
        double tambahanBahan = jenisBahan.equalsIgnoreCase("Sutra") ? 30000 : 0;
        return (this.hargaDasar + tambahanBahan) * jumlah;
    }

    @Override
    public void tampilkanDetailLayanan() {
        super.tampilkanDetailLayanan();
        System.out.println("Bahan Kain      : " + jenisBahan);
    }
}
