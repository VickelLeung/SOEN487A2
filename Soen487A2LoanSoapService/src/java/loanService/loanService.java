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
     * Web service operation
     */
    @WebMethod(operationName = "getMember")
    public String getMember(@WebParam(name = "id") int id)  throws MySOAPFault{
        //TODO write your implementation code here:
            Members mb  = MemberMVC.MemberController.getInstance().getMember(id);
            String result = "no member";
            
            if (id == 0){
                throw new MySOAPFault("missing id");
            }
            
            if ( id < 0 ){
                throw new MySOAPFault("incorrect id");
                
            } else {
                if(mb!= null){
                result = mb.getName() +" "+ mb.getContact();
               }
            }
            return result;
    }

   /**
     * Web service operation
     */
    @WebMethod(operationName = "getMemberIdByName")
    public int getMemberIdByName(@WebParam(name = "name") String name) throws MySOAPFault {
        //TODO write your implementation code here:
        if (name==null || name.isEmpty()){
             throw new MySOAPFault(" missing Name");
        } else {
             return MemberMVC.MemberController.getInstance().getMemberIdByName(name);
         }        
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addMember")
    public String addMember(@WebParam(name = "name") String name, @WebParam(name = "contact") String contact, @WebParam(name = "password") String password) throws MySOAPFault {
        //TODO write your implementation code here:
        
        if (name==null || name.isEmpty()){
             throw new MySOAPFault(" missing Name");
        }
        
        if (contact==null || contact.isEmpty()){
             throw new MySOAPFault(" missing Contact");
        }
        
        if (password==null || password.isEmpty()){
             throw new MySOAPFault(" missing password");
        }
        
        if (name.isEmpty() || password.isEmpty()){
            throw new MySOAPFault("fail to add member: missing Name or Password");
        } else {
            String result = "fail to add member";
            Members mb = new Members(name,contact,password);
            if(MemberMVC.MemberController.getInstance().addMember(mb)){
                result = "success to add member";
            }
           return result;
        }
    }
    
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateMember")
    public String updateMember(@WebParam(name = "id") int id, @WebParam(name = "name") String name, @WebParam(name = "contact") String contact) throws MySOAPFault {
        //TODO write your implementation code here:
       String result = "fail to edit member";
       try{
            
            if (id == 0){
                throw new MySOAPFault("missing id");
            }
            
            if ( id < 0 ){
                throw new MySOAPFault("incorrect id");
            }    
            
            if  (name == null || name.isEmpty()){
                throw new MySOAPFault("missing Name");
            }
            if (contact == null  || name.isEmpty()) {
                throw new MySOAPFault("missing contact");
            }
            
            if (MemberMVC.MemberController.getInstance().updateMember(id, name, contact)) {
                result = "success to edit member";
            }
            
            return result;
        }
        catch (NumberFormatException e) { 
            return (id + " is not a valid integer number"); 
        }
        catch (Exception ex) {
            return ("Exception: " + ex);
        }   
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getListMember")
    public String getListMember() throws MySOAPFault {
           HashMap <Integer, Members> memberMap = null;
         memberMap = MemberMVC.MemberController.getInstance().getMemberList();
         String result = "";
         if(memberMap == null){
             throw new MySOAPFault("no member"); 
         }
         else{
             for(int id : memberMap.keySet()){
                 result = result + " "+ id + " "+ memberMap.get(id).getName() + " " + memberMap.get(id).getContact() +"\n";
             }
         }
        return result;
    }

    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteMember")
    public String deleteMember(@WebParam(name = "id") int id) throws MySOAPFault {
        String result = "";
        
        if (id <= 0){
            throw new MySOAPFault("fail to delete member: incorrect id"); 
            
        } else {
            if(MemberMVC.MemberController.getInstance().deleteMember(id)){
                result = "success to delete member";
            }
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
    public String getLoanListByBookName(@WebParam(name = "bookName") String bookName) throws MySOAPFault {
        //TODO write your implementation code here:\
        if(bookName.isEmpty()){
            throw new MySOAPFault("fail to BoonName: incorrect bookname"); 
        }
        else{
                    HashMap <Integer, Loans> loansMap = null;
                    String result = "No loanBook on the list";
                    try {
                        loansMap = loanMVC.LoanController.getInstance().getLoanListByName(bookName);
                    } catch (SQLException ex) {
                        Logger.getLogger(loanService.class.getName()).log(Level.SEVERE, null, ex);
                        result = "fail to get loan list by book name";
                    }

                    if(loansMap != null){
                        for(int i : loansMap.keySet()){
                            result = loansMap.get(i).getBookName() + " " + loansMap.get(i).getPersonBorrow() + " " +loansMap.get(i).getBorrowId()+ " " + loansMap.get(i).getDateOfBorrowing() + " " + loansMap.get(i).getReturnDate()+" "+loansMap.get(i).isIsReturn();
                        }
                    }
                    return result;
        }

}


    /**
     * Web service operation
     */
    @WebMethod(operationName = "getLoanDetailByID")
    public String getLoanDetailByID(@WebParam(name = "borrowBookId") int borrowBookId) throws MySOAPFault{
       if(borrowBookId <=0 ){
           throw new MySOAPFault("fail to borrowBookId: incorrect borrowBookId"); 
       }
       else{
                String result = "";
                try {
                    Loans ls = loanMVC.LoanController.getInstance().getLoanDetailByID(borrowBookId);
                    if(ls != null){
                        result = ls.getBookName() + " " + ls.getPersonBorrow() + " " + ls.getBorrowId()+ " " + ls.getDateOfBorrowing() + " " + ls.getReturnDate()+" "+ ls.isIsReturn();
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(loanService.class.getName()).log(Level.SEVERE, null, ex);
                    result = "fail to get loan list by ID";
                }
                if("".equals(result)){
                    result = "no book loan";
                }
                return result;
               }
    }

    

        /**
     * Web service operation
     */
    @WebMethod(operationName = "getLoanListByMemberID")
    public String getLoanListByMemberID(@WebParam(name = "memberID") int memberID)  throws MySOAPFault {
         if(memberID <=0 ){
             throw new MySOAPFault("fail to getLoanListByMemberID: incorrect getLoanListByMemberID"); 
         }
         else{
                 HashMap <Integer, Loans> loansMap = null;
                String result = "No loanBook on the list";
                try {
                    loansMap = loanMVC.LoanController.getInstance().listLoanByMemberID(memberID);
                } catch (SQLException ex) {
                    Logger.getLogger(loanService.class.getName()).log(Level.SEVERE, null, ex);
                    result = "fail to get loan list by MemberID";
                }

                if(loansMap != null){
                    result = "";
                    for(int i : loansMap.keySet()){
                        result = result + loansMap.get(i).getBookName() + " " + loansMap.get(i).getPersonBorrow() + " " +loansMap.get(i).getBorrowId()+ " " + loansMap.get(i).getDateOfBorrowing() + " " + loansMap.get(i).getReturnDate()+" "+loansMap.get(i).isIsReturn() +"\n";
                    }
                }
                return result;
         }
    }
    
    
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "CreateLoanBook")
    public String CreateLoanBook(@WebParam(name = "borrowID") int borrowID, @WebParam(name = "bookName") String bookName, @WebParam(name = "personBorrow") int personBorrow, @WebParam(name = "borrowDate") String borrowDate, @WebParam(name = "returnDate") String returnDate) throws MySOAPFault {
        
        if( bookName.isEmpty() || borrowID <=0 ){
                throw new MySOAPFault("incorrect id or book name"); 
        }
        else{                   
            String result = "failed to add the loanbook";
            if(loanMVC.LoanController.getInstance().loanBook(borrowID, bookName, personBorrow, borrowDate, returnDate)){
                result = "success to add the loanbook"; 
            }
            return result;
        }

    }


     /**
     * Web service operation
     */
    @WebMethod(operationName = "borrowBook")
    public String borrowBook(@WebParam(name = "Bookid") int Bookid) throws MySOAPFault {
        //TODO write your implementation code here:
       if( Bookid <=0 ){
                throw new MySOAPFault("incorrect id or book name"); 
        }else{
             String result = "init";
            try {
                if (loanMVC.LoanController.getInstance().isLoanBookExist(Bookid)
                        && loanMVC.LoanController.getInstance().showIsReturn(Bookid) == 1) {
                    if (loanMVC.LoanController.getInstance().borrowBook(Bookid)) {
                        result = "Success to borrow book";
                    }
                } else if (loanMVC.LoanController.getInstance().showIsReturn(Bookid) == 0) {
                    result = "Sorry. Your requested book is already borrowed by someone else. Please come back later!";
                } else {
                    result = "The requested book does not exist";
                }
            } catch (Exception e) {
                result = e.getMessage();
            }
            return result;
       }
    }
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "returnBook")
    public String returnBook(@WebParam(name = "bookID") int bookID) throws MySOAPFault {
       if( bookID <=0 ){
                throw new MySOAPFault("incorrect id or book name"); 
       }
       else
       {
                String result = "init";
                try {
                    if (loanMVC.LoanController.getInstance().isLoanBookExist(bookID)
                            && loanMVC.LoanController.getInstance().showIsReturn(bookID) == 0) {
                        if (loanMVC.LoanController.getInstance().returnBook(bookID)) {
                            result = "Success to return book";
                        }
                    } else if (loanMVC.LoanController.getInstance().showIsReturn(bookID) == 1) {
                        result = "This book has been previously returned. It is available to borrow now.";
                    } else {
                        result = "This book does not exist";
                    }
                } catch (Exception e) {
                }
                return result;

       }
    }

    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "updateLoan")
    public String updateLoan(@WebParam(name = "BookId") int BookId, @WebParam(name = "BookName") String BookName, @WebParam(name = "PersonBorrow") int PersonBorrow, @WebParam(name = "DateOfBorrowing") String DateOfBorrowing, @WebParam(name = "ReturnDate") String ReturnDate, @WebParam(name = "isReturn") int isReturn) throws MySOAPFault {
        
        if(BookId<=0){
             throw new MySOAPFault("incorrect id"); 
        }
        else{ 
            boolean flag = false;
            HashMap<String, String> map = new HashMap<>();
            if(!BookName.equals("")  || BookName !=null){
                map.put("BookName", BookName);
                flag = true;
            }
            if(PersonBorrow != 0){
                map.put("PersonBorrow", Integer.toString(PersonBorrow));
                flag = true;
            }
            if(!DateOfBorrowing.equals("")  || DateOfBorrowing !=null){
                map.put("DateOfBorrowing", DateOfBorrowing);
                flag = true;
            }
            if(!ReturnDate.equals("")  || ReturnDate !=null){
                map.put("ReturnDate", ReturnDate);
                flag = true;
            }
            if(isReturn>0 && isReturn <2){
                map.put("isReturn", Integer.toString(isReturn));
                flag = true;
            }
            String result = "False to update the loan records";
            if(flag){
                try {
                    if(loanMVC.LoanController.getInstance().isLoanBookExist(BookId)){
                        if(loanMVC.LoanController.getInstance().updateLoan(BookId, map)){
                            result = "Success to update the loan records";
                        }
                        else{}
                    }else{
                        result = "book does not exist in loan system";
                    }
                } catch (SQLException ex) {
                    Logger.getLogger(loanService.class.getName()).log(Level.SEVERE, null, ex);
                }
            }else
            {
                result = "no arguments";
            }
            return result;
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "deleteLoanBook")
    public String deleteLoanBook(@WebParam(name = "borrowBookId") int borrowBookId) throws MySOAPFault {
        if(borrowBookId<=0){
             throw new MySOAPFault("incorrect id"); 
        }else{
               String result = "fail delete loan book"; 
                if(loanMVC.LoanController.getInstance().deleteLoanBook(borrowBookId)){
                    result = "success delete loan book";
                }
                return result;
        }

    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "showIsReturn")
    public int showIsReturn(@WebParam(name = "borrowBookId") int borrowBookId) throws MySOAPFault {
        if(borrowBookId<=0){
             throw new MySOAPFault("incorrect id"); 
        }
        else{
             return loanMVC.LoanController.getInstance().showIsReturn(borrowBookId);
        }
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "login")
    public String login(@WebParam(name = "name") String name, @WebParam(name = "password") String password)  throws MySOAPFault {
        
        if(name.isEmpty()&&password.isEmpty()){
             throw new MySOAPFault("incorrect id"); 
        }
        else{
                    String result = "fail_to_login";
        try{
            boolean isLogin = MemberMVC.MemberController.getInstance().login(name, password);
            if(isLogin){
                result = "success_to_login";
            }     
        }catch(Exception e){
            result = e.getMessage();
        }     
            return result;   
        }

    }
}