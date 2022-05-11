/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author ASUS
 */
@Entity
public class LigneArticle implements Serializable {

    @EmbeddedId
    private LigneArticlePK articlePK;
    
    @ManyToOne
    @MapsId("idArticle")
    private Article article;
    
    @ManyToOne
    @MapsId("idFacture")
    private Facture facture;
    
    @Column(name = "QUANTITE")
    private Double quantite;

    public LigneArticlePK getArticlePK() {
        return articlePK;
    }

    public void setArticlePK(LigneArticlePK articlePK) {
        this.articlePK = articlePK;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public Double getQuantite() {
        return quantite;
    }

    public void setQuantite(Double quantite) {
        this.quantite = quantite;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.articlePK);
        hash = 37 * hash + Objects.hashCode(this.article);
        hash = 37 * hash + Objects.hashCode(this.facture);
        hash = 37 * hash + Objects.hashCode(this.quantite);
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
        final LigneArticle other = (LigneArticle) obj;
        if (!Objects.equals(this.articlePK, other.articlePK)) {
            return false;
        }
        if (!Objects.equals(this.article, other.article)) {
            return false;
        }
        if (!Objects.equals(this.facture, other.facture)) {
            return false;
        }
        return Objects.equals(this.quantite, other.quantite);
    }

    @Override
    public String toString() {
        return "LigneArticle{" 
                + "articlePK=" + articlePK 
                + ", article=" + article 
                + ", facture=" + facture 
                + ", quantite=" + quantite + '}';
    }
    
    
    
    
}
