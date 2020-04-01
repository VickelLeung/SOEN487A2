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
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

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
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML,MediaType.TEXT_PLAIN,MediaType.TEXT_HTML})
    public String getJson() {
        /*
            public int id;
    public String title;
    public String description;
    public String author;
    public String ISBN;
    public String Publisher;

        
        */
         JSONArray list = new JSONArray();
         HashMap<Integer, Books> hm = new HashMap<Integer, Books>();
         hm = bookMVC.BooksController.getInstance().getBookList();
          for (int i : hm.keySet()){
             JSONObject obj = new JSONObject();
             obj.put("id", hm.get(i).getId());
             obj.put("title", hm.get(i).getTitle());
             obj.put("description", hm.get(i).getDescription());
             obj.put("author", hm.get(i).getAuthor());
             obj.put("ISBN", hm.get(i).getISBN());
             obj.put("publisher", hm.get(i).getPublisher());
             list.add(obj);
          }
//          int index = 0;
//          for (Map.Entry<Integer,Books> entry : hm.entrySet()) {
//              
//              results+="[index]: "+index + "\n"+ entry.getValue().toString() + "\n";
//              index++;
//          }         
         return list.toJSONString();
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
