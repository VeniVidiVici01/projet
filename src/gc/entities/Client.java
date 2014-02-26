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

    
    private int id_client;
    private String nom;
    private String prenom;
    private double cin;
    private String mail;
    private String pwd;
    private String adresse;
    private double tel;
    private int etat ;

    public Client(int id_client, String nom, String prenom, double cin, String mail, String pwd, String adresse, double tel,int etat) {
        this.id_client = id_client;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.mail = mail;
        this.pwd = pwd;
        this.adresse = adresse;
        this.tel = tel;
        this.etat = etat ;
    }

    /**
     *
     * @param id
     */
    public void setId_client(int id) {
        this.id_client = id;
    }
   

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

    public int getId_client() {
        return id_client;
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

       public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + "nom=" + nom + "prenom=" + prenom + "cin=" + cin + "mail=" + mail + "pwd=" + pwd + "adresse=" + adresse + "tel=" + tel + '}';
    }

   
  
}
