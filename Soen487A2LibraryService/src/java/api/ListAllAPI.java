/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import bookMVC.Books;
import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author vickelleung
 */
@Path("list_all")
public class ListAllAPI {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of List_allAPI
     */
    public ListAllAPI() {
    }

    /**
     * Retrieves representation of an instance of api.GetbookResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
         String results ="";
         HashMap<Integer, Books> hm = new HashMap<Integer, Books>();
         hm = bookMVC.BooksController.getInstance().getBookList();
            
          int index = 0;
          for (Map.Entry<Integer,Books> entry : hm.entrySet()) {
              
              results+="[index]: "+index + "\n"+ entry.getValue().toString() + "\n";
              index++;
          }
          
         return results;
    }

    /**
     * PUT method for updating or creating an instance of ListAllAPI
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
