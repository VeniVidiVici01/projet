/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package goldencage;

import gc.dao.ClientDAO;
import gc.entities.Client;

/**
 *
 * @author mohamed
 */
public class GoldenCage {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ClientDAO clientdao = new ClientDAO();
        Client cli = new Client(0,"", "", 0, "", "", "", 0);
      
      
       cli = clientdao.findClientByMailPwd("gh","gh");
     System.out.println(cli.getMail());
        //cli= clientdao.findClientById(1);
        //System.out.println(cli.getNom());
        //cli = clientdao.findClientAdresse("gh");
      // System.out.println(cli.getMail());
        //clientdao.insertClient(cli);
                
        // TODO code application logic here
    }
    
}
