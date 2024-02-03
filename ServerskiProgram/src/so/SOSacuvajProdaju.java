/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.ProdajaLekova;
import domenskeKlase.StavkaProdaje;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 *
 */
public class SOSacuvajProdaju extends ApstraktnaSO {

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
        ProdajaLekova pl = (ProdajaLekova) ado;
        if (pl.getLista().size() == 0) {
            throw new Exception("Prodaja mora imati barem jednu stavku!");
        }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws Exception, SQLException {
        ProdajaLekova pl=(ProdajaLekova) ado;
        PreparedStatement ps=DBBroker.getInstance().insert(ado);
        
        ResultSet rs=ps.getGeneratedKeys();
        
        rs.next();
        
        int prodajaID=rs.getInt(1);
        pl.setProdajaID(prodajaID);
        
        
        for (StavkaProdaje stavkaProdaje : pl.getLista()) {
            stavkaProdaje.setProdaja(pl);
            DBBroker.getInstance().insert(stavkaProdaje);
        }
        
    }

}
