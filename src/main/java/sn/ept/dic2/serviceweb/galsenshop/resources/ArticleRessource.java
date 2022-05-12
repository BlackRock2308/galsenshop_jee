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
import sn.ept.dic2.serviceweb.galsenshop.entities.Article;
import sn.ept.dic2.serviceweb.galsenshop.entities.Categorie;
import sn.ept.dic2.serviceweb.galsenshop.facades.ArticleFacade;

/**
 *
 * @author ASUS
 */
@Path("articles")
public class ArticleRessource {
    
    @EJB
    private ArticleFacade articleFacade;
    
    /**
     * ************* find all Articles *********************** *
     */
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Article> getArticles() {

        return articleFacade.findAll();
    }

    /**
     * ************* find Article by Id *********************** *
     */
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article getArticleById(@PathParam("id") String id) {
        Article c = articleFacade.find(id);
        if (c == null) {
            throw new WebApplicationException(Response.Status.NOT_FOUND);
        }
        return c;
    }

    /**
     * ************* Add new Article *********************** *
     */
    @POST
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article createArticle(Article c) {
        System.out.println("createCategorie " + c);
        articleFacade.create(c);
        return c;
    }

    /**
     * ************* Update existing Article *********************** *
     */
    @PUT
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{code}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Article updatArticle(@PathParam("code") String code, Article a) {

        Article art = getArticleById(code);
        //epdda el a partir de e
        art.setLibele(a.getLibele());
        art.setDescription(a.getDescription());
        art.setPrix_unitaire(a.getPrix_unitaire());
        
        art.setQuantite_stock(a.getQuantite_stock());
        art.setUnite(a.getUnite());

        articleFacade.edit(art);

        return art;
    }
    
        /**
     * ************* Delete existing Article *********************** *
     */
    @DELETE
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("/{code}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Response deleteCategorie(@PathParam("code") String code) {

        Article art = getArticleById(code);
        
        articleFacade.remove(art);

        return Response.noContent().build();

    }

    /**
     * ************* Search Article based on searcText  *********************** *
     */
    @GET
    @Path("/search")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Article> findArticle(@QueryParam("text") String searchText) {
        return articleFacade.findArticle(searchText);
    }
}

    

