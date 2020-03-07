/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookMVC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
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
    //public HashMap <Integer, Books> booksmap = new HashMap <Integer, Books>();
    public HashMap <Integer, Books> booksmap = null;
    
    
    public static synchronized BooksController getInstance(){
        if(booksContoller == null){
            booksContoller = new BooksController();
        }
        
        return booksContoller;
    }
    
    
    private BooksController(){
        this.dao = LibraryDAO.getInstance();
        this.booksmap = new HashMap <>();
    }
   
    public Books getBookByID(){
        Books book = null;
        
        try {
            ResultSet rs = dao.getBook();
            while(rs.next()){
             book = new Books(rs.getString("Title"),rs.getString("Description"),rs.getString("Author"),rs.getString("ISBN"),rs.getString("Publisher"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }
    
    
   public void getBookList(){
       this.booksmap.clear();
       try {
            ResultSet rs = dao.getAllBook();
            
            while(rs.next()){
                Books book = new Books(rs.getString("Title"),rs.getString("Description"),rs.getString("Author"),rs.getString("ISBN"),rs.getString("Publisher"));
                booksmap.put(rs.getInt("id"), book);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   
   public Books getBookById(int id){
            Books bk = null;
            try {
                ResultSet rs = dao.getbookById(id);
                while(rs.next()){
                bk = new Books(rs.getString("Title"),rs.getString("Description"),rs.getString("Author"),rs.getString("ISBN"),rs.getString("Publisher"));
                }
            } catch (SQLException ex) {
                Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
            }
            return bk;
   }    
   
   public boolean deleteBookById(int id){
        return dao.delete(id);
   }

}
