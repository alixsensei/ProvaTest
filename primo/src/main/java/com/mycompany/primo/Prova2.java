package com.mycompany.primo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Date;

public class Prova2 {

    public static void main(String[] args) throws SQLException, ParseException, IOException {
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
            String sql2 = "INSERT INTO dipendente VALUES ( " +
                   " ?, ?, ?, ?, ?)";
             
             
            stm = dbconn.prepareStatement(sql2);
             
             //
             
               
             // Interagisco con l'utente
            BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
             // Inserimento dei dati nel buffer
            
             System.out.print("Inserisci il giorno di nascita: ");
            int day = Integer.parseInt(buff.readLine());
            System.out.print("Inserisci il mese di nascita: ");
            int month = Integer.parseInt(buff.readLine());
            System.out.print("Inserisci l'anno di nascita: ");
            int year = Integer.parseInt(buff.readLine());

            String date = year + "-" + month + "-" + day;
            java.util.Date utilDate = null;

            try {
              SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
              utilDate = formatter.parse(date);
              System.out.println("utilDate:" + utilDate);
            } catch (ParseException e) {
              System.out.println(e.toString());
              e.printStackTrace();
            }
             
              java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
  
            
            // Inserimento dei dati nel buffer
            
            System.out.print("codice ID: ");
            int id = Integer.parseInt(buff.readLine());
            System.out.print("Nome: ");
            String nome = buff.readLine();
            System.out.print("Cognome: ");
            String cognome = buff.readLine();
            System.out.print("Codice Fiscale: ");
            String codfisc = buff.readLine();  
             
             stm.setInt(1,id);
             stm.setString(2,nome);
             stm.setString(3,cognome);
             stm.setDate(4, sqlDate);
             stm.setString(5,codfisc);
             
          /*   String query =  "UPDATE dipendente " +
                   "SET data_di_nascita = 1980-12-23 WHERE id = 1";
             stm = dbconn.prepareStatement(query); */
         //   stm.setDate(1, sqlDate);
              stm.executeUpdate();
                    
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
