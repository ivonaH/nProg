/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.main;

import rs.ac.bg.fon.ai.nprog.mavenClient.controller.Controller;

/**
 *
 * @author Ivona
 */
public class Main {

    public static void main(String[] args) {
        Controller.getInstance().connect(9000);
    }
}
