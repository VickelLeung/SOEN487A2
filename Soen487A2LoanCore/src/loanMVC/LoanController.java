/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanMVC;

import LoanDAO.GetProperties;
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
       
    public boolean isLoanBookExist(int id) throws SQLException{
    ResultSet rs = null;
    boolean flag = false;
    rs = this.dao.getLoanById(id);    
    while(rs.next()){
        flag = true;
    }  
    return flag;
    }
    
    public Loans getLoanDetailByID(int borrowId) throws SQLException{
        Loans loan = null;
        ResultSet rs = this.dao.getLoanDetailByID(borrowId);
        while(rs.next()){
            loan = new Loans(rs.getInt("BorrowId"),rs.getString("BookName"),rs.getInt("PersonBorrow"),rs.getString("DateOfBorrowing"),rs.getString("ReturnDate"),rs.getInt("IsReturn"));
        }
        return loan;
    }


//    public String test(){
//        return GetProperties.getDBURL();
//    }
//    
//      public void test2(){
//         GetProperties.set();
//    }
//    
    
    
    public boolean loanBook(int borrowId, String bookname, int personBorrow, String dateOfBorrowing, String returnDate) {
        return this.dao.loanBook(borrowId, bookname ,personBorrow, dateOfBorrowing, returnDate);
    }
  
    

   
   public boolean updateBook(int borrowId, String data){
       return this.dao.update(borrowId, data);
   }
    
   public HashMap <Integer, Loans> getLoanList() throws SQLException{
       this.loadsmap.clear();
       ResultSet rs = dao.getLoanList();
        while(rs.next()){
            Loans ls = new Loans(rs.getInt("BorrowId"),rs.getString("BookName"),rs.getInt("PersonBorrow"),rs.getString("DateOfBorrowing"),rs.getString("ReturnDate"),rs.getInt("IsReturn"));
            this.loadsmap.put(rs.getInt("BorrowId"), ls);
        } 
        return this.loadsmap;
   }
   
      public HashMap <Integer, Loans> getLoanListByName(String name ) throws SQLException{
         this.loadsmap.clear();
        ResultSet rs = dao.getLoanByName(name);
        while(rs.next()){
            Loans ls = new Loans(rs.getInt("BorrowId"),rs.getString("BookName"),rs.getInt("PersonBorrow"),rs.getString("DateOfBorrowing"),rs.getString("ReturnDate"),rs.getInt("IsReturn"));
            this.loadsmap.put(rs.getInt("BorrowId"), ls);
        }
        return this.loadsmap;
        
   }
      
    public HashMap <Integer, Loans> listLoanByMemberID(int memberID) throws SQLException{
       this.loadsmap.clear();
        ResultSet rs = dao.listLoanByMemberID(memberID);
                while(rs.next()){
            Loans ls = new Loans(rs.getInt("BorrowId"),rs.getString("BookName"),rs.getInt("PersonBorrow"),rs.getString("DateOfBorrowing"),rs.getString("ReturnDate"),rs.getInt("IsReturn"));
            this.loadsmap.put(rs.getInt("BorrowId"), ls);
        }
     return this.loadsmap;
   } 
   
      
   public boolean borrowBook(int id){
       return dao.borrowBook(id);
   }
   
   
     
   public boolean returnBook(int borrowId){
       return this.dao.returnBook(borrowId);
   }
      
   public boolean deleteLoanBook(int id){
       return this.dao.delete(id);
   }
   
   public boolean updateLoan(int id , HashMap<String, String> map) throws SQLException{
       return this.dao.updateBook(id, map);
   
   }
    
   public int showIsReturn(int id){
       return this.dao.showIsReturn(id);
   }
}
