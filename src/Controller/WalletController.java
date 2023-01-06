/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MainProgram.DBconnection;
import View.WalletView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author rafli
 */
public class WalletController {
    WalletView walletV;
    Connection conn = DBconnection.getConnection();
    Statement stmn = DBconnection.getStatement();
    ResultSet result;
    String sql;

    public WalletController(WalletView wallet) {
        walletV = wallet;
        walletV.btnWallet(new walletbtn());
    }
    class walletbtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String sql = "select wallet from akun where role='kurir'";
                result = stmn.executeQuery(sql);
                int wallet = 0;
                if(result.next()){
                    wallet = result.getInt("wallet");
                }
                walletV.setSaldo(wallet);
            } catch(Exception error){
                
            }
            
        }
        
    }
}
