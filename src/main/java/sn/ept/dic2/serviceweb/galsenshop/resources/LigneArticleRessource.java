/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.resources;

import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sn.ept.dic2.serviceweb.galsenshop.entities.Facture;
import sn.ept.dic2.serviceweb.galsenshop.entities.LigneArticle;
import sn.ept.dic2.serviceweb.galsenshop.facades.LigneArticleFacade;

/**
 *
 * @author ASUS
 */
@Path("orders")
public class LigneArticleRessource {
    
    @EJB
    private LigneArticleFacade ligneArticleFacade;
    
    
    /**
     * ************* find all Orders *********************** *
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<LigneArticle> getOrders() {

        return ligneArticleFacade.findAll();
    }

    /**
     * ************* find Order by Id *********************** *
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public LigneArticle getOrderById(@PathParam("id") String id) {
        LigneArticle c = ligneArticleFacade.find(id);
        if (c == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return c;
    }

    /**
     * ************* Add new Order *********************** *
     */
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public LigneArticle createOrder(LigneArticle c) {
        System.out.println("createFacture " + c);
        ligneArticleFacade.create(c);
        return c;
    }

    /**
     * ************* Delete existing Order *********************** *
     */
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{numero}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteFacture(@PathParam("numero") String numero) {

        LigneArticle cat = getOrderById(numero);

        ligneArticleFacade.remove(cat);

        return Response.noContent().build();

    }

}