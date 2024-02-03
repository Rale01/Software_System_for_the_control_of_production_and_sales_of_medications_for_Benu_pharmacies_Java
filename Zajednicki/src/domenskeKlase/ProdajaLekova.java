/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domenskeKlase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 *
 */
public class ProdajaLekova extends ApstraktniObjekat {

    private int prodajaID;
    private Date datumVremeProdaje;
    private String napomena;
    private int ukupnaKolicina;
    private int ukupnaCena;
    private Farmaceut farmaceut;
    private Kupac kupac;
    private ArrayList<StavkaProdaje> lista;

    public ProdajaLekova() {
    }

    public ProdajaLekova(int prodajaID, Date datumVremeProdaje, String napomena, int ukupnaKolicina, int ukupnaCena, Farmaceut farmaceut, Kupac kupac, ArrayList<StavkaProdaje> lista) {
        this.prodajaID = prodajaID;
        this.datumVremeProdaje = datumVremeProdaje;
        this.napomena = napomena;
        this.ukupnaKolicina = ukupnaKolicina;
        this.ukupnaCena = ukupnaCena;
        this.farmaceut = farmaceut;
        this.kupac = kupac;
        this.lista = lista;
    }

    @Override
    public String nazivTabele() {
        return "prodajalekova";
    }

    @Override
    public String alijas() {
        return "pl";
    }

    @Override
    public String spajanje() {
        return "JOIN kupac k using(kupacid)"
                + "JOIN farmaceut f using(farmaceutid)";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Farmaceut f = new Farmaceut(rs.getInt("FarmaceutID"), rs.getString("korisnickoIme"), rs.getString("Lozinka"));
            Kupac k = new Kupac(rs.getInt("KupacID"), rs.getString("ImePrezimeKupca"), rs.getString("Kontakt"));
            ProdajaLekova pl = new ProdajaLekova(rs.getInt("ProdajaID"), rs.getTime("DatumVremeProdje"), rs.getString("Napomena"), rs.getInt("UkupnaKolicina"), rs.getInt("UkupnaCena"), f, k, null);
            lista.add(pl);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(DatumVremeProdaje, Napomena, UkupnaKolicina, UkupnaCena, FarmaceutID, KupacID)";
    }

    @Override
    public String primarniKljuc() {
        return "";
    }

    @Override
    public String vrednostiZaInsert() {
        return "'" + new Timestamp(datumVremeProdaje.getTime()) + "','" + napomena + "'," + ukupnaKolicina + "," + ukupnaCena + "," + farmaceut.getFarmaceutID() + "," + kupac.getKupacID();
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String id() {
        return "";
    }

    public int getProdajaID() {
        return prodajaID;
    }

    public void setProdajaID(int prodajaID) {
        this.prodajaID = prodajaID;
    }

    public Date getDatumVremeProdaje() {
        return datumVremeProdaje;
    }

    public void setDatumVremeProdaje(Date datumVremeProdaje) {
        this.datumVremeProdaje = datumVremeProdaje;
    }

    public String getNapomena() {
        return napomena;
    }

    public void setNapomena(String napomena) {
        this.napomena = napomena;
    }

    public int getUkupnaKolicina() {
        return ukupnaKolicina;
    }

    public void setUkupnaKolicina(int ukupnaKolicina) {
        this.ukupnaKolicina = ukupnaKolicina;
    }

    public int getUkupnaCena() {
        return ukupnaCena;
    }

    public void setUkupnaCena(int ukupnaCena) {
        this.ukupnaCena = ukupnaCena;
    }

    public Farmaceut getFarmaceut() {
        return farmaceut;
    }

    public void setFarmaceut(Farmaceut farmaceut) {
        this.farmaceut = farmaceut;
    }

    public Kupac getKupac() {
        return kupac;
    }

    public void setKupac(Kupac kupac) {
        this.kupac = kupac;
    }

    public ArrayList<StavkaProdaje> getLista() {
        return lista;
    }

    public void setLista(ArrayList<StavkaProdaje> lista) {
        this.lista = lista;
    }

}
