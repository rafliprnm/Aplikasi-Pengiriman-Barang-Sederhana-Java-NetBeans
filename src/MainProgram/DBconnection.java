package MainProgram;

import java.sql.*;

public class DBconnection{
    static Connection con;
    static Statement stt;
    public static Connection getConnection(){
        if(con == null){
            try{
                con = DriverManager.getConnection("jdbc:mysql://localhost/pbokel4", "root", "");
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return con;
    }
    public static Statement getStatement(){
        if(stt == null){
            try{
                stt = con.createStatement();
            }
            catch(Exception e){
                System.out.println(e.getMessage());
            }
        }
        return stt;
    }
}
