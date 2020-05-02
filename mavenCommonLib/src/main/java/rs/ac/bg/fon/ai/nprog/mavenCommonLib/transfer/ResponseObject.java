/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenCommonLib.transfer;

import java.io.Serializable;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.Operation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.ResponseStatus;

/**
 *
 * @author Ivona
 */
public class ResponseObject implements Serializable{
    private ResponseStatus status;
    private Object data;
    private String errorMessage;
    private int operation;

    public ResponseObject() {
    }

    public ResponseObject(ResponseStatus status, Object data, String errorMessage, int operation) {
        this.status = status;
        this.data = data;
        this.errorMessage = errorMessage;
        this.operation=operation;
    }

    public ResponseStatus getStatus() {
        return status;
    }

    public void setStatus(ResponseStatus status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getOperation() {
        return operation;
    }

    public void setOperation(int operation) {
        this.operation = operation;
    }
    
    
}
