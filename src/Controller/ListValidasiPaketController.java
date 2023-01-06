/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MainProgram.DBconnection;
import View.HomeAdminView;
import View.ListValidasiPaketView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author rafli
 */
public class ListValidasiPaketController {
    
    ListValidasiPaketView listValidasiPaketV;
    Connection conn = DBconnection.getConnection();
    Statement stmn = DBconnection.getStatement();
    ResultSet result;
    String sql;
    
    public ListValidasiPaketController(ListValidasiPaketView view) {
        listValidasiPaketV = view;
        listValidasiPaketV.btnPelunasanPembayaran(new btnPelunasan());
        getData();
    }
    
    public void getData() {
        try {
            String status;
            sql = "select * from paket";
            result = stmn.executeQuery(sql);
            DefaultTableModel tabel = listValidasiPaketV.getTablePaket();
            while (result.next()) {
                if (result.getString("pembayaran").equals("Transfer")) {
                    status = "Lunas";
                } else {
                    status = "Belum Bayar";
                }
                Object o[] = {result.getInt("idBarang"), result.getString("penerima"), result.getString("alamat"),
                    result.getString("jenis_pengiriman"), result.getString("jenis_paket"), result.getInt("harga_paket"), status};
                tabel.addRow(o);
            }
            listValidasiPaketV.setTablePaket(tabel);
        } catch (Exception error) {
            System.out.println(error.getMessage());
            
        }
    }
    
    class btnPelunasan implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                int idBarang = listValidasiPaketV.getIDBarang();
                String sql = "UPDATE paket SET pembayaran = 'Transfer' where idBarang = "+idBarang+"";
                stmn.executeUpdate(sql);
                JOptionPane.showMessageDialog(null,"Paket Telah Lunas");
                HomeAdminView home = new HomeAdminView();
                home.show();
                listValidasiPaketV.setVisible(false);
            } catch (Exception error) {
                
            }
        }    
    }
}
