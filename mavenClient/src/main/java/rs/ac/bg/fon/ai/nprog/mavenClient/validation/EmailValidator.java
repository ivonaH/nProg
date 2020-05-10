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
public class EmailValidator {

    public static void validateEmail(String email) throws ValidationException {
        if (!email.contains("@") || !email.contains(".") || email.charAt(0) == '.'
                || email.charAt(0) == '-' || email.split("@")[0].length() < 2 || email.split("@")[1].length() < 2) {
            throw new ValidationException("Email nije u odgovarajucem formatu.");
        }

    }
}
