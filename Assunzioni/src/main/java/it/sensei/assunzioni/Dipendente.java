/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sensei.assunzioni;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alix
 */
@Entity
@Table(name = "dipendente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dipendente.findAll", query = "SELECT d FROM Dipendente d"),
    @NamedQuery(name = "Dipendente.findById", query = "SELECT d FROM Dipendente d WHERE d.id = :id"),
    @NamedQuery(name = "Dipendente.findByNome", query = "SELECT d FROM Dipendente d WHERE d.nome = :nome"),
    @NamedQuery(name = "Dipendente.findByCognome", query = "SELECT d FROM Dipendente d WHERE d.cognome = :cognome"),
    @NamedQuery(name = "Dipendente.findByDataDiNascita", query = "SELECT d FROM Dipendente d WHERE d.dataDiNascita = :dataDiNascita"),
    @NamedQuery(name = "Dipendente.findByCodiceFiscale", query = "SELECT d FROM Dipendente d WHERE d.codiceFiscale = :codiceFiscale")})
public class Dipendente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 50)
    @Column(name = "nome")
    private String nome;
    @Size(max = 20)
    @Column(name = "cognome")
    private String cognome;
    @Column(name = "data_di_nascita")
    @Temporal(TemporalType.DATE)
    private Date dataDiNascita;
    @Size(max = 16)
    @Column(name = "codice_fiscale")
    private String codiceFiscale;

    public Dipendente() {
    }

    public Dipendente(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Date getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(Date dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getCodiceFiscale() {
        return codiceFiscale;
    }

    public void setCodiceFiscale(String codiceFiscale) {
        this.codiceFiscale = codiceFiscale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dipendente)) {
            return false;
        }
        Dipendente other = (Dipendente) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.sensei.assunzioni.Dipendente[ id=" + id + " ]";
    }
    
}
