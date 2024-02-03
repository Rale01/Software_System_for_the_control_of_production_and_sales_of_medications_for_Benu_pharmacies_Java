/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenskeKlase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 *
 */
public class Lek extends ApstraktniObjekat {

    private int lekID;
    private String nazivLeka;
    private int prodajnaCena;
    private String napomena;
    private ArrayList<SupstancaLeka> lista;

    public Lek() {
    }

    public Lek(int lekID, String nazivLeka, int prodajnaCena, String napomena, ArrayList<SupstancaLeka> lista) {
        this.lekID = lekID;
        this.nazivLeka = nazivLeka;
        this.prodajnaCena = prodajnaCena;
        this.napomena = napomena;
        this.lista = lista;
    }

    @Override
    public String nazivTabele() {
        return "lek";
    }

    @Override
    public String alijas() {
        return "l";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Lek l = new Lek(rs.getInt("LekID"), rs.getString("NazivLeka"), rs.getInt("ProdajnaCena"), rs.getString("Napomena"), null);
            lista.add(l);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(NazivLeka, ProdajnaCena, Napomena)";
    }

    @Override
    public String primarniKljuc() {
        return "lekid=" + lekID;
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + nazivLeka + "'," + prodajnaCena + ",'" + napomena + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "NazivLeka='" + nazivLeka + "',ProdajnaCena=" + prodajnaCena + ",Napomena='" + napomena + "'";
    }

    @Override
    public String id() {
        return "lekid=" + lekID;
    }

    public int getLekID() {
        return lekID;
    }

    public void setLekID(int lekID) {
        this.lekID = lekID;
    }

    public String getNazivLeka() {
        return nazivLeka;
    }

    public void setNazivLeka(String nazivLeka) {
        this.nazivLeka = nazivLeka;
    }

    public int getProdajnaCena() {
        return prodajnaCena;
    }

    public void setProdajnaCena(int prodajnaCena) {
        this.prodajnaCena = prodajnaCena;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public ArrayList<SupstancaLeka> getLista() {
        return lista;
    }

    public void setLista(ArrayList<SupstancaLeka> lista) {
        this.lista = lista;
    }

    @Override
    public String toString() {
        return "Naziv: " + nazivLeka + " Cena: " + prodajnaCena;
    }

}
