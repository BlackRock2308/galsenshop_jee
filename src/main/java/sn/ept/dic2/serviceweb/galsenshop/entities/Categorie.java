/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;

/**
 *
 * @author ASUS
 */
@Entity
public class Categorie implements Serializable {

    @Id
    @Column(name = "code", length = 3)
    private String code;
    @Column(name = "LIBELE",length = 100)
    private String libele;
    @Column(name = "DESCRIPTION",length = 100)
    private String description;
    @Column(name = "TVA")
    private Double tva;
    @OneToMany
    @JoinColumn(name = "categorie_code") // we need to duplicate the physical
    private Set<Article> articles= new HashSet<>();

    public Categorie() {
    }

    public Categorie(String code, String libele, String description, Double tva) {
        this.code = code;
        this.libele = libele;
        this.description = description;
        this.tva = tva;
    }

    public Categorie(String code, String libele, String description) {
        this.code = code;
        this.libele = libele;
        this.description = description;
    }
   
   
  

    @PrePersist
    private void initTVA(){
        if(tva == null){
            tva = 0.0;
            System.out.println("La TVA est initialie a : " +tva);
        }
    }

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
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

    public Double getTva() {
        return tva;
    }

    public void setTva(Double tva) {
        this.tva = tva;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 19 * hash + Objects.hashCode(this.code);
        hash = 19 * hash + Objects.hashCode(this.libele);
        hash = 19 * hash + Objects.hashCode(this.description);
        hash = 19 * hash + Objects.hashCode(this.tva);
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
        final Categorie other = (Categorie) obj;
        if (!Objects.equals(this.code, other.code)) {
            return false;
        }
        if (!Objects.equals(this.libele, other.libele)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return Objects.equals(this.tva, other.tva);
    }

    @Override
    public String toString() {
        return "Categorie{" + "code=" + code + ", libele=" + libele + ", description=" + description + ", tva=" + tva + '}';
    }


    
}
