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
import sn.ept.dic2.serviceweb.galsenshop.entities.Client;

/**
 *
 * @author ASUS
 */
@Stateless
public class ClientFacade extends AbstractFacade<Client> {

    @PersistenceContext(unitName = "galsenShopPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ClientFacade() {
        super(Client.class);
    }

 

    public List<Client> findClientByNomOrPhone(String searchText) {

        // http://localhost:8080/galsenshop/api/categories/search?text=searchText
        String requete = "SELECT c FROM Client c WHERE c.nom like '%" + searchText + "%' OR c.telephone like '%" + searchText + "%' ORDER BY c.id DESC";

        Query q = em.createQuery(requete);

        return q.getResultList();

    }
}
