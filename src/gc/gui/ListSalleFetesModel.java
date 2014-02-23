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
     String[] headers={"Nom","Date","Liex","Prix"};
     List<Offre> ListeOffre=new ArrayList<Offre>();
    public ListSalleFetesModel()
    {
       OffreDAO offredao=new OffreDAO();
       ListeOffre=offredao.DisplayAllOffre();
        
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
                return ListeOffre.get(rowIndex).getDate();
            case 2:
                return ListeOffre.get(rowIndex).getLieu();
            case 3:
                return ListeOffre.get(rowIndex).getPrix();
            default:
                return null;
        }
    }
    
    
    
    
    
}
