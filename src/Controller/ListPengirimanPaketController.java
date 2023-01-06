/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MainProgram.DBconnection;
import View.HomeKurirView;
import View.ListPengirimanPaketView;
import View.WalletView;
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
public class ListPengirimanPaketController {
    
    ListPengirimanPaketView listPengirimPaketV;
    Connection conn = DBconnection.getConnection();
    Statement stmn = DBconnection.getStatement();
    ResultSet result;
    String sql;
    public ListPengirimanPaketController(ListPengirimanPaketView view) {
        listPengirimPaketV = view;
        listPengirimPaketV.btnKirim(new btnTerkirim());
        getData();
    }
    
    public void getData(){
        try {
            sql = "select * from paket WHERE status=false and pembayaran='Transfer'";
            result = stmn.executeQuery(sql);
            DefaultTableModel tabel = listPengirimPaketV.getTablePaket();
            while(result.next()){
                Object o[] = {result.getInt("idBarang"), result.getString("penerima"), result.getString("alamat"), result.getInt("harga_paket")};
                tabel.addRow(o);
            }
            listPengirimPaketV.setTablePaket(tabel);
        } catch (Exception error) {
        }
    }
    
    class btnTerkirim implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            int idBarang = listPengirimPaketV.getIDBarang();
            try {
                String sql1 = "select * from paket where idBarang = "+idBarang+"";
                result = stmn.executeQuery(sql1);
                int harga = 0;
                if(result.next()){
                    harga = result.getInt("harga_paket");
                }
                String sql2 = "UPDATE paket SET status = true where idBarang = "+idBarang+"";
                stmn.executeUpdate(sql2);
                String sql4 = "select wallet from akun where role='kurir'";
                result = stmn.executeQuery(sql4);
                int walletUpdate = 0;
                if(result.next()){
                    walletUpdate = result.getInt("wallet") + harga;
                }
                String sql3 = "UPDATE akun SET wallet ="+walletUpdate+" where role='kurir'";
                stmn.executeUpdate(sql3);
                JOptionPane.showMessageDialog(null,"Paket Telah Diterima");
                HomeKurirView home = new HomeKurirView();
                home.show();
                listPengirimPaketV.setVisible(false);
            } catch (Exception error) {
                System.out.println(error.getMessage());
            }
        }    
    }
    
}
