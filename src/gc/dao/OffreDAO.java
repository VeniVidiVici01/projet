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
    public void insertOffre(Offre o){

        String requete = "insert into offre(id_offre) values (?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, o.getId_offre());
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateOffre(Offre o ){
        String requete = "update offre set id_offre=? where id_offre=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, o.getId_offre());
            ps.setInt(2, o.getId_offre());
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
    Offre o  = new Offre(0, "",0,"");
     String requete = "select * from offre where id_offre=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_offre);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               o.setId_offre(resultat.getInt(1));
             
            }
            return o;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du offre "+ex.getMessage());
            return null;
        }
    }

    public Offre findOffreLieu(String lieu){
     Offre o  = new Offre(0, "",0,"");
     String requete = "select * from offre where lieu= ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, lieu);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               o.setId_offre(resultat.getInt(1));
                System.out.println("testttttttt"+o.getId_offre());
               o.setoffre(resultat.getString(2));
                System.out.println(resultat.getString(2));
            }
            return o;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du offre "+ex.getMessage());
            return null;
        }
    }

    public List<Offre> DisplayAllOffre (){


        List<Offre> listeoffre = new ArrayList<>();

        String requete = "select * from offre";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
                Offre o = new Offre(0, "",0,"");
                o.setId_offre(resultat.getInt(1));
                o.setlieu(resultat.getString(2));

                listeoffre.add(o);
            }
            return listeoffre;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des offres  "+ex.getMessage());
            return null;
        }
    }
    
}
