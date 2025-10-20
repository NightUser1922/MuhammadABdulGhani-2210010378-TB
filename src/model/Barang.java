package model;

public class Barang {
    private int id_barang;
    private String nama_barang;
    private int stok;
    private double harga;
    private int id_kategori;
    private String nama_kategori; // ✅ Tambahan baru

    public Barang() {}

    // ✅ Konstruktor lengkap (opsional, bisa disesuaikan)
    public Barang(int id_barang, String nama_barang, int stok, double harga, int id_kategori, String nama_kategori) {
        this.id_barang = id_barang;
        this.nama_barang = nama_barang;
        this.stok = stok;
        this.harga = harga;
        this.id_kategori = id_kategori;
        this.nama_kategori = nama_kategori;
    }

    // Getter dan Setter
    public int getId_barang() { return id_barang; }
    public void setId_barang(int id_barang) { this.id_barang = id_barang; }

    public String getNama_barang() { return nama_barang; }
    public void setNama_barang(String nama_barang) { this.nama_barang = nama_barang; }

    public int getStok() { return stok; }
    public void setStok(int stok) { this.stok = stok; }

    public double getHarga() { return harga; }
    public void setHarga(double harga) { this.harga = harga; }

    public int getId_kategori() { return id_kategori; }
    public void setId_kategori(int id_kategori) { this.id_kategori = id_kategori; }

    public String getNama_kategori() { return nama_kategori; }   // ✅ Getter baru
    public void setNama_kategori(String nama_kategori) { this.nama_kategori = nama_kategori; } // ✅ Setter baru
}
