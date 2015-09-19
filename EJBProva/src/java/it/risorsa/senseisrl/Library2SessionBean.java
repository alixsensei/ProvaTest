/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.risorsa.senseisrl;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;


@Stateless
public class Library2SessionBean implements Library2SessionBeanRemote {

     List<String> bookShelf;
     
     public Library2SessionBean() {
       bookShelf = new ArrayList<String>();
    }
    
    @Override
    public void addBook(String bookName) {
        bookShelf.add(bookName);
    }

    @Override
    public List getBooks() {
        return bookShelf;
    }

    @Override
    public String spara(String stringa) {
        return stringa;
    }
}
