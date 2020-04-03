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
import javax.ws.rs.HeaderParam;
import javax.ws.rs.QueryParam;
import org.json.simple.JSONObject;


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
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN, MediaType.TEXT_HTML})
    public String getBook(@HeaderParam("Accept") String accepted, @QueryParam("id") int id, @QueryParam("title") String title){
    try{
                if(title != null){
        return Integer.toString(bookMVC.BooksController.getInstance().getBookByTitle(title));
       }
       else{
           JSONObject obj = new JSONObject();
           obj.put("title", bookMVC.BooksController.getInstance().getBookById(id).getTitle());
           obj.put("description", bookMVC.BooksController.getInstance().getBookById(id).getDescription());
           obj.put("isbn", bookMVC.BooksController.getInstance().getBookById(id).getISBN());
           obj.put("publisher", bookMVC.BooksController.getInstance().getBookById(id).getPublisher());
           obj.put("author", bookMVC.BooksController.getInstance().getBookById(id).getAuthor());
        
           return obj.toJSONString();
       }
    }catch(Exception e){
           System.out.println(e.getMessage());
           JSONObject obj = new JSONObject();
           obj.put("title", "No found");
           obj.put("description", "No found");
           obj.put("isbn", "No found");
           obj.put("publisher", "No found");
           obj.put("author", "No found");   
           return obj.toJSONString();   
    }
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
