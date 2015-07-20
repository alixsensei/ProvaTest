/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.primo;

import javax.ejb.Stateless;

/**
 *
 * @author Alix
 */
@Stateless
public class JavaBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private String cognome;
    private String nome;
    private boolean genius;

    /**
     * @return the cognome
     */
    public String getCognome() {
        return cognome;
    }

    /**
     * @param cognome the cognome to set
     */
    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the genius
     */
    public boolean isGenius() {
        return genius;
    }

    /**
     * @param genius the genius to set
     */
    public void setGenius(boolean genius) {
        this.genius = genius;
    }
    
    
}
