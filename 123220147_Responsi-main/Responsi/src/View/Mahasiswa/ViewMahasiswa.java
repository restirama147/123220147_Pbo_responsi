/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Mahasiswa;

import Controller.ControllerMahasiswa;
import Model.Mahasiswa.ModelMahasiswa;
import View.Home;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Lab Informatika
 */
public class ViewMahasiswa extends JFrame{
     Integer baris;

    // Membuat sebuah instance bernama controller dari class "ControllerMahasiswa".
    ControllerMahasiswa controller;

    // Menginisiasi komponen
    JLabel header = new JLabel("Data Mahasiswa");
    JButton tombolTambah = new JButton("Tambah Mahasiswa");
    JButton tombolEdit = new JButton("Edit Mahasiswa");
    JButton tombolHapus = new JButton("Hapus Mahasiswa");
    JButton tombolKembali = new JButton("Kembali ke menu utama");

    /*
      Untuk membuat Tabel, kita memerlukan 3 komponen, yaitu:
      1. JTable sebagai komponen tabelnya
      2. DefaultTableModel untuk model atau isinya
      3. JScrollPane supaya tabel dapat di-scroll saat datanya melebihi ukuran layar.
     */
    JTable table;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;

    /*
      Nama kolom tabelnya disimpan ke dalam variabel "namaKolom" yang memiliki 
      tipe data Array String.
     */
    String namaKolom[] = {"ID", "Nama", "NIM", "Angkatan"};

    public ViewMahasiswa() {
        tableModel = new DefaultTableModel(namaKolom, 0);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);

        setTitle("Daftar Mahasiswa");
        setVisible(true);
        setSize(552, 580);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(header);
        add(scrollPane);
        add(tombolTambah);
        add(tombolEdit);
        add(tombolHapus);
        add(tombolKembali);

        header.setBounds(20, 8, 440, 24);
        scrollPane.setBounds(20, 36, 512, 320);
        tombolTambah.setBounds(20, 370, 512, 40);
        tombolEdit.setBounds(20, 414, 512, 40);
        tombolHapus.setBounds(20, 458, 512, 40);
        tombolKembali.setBounds(20, 502, 512, 40);

      
        controller = new ControllerMahasiswa(this);
        controller.showAllMahasiswa();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                baris = table.getSelectedRow();
            }
        });

        // Memberikan event handling ketika tombol "Tambah Mahasiswa" diklik
        tombolTambah.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ketika tombol tambah diklik, maka program akan berpindah ke halaman InputData()
                dispose();
                new InputMahasiswa();
            }
        });

        tombolEdit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                 
                    ModelMahasiswa mahasiswaTerpilih = new ModelMahasiswa();
                    
                    Integer id = (int) table.getValueAt(baris, 0);
                    String nama = table.getValueAt(baris, 1).toString();
                    String nim = table.getValueAt(baris, 2).toString();
                    
                    mahasiswaTerpilih.setId(id);
                    mahasiswaTerpilih.setNama(nama);
                    mahasiswaTerpilih.setNim(nim);

                    
                    dispose();
                    new EditMahasiswa(mahasiswaTerpilih);
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });

        tombolHapus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (baris != null) {
                    controller.deleteMahasiswa(baris);
                 
                    baris = null;
                } else {
                    JOptionPane.showMessageDialog(null, "Data belum dipilih.");
                }
            }
        });
        
        tombolKembali.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Home();
            }
        });
    }

    public JTable getTableMahasiswa() {
        return table;
    }
    
}
