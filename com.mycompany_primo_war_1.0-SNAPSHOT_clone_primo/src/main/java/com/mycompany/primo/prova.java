/*
 * Visualizza il contenuto del mio Data Base.
 */
package com.mycompany.primo;
import java.sql.*;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class prova {

    public static void main(String[] args) throws SQLException, ParseException {
        
        // creo la connessione
        Connessione conn = new Connessione();
        Connection tmp = conn.connection;
        //Connection dbconn = null;
        Statement stm = null;
       
        
        try {   
           
            stm = tmp.createStatement();
            
            ResultSet rs;
             
       
            String sql2 = "SELECT * FROM dipendente";
            rs = stm.executeQuery(sql2);

            System.out.println("Ecco il contenuto della notra Database:");
            System.out.println("=======================================");
            while(rs.next()){
                
                
               //Retrieve by column name
               //int id  = rs.getInt("id");
               //String nome = rs.getString("nome");
               //String cognome = rs.getString("cognome");
               String data = rs.getString("data_di_nascita");
               //String codefisc = rs.getString("codice_fiscale");
               
               //int id = rs.getInt("id");
               //System.out.println(data);
               stm = tmp.createStatement();
               String sql = "SELECT DATE_FORMAT('" + data + "', GET_FORMAT(DATE,'EUR')) FROM dipendente";
               ResultSet rs_date_conv = stm.executeQuery(sql);
               if (rs_date_conv.next()) {
                    String date_conv = rs_date_conv.getString(1);
            
                    //Display values
                    System.out.print("ID: " + rs.getInt("id"));
                    System.out.print(", Nome: " + rs.getString("nome"));
                    System.out.print(", Cognome: " + rs.getString("cognome"));
                    System.out.print(", Data di nascita: " + date_conv);
                    System.out.println(", Codice fiscale: " + rs.getString("codice_fiscale"));
                    System.out.println();
                }
            
        }
        tmp.close();
             
        } catch (SQLException ex) {
            Logger.getLogger(prova.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
}
