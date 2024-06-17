/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Mahasiswa;

import java.util.List;

/**
 *
 * @author Lab Informatika
 */
public interface InterfaceDAOMahasiswa {
    public void insert(ModelMahasiswa mahasiswa);
    
    public void update(ModelMahasiswa mahasiswa);
    
    public void delete(int id);
    
    public List<ModelMahasiswa> getAll();
}
