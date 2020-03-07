/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soen487a2librarycore;

import java.sql.ResultSet;
import java.sql.SQLException;



/**
 *
 * @author fokpoonkai
 */
public class Soen487A2LibraryCore {
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        ResultSet rs = LibraryDAO.getInstance().getBook();
        String title = "";
        while(rs.next()){
           title =  rs.getString("title");
        }
        
        System.out.print(title);
        
        
        
    }
    
}
