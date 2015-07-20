/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import javax.xml.crypto.Data;


public class Update {
    
     // nome del driver
     static String jdbcDriver = "com.mysql.jdbc.Driver";
     //indirizzo del mio database
     static String DB_URL = "jdbc:mysql://localhost/formazione";
     
     static String username = "admin";
     static String password = "admin";
     static Statement stm = null;
     
     // metodo che aggiunge un nuovo record nel database
     
     private static boolean agginuge(String nome, String cognome, Date data, String codfisc) {
         //Riferimento alla connessione
         Connection connection = null;
         
         try {
             connection = DriverManager.getConnection(DB_URL, username, password);
             stm = connection.createStatement();
             stm.executeUpdate( "INSERT INTO dipendente ( " +
                     "nome, cognome, data_di_nascita, Codice fiscale " +
                     ") VALUES   (               " +
                     "' " + nome + ", " + cognome + ", " + data + " ," + codfisc + ")"
             
             );
             return true;
             
         } catch (SQLException ex) {
             return false;
             //Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally {
             if(connection != null) {
                 try {
                     connection.close();
                 } catch (SQLException ex) {
                     Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
                 }
                
             } 
         }
     }
     

    public static void main(String[] args) throws IOException {
        
         try {
             // carico il driver
             Class.forName("com.mysql.jdbc.Driver");
             
             // Interagisco con l'utente
             BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
             
            // Inserimento dei dati nel buffer
            System.out.print("Nome: ");
            String nome = buff.readLine();
            System.out.print("Cognome: ");
            String cognome = buff.readLine();
            System.out.print("Data di nascita: ");
            String data = buff.readLine();
            System.out.print("Codice fiscale: ");
            String codfisc = buff.readLine();  
            
            agginuge(nome, cognome, data, codfisc);
            
           
             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

    private static void agginuge(String nome, String cognome, String data, String codfisc) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
}