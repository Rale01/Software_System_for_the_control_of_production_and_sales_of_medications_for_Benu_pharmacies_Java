/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modeliklijent;

import domenskeKlase.Lek;
import formemain.PretragaLekova;
import klijentkontroler.KlijentKontroler;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Rastko
 */
public class ModelTabeleLekovi extends AbstractTableModel {

    private ArrayList<Lek> lista;
    private String[] kolone = {"Sifra leka", "Naziv", "Cena"};
    private String parametar = "";

    public ModelTabeleLekovi() {
        try {
            lista = KlijentKontroler.getInstance().vratiLekove();
        } catch (Exception ex) {
            Logger.getLogger(ModelTabeleLekovi.class.getName()).log(Level.SEVERE, null, ex);
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
        Lek l = lista.get(row); //izmeniti

        switch (column) {
            case 0:
                return l.getLekID();
            case 1:
                return l.getNazivLeka();
            case 2:
                return l.getProdajnaCena();
            default:
                return null;
        }
    }

    public Lek getSelectedLek(int row) {
        return lista.get(row);
    }

    public void setParametar(String parametar) {
        this.parametar = parametar;
        refreshTable();
    }

    public void refreshTable() {
        try {
            if (!parametar.equals("")) {
                ArrayList<Lek> novaLista = new ArrayList<>();
                for (Lek l : lista) { 
                    if (l.getNazivLeka().toLowerCase().contains(parametar.toLowerCase())) {
                        novaLista.add(l);
                    }
                }
                lista = novaLista;
                if(novaLista.size()>0){
                    PretragaLekova.setPoruka("Sistem je pronasao lekove po zadatoj vrednosti");
                }
                else{
                    PretragaLekova.setPoruka("Sistem nije pronasao lekove po zadatoj vrednosti");
                }
            }

            fireTableDataChanged();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
