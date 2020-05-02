/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Ivona
 */
public class User implements DomainObject, Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int userId;
    private String username;
    private String name;
    private String lastname;
    private String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(int userId, String username, String name, String lastname, String password) {
        this.userId = userId;
        this.username = username;
        this.name = name;
        this.lastname = lastname;
        this.password = password;
    }

   public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String getTableName() {
        return "user";
    }

    @Override
    public String getParameters() {
        return String.format("%s, '%s','%s','%s','%s'", userId, username, password, name, lastname);
    }

    @Override
    public String getParameterNames() {
        return "UserId,Username,Password,Name,Lastname";
    }

    @Override
    public int getPrimaryKeyValue() {
        return userId;
    }

    @Override
    public String getPrimaryKeyName() {
        return "userId";
    }

    @Override
    public List<DomainObject> convertRSList(ResultSet rs) {
        List<DomainObject> users = new ArrayList<>();
        try {
            while (rs.next()) {
                int userId = rs.getInt("UserId");
                String username = rs.getString("Username");
                String password = rs.getString("Password");
                String name = rs.getString("Name");
                String lastname = rs.getString("Lastname");

                users.add(new User(userId, username, name, lastname, password));
            }
        } catch (Exception ex) {
            System.out.println("ERROR ResultSet User");
        }
        return users;
    }

    @Override
    public String getUpdateQuery() {
        return "UserId="+userId+", Username='"+username+"', Password='"+password+"', Name='"+name+"', Lastname='"+lastname+"'";
    }

    @Override
    public String getJoinCondition() {
        return null;
    }

    @Override
    public String getSortCondition() {
       return null; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }


}
