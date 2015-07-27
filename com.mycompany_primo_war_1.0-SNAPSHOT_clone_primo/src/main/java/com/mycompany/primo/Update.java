
package com.mycompany.primo;
import java.sql.*;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Update {

    static Statement stm = null;
    
    public static void main(String[] args) throws IOException, SQLException {
        
        Connessione conn = new Connessione();
        
        stm = conn.connection.createStatement();
        
        
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));
        
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
        
        System.out.print("Nome: ");
        String nome = buff.readLine();
        System.out.print("Cognome: ");
        String cognome = buff.readLine();
        System.out.print("Codice fiscale: ");
        String codfisc = buff.readLine();
        
        conn.connection.setAutoCommit(false);
        
        String sql = "INSERT INTO dipendente (nome, cognome, data_di_nascita, codice_fiscale)" +
                " VALUES ('" + nome + "','" + cognome + "','" + sqlDate + "','" + codfisc + "')";
        stm.executeUpdate(sql);
        System.out.println("Il dato è stato aggiundo nel record!!");
        
        conn.connection.commit();
        conn.connection.close();
        stm.close();
        
    }
    

}