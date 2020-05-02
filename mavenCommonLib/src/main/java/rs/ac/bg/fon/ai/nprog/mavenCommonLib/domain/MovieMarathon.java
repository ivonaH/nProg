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

/**
 *
 * @author Ivona
 */
public class MovieMarathon implements DomainObject, Serializable  {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int marathonId;
    private String name;
    private User user;

    public MovieMarathon() {
    }

    public MovieMarathon(int marathonId, String name, User user) {
        this.marathonId = marathonId;
        this.name = name;
        this.user = user;
    }

    public MovieMarathon(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public MovieMarathon(int movieMarathonId) {
        this.marathonId = movieMarathonId;
    }

    public int getMarathonId() {
        return marathonId;
    }

    public void setMarathonId(int marathonId) {
        this.marathonId = marathonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String getTableName() {
        return "MovieMarathon";
    }

    @Override
    public String getParameters() {
        return String.format("%s, '%s', %s", marathonId, name, user.getUserId());
    }

    @Override
    public String getParameterNames() {
        return "MarathonId, Name, UserId";
    }

    @Override
    public int getPrimaryKeyValue() {
        return marathonId;
    }

    @Override
    public String getPrimaryKeyName() {
        return "MarathonId";
    }

    @Override
    public List<DomainObject> convertRSList(ResultSet rs) {
        List<DomainObject> list = new ArrayList<>();
        try {
            while (rs.next()) {
                int marathonId = rs.getInt("MarathonId");
                String name = rs.getString("Name");
                int id = rs.getInt("UserId");

                list.add(new MovieMarathon(marathonId, name, new User(id)));
            }
        } catch (Exception ex) {
            System.out.println("ERROR ResultSet " + getTableName());
        }

        return list;
    }

    @Override
    public String getUpdateQuery() {
        return "MarathonId=" + marathonId;
    }

    @Override
    public String getJoinCondition() {
        return null;
    }

    @Override
    public String getSortCondition() {
        return "name";
    }

}
