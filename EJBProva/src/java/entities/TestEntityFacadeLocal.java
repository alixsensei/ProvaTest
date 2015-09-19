/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.util.List;
import javax.ejb.Local;
import javax.ejb.Remote;


@Remote
public interface TestEntityFacadeLocal {
    
    void addBook(Book book);
    
    List<Book> getBooks();

//    void create(Book testEntity);
//
//    void edit(Book testEntity);
//
//    void remove(Book testEntity);
//
//    Book find(Object id);
//
//    List<Book> findAll();
//
//    List<Book> findRange(int[] range);
//
//    int count();
    
}
