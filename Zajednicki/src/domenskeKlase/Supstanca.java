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
public class Supstanca extends ApstraktniObjekat {

    private int supstancaID;
    private String nazivSupstance;
    private String agregatnoStanje;

    public Supstanca() {
    }

    public Supstanca(int supstancaID, String nazivSupstance, String agregatnoStanje) {
        this.supstancaID = supstancaID;
        this.nazivSupstance = nazivSupstance;
        this.agregatnoStanje = agregatnoStanje;
    }

    @Override
    public String toString() {
        return nazivSupstance;
    }

    @Override
    public String nazivTabele() {
        return "supstanca";
    }

    @Override
    public String alijas() {
        return "";
    }

    @Override
    public String spajanje() {
        return "";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista=new ArrayList<>();
        while(rs.next()){
            Supstanca s=new Supstanca(rs.getInt("SupstancaID"), rs.getString("NazivSupstance"), rs.getString("AgregatnoStanje"));
            lista.add(s);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "";
    }

    @Override
    public String primarniKljuc() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaInsert() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String id() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getSupstancaID() {
        return supstancaID;
    }

    public void setSupstancaID(int supstancaID) {
        this.supstancaID = supstancaID;
    }

    public String getNazivSupstance() {
        return nazivSupstance;
    }

    public void setNazivSupstance(String nazivSupstance) {
        this.nazivSupstance = nazivSupstance;
    }

    public String getAgregatnoStanje() {
        return agregatnoStanje;
    }

    public void setAgregatnoStanje(String agregatnoStanje) {
        this.agregatnoStanje = agregatnoStanje;
    }

}
