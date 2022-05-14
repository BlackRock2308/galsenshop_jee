/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author ASUS
 */
@Entity
public class Facture implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer numero;
    @Temporal(TemporalType.TIMESTAMP)  //2001-02-16 20:38:40
    private Date date ;
    
    @Column(nullable = false)
    private Integer cientId;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cientId", nullable = false, updatable = false,insertable = false)
    private Client client;
    
    @OneToMany(cascade = CascadeType.ALL ,fetch = FetchType.LAZY)
    private Set<LigneArticle> ligneArticles = new HashSet<>();

    public Facture(Integer numero, Date date, Integer cientId, Client client) {
        this.numero = numero;
        this.date = date;
        this.cientId = cientId;
        this.client = client;
    }
    


    public Facture() {
    }

   

    public Set<LigneArticle> getLigneArticles() {
        return ligneArticles;
    }

    public void setLigneArticles(Set<LigneArticle> ligneArticles) {
        this.ligneArticles = ligneArticles;
    }

    public Integer getCientId() {
        return cientId;
    }

    public void setCientId(Integer cientId) {
        this.cientId = cientId;
    }

    
    
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.numero);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Facture other = (Facture) obj;
        return Objects.equals(this.numero, other.numero);
    }
    
    
    
}
