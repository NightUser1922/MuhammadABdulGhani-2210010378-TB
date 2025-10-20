package model;

public class Transaksi {
    private int id_transaksi;
    private String tanggal;
    private int id_barang;
    private int jumlah;
    private String jenis;
    private double total;

    public Transaksi() {}

    public Transaksi(int id_transaksi, String tanggal, int id_barang, int jumlah, String jenis, double total) {
        this.id_transaksi = id_transaksi;
        this.tanggal = tanggal;
        this.id_barang = id_barang;
        this.jumlah = jumlah;
        this.jenis = jenis;
        this.total = total;
    }

    public int getId_transaksi() { return id_transaksi; }
    public void setId_transaksi(int id_transaksi) { this.id_transaksi = id_transaksi; }

    public String getTanggal() { return tanggal; }
    public void setTanggal(String tanggal) { this.tanggal = tanggal; }

    public int getId_barang() { return id_barang; }
    public void setId_barang(int id_barang) { this.id_barang = id_barang; }

    public int getJumlah() { return jumlah; }
    public void setJumlah(int jumlah) { this.jumlah = jumlah; }

    public String getJenis() { return jenis; }
    public void setJenis(String jenis) { this.jenis = jenis; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }
}
