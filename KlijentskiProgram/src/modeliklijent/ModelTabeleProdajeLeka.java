/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliklijent;

import domenskeKlase.Lek;
import domenskeKlase.StavkaProdaje;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rastko
 */
public class ModelTabeleProdajeLeka extends AbstractTableModel {

    private ArrayList<StavkaProdaje> lista;
    private String[] kolone = {"Prodaja", "Kolicina", "Lek"};
    private int rb = 1;

    public ModelTabeleProdajeLeka() {
        try {
            lista = new ArrayList<>();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleProdajeLeka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ModelTabeleProdajeLeka(ArrayList<StavkaProdaje> stavke) {
        try {
            lista = stavke;
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleProdajeLeka.class.getName()).log(Level.SEVERE, null, ex);
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
        StavkaProdaje sp = lista.get(row); //izmeniti

        switch (column) {
            case 0:
                return sp.getProdaja().getProdajaID();
            case 1:
                return sp.getKolicina();
            case 2:
                return sp.getLek().toString();
            default:
                return null;
        }
    }

    public void dodaj(StavkaProdaje sp) {
        sp.setRb(rb++);
        lista.add(sp);
        fireTableDataChanged();
    }

    public void obrisi(int row) {
        lista.remove(row);
        rb = 1;
        for (StavkaProdaje stavkaProdaje : lista) {
            stavkaProdaje.setRb(rb++);
        }
        fireTableDataChanged();
    }

    public boolean postoji(Lek l) {
        for (StavkaProdaje stavkaProdaje : lista) {
            if (stavkaProdaje.getLek().getLekID() == l.getLekID()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<StavkaProdaje> getLista() {
        return lista;
    }

    public int vratiKolicinu() {
        int kolicina = 0;
        for (StavkaProdaje stavkaProdaje : lista) {
            kolicina += stavkaProdaje.getKolicina();
        }
        return kolicina;
    }

    public int vratiCenu() {
        int cena = 0;
        for (StavkaProdaje stavkaProdaje : lista) {
            cena += stavkaProdaje.getKolicina()*stavkaProdaje.getLek().getProdajnaCena();
        }
        return cena;
    }

}
