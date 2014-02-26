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
public class Prestataire {
    private int id_prestataire ;
   private String nom ;
   private String prenom ;
   private double cin ;
   private String mail ;
   private String pwd ;
   private String adresse ;
   private double tel ;
   private String specialite ;
  private String etat ;
   
 
    public Prestataire(int id_prestataire, String nom, String prenom, double cin, String mail, String pwd, String adresse, double tel, String specialite,String etat) {
        this.id_prestataire = id_prestataire;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.mail = mail;
        this.pwd = pwd;
        this.adresse = adresse;
        this.tel = tel;
        this.specialite = specialite;
        this.etat = etat ;
    }

    public Prestataire() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getId_prestataire() {
        return id_prestataire;
    }

    public void setId_prestataire(int id_prestataire) {
        this.id_prestataire = id_prestataire;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getCin() {
        return cin;
    }

    public void setCin(double cin) {
        this.cin = cin;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getTel() {
        return tel;
    }

    public void setTel(double tel) {
        this.tel = tel;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    @Override
    public String toString() {
        return "Prestataire{" + "id_prestataire=" + id_prestataire + ", nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + ", mail=" + mail + ", pwd=" + pwd + ", adresse=" + adresse + ", tel=" + tel + ", specialite=" + specialite + ", etat=" + etat + '}';
    }

    
    
    
}
