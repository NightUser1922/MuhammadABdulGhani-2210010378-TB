package controller;

import model.Barang;
import model.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class BarangController {

    public void insert(Barang b) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "INSERT INTO barang (nama_barang, stok, harga, id_kategori) VALUES (?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getNama_barang());
            ps.setInt(2, b.getStok());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getId_kategori());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal insert data: " + e.getMessage());
        }
    }

    public ArrayList<Barang> getAllBarang() {
        ArrayList<Barang> list = new ArrayList<>();
        try {
            Connection conn = Koneksi.getConnection();

            // ✅ Gunakan JOIN agar nama kategori ikut diambil
            String sql = "SELECT b.*, k.nama_kategori " +
                         "FROM barang b " +
                         "JOIN kategori k ON b.id_kategori = k.id_kategori";

            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                Barang b = new Barang();
                b.setId_barang(rs.getInt("id_barang"));
                b.setNama_barang(rs.getString("nama_barang"));
                b.setStok(rs.getInt("stok"));
                b.setHarga(rs.getDouble("harga"));
                b.setId_kategori(rs.getInt("id_kategori"));
                b.setNama_kategori(rs.getString("nama_kategori")); // ✅ ambil nama kategori
                list.add(b);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal ambil data: " + e.getMessage());
        }
        return list;
    }

    public void update(Barang b) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "UPDATE barang SET nama_barang=?, stok=?, harga=?, id_kategori=? WHERE id_barang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, b.getNama_barang());
            ps.setInt(2, b.getStok());
            ps.setDouble(3, b.getHarga());
            ps.setInt(4, b.getId_kategori());
            ps.setInt(5, b.getId_barang());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal update data: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "DELETE FROM barang WHERE id_barang=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal hapus data: " + e.getMessage());
        }
    }
}
