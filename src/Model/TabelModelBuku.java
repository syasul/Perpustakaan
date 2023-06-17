/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author User
 */
public class TabelModelBuku extends AbstractTableModel {
    List<Buku> ListBk;
    
    public TabelModelBuku(List<Buku> ListBk) {
        this.ListBk = ListBk;
    }
    
    @Override
    public int getRowCount() {
        return ListBk.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return switch(column) {
            case 0 -> ListBk.get(row).getKode_buku();
            case 1 -> ListBk.get(row).getJudul();
            case 2 -> ListBk.get(row).getPengarang();
            case 3 -> ListBk.get(row).getPenerbit();
            case 4 -> ListBk.get(row).getTahun();
            case 5 -> ListBk.get(row).getHarga_sewa();
            case 6 -> ListBk.get(row).getStatus();                
            default -> null;
        };
    }
      
    @Override
    public String getColumnName(int column) {
        return switch(column) {
            case 0 -> "Kode";
            case 1 -> "Judul";
            case 2 -> "Pengarang";
            case 3 -> "Penerbit";
            case 4 -> "Tahun";
            case 5 -> "Harga Sewa";              
            case 6 -> "Status";                
            default -> null;
        };
    }
    
    
}
