
package com.mycompany.primo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PreparedStatementBatch {
    
     public static void main(String[] args) throws SQLException {
    // nome del driver
    String jdbcDriver = "com.mysql.jdbc.Driver";
     //indirizzo del mio database
    String DB_URL = "jdbc:mysql://localhost/formazione";
     
    String username = "admin";
    String password = "admin";
    PreparedStatement stm = null;
    Connection dbconn = null;
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            dbconn = DriverManager.getConnection(DB_URL, username, password);
            System.out.println("Connected!!!");
            
            //create SQL statement
            String sql = "INSERT INTO dipendente (id, nome, cognome, data_di_nascita, codice_fiscale)" +
                    " VALUE (?,?,?,?,?)";
            
            // add statement sql in the batch
            stm = dbconn.prepareStatement(sql);
              
            // set auto-commit to false
            dbconn.setAutoCommit(false);
            
            stm.setInt(1, 12);
            stm.setString(2, "Pablo");
            stm.setString(3, "Renato");
            stm.setString(4, "1983-03-29");
            stm.setString(5, "FGFGFHJTY");
            stm.addBatch();
            
            stm.setInt(1, 13);
            stm.setString(2, "Raul");
            stm.setString(3, "Gonzalez");
            stm.setString(4, "1987-03-29");
            stm.setString(5, "FGFGBWQTY");
            stm.addBatch();
            
            stm.setInt(1, 14);
            stm.setString(2, "Meryland");
            stm.setString(3, "Assoni");
            stm.setString(4, "1983-05-29");
            stm.setString(5, "GHJTG78787b");
            stm.addBatch();
            
            //create SQL statement
            //String sql1 = "update into dipendente set cognome = 'Ndembi' where id = 3";
            // add statement sql in the batch
            //stm.addBatch(sql1);
         
            //create an int[] to hold returned values
            stm.executeBatch();
            
            // explicit commit statements to apply changes
            dbconn.commit();
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(StatementBatch.class.getName()).log(Level.SEVERE, null, ex);
        }
     
    
         
         
     
    }
    
}
