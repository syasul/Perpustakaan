/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import com.mysql.cj.jdbc.MysqlDataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author User
 */
public class Koneksi {
     static Connection koneksi;
    public static Connection connection() {
        if (koneksi == null) {
            MysqlDataSource data = new MysqlDataSource();
            data.setDatabaseName("db_perpus");
            data.setUser("root");
            data.setPassword("");
            try {
                koneksi = data.getConnection();
                System.out.println("Sudah Konek");
            } catch (SQLException ex) {
                System.out.println("Tidak Konek");
            }
        }
        return koneksi;
    }
}
