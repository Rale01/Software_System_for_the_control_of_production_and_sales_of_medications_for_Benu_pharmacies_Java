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
public class StavkaProdaje extends ApstraktniObjekat {

    private int rb;
    private int kolicina;
    private ProdajaLekova prodaja;
    private Lek lek;

    public StavkaProdaje(int rb, int kolicina, ProdajaLekova prodaja, Lek lek) {
        this.rb = rb;
        this.kolicina = kolicina;
        this.prodaja = prodaja;
        this.lek = lek;
    }

    public StavkaProdaje() {
        
    }

    @Override
    public String nazivTabele() {
        return "stavkaprodaje";
    }

    @Override
    public String alijas() {
        return "";
    }

    @Override
    public String spajanje() {
        return "JOIN stavkaprodaje sp "
                + "JOIN lek l ON(sp.lekid = l.lekid) JOIN prodajalekova p ON(sp.prodajaid = p.prodajaid)";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            ProdajaLekova p = new ProdajaLekova(rs.getInt("ProdajaID"), rs.getTimestamp("DatumVremeProdaje"), rs.getString("Napomena"), rs.getInt("UkupnaKolicina"), rs.getInt("UkupnaCena"), null, null, null);
            Lek l = new Lek(rs.getInt("LekID"), rs.getString("NazivLeka"), rs.getInt("ProdajnaCena"), rs.getString("Napomena"), null);
            StavkaProdaje sp = new StavkaProdaje(rs.getInt("Rb"), rs.getInt("UkupnaKolicina"),
                    p, l);
            lista.add(sp);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(ProdajaID, Rb, KolicinaLeka, LekID)";
    }

    @Override
    public String primarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaInsert() {
        return prodaja.getProdajaID() + "," + rb + "," + kolicina + "," + lek.getLekID();
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


    public int getRb() {
        return rb;
    }

    public void setRb(int rb) {
        this.rb = rb;
    }

    public int getKolicina() {
        return kolicina;
    }

    public void setKolicina(int kolicina) {
        this.kolicina = kolicina;
    }

    public ProdajaLekova getProdaja() {
        return prodaja;
    }

    public void setProdaja(ProdajaLekova prodaja) {
        this.prodaja = prodaja;
    }

    public Lek getLek() {
        return lek;
    }

    public void setLek(Lek lek) {
        this.lek = lek;
    }
    
    
    @Override
    public String id() {
        return "l.lekid = " + lek.getLekID();
    }


}
