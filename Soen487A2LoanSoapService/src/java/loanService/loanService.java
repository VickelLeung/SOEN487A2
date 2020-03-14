/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanService;

import MemberMVC.Members;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import loanMVC.Loans;

/**
 *
 * @author fokpoonkai
 */
@WebService(serviceName = "loanService")
public class loanService {
    
    /**
     
     member
     */
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getMember")
    public String getMember(@WebParam(name = "id") int id) {
        //TODO write your implementation code here:
         Members mb  = MemberMVC.MemberController.getInstance().getMember(id);
         String result = "no member";
         if(mb!= null){
             result = mb.getName() +" "+ mb.getContact();
         }
         return result;
    }


    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMember")
    public String addMember(@WebParam(name = "name") String name, @WebParam(name = "contact") String contact) {
        //TODO write your implementation code here:
        String result = "fail to add member";
        Members mb = new Members(name,contact);
        if(MemberMVC.MemberController.getInstance().addMember(mb)){
            result = "success to add member";
        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "edit")
    public String edit(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "contact") String contact) {
        //TODO write your implementation code here:
       String result = "fail to edit member";
       if(name == null){
           name = "";
       }
       if(contact == null){
           contact = ""; 
       }
       
       if(MemberMVC.MemberController.getInstance().updateMember(id, name, contact)){
           result = "success to edit member";
       };
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getListMember")
    public String getListMember() {
         HashMap <Integer, Members> memberMap = null;
         memberMap = MemberMVC.MemberController.getInstance().getMemberList();
         String result = "";
         if(memberMap == null){
             result = "No member";
         }
         else{
             for(int id : memberMap.keySet()){
                 result = result + " "+ id + " "+ memberMap.get(id).getName() + " " + memberMap.get(id).getContact() +"\n";
             }
         }

//TODO write your implementation code here:
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteMember")
    public String deleteMember(@WebParam(name = "id") int id) {
       //TODO write your implementation code here:
       String result = "fail to delete member";
        if(MemberMVC.MemberController.getInstance().deleteMember(id)){
            result = "success to delete member";
        }
        return result;
    }

    

    
   /**
    loan book
    
    */
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLoanListByBookName")
    public String getLoanListByBookName(@WebParam(name = "bookName") String bookName) {
        //TODO write your implementation code here:\
        HashMap <Integer, Loans> loansMap = null;
        String result = "No loanBook on the list";
        try {
            loansMap = loanMVC.LoanController.getInstance().getLoanListByName(bookName);
        } catch (SQLException ex) {
            Logger.getLogger(loanService.class.getName()).log(Level.SEVERE, null, ex);
            result = "fail to get loan list by book name";
        }
        
        if(loansMap != null){
            result = "";
            for(int i : loansMap.keySet()){
                result = result + " " + loansMap.get(i).getBookName() + " " + loansMap.get(i).getPersonBorrow() + " " +loansMap.get(i).getBorrowId()+  loansMap.get(i).getDateOfBorrowing() + " " + loansMap.get(i).getReturnDate()+" "+loansMap.get(i).isIsReturn();
            }
        }
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "CreateLoanBook")
    public String CreateLoanBook(@WebParam(name = "borrowID") int borrowID, @WebParam(name = "bookName") String bookName, @WebParam(name = "personBorrow") int personBorrow, @WebParam(name = "borrowDate") String borrowDate, @WebParam(name = "returnDate") String returnDate) {
        //TODO write your implementation code here:
        
        
        
        String result = "failed to add the loanbook";
        
 
        
        if(loanMVC.LoanController.getInstance().loanBook(borrowID, bookName, personBorrow, borrowDate, returnDate)){
            result = "sccessful to add the loanbook"; 
        }
        
        
        
        return result;
    }
    
    
   
    
    
}
