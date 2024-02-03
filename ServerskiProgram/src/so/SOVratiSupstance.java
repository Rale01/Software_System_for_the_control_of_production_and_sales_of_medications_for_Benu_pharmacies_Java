/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Supstanca;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 *
 */
public class SOVratiSupstance extends ApstraktnaSO {

    ArrayList<Supstanca> lista;

    public ArrayList<Supstanca> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws Exception, SQLException {
        ArrayList<ApstraktniObjekat> sups = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<Supstanca>) (ArrayList<?>) sups;
    }

}
