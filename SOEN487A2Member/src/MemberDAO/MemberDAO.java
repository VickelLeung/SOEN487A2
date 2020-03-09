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
            this.con =  DriverManager.getConnection( "jdbc:mysql://den1.mysql1.gear.host/soen487a2", "soen487a2", "Bo4hZ0KtZ?~0" );
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
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
         return rs;
    }

     public boolean addMember(String name, String contact){
         System.out.println("n: " + name + " c: " + contact);
         boolean ret = false;
         PreparedStatement preparedStatement = null;
         try {
            
            preparedStatement = con
                    .prepareStatement("insert into members (name, contact) values (?,?)");  
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, contact);
            preparedStatement.executeUpdate();
            ret = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
      return ret;
     }

     public boolean updateMember(int id ,String name, String contact){
       
         boolean ret = false;
         PreparedStatement preparedStatement = null;
         try {
             
            preparedStatement = con
                      .prepareStatement("update members SET name=?, contact=? WHERE id=? "); 
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, contact);
            preparedStatement.setInt(3, id);
            preparedStatement.executeUpdate();
            ret = true;
            
        } catch (SQLException ex) {
            Logger.getLogger(MemberDAO.class.getName()).log(Level.SEVERE, null, ex);
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
}