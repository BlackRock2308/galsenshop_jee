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
import sn.ept.dic2.serviceweb.galsenshop.entities.Client;
import sn.ept.dic2.serviceweb.galsenshop.facades.ClientFacade;

/**
 *
 * @author ASUS
 */
@Path("clients")
public class ClientRessource {
    
    @EJB
    private ClientFacade clientFacade;
    
    /**
     * ************* find all clients *********************** *
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Client> getClients() {

        return clientFacade.findAll();
    }

    /**
     * ************* find category by Id *********************** *
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Client getClientById(@PathParam("id") Integer id) {
        Client c = clientFacade.find(id);
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
    public Client createClient(Client c) {
        System.out.println("createClient " + c);
        clientFacade.create(c);
        return c;
    }

    /**
     * ************* Update existing client *********************** *
     */
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Client updateClient(@PathParam("id") Integer id, Client c) {

        Client cli = getClientById(id);
        cli.setAdresse(c.getAdresse());
        cli.setTelephone(c.getNom());
        cli.setNom(c.getNom());

        clientFacade.edit(cli);

        return cli;

    }
    
        /**
     * ************* Delete existing client *********************** *
     */
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{id}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteClient(@PathParam("id") Integer id) {

        Client cli = getClientById(id);
        
        clientFacade.remove(cli);

        return Response.noContent().build();

    }

   /**
     * ************* Search category based on searcText  *********************** *
     */
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Client> findClient(@QueryParam("text") String searchText) {
        return clientFacade.findClientByNomOrPhone(searchText);
    }
    
}
