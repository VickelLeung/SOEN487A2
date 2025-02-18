/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

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
import org.json.simple.JSONObject;
/**
 * REST Web Service
 *
 * @author vickelleung
 */
@Path("delete_book")
public class DeleteBookAPI {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of DeleteBookAPI
     */
    public DeleteBookAPI() {
    }

    /**
     * Retrieves representation of an instance of api.DeleteBookAPI
     * @return an instance of java.lang.String
     */
    @GET
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN, MediaType.TEXT_XML})
    public String delete_book(@QueryParam("id") int id) {
        
        boolean isDeleted = bookMVC.BooksController.getInstance().deleteBookById(id);
        JSONObject obj = new JSONObject();
         
        if(isDeleted){
            obj.put("message", "Successfully deleted");
            return obj.toJSONString();
        }
        else{
           obj.put("message", "unsuccessfully deleted");
            return obj.toJSONString();
        }
        
    }

    /**
     * PUT method for updating or creating an instance of DeleteBookAPI
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
