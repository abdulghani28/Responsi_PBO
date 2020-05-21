package kereta;

import javax.swing.table.*;
import javax.swing.*;
import java.awt.*;
import java.util.Objects;

public class KeretaView extends JFrame{
    JFrame currentFrame;
    Dimension dimensiMain;
    DefaultTableModel tableModel;
    JScrollPane scrollPane;
    JPanel panel1 = new JPanel();
    JButton btnKembali = new JButton("Kembali");
    JLabel titleLabel = new JLabel("TiketKereta.com");
    JButton btnDaftarKereta = new JButton("Daftar Kereta");
    JButton btnDaftarTiket = new JButton("Daftar Tiket");
    
    public KeretaView() {
        dimensiMain = new Dimension(850,650);
        tableModel = new DefaultTableModel(kolomKereta,0);
        tabelKereta = new JTable(tableModel);
        tableModel = new DefaultTableModel(kolomTiket,0);
        tabelTiket = new JTable(tableModel);
        mainView();
    }
    
    public void mainView(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(panel1);
        panel1.setSize(dimensiMain);
        panel1.setLayout(null);
        panel1.setBorder(BorderFactory.createLineBorder(Color.green));
        panel1.add(titleLabel); titleLabel.setBounds(350,30,300,300); titleLabel.setFont(new Font("Times New Roman",Font.BOLD,30));
        panel1.add(btnDaftarKereta); btnDaftarKereta.setBounds(350,300,200,50);
        panel1.add(btnDaftarTiket); btnDaftarTiket.setBounds(350,400,200,50);
    }

//      Daftar Tiket
    JPanel panelTiket = new JPanel();
    JLabel labelNama = new JLabel("Nama : ");
    JLabel labelJK = new JLabel("Jenis Kelamin : ");
    JLabel labelStasiun = new JLabel("Stasiun Tujuan : ");
    JLabel labelKereta = new JLabel("Kereta : ");
    JTextField textNama = new JTextField();
    String[] kelamin = {"Laki-laki","Perempuan"};
    JComboBox<String> jenisKelamin = new JComboBox<>(kelamin);
    String[] tujuan = {"Tugu Jogja","Lempuyungan","Maguwo"};
    JComboBox<String> tujuanStasiun = new JComboBox<>(tujuan);
    String[] namaKereta;
    JComboBox<String> listKereta;
    JButton btnTambahTiket = new JButton("Tambah");
    JButton btnBatalTiket = new JButton("Batal");

    
    public JFrame daftarTiket(){
        listKereta = new JComboBox<>(namaKereta);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(panelTiket);
        panelTiket.setLayout(null);
        panelTiket.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelTiket.setSize(dimensiMain);
        panelTiket.add(btnKembali); btnKembali.setBounds(10,10,100,20);
        panelTiket.add(labelNama); labelNama.setBounds(60,50,50,20);
        panelTiket.add(labelJK);labelJK.setBounds(60,70,120,20);
        panelTiket.add(labelStasiun);labelStasiun.setBounds(60,90,120,20);
        panelTiket.add(labelKereta);labelKereta.setBounds(60,110,120,20);
        panelTiket.add(textNama); textNama.setBounds(180,50,140,20);
        panelTiket.add(jenisKelamin); jenisKelamin.setBounds(180,70,140,20);
        panelTiket.add(tujuanStasiun); tujuanStasiun.setBounds(180,90,140,20);
        panelTiket.add(listKereta); listKereta.setBounds(180,110,140,20);
        panelTiket.add(btnTambahTiket);btnTambahTiket.setBounds(350,50,100,20);
        panelTiket.add(btnBatalTiket);btnBatalTiket.setBounds(350,70,100,20);
        scrollPane = new JScrollPane(tabelTiket);
        panelTiket.add(scrollPane);
        scrollPane.setBounds(40,200,400,400);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        return currentFrame;
    }
//      Daftar Kereta
    JPanel panelKereta = new JPanel();
    String[] kolomTiket = {"Nama","Jenis Kelamin","Stasiun","Kereta"};
    JTable tabelTiket;
    JLabel labelIdKereta = new JLabel("ID Kereta : ");
    JLabel labelNamaKereta = new JLabel("Nama Kereta : ");
    JLabel labelKelasKereta = new JLabel("Kelas : ");
    JTextField textIdKereta = new JTextField();
    JTextField textNamaKereta = new JTextField();
    JTextField textKelasKereta = new JTextField();
    JButton btnTambahKereta = new JButton("Tambah");
    JButton btnEditKereta = new JButton("Edit");
    JButton btnHapusKereta = new JButton("Hapus");
    JButton btnBatalKereta = new JButton("Batal");
    int baris=-1;
    
    String[] kolomKereta = {"ID Kereta","Nama Kereta","Kelas"};
    JTable tabelKereta;
    
    public JFrame daftarKereta(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setLayout(null);
        setLocationRelativeTo(null);
        
        add(panelKereta);
        panelKereta.setLayout(null);
        panelKereta.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        panelKereta.setSize(dimensiMain);
        panelKereta.add(btnKembali); btnKembali.setBounds(10,10,100,20);
        panelKereta.add(btnKembali); btnKembali.setBounds(10,10,100,20);
        panelKereta.add(labelIdKereta); labelIdKereta.setBounds(60,50,100,20);
        panelKereta.add(labelNamaKereta);labelNamaKereta.setBounds(60,70,120,20);
        panelKereta.add(labelKelasKereta);labelKelasKereta.setBounds(60,90,120,20);
        panelKereta.add(textIdKereta); textIdKereta.setBounds(180,50,140,20);
        panelKereta.add(textNamaKereta); textNamaKereta.setBounds(180,70,140,20);
        panelKereta.add(textKelasKereta); textKelasKereta.setBounds(180,90,140,20);
        panelKereta.add(btnTambahKereta);btnTambahKereta.setBounds(350,50,100,20);
        panelKereta.add(btnEditKereta);btnEditKereta.setBounds(350,70,100,20);
        panelKereta.add(btnHapusKereta);btnHapusKereta.setBounds(350,90,100,20);
        panelKereta.add(btnBatalKereta);btnBatalKereta.setBounds(350,110,100,20);
        scrollPane = new JScrollPane(tabelKereta);
        panelKereta.add(scrollPane);
        scrollPane.setBounds(40,200,400,400);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        return currentFrame;
    }
    
    public void refresh(){
        dispose();
    }
    
    public int getBaris(){
        return baris;
    }
    
    public String getNama(){
        return textNama.getText();
    }
    
    public String getKelamin(){
        return Objects.requireNonNull(jenisKelamin.getSelectedItem()).toString();
    }
    
    public String getStasiun(){
        return Objects.requireNonNull(tujuanStasiun.getSelectedItem()).toString();
    }
    
    public String getKereta(){
        return Objects.requireNonNull(listKereta.getSelectedItem()).toString();
    }
    
    public String getIdKereta(){
        return textIdKereta.getText();
    }
    
    public String getNamaKereta(){
        return textNamaKereta.getText();
    }
    
    public String getKelasKereta(){
        return textKelasKereta.getText();
    }
    
}
