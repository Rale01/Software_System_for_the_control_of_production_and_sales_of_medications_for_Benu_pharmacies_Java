/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package so;

import broker.DBBroker;
import domenskeKlase.ApstraktniObjekat;

/**
 *
 * @author Rastko
 */

//commit i rollback bacaju SQLException-e
public abstract class ApstraktnaSO {

    public void templateExecute(ApstraktniObjekat ado) throws Exception {
        try {
            validate(ado);
            execute(ado);
            commit();
        } catch (Exception e) {
            rollback();
            throw e;
        }
    }

    protected abstract void validate(ApstraktniObjekat ado) throws Exception;

    protected abstract void execute(ApstraktniObjekat ado) throws Exception;

    public void commit() throws Exception {
        DBBroker.getInstance().getConnection().commit();
    }

    public void rollback() throws Exception {
        DBBroker.getInstance().getConnection().rollback();
    }
}
