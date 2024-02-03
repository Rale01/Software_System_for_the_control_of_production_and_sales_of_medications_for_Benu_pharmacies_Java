/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliklijent;

import domenskeKlase.Supstanca;
import domenskeKlase.SupstancaLeka;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rastko
 */
public class ModelTabeleSupstanceLeka extends AbstractTableModel {

    private ArrayList<SupstancaLeka> lista;
    private String[] kolone = {"Rb", "Kolicina", "Supstanca"};
    private int rb = 1;

    public ModelTabeleSupstanceLeka() {
        try {
            lista = new ArrayList<>();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleSupstanceLeka.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ModelTabeleSupstanceLeka(ArrayList<SupstancaLeka> supstance) {
        lista = supstance;
        rb = lista.size() + 1;
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
        SupstancaLeka sl = lista.get(row); //izmeniti

        switch (column) {
            case 0:
                return sl.getRb();
            case 1:
                return sl.getKolicina();
            case 2:
                return sl.getSupstanca().toString();
            default:
                return null;
        }
    }

    public void dodaj(SupstancaLeka sl) {
        sl.setRb(rb++);
        lista.add(sl);
        fireTableDataChanged();
    }

    public void obrisi(int row) {
        lista.remove(row);
        rb = 1;
        for (SupstancaLeka supstancaLeka : lista) {
            supstancaLeka.setRb(rb++);
        }
        fireTableDataChanged();
    }

    public boolean postoji(Supstanca s) {
        for (SupstancaLeka supstancaLeka : lista) {
            if (supstancaLeka.getSupstanca().getSupstancaID() == s.getSupstancaID()) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<SupstancaLeka> getLista() {
        return lista;
    }

}
