
package com.mycompany.primo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class StatementBatch {
    
    static Statement stm = null;
    
    public static void main(String[] args) throws SQLException, IOException {
    
        Connessione conn = new Connessione();
    
        stm = conn.connection.createStatement();
        conn.connection.setAutoCommit(false);
        
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        /*
        System.out.print("Inserisci l'ID della riga che vuoi cancellare: ");
        int ID = Integer.parseInt(buffer.readLine());
        
        String sql3 = "DELETE FROM dipendente WHERE id = '" + ID + "'"; 
        stm.addBatch(sql3);
        */
        //System.out.print("Inserisci l'ID della riga che vuoi cancellare: ");
        //int ID = Integer.parseInt(buffer.readLine());
        String sql4 = "SELECT * FROM dipendente";
        ResultSet rs = stm.executeQuery(sql4);
        while(rs.next()) {
            String sql3 = "DELETE FROM dipendente WHERE data_di_nascita = 'null'"; 
            stm.addBatch(sql3);  
        }
        
        System.out.print("Inserisci l'ID del cognome che vuoi aggiornare: ");
        int ID2 = Integer.parseInt(buffer.readLine());
        System.out.print("Inserisce il nuovo cognome: ");
        String cognome = buffer.readLine();
        String sql = "UPDATE dipendente SET cognome = '" + cognome + "' WHERE id = '" + ID2 + "'";
        stm.addBatch(sql);
        
        System.out.print("Inserisci l'ID del nome che vuoi modificare: ");
        int ID3 = Integer.parseInt(buffer.readLine());
        System.out.print("Inserisce il nuovo nome: ");
        String nome = buffer.readLine();
        String sql2 = "UPDATE dipendente SET nome = '" + nome + "' WHERE id = '" + ID3 + "'";
        stm.addBatch(sql2);
        
        
        int[] count = stm.executeBatch();
        
        conn.connection.commit();
        
        conn.connection.close();
        
       stm.close();
        
    }
}
