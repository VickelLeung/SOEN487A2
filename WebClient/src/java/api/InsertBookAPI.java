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
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import org.json.JSONObject;
import org.json.XML;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
    public String addBook_JSON_TEXT(Object requestEntity) {
        try{
            String data =  webResource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);
            JSONObject obj = new JSONObject(data);
            String plainText = obj.get("message")+"";
            return plainText;
        }
        catch(Exception e){
            return "error " +e.toString();    
        }
        
    }
    
    public String addBook_JSON_JSON(Object requestEntity) {
        try{
         return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);
        }
        catch(Exception e){
           JSONObject obj = new JSONObject();
           obj.put("error", e.toString());
           return String.valueOf(obj);
        }   
    }
    
   public String addBook_JSON_HTML(Object requestEntity)  {
       String result="";
        String data =  webResource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);

         JSONObject obj = new JSONObject(data);
         try {
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
 
            Document document = documentBuilder.newDocument();

            Element root = document.createElement("html");
            document.appendChild(root);
            
            Element body = document.createElement("body");
            root.appendChild(body);         
        
             // message element
            Element message = document.createElement("message");
            message.appendChild(document.createTextNode(obj.get("message").toString()));
            body.appendChild(message);
            
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            StreamResult streamResult = new StreamResult(new File("TrainBlahBlah3.xml"));
            
            // If you use
            // StreamResult result = new StreamResult(System.out);
            // the output will be pushed to the standard output ...
            // You can use that for debugging 
 
            transformer.transform(domSource, streamResult);
 
            
            TransformerFactory tFactory = TransformerFactory.newInstance();
 
            Source xslDoc = new StreamSource("/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/config/ChuChuMsg.xsl");

            Source xmlDoc = new StreamSource("/Applications/NetBeans/glassfish-4.1.1/glassfish/domains/domain1/config/TrainBlahBlah3.xml");


            OutputStream htmlFile = new FileOutputStream("TrainBlahBlah3.html");

            Transformer trasform = tFactory.newTransformer(xslDoc);

            trasform.transform(xmlDoc, new StreamResult(htmlFile));       
       
        System.out.println("Done creating XML File");
          
                
        File myObj = new File("TrainBlahBlah3.html");
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
   
    public String addBook_JSON_XML(Object requestEntity) {
        try{
            String data = webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).type(javax.ws.rs.core.MediaType.APPLICATION_JSON).post(String.class, requestEntity);
            org.json.JSONObject obj = new org.json.JSONObject(data);
            String xml = XML.toString(obj);
            return xml;
        }
        catch(Exception e){
           JSONObject obj = new JSONObject();
           obj.put("error", e.toString());
           return XML.toString(obj);         
        } 
    }
    
    
    
    /////////
    
    
    public String addBook_TEXT_TEXT(Object requestEntity) {
        try{
            String data = webResource.accept(javax.ws.rs.core.MediaType.TEXT_PLAIN).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(String.class, requestEntity);
            JSONObject obj = new JSONObject(data);
            String plainText = obj.get("message")+"";
            return plainText;
        }
        catch(Exception e){
            return "error " +e.toString();    
        }

    }

        
    public String addBook_TEXT_JSON(Object requestEntity) {
        try{
           return webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_JSON).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(String.class, requestEntity);
        }
        catch(Exception e){
           JSONObject obj = new JSONObject();
           obj.put("error", e.toString());
           return String.valueOf(obj);
        }
    }
    
        
    public String addBook_TEXT_HTML(Object requestEntity) {
        try{
            return webResource.accept(javax.ws.rs.core.MediaType.TEXT_HTML).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(String.class, requestEntity);
        }
       catch(Exception e){
            return "error " +e.toString();    
        }
    }
       
    public String addBook_TEXT_XML(Object requestEntity) {
        try{
            String data =  webResource.accept(javax.ws.rs.core.MediaType.APPLICATION_XML).type(javax.ws.rs.core.MediaType.TEXT_PLAIN).post(String.class, requestEntity);
            org.json.JSONObject obj = new org.json.JSONObject(data);
            String xml = XML.toString(obj);
            return xml;
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
