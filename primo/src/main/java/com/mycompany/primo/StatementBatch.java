
package com.mycompany.primo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class StatementBatch {
    
    
    public static void main(String[] args) throws SQLException {
    // nome del driver
    String jdbcDriver = "com.mysql.jdbc.Driver";
     //indirizzo del mio database
    String DB_URL = "jdbc:mysql://localhost/formazione";
     
    String username = "admin";
    String password = "admin";
    Statement stm = null;
    Connection dbconn = null;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            dbconn = DriverManager.getConnection(DB_URL, username, password);
            System.out.println("Connected!!!");
            stm = dbconn.createStatement();
            
            // set auto-commit to false
            dbconn.setAutoCommit(false);
            
            //create SQL statement
            String sql = "INSERT INTO dipendente (id, nome, cognome, data_di_nascita, codice_fiscale)" +
                    " VALUE (7,'Mario','Giordano','2001-02-14', 'FRTRHGFTYGF'"
                    + ")";
            // add statement sql in the batch
            stm.addBatch(sql);
            
            //create SQL statement
            String sql1 = "INSERT INTO dipendente (id, nome, cognome, data_di_nascita, codice_fiscale)" +
                    " VALUE (8,'Mauro','Rocco','1931-02-14', 'FXXHGFTYGF'"
                    + ")";
            // add statement sql in the batch
            stm.addBatch(sql1);
             
            String sql2 = "UPDATE dipendente SET cognome = 'Cortesi' WHERE id = 3";
            // add statement sql2 sulla batch
            stm.addBatch(sql2);
            
            //create an int[] to hold returned values
            int[] count = stm.executeBatch();
            
            // explicit commit statements to apply changes
            dbconn.commit();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StatementBatch.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
         
         
     
    }
}
