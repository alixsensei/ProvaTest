
package it.risorsa.senseisrl;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;

@Remote
public interface Library2SessionBeanRemote {
    
   void addBook(String bookName);
    
    List getBooks();
    
    String spara(String stringa);
}
