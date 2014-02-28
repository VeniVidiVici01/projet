/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.dao;

import gc.entities.Prestataire;
import gc.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author BEN ARFA
 */
public class PrestataireDAO {
     public void insertPrestataire(Prestataire p){

        String requete = "insert into prestataire(id_prestataire,nom,prenom,cin,mail,pwd,adresse,tel,specialite) values (default,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           
            ps.setString(1, p.getNom());
              ps.setString(2, p.getPrenom());
               ps.setDouble(3, p.getCin());
               ps.setString(4, p.getMail());
                ps.setString(5, p.getPwd());
              ps.setString(6, p.getAdresse());
               ps.setDouble(7, p.getTel());
                ps.setString(8, p.getSpecialite());
                 
                
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updatePrestataire(Prestataire p){
        String requete;
         requete = "update prestataire  set nom =?,prenom=?,cin=?,mail=?,pwd=?,adresse=?,tel=?,specialite=?,etat=? where id_prestataire=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(10, p.getId_prestataire()); 
             ps.setString(1, p.getNom());
              ps.setString(2, p.getPrenom());
               ps.setDouble(3, p.getCin());
                ps.setString(4, p.getMail());
                ps.setString(5, p.getPwd());
              ps.setString(6, p.getAdresse());
               ps.setDouble(7, p.getTel());
                ps.setString(8, p.getSpecialite());
                 ps.setString(9, p.getEtat());
            
            //ps.setInt(2, p.getId_prestataire());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deletePrestataire(int id_prestataire){
        String requete = "delete from prestataire where id_prestataire=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_prestataire);
            ps.executeUpdate();
            System.out.println("Prestataire supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Prestataire findPrestataireById(int id_prestataire){
    Prestataire p = new Prestataire(0, "","",0,"", "","", 0, "","");
     String requete = "select * from prestataire where id_prestataire=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_prestataire);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               p.setId_prestataire(resultat.getInt(1));
               p.setNom(resultat.getString(2));
              p.setPrenom(resultat.getString(3));
               p.setCin(resultat.getDouble(4));
                p.setMail(resultat.getString(5));
              p.setPwd(resultat.getString(6));
               p.setAdresse(resultat.getString(7));
                p.setTel(resultat.getDouble(8));
                 p.setSpecialite(resultat.getString(9));
                  p.setEtat(resultat.getString(10));
                 
                
             
            }
            return p;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du prestataire "+ex.getMessage());
            return null;
        }
    }

    public Prestataire findPrestataireByAdresse(String adresse){
    Prestataire p = new Prestataire(0, "","",0,"", "","", 0, "","");
     String requete = "select * from prestataire where nom= ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, adresse);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               p.setId_prestataire(resultat.getInt(1));
               p.setNom(resultat.getString(2));
              p.setPrenom(resultat.getString(3));
               p.setCin(resultat.getDouble(4));
                p.setMail(resultat.getString(5));
              p.setPwd(resultat.getString(6));
               p.setAdresse(resultat.getString(7));
                p.setTel(resultat.getDouble(8));
                 p.setSpecialite(resultat.getString(9));
                  p.setEtat(resultat.getString(10));
            }
            return p;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du prestataire"+ex.getMessage());
            return null;
        }
    }
    
     public Prestataire findPrestataireByMailPwd(String mail,String pwd){
    Prestataire p = new Prestataire(0, "","",0,"", "","", 0, "","");
     String requete = "select * from prestataire where mail=?  and pwd =? ";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, mail);
             ps.setString(2, pwd);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               p.setId_prestataire(resultat.getInt(1));
               p.setNom(resultat.getString(2));
              p.setPrenom(resultat.getString(3));
               p.setCin(resultat.getDouble(4));
                p.setMail(resultat.getString(5));
              p.setPwd(resultat.getString(6));
               p.setAdresse(resultat.getString(7));
                p.setTel(resultat.getDouble(8));
                 p.setSpecialite(resultat.getString(9));
                  p.setEtat(resultat.getString(10));
                 
                
             
            }
            return p;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du prestataire "+ex.getMessage());
            return null;
        }
    }

    public List<Prestataire> DisplayAllPrestataire (){


        List<Prestataire> listeprestataire = new ArrayList<>();

        String requete = " select *from prestataire ";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           

            while(resultat.next()){
                Prestataire p = new Prestataire(0, "","",0,"", "","", 0, "","");
                 p.setId_prestataire(resultat.getInt(1));
               p.setNom(resultat.getString(2));
              p.setPrenom(resultat.getString(3));
               p.setCin(resultat.getDouble(4));
                p.setMail(resultat.getString(5));
              p.setPwd(resultat.getString(6));
               p.setAdresse(resultat.getString(7));
                p.setTel(resultat.getDouble(8));
                 p.setSpecialite(resultat.getString(9));
                  p.setEtat(resultat.getString(10));

                listeprestataire.add(p);
            }
            return listeprestataire;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des prestataire "+ex.getMessage());
            return null;
        }
    }

    
}
