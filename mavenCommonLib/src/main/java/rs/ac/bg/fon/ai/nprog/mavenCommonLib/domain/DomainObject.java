/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain;

import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Ivona
 */
public interface DomainObject {
    String getTableName();
    String getParameters();
    String getParameterNames();
    int getPrimaryKeyValue();
    String getPrimaryKeyName();
    List<DomainObject> convertRSList(ResultSet rs);
    String getUpdateQuery();
    String getJoinCondition();

    public String getSortCondition();
}
