/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package model;

/**
 *
 * @author ASUS
 */
public class Pelanggan {
    private String nama;
    private String nomorTelepon;
    private String alamat;

public Pelanggan(String nama, String nomorTelepon, String alamat) {
    this.nama = nama;
    this.nomorTelepon = nomorTelepon;
    this.alamat = alamat;
}

public String getNama() { return nama; }
public void setNama(String nama) { this.nama = nama; }

public String getNomorTelepon() { return nomorTelepon; }
public void setNomorTelepon(String nomorTelepon) { this.nomorTelepon = nomorTelepon; }

public String getAlamat() { return alamat; }
public void setAlamat(String alamat) { this.alamat = alamat; }
}
