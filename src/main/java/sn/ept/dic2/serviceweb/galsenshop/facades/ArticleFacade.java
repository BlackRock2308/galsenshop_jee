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
import sn.ept.dic2.serviceweb.galsenshop.entities.Article;
import sn.ept.dic2.serviceweb.galsenshop.entities.Categorie;

/**
 *
 * @author ASUS
 */
@Stateless
public class ArticleFacade extends AbstractFacade<Article> {

    @PersistenceContext(unitName = "galsenShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ArticleFacade() {
        super(Article.class);
    }
    
        public List<Article> findArticle(String searchText) {

        // http://localhost:8080/galsenshop/api/categories/search?text=searchText
        
        String requete = "SELECT a FROM Article a WHERE a.libele like '%" + searchText + "%' OR a.description like '%" + searchText + "%' ORDER BY a.code DESC";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }
    
}
