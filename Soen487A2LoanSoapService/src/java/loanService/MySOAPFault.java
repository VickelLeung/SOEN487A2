/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loanService;

import javax.xml.ws.WebFault;

/**
 *
 * @author TOMMY
 */

@WebFault(name="MySOAPFault", targetNamespace="http://loanservice/")
public class MySOAPFault extends Exception{
   
    public MySOAPFault(String message){
        super(message);
    }
   
    public MySOAPFault(String message, Throwable cause){
        super(message, cause);
    }

    
}