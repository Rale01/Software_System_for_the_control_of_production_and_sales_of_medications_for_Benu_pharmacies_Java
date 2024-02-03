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
public class SOObrisiLek extends ApstraktnaSO {

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        
    }

    @Override
    protected void execute(ApstraktniObjekat ado)  throws Exception, SQLException{
        Lek l = (Lek) ado;
        SupstancaLeka sl = new SupstancaLeka();
        sl.setLek(l);
        DBBroker.getInstance().delete(sl);
        DBBroker.getInstance().delete(ado);
    }

}
