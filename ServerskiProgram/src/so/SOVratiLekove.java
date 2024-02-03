/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Lek;
import java.sql.SQLException;
import java.util.ArrayList;


/**
 *
 * 
 */
public class SOVratiLekove extends ApstraktnaSO{
    private ArrayList<Lek> lista;

    public ArrayList<Lek> getLista() {
        return lista;
    }
    
    
    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws Exception, SQLException {
        ArrayList<ApstraktniObjekat> lekovi=DBBroker.getInstance().selectBezUslova(ado);
        lista=(ArrayList<Lek>)(ArrayList<?>) lekovi;
    }

}
