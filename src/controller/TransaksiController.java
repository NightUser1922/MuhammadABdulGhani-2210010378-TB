package controller;

import model.Transaksi;
import model.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class TransaksiController {

    public void insert(Transaksi t) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "INSERT INTO transaksi (tanggal, id_barang, jumlah, jenis, total) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTanggal());
            ps.setInt(2, t.getId_barang());
            ps.setInt(3, t.getJumlah());
            ps.setString(4, t.getJenis());
            ps.setDouble(5, t.getTotal());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal insert transaksi: " + e.getMessage());
        }
    }

    public ArrayList<Transaksi> getAllTransaksi() {
        ArrayList<Transaksi> list = new ArrayList<>();
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "SELECT * FROM transaksi ORDER BY id_transaksi DESC";
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Transaksi t = new Transaksi();
                t.setId_transaksi(rs.getInt("id_transaksi"));
                t.setTanggal(rs.getString("tanggal"));
                t.setId_barang(rs.getInt("id_barang"));
                t.setJumlah(rs.getInt("jumlah"));
                t.setJenis(rs.getString("jenis"));
                t.setTotal(rs.getDouble("total"));
                list.add(t);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal ambil data transaksi: " + e.getMessage());
        }
        return list;
    }

    public void update(Transaksi t) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "UPDATE transaksi SET tanggal=?, id_barang=?, jumlah=?, jenis=?, total=? WHERE id_transaksi=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, t.getTanggal());
            ps.setInt(2, t.getId_barang());
            ps.setInt(3, t.getJumlah());
            ps.setString(4, t.getJenis());
            ps.setDouble(5, t.getTotal());
            ps.setInt(6, t.getId_transaksi());
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal update transaksi: " + e.getMessage());
        }
    }

    public void delete(int id) {
        try {
            Connection conn = Koneksi.getConnection();
            String sql = "DELETE FROM transaksi WHERE id_transaksi=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Gagal hapus transaksi: " + e.getMessage());
        }
    }
}
