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
//


import java.io.File;
import java.io.FileNotFoundException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


import java.io.FileOutputStream;
 
import java.io.OutputStream;
 
import javax.xml.transform.Source;
 
import javax.xml.transform.Transformer;
 
import javax.xml.transform.TransformerFactory;
 
import javax.xml.transform.stream.StreamResult;
 
import javax.xml.transform.stream.StreamSource;

import java.io.FileOutputStream;
 
import java.io.OutputStream;
import java.util.Scanner;
 
import javax.xml.transform.Source;
 
import javax.xml.transform.Transformer;
 
import javax.xml.transform.TransformerFactory;
 
import javax.xml.transform.stream.StreamResult;
 
import javax.xml.transform.stream.StreamSource;

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

             String plainText = "<h3>TITLE</h3> "+obj.get("title")+"<br/><h3>Description</h3> " + obj.get("description") + "<br/><h3>Author:</h3> " + obj.get("author") + "<br/><h3>isbn:</h3>" 
                     + obj.get("isbn") + "<br/><h3>Publisher</h3>" + obj.get("publisher");

            return plainText;
        }
        catch(Exception e){
            return "error " +e.toString();    
        }
        
    }
    
    public String getBook_HTML(String id) throws UniformInterfaceException, FileNotFoundException {
        WebResource resource = webResource;
        if (id != null) {
            resource = resource.queryParam("id", id);
        }
        String result="";
        String data =  resource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).get(String.class);
         JSONObject obj = new JSONObject(data);
         try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("html");
            document.appendChild(root);
            
            Element body = document.createElement("body");
            root.appendChild(body);
            
        
             // author element
            Element author = document.createElement("author");
            author.appendChild(document.createTextNode(obj.get("author").toString()));
            body.appendChild(author);
            
            // isbn element
            Element isbn = document.createElement("isbn");
            isbn.appendChild(document.createTextNode(obj.get("isbn").toString()));
            body.appendChild(isbn);
            
            // description element
            Element description = document.createElement("description");
            description.appendChild(document.createTextNode(obj.get("description").toString()));
            body.appendChild(description);
            
            // publisher element
            Element publisher = document.createElement("publisher");
            publisher.appendChild(document.createTextNode(obj.get("publisher").toString()));
            body.appendChild(publisher);
            
            Element title = document.createElement("title");
            title.appendChild(document.createTextNode(obj.get("title").toString()));
            body.appendChild(title);
            
            
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("TrainBlahBlah.xml"));
            
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
 
            transformer.transform(domSource, streamResult);
 
            TransformerFactory tFactory = TransformerFactory.newInstance();
 
            Source xslDoc = new StreamSource("/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/config/ChuChu.xsl");

            Source xmlDoc = new StreamSource("/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/config/TrainBlahBlah.xml");

            OutputStream htmlFile = new FileOutputStream("TrainBlahBlah.html");

            Transformer trasform = tFactory.newTransformer(xslDoc);

            trasform.transform(xmlDoc, new StreamResult(htmlFile));
            
       
        System.out.println("Done creating XML File");
          
                
        File myObj = new File("TrainBlahBlah.html");
        Scanner myReader = new Scanner(myObj);
           while (myReader.hasNextLine()) {
               String d = myReader.nextLine();
               System.out.println(data);
               result += d;
         }        
            
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
        }
         
        return result;
     
    }

    public void close() {
        client.destroy();
    }
    
}
