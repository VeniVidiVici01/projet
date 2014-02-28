/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.entities;

/**
 *
 * @author mahmoud
 */
public class Globale {
public static String mail;
public static int id;
public static String nom;
public static String prenom ;
public static int idp ;

    public static int getId() {
        return id;
    }

    public static String getNom() {
        return nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static void setId(int id) {
        Globale.id = id;
    }

    public static void setNom(String nom) {
        Globale.nom = nom;
    }

    public static void setPrenom(String prenom) {
        Globale.prenom = prenom;
    }


    public static void setMail(String mail) {
        Globale.mail = mail;
    }

    public static String getMail() {
        return mail;
    }
    
}
