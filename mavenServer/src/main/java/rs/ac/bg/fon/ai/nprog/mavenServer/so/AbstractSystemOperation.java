/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.so;

import rs.ac.bg.fon.ai.nprog.mavenServer.database.DBBroker;
import rs.ac.bg.fon.ai.nprog.mavenServer.database.DatabaseConnection;
import java.util.List;

/**
 *
 * @author Ivona
 */
public abstract class AbstractSystemOperation {

    protected DBBroker dbb;

    public AbstractSystemOperation() {
        dbb = new DBBroker();

    }

    public final void executeOperation(Object object, List<String> columns, List<String> values) throws Exception {
        try {
            validate(object);
            DatabaseConnection.getInstance().getConnection().setAutoCommit(false);
            executeSpecificOperation(object, columns, values);
            DatabaseConnection.getInstance().getConnection().commit();
        } catch (Exception ex) {
            DatabaseConnection.getInstance().getConnection().rollback();
            throw ex;

        }
    }

    protected abstract void executeSpecificOperation(Object object, List<String> columns, List<String> values) throws Exception;

    protected abstract void validate(Object object) throws Exception;
}
