/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LoanDAO;

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
public class LoanDAO {
    private static LoanDAO dao = null;
    public Connection con = null;
    
    public static synchronized LoanDAO getInstance(){
        if(dao == null){
            dao = new LoanDAO();
        }
        return dao;
    }
  
    public LoanDAO(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.con =  DriverManager.getConnection( "jdbc:mysql://den1.mysql1.gear.host/soen487a2", "soen487a2", "Bo4hZ0KtZ?~0" );
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    public ResultSet getLoanById(int id){
           ResultSet rs = null;
           String query = "Select * From loans where BorrowId = ?";
            try {
                  PreparedStatement preparedStatement = con.prepareStatement(query);
                  preparedStatement.setInt(1, id);
                  rs = preparedStatement.executeQuery();
              } catch (SQLException ex) {
                  Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
              }
            return rs;
    }
    
    
    public ResultSet getLoanByName(String name){
       ResultSet rs = null;
       String query = "Select * From loans where BookName = ?";
        try {
              PreparedStatement preparedStatement = con.prepareStatement(query);
              preparedStatement.setString(1, name);
              rs = preparedStatement.executeQuery();
          } catch (SQLException ex) {
              Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
          }
        return rs;
    }

    
    public boolean loanBook(int borrowId,String bookname, int personBorrow, String dateOfBorrowing, String returnDate){
          boolean ret = false;
             try {         
                  PreparedStatement preparedStatement = con
                            .prepareStatement("insert into loans (BorrowId, BookName, PersonBorrow, DateOfBorrowing, ReturnDate, IsReturn) values (?,?,?,?,?,?)");  
                    preparedStatement.setInt(1, borrowId);
                    preparedStatement.setString(2, bookname);
                    preparedStatement.setInt(3, personBorrow);
                    preparedStatement.setString(4, dateOfBorrowing);
                    preparedStatement.setString(5, returnDate);
                    preparedStatement.setInt(6, 1);
                    preparedStatement.executeUpdate();
                    ret = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          return ret;
    }

      public boolean update(int borrowId, String data){
          boolean ret = false;
              PreparedStatement preparedStatement = null;
             try {         
                    preparedStatement = con
                            .prepareStatement("update loans set ReturnDate = ? where BorrowId = ?");  
                    preparedStatement.setString(1, data);
                    preparedStatement.setInt(2, borrowId);
                    preparedStatement.executeUpdate();
                    ret = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          return ret;
    }
        
    public boolean delete(int id)
    {  
        boolean ret = false;
        try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("delete from loans where BorrowId = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            ret = true;
        } catch (SQLException ex) {
            Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public ResultSet getLoanList(){
       
        ResultSet rs = null;
        try {
            
            
            String query = "SELECT * From loans";
            Statement stmt = con.createStatement();
           
            rs = stmt.executeQuery(query);
           
        } catch (SQLException ex) {
            Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
     return rs;
    
    }
    
     public boolean borrowBook(int id) {
 
        boolean ret = false;
        //String query = "UPDATE loans SET IsReturn='0' WHERE BorrowId="+id+";";
            
         try {
            PreparedStatement preparedStatement = con
                    .prepareStatement("UPDATE loans SET IsReturn=0 WHERE BorrowId= ?");
            preparedStatement.setInt(1, id);
            
      
            preparedStatement.executeUpdate();
            ret = true;
           
        } catch (SQLException ex) {
            Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         return ret;
     }
     
     
         
        public boolean returnBook(int borrowId){
          boolean ret = false;
              PreparedStatement preparedStatement = null;

             try {         
                    preparedStatement = con
                            .prepareStatement("update loans set IsReturn = 1 where BorrowId = ?");  
                    preparedStatement.setInt(1, borrowId);
                    preparedStatement.executeUpdate();
                    ret = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(LoanDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
          return ret;
    }
    
    
    
     
     
}
