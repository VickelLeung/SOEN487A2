/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookMVC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import libraryDAO.LibraryDAO;

/**
 *
 * @author fokpoonkai
 */
public class BooksController {
    private static BooksController booksContoller = null;
    private LibraryDAO dao = null;
    
    public static synchronized BooksController getInstance(){
        if(booksContoller == null){
            booksContoller = new BooksController();
        }
        
        return booksContoller;
    }
    
    
    private BooksController(){
        this.dao = LibraryDAO.getInstance();
    }
   
    public Books getBookByID(){
        Books book = null;
        
        try {
            ResultSet rs = dao.getBook();
            while(rs.next()){
             book = new Books(rs.getString("Title"),rs.getString("Description"),rs.getString("Author"),rs.getString("ISBN"),rs.getString("Publisher"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }
    
    
}
