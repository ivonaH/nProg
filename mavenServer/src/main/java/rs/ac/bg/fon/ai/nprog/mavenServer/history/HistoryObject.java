package rs.ac.bg.fon.ai.nprog.mavenServer.history;

import java.util.Date;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.Operation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.ResponseStatus;

public class HistoryObject {
	String username;
	Date date;
	int operation;
	ResponseStatus status;
	String errorMessage;

	public HistoryObject(String username, Date date, int operation, ResponseStatus status, String errorMessage) {
		this.username = username;
		this.date = date;
		this.operation = operation;
		this.status = status;
		this.errorMessage = errorMessage;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getOperation() {
		return operation;
	}

	public void setOperation(int operation) {
		this.operation = operation;
	}

	public ResponseStatus getStatus() {
		return status;
	}

	public void setStatus(ResponseStatus status) {
		this.status = status;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "HistoryObject [username=" + username + ", date=" + date + ", operation=" + operation + ", status="
				+ status + ", errorMessage=" + errorMessage + "]";
	}

	
	
}
