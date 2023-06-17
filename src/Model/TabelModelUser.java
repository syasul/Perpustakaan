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
public class TabelModelUser extends AbstractTableModel {
    List<User> ListUs;
    
    public TabelModelUser(List<User> ListUs) {
        this.ListUs = ListUs;
    }
    
    @Override
    public int getRowCount() {
        return ListUs.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public Object getValueAt(int row, int column) {
        return switch(column) {
            case 0 -> ListUs.get(row).getNik();
            case 1 -> ListUs.get(row).getNama();
            case 2 -> ListUs.get(row).getJkel();
            case 3 -> ListUs.get(row).getTelepon();
            case 4 -> ListUs.get(row).getAlamat();
            case 5 -> ListUs.get(row).getUsername();
            case 6 -> ListUs.get(row).getPassword();                
            default -> null;
        };
    }
      
    @Override
    public String getColumnName(int column) {
        return switch(column) {
            case 0 -> "NIK";
            case 1 -> "Nama";
            case 2 -> "jenis kelamin";
            case 3 -> "Telepon";
            case 4 -> "Alamat";
            case 5 -> "Username";              
            case 6 -> "Password";                
            default -> null;
        };
    }
}
