
package com.mycompany.primo;

import static com.mycompany.primo.ProvaStudente.stm;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class PreparedStatementBatch {
    
    public static void main(String[] args) throws SQLException, IOException {
        
        Connessione conn = new Connessione();
        PreparedStatement stm;
        Connection tmp = conn.connection;
                
        BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
        conn.connection.setAutoCommit(false);
        String scelta, sql;
        
        do {
            System.out.print("Seleziona l'operazione da eseguire [1=Update/2=Insert/3=Delete]");
            int op = Integer.parseInt(buffer.readLine());
            
            System.out.print("Seleziona la tabella [1=studente/2=dipendente]");
            int tb = Integer.parseInt(buffer.readLine());
            
            tmp.setAutoCommit(false);
            
            // Aggiornamento
            switch(op) {
                case 1:
                do {
                    System.out.print("Cosa vuoi modificare? [1=nome; 2=cognome;3=data di nascita;4=codice fiscal]: ");
                    int ris = Integer.parseInt(buffer.readLine());

                    System.out.print("Inserisci l'ID della persona che si vuole aggiornare: ");
                    int id = Integer.parseInt(buffer.readLine());
                    switch(ris){
                        case 1:
                            if ( tb == 1) {
                                System.out.print("Inserisci il nuovo Nome: ");
                                String nome = buffer.readLine();
                                sql = "UPDATE studente SET nome = ? where matricola = ?";
                                stm = tmp.prepareStatement(sql);
                                stm.setInt(1, id);
                                stm.setString(2, nome);
                                stm.addBatch();
                            }
                            else if (tb == 2) {
                                System.out.print("Inserisci il nuovo Nome: ");
                                String nome = buffer.readLine();
                                sql = "UPDATE dipendente SET nome = ? where id = ?";
                                stm = tmp.prepareStatement(sql);
                                stm.setInt(1, id);
                                stm.setString(2, nome);
                                stm.addBatch();
                            }
                            break;

                        case 2:
                            if ( tb == 1) {
                                System.out.print("Inserisci il nuovo Nome: ");
                                String cognome = buffer.readLine();
                                sql = "UPDATE studente SET cognome = ? where matricola = ?";
                                stm = tmp.prepareStatement(sql);
                                stm.setInt(1, id);
                                stm.setString(2, cognome);
                                stm.addBatch();
                            }
                            else if (tb == 2) {
                                System.out.print("Inserisci il nuovo Nome: ");
                                String nome = buffer.readLine();
                                sql = "UPDATE studente SET nome = ? where matricola = ?";
                                stm = tmp.prepareStatement(sql);
                                stm.setInt(1, id);
                                stm.setString(2, nome);
                                stm.addBatch();
                            }
                            break;

                        case 3:
                            System.out.print("Inserisci il giorno di nascita[1-31]: ");
                            int day = Integer.parseInt(buffer.readLine());
                            System.out.print("Inserisci il mese di nascita[1-12]: ");
                            int month = Integer.parseInt(buffer.readLine());
                            System.out.print("Inserisci l'anno di nascita: ");
                            int year = Integer.parseInt(buffer.readLine());

                            String date = year + "-" + month + "-" + day;
                            java.util.Date utilDate = null;
                            try {
                                SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
                                utilDate = formatter.parse(date);
                            } catch (ParseException e) {
                                System.out.println(e.toString());
                            }
                            java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());


                            if ( tb == 1) {
                                sql = "UPDATE studente SET data_di_nascita = ? where matricola = ?";
                                stm = tmp.prepareStatement(sql);
                                stm.setInt(1, id);
                                stm.setDate(2, sqlDate);
                            }
                            else if(tb == 2) {
                                sql = "UPDATE dipendente SET data_di_nascita = ? where id = ?";
                                stm = tmp.prepareStatement(sql);
                                stm.setInt(1, id);
                                stm.setDate(2, sqlDate);
                            }
                            stm.addBatch();
                            break;

                        default:
                            System.out.println("Scelta non valida");

                    }
                    System.out.println("Dato pronto nell'aggiornamento....");
                    System.out.print("Vuoi aggiornare un altro dato?: ");
                    scelta = buffer.readLine();
                } while ("si".equals(scelta));
                
                
                case 2:
                    do {
                        System.out.print("Nome: ");
                        String nome = buffer.readLine();
                        System.out.print("Cognome: ");
                        String cognome = buffer.readLine();
                        
                        if (tb == 1) {
                            sql = "INSERT INTO studente (nome, cognome, data_di_nascita)" +
                                   " VALUE (?,?,?)";
                            stm = tmp.prepareStatement(sql);
                            stm.setString(1, nome);
                            stm.setString(2, cognome);
                            stm.setDate(3, sqlDate);
                        }
                        else if (tb == 2) {
                            System.out.print("Inserisci il Codice Fiscale: ");
                            String codice_fiscale = buffer.readLine();
                            sql = "INSERT INTO dipendente(nome, cognome, data_di_nascita, codice_fiscale)"
                                + "VALUES (?,?,?,?)";
                            stm = tmp.prepareStatement(sql);
                            stm.setString(1, nome);
                            stm.setString(2, cognome);
                            stm.setDate(3, sqlDate);
                            stm.setString(4, codice_fiscale);
                        }
                        stm.addBatch();
                        break;
                        System.out.println("Dato pronto all'inserimento....");
                        System.out.print("Vuoi inserire un altro dato? [si/no]");
                        scelta = buffer.readLine();
                    } while("si".equals(scelta));
            
                case 3:
                    do {
                        if (tb == 1){
                            sql = "DELETE"
                            
                        }
                    stm.executeUpdate(sql);
                    System.out.println("Il dato è stato aggiornato nella tabella!!");
                    System.out.print("Vuoi aggiornare un altro dato?: ");
                    scelta = buffer.readLine();
                }   while ("si".equals(scelta));
            }
            
            
            System.out.print("Inserisci l'ID della riga che vuoi modificare: ");
            int ID = Integer.parseInt(buffer.readLine());
            
            System.out.print("Cosa vuoi modificare? [1=nome; 2=cognome;3=data di nascita;4=codice fiscal]: ");
            int ris = Integer.parseInt(buffer.readLine());
            
            switch(ris){
                case 1:
                    String sql1 = "UPDATE dipendente SET nome = ? where id = ?";
                    stm = tmp.prepareStatement(sql1);
                    System.out.print("Nuovo Nome: ");
                    String nome = buffer.readLine();
                    stm.setInt(1, ID);
                    stm.setString(2, nome);
                    stm.addBatch();
                    break;
                    
                case 2:
                    String sql2 = "UPDATE dipendente SET cognome = ? where id = ?";
                    stm = tmp.prepareStatement(sql2);
                    System.out.print("Nuovo Cognome: ");
                    String cognome = buffer.readLine();
                    stm.setInt(1, ID);
                    stm.setString(2, cognome);
                    stm.addBatch();
                    break;
                    
                case 3:
                    String sql3 = "UPDATE dipendente SET data_di_nascita = ? where id = ?";
                    stm = tmp.prepareStatement(sql3);
                    System.out.print("Inserisci il nuovo giorno di nascita: ");
                    int day = Integer.parseInt(buffer.readLine());
                    System.out.print("Inserisci il nuovo mese di nascita: ");
                    int month = Integer.parseInt(buffer.readLine());
                    System.out.print("Inserisci il nuovo anno di nascita: ");
                    int year = Integer.parseInt(buffer.readLine());
                    
                    String date = year + "-" + month + "-" + day;
                    java.util.Date utilDate = null;
                    try {
                        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                        utilDate = formatter.parse(date);
                        //System.out.println("utilDate:" + utilDate);
                    } catch (ParseException e) {
                        System.out.println(e.toString());
                    }
                    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                    stm.setInt(1, ID);
                    stm.setDate(2, sqlDate);
                    stm.addBatch();
                    break;
                    
                case 4:
                    String sql4 = "UPDATE dipendente SET codfisc = ? where id = ?";
                    stm = tmp.prepareStatement(sql4);
                    System.out.print("Nuovo Codice fiscale: ");
                    String codfisc = buffer.readLine();
                    stm.setInt(1, ID);
                    stm.setString(2, codfisc);
                    stm.addBatch();
                    break;
                    
                default:
                    System.out.println("Si è scelto di aggiornare nulla");
                    
            }
            //stm.addBatch();
            
            String sql = "INSERT INTO dipendente (nome, cognome, data_di_nascita, codice_fiscale)" +
            " VALUE (?,?,?,?)";
            stm = conn.connection.prepareStatement(sql);
            
            //stm.setInt(1, 12);
            stm.setString(1, "Albertini");
            stm.setString(2, "Zamboni");
            stm.setString(3, "1976-03-29");
            stm.setString(4, "F398HJTY");
            stm.addBatch();
            
            //stm.setInt(1, 13);
            stm.setString(1, "Raul");
            stm.setString(3, "Ganziami");
            stm.setString(3, "1987-03-29");
            stm.setString(4, "FGGBWQTY");
            stm.addBatch();
            
            //stm.setInt(1, 14);
            stm.setString(1, "Merylande");
            stm.setString(2, "Cortesè");
            stm.setString(3, "1983-05-29");
            stm.setString(4, "GHJTG78787b");
            stm.addBatch();
            
            //   String sql = "INSERT INTO dipendente (nome, cognome, data_di_nascita, codice_fiscale)" +
            //       " VALUE (?,?,?,?)";
            //stm.setString(1, "1945-03-22");
        //stm.setInt(1, 12);
        /*
        stm.setString(1, "Pablo");
        stm.setString(2, "Rossi");
        stm.setString(3, "1977-03-29");
        stm.setString(4, "FGDCFHJTY");
        //stm.addBatch(); */
        
        //stm.executeBatch();
        tmp.setAutoCommit(false);
        stm.executeUpdate();
        tmp.commit();
        }
        stm.close();
    }
    
}
