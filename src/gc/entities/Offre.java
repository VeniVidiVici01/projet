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
    private String nom;
    private String lieu ;
    private double prix ;
    private String date ;
    private String type;
    private String description;
    private int id_prestataire;

    public Offre(int id_offre, String nom, String lieu, double prix, String date, String type, String description, int id_prestataire) {
        this.id_offre = id_offre;
        this.nom=nom;
        this.lieu = lieu;
        this.prix = prix;
        this.date = date;
        this.type=type;
        this.description=description;
        this.id_prestataire=id_prestataire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId_prestataire() {
        return id_prestataire;
    }

    public void setId_prestataire(int id_prestataire) {
        this.id_prestataire = id_prestataire;
    }

  
    public void setoffre(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setlieu(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return "Offre{" + "id_offre=" + id_offre + ", nom=" + nom + ", lieu=" + lieu + ", prix=" + prix + ", date=" + date + ", type=" + type + ", description=" + description + ", id_prestataire=" + id_prestataire + '}';
    }

  
    
 
    
}
