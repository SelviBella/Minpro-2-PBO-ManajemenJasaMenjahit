# Minpro-2-PBO-ManajemenJasaMenjahit
**Nama**  : Selvi Bella Dwi Anita

**NIM**   : 2509116053

**Kelas** : B

---

## Deskripsi Singkat Program
Program aplikasi jasa menjahit ini dikembangkan untuk mengoptimalkan manajemen antrean pesanan jahit secara otomatis. Dalam program ini, telah diterapkan struktur **MVC (Model View Controller)** agar kode bisa tersusun lebih rapi. Selain itu, program ini juga menerapkan **Inheritance**, **Encapsulation**, dan **Polymorphism** untuk menghitung perbedaan biaya antara layanan jahit pakaian baru dengan layanan permak secara otomatis.

---

## Penjelasan Alur Program
1. **Menu Utama**: Aplikasi memunculkan 5 pilihan instruksi menggunakan kombinasi perulangan `do-while` dan percabangan `switch-case`.

   <img width="418" height="172" alt="image" src="https://github.com/user-attachments/assets/5d38c715-563f-4a5a-b0dd-5e06bfa344e6" />

---

2. **Menu 1 (Tambah/Create)**: Pengguna menginput data diri pelanggan, memilih jenis layanan (Jahit Baru atau Permak), memasukkan detail bahan/kesulitan, ukuran, serta kuantitas. Total harga otomatis dihitung secara instan berdasarkan jenis layanan yang dipilih.

   <img width="785" height="703" alt="image" src="https://github.com/user-attachments/assets/1fadf1c8-4725-49e0-a966-e26f4cda2d8d" />

---

3. **Menu 2 (Tampilkan/Read)**: Menampilkan seluruh daftar antrean pesanan aktif beserta nota rincian harganya.

   <img width="565" height="731" alt="image" src="https://github.com/user-attachments/assets/bca00ae1-4a46-472b-943f-e273897d2722" />

---

4. **Menu 3 (Ubah/Update)**: Pengguna dapat mencari ID pesanan tertentu untuk memperbarui rekam status pengerjaannya (misal: "Selesai" atau "Diambil").

   <img width="548" height="680" alt="image" src="https://github.com/user-attachments/assets/7ae2155e-15c9-452f-a948-d171e7ce98c7" />

---

5. **Menu 4 (Hapus/Delete)**: Digunakan untuk membatalkan atau menghapus baris pesanan dari antrean permanen berdasarkan ID pesanan.

   <img width="472" height="723" alt="image" src="https://github.com/user-attachments/assets/9b7e5c3d-f1e7-4a63-aae3-5466e5c1505e" />

---

6. **Menu 5 (Keluar)**: Menghentikan perulangan menu utama dan menutup program aplikasi.

   <img width="375" height="168" alt="image" src="https://github.com/user-attachments/assets/4c33af16-32d2-432e-a9d1-c75d8dfc81f5" />

---

7. **Validasi Input Menu**: Program menggunakan fungsi input.hasNextInt() untuk memvalidasi ketikan pengguna. Jika pengguna tidak sengaja menginput huruf pada menu angka, program tidak akan error, melainkan menampilkan pesan peringatan dan mengulang menu.

   * Ketika pengguna menginput angka yang tidak ada di dalam menu.

     <img width="392" height="162" alt="image" src="https://github.com/user-attachments/assets/629a401d-d40d-4bf8-ae03-3e6e5661cf7f" />

     ---

   * Ketika pengguna menginput huruf.
     
     <img width="378" height="172" alt="image" src="https://github.com/user-attachments/assets/94b2c58d-ee61-4f5d-ae40-d2fc4c348eb9" />

---

## Penjelasan Penerapan Encapsulation & Inheritance
* **Encapsulation:** Semua atribut penting di dalam kelas (seperti nama, nomor telepon, alamat, dan harga) dikunci menggunakan modifier private. Datanya tidak bisa diakses langsung dari luar, melainkan wajib melalui fungsi perantara Getter dan Setter.
```java
public class Pelanggan {
    //Modifier Private
    private String namaPelanggan;
    private String nomorTelepon;
    private String alamat;

    // Getter & Setter
    public String getNamaPelanggan() { 
        return namaPelanggan; 
    }
    
    public void setNamaPelanggan(String namaPelanggan) { 
        this.namaPelanggan = namaPelanggan; 
    }
}
```

* **Inheritance (Pewarisan)**: Terdapat pada class *Layanan* yang menjadi kelas induk (Superclass). Class ini mewariskan properti umum kepada dua kelas anak (Subclass), yaitu *LayananJahitBaru* dan *LayananPermak* menggunakan kata kunci extends.
```java
// Menggunakan kata kunci 'extends' untuk mewarisi sifat dari kelas Layanan
public class LayananJahitBaru extends Layanan { 
    private String jenisBahan; 

    public LayananJahitBaru(double hargaDasar, String jenisBahan) {
        // 'super' digunakan untuk mengirim data ke constructor milik Superclass
        super("Jahit Pakaian Baru", hargaDasar); 
        this.jenisBahan = jenisBahan;
    }
}
```

---

## Penjelasan Letak Penerapan Nilai Tambah (MVC & Polymorphism)

### Struktur MVC
Program dibagi ke dalam struktur package yang terpisah demi kerapian kode:
1. **`model`**: Berisi file `Pelanggan.java`, `Layanan.java`, `LayananJahitBaru.java`, `LayananPermak.java`, and `Pesanan.java`.
2. **`view`**: Berisi file `View.java` yang bertugas menampilkan output kepada pengguna dan membaca input dari pengguna melalui `Scanner`.
3. **`controller`**: Berisi file `Controller.java` yang bertugas memanipulasi, menyimpan, mengubah, dan menghapus data utama di dalam `ArrayList<Pesanan>`.

### Polymorphism (Method Overriding)
Polimorfisme diterapkan melalui **Method Overriding** (menulis ulang fungsi kelas induk di kelas anak) untuk menghasilkan perhitungan biaya tambahan yang dinamis berdasarkan jenis kain atau tingkat kesulitan:

* **Letak Fungsi pada Superclass (`Layanan.java`)**:
```java
public class Layanan {
    protected String jenisLayanan;
    protected double hargaDasar;

    // Method polimorfik dasar yang akan di-override
    public double hitungTotalBiaya(int jumlah) {
        return this.hargaDasar * jumlah;
    }
}
```

* **Overriding pada Subclass 1 (`LayananJahitBaru.java`)**:
Menambahkan biaya kain premium sebesar **Rp 30.000** secara dinamis jika parameter bahan kain bernilai **"Sutra"**.
```java
@Override
public double hitungTotalBiaya(int jumlah) {
    double tambahanBahan = jenisBahan.equalsIgnoreCase("Sutra") ? 30000 : 0;
    return (this.hargaDasar + tambahanBahan) * jumlah;
}
```

* **Overriding pada Subclass 2 (`LayananPermak.java`)**:
Menambahkan biaya jasa penjahit sebesar **Rp 15.000** secara otomatis jika tingkat kerusakannya tergolong **"Berat"**.
```java
@Override
public double hitungTotalBiaya(int jumlah) {
    double tambahanSulit = tingkatKesulitan.equalsIgnoreCase("Berat") ? 15000 : 0;
    return (this.hargaDasar + tambahanSulit) * jumlah;
}
```

* **Eksekusi Secara Polimorfik (`Pesanan.java`)**:
Saat fungsi `.hitungTotalBiaya(jumlah)` dipanggil di dalam nota invoice, Java secara otomatis mendeteksi objek anak mana yang sedang aktif tanpa memerlukan fungsi percabangan manual (`if-else`).
```java
// Eksekusi polimorfik otomatis
System.out.println("Total Bayar    : Rp " + layanan.hitungTotalBiaya(jumlah));
```
