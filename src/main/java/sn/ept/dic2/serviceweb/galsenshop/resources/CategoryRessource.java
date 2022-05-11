/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sn.ept.dic2.serviceweb.galsenshop.resources;

import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import sn.ept.dic2.serviceweb.galsenshop.entities.Categorie;
import sn.ept.dic2.serviceweb.galsenshop.facades.CategorieFacade;

/**
 *
 * @author ASUS
 */
@Path("categories")
public class CategoryRessource {

    @EJB
    private CategorieFacade categorieFacade;

    /**
     * ************* find all categories *********************** *
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categorie> getCategories() {

        return categorieFacade.findAll();
    }

    /**
     * ************* find category by Id *********************** *
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categorie getCategorieById(@PathParam("id") String id) {
        Categorie c = categorieFacade.find(id);
        if (c == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return c;
    }

    /**
     * ************* Add new category *********************** *
     */
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categorie createCategorie(Categorie c) {
        System.out.println("createCategorie " + c);
        categorieFacade.create(c);
        return c;
    }

    /**
     * ************* Update existing category *********************** *
     */
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{code}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Categorie updateCategorie(@PathParam("code") String code, Categorie c) {

        Categorie cat = getCategorieById(code);
        //epdda el a partir de e
        cat.setLibele(c.getLibele());
        cat.setDescription(c.getDescription());
        cat.setTva(c.getTva());

        categorieFacade.edit(cat);

        return cat;

    }
    
        /**
     * ************* Delete existing category *********************** *
     */
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{code}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteCategorie(@PathParam("code") String code) {

        Categorie cat = getCategorieById(code);
        
        categorieFacade.remove(cat);

        return Response.noContent().build();

    }

    /**
     * ************* Search category based on searcText  *********************** *
     */
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Categorie> findCategorie(@QueryParam("text") String searchText) {
        return categorieFacade.findCategorie(searchText);
    }
}
