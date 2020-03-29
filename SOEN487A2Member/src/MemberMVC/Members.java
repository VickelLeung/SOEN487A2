package MemberMVC;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vickelleung
 */
public class Members {

    private int id;
    private String name;
    private String contact;
    private String password;

    public Members() {
        this.id = 1;
        this.name = "default";
        this.contact = "contact";
        this.password = "abcd";
    }

    public Members(int id, String name, String contact, String password) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.password = password;
    }

    public Members(String name, String contact, String password) {
        this.name = name;
        this.contact = contact;
        this.password = password;
    }

    public void setName(String n) {
        name = n;
    }

    public void setPassword(String p) {
        password = p;
    }

    public void setContact(String c) {
        contact = c;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getContact() {
        return contact;
    }

    public String toString() {
        return "Name :" + name + " contact: " + contact;
    }
}
