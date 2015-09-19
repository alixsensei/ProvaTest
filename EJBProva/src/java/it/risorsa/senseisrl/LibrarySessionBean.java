
package it.risorsa.senseisrl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.ejb.Stateful;

//@Stateless
@Stateful
public class LibrarySessionBean implements Library2SessionBeanRemote, LibrarySessionBeanRemote {
  
    List<String> bookShelf;
    
    @Override
    public String spara(String stringa) {
        return stringa;
       
    }

    public LibrarySessionBean() {
       bookShelf = new ArrayList<String>();
    }
    
    
    public void addBook(String bookName) {
        bookShelf.add(bookName);
    }

    public List<String> getBooks() {
        return bookShelf;
    }

}
