package com.mycompany.primo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Prova2 {

    public static void main(String[] args) throws SQLException, ParseException, IOException {

        PreparedStatement stm = null;
        
        Connessione conn = new Connessione();
        
        Connection tmp = conn.connection;
                  
               
        String sql2 = "INSERT INTO dipendente (nome, cognome, data_di_nascita, codice_fiscale)" +
                    "VALUES ( ?, ?, ?, ?)";
        stm = tmp.prepareStatement(sql2);

           
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
        } catch (ParseException e) {
            System.out.println(e.toString());
        }
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
         
        System.out.print("Nome: ");
        String nome = buff.readLine();
        System.out.print("Cognome: ");
        String cognome = buff.readLine();
        System.out.print("Codice Fiscale: ");
        String codfisc = buff.readLine();  
            
        stm.setString(1,nome);
        stm.setString(2,cognome);
        stm.setDate(3, sqlDate);
        stm.setString(4,codfisc);
             
        stm.executeUpdate();
            
       tmp.close();
        stm.close();
        
    }
    
}
