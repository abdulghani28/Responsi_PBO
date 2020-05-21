package kereta;

import java.sql.*;
import javax.swing.*;

public class KeretaModel {
    static final String jdbcDriver = "com.mysql.jdbc.Driver";
    static final String DBurl = "jdbc:mysql://localhost/responsi_pbo";
    static final String DBusername = "root";
    static final String DBpassword = "";
    Connection koneksi;
    Statement statement;
    ResultSet resultSet;
    
    public KeretaModel() {
        try {
            Class.forName(jdbcDriver);
            koneksi = DriverManager.getConnection(DBurl, DBusername, DBpassword);
            System.out.println("Koneksi Berhasil");
        } catch(Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            System.out.println("Koneksi Gagal");
        }
    }
    
    public String getIDKeretaFromNama(String nama){
        String data = null;
        try {
            String query = "SELECT * FROM kereta where namaKereta = '"+nama+"'";
            resultSet = statement.executeQuery(query);
            if(resultSet.next()){
                data = resultSet.getString("idKereta");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return data;
    }
    
    public int getBanyakDataKereta(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM kereta";
            ResultSet setResult = statement.executeQuery(query);
            while(setResult.next()){
                jmlData++;
            }
            return jmlData;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }
    
//      Kereta
    public String[][] readKereta(){
        String[][] data = new String[getBanyakDataKereta()][3];
        try {
            String query = "SELECT * FROM kereta";
            resultSet = statement.executeQuery(query);
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("idKereta");
                data[p][1] = resultSet.getString("namaKereta");
                data[p][2] = resultSet.getString("kelasKereta");
                p++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!");
        }
        return data;
    }
    
    public void insertKereta(String idKereta, String namaKereta, String kelasKereta){
        try {
            System.out.println(idKereta+namaKereta+kelasKereta);
            String query = "INSERT INTO kereta VALUES ('"+idKereta+"','"+namaKereta+"','"+kelasKereta+"')";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan!");
        }
    }

    
    public String[] readKeretaBox(){
        String[] data = new String[getBanyakDataKereta()];
        int i=0;
        try{
            String query = "SELECT namaKereta FROM kereta";
            ResultSet setResult = statement.executeQuery(query);
            while(setResult.next()){
                data[i] = setResult.getString("namaKereta");
                i++;
            }
            
        } catch(SQLException e){
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!");
        }
        return data;
    }
    
    public void editKereta(String idKereta, String namaKereta, String kelasKereta){
        try {
            String query = "UPDATE kereta SET namaKereta ='"+namaKereta+"', kelasKereta = '"+kelasKereta+"' where idKereta = '"+idKereta+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dirubah");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Diedit!");
        }
    }
    
    public void deleteKereta(String idKereta){
        try {
            String query = "DELETE FROM kereta where idKereta = '"+idKereta+"'";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Dihapus");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Dihapus!");
        }
    }
    
//      Tiket

    public int getBanyakDataTiket(){
        int jmlData = 0;
        try{
            statement = koneksi.createStatement();
            String query = "SELECT * FROM tiket";
            ResultSet setResult = statement.executeQuery(query);
            while(setResult.next()){
                jmlData++;
            }
            return jmlData;
        } catch(SQLException e){
            System.out.println(e.getMessage());
            System.out.println("SQL Error");
            return 0;
        }
    }

    public String[][] readTiket(){
        String[][] data = new String[getBanyakDataTiket()][4];
        try {
            String query = "SELECT * FROM tiket JOIN kereta ON tiket.idKereta = kereta.idKereta";
            resultSet = statement.executeQuery(query);
            int p=0;
            while(resultSet.next()){
                data[p][0] = resultSet.getString("tiket.nama");
                data[p][1] = resultSet.getString("tiket.jenisKelamin");
                data[p][2] = resultSet.getString("tiket.stasiunTujuan");
                data[p][3] = resultSet.getString("kereta.namaKereta");
                p++;
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Data Gagal Ditampilkan!");
        }
        return data;
    }
    
    public void insertTiket(String nama, String jenisKelamin, String stasiunTujuan, String namaKereta){
        try {
            System.out.println(nama+jenisKelamin+stasiunTujuan+namaKereta);
            String idKereta = getIDKeretaFromNama(namaKereta);
            System.out.println(idKereta);
            String query = "INSERT INTO tiket VALUES ('"+nama+"','"+jenisKelamin+"','"+stasiunTujuan+"','"+idKereta+"')";
            statement.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Berhasil Ditambahkan");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            JOptionPane.showMessageDialog(null, "Data Gagal Ditambahkan!");
        }
    }
}
