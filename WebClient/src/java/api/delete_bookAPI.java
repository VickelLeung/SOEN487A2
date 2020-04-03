/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.json.JSONObject;
import org.json.XML;

/**
 * Jersey REST client generated for REST resource:DeleteBookAPI
 * [delete_book]<br>
 * USAGE:
 * <pre>
 *        delete_bookAPI client = new delete_bookAPI();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author vickelleung
 */
public class delete_bookAPI {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Soen487A2LibraryService/webresources";

    public delete_bookAPI() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("delete_book");
    }

    public String delete_book_XML(String id) {
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

    public String delete_book_JSON(String id) {
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

    public String delete_book_TEXT(String id)  {
        try{
                WebResource resource = webResource;
                String x = resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
                 JSONObject obj = new JSONObject(x);      
                String plainText = obj.get("message")+"";         
                return plainText;
        }catch(Exception e){
            return "error " +e.toString();    
        }
    }

    public String delete_book_TEXT_XML(String id) {
        try{
             WebResource resource = webResource;
            if (id != null) {
                resource = resource.queryParam("id", id);
            }
            return resource.accept(javax.ws.rs.core.MediaType.TEXT_XML).get(String.class);
        }
        catch(Exception e){
           JSONObject obj = new JSONObject();
           obj.put("error", e.toString());
           return XML.toString(obj);         
        } 
    }

    public void putXml(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }

    public void close() {
        client.destroy();
    }
    
}
