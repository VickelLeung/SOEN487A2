/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Librarycore;

import bookMVC.Books;
import bookMVC.BooksController;
import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author fokpoonkai
 */
public class LibraryCore {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
//        ResultSet rs = LibraryDAO.getInstance().getBook();
//        String title = "";
//        while(rs.next()){
//           title =  rs.getString("title");
//        }
//        
//        System.out.print(title);
        BooksController bc = BooksController.getInstance();
        Books book = bc.getBookByID();
        System.out.println(book.title);
        
        
    }
    
}
