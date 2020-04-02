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
import java.io.StringReader;
import java.sql.SQLException;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.HttpHeaders;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
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
    @Consumes({MediaType.APPLICATION_JSON, MediaType.TEXT_PLAIN})
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML, MediaType.TEXT_PLAIN, MediaType.TEXT_PLAIN})
    public String getXml(@Context HttpHeaders headers,String data, @QueryParam("id") int id) throws ParseException, SQLException {
   
        String contentType = headers.getRequestHeader("Content-Type").get(0);
        String result = "";
        String tempData = data;
        
        String title;
        String description;
        String isbn;
        String author;
        String publisher;
        boolean isAdded = false;
                
        if(contentType.equals("application/json")){
            System.out.println("json");
            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(tempData);

            title = json.get("title").toString();
            description = json.get("description").toString();
            isbn = json.get("isbn").toString();
            author  = json.get("author").toString();
            publisher = json.get("publisher").toString();
            
            isAdded = bookMVC.BooksController.getInstance().updateBookById(id, title, description, author, isbn, publisher );
        }
       
        else if(contentType.equals("text/plain")){
            String[] arr = data.split("&");    
            isAdded = bookMVC.BooksController.getInstance().updateBookById(Integer.parseInt(arr[0]), arr[1], arr[2], arr[3], arr[4], arr[5] );
        }
        
        JSONObject obj = new JSONObject();
        
        if(isAdded){
            obj.put("message", "Successfully update");
            return obj.toJSONString();
            
        }
        else{
            obj.put("message", "unsuccessfully update");
            return obj.toJSONString();
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
