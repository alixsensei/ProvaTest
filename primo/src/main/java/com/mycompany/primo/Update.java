
package com.mycompany.primo;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Update {
    
     // nome del driver
     static String jdbcDriver = "com.mysql.jdbc.Driver";
     //indirizzo del mio database
     static String DB_URL = "jdbc:mysql://localhost/formazione";
     
     static String username = "admin";
     static String password = "admin";
     static Statement stm = null;
     
     // metodo che aggiunge un nuovo record nel database
     
     private static boolean aggiunge(int id, String nome, String cognome, Date data, String codfisc) {
         //Riferimento alla connessione
         Connection connection = null;
         
         
         
         try {
             connection = DriverManager.getConnection(DB_URL, username, password);
             stm = connection.createStatement();
             // set auto-commit to false
            connection.setAutoCommit(false);
             stm.executeUpdate( "INSERT INTO dipendente ( " +
                     "id, nome, cognome, data_di_nascita, codice_fiscale" +
                                " VALUES   (               " +
                     + id + ", " + nome + ", " + cognome + ", " + data + " ," + codfisc + ")"
             
             );
             // explicit commit statements to apply changes
            connection.commit();
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
            System.out.print("Inserisci il codice ID: ");
            int id = Integer.parseInt(buff.readLine());
             
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
            }
             
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
             
            // Inserimento dei dati nel buffer
            System.out.print("Nome: ");
            String nome = buff.readLine();
            System.out.print("Cognome: ");
            String cognome = buff.readLine();
            //System.out.print("Data di nascita: ");
            //String data = buff.readLine();
            System.out.print("Codice fiscale: ");
            String codfisc = buff.readLine();  
            
            aggiunge(id, nome, cognome, sqlDate, codfisc);
            
           
             
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Update.class.getName()).log(Level.SEVERE, null, ex);
         }
        
    }

  //  private static void agginuge(String nome, String cognome, String data, String codfisc) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    //}
        
}