/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primo;
import java.sql.*;
import java.text.ParseException;
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
            String DB_URL = "jdbc:mysql://localhost/formazione?zeroDateTimeBehavior=convertToNull&autoReconnect=true&characterEncoding=UTF-8&characterSetResults=UTF-8";
             dbconn = DriverManager.getConnection(DB_URL, username, password);
             System.out.println("Connected!!!");
             stm = dbconn.createStatement();
            
            ResultSet rs;
             
       
            String sql2 = "SELECT * FROM dipendente";
            rs = stm.executeQuery(sql2);

            System.out.println("Ecco il contenuto della notra Database:");
            System.out.println("=======================================");
            while(rs.next()){
               //Retrieve by column name
               int id  = rs.getInt("id");
               String nome = rs.getString("nome");
               String cognome = rs.getString("cognome");
               String data = rs.getString("data_di_nascita");
               String codefisc = rs.getString("codice_fiscale");

               //Display values
               System.out.print("ID: " + id);
               System.out.print(", Nome: " + nome);
               System.out.print(", Cognome: " + cognome);
               System.out.print(", Data di nascita: " + data);
               System.out.println(", Codice fiscale: " + codefisc);
               System.out.println();
            }

        if (stm != null) {
                stm.close();
        }
        if (rs != null) {
                rs.close();
        }
                    
        } catch (ClassNotFoundException | SQLException ex) {
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
