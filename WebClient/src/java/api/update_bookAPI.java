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
 * @author vickelleung
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

    public String getXml_XML(Object requestEntity) throws UniformInterfaceException {

       String x = webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(String.class, requestEntity);
       JSONObject obj = new JSONObject(x);
       String xml = XML.toString(obj);

       return xml;
    }

    public String getXml_JSON(Object requestEntity) throws UniformInterfaceException {
        return webResource.type(javax.ws.rs.core.MediaType.APPLICATION_JSON).put(String.class, requestEntity);
    }

    public String getXml_TEXT(Object requestEntity) throws UniformInterfaceException {
       WebResource resource = webResource;
        String x = resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
        JSONObject obj = new JSONObject(x);

        String plainText = obj.get("title")+" " + obj.get("description") + " " + obj.get("author") + " " 
                + obj.get("isbn") + " " + obj.get("publisher");
         
        return plainText;
        
    }

    public String getXml_HTML(Object requestEntity) throws UniformInterfaceException {
        return webResource.type(javax.ws.rs.core.MediaType.TEXT_HTML).put(String.class, requestEntity);
    }

    public void putXml(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }

    public void close() {
        client.destroy();
    }
    
}
