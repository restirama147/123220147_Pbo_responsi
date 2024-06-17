/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Dosen.*;
import View.Dosen.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab Informatika
 */
public class ControllerDosen {

    ViewDosen halamanTable;
    InputDosen halamanInput;
    EditDosen halamanEdit;

    InterfaceDAODosen daoDosen;

    List<ModelDosen> daftarDosen;

    public ControllerDosen(ViewDosen halamanTable) {
        this.halamanTable = halamanTable;
        this.daoDosen = new DAODosen();
    }

    public ControllerDosen(InputDosen halamanInput) {
        this.halamanInput = halamanInput;
        this.daoDosen = new DAODosen();
    }

    public ControllerDosen(EditDosen halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoDosen = new DAODosen();
    }

    public void showAllDosen() {

        daftarDosen = daoDosen.getAll();

        ModelTabelDosen table = new ModelTabelDosen(daftarDosen);

        halamanTable.getTableDosen().setModel(table);
    }

    public void insertDosen() {
        try {
            // Membuat "dosen baru" yang isinya masih kosong
            ModelDosen dosenBaru = new ModelDosen();

            /*
              Mengambil input nama dan nidn menggunakan getter yang telah dibuat di view
              Nilai dari input kemudian disimpan ke dalam variabel "nama" dan "nidn".
             */
            String nama = halamanInput.getInputNama();
            String no_hp = halamanInput.getInputNo_hp();
            String email = halamanInput.getInputEmail();

            /*
              Mengecek apakah input dari nama atau nidn kosong/tidak.
              Jika kosong, maka buatlah sebuah exception.
             */
            if ("".equals(nama) || "".equals(no_hp)|| "".equals(email)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }

            // Mengisi nama dan nidn dari "dosen baru" yang dibuat tadi.
            dosenBaru.setNama(nama);
            dosenBaru.setNo_hp(no_hp);
            dosenBaru.setEmail(email);

            // Memasukkan "dosen baru" ke dalam database.
            daoDosen.insert(dosenBaru);

            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "Dosen baru berhasil ditambahkan.");

            // Terakhir, program akan pindah ke halaman Table Dosen
            System.out.println(dosenBaru.getNama());
            halamanInput.dispose();
            new ViewDosen();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void editDosen(int id) {
        try {
           
            ModelDosen dosenYangMauDiedit = new ModelDosen();

            
            String nama = halamanEdit.getInputNama();
            String no_hp = halamanEdit.getInputNo_hp();
            String email = halamanEdit.getInputEmail();
            
            

            if ("".equals(nama) || "".equals(no_hp) || "".equals(email)) {
                throw new Exception("Nama atau NIDN tidak boleh kosong!");
            }

            dosenYangMauDiedit.setId(id);
            dosenYangMauDiedit.setNama(nama);
            dosenYangMauDiedit.setNo_hp(no_hp);
            dosenYangMauDiedit.setEmail(email);

            daoDosen.update(dosenYangMauDiedit);

            JOptionPane.showMessageDialog(null, "Data dosen berhasil diubah.");

            // Terakhir, program akan pindah ke halaman Table Dosen
            halamanEdit.dispose();
            new ViewDosen();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteDosen(Integer baris) {
        Integer id = (int) halamanTable.getTableDosen().getValueAt(baris, 0);
        String nama = halamanTable.getTableDosen().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Dosen",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {
         
            daoDosen.delete(id);
            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllDosen();
        }
    }
}
