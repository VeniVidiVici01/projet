/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.dao;

import gc.entities.Client;
import gc.entities.Commentaire;
import gc.entities.ResCommentaire;
import gc.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author mohamed
 */
public class CommentaireDAO {
    
     public void insertCommentaire(Commentaire commentaire){

        String requete = "insert into commentaire (id_comm,id_user,type,id_offre,commentaire) values (default,?,?,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, commentaire.getId_user());
            ps.setString(2, commentaire.getType());
            ps.setInt(3, commentaire.getId_offre());
            ps.setString(4, commentaire.getCommentaire());
         
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateCommentaire(Commentaire commentaire,int id){
        String requete = "update commentaire set id_user=?, id_offre=? , type=? where id_comm=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);          
            ps.setInt(1, commentaire.getId_user());
            ps.setInt(2, commentaire.getId_offre());
            ps.setString(3, commentaire.getType());
            ps.setInt(4, id);
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteCommentaire(int id){
        String requete = "delete from commentaire where id=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ps.executeUpdate();
            System.out.println("commentaire supprimer");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Commentaire findCommentaire(int id){
        Commentaire commentaire = new Commentaire(0,0,0,"","");
     String requete = "select * from commentaire where id_comm=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               commentaire.setId_comm(resultat.getInt(1));
               commentaire.setId_offre(resultat.getInt(3));
               commentaire.setId_user(resultat.getInt(2));
               commentaire.setType(resultat.getString(4));
               
            }
            return commentaire;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du commentaire "+ex.getMessage());
            return null;
        }
    }

   
    public List<ResCommentaire> DisplayAllCommentaire (){


        List<ResCommentaire> listeCommentaire = new ArrayList<ResCommentaire>();

        String requete = "select C.nom, P.nom, M.comm"
                + " from commentaire M,client C,prestataire P "
                + " where ( M.type like 'prestataire' and M.id_user=P.id_prestataire ) "
                + " or ( M.type like 'client' and M.id_user=C.id_client )";
             
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);

            while(resultat.next()){
             ResCommentaire res = new ResCommentaire();
             res.setNomc(resultat.getString(1));
             res.setNomp(resultat.getString(2));
             res.setComm(resultat.getString(3));

              
             

                listeCommentaire.add(res);
                 
            }
            return listeCommentaire;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des commentaires "+ex.getMessage());
            return null;
        }
    }
 
    
}
