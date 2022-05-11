/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.entities;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;

/**
 *
 * @author ASUS
 */
@Embeddable
public class LigneArticlePK implements Serializable{
    
    private String idArticle;
    
    private Integer idFacture;

    public String getIdArticle() {
        return idArticle;
    }

    public void setIdArticle(String idArticle) {
        this.idArticle = idArticle;
    }

    public Integer getIdFacture() {
        return idFacture;
    }

    public void setIdFacture(Integer idFacture) {
        this.idFacture = idFacture;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.idArticle);
        hash = 79 * hash + Objects.hashCode(this.idFacture);
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
        final LigneArticlePK other = (LigneArticlePK) obj;
        if (!Objects.equals(this.idArticle, other.idArticle)) {
            return false;
        }
        return Objects.equals(this.idFacture, other.idFacture);
    }
    
    
    
}
