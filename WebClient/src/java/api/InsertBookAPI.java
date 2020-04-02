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
 * Jersey REST client generated for REST resource:InsertBookAPI [add_book]<br>
 * USAGE:
 * <pre>
 *        bb client = new bb();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author fokpoonkai
 */
public class InsertBookAPI {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Soen487A2LibraryService/webresources";

    public InsertBookAPI() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("add_book");
    }
//javax.ws.rs.core.MediaType.APPLICATION_XML
    public String addBook_JSON_TEXT(Object requestEntity) throws UniformInterfaceException {
        String data =  webResource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);
        JSONObject obj = new JSONObject(data);
        String plainText = obj.get("message")+"";
        return plainText;
    }
    
    public String addBook_JSON_JSON(Object requestEntity) throws UniformInterfaceException {
        return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);
    }
    
   public String addBook_JSON_HTML(Object requestEntity) throws UniformInterfaceException {
        return webResource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);
    }
   
    public String addBook_JSON_XML(Object requestEntity) throws UniformInterfaceException {
        String data = webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);
        org.json.JSONObject obj = new org.json.JSONObject(data);
        String xml = XML.toString(obj);
        
        return xml;
    }
    
    
    
    /////////
    
    
    public String addBook_TEXT_TEXT(Object requestEntity) throws UniformInterfaceException {
        String data = webResource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(String.class, requestEntity);
         JSONObject obj = new JSONObject(data);
         String plainText = obj.get("message")+"";
        return plainText;
    }

        
    public String addBook_TEXT_JSON(Object requestEntity) throws UniformInterfaceException {
        return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(String.class, requestEntity);
    }
    
        
    public String addBook_TEXT_HTML(Object requestEntity) throws UniformInterfaceException {
        return webResource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(String.class, requestEntity);
    }
       
    public String addBook_TEXT_XML(Object requestEntity) throws UniformInterfaceException {
        String data =  webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(String.class, requestEntity);
        org.json.JSONObject obj = new org.json.JSONObject(data);
        String xml = XML.toString(obj);
        
        return xml;
    }
    
    public void putXml(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }
    
    
    
    public void close() {
        client.destroy();
    }
    
}
