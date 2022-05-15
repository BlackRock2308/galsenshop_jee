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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

/**
 *
 * @author ASUS
 */
@Entity
public class LigneArticle implements Serializable {

    @Id
    private String articlePK;

    @Column(name = "QUANTITE")
    private Double quantite;
    
    @Column(name = "ARTICLE_ID", nullable = false, length = 5)
    private String idArticle;
    
    @Column(name = "FACTURE_ID",nullable = false)
    private Integer idFacture;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(nullable = true, updatable = false,insertable = false)
    //@MapsId("idFacture")
    private Facture facture;

    @ManyToOne(fetch = FetchType.EAGER)
    //@MapsId("idFacture")
    @JoinColumn(nullable = true, updatable = false,insertable = false)
    private Article article;

    public LigneArticle(String articlePK, Double quantite, Integer idFacture, String idArticle, Facture facture, Article article) {
        this.articlePK = articlePK;
        this.quantite = quantite;
        this.idFacture = idFacture;
        this.idArticle = idArticle;
        this.facture = facture;
        this.article = article;
    }

    

    

    public LigneArticle() {
    }

    public String getArticlePK() {
        return articlePK;
    }

    public void setArticlePK(String articlePK) {
        this.articlePK = articlePK;
    }

    public Integer getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Integer idFacture) {
        this.idFacture = idFacture;
    }

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
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
