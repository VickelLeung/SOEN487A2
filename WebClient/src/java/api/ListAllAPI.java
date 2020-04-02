/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Jersey REST client generated for REST resource:ListAllAPI [list_all]<br>
 * USAGE:
 * <pre>
 *        aa client = new aa();
 *        Object response = client.XXX(...);
 *        // do whatever with response
 *        client.close();
 * </pre>
 *
 * @author fokpoonkai
 */
public class ListAllAPI {

    private WebResource webResource;
    private Client client;
    private static final String BASE_URI = "http://localhost:8080/Soen487A2LibraryService/webresources";

    public ListAllAPI() {
        com.sun.jersey.api.client.config.ClientConfig config = new com.sun.jersey.api.client.config.DefaultClientConfig();
        client = Client.create(config);
        webResource = client.resource(BASE_URI).path("list_all");
    }

    public void putXml(Object requestEntity) throws UniformInterfaceException {
        webResource.type(javax.ws.rs.core.MediaType.APPLICATION_XML).put(requestEntity);
    }

    public String getJson_XML() throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);
    }

    public String getJson_JSON() throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
    }

    public String getJson_TEXT() throws UniformInterfaceException, ParseException {
        WebResource resource = webResource;
        String data = resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);
        String result = "";
        
        JSONParser parser = new JSONParser();
        JSONArray array = (JSONArray)parser.parse(data);
        /*
        {"ISBN":"apple","author":"apple","description":"apple is sweet","publisher":"","id":1,"title":"apple"}*/
        for(int i = 0; i < array.size(); i++){
           //result = result + (String)(((JSONObject)array.get(i)).get("id")) +" "+(String)(((JSONObject)array.get(i)).get("title"))+" "+(String)(((JSONObject)array.get(i)).get("description"))+" "+(String)(((JSONObject)array.get(i)).get("publisher"))+" "+(String)(((JSONObject)array.get(i)).get("author"))+"\n";    
             result =result + String.valueOf(((JSONObject)array.get(i)).get("id")) +  "  "
                        + String.valueOf((((JSONObject)array.get(i)).get("title"))) + "  "
                        + String.valueOf(((JSONObject)array.get(i)).get("description")) +  "  "
                        + String.valueOf(((JSONObject)array.get(i)).get("author")) +  "  " 
                        + String.valueOf(((JSONObject)array.get(i)).get("ISBN")) + "  "
                        + String.valueOf(((JSONObject)array.get(i)).get("publisher"))
                        +"\n";
        }
        return result;
    }

    public String getJson_HTML() throws UniformInterfaceException {
        WebResource resource = webResource;
        return resource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
    }

    public void close() {
        client.destroy();
    }
    
}
