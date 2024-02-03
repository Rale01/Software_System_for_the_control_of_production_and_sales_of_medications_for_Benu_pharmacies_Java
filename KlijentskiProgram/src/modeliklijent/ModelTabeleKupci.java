/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliklijent;

import domenskeKlase.Kupac;
import formemain.PretragaKupaca;
import klijentkontroler.KlijentKontroler;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rastko
 */
public class ModelTabeleKupci extends AbstractTableModel {

    private ArrayList<Kupac> lista;
    private String[] kolone = {"Ime prezime", "Kontakt"};
    private String parametar = "";

    public ModelTabeleKupci() {
        try {
            lista = KlijentKontroler.getInstance().vratiKupce();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleKupci.class.getName()).log(Level.SEVERE, null, ex);
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
        Kupac k = lista.get(row); //izmeniti

        switch (column) {
            case 0:
                return k.getImePrezimeKupca();
            case 1:
                return k.getKontakt();
            default:
                return null;
        }
    }

    public Kupac getSelectedKupac(int row) {
        return lista.get(row);
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            if (!parametar.equals("")) {
                ArrayList<Kupac> novaLista = new ArrayList<>();
                for (Kupac k : lista) {
                    if(k.getImePrezimeKupca().toLowerCase().contains(parametar.toLowerCase())){
                        novaLista.add(k);
                    }
                }
                lista = novaLista;
                if(novaLista.size()>0){
                    PretragaKupaca.setPoruka("Sistem je pronasao kupce po zadatoj vrednosti");
                }
                else{
                    PretragaKupaca.setPoruka("Sistem nije pronasao kupce po zadatoj vrednosti");
                }
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
