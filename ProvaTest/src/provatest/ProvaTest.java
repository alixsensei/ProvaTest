package provatest;

import it.risorsa.senseisrl.Library2SessionBeanRemote;
import it.risorsa.senseisrl.LibrarySessionBeanRemote;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class ProvaTest {
    
    static BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    
    static LibrarySessionBeanRemote libraryBean = null;
    static Library2SessionBeanRemote libraryBean2 = null;

    public static void main(String[] args) throws NamingException, IOException {

        Context context = null;

        
        try {
            Properties prop = new Properties();
            prop.put(Context.INITIAL_CONTEXT_FACTORY, "org.jboss.naming.remote.client.InitialContextFactory");
            prop.put(Context.PROVIDER_URL, "http-remoting://127.0.0.1:8080");
            prop.put(Context.SECURITY_PRINCIPAL, "alix");
            prop.put(Context.SECURITY_CREDENTIALS, "admin");
            prop.put("jboss.naming.client.ejb.context", true);
            context = new InitialContext(prop);
            libraryBean
                    = (LibrarySessionBeanRemote) context.lookup("ejbRemota/LibrarySessionBean!it.risorsa.senseisrl.LibrarySessionBeanRemote");
            libraryBean2
                    = (Library2SessionBeanRemote) context.lookup("ejbRemota/LibrarySessionBean!it.risorsa.senseisrl.Library2SessionBeanRemote");
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
        System.out.println("Weeeee " + libraryBean.spara("Puuuuuuupo"));
        System.out.println("Weeeee " + libraryBean2.spara("mi senti????"));

        testStatelessEjb();
    }
    
    private static void showGUI() {
        System.out.println("*************************");
        System.out.println("Welcome to the book store");
        System.out.println("**************************");
        System.out.println("Option \n1. Add Book\n2. Exit");
        System.out.print("Enter choice: ");
    }
    
    private static void testStatelessEjb() throws NamingException, IOException {
        
        try {
            int choice = 1;
            
            while(choice != 2) {
                String bookName;
                showGUI();
                String strChoice = buffer.readLine();
                choice = Integer.parseInt(strChoice);
                if(choice == 1) {
                    System.out.print("Enter book name: ");
                    bookName = buffer.readLine();
                    libraryBean.addBook(bookName);
                }
                else if(choice == 2) {
                    break;
                }
            }
            
            List<String> booksList = libraryBean.getBooks();
            System.out.println("Book(s) entered so far: " + booksList.size());
            for (int i = 0; i < booksList.size(); i++) {
                System.out.println((i+1)+ ". " + booksList.get(i));
            }
            
        } catch(IOException | NumberFormatException e) {
           System.out.println(e.getMessage());
        } finally {
            buffer.close();
        }
        
    }
}
