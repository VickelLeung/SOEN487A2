/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import bookMVC.Books;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * REST Web Service
 *
 * @author vickelleung
 */
@Path("add_book")
public class AddBookAPI {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of AddBookAPI
     */
    public AddBookAPI() {
    }

    /**
     * Retrieves representation of an instance of api.AddBookAPI
     * @return an instance of java.lang.String
     */
    @POST
    @Consumes("application/json") 
    @Produces(MediaType.TEXT_PLAIN)
    public String addBook(String data) throws ParseException {
       
        String result = "";
        String tempData = data;
        
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(tempData);
        
        String title = json.get("title").toString();
        String description = json.get("description").toString();
        String isbn = json.get("isbn").toString();
        String author  = json.get("author").toString();
        String publisher = json.get("publisher").toString();
        Books book = new Books(title, description, isbn, author, publisher);
        
        boolean isAdded = bookMVC.BooksController.getInstance().addBook(book);
        
        if(isAdded){
            result =  "Sucessfully added \"" + title + "\"";
        }
        else
        {
            result =  "Error, please try again.";
        }
        
        return result;
    }

    /**
     * PUT method for updating or creating an instance of AddBookAPI
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
