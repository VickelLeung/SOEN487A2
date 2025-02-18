/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryDAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fokpoonkai
 */
public class LibraryDAO {
    
 
    private static LibraryDAO dao = null;
    public Connection con = null;
    public ResultSet rs = null;
    
    
    public static synchronized LibraryDAO getInstance(){
        if(dao == null){
            dao = new LibraryDAO();
            
        }
        return dao;
    }
    
    private LibraryDAO()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            GetProperties properties = new GetProperties();
            con =  DriverManager.getConnection( "jdbc:mysql://den1.mysql1.gear.host/soen487a2", "soen487a2", "Bo4hZ0KtZ?~0" );
            //con =  DriverManager.getConnection( GetProperties.getDBURL(), GetProperties.getDBUser(), GetProperties.getDBPassword());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
        
    public ResultSet getAllBook() throws SQLException
    {
     
      
            String query = "SELECT * From books";
            Statement stmt = con.createStatement();
           
            rs = stmt.executeQuery(query);
            return rs; 
   }
    
    /*
    haven't check it yet
    
    */
    public void editBook(HashMap<String,String> map, int tmp_static_num_2) throws SQLException
    {
            String query = "UPDATE books Set ";
          int index = 0;

          for(String key: map.keySet())
          {   
              index ++;
              if(index == 1)
              {
              String x = key +" = \'"+ map.get(key)+"\'";
              query = query + x;                
              }
              else
              {
                  String x = key +" = \'"+ map.get(key)+"\'";
                  query = query +", "+ x;      
              }
           }
          query = query + "WHERE id ="+tmp_static_num_2+";";
          Statement stmt = con.createStatement();
          stmt.executeUpdate(query);
    }
    
    public ResultSet getbookByTitle(String title){
           ResultSet rs = null;
           String query = "Select * From books where title = ?";
        try {
           
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, title);
            rs = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
     }
    
     public ResultSet getbookById(int id){
           ResultSet rs = null;
           String query = "Select * From books where id = ?";
        try {
           
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
     }
     
    public boolean delete(int id)
    {  
        boolean ret = false;
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("DELETE from books where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            ret = true;
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    
    /*
        public String title;
    public String description;
    public String author;
    public String ISBN;
    public String Publisher;
    */
     public boolean addBook(String title, String description, String author, String ISBN, String Publisher ){
       
         boolean ret = false;
         PreparedStatement preparedStatement = null;
         try {
            
            preparedStatement = con
                    .prepareStatement("INSERT into books (title, description, author, ISBN, Publisher) values (?,?,?,?,?)");  
            preparedStatement.setString(1, title);
            preparedStatement.setString(2, description);
            preparedStatement.setString(3, author);
            preparedStatement.setString(4, ISBN);
            preparedStatement.setString(5, Publisher);
            preparedStatement.executeUpdate();
            ret = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return ret;
     }
     
      public boolean updateBook(int id, String title, String description, String author, String ISBN, String Publisher) throws SQLException{
        HashMap <String, String> map = new HashMap<>();
        boolean ret = false;
        
        if(!title.equals("")){
             map.put("title", title);
         }
        if(!description.equals("")){
            map.put("description",description);
        }
        if(!author.equals("")){
            map.put("author", author);
        }
        if(!ISBN.equals("")){
            map.put("ISBN", ISBN);
        }
        if(!Publisher.equals("")){
            map.put("Publisher",Publisher);
        }
         
        if(!map.isEmpty()){
         String query = "UPDATE books Set ";
         int index = 0;
         for(String key : map.keySet()){
            index ++;
            if(index == 1){
                  String x = key +" = \'"+ map.get(key)+"\'";
                  query = query + x;
            }
            else {
                String x = key +" = \'"+ map.get(key)+"\'";
                query = query +", "+ x;      
            }
         }
                query = query + "WHERE id ="+id+";";
                
              System.out.println(query);
               Statement stmt = con.createStatement();
               stmt.executeUpdate(query);
               ret = true;
        }
      return ret;
     }

}
