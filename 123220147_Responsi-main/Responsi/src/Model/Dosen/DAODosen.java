/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Dosen;

import Model.Connector;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public class DAODosen implements InterfaceDAODosen {

    @Override
    public void insert(ModelDosen dosen) {
        try {
            String query = "INSERT INTO dosen (nama, no_hp, email) VALUES (?, ?);";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNo_hp());
            statement.setString(2, dosen.getEmail());

            statement.executeUpdate();

            statement.close();
        } catch (SQLException e) {
            System.out.println("Input Gagal: " + e.getLocalizedMessage());
        }
    }

    @Override
    public void update(ModelDosen dosen) {
        try {

            String query = "UPDATE dosen SET nama=?, no_hp=?, email=? WHERE id=?;";

            PreparedStatement statement;
            statement = Connector.Connect().prepareStatement(query);
            statement.setString(1, dosen.getNama());
            statement.setString(2, dosen.getNo_hp());
            statement.setString(3, dosen.getEmail());
            statement.setInt(4, dosen.getId());

            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Update Gagal! (" + e.getLocalizedMessage() + ")");
        }
    }

    @Override
    public void delete(int id) {
        try {

            String query = "DELETE FROM dosen WHERE id=?;";

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
    public List<ModelDosen> getAll() {
        List<ModelDosen> listDosen = null;

        try {
            listDosen = new ArrayList<>();

            Statement statement = Connector.Connect().createStatement();

            String query = "SELECT * FROM dosen;";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {

                ModelDosen dosen = new ModelDosen();

                dosen.setId(resultSet.getInt("id"));
                dosen.setNama(resultSet.getString("nama"));
                dosen.setNo_hp(resultSet.getString("no_hp"));
                dosen.setEmail(resultSet.getString("email"));

                listDosen.add(dosen);
                
            }
            System.out.println(listDosen);
            // Menutup koneksi untuk menghemat penggunaan memory.
            statement.close();
        } catch (SQLException e) {
            // Menampilkan pesan error ketika gagal mengambil data.
            System.out.println("Error: " + e.getLocalizedMessage());
        }
        return listDosen;
    }
}


