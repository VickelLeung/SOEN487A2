/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.json.*;

/**
 * Jersey REST client generated for REST resource:GetBookAPI [get_book]<br>
 * USAGE:
 * <pre>
 *        get_bookAPI client = new get_bookAPI();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author vickelleung
 */
public class get_bookAPI {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Soen487A2LibraryService/webresources";

    public get_bookAPI() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("get_book");
    }

    public void putJson(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(requestEntity);
    }

    public String getBook_XML(String id) {
        try{
                WebResource resource = webResource;       
                if (id != null) {
                    resource = resource.queryParam("id", id);
                }
               String x = resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
               JSONObject obj = new JSONObject(x);
               String xml = XML.toString(obj);
               return xml;
           }
        catch(Exception e){
           JSONObject obj = new JSONObject();
           obj.put("error", e.toString());
           return XML.toString(obj);         
        } 

    }

    public String getBook_JSON(String id) {
        try{
            WebResource resource = webResource;
            if (id != null) {
                resource = resource.queryParam("id", id);
            }
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);

        }
        catch(Exception e){
           JSONObject obj = new JSONObject();
           obj.put("error", e.toString());
           return String.valueOf(obj);
        }
    }

    public String getBook_TEXT(String id){
        try{
            WebResource resource = webResource;
        
            if (id != null) {
                resource = resource.queryParam("id", id);
            }
             String x = resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
             JSONObject obj = new JSONObject(x);

             String plainText = obj.get("title")+" " + obj.get("description") + " " + obj.get("author") + " " 
                     + obj.get("isbn") + " " + obj.get("publisher");

            return plainText;
        }
        catch(Exception e){
            return "error " +e.toString();    
        }
        
    }
    
    public String getBook_HTML(String id, String title) throws UniformInterfaceException {
        WebResource resource = webResource;
        if (id != null) {
            resource = resource.queryParam("id", id);
        }
      
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void close() {
        client.destroy();
    }
    
}
