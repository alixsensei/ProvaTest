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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alix
 */
@Entity
@Table(name = "assunzione")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Assunzione.findAll", query = "SELECT a FROM Assunzione a"),
    @NamedQuery(name = "Assunzione.findByCodice", query = "SELECT a FROM Assunzione a WHERE a.codice = :codice"),
    @NamedQuery(name = "Assunzione.findByNomeAzienda", query = "SELECT a FROM Assunzione a WHERE a.nomeAzienda = :nomeAzienda"),
    @NamedQuery(name = "Assunzione.findByDipendente", query = "SELECT a FROM Assunzione a WHERE a.dipendente = :dipendente"),
    @NamedQuery(name = "Assunzione.findByDataAssunzione", query = "SELECT a FROM Assunzione a WHERE a.dataAssunzione = :dataAssunzione")})
public class Assunzione implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codice")
    private Integer codice;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nome_azienda")
    private String nomeAzienda;
    @Column(name = "dipendente")
    private Integer dipendente;
    @Column(name = "data_assunzione")
    @Temporal(TemporalType.DATE)
    private Date dataAssunzione;

    public Assunzione() {
    }

    public Assunzione(Integer codice) {
        this.codice = codice;
    }

    public Assunzione(Integer codice, String nomeAzienda) {
        this.codice = codice;
        this.nomeAzienda = nomeAzienda;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getNomeAzienda() {
        return nomeAzienda;
    }

    public void setNomeAzienda(String nomeAzienda) {
        this.nomeAzienda = nomeAzienda;
    }

    public Integer getDipendente() {
        return dipendente;
    }

    public void setDipendente(Integer dipendente) {
        this.dipendente = dipendente;
    }

    public Date getDataAssunzione() {
        return dataAssunzione;
    }

    public void setDataAssunzione(Date dataAssunzione) {
        this.dataAssunzione = dataAssunzione;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codice != null ? codice.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Assunzione)) {
            return false;
        }
        Assunzione other = (Assunzione) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.sensei.assunzioni.Assunzione[ codice=" + codice + " ]";
    }
    
}
