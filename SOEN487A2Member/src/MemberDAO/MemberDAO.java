/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberDAO;

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
 * @author vickelleung
 */
public class MemberDAO {
   
    private static MemberDAO dao = null;
    public Connection con = null;
    
    public static synchronized MemberDAO getInstance(){
        if(dao == null){
            dao = new MemberDAO();
        }
        return dao;
    }
    
    private MemberDAO()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            GetProperties properties = new GetProperties();
            this.con =  DriverManager.getConnection( "jdbc:mysql://den1.mysql1.gear.host/soen487a2", "soen487a2", "Bo4hZ0KtZ?~0" );
            //con =  DriverManager.getConnection( GetProperties.getDBURL(), GetProperties.getDBUser(), GetProperties.getDBPassword());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
     public ResultSet getListMembers() throws SQLException
    {
        ResultSet rs = null;
      
            String query = "SELECT * From members";
            Statement stmt = con.createStatement();
           
            rs = stmt.executeQuery(query);
            return rs;
    }
       
    
    public ResultSet getMemberInfo(int id) throws SQLException
    {
        ResultSet rs = null;
        String query = "SELECT * From members where id = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, id);
            rs = preparedStatement.executeQuery();
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }


     public boolean addMember(String name, String contact, String password){
         boolean ret = false;
         PreparedStatement preparedStatement = null;
         try {
            
            preparedStatement = con
                    .prepareStatement("insert into members (name, contact, password) values (?,?,?)");  
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, contact);
            preparedStatement.setString(3, password);
            preparedStatement.executeUpdate();
            ret = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return ret;
     }

     public int getMemberIdByName(String name){
        int ret = -1;
        try {
            ResultSet rs = null;
            PreparedStatement preparedStatement = con
                    .prepareStatement("Select * from members where name = ?");
            preparedStatement.setString(1, name);
            
            rs = preparedStatement.executeQuery();
            while(rs.next()){
                ret = rs.getInt("id");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }       
        return ret;
     }
     
     
     public boolean updateMember(int id ,String name, String contact){
       
         boolean ret = false;
         boolean flag = false;
         
         String query = "update members SET ";
         if(!name.equals("")&&!contact.equals("")){
             query = query +"name= \'"+name+"\', contact=\'"+ contact +"\'";
             flag = true;
         }
         else if(!name.equals("")){
             query = query +"name= \'"+name+"\'";
             flag = true;
         }
         else if(!contact.equals("")){
             query = query +"contact= \'"+contact+"\'";
             flag = true;
         }
         
         query = query + " WHERE id="+id +";";
         
        if(flag){
            try {            
                 Statement stmt = con.createStatement();
                 stmt.executeUpdate(query);
                ret = true;

            } catch (SQLException ex) {
                Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
            } 
        } 
       
      return ret;
     }
     
     public boolean deleteMember(int id){
       
         boolean ret = false;
         PreparedStatement preparedStatement = null;
         try {
            preparedStatement = con
                      .prepareStatement("DELETE FROM members WHERE id=?"); 
        preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
            ret = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return ret;
     } 
     
     
     public boolean login(String name , String password){
         boolean ret = false;
        ResultSet rs = null;
        String query = "SELECT * From members where name = ? AND password = ?";
        try {
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);
            rs = preparedStatement.executeQuery();
            if(rs.next()){
                ret = true;
            }
            System.out.println(rs);
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

         return ret;
     }
}