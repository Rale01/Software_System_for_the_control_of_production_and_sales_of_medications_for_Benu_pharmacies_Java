/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Lek;
import domenskeKlase.ProdajaLekova;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class SOVratiProdajeKonkretnogLeka extends ApstraktnaSO{
    
    private ArrayList<ProdajaLekova> lista;

    public ArrayList<ProdajaLekova> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws Exception {
        ArrayList<ApstraktniObjekat> prodajeKonkretnogLeka=DBBroker.getInstance().select(ado);
        lista=(ArrayList<ProdajaLekova>)(ArrayList<?>) prodajeKonkretnogLeka;
    }
    
}
