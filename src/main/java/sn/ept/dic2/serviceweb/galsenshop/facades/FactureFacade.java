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
import sn.ept.dic2.serviceweb.galsenshop.entities.Facture;

/**
 *
 * @author ASUS
 */
@Stateless
public class FactureFacade extends AbstractFacade<Facture> {

    @PersistenceContext(unitName = "galsenShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FactureFacade() {
        super(Facture.class);
    }

    public List<Facture> findFactureByCLientName(String searchText) {

        // http://localhost:8080/galsenshop/api/factures/search?text=searchText
        String requete = "SELECT f FROM Facture f INNER JOIN Client c ON f.cientId = c.id WHERE c.nom like '%" + searchText + "%' ORDER BY f.numero";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }

    public List<Facture> findFactureByIntervalleDate(String start, String end) {

        // http://localhost:8080/galsenshop/api/factures/search?text=searchText
        String requete = "SELECT f.numero,f.date  FROM Facture f WHERE f.date > '%" + start + "%' AND f.date < '%" + end + "%' ORDER BY f.numero" ;
         

        Query q = em.createQuery(requete);

        return q.getResultList();

    }

}
