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

        String requete = "insert into prestataire (id_prestataire) values (?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, p.getId_prestataire());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updatePrestataire(Prestataire p){
        String requete = "update prestataire  set id_prestataire=? where id_prestataire=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, p.getId_prestataire());
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
    Prestataire p = new Prestataire(0, "","",0,"", "","", 0, "");
     String requete = "select * from prestataire where id_prestataire=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_prestataire);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               p.setId_prestataire(resultat.getInt(1));
             
            }
            return p;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du prestataire "+ex.getMessage());
            return null;
        }
    }

    public Prestataire findPrestataireByAdresse(String adresse){
    Prestataire p = new Prestataire(0, "","",0,"", "","", 0, "");
     String requete = "select * from prestataire where adresse= ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, adresse);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               p.setId_prestataire(resultat.getInt(1));
                System.out.println("testttttttt"+p.getId_prestataire());
               p.setAdresse(resultat.getString(2));
                System.out.println(resultat.getString(2));
            }
            return p;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du prestataire"+ex.getMessage());
            return null;
        }
    }

    public List<Prestataire> DisplayAllPrestataire (){


        List<Prestataire> listeprestataire = new ArrayList<Prestataire>();

        String requete = "select * from prestataire";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Prestataire p = new Prestataire(0, "","",0,"", "","", 0, "");
                p.setId_prestataire(resultat.getInt(1));
                p.setAdresse(resultat.getString(2));

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
