/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.facades;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sn.ept.dic2.serviceweb.galsenshop.entities.Categorie;

/**
 *
 * @author ASUS
 */
@Stateless
public class CategorieFacade extends AbstractFacade<Categorie> {

    @PersistenceContext(unitName = "galsenShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CategorieFacade() {
        super(Categorie.class);
    }

    public List<Categorie> findCategorie(String searchText) {

        // http://localhost:8080/galsenshop/api/categories/search?text=searchText
        
        String requete = "SELECT c FROM Categorie c WHERE c.libele like '%" + searchText + "%' OR c.description like '%" + searchText + "%'  ORDER BY c.code DESC";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }
}
