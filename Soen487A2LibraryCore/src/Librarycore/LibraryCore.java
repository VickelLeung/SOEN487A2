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
        BooksController bc = BooksController.getInstance();
//        Books book = bc.getBookByID();
//        System.out.println(book.title);
//        Books book = bc.getBookById(1);
//         System.out.println(book.title);
//    Books book = new Books("pi","apple","jo","da","lo");
//    if(bc.addBook(book)){
//        System.out.println("[Sccess] AddBook");
//    }
//    else{
//    System.out.println("[Failed] AddBook");
//    }
//        System.out.println(bc.getBookById(0));
        
    }
    
}
