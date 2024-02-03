/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Lek;
import domenskeKlase.SupstancaLeka;
import java.sql.SQLException;

/**
 *
 *
 */
public class SOIzmeniLek extends ApstraktnaSO {

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        Lek l = (Lek) ado;

        if (l.getLista().size() == 0) {
            throw new Exception("Lek mora imati barem jednu supstancu!");
        }
        if (l.getProdajnaCena() <= 0) {
            throw new Exception("Prodajna cena mora biti veca od 0");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws Exception, SQLException {

        Lek l = (Lek) ado;
        DBBroker.getInstance().update(ado);
        SupstancaLeka sl = new SupstancaLeka();
        sl.setLek(l);
        DBBroker.getInstance().delete(sl);
        for (SupstancaLeka supstancaLeka : l.getLista()) {
            supstancaLeka.setLek(l);
            DBBroker.getInstance().insert(supstancaLeka);
        }
    }

}
