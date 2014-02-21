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
public class Commentaire {
    private int id_comm ;
    private int id_offre ;
    private int id_user ;
    private String type ;

    public Commentaire(int id_comm, int id_offre, int id_user, String type) {
        this.id_comm = id_comm;
        this.id_offre = id_offre;
        this.id_user = id_user;
        this.type = type;
    }

    public int getId_comm() {
        return id_comm;
    }

    public int getId_offre() {
        return id_offre;
    }

    public int getId_user() {
        return id_user;
    }

    public String getType() {
        return type;
    }

    public void setId_comm(int id_comm) {
        this.id_comm = id_comm;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
}
