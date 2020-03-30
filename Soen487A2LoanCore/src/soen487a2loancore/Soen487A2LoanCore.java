/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soen487a2loancore;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import loanMVC.LoanController;
import loanMVC.Loans;

/**
 *
 * @author fokpoonkai
 */
public class Soen487A2LoanCore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException  {
        // TODO code application logic here
        
        LoanController lc = LoanController.getInstance();
        HashMap <String, String> map = new HashMap<>();
        
//       HashMap <Integer, Loans> map2 = new HashMap<>();
//       map2 = lc.listLoanByMemberID(2);
//       for(Integer i : map2.keySet()){
//           System.out.println(map2.get(i).getBookName());
//       }
//        
        
//        if(lc.loanBook(1, "aaa", "dddd", "dddd")){
//            System.out.println("True");
//        }else
//        {System.out.println("false");}
//        
//        
//
//      if(lc.deleteLoanBook(1)){
//          System.out.println("True");
//      }else{
//          System.out.println("false");
//      }
//       
//    int x = 1;
//    try{
//    if(lc.borrowBook(1)){
//        System.out.println("fff");}
//    }catch(Exception e){
//        System.out.println("fdfdsa");
//    }

//
//    HashMap <String, String> map = new HashMap<>();
//    map.put("BookName", "bbbb");
//    map.put("ReturnDate", "aaaaa");
//    
//    
//        try {
//            if(lc.updateLoan(1, map)){
//                System.out.print("ddd");
//            }else{
//                System.out.print("Eeee");
//            }
//        } catch (SQLException ex) {
//            Logger.getLogger(Soen487A2LoanCore.class.getName()).log(Level.SEVERE, null, ex);
//        }
    
    
    
    
    }
}
