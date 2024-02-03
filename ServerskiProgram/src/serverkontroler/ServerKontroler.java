/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverkontroler;

import domenskeKlase.Farmaceut;
import domenskeKlase.Kupac;
import domenskeKlase.Lek;
import domenskeKlase.ProdajaLekova;
import domenskeKlase.StavkaProdaje;
import domenskeKlase.Supstanca;
import domenskeKlase.SupstancaLeka;
import java.util.ArrayList;
import so.SOIzmeniKupca;
import so.SOIzmeniLek;
import so.SOLogin;
import so.SOObrisiLek;
import so.SOSacuvajKupca;
import so.SOSacuvajLek;
import so.SOSacuvajProdaju;
import so.SOVratiKupce;
import so.SOVratiLekove;
import so.SOVratiStavkeProdaje;
import so.SOVratiSupstance;
import so.SOVratiSupstanceLeka;

/**
 *
 * @author Rastko
 */
public class ServerKontroler {

    private static ServerKontroler instance;

    public ServerKontroler() {
    }

    public static ServerKontroler getInstance() {
        if (instance == null) {
            instance = new ServerKontroler();
        }
        return instance;
    }

    public void izmeniKupca(Kupac kupac) throws Exception {
        SOIzmeniKupca so = new SOIzmeniKupca();
        so.templateExecute(kupac);
    }

    public void izmeniLek(Lek lek) throws Exception {
        SOIzmeniLek so = new SOIzmeniLek();
        so.templateExecute(lek);
    }

    public Farmaceut login(Farmaceut farmaceut) throws Exception {
        SOLogin so = new SOLogin();
        so.templateExecute(farmaceut);
        return so.getF();
    }

    public void obrisiLek(Lek lek) throws Exception {
        SOObrisiLek so = new SOObrisiLek();
        so.templateExecute(lek);

    }

    public void sacuvajKupca(Kupac kupac) throws Exception {
        SOSacuvajKupca so = new SOSacuvajKupca();
        so.templateExecute(kupac);
    }

    public void sacuvajLek(Lek lek) throws Exception {
        SOSacuvajLek so = new SOSacuvajLek();
        so.templateExecute(lek);
    }

    public void sacuvajProdaju(ProdajaLekova prodajaLekova) throws Exception {
        SOSacuvajProdaju so = new SOSacuvajProdaju();
        so.templateExecute(prodajaLekova);
    }

    public ArrayList<Kupac> vratiKupce() throws Exception {
        SOVratiKupce so = new SOVratiKupce();
        so.templateExecute(new Kupac());
        return so.getLista();
    }

    public ArrayList<Lek> vratiLekove() throws Exception {
        SOVratiLekove so = new SOVratiLekove();
        so.templateExecute(new Lek());
        return so.getLista();
    }

    public ArrayList<Supstanca> vratiSupstance() throws Exception {
        SOVratiSupstance so = new SOVratiSupstance();
        so.templateExecute(new Supstanca());
        return so.getLista();
    }

    public ArrayList<SupstancaLeka> vratiSupstanceLeka(Lek lek) throws Exception {
        SupstancaLeka sl = new SupstancaLeka();
        sl.setLek(lek);
        SOVratiSupstanceLeka so = new SOVratiSupstanceLeka();
        so.templateExecute(sl);
        return so.getLista();
    }

  

    public ArrayList<StavkaProdaje> vratiSveStavke() throws Exception {
        SOVratiStavkeProdaje so= new SOVratiStavkeProdaje();
        so.templateExecute(new StavkaProdaje());
        return so.getLista();
    }


}
