/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MainProgram.DBconnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import View.StatusPengirimView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author rafli
 */
public class StatusPengirimanController {

    StatusPengirimView statusV;
    Connection conn = DBconnection.getConnection();
    Statement stmn = DBconnection.getStatement();
    ResultSet result;
    String sql;

    public StatusPengirimanController(StatusPengirimView view) {
        statusV = view;
        statusV.btnCek(new btnGetidBarang());
    }

    class btnGetidBarang implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String idBarang = statusV.getIdBarang();
            try {
                sql = "select * from paket where idBarang = '" + idBarang + "'";
                result = stmn.executeQuery(sql);
                if (result.next()) {
                    if (result.getBoolean("status")==true) {
                        statusV.setStatusPaket("Paket Sudah Diterima oleh penerima");
                    } else {
                        statusV.setStatusPaket("Paket sedang diantar oleh kurir");
                    }
                } else {
                    statusV.setStatusPaket("Pastikan Anda Memasukan ID Barang yang benar");
                }
            } catch (Exception error) {
                String msg = "Error";
                JOptionPane.showMessageDialog(null, msg);
            }
        }

    }

}
