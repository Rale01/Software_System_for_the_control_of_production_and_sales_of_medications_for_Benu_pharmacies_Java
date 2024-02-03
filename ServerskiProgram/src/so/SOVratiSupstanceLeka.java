/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.SupstancaLeka;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 *
 */
public class SOVratiSupstanceLeka extends ApstraktnaSO {

    private ArrayList<SupstancaLeka> lista;

    public ArrayList<SupstancaLeka> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws Exception, SQLException {
        ArrayList<ApstraktniObjekat> sups = DBBroker.getInstance().select(ado);
        lista = (ArrayList<SupstancaLeka>) (ArrayList<?>) sups;
    }

}
