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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
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
public class InsertBookAPI {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of InsertBookAPIResource
     */
    public InsertBookAPI() {
    }
    
    
    
    
    @POST
    @Consumes({"application/json",MediaType.TEXT_PLAIN}) 
    @Produces({MediaType.TEXT_PLAIN,MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_HTML})
    public String addBook(@Context HttpHeaders headers, String data) throws ParseException {
        String contentType = headers.getRequestHeader("Content-Type").get(0);
        JSONObject obj = new JSONObject();
        Books book = null;
        String result = "";
        
        if(contentType.toLowerCase().contains("text")){
             //string key=value & key=value
             System.out.println(data);
             String tempDataArr []= data.split("&");
             String title = "";
             String description = "";
             String isbn = "";
             String author  = "";
             String publisher = "";
            
             for(String str : tempDataArr){
                 String tmp [] = str.split("=");
                 
                 if(tmp[0].equalsIgnoreCase("title")){
                     title = tmp[1];
                 }
                 else if(tmp[0].equalsIgnoreCase("description"))
                 {
                     description= tmp[1];
                 }
                 else if(tmp[0].equalsIgnoreCase("isbn"))
                 {
                     isbn= tmp[1];
                 }
                 else if(tmp[0].equalsIgnoreCase("author"))
                 {
                     author= tmp[1];
                 }
                 else if(tmp[0].equalsIgnoreCase("publisher"))
                 {
                     publisher= tmp[1];
                 }
             }//END FOR
            book = new Books(title, description, isbn, author, publisher);

            boolean isAdded = bookMVC.BooksController.getInstance().addBook(book);

            if(isAdded){
                result =  "Sucessfully added \"" + title + "\"";
            }
            else
            {
                result =  "Error, please try again.";
            }
        
        }else{
                  
                String tempData = data;


                JSONParser parser = new JSONParser();
                JSONObject json = (JSONObject) parser.parse(tempData);

                String title = json.get("title").toString();
                String description = json.get("description").toString();
                String isbn = json.get("isbn").toString();
                String author  = json.get("author").toString();
                String publisher = json.get("publisher").toString();
                book = new Books(title, description, isbn, author, publisher);

                boolean isAdded = bookMVC.BooksController.getInstance().addBook(book);

                if(isAdded){
                    result =  "Sucessfully added \"" + title + "\"";
                }
                else
                {
                    result =  "Error, please try again.";
                }
      
        }
        obj.put("message", result);

        return obj.toJSONString();
    }

    
    /**
     * PUT method for updating or creating an instance of InsertBookAPI
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void putXml(String content) {
    }
}
