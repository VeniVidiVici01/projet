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
   private int id_rec ;
   private int id_user ;
   private String message;
   private String type;
    private int id_prestataire ;

    

    public Reclamation(int id_rec, int id_user, String message, String type, int id_prestataire) {
        this.id_rec = id_rec;
        this.id_user = id_user;
        
        this.message = message;
        this.type = type;
        this.id_prestataire = id_prestataire;
    }

    public int getId_rec() {
        return id_rec;
    }

    public void setId_prestataire(int id_prestataire) {
        this.id_prestataire = id_prestataire;
    }

    public int getId_prestataire() {
        return id_prestataire;
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

    public void setId_rec(int id_rec) {
        this.id_rec = id_rec;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setType(String type) {
        this.type = type;
    }
   
   
 
}
