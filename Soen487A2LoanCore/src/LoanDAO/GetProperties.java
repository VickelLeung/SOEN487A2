/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanDAO;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author fokpoonkai
 */
public class GetProperties {
    String result = "";
	InputStream inputStream;
 
        
        public GetProperties(){}
        
        
            public static void set(){
                   try (OutputStream output = new FileOutputStream("./resouce/111.properties")) {

                        Properties prop = new Properties();

                        // set the properties value
                        prop.setProperty("db.url", "localhost");
                        prop.setProperty("db.user", "mkyong");
                        prop.setProperty("db.password", "password");

                        // save properties to project root folder
                        prop.store(output, null);

                        System.out.println(prop);

                    } catch (IOException io) {
                        io.printStackTrace();
                    }

            }
        
public static String getDBURL(){
   String result = "noResult";
   try (InputStream input = new FileInputStream("config.properties")) {
           
            Properties prop = new Properties();

            // load a properties file
            prop.load(input); 
//            // get the property value and print it out
//            System.out.println(prop.getProperty("db.url"));
//            System.out.println(prop.getProperty("db.user"));
//            System.out.println(prop.getProperty("db.password"));
        result = prop.getProperty("db.url");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
   return result;
}
        

public static String getDBUser(){
   String result = "noResult";
   try (InputStream input = new FileInputStream("config.properties")) {
           
            Properties prop = new Properties();

            // load a properties file
            prop.load(input); 
//            // get the property value and print it out
//            System.out.println(prop.getProperty("db.url"));
//            System.out.println(prop.getProperty("db.user"));
//            System.out.println(prop.getProperty("db.password"));
        result = prop.getProperty("db.user");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
   return result;
}

public static String getDBPassword(){
   String result = "noResult";
   try (InputStream input = new FileInputStream("config.properties")) {
           
            Properties prop = new Properties();

            // load a properties file
            prop.load(input); 
//            // get the property value and print it out
//            System.out.println(prop.getProperty("db.url"));
//            System.out.println(prop.getProperty("db.user"));
//            System.out.println(prop.getProperty("db.password"));
        result = prop.getProperty("db.password");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
            
   return result;
}
        
}