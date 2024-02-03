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
public class SupstancaLeka extends ApstraktniObjekat {

    private int rb;
    private int kolicina;
    private Lek lek;
    private Supstanca supstanca;

    public SupstancaLeka() {
    }

    public SupstancaLeka(int rb, int kolicina, Lek lek, Supstanca supstanca) {
        this.rb = rb;
        this.kolicina = kolicina;
        this.lek = lek;
        this.supstanca = supstanca;
    }

    @Override
    public String nazivTabele() {
        return "supstancaleka";
    }

    @Override
    public String alijas() {
        return "sl";
    }

    @Override
    public String spajanje() {
        return "JOIN supstanca s using (supstancaid)"
                + "JOIN lek l using(lekid)";
    }

    @Override
    public ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException {
        ArrayList<ApstraktniObjekat> lista = new ArrayList<>();
        while (rs.next()) {
            Lek l = new Lek(rs.getInt("LekID"), rs.getString("NazivLeka"), rs.getInt("ProdajnaCena"), rs.getString("Napomena"), null);
            Supstanca s = new Supstanca(rs.getInt("SupstancaID"), rs.getString("NazivSupstance"), rs.getString("AgregatnoStanje"));
            SupstancaLeka sl = new SupstancaLeka(rs.getInt("Rb"), rs.getInt("Kolicina"), l, s);
            lista.add(sl);
        }
        rs.close();
        return lista;
    }

    @Override
    public String koloneZaInsert() {
        return "(Rb, Kolicina, LekID, SupstancaID)";
    }

    @Override
    public String primarniKljuc() {
         return " lekid=" + lek.getLekID();
    }

    @Override
    public String vrednostiZaInsert() {
        return rb + "," + kolicina + "," + lek.getLekID() + "," + supstanca.getSupstancaID();
    }

    @Override
    public String vrednostiZaUpdate() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public String id() {
        return "l.lekid=" + lek.getLekID();
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

    public Lek getLek() {
        return lek;
    }

    public void setLek(Lek lek) {
        this.lek = lek;
    }

    public Supstanca getSupstanca() {
        return supstanca;
    }

    public void setSupstanca(Supstanca supstanca) {
        this.supstanca = supstanca;
    }

}
