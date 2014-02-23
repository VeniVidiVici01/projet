/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.entities;

/**
 *
 * @author mohamed
 */
public class Admin {
     private int id_admin;
    private String mail;
    private String pwd;

    public Admin(String mail, String pwd) {
   
        this.mail = mail;
        this.pwd = pwd;
    }

    

    public int getId_admin() {
        return id_admin;
    }

    public String getMail() {
        return mail;
    }

    public String getPwd() {
        return pwd;
    }

    
    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Admin{" + "id_admin=" + id_admin + ", mail=" + mail + ", pwd=" + pwd + '}';
    }

    
    
}
