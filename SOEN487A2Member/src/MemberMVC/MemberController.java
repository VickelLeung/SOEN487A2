package MemberMVC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import MemberDAO.MemberDAO;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author vickelleung
 */
public class MemberController {
    private static MemberController memberController = null;
    private MemberDAO dao = null;
    //public HashMap <Integer, Books> booksmap = new HashMap <Integer, Books>();
    public HashMap <Integer, Members> memberMap = null;
    
    public static synchronized MemberController getInstance(){
        if(memberController == null){
            memberController = new MemberController();
        }
        
        return memberController;
    }
    
    
    private MemberController(){
        this.dao = MemberDAO.getInstance();
        this.memberMap = new HashMap <>();
    }
   
    public Members getMember(int id){
       Members mem = null;
        
        try {
            ResultSet rs = dao.getMemberInfo(id);
            while(rs.next()){
             mem = new Members(rs.getInt("id"),rs.getString("name"),rs.getString("contact"),rs.getString("password"));
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mem; 
    }
    
   public HashMap getMemberList(){
       this.memberMap.clear();
       try {
            ResultSet rs = dao.getListMembers();
            
            while(rs.next()){
                Members mem = new Members(rs.getInt("id"),rs.getString("name"),rs.getString("contact"),rs.getString("password"));
                memberMap.put(rs.getInt("id"), mem);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(MemberController.class.getName()).log(Level.SEVERE, null, ex);
        }
       return memberMap;
    }
   
   public boolean login(String name, String password){
       return dao.login(name, password);
   }

    public boolean addMember(Members m){
       return dao.addMember(m.getName(), m.getContact(),m.getPassword());
       //return dao.addBookToSQL(m.getTitle(), m.getDescription(), m.getAuthor(), m.getISBN(), m.getPublisher());
    }
   
   
   public boolean updateMember(int id,String name, String contact){ 
       return dao.updateMember(id, name, contact);
   }
   
   public boolean deleteMember(int id){
        return dao.deleteMember(id);
   }
   
   public int getMemberIdByName(String name){
       return dao.getMemberIdByName(name);
   }

}



