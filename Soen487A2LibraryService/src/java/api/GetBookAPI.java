/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import bookMVC.Books;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import static bookMVC.BooksController.getInstance;
import javax.ws.rs.QueryParam;

/**
 * REST Web Service
 *
 * @author vickelleung
 */
@Path("get_book")
public class GetBookAPI {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of GetBookAPI
     */
    public GetBookAPI() {
    }

    /**
     * Retrieves representation of an instance of api.GetBookAPI
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getBook(@QueryParam("id") int id) throws ClassNotFoundException {
        
       System.out.println("id: "+id);
       
       return bookMVC.BooksController.getInstance().getBookById(id).toString();
    }

    /**
     * PUT method for updating or creating an instance of GetBookAPI
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
