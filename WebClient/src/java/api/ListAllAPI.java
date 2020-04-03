/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package api;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.UniformInterfaceException;
import com.sun.jersey.api.client.WebResource;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.*;
import org.json.XML;
import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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

    public String getJson_XML(){
        try{
            WebResource resource = webResource;

            String data = resource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).get(String.class);

            org.json.JSONArray jsonArr = new org.json.JSONArray(data);

            return XML.toString(jsonArr);
        
        }catch(Exception e){
           JSONObject obj = new JSONObject();
           obj.put("error", e.toString());
           return XML.toString(obj);         
        } 
    }

    public String getJson_JSON() {
        try{
             WebResource resource = webResource;
            return resource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).get(String.class);
        }catch(Exception e){
           JSONObject obj = new JSONObject();
           obj.put("error", e.toString());
           return String.valueOf(obj);
        }
    }

    public String getJson_TEXT() {
        try{
            WebResource resource = webResource;
           String data = resource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).get(String.class);

             String results = "";
             org.json.JSONArray jsonArr = new org.json.JSONArray(data);
             for (int i = 0; i < jsonArr.length(); i++) {
               JSONObject obj = jsonArr.getJSONObject(i);
               results += "Title: " + obj.getString("title") + "\nDescription: " + obj.getString("description") + "\nAuthor: " + obj.getString("author")
                       + "\nISBN: " + obj.getString("ISBN") + "\nPublisher: " + obj.getString("publisher") + "\n\n";
             }      
            return results;
        }catch(Exception e){
            return "error " +e.toString();    
        }
    }

    public String getJson_HTML() throws UniformInterfaceException {
      
        WebResource resource = webResource;
              
        String result="";
        String data =  resource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
        
         try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("html");
            document.appendChild(root);
            
            Element body = document.createElement("body");
            root.appendChild(body);
            
           
            
          org.json.JSONArray jsonArr = new org.json.JSONArray(data);
             for (int i = 0; i < jsonArr.length(); i++) {
               JSONObject obj = jsonArr.getJSONObject(i);
               
                Element div = document.createElement("div");
                root.appendChild(div);
                
                // author element
               Element author = document.createElement("author");
               author.appendChild(document.createTextNode(obj.get("author").toString()));
               div.appendChild(author);

               // isbn element
               Element isbn = document.createElement("isbn");
               isbn.appendChild(document.createTextNode(obj.get("ISBN").toString()));
               div.appendChild(isbn);

               // description element
               Element description = document.createElement("description");
               description.appendChild(document.createTextNode(obj.get("description").toString()));
               div.appendChild(description);

               // publisher element
               Element publisher = document.createElement("publisher");
               publisher.appendChild(document.createTextNode(obj.get("publisher").toString()));
               div.appendChild(publisher);

               Element title = document.createElement("title");
               title.appendChild(document.createTextNode(obj.get("title").toString()));
               div.appendChild(title);
            
            }
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("TrainBlahBlah2.xml"));
            
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
 
            transformer.transform(domSource, streamResult);
 
            
            TransformerFactory tFactory = TransformerFactory.newInstance();
 
            Source xslDoc = new StreamSource("/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/config/ChuChuList.xsl");

            Source xmlDoc = new StreamSource("/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/config/TrainBlahBlah2.xml");


            OutputStream htmlFile = new FileOutputStream("TrainBlahBlah2.html");

            Transformer trasform = tFactory.newTransformer(xslDoc);

            trasform.transform(xmlDoc, new StreamResult(htmlFile));
            
       
        System.out.println("Done creating XML File");
          
                
        File myObj = new File("TrainBlahBlah2.html");
        Scanner myReader = new Scanner(myObj);
           while (myReader.hasNextLine()) {
               String d = myReader.nextLine();
               System.out.println(data);
               result += d;
         }    
              
               //return resource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
        }
        catch(Exception e){
            return "error " +e.toString();    
        }
         return result;
    }

    public void close() {
        client.destroy();
    }
    
}
