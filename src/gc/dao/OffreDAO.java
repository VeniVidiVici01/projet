/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.dao;
import gc.entities.Offre;
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
public class OffreDAO {
    public boolean insertOffre(Offre o){

      String requete = "insert into offre(id_offre,nom,lieu,prix,date,type,description,id_prestataire) values (default,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
          
            ps.setString(1, o.getNom());
            ps.setString(2, o.getLieu());
            ps.setDouble(3, o.getPrix());
            ps.setString(4, o.getDate());
            ps.setString(5, o.getType());
            ps.setString(6, o.getDescription());
            ps.setInt(7, o.getId_prestataire());
            ps.executeUpdate();
            
            System.out.println("Ajout effectuée avec succès");
            return  true ;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
        return false;
    }


    public void updateOffre(Offre o ){
        String requete = "update offre set nom=?,lieu=?,prix=?,date=?,type=?,description=?,id_prestataire=? where id_offre=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
             ps.setString(1, o.getNom());
             ps.setString(2, o.getLieu());
            ps.setDouble(3, o.getPrix());
            ps.setString(4, o.getDate());
            ps.setString(5, o.getType());
            ps.setString(6, o.getDescription());
            ps.setInt(7, o.getId_prestataire());
            ps.setInt(8,o.getId_offre());
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteOffre(int id_offre){
        String requete = "delete from offre where id_offre=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_offre);
            ps.executeUpdate();
            System.out.println("Offre supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Offre findOffreById(int id_offre){
    Offre o;
        o = new Offre (0, "","",0 , "", "", "",0);
     String requete = "select * from offre where id_offre=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_offre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               o.setId_offre(resultat.getInt(1));
               o.setNom(resultat.getString(2));
                o.setLieu(resultat.getString(3));
                 o.setPrix(resultat.getDouble(4));
                  o.setDate(resultat.getString(5));
                   o.setType(resultat.getString(6));
                   o.setDescription(resultat.getString(7));
                  o.setId_prestataire(resultat.getInt(8));  
             
            }
            return o;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du offre "+ex.getMessage());
            return null;
        }
    }

    public Offre findOffreLieu(String lieu){
     Offre o  = new Offre(0, "","", 0, "", "", "", 0);
     String requete = "select * from offre where lieu= ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, lieu);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               o.setId_offre(resultat.getInt(1));
               o.setNom(resultat.getString(2));
                o.setLieu(resultat.getString(3));
                 o.setPrix(resultat.getInt(4));
                  o.setDate(resultat.getString(5));
                   o.setType(resultat.getString(6));
                    o.setDescription(resultat.getString(7));
                     o.setId_prestataire(resultat.getInt(8));
                
            }
            return o;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du offre "+ex.getMessage());
            return null;
        }
    }
    public List<Offre> DisplayType(){
         List<Offre> listeoffre = new ArrayList<>();
         String requete = "SELECT DISTINCT type from offre";
        try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Offre o  = new Offre();
               
                o.setType(resultat.getString(1));
                listeoffre.add(o);
            }
            return listeoffre;
        } 
         catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des offres  "+ex.getMessage());
            return null;
        }
    }

    public List<Offre> DisplayAllOffre (){


        List<Offre> listeoffre = new ArrayList<>();

        String requete = "SELECT nom,lieu,prix,description from offre";
        try {
           Statement statement = MyConnection.getInstance().createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Offre o  = new Offre();
               
                o.setNom(resultat.getString(1));
                o.setLieu(resultat.getString(2));
                o.setPrix(resultat.getDouble(3));
                 o.setDescription(resultat.getString(4));
                 
                  // o.setType(resultat.getString(5));
                 //   o.setDescription(resultat.getString(6));
                   //  o.setId_prestataire(resultat.getInt(7));

                listeoffre.add(o);
            }
            return listeoffre;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des offres  "+ex.getMessage());
            return null;
        }
    }
    public List<Offre> RechercheOffre(String nom,Double prix,String lieu,String type)
    {
        List<Offre> listeoffre = new ArrayList<>();
        String requete = "SELECT nom,lieu,prix,description from offre where nom like ? or lieu like ? or prix= ? or type= ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, nom);
            ps.setString(2, lieu);
            ps.setDouble(3, prix);
            ps.setString(4, type);
            ResultSet resultat = ps.executeQuery();
            
            while(resultat.next()){
                Offre o  = new Offre();
               
                o.setNom(resultat.getString(1));
                o.setLieu(resultat.getString(2));
                o.setPrix(resultat.getDouble(3));
                 o.setDescription(resultat.getString(4));
                 
                  // o.setType(resultat.getString(5));
                 //   o.setDescription(resultat.getString(6));
                   //  o.setId_prestataire(resultat.getInt(7));

                listeoffre.add(o);
               
            }
            
        
        return listeoffre;
        
        }
       catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des offres  "+ex.getMessage());
            return null;
        }
        
    }
    
}
