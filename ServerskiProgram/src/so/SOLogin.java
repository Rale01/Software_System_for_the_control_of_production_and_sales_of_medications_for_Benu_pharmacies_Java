/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;
import domenskeKlase.Farmaceut;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 *
 */
public class SOLogin extends ApstraktnaSO {

    private Farmaceut f;

    public Farmaceut getF() {
        return f;
    }

    @Override
    protected void validate(ApstraktniObjekat ado) throws Exception {
            Farmaceut farmaceut = (Farmaceut) ado;
            String username = farmaceut.getKorisnickoIme();
            String password = farmaceut.getLozinka();
            
            if (username.isEmpty() || password.isEmpty()) {
                throw new Exception("Molimo Vas, unesite Vasu "
                        + "lozinku i korisnicko ime!");
            }
            
             if(password.length() < 5){
                throw new Exception("Molimo Vas, unesite Vasu "
                        + "lozinku tako da ima minimum 5 karaktera!");
            }
        
            if(!username.matches("[A-Za-z]+[0-9]{2}$")){
                throw new Exception("Molimo Vas, unesite Vase "
                        + "korisnicko ime tako da pocinje slovima a zavrsava se sa dva broja!");
            }
            
            
            if(!password.matches(".*[0-9]+.*")){
                throw new Exception( "Molimo Vas, unesite Vasu "
                        + "lozinku tako da sadrzi bar jedan broj!");
            }
            if(!password.matches(".*[a-z]+.*")){
               throw new Exception( "Molimo Vas, unesite Vasu "
                        + "lozinku tako da sadrzi bar jedno malo slovo!");
            }
            if(!password.matches(".*[A-Z]+.*")){
               throw new Exception( "Molimo Vas, unesite Vasu "
                        + "lozinku tako da sadrzi bar jedno veliko slovo!");
            }
    }

    @Override
    protected void execute(ApstraktniObjekat ado) throws Exception, SQLException {
        
        ArrayList<ApstraktniObjekat> farm = DBBroker.getInstance().selectBezUslova(ado);
        ArrayList<Farmaceut> lista = (ArrayList<Farmaceut>) (ArrayList<?>) farm;
        
        Farmaceut farmaceutAdo = (Farmaceut) ado;

        for (Farmaceut farmaceut : lista) {
            if (farmaceut.getKorisnickoIme().equals(farmaceutAdo.getKorisnickoIme())
                    && farmaceut.getLozinka().equals(farmaceutAdo.getLozinka())) {
                f = farmaceut;
                return;
            }
        }

    }

}
