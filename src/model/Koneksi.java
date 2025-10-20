package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.*;
import javax.swing.JOptionPane;

public class Koneksi {
    private static final String URL = "jdbc:mysql://localhost:3306/gudang";
    private static final String USER = "root";
    private static final String PASS = "";

    public static Connection getConnection() {
        try {
            // Selalu buat koneksi baru agar tidak pakai koneksi lama yang sudah ditutup
            return DriverManager.getConnection(URL, USER, PASS);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Koneksi Gagal: " + e.getMessage());
            return null;
        }
    }
}