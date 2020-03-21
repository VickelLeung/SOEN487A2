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
import java.sql.SQLException;
import javax.ws.rs.QueryParam;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
/**
 * REST Web Service
 *
 * @author vickelleung
 */
@Path("update_book")
public class UpdateBookAPI {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of UpdateBookAPI
     */
    public UpdateBookAPI() {
    }

    /**
     * Retrieves representation of an instance of api.UpdateBookAPI
     * @return an instance of java.lang.String
     */
    @PUT
    @Produces(MediaType.APPLICATION_XML)
    public String getXml(String data, @QueryParam("id") int id) throws ParseException, SQLException {
   
        String result = "";
        String tempData = data;
        
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(tempData);
        
        String title = json.get("title").toString();
        String description = json.get("description").toString();
        String isbn = json.get("isbn").toString();
        String author  = json.get("author").toString();
        String publisher = json.get("publisher").toString();
        
        boolean isAdded = bookMVC.BooksController.getInstance().updateBookById(id, title, description, author, isbn, publisher );
        
        if(isAdded){
            return "Updated book";
        }
        else{
            return "Did not update";
        }
    }

    /**
     * PUT method for updating or creating an instance of UpdateBookAPI
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
