/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.entities;

/**
 *
 * @author BEN ARFA
 */
public class Offre {
    private int id_offre ;
    private String lieu ;
    private double prix ;
    private String date ; 

    public Offre(int id_offre, String lieu, double prix, String date) {
        this.id_offre = id_offre;
        this.lieu = lieu;
        this.prix = prix;
        this.date = date;
    }

    public int getId_offre() {
        return id_offre;
    }

    public void setId_offre(int id_offre) {
        this.id_offre = id_offre;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", lieu=" + lieu + ", prix=" + prix + ", date=" + date + '}';
    }

    public void setoffre(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setlieu(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
 
    
}
