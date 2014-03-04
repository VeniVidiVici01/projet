/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gc.gui;
import gc.dao.OffreDAO;
import gc.entities.Offre;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author NESSIM
 */
public class ListSalleFetesModel extends AbstractTableModel{
     String[] headers={"Nom","Lieux","Prix","Description"};
     List<Offre> ListeOffre=new ArrayList<>();
    public ListSalleFetesModel()
    {
       OffreDAO offredao=new OffreDAO();
       ListeOffre=offredao.DisplayAllOffre();
        
    }
    public ListSalleFetesModel(String nom,Double prix,String lieu,String type)
    {
       OffreDAO offredao=new OffreDAO();
       ListeOffre=offredao.RechercheOffre(nom, prix, lieu, type);
        
    }

    @Override
    public int getRowCount() {
   return ListeOffre.size();
    }

    @Override
    public int getColumnCount() {
        return headers.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return  ListeOffre.get(rowIndex).getNom();
            case 1:
                return ListeOffre.get(rowIndex).getLieu();
            case 2:
                return ListeOffre.get(rowIndex).getPrix();
            case 3:
                return ListeOffre.get(rowIndex).getDescription();
            default:
                return null;
        }
    }
    
    
     @Override
        public String getColumnName(int column) {
        return headers[column];
    }
    
}
