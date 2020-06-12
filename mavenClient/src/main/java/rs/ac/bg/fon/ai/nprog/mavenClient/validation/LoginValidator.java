/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.validation;

import rs.ac.bg.fon.ai.nprog.mavenCommonLib.exception.ValidationException;

/**
 *
 * @author Ivona
 */
public class LoginValidator {

    public static void validateUsernameAndPassword(String username, String password) throws ValidationException {
        if (username == null || password == null || username.isEmpty() || password.isEmpty()) {
            throw new ValidationException("Username or password is empty.");
        }
    }

}

