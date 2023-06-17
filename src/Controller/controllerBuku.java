/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.daoBuku;
import Model.Buku;
import Model.TabelModelBuku;
import View.FormBuku;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author User
 */
public class controllerBuku {
    FormBuku frame;
    List<Buku> listBk;
    daoBuku daoBk = new daoBuku();
    Buku bk = new Buku();
    
    public controllerBuku(FormBuku frame) {
        this.frame = frame;
    }
    
    public void tampil_tabel() {
        TabelModelBuku tabelBk = new TabelModelBuku(daoBk.getData());
        frame.getTblBuku().setModel(tabelBk);
    }
    
    public void tambahData() {
        if (frame.getTxtKode().getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Kode Barang Belum Diisi");
        } else {
            bk.setKode_buku(frame.getTxtKode().getText());
            bk.setJudul(frame.getTxtJudul().getText());
            bk.setPengarang(frame.getTxtPengarang().getText());
            bk.setPenerbit(frame.getTxtPenerbit().getText());
            bk.setTahun(Integer.parseInt(frame.getTxtTahun().getText()));
            bk.setHarga_sewa(Integer.parseInt(frame.getTxtHargasewa().getText()));
            bk.setStatus(frame.getComboStatus().getSelectedItem().toString());
            daoBk.tambah(bk);
            System.out.println("Berhasil Mengirimkan Data");
            System.out.println(frame.getContentPane().getSize());
            JOptionPane.showMessageDialog(frame,"Berhasil menambahkan data");
        }
    }
    
    public void updateData() {
    if (frame.getTxtKode().getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Kode Buku Belum Diisi");
    } else {
        bk.setKode_buku(frame.getTxtKode().getText());
        bk.setJudul(frame.getTxtJudul().getText());
        bk.setPengarang(frame.getTxtPengarang().getText());
        bk.setPenerbit(frame.getTxtPenerbit().getText());
        bk.setTahun(Integer.parseInt(frame.getTxtTahun().getText()));
        bk.setHarga_sewa(Integer.parseInt(frame.getTxtHargasewa().getText()));
        bk.setStatus(frame.getComboStatus().getSelectedItem().toString());
        daoBk.ubah(bk); // Memanggil metode update pada objek daoBuku
        JOptionPane.showMessageDialog(frame, "Berhasil Memperbarui Data");
    }
}
    
    public void hapusData() {
        bk.setKode_buku(frame.getTxtKode().getText());
        System.out.println(frame.getTxtKode().getText());
        daoBk.hapus(bk);
        JOptionPane.showMessageDialog(frame, "Berhasil Menghapus data");
    }
    
    public void bersih() {
        frame.setTxtKode(null);
        frame.setTxtJudul(null);
        frame.setTxtPengarang(null);
        frame.setTxtPenerbit(null);
        frame.setTxtTahun(null);
        frame.setTxtHargasewa(null);
        frame.setComboStatus(null);
    }
    
    public void keluar() {
        frame.dispose();
    }
}
