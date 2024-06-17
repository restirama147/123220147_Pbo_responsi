/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Mahasiswa;

import Model.Connector;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public class DAOMahasiswa implements InterfaceDAOMahasiswa {

    @Override
    public void insert(ModelMahasiswa mahasiswa) {
        try {
            String query = "INSERT INTO mahasiswa (nama, nim, angkatan) VALUES (?, ?);";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getNim());
            statement.setString(2, mahasiswa.getAngkatan());

            // Menjalankan query untuk memasukkan data mahasiswa baru
            statement.executeUpdate();

            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal input data.
            System.out.println("Input gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelMahasiswa mahasiswa) {
        try {
            // Perintah query disimpan ke dalam variabel "query"
            String query = "UPDATE mahasiswa SET nama=?, nim=?, angkatan=? WHERE id=?;";

            /* 
              Memasukkan nama dan nim dari input user 
              beserta id yang didapat dari data yang mau diubah ke dalam query 
              untuk mengisi bagian "?".
             */
            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, mahasiswa.getNama());
            statement.setString(2, mahasiswa.getNim());
            statement.setString(3, mahasiswa.getAngkatan());
            statement.setInt(4, mahasiswa.getId());

            // Menjalankan query untuk mengubah data mahasiswa yang dipilih
            statement.executeUpdate();

            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal edit data.
            System.out.println("update Gagal! (" + e.getMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {
            String query = "DELETE FROM mahasiswa WHERE id=?;";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setInt(1, id);

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Delete Failed: " + e.getLocalizedMessage());
        }
    }

    @Override
    public List<ModelMahasiswa> getAll() {
        List<ModelMahasiswa> listMahasiswa = null;

        try {
       
            listMahasiswa = new ArrayList<>();

            Statement statement = Connector.Connect().createStatement();

           
            String query = "SELECT * FROM mahasiswa;";
            ResultSet resultSet = statement.executeQuery(query);

           
            while (resultSet.next()) {
                ModelMahasiswa mhs = new ModelMahasiswa();

                mhs.setId(resultSet.getInt("id"));
                mhs.setNama(resultSet.getString("nama"));
                mhs.setNim(resultSet.getString("nim"));
                mhs.setAngkatan(resultSet.getString("angkatan"));

                listMahasiswa.add(mhs);
            }

            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listMahasiswa;
    }
}
