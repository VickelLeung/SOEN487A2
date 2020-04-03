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
 * Jersey REST client generated for REST resource:UpdateBookAPI
 * [update_book]<br>
 * USAGE:
 * <pre>
 *        update_bookAPI client = new update_bookAPI();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author fokpoonkai
 */
public class update_bookAPI {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Soen487A2LibraryService/webresources";

    public update_bookAPI() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("update_book");
    }

    public String getXml_JSON_JSON(Object requestEntity) throws UniformInterfaceException {
        return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(String.class, requestEntity);
    }
    
   public String getXml_JSON_XML(Object requestEntity) {
       try{
             String x = webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(String.class, requestEntity);
            JSONObject obj = new JSONObject(x);
            String xml = XML.toString(obj);

            return xml;
       
       } catch(Exception e){
           JSONObject obj = new JSONObject();
           obj.put("error", e.toString());
           return XML.toString(obj);         
        } 
    }
   
   public String getXml_JSON_TEXT(Object requestEntity) {
        try{
                String x = webResource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(String.class, requestEntity);
                JSONObject obj = new JSONObject(x);       
               String plainText = obj.get("message")+ "";
               return plainText;
        
        } 
        catch(Exception e){
            return "error " +e.toString();    
        }


   }
    
   public String getXml_JSON_HTML(Object requestEntity) {
       try{
            return webResource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(String.class, requestEntity);
       }
       catch(Exception e){
            return "error " +e.toString();    
        } 
    }

    ////////////
    public String getXml_TEXT_TEXT(Object requestEntity) {
        try{
          return webResource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).put(String.class, requestEntity);
        }
       catch(Exception e){
            return "error " +e.toString();    
        }
    }
    
    public String getXml_TEXT_HTML(Object requestEntity){
        try{
            return webResource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).put(String.class, requestEntity);
        }
        catch(Exception e){
            return "error " +e.toString();    
        }
   
    }
    
    
     public String getXml_TEXT_JSON(Object requestEntity) {
         try{
              return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).put(String.class, requestEntity);
         }
         catch(Exception e){
            JSONObject obj = new JSONObject();
            obj.put("error", e.toString());
            return String.valueOf(obj);
        }
    }
    
    public String getXml_TEXT_XML(Object requestEntity) {
        try{
             return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).put(String.class, requestEntity);
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