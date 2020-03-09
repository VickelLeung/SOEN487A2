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
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author fokpoonkai
 */
public class LibraryDAO {
    
 
    private static LibraryDAO dao = null;
    public Connection con = null;
    
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
            this.con =  DriverManager.getConnection( "jdbc:mysql://den1.mysql1.gear.host/soen487a2", "soen487a2", "Bo4hZ0KtZ?~0" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LibraryDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public ResultSet getBook() throws SQLException
    {
        ResultSet rs = null;
      
            String query = "SELECT * From books";
            Statement stmt = con.createStatement();
           
            rs = stmt.executeQuery(query);
            return rs;
    }
        
        
    public ResultSet getAllBook() throws SQLException
    {
        ResultSet rs = null;
      
            String query = "SELECT * From books";
            Statement stmt = con.createStatement();
           
            rs = stmt.executeQuery(query);
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
                    .prepareStatement("delete from book where id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
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
     public boolean addBookToSQL(String title, String description, String author, String ISBN, String Publisher ){
       
         boolean ret = false;
         PreparedStatement preparedStatement = null;
         try {
            
            preparedStatement = con
                    .prepareStatement("insert into books (title, description, author, ISBN, Publisher) values (?,?,?,?,?)");  
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

}
