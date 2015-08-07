/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.sensei.assunzioni;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alix
 */
@Entity
@Table(name = "azienda")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Azienda.findAll", query = "SELECT a FROM Azienda a"),
    @NamedQuery(name = "Azienda.findByCodice", query = "SELECT a FROM Azienda a WHERE a.codice = :codice"),
    @NamedQuery(name = "Azienda.findByNome", query = "SELECT a FROM Azienda a WHERE a.nome = :nome"),
    @NamedQuery(name = "Azienda.findBySettore", query = "SELECT a FROM Azienda a WHERE a.settore = :settore"),
    @NamedQuery(name = "Azienda.findByVia", query = "SELECT a FROM Azienda a WHERE a.via = :via"),
    @NamedQuery(name = "Azienda.findByNumeroCivico", query = "SELECT a FROM Azienda a WHERE a.numeroCivico = :numeroCivico"),
    @NamedQuery(name = "Azienda.findByCap", query = "SELECT a FROM Azienda a WHERE a.cap = :cap"),
    @NamedQuery(name = "Azienda.findByCitta", query = "SELECT a FROM Azienda a WHERE a.citta = :citta"),
    @NamedQuery(name = "Azienda.findByPaese", query = "SELECT a FROM Azienda a WHERE a.paese = :paese"),
    @NamedQuery(name = "Azienda.findByTelefono", query = "SELECT a FROM Azienda a WHERE a.telefono = :telefono"),
    @NamedQuery(name = "Azienda.findByResponsabile", query = "SELECT a FROM Azienda a WHERE a.responsabile = :responsabile")})
public class Azienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codice")
    private Integer codice;
    @Size(max = 30)
    @Column(name = "nome")
    private String nome;
    @Size(max = 30)
    @Column(name = "settore")
    private String settore;
    @Size(max = 30)
    @Column(name = "via")
    private String via;
    @Column(name = "numero_civico")
    private Integer numeroCivico;
    @Column(name = "cap")
    private Integer cap;
    @Size(max = 30)
    @Column(name = "citta")
    private String citta;
    @Size(max = 30)
    @Column(name = "paese")
    private String paese;
    @Size(max = 12)
    @Column(name = "telefono")
    private String telefono;
    @Size(max = 30)
    @Column(name = "responsabile")
    private String responsabile;

    public Azienda() {
    }

    public Azienda(Integer codice) {
        this.codice = codice;
    }

    public Integer getCodice() {
        return codice;
    }

    public void setCodice(Integer codice) {
        this.codice = codice;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSettore() {
        return settore;
    }

    public void setSettore(String settore) {
        this.settore = settore;
    }

    public String getVia() {
        return via;
    }

    public void setVia(String via) {
        this.via = via;
    }

    public Integer getNumeroCivico() {
        return numeroCivico;
    }

    public void setNumeroCivico(Integer numeroCivico) {
        this.numeroCivico = numeroCivico;
    }

    public Integer getCap() {
        return cap;
    }

    public void setCap(Integer cap) {
        this.cap = cap;
    }

    public String getCitta() {
        return citta;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    public String getPaese() {
        return paese;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getResponsabile() {
        return responsabile;
    }

    public void setResponsabile(String responsabile) {
        this.responsabile = responsabile;
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
        if (!(object instanceof Azienda)) {
            return false;
        }
        Azienda other = (Azienda) object;
        if ((this.codice == null && other.codice != null) || (this.codice != null && !this.codice.equals(other.codice))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "it.sensei.assunzioni.Azienda[ codice=" + codice + " ]";
    }
    
}
