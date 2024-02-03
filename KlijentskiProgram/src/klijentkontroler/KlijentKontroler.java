/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package klijentkontroler;

import domenskeKlase.Farmaceut;
import domenskeKlase.Kupac;
import domenskeKlase.Lek;
import domenskeKlase.ProdajaLekova;
import domenskeKlase.StavkaProdaje;
import domenskeKlase.Supstanca;
import domenskeKlase.SupstancaLeka;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import sesija.Sesija;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer_operacije.StatusOdgovora;
import transfer_operacije.Operacije_radna_memorija;

/**
 *
 * @author Rastko
 */
public class KlijentKontroler {

    private static KlijentKontroler instance;

    public KlijentKontroler() {
    }

    public static KlijentKontroler getInstance() {
        if (instance == null) {
            instance = new KlijentKontroler();
        }
        return instance;
    }

    private Object sendRequest(int operation, Object data) throws Exception {
        KlijentskiZahtev req = new KlijentskiZahtev(operation, data);
        ObjectOutputStream out = new ObjectOutputStream(Sesija.getInstance().getSocket().getOutputStream());
        out.writeObject(req);
        
        ObjectInputStream in = new ObjectInputStream(Sesija.getInstance().getSocket().getInputStream());
        ServerskiOdgovor res = (ServerskiOdgovor) in.readObject();
        if (res.getResponseStatus().equals(StatusOdgovora.Error)) {
            throw res.getError();
        } else {
            return res.getData();
        }
    }

    public Farmaceut login(Farmaceut f) throws Exception {
        return (Farmaceut) sendRequest(Operacije_radna_memorija.LOGIN, f);
    }

    public ArrayList<Supstanca> vratiSupstance() throws Exception {
        return (ArrayList<Supstanca>) sendRequest(Operacije_radna_memorija.VRATI_SUPSTANCE, null);
    }

    public void sacuvajLek(Lek l) throws Exception {
        sendRequest(Operacije_radna_memorija.SACUVAJ_LEK, l);
    }

    public ArrayList<Lek> vratiLekove() throws Exception {
        return (ArrayList<Lek>) sendRequest(Operacije_radna_memorija.VRATI_LEKOVE, null);
    }

    public void izmeniLek(Lek l) throws Exception {
        sendRequest(Operacije_radna_memorija.IZMENI_LEK, l);
    }

    public void obrisiLek(Lek l) throws Exception {
        sendRequest(Operacije_radna_memorija.OBRISI_LEK, l);
    }

    public ArrayList<SupstancaLeka> vratiSupstanceLeka(Lek l) throws Exception {
        return (ArrayList<SupstancaLeka>) sendRequest(Operacije_radna_memorija.VRATI_SUPSTANCE_LEKA, l);
    }

    public ArrayList<Kupac> vratiKupce() throws Exception {
        return (ArrayList<Kupac>) sendRequest(Operacije_radna_memorija.VRATI_KUPCE, null);
    }

    public void sacuvajProdaju(ProdajaLekova pl) throws Exception {
        sendRequest(Operacije_radna_memorija.SACUVAJ_PRODAJU, pl);
    }

    public void sacuvajKupca(Kupac k) throws Exception {
        sendRequest(Operacije_radna_memorija.SACUVAJ_KUPCA, k);
    }

    public void izmeniKupca(Kupac k) throws Exception {
        sendRequest(Operacije_radna_memorija.IZMENI_KUPCA, k);
    }

    public ArrayList<ProdajaLekova> vratiProdajeKonkretnogLeka(Lek l) throws Exception {
        return (ArrayList<ProdajaLekova>) sendRequest(Operacije_radna_memorija.VRATI_PRODAJE_KONKRETNOG_LEKA
          , l);
    }

    public ArrayList<StavkaProdaje> vratiStavkeProdaje(Lek l) throws Exception {
        return (ArrayList<StavkaProdaje>) sendRequest(Operacije_radna_memorija.VRATI_STAVKE_PRODAJE
          , l);
    }

    public ArrayList<StavkaProdaje> vratiSveStavke() throws Exception {
        return (ArrayList<StavkaProdaje>) sendRequest(Operacije_radna_memorija.VRATI_SVE_STAVKE, null);
        
    }

}
