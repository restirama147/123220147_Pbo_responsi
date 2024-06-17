/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Mahasiswa;

import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Lab Informatika
 */
public class ModelTabelMahasiswa extends AbstractTableModel {

    List<ModelMahasiswa> daftarMahasiswa;

    String kolom[] = {"ID", "Nama", "NIM"};

    public ModelTabelMahasiswa(List<ModelMahasiswa> daftarMahasiswa) {
        this.daftarMahasiswa = daftarMahasiswa;
    }

    @Override
    public int getRowCount() {
        return daftarMahasiswa.size();
    }

    @Override
    public int getColumnCount() {
        return kolom.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return daftarMahasiswa.get(rowIndex).getId();
            case 1:
                return daftarMahasiswa.get(rowIndex).getNama();
            case 2:
                return daftarMahasiswa.get(rowIndex).getNim();
            case 3:
                return daftarMahasiswa.get(rowIndex).getAngkatan();
            default:
                return null;
        }
    }

    @Override
    public String getColumnName(int columnIndex) {
        return kolom[columnIndex];
    }
}
