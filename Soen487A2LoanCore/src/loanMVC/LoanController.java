/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanMVC;

import LoanDAO.LoanDAO;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author fokpoonkai
 */
public class LoanController {
    private static LoanController loanController = null;
    private LoanDAO dao = null;
    public HashMap <Integer, Loans> loadsmap = null;
     
        
    public static synchronized LoanController getInstance(){
        if(loanController == null){
            loanController = new LoanController();
        }
        
        return loanController;
    }
    
      private LoanController(){
        this.dao = LoanDAO.getInstance();
        this.loadsmap = new HashMap <>();
    }
    
    public ResultSet loanBook(int id){
    ResultSet rs = null;
    rs = this.dao.getLoanById(id);    
    return rs;
    }
      
    public boolean loanBook(int borrowId, String personBorrow, String dateOfBorrowing, String returnDate) {
        return this.dao.loanBook(borrowId, personBorrow, dateOfBorrowing, returnDate);
    }
  
   public boolean returnBook(int borrowId){
       return this.dao.returnBook(borrowId);
   }
   
   public boolean updateBook(int borrowId, String data){
       return this.dao.update(borrowId, data);
   }
    
   public void getLoanList() throws SQLException{
        ResultSet rs = dao.getLoanList();
        while(rs.next()){
            Loans ls = new Loans(rs.getInt("BorrowId"),rs.getString("PersonBorrow"),rs.getString("DateOfBorrowing"),rs.getString("ReturnDate"),rs.getInt("IsReturn"));
        
        
        
        }
        
   }
   
}
