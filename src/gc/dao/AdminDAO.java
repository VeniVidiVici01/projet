 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gc.dao;

import gc.entities.Admin;
import gc.util.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author STETCHI
 */
public class AdminDAO {
    public void insertAdmin(Admin a){

        String requete = "insert into Admin (id_admin,mail,pwd) values (default,?,?)";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
           
            ps.setString(1, a.getMail());
            ps.setString(2, a.getPwd());
            ps.executeUpdate();
            System.out.println("insertion effectuée avec succès");
        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de l'insertion "+ex.getMessage());
        }
    }
   public Admin findAdminByMail(String mail, String pwd ){
    Admin a = new Admin("","");
     String requete = "select * from admin where mail=? and pwd=? ";
        try {
            PreparedStatement ps = MyConnection.getInstance().prepareStatement(requete);
            ps.setString(1, mail);
            ps.setString(2, pwd);

            ResultSet resultat = ps.executeQuery();
            while (resultat.next())
            {
               
               a.setMail(resultat.getString(2));
               a.setPwd(resultat.getString(3));
              
                
             
            }
            return a;

        } catch (SQLException ex) {
           //Logger.getLogger(PersonneDao.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erreur lors de la recherche de l'admin "+ex.getMessage());
            return null;
        }
    }

}
