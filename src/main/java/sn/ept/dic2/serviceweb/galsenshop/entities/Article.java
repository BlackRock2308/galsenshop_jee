/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author ASUS
 */
@Entity
public class Article implements Serializable {

    @Id
    @Column(name = "CODE", length = 5)
    private String code;
    @Column(name = "LIBELE", length = 30)
    private String libele;
    @Column(name = "DESCRIPTION", length = 100)
    private String description;
    @Column(name = "PRIX_UNITAIRE")
    private Double prix_unitaire;
    @Column(name = "UNITE", length = 45)
    private String unite;
    @Column(name = "QTE_STOCK")
    private Double quantite_stock;
    
    @ManyToOne
    private Categorie categorie;

    public Article(String code, String libele, String description, Double prix_unitaire, String unite, Double quantite_stock, Categorie categorie) {
        this.code = code;
        this.libele = libele;
        this.description = description;
        this.prix_unitaire = prix_unitaire;
        this.unite = unite;
        this.quantite_stock = quantite_stock;
        this.categorie = categorie;
    }

    public Article() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibele() {
        return libele;
    }

    public void setLibele(String libele) {
        this.libele = libele;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrix_unitaire() {
        return prix_unitaire;
    }

    public void setPrix_unitaire(Double prix_unitaire) {
        this.prix_unitaire = prix_unitaire;
    }

    public String getUnite() {
        return unite;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public Double getQuantite_stock() {
        return quantite_stock;
    }

    public void setQuantite_stock(Double quantite_stock) {
        this.quantite_stock = quantite_stock;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.code);
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
        final Article other = (Article) obj;
        return Objects.equals(this.code, other.code);
    }

    @Override
    public String toString() {
        return "Article{" + "code=" + code + ", libele=" + libele + ", description=" + description + ", prix_unitaire=" + prix_unitaire + ", unite=" + unite + ", quantite_stock=" + quantite_stock + ", categorie=" + categorie + '}';
    }
    
    
    
}
