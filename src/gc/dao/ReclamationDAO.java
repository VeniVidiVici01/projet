/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.dao;

import gc.entities.Reclamation;
import gc.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mahmoud
 */
public class ReclamationDAO {
   public void insertReclamation(Reclamation r){

        String requete = "insert into reclamation (id_reclamation,id_user,message,type) values (default,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, r.getId_user());
            ps.setString(2, r.getMessage());
            ps.setString(3, r.getType());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateReclamation(Reclamation r){
        String requete = "update reclamation set id_user=?,message=?,type=? where id_rec=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           // ps.setString(1, .getAdresse_depot());
            ps.setInt(1, r.getId_user());
            ps.setString(2, r.getMessage());
            ps.setString(3, r.getType());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteReclamation(int id){
        String requete = "delete from reclamation where id_reclamation=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("reclamation supprimer");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }
    
    


    public Reclamation findReclamation(int id){
        Reclamation reclamation = new Reclamation(0, 0, "", "");
     String requete = "select * from reclamation where id_reclamation=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               reclamation.setId_rec(resultat.getInt(1));
               reclamation.setId_user(resultat.getInt(2));
               reclamation.setMessage(resultat.getString(3));
               reclamation.setType(resultat.getString(4));
               
            }
            return reclamation;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

     public Reclamation findReclamationByUser(int id){
        Reclamation reclamation = new Reclamation(0, 0, "", "");
     String requete = "select * from reclamation where id_user=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               reclamation.setId_rec(resultat.getInt(1));
               reclamation.setId_user(resultat.getInt(2));
               reclamation.setMessage(resultat.getString(3));
               reclamation.setType(resultat.getString(4));
               
            }
            return reclamation;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

     public Reclamation findReclamationById(int id){
        Reclamation reclamation = new Reclamation(0, 0, "", "");
     String requete = "select * from reclamation where id_reclamation=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               reclamation.setId_rec(resultat.getInt(1));
               reclamation.setId_user(resultat.getInt(2));
               reclamation.setMessage(resultat.getString(3));
               reclamation.setType(resultat.getString(4));
               
            }
            return reclamation;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du depot "+ex.getMessage());
            return null;
        }
    }

   
    public List<Reclamation> DisplayAllReclamation (){


        List<Reclamation> listereclamation = new ArrayList<Reclamation>();

        String requete = "select * from reclamation";
        try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
              Reclamation reclamation =new  Reclamation(0,0,"", "");
                reclamation.setId_rec(resultat.getInt(1));
                reclamation.setId_user(resultat.getInt(2));
                reclamation.setMessage(resultat.getString(3));
                reclamation.setType(resultat.getString(4));
                

                listereclamation.add(reclamation);
            }
            return listereclamation;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des reclamations "+ex.getMessage());
            return null;
        }
    }
 
    
    
    
    
}
