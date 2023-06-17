/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Controller.Koneksi;
import Model.Buku;
import Model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
/**
 *
 * @author User
 */
public class daoUser {
    Connection connection;
    final String create = "INSERT INTO tb_user (nik, nama, jkel, telepon, alamat, username, password) VALUES (?,?,?,?,?,?)";
    final String read = "SELECT * FROM tb_user";
    final String update = "UPDATE tb_user SET nama=?, jkel=?, telepon=?, alamat=?, username=?, password=? WHERE nik=?;";
    final String delete = "DELETE FROM tb_user WHERE nik=?;";
    
    public daoUser() {
        connection = Koneksi.connection();
    }
    
    public List<User> getData() {
        List<User> listUs = null;
        try {
            listUs = new ArrayList<>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(read);
            while (rs.next()) {
                User us = new User();
                us.setNik(rs.getInt("nik"));
                us.setNama(rs.getString("nama"));
                us.setJkel(rs.getString("Jkel"));
                us.setTelepon(rs.getInt("telepon"));
                us.setAlamat(rs.getString("alamat"));
                us.setUsername(rs.getString("username"));
                us.setPassword(rs.getString("password"));
                listUs.add(us);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return listUs;
    }
    
    public void tambah(User us){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(create);

            statement.setString(1, us.getNama());
            statement.setString(2, us.getJkel());
            statement.setInt(3, us.getTelepon());
            statement.setString(4, us.getAlamat());
            statement.setString(5, us.getUsername());
            statement.setString(6, us.getPassword());
            statement.setInt(7, us.getNik());
            statement.executeUpdate();
        } catch(SQLException e){
            System.out.println(e);
        }
    }
    
    public void ubah(Buku bk) {
            PreparedStatement statement = null;
            try {                
                statement = connection.prepareStatement(update);                

                statement.setString(1, bk.getJudul());
                statement.setString(2, bk.getPengarang());
                statement.setString(3, bk.getPenerbit());
                statement.setInt(4, bk.getTahun());
                statement.setInt(5, bk.getHarga_sewa());
                statement.setString(6, bk.getStatus());
                statement.setString(7, bk.getKode_buku());
                statement.executeUpdate();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        public void hapus(User us) {
            PreparedStatement statement = null;
            try {
                
                statement = connection.prepareStatement(delete);
                statement.setInt(1, us.getNik());
                statement.executeUpdate();
                System.out.println("p");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
}
