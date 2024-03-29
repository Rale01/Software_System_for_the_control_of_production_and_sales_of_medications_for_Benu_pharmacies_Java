/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domenskeKlase;

import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Rastko
 */
public abstract class ApstraktniObjekat implements Serializable {
    
    public abstract String nazivTabele();
    public abstract String alijas();
    public abstract String spajanje();
    public abstract ArrayList<ApstraktniObjekat> selectLista(ResultSet rs) throws SQLException;
    public abstract String koloneZaInsert();
    public abstract String primarniKljuc();
    public abstract String vrednostiZaInsert();
    public abstract String vrednostiZaUpdate();
    public abstract String id();
    
}
