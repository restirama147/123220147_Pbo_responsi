/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dosen;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class ModelTabelDosen extends AbstractTableModel {

    List<ModelDosen> daftarDosen;

    String kolom[] = {"ID", "Nama", "No Hp", "Email"};

    public ModelTabelDosen(List<ModelDosen> daftarDosen) {
        this.daftarDosen = daftarDosen;
    }

    @Override
    public int getRowCount() {
        return daftarDosen.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarDosen.get(rowIndex).getId();
            case 1:
                return daftarDosen.get(rowIndex).getNama();
            case 2:
                return daftarDosen.get(rowIndex).getNo_hp();
            case 3:
                return daftarDosen.get(rowIndex).getEmail();
            default:
                return null;
        }
    }
    
    @Override
      public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }

}
