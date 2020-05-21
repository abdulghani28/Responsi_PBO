package kereta;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KeretaController {
    KeretaModel keretaModel;
    KeretaView keretaView;

    public KeretaController(KeretaModel keretaModel, KeretaView keretaView) {
        this.keretaModel = keretaModel;
        this.keretaView = keretaView;
        readDataKereta();
        readTiketKereta();
        
        keretaView.namaKereta = keretaModel.readKeretaBox();
        keretaView.btnKembali.addActionListener(ae -> {
            keretaView.getContentPane().removeAll();
            keretaView.refresh();
            new MVC();
        });
        
        keretaView.btnDaftarKereta.addActionListener(ae -> {
            keretaView.getContentPane().removeAll();
            keretaView.refresh();
            showRequest(keretaView.daftarKereta());
        });
        keretaView.btnDaftarTiket.addActionListener(ae -> {
            keretaView.namaKereta = keretaModel.readKeretaBox();
            keretaView.getContentPane().removeAll();
            keretaView.refresh();
            showRequest(keretaView.daftarTiket());
        });
        
//        Kereta

        keretaView.tabelKereta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                String[][] data = keretaModel.readKereta();
                int row = keretaView.tabelKereta.getSelectedRow();
                keretaView.textIdKereta.setEditable(false);
                keretaView.baris = row;
                keretaView.textIdKereta.setText(data[row][0]);
                keretaView.textNamaKereta.setText(data[row][1]);
                keretaView.textKelasKereta.setText(data[row][2]);
            }
        });

        keretaView.btnTambahKereta.addActionListener(ae -> {
            String idKereta = keretaView.getIdKereta();
            String namaKereta = keretaView.getNamaKereta();
            String kelasKereta = keretaView.getKelasKereta();
            keretaModel.insertKereta(idKereta,namaKereta,kelasKereta);
            readDataKereta();
        });
        
        keretaView.btnEditKereta.addActionListener(ae -> {
            System.out.println("Baris = "+ keretaView.getBaris());
            if(keretaView.getBaris()<0){
                JOptionPane.showMessageDialog(null, "Pilih Data yang Ingin Diedit!");
            }
            else{
                String idKereta = keretaView.getIdKereta();
                String namaKereta = keretaView.getNamaKereta();
                String kelasKereta = keretaView.getKelasKereta();
                keretaModel.editKereta(idKereta,namaKereta,kelasKereta);
                readDataKereta();
            }
        });
        
        keretaView.btnHapusKereta.addActionListener(ae -> {
            System.out.println("Baris = "+ keretaView.getBaris());
            if(keretaView.getBaris()<0){
                JOptionPane.showMessageDialog(null, "Pilih Data yang Akan Dihapus!");
            }
            else{
                String data = keretaView.getIdKereta();
                keretaModel.deleteKereta(data);
                readDataKereta();
            }
        });
        
        keretaView.btnBatalKereta.addActionListener(ae -> clearTextFieldKereta());
        
//        Tiket

        keretaView.btnTambahTiket.addActionListener(ae -> {
            String nama = keretaView.getNama();
            String jenisKelamin = keretaView.getKelamin();
            String stasiunTujuan = keretaView.getStasiun();
            String namaKereta = keretaView.getKereta();
            keretaModel.insertTiket(nama, jenisKelamin, stasiunTujuan, namaKereta);
            readTiketKereta();
        });

        keretaView.btnBatalTiket.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                clearTextFieldTiket();
            }
        });
    }

//      Kereta
    
    public void readDataKereta(){
        try {
            String[][] data = new String[keretaModel.getBanyakDataKereta()][3];
            data = keretaModel.readKereta();
            keretaView.tabelKereta.setModel((new JTable(data, keretaView.kolomKereta)).getModel());
        } catch (IllegalArgumentException i) {
            System.err.println(i); 
        }
    }

//      Tiket
    
    public void readTiketKereta(){
        try {
            String[][] data = new String[keretaModel.getBanyakDataTiket()][4];
            data = keretaModel.readTiket();
            keretaView.tabelTiket.setModel((new JTable(data, keretaView.kolomTiket)).getModel());
        } catch (IllegalArgumentException i) {
            System.err.println(i); 
        }
    }
    
    public void showRequest (JFrame frame) {
        frame.setVisible(true);
    }
    
    public void clearTextFieldTiket(){
        keretaView.textNama.setText("");
    }
    
    public void clearTextFieldKereta(){
        keretaView.baris = -1;
        keretaView.textIdKereta.setEditable(true);
        keretaView.textIdKereta.setText("");
        keretaView.textNamaKereta.setText("");
        keretaView.textKelasKereta.setText("");
    }
}
