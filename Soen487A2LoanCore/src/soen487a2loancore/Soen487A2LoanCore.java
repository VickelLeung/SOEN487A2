/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soen487a2loancore;

import java.sql.SQLException;
import loanMVC.LoanController;

/**
 *
 * @author fokpoonkai
 */
public class Soen487A2LoanCore {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)  {
        // TODO code application logic here
        
        LoanController lc = LoanController.getInstance();
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
    int x = 1;
    try{
    if(lc.borrowBook(1)){
        System.out.println("fff");}
    }catch(Exception e){
        System.out.println("fdfdsa");
    }
    
    }
}
