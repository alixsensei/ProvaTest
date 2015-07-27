/*
 *Aggiornamento database
 */
package com.mycompany.primo;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.*;


public class Conversione {
 
    static PreparedStatement stm2 = null;
    static Statement statement2 = null;
    
    public static void main(String[] args) throws SQLException, ParseException, IOException {
        
        // creo la connessione
        Connessione conn = new Connessione();
        Connection tmp = conn.connection;
        ResultSet rs, rs2;
        int count = 0;
    
            
            String sql = "INSERT INTO dipendente (nome, cognome, data_di_nascita, codice_fiscale)" +
            " VALUE (?,?,?,?)";
            
            String sql2 = "SELECT * FROM dipendente";
      
            String query = "select * from dipendente where id = 1";
            statement2 = tmp.createStatement();
       
            stm2 = tmp.prepareStatement(sql);
          
            String date = "1988-09-05";
            java.util.Date utilDate = null;
            try {
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                utilDate = formatter.parse(date);
            } catch (ParseException e) {
                System.out.println(e.toString());
            }
            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
            
            tmp.setAutoCommit(false);
            //stm.setInt(1, 12);
            stm2.setString(1, "Giovinco");
            stm2.setString(2, "Paolo");
            stm2.setDate(3, sqlDate);
            stm2.setString(4, "F398HJTY");
            stm2.executeUpdate();
            
            rs2 = statement2.executeQuery(query);
            rs2.next();
            rs = stm2.executeQuery(sql2);
            
            System.out.println("Ciao, mi chiamo " + rs2.getString("nome") + " " + rs2.getString("cognome") + ", " +
               "sono nato il " + rs2.getString("data_di_nascita")
                    + "e il mio codice fiscale e' " + 
                    ""+ rs2.getString("codice_fiscale"));
            
            
   
            System.out.println("Ecco il contenuto della tabella");
            
            while (rs.next()) {
                count++;
                System.out.print("id" + rs.getInt("id"));
                System.out.print(", Nome: " +rs.getString("nome"));
                System.out.print(", Cognome: " + rs.getString("cognome"));
                System.out.print(", Data di nascita: " + rs.getString("data_di_nascita"));
                System.out.println(", Codice fiscale: " + rs.getString("codice_fiscale"));
                System.out.println();
            }
            
            System.out.println("Il numero di righe nella tabella è: " + count);
            
            tmp.commit();
            tmp.rollback();
            tmp.close();
           
        
        }
}
 
       
