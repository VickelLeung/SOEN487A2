/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package libraryDAO;
import java.sql.Connection;
import java.sql.DriverManager;
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
        
        
        
        
        
        
}
