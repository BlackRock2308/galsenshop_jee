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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sn.ept.dic2.serviceweb.galsenshop.entities.Categorie;
import sn.ept.dic2.serviceweb.galsenshop.entities.Facture;
import sn.ept.dic2.serviceweb.galsenshop.facades.FactureFacade;

/**
 *
 * @author ASUS
 */
@Path("factures")
public class FactureRessource {

    @EJB
    private FactureFacade factureFacade;

    /**
     * ************* find all facture *********************** *
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Facture> getFactures() {

        return factureFacade.findAll();
    }

    /**
     * ************* find facture by Id *********************** *
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Facture getFactureById(@PathParam("id") Integer id) {
        Facture c = factureFacade.find(id);
        if (c == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return c;
    }

    /**
     * ************* Add new facture *********************** *
     */
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Facture createFacture(Facture c) {
        System.out.println("createFacture " + c);
        c.setDate(new Date());
        factureFacade.create(c);
        return c;
    }

    /**
     * ************* Delete existing category *********************** *
     */
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{numero}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteFacture(@PathParam("numero") Integer numero) {

        Facture cat = getFactureById(numero);

        factureFacade.remove(cat);

        return Response.noContent().build();

    }
    
        /**
     * ************* Search category based on Client Name  *********************** *
     */
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Facture> findFactureByClient(@QueryParam("text") String searchText) {
        return factureFacade.findFactureByCLientName(searchText);
    }
    
            /**
     * ************* Search category based on Client Name  *********************** *
     */
    @GET
    @Path("/searchByDate")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Facture> findFactureByDate(@QueryParam("start") String start,@QueryParam("end") String end) {
        return factureFacade.findFactureByIntervalleDate(start, end);
    }

}
