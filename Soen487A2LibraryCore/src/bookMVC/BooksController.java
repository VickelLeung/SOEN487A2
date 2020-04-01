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
            ResultSet rs = dao.getAllBook();
            while(rs.next()){
             book = new Books(rs.getString("Title"),rs.getString("Description"),rs.getString("Author"),rs.getString("ISBN"),rs.getString("Publisher"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return book;
    }
    
    
   public HashMap<Integer, Books> getBookList(){
//       String results = "";
       this.booksmap.clear();
       try {
            ResultSet rs = dao.getAllBook();
            
            while(rs.next()){
                Books book = new Books(rs.getInt("id"),rs.getString("Title"),rs.getString("Description"),rs.getString("Author"),rs.getString("ISBN"),rs.getString("Publisher"));
                booksmap.put(rs.getInt("id"), book);
//                results += book.toString();
            }
            rs.close();
             
            
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
       return booksmap;
    }
   
   public int getBookByTitle(String title) throws ClassNotFoundException{
       int id = 0;
        
      
      
        try {
                 ResultSet rs = dao.getbookByTitle(title);
                if(rs == null){
                    id = -1;
                }
                else{
                    //id = Integer.parseInt(rs.getString("id"));
                    while(rs.next()){
                    id = Integer.parseInt(rs.getString("id"));
                    }
                }
        } catch (SQLException ex) {
            Logger.getLogger(BooksController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       System.out.println("id: "+id);
       
       return id;
   }
   
   public Books getBookById(int id) throws ClassNotFoundException{
        
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
   
   
   public boolean addBook(Books book){
       return dao.addBook(book.getTitle(), book.getDescription(), book.getAuthor(), book.getISBN(), book.getPublisher());
    }
   
   public boolean deleteBookById(int id){
        
        return dao.delete(id);
   }
   
   public boolean updateBookById(int id, String title, String description, String author, String ISBN, String Publisher ) throws SQLException{
       
        return dao.updateBook(id, title, description, author, ISBN, Publisher);
   }

}
