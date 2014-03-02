/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package gc.dao;

import gc.entities.Client;
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
* @author Bagio
*/
public class ClientDAO {

     public void insertClient(Client c){

        String requete = "insert into client(id_client,nom,prenom,cin,mail,pwd,adresse,tel,etat) values (default,?,?,?,?,?,?,?,default)";
        try {
            PreparedStatement ps;
            ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setDouble(3, c.getCin());
            ps.setString(4, c.getMail());
            ps.setString(5, c.getPwd());
            ps.setString(6, c.getAdresse());
            ps.setDouble(7, c.getTel());
            
            
            ps.executeUpdate();
            System.out.println("Ajout effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }


    public void updateClient(Client c ){
        String requete = "update client set nom=?,prenom=?,cin=?,mail=?,pwd=?,adresse=?,tel=?,etat=? where id_client=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, c.getNom());
            ps.setString(2, c.getPrenom());
            ps.setDouble(3, c.getCin());
            ps.setString(4, c.getMail());
            ps.setString(5, c.getPwd());
            ps.setString(6, c.getAdresse());
            ps.setDouble(7, c.getTel());
            ps.setString(8, c.getEtat());
            ps.setInt(9, c.getId_client());
            
            ps.executeUpdate();
            System.out.println("Mise à jour effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la mise à jour "+ex.getMessage());
        }
    }

    public void deleteClient(int id_client){
        String requete = "delete from client where id_client=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_client);
            ps.executeUpdate();
            System.out.println("client supprimée");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la suppression "+ex.getMessage());
        }
    }


    public Client findClientById(int id_client){
    Client c = new Client (0,"","",0,"","","",0);
     String requete = "select * from client where id_client=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setInt(1, id_client);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               c.setId_client(resultat.getInt(1));
               c.setNom(resultat.getString(2));
               c.setPrenom(resultat.getString(3));
               c.setCin(resultat.getDouble(4));
               c.setMail(resultat.getString(5));
               c.setPwd(resultat.getString(6));
               c.setAdresse(resultat.getString(7)); 
               c.setTel(resultat.getDouble(8));
              
               
               
               
               
            }
            return c;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du client "+ex.getMessage());
            return null;
        }
    }

    public Client findClientAdresse(String nom){
      Client c = new Client (0,"","",0,"","","",0);
     String requete = "select * from client where nom= ?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, nom);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               c.setId_client(resultat.getInt(1));
                
                c.setMail(resultat.getString(5));
                
            }
            return c;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du client "+ex.getMessage());
            return null;
        }
    }
     public Client findClientByMailPwd(String mail, String pwd){
      Client c = new Client (0,"","",0,"","","",0);
     String requete = "select * from client where mail=? and pwd=?";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, mail);
            ps.setString(2, pwd);
            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               c.setId_client(resultat.getInt(1));
                System.out.println("testttttttt"+c.getId_client());
                c.setMail(resultat.getString(2));
                System.out.println(resultat.getString(2));
            }
            return c;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche du client "+ex.getMessage());
            return null;
        }
    }

    public List<Client> DisplayAllClient (){



        List<Client> listeclient = new ArrayList<>();

        String requete = "select * from client";
        try {
           Statement statement = MyConnection.getInstance()
                   .createStatement();
            ResultSet resultat = statement.executeQuery(requete);
           

            while(resultat.next()){
                Client p = new Client(0,"","",0,"","","",0);
                 p.setId_client(resultat.getInt(1));
               p.setNom(resultat.getString(2));
              p.setPrenom(resultat.getString(3));
               p.setCin(resultat.getDouble(4));
                p.setMail(resultat.getString(5));
              p.setPwd(resultat.getString(6));
               p.setAdresse(resultat.getString(7));
                p.setTel(resultat.getDouble(8));
                p.setEtat(resultat.getString(9));

                listeclient.add(p);
            }
            return listeclient;
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors du chargement des clients "+ex.getMessage());
            return null;
        }
    }
    
         public int DisplayNbrClient() {
int c=0;
        String requete = "select count(*)from prestataire";
        try{
     
           Statement statement = MyConnection.getInstance().createStatement();
                   
            ResultSet resultat = statement.executeQuery(requete);
            while(resultat.next())
            {
              c= resultat.getInt(1);
            }
            return c;
        }
        catch (SQLException ex){
            ex.getMessage();
            return 0;
        }
}}
