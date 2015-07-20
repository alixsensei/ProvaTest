/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primo;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;


public class prova {

    public static void main(String[] args) throws SQLException, ParseException {
        Connection dbconn = null;
        Statement stm = null;
       
        String username = "admin";
        String password = "admin";
        try {           
               Class.forName("com.mysql.jdbc.Driver");
            // apertura della connessione
            
            String jdbcDriver = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost/formazione";
             dbconn = DriverManager.getConnection(DB_URL, username, password);
             System.out.println("Connected!!!");
             stm = dbconn.createStatement();
             String sql;
             //sql = "select * from dipendente";
             //ResultSet rs = stm.executeQuery(sql);
             //rs.last();
             //System.out.println("Numero delle righe: " + rs.getRow());
             sql = "select nome from dipendente where cognome = ndembi";
             ResultSet rs;
             int indice;
             Date data;
            rs = stm.executeQuery(sql);
      
       while(rs.next()){
         
         //indice = rs.getInt("id");
         String nome = rs.getString("nome");
         //String cognome  = rs.getString("cognome");
        // data  = rs.getDate("data_di_nascita");
         //String codfisc = rs.getString("codice_fiscale");
         //Display values
         //System.out.println("Il codice id è: "+ indice);
         System.out.println("Il nome è "+ nome);
         //System.out.println("Il cognome è "+ cognome);
         //System.out.println("Il codice fiscale è "+ codfisc);
        // System.out.println("la sua data di nascita è: " + data);
        }
       
       // proviamo a popolare il nostro db
        if (stm != null) {
                stm.close();
        }
        if (rs != null) {
                rs.close();
        }
                    
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
