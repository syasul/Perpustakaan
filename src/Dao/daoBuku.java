/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Controller.Koneksi;
import Model.Buku;
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
public class daoBuku {
    Connection connection;
    final String create = "INSERT INTO tb_buku (kode_buku, judul, pengarang, penerbit, tahun, harga_sewa, status) VALUES (?,?,?,?,?,?,?)";
    final String read = "SELECT * FROM tb_buku";
    final String update = "UPDATE tb_buku SET judul=?, pengarang=?, penerbit=?, tahun=?, harga_sewa=?, status=? WHERE kode_buku=?;";
    final String delete = "DELETE FROM tb_buku WHERE kode_buku=?;";
    
    public daoBuku() {
        connection = Koneksi.connection();
    }
    
    public List<Buku> getData() {
        List<Buku> listBrg = null;
        try {
            listBrg = new ArrayList<>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(read);
            while (rs.next()) {
                Buku bk = new Buku();
                bk.setKode_buku(rs.getString("kode_buku"));
                bk.setJudul(rs.getString("judul"));
                bk.setPengarang(rs.getString("pengarang"));
                bk.setPenerbit(rs.getString("penerbit"));
                bk.setTahun(rs.getInt("tahun"));
                bk.setHarga_sewa(rs.getInt("harga_sewa"));
                bk.setStatus(rs.getString("status"));
                listBrg.add(bk);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return listBrg;
    }
    
    public void tambah(Buku bk){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(create);
            statement.setString(1, bk.getKode_buku());
            statement.setString(2, bk.getJudul());
            statement.setString(3, bk.getPengarang());
            statement.setString(4, bk.getPenerbit());
            statement.setInt(5, bk.getTahun());
            statement.setInt(6, bk.getHarga_sewa());
            statement.setString(7, bk.getStatus());
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
                System.out.println(statement.executeUpdate());
                
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        
        public void hapus(Buku bk) {
            PreparedStatement statement = null;
            try {
                
                statement = connection.prepareStatement(delete);
                statement.setString(1, bk.getKode_buku());
                statement.executeUpdate();
                System.out.println("p");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    
}
