/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.facades;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    
}
