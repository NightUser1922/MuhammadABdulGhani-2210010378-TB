package controller;

import model.Barang;
import model.Koneksi;
import java.sql.*;
import java.util.ArrayList;

public class BarangController {
    Connection conn = Koneksi.getConnection();

    public ArrayList<Barang> getAllBarang() {
        ArrayList<Barang> list = new ArrayList<>();
        try {
            String sql = "SELECT * FROM barang";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Barang b = new Barang(
                    rs.getInt("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("stok"),
                    rs.getDouble("harga"),
                    rs.getInt("id_kategori")
                );
                list.add(b);
            }
        } catch (SQLException e) {
            System.out.println("Gagal mengambil data: " + e.getMessage());
        }
        return list;
    }

    public void insert(Barang b) {
        try {
            String sql = "INSERT INTO barang (nama_barang, stok, harga, id_kategori) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getNama_barang());
            ps.setInt(2, b.getStok());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getId_kategori());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal insert: " + e.getMessage());
        }
    }

    public void update(Barang b) {
        try {
            String sql = "UPDATE barang SET nama_barang=?, stok=?, harga=?, id_kategori=? WHERE id_barang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getNama_barang());
            ps.setInt(2, b.getStok());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getId_kategori());
            ps.setInt(5, b.getId_barang());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal update: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            String sql = "DELETE FROM barang WHERE id_barang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Gagal delete: " + e.getMessage());
        }
    }
}
