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

    public Client(Object object, String _, String _0, Object object0, String _1, String _2, String _3, Object object1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    @Override
    public String toString() {
        return "Client{" + "id_client=" + id_client + "nom=" + nom + "prenom=" + prenom + "cin=" + cin + "mail=" + mail + "pwd=" + pwd + "adresse=" + adresse + "tel=" + tel + '}';
    }

    public void setId_client(int aInt) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setclient(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setadresse(String string) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
