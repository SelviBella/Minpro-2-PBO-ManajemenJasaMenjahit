# Minpro-2-PBO-ManajemenJasaMenjahit
* **Nama**  : Selvi Bella Dwi Anita
* **NIM**   : 2509116053
* **Kelas** : B

---

## Deskripsi Singkat Program
Program aplikasi jasa menjahit ini dikembangkan untuk mengoptimalkan manajemen antrean pesanan jahit secara otomatis. Dalam program ini, telah diterapkan struktur **MVC (Model View Controller)** agar kode bisa tersusun lebih rapi. Selain itu, program ini juga menerapkan **Inheritance**, **Encapsulation**, dan **Polymorphism** untuk menghitung perbedaan biaya antara layanan jahit pakaian baru dengan layanan permak secara otomatis.

---

## Penjelasan Alur Program
1. **Navigasi Menu Utama**: Aplikasi memunculkan 5 pilihan instruksi menggunakan kombinasi perulangan `do-while` dan percabangan `switch-case`.
2. **Menu 1 (Tambah/Create)**: Pengguna menginput data diri pelanggan, memilih jenis layanan (Jahit Baru atau Permak), memasukkan detail bahan/kesulitan, ukuran, serta kuantitas. Total harga otomatis dihitung secara instan berdasarkan jenis layanan yang dipilih.
3. **Menu 2 (Tampilkan/Read)**: Menjelajahi data di memori untuk menampilkan seluruh daftar antrean pesanan aktif beserta nota rincian harganya.
4. **Menu 3 (Ubah/Update)**: Pengguna dapat mencari ID pesanan tertentu untuk memperbarui rekam status pengerjaannya (misal: "Selesai" atau "Diambil").
5. **Menu 4 (Hapus/Delete)**: Digunakan untuk membatalkan atau menghapus baris pesanan dari antrean permanen berdasarkan ID target.
6. **Menu 5 (Keluar)**: Menghentikan perulangan menu utama dan menutup aplikasi secara aman.

---

## Penjelasan Penerapan Encapsulation & Inheritance
* **Encapsulation:** Semua atribut penting di dalam kelas (seperti nama, nomor telepon, alamat, dan harga) dikunci menggunakan modifier private. Datanya tidak bisa diakses langsung dari luar, melainkan wajib melalui fungsi perantara *Getter dan Setter.
* **Inheritance (Pewarisan)**: Terdapat pada class *Layanan* yang menjadi kelas induk (Superclass). Class ini mewariskan properti umum kepada dua kelas anak (Subclass), yaitu *LayananJahitBaru* dan *LayananPermak* menggunakan kata kunci extends.
* **Validasi Input**: Program menggunakan fungsi input.hasNextInt() untuk memvalidasi ketikan pengguna. Jika pengguna tidak sengaja menginput huruf pada menu angka, program tidak akan error, melainkan menampilkan pesan peringatan dan mengulang menu.
  
---

## Penjelasan Letak Penerapan Nilai Tambah (MVC & Polymorphism)

### Struktur MVC
Program wajib dibagi ke dalam struktur package yang terpisah demi kerapian kode:
1. **`model`** (Tempat Struktur Data): Berisi file `Pelanggan.java`, `Layanan.java`, `LayananJahitBaru.java`, `LayananPermak.java`, and `Pesanan.java`.
2. **`view`** (Tempat Antarmuka): Berisi file `PenjahitView.java` yang bertugas menangani interaksi cetak teks menu CLI dan membaca ketikan `Scanner` dari pengguna.
3. **`controller`** (Tempat Logika Bisnis): Berisi file `PenjahitController.java` yang bertugas memanipulasi, menyimpan, mengubah, dan menghapus data utama di dalam `ArrayList<Pesanan>`.
4. **`main`** (Gerbang Utama): Berisi file `MainApp.java` yang bertugas membuat objek View untuk menjalankan aplikasi pertama kali.

### Polymorphism (Method Overriding)
Polimorfisme diterapkan melalui teknik **Method Overriding** (menulis ulang fungsi kelas induk di kelas anak) untuk menghasilkan perhitungan biaya tambahan yang dinamis berdasarkan jenis kain atau tingkat kesulitan:

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
