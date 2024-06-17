/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.*;

/**
 *
 * @author Lab Informatika
 */
public class Connector {

    private static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    private static String nama_db = "university";
    private static String url_db = "jdbc:mysql://localhost:3306/" + nama_db + "?useLegacyDatetimeCode=false&amp;serverTimezone=Europe/Amsterdam&amp;useSSL=false";
    private static String username_db = "root";
    private static String password_db = "";

    static Connection conn;

    public static Connection Connect() {
        try {
            Class.forName(jdbc_driver);

            conn = DriverManager.getConnection(url_db, username_db, password_db);

            System.out.println("MySQL Connected");
        } catch (ClassNotFoundException | SQLException exception) {
            System.out.println("Koneksi Gaga;: " + exception.getLocalizedMessage());
        }
        return conn;
    }

}
