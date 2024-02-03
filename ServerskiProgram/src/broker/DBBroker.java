/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package broker;

import domenskeKlase.ApstraktniObjekat;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

/**
 *
 * @author Rastko
 */
public class DBBroker {

    private static DBBroker instance;
    private static Connection connection;
    private static Properties configFile;

    private DBBroker()  throws Exception{
        

            configFile = new Properties();
            
            configFile.load(new FileInputStream("setConfig.properties"));
            connection = DriverManager.getConnection(configFile.getProperty("url"), configFile.getProperty("username"), configFile.getProperty("password"));
            connection.setAutoCommit(false);
            
 

    }

    public static void setConfigFile(Properties configFile) {
        DBBroker.configFile = configFile;
    }

    public Connection getConnection() {
        return connection;
    }

    public static DBBroker getInstance()  throws Exception{
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public ArrayList<ApstraktniObjekat> select(ApstraktniObjekat ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.spajanje() + " WHERE " + ado.id() + " ";
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.selectLista(rs);
    }

    public PreparedStatement insert(ApstraktniObjekat ado) throws SQLException {
        String upit = "INSERT INTO " + ado.nazivTabele() + " "
                + ado.koloneZaInsert() + " VALUES(" + ado.vrednostiZaInsert() + ")";
        System.out.println(upit);
        PreparedStatement ps = connection.prepareStatement(upit, Statement.RETURN_GENERATED_KEYS);
        ps.executeUpdate();
        return ps;
    }

    public void update(ApstraktniObjekat ado) throws SQLException {
        String upit = "UPDATE " + ado.nazivTabele() + " SET "
                + ado.vrednostiZaUpdate() + " WHERE " + ado.id();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public void delete(ApstraktniObjekat ado) throws SQLException {
        String upit = "DELETE FROM " + ado.nazivTabele() + " WHERE " + ado.primarniKljuc();
        System.out.println(upit);
        Statement s = connection.createStatement();
        s.executeUpdate(upit);
    }

    public ArrayList<ApstraktniObjekat> selectBezUslova(ApstraktniObjekat ado) throws SQLException {
        String upit = "SELECT * FROM " + ado.nazivTabele() + " " + ado.alijas()
                + " " + ado.spajanje();
        System.out.println(upit);
        Statement s = connection.createStatement();
        ResultSet rs = s.executeQuery(upit);
        return ado.selectLista(rs);
    }


}
