/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package niti;

import domenskeKlase.Farmaceut;
import domenskeKlase.Kupac;
import domenskeKlase.Lek;
import domenskeKlase.ProdajaLekova;
import domenskeKlase.StavkaProdaje;
import domenskeKlase.Supstanca;
import domenskeKlase.SupstancaLeka;
import serverkontroler.ServerKontroler;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;
import transfer_operacije.StatusOdgovora;
import transfer_operacije.Operacije_radna_memorija;

/**
 *
 * @author Rastko
 */
public class ObradaZahteva extends Thread {

    private Socket socket;

    ObradaZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
                KlijentskiZahtev req = (KlijentskiZahtev) in.readObject();
                ServerskiOdgovor res = handleRequest(req);
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(res);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private ServerskiOdgovor handleRequest(KlijentskiZahtev req) {
        ServerskiOdgovor res = new ServerskiOdgovor(null, null, StatusOdgovora.Success);

        try {
            switch (req.getOperation()) {
                case Operacije_radna_memorija.IZMENI_KUPCA:
                    ServerKontroler.getInstance().izmeniKupca((Kupac) req.getData());
                    break;
                case Operacije_radna_memorija.IZMENI_LEK:
                    ServerKontroler.getInstance().izmeniLek((Lek) req.getData());
                    break;
                case Operacije_radna_memorija.LOGIN:
                    Farmaceut f = ServerKontroler.getInstance().login((Farmaceut) req.getData());
                    res.setData(f);
                    if (res.getData() == null) {
                        throw new Exception("Sistem ne moze da nadje farmaceuta po zadatim vrednostima");
                    } else {
                        break;
                    }
                case Operacije_radna_memorija.OBRISI_LEK:
                    ServerKontroler.getInstance().obrisiLek((Lek) req.getData());
                    break;
                case Operacije_radna_memorija.SACUVAJ_KUPCA:
                    ServerKontroler.getInstance().sacuvajKupca((Kupac) req.getData());
                    break;
                case Operacije_radna_memorija.SACUVAJ_LEK:
                    ServerKontroler.getInstance().sacuvajLek((Lek) req.getData());
                    break;
                case Operacije_radna_memorija.SACUVAJ_PRODAJU:
                    ServerKontroler.getInstance().sacuvajProdaju((ProdajaLekova) req.getData());
                    break;
                case Operacije_radna_memorija.VRATI_KUPCE:
                    ArrayList<Kupac> kupci = ServerKontroler.getInstance().vratiKupce();
                    res.setData(kupci);
                    break;
                case Operacije_radna_memorija.VRATI_LEKOVE:
                    ArrayList<Lek> lekovi = ServerKontroler.getInstance().vratiLekove();
                    res.setData(lekovi);
                    break;
                case Operacije_radna_memorija.VRATI_SUPSTANCE:
                    ArrayList<Supstanca> supstance = ServerKontroler.getInstance().vratiSupstance();
                    res.setData(supstance);
                    break;
                case Operacije_radna_memorija.VRATI_SUPSTANCE_LEKA:
                    ArrayList<SupstancaLeka> supsLek = ServerKontroler.getInstance().vratiSupstanceLeka((Lek) req.getData());
                    res.setData(supsLek);
                    break;
                
                case Operacije_radna_memorija.VRATI_SVE_STAVKE:
                    ArrayList<StavkaProdaje> sveStavke=ServerKontroler.getInstance().vratiSveStavke();
                    res.setData(sveStavke);
                    break;
                default:
                    return null;
            }
        } catch (Exception e) {
            res.setError(e);
            res.setResponseStatus(StatusOdgovora.Error);
        }
        return res;
    }
}
