/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliklijent;

import domenskeKlase.Lek;
import domenskeKlase.ProdajaLekova;
import domenskeKlase.StavkaProdaje;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;
import klijentkontroler.KlijentKontroler;

/**
 *
 * @author Rastko
 */
public class ModelTabeleProdajeKonkretnogLeka extends AbstractTableModel {

    private ArrayList<ProdajaLekova> lista;
    private String[] kolone = {"Datum i vreme: ", "Napomena:", "Ukupna kolicina:", "Ukupna cena: "};
    Lek lek;

    public ModelTabeleProdajeKonkretnogLeka(Lek l) {
        try {
            lek = l;
            ArrayList<StavkaProdaje> stavkeProdaje = KlijentKontroler.getInstance().vratiStavkeProdaje(lek);
            for (StavkaProdaje sp : stavkeProdaje) {
                if(sp.getLek().getLekID() == lek.getLekID()){
                    lista.add(sp.getProdaja());
                    fireTableDataChanged();
                }
            }
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleProdajeKonkretnogLeka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return lista.size();
    }

    @Override
    public int getColumnCount() {
        return kolone.length;
    }

    @Override
    public String getColumnName(int i) {
        return kolone[i];
    }

    @Override
    public Object getValueAt(int row, int column) {
        ProdajaLekova p = lista.get(row); 

        switch (column) {
            case 0:
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                return sdf.format(p.getDatumVremeProdaje());
            case 1:
                return p.getNapomena();
            case 2:
                return p.getUkupnaKolicina();
            case 3:
                return p.getUkupnaCena();
            default:
                return null;
        }
    }


}
