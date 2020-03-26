/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MemberCore;
import MemberMVC.MemberController;
import MemberMVC.Members;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


/**
 *
 * @author vickelleung
 */
public class MemberCore {
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        MemberController mc = MemberController.getInstance();
      //  Members mem = new Members(1, "tom", "514-423-12421");
      //  HashMap hm = new HashMap();
        
//        ==Add==
//        if( mc.addMember(mem)) System.out.println("Added");
//        else System.out.println("Did not added");
        
//        ==update mem==
//          if( mc.updateMember(1, "rick", "514-232-4562")) System.out.println("update");
//          else System.out.println("Did not updated"); 

//        ==Delete mem==
//        if( mc.deleteMember(1)) System.out.println("deleted");
//        else System.out.println("Did not delete");

      // ==GetMembers==
      // System.out.print(mc.getMember(1).toString());
        
//         ==ListMembers==
//            hm = mc.getMemberList();
//            for(int i = 0; i<hm.size(); i++){
//                System.out.println(hm.get(i));
//            }

      int x = mc.getMemberIdByName("sssss");
        System.out.println(x);

    }
 }
    

