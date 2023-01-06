/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MainProgram.DBconnection;
import View.HomePengirimView;
import View.InputBarangView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import model.Barang;
import model.Paket;
import model.Pengirim;

/**
 *
 * @author rafli
 */
public class InputBarangController {

    InputBarangView inputBarangV;
    Connection conn = DBconnection.getConnection();
    Statement stmn = DBconnection.getStatement();
    ResultSet result;
    String sql;

    public InputBarangController(InputBarangView view) {
        inputBarangV = view;
        inputBarangV.btnKirimDataBarang(new btnSubmit());
        inputBarangV.btnKalkukasiData(new btnKalkulasi());
    }

    class btnSubmit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String namaPenerima = inputBarangV.getPenerima();
            String namaBarang = inputBarangV.getBarang();
            double beratBarang = inputBarangV.getBerat();
            int jumlah = inputBarangV.getJumlah();
            double totalBerat = inputBarangV.getTotalBerat();
            String alamatPenerima = inputBarangV.getAlamat();
            String jenisPengiriman = inputBarangV.getJenisPengiriman();
            String jenisPaket = inputBarangV.getJenisPaket();
            int harga = inputBarangV.getHarga();
            String pembayaran = inputBarangV.getPembayaran();
            if (namaPenerima.equals("")
                    || namaBarang.equals("")
                    || jumlah == 0
                    || beratBarang == 0
                    || totalBerat == 0
                    || alamatPenerima.equals("")
                    || jenisPengiriman.equals("")
                    || jenisPaket.equals("")
                    || harga == 0) {
                JOptionPane.showMessageDialog(null, "Silakan lengkapi data terlebih dahulu");
            } else {
                Barang barangTambah = new Barang(namaPenerima, namaBarang, beratBarang, jumlah, totalBerat, alamatPenerima, jenisPengiriman, jenisPaket, harga, pembayaran);
                Pengirim pengirim = new Pengirim();
                pengirim.inputBarang(barangTambah);
                HomePengirimView home = new HomePengirimView();
                home.show();
                inputBarangV.setVisible(false);
            }
        }

    }

    class btnKalkulasi implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Barang brg = new Barang();
            double beratBarang = inputBarangV.getBerat();
            int jumlah = inputBarangV.getJumlah();
            double jumlahBeratBarang = brg.jumlahBeratBarang(jumlah, beratBarang);
            String jenisPengiriman = inputBarangV.getJenisPengiriman();
            String jenisPaket = inputBarangV.getJenisPaket();
            int hargaJenisPaket = 0;
            if (jenisPaket.equals("Normal")) {
                hargaJenisPaket = 5000;
            } else if (jenisPaket.equals("Tumbuhan/Hewan")) {
                hargaJenisPaket = 15000;
            } else if (jenisPaket.equals("Dokumen")) {
                hargaJenisPaket = 10000;
            } else if (jenisPaket.equals("Pecah Belah")) {
                hargaJenisPaket = 80000;
            }
            int hargaJenisPengiriman = 0;
            if (jenisPengiriman.equals("Normal")) {
                hargaJenisPengiriman = 5000;
            } else if (jenisPengiriman.equals("Fast")) {
                hargaJenisPengiriman = 10000;
            } else if (jenisPengiriman.equals("Express")) {
                hargaJenisPengiriman = 15000;
            }
            Paket pkt = new Paket();
            int TotalHarga = pkt.Totalharga(hargaJenisPengiriman, hargaJenisPaket);
            inputBarangV.setTotalHarga(TotalHarga);
            inputBarangV.setJumlahBerat(jumlahBeratBarang);
        }

    }
}
