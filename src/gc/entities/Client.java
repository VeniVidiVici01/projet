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
public class Client {
    private int id_admin;
    private String nom;
    private String prenom;
    private double cin;
    private String mail;
    private String pwd;
    private String adresse;
    private double tel;

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public double getCin() {
        return cin;
    }

    public void setCin(double cin) {
        this.cin = cin;
    }

    public int getId_admin() {
        return id_admin;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public double getTel() {
        return tel;
    }

    public void setTel(double tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Client{" + "id_admin=" + id_admin + "nom=" + nom + "prenom=" + prenom + "cin=" + cin + "mail=" + mail + "pwd=" + pwd + "adresse=" + adresse + "tel=" + tel + '}';
    }
    
    
}
