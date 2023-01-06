/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import MainProgram.DBconnection;
import View.HomeAdminView;
import View.HomeKurirView;
import View.HomePengirimView;
import View.LoginView;
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
public class LoginController {
    LoginView loginV;
    Connection conn = DBconnection.getConnection();
    Statement stmn = DBconnection.getStatement();
    ResultSet result;
    String sql;
    public LoginController(LoginView login) {
        loginV = login;
        loginV.btnLogin(new loginbtn());
    }
    class loginbtn implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = loginV.getUsername();
            String password = loginV.getPassword();
            try {
                sql = "select * from akun where username = '"+username+"' AND password = '"+password+"'";
                result = stmn.executeQuery(sql);
                if(result.next()){
                    if(result.getString("role").equals("admin")){
                        HomeAdminView home = new HomeAdminView();
                        home.setVisible(true);
                        loginV.dispose();
                    }else if(result.getString("role").equals("pengirim")){
                        HomePengirimView home = new HomePengirimView();
                        home.setVisible(true);
                        loginV.dispose();
                    }else if(result.getString("role").equals("kurir")){
                        HomeKurirView home = new HomeKurirView();
                        home.setVisible(true);
                        loginV.dispose();
                    }
                }
            } catch(Exception error){
                String msg = "username atau password salah";
                JOptionPane.showMessageDialog(null,msg);
            }
            
        }
        
    }
}
