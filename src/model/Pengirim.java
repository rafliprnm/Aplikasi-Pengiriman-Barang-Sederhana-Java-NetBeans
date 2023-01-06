/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import MainProgram.DBconnection;
import java.sql.Connection;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rafli
 */
public class Pengirim extends User implements Payable {

    Connection con = DBconnection.getConnection();
    Statement stt = DBconnection.getStatement();
    String sql;
    private String name;
    private String phoneNumber;
    private String category;
    protected String senderAddress;
    private boolean statusDelivery;

    public Pengirim(String name, String phoneNumber, String category, String senderAddress, boolean statusDelivery) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.category = category;
        this.senderAddress = senderAddress;
        this.statusDelivery = statusDelivery;
    }

    public Pengirim() {
    }
    

    @Override
    public void login() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void methodPay() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void inputBarang(Barang b) {
        if (b.getPenerima().equals("")
                || b.getName().equals("")
                || b.getSumItem() == 0
                || b.getWeight() == 0
                || b.getTotalWeightItem() == 0
                || b.getDestinationAddress().equals("")
                || b.getJenisPengiriman().equals("")
                || b.getJenisPaket().equals("")
                || b.getPembayaran().equals("")) {
            JOptionPane.showMessageDialog(null, "Silakan lengkapi data terlebih dahulu");
        } else {
            sql = "insert into paket (penerima, namaBarang, beratBarang, jumlahBarang, totalBerat, alamat, jenis_pengiriman, jenis_paket,harga_paket,pembayaran) values "
                    + "('" + b.getPenerima() + "', '" + b.getName() + "',"
                    + "'" + b.getWeight() + "', '" + b.getSumItem() + "'"
                    + ",'" + b.getTotalWeightItem() + "', '" + b.getDestinationAddress() + "'"
                    + ",'" + b.getJenisPengiriman()+ "', '" + b.getJenisPaket()+ "'"
                    + ",'" + b.getHarga()+ "', '" + b.getPembayaran()+ "')";
            try {
                stt.execute(sql);
                JOptionPane.showMessageDialog(null, "Paket berhasil ditambahkan");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Silakan lengkapi data terlebih dahulu");
            }
        }

    }

    public void getBarang(Barang b) {

    }

    public void setDeliveryProgress(boolean s, String namaKurir, String nomorKurir) {
        statusDelivery = s;
        if (statusDelivery == true) {
            System.out.print("Paket Anda Telah Sampai Tujuan");
        } else {
            System.out.println("Paket Anda Sedang Diantar Oleh" + namaKurir + "Hubungi Kurir" + nomorKurir);
        }
    }

    public void historyDelivery() {

    }

    public void ratingKurir() {

    }
}
