/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Mahasiswa.*;
import View.Mahasiswa.*;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Lab Informatika
 */
public class ControllerMahasiswa {

    ViewMahasiswa halamanTable;
    InputMahasiswa halamanInput;
    EditMahasiswa halamanEdit;

    InterfaceDAOMahasiswa daoMahasiswa;

    List<ModelMahasiswa> daftarMahasiswa;

    public ControllerMahasiswa(ViewMahasiswa halamanTable) {
        this.halamanTable = halamanTable;
        this.daoMahasiswa = new DAOMahasiswa();
    }

    public ControllerMahasiswa(InputMahasiswa halamanInput) {
        this.halamanInput = halamanInput;
        this.daoMahasiswa = new DAOMahasiswa();
    }

    public ControllerMahasiswa(EditMahasiswa halamanEdit) {
        this.halamanEdit = halamanEdit;
        this.daoMahasiswa = new DAOMahasiswa();
    }

    public void showAllMahasiswa() {

        daftarMahasiswa = daoMahasiswa.getAll();

        ModelTabelMahasiswa table = new ModelTabelMahasiswa(daftarMahasiswa);

        halamanTable.getTableMahasiswa().setModel(table);
    }

    public void insertMahasiswa() {
        try {
            ModelMahasiswa mahasiswaBaru = new ModelMahasiswa();

            String nama = halamanInput.getInputNama();
            String nim = halamanInput.getInputNIM();
            String angkatan = halamanInput.getInputAngkatan();

            if ("".equals(nama) || "".equals(nim) || "".equals(angkatan)) {
                throw new Exception("Nama atau NIM atau Angkatan tidak boleh kosong!");
            }

            mahasiswaBaru.setNama(nama);
            mahasiswaBaru.setNim(nim);
            mahasiswaBaru.setAngkatan(angkatan);

            // Memasukkan "mahasiswa baru" ke dalam database.
            daoMahasiswa.insert(mahasiswaBaru);

            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "Mahasiswa baru berhasil ditambahkan.");

            // Terakhir, program akan pindah ke halaman Table Mahasiswa()
            halamanInput.dispose();
            new ViewMahasiswa();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void editMahasiswa(int id) {
        try {
            /*
              Membuat instance "mahasiswa yang mau diedit" buat 
              menyimpan informasi mahasiswa yang mau diedit.
             */
            ModelMahasiswa mahasiswaYangMauDiedit = new ModelMahasiswa();

            /*
              Mengambil input nama dan nim menggunakan getter yang telah dibuat di view
              Nilai dari input kemudian disimpan ke dalam variabel "nama" dan "nim".
             */
            String nama = halamanEdit.getInputNama();
            String nim = halamanEdit.getInputNIM();
            String angkatan = halamanEdit.getInputAngkatan();


            /*
              Mengecek apakah input dari nama atau nim kosong/tidak.
              Jika kosong, maka buatlah sebuah exception.
             */
            if ("".equals(nama) || "".equals(nim) || "".equals(angkatan)) {
                throw new Exception("Nama atau NIM atau Angkatantidak boleh kosong!");
            }

            // Mengisi id, nama dan nim dari "mahasiswa baru" yang dibuat tadi.
            mahasiswaYangMauDiedit.setId(id);
            mahasiswaYangMauDiedit.setNama(nama);
            mahasiswaYangMauDiedit.setNim(nim);
            mahasiswaYangMauDiedit.setAngkatan(angkatan);

            // Memasukkan "mahasiswa baru" ke dalam database.
            daoMahasiswa.update(mahasiswaYangMauDiedit);

            // Menampilkan pop-up ketika berhasil mengedit data
            JOptionPane.showMessageDialog(null, "Data mahasiswa berhasil diubah.");

            // Terakhir, program akan pindah ke halaman Table Mahasiswa()
            halamanEdit.dispose();
            new ViewMahasiswa();
        } catch (Exception e) {
            // Menampilkan pop-up ketika terjadi error
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }

    public void deleteMahasiswa(Integer baris) {
        // Mengambil id dan nama berdasarkan baris yang dipilih
        Integer id = (int) halamanTable.getTableMahasiswa().getValueAt(baris, 0);
        String nama = halamanTable.getTableMahasiswa().getValueAt(baris, 1).toString();

        // Membuat Pop-Up untuk mengonfirmasi apakah ingin menghapus data
        int input = JOptionPane.showConfirmDialog(
                null,
                "Hapus " + nama + "?",
                "Hapus Mahasiswa",
                JOptionPane.YES_NO_OPTION
        );

        if (input == 0) {

            daoMahasiswa.delete(id);

            JOptionPane.showMessageDialog(null, "Berhasil menghapus data.");

            showAllMahasiswa();
        }
    }
}
