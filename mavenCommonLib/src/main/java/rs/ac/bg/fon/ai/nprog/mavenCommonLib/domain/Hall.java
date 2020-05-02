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
public class Hall implements DomainObject, Serializable  {

	private static final long serialVersionUID = 1L;
	private int hallId;
    private String name;
    private int capacity;

    public Hall(int hallId, String name, int capacity) {
        this.hallId = hallId;
        this.name = name;
        this.capacity = capacity;
    }

    public Hall() {
    }

    Hall(int hallId) {
        this.hallId = hallId;
    }

    public int getHallId() {
        return hallId;
    }

    public void setHallId(int hallId) {
        this.hallId = hallId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String getTableName() {
        return "Hall";
    }

    @Override
    public String getParameters() {
        return String.format("%s, '%s',%s", hallId, name, capacity);
    }

    @Override
    public String getParameterNames() {
        return "HallId, Name, Capacity";
    }

    @Override
    public int getPrimaryKeyValue() {
        return hallId;
    }

    @Override
    public String getPrimaryKeyName() {
        return "HallId";
    }

    @Override
    public String getUpdateQuery() {
        return "HallId=" + hallId + ", Name='" + name + "', Capacity=" + capacity;
    }

    @Override
    public List<DomainObject> convertRSList(ResultSet rs) {
        List<DomainObject> halls = new ArrayList<>();
        try {
            while (rs.next()) {
                int hallId = rs.getInt("HallId");
                String name = rs.getString("Name");
                int capacity = rs.getInt("Capacity");

                halls.add(new Hall(hallId, name, capacity));
            }
        } catch (Exception ex) {
            System.out.println("ERROR ResultSet User");
        }
        return halls;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public String getJoinCondition() {

        return null;
    }

    @Override
    public String getSortCondition() {
        return "Name";
    }

 
    
    @Override
    public boolean equals(Object obj) {
     Hall hall=(Hall)obj;
     return hall.hallId==this.hallId;
    }

 
    

 

       
}
