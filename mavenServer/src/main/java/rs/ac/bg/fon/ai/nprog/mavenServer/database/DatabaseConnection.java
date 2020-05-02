/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;

/**
 *
 * @author Ivona
 */
public class DatabaseConnection {

    private Connection connection;
    private static DatabaseConnection instance;

    private DatabaseConnection() throws SQLException {
        String url = Configuration.getInstance().getUrl();
        String user = Configuration.getInstance().getUsername();
        String password = Configuration.getInstance().getPassword();
        connection = DriverManager.getConnection(url, user, password);
        connection.setAutoCommit(false);
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public void closeConnection() {
        try {
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Can't close connection.");
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void commit() throws SQLException {
        connection.commit();
    }

    public void rollback() throws SQLException {
        connection.rollback();
    }

}
