package com.mycompany.primo;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;


public class Prova2 {

    public static void main(String[] args) throws SQLException, ParseException {
        Connection dbconn = null;
        PreparedStatement stm = null;
        
        String username = "admin";
        String password = "admin";
        try {           
               Class.forName("com.mysql.jdbc.Driver");
            // apertura della connessione
            // prova di git
            
            String jdbcDriver = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost/formazione";
             dbconn = DriverManager.getConnection(DB_URL, username, password);
             System.out.println("Connected!!!");
             String sql2 = "INSERT INTO dipendente ( " +
                     " Nome, Cognome, codfisc " +
                     ") VALUES ( " +
                     " ?, ?, ?"+
                    ")";
             stm = dbconn.prepareStatement(sql2);
             DataFormat dt = new SimpleDataFormat("yyyy-MM-dd");
             Date data = dt.valueOf("2001-02-17");  
             
             // imposto i parametri
             stm.setString(1,"alix");
             stm.setString(2,"ndembi");
             stm.setDate(3, data);
             stm.setString(4,"FHFGHTGRF");
             
             /*
             stm.setString(6, "robert");
             stm.setString(7, "Pires");
             stm.setString(8, "2013-10-11");
             stm.setString(9, "FHFRDVRF");
             */
             
            stm.executeUpdate();
                    
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(prova.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(prova.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (dbconn != null) {
                dbconn.close();
            }
        }
        
       
        if(dbconn == null) {
           System.out.println("error");
        }
        
    }
    
}
