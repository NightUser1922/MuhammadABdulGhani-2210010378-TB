package utils;
import java.io.*;
import java.sql.*;
import model.Koneksi;

public class ReportGenerator {
    public static void generateBarangReport() {
        try (Connection conn = Koneksi.getConnection();
             PrintWriter out = new PrintWriter("LaporanBarang.txt")) {
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM barang");
            out.println("===== LAPORAN DATA BARANG =====");
            while (rs.next()) {
                out.printf("%d - %s - %d - %.2f%n",
                    rs.getInt("id_barang"),
                    rs.getString("nama_barang"),
                    rs.getInt("stok"),
                    rs.getDouble("harga"));
            }
            out.println("===============================");
            out.close();
            System.out.println("Laporan berhasil dibuat!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
