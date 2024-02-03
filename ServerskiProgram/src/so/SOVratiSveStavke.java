/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.StavkaProdaje;
import java.util.ArrayList;

public class SOVratiSveStavke extends ApstraktnaSO {

    private ArrayList<StavkaProdaje> lista;

    public ArrayList<StavkaProdaje> getLista() {
        return lista;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {

    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws Exception {
        ArrayList<ApstraktniObjekat> spovi = DBBroker.getInstance().selectBezUslova(ado);
        lista = (ArrayList<StavkaProdaje>) (ArrayList<?>) spovi;
    }
}
