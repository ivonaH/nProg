/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.form.model;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.ResponseStatus;
import rs.ac.bg.fon.ai.nprog.mavenServer.history.HistoryObject;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;

import com.jayway.jsonpath.internal.path.ArraySliceOperation.Operation;

/**
 *
 * @author Ivona
 */
public class HistoryTableModel extends AbstractTableModel {

	String[] columns = { "Korisnik", "Datum","Vreme", "Operacija", "Status", "Greska" };
	List<HistoryObject> history;

	public HistoryTableModel(List<HistoryObject> history) {
		this.history = history;
	}

	@Override
	public int getRowCount() {
		return history.size();
	}

	@Override
	public int getColumnCount() {
		return columns.length;
	}

	@Override
	public Object getValueAt(int row, int column) {
		HistoryObject h = history.get(row);
		switch (column) {
		case 0:
			return h.getUsername();
		case 1:
			SimpleDateFormat sdf=new SimpleDateFormat("dd.MM.yyyy");
			return sdf.format(h.getDate());
		case 2:{
			SimpleDateFormat sdt=new SimpleDateFormat("HH:mm");
			return sdt.format(h.getDate());
		}
		case 3:
			return h.getOperation();
		case 4:
			return h.getStatus();
		case 5:
			return h.getErrorMessage();
		default:
			return "n/a";
		}
	}

	@Override
	public String getColumnName(int column) {
		return columns[column];
	}

	@Override
	public boolean isCellEditable(int i, int i1) {
		return false;
	}


}
