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
public class Reclamation {
   
   private int id_user ;
   private String message;
   private String type;
   
   public Reclamation(int id_user, String message, String type) {
        this.id_user = id_user;
        this.message = message;
        this.type = type;
    }
  

    public int getId_user() {
        return id_user;
    }

    public String getMessage() {
        return message;
    }

    public String getType() {
        return type;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }

    
    
    
    
}
