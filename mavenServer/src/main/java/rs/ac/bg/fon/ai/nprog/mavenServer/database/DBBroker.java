/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.database;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.DomainObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

/**
 *
 * @author Ivona
 */
public class DBBroker {

    public List<DomainObject> getAllDomainObjects(domain.DomainObject o) throws Exception {
        String query = "SELECT * FROM " + o.getTableName()+" t ";
        if (o.getSortCondition() != null) {
            query += " ORDER BY " + o.getSortCondition();
        }
        if(o.getJoinCondition()!=null){
            query+=o.getJoinCondition();
        }
        System.out.println(query);
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<DomainObject> list = o.convertRSList(rs);
        statement.close();
        rs.close();
        return list;
    }

    public List<DomainObject> getAllDomainObjectsWithWhere(domain.DomainObject o, List<String> columns, List<String> values) throws Exception {
        String query = "SELECT * FROM " + o.getTableName();
        if (o.getJoinCondition() != null) {
            query += " t " + o.getJoinCondition();
        }
        int i = 0;
        query += " WHERE ";
        while (i != columns.size() - 1) {

            query += columns.get(i) + "='" + values.get(i) + "' AND ";
            System.out.println("PROCITAO : " + query);

            i++;
        }
        query += columns.get(i) + "=" + "'" + values.get(i) + "'";
        if (o.getSortCondition() != null) {
            query += " ORDER BY " + o.getSortCondition();
            System.out.println("SORT cond: "+o.getSortCondition());
        }
        System.out.println(query);
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<DomainObject> list = o.convertRSList(rs);
        statement.close();
        rs.close();
        return list;

    }

    public int countDomainObjectsWithWhere(domain.DomainObject o, String column, int value) throws Exception {
        int number = -1;

        String query = "SELECT COUNT(*) as number FROM " + o.getTableName();

        int i = 0;
        query += " WHERE " + column + "=" + value;
        System.out.println(query);
        Statement statement = DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            number = rs.getInt("number");
        }

        statement.close();
        rs.close();
        System.out.println("ResultSet OK izbrojao je:" + number);
        return number;

    }

    public DomainObject getDomainObjectByPrimaryKey(DomainObject o, int id) throws Exception {
        System.out.println("USAO U BAZU");
        String query;
        query = "SELECT * FROM " + o.getTableName() + " t";
        if (o.getJoinCondition() != null) {
            query += " " + o.getJoinCondition();
        }
        query += " WHERE " + o.getPrimaryKeyName() + "=" + id;
        System.out.println(query);
        Statement statement = (Statement) DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);
        List<DomainObject> list = o.convertRSList(rs);
        statement.close();
        rs.close();
        return list.get(0);
    }

    public void deleteDomainObject(DomainObject o) throws Exception {
        String query;

        query = "DELETE FROM " + o.getTableName() + " WHERE " + o.getPrimaryKeyName() + "=" + o.getPrimaryKeyValue();

        System.out.println(query);
        Statement s = DatabaseConnection.getInstance().getConnection().createStatement();
        s.executeUpdate(query);
        //DatabaseConnection.getInstance().getConnection().commit();
        s.close();
    }

    public void deleteDomainObjects(List<DomainObject> list) throws Exception {
        for (DomainObject o : list) {
            deleteDomainObject(o);
        }
    }

    public void saveDomainObject(DomainObject o) throws Exception {

        String query = "INSERT INTO " + o.getTableName() + "(" + o.getParameterNames() + ")" + " VALUES (" + o.getParameters() + ")";
        System.out.println(query);
        Statement s = DatabaseConnection.getInstance().getConnection().createStatement();
        s.executeUpdate(query);
        s.close();

    }

    public void updateDomainObjects(List<DomainObject> list, String column, String value) throws Exception {

        for (DomainObject o : list) {
            updateDomainObjectValue(o, column, value);
        }
    }

    public boolean updateDomainObject(DomainObject o) throws Exception {
        String query = "UPDATE " + o.getTableName() + " SET " + o.getUpdateQuery() + " WHERE " + o.getPrimaryKeyName() + "=" + o.getPrimaryKeyValue();
        System.out.println(query);
        Statement s = (Statement) DatabaseConnection.getInstance().getConnection().createStatement();
        s.executeUpdate(query);
        s.close();
        System.out.println("GOTOV update");
        return true;
    }

    public boolean updateDomainObjectValue(DomainObject o, String columnName, String value) throws Exception {
        String query = "UPDATE " + o.getTableName() + " SET " + columnName + "=" + value + " WHERE " + o.getPrimaryKeyName() + "=" + o.getPrimaryKeyValue();
        System.out.println(query);
        Statement s = (Statement) DatabaseConnection.getInstance().getConnection().createStatement();
        s.executeUpdate(query);
        s.close();
        System.out.println("GOTOV update");
        return true;
    }

    public int generateId(DomainObject o) throws SQLException {

        return maxId(o) + 1;

    }

    public int maxId(DomainObject o) throws SQLException {
        int max = -1;
        String query = "select max(" + o.getPrimaryKeyName() + ") from " + o.getTableName();
        System.out.println(query);
        Statement statement = (Statement) DatabaseConnection.getInstance().getConnection().createStatement();
        ResultSet rs = statement.executeQuery(query);
        while (rs.next()) {
            max = rs.getInt("max(" + o.getPrimaryKeyName() + ")");
        }
        statement.close();
        rs.close();
        return max;

    }

}
