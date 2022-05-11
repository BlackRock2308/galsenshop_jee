/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB31/SingletonEjbClass.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.init;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import sn.ept.dic2.serviceweb.galsenshop.entities.Categorie;
import sn.ept.dic2.serviceweb.galsenshop.facades.CategorieFacade;

/**
 *
 * @author ASUS
 */
@Singleton
@Startup
public class InitCategorie {

    @EJB
    private CategorieFacade categorieFacade;
 
    //permet de créer l'objet au démarrage
    @PostConstruct
    public void init() {
        System.out.println("Demarrage de l'application");

        if (categorieFacade.count() == 0) {

            System.out.println("la BD contient :" +categorieFacade.count() + "elements");
            
            Categorie c1 = new Categorie("BSE", "biens sociaux essentiels", "les médicaments,appareils médico-chirurgicaux,le papier journal, les livres, les journa");
            Categorie c2 = new Categorie("BPN", "biens de premières nécessités", "Les matières premières de base, les biens d'équipement et les intrants spécifiques", 0.05);
            Categorie c3 = new Categorie("IPI", "Intrants et produits intermédiares", "", 0.1);
            Categorie c4 = new Categorie("BCF", "Biens de consommation finale", "Catégorie par défaut", 0.2);

            
            categorieFacade.create(c1);
            categorieFacade.create(c2);
            categorieFacade.create(c3);
            categorieFacade.create(c4);

        }

    }

}
