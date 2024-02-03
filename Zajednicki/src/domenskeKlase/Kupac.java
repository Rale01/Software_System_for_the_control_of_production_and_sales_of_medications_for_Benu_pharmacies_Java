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
public class Kupac extends ApstraktniObjekat {

    private int kupacID;
    private String imePrezimeKupca;
    private String kontakt;

    public Kupac() {
    }

    public Kupac(int kupacID, String imePrezimeKupca, String kontakt) {
        this.kupacID = kupacID;
        this.imePrezimeKupca = imePrezimeKupca;
        this.kontakt = kontakt;
    }

    @Override
    public String toString() {
        return imePrezimeKupca;
    }

    @Override
    public String nazivTabele() {
        return "kupac";
    }

    @Override
    public String alijas() {
        return "k";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Kupac k = new Kupac(rs.getInt("KupacID"), rs.getString("ImePrezimeKupca"), rs.getString("Kontakt"));
            lista.add(k);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(ImePrezimeKupca,Kontakt)";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + imePrezimeKupca + "','" + kontakt + "'";
    }

    @Override
    public String vrednostiZaUpdate() {
        return "ImePrezimeKupca='" + imePrezimeKupca + "',Kontakt='" + kontakt + "'";
    }

    @Override
    public String id() {
        return "kupacid=" + kupacID;
    }

    public int getKupacID() {
        return kupacID;
    }

    public void setKupacID(int kupacID) {
        this.kupacID = kupacID;
    }

    public String getImePrezimeKupca() {
        return imePrezimeKupca;
    }

    public void setImePrezimeKupca(String imePrezimeKupca) {
        this.imePrezimeKupca = imePrezimeKupca;
    }

    public String getKontakt() {
        return kontakt;
    }

    public void setKontakt(String kontakt) {
        this.kontakt = kontakt;
    }

}
