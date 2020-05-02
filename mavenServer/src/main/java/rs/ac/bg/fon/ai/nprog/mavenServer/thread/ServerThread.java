/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenServer.thread;

import rs.ac.bg.fon.ai.nprog.mavenServer.configuration.Configuration;
import rs.ac.bg.fon.ai.nprog.mavenServer.controller.Controller;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Ivona
 */
public class ServerThread extends Thread {

    private final ServerSocket serverSocket;

    public ServerThread() throws IOException {
        int port = Integer.parseInt(Configuration.getInstance().getProperty("port"));
        this.serverSocket = new ServerSocket(port);
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            System.out.println("Waiting clients.. :)");
            try {
                Socket socket = serverSocket.accept();
                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
                System.out.println("Client connected :))");
                Controller.getInstance().addClient(clientThread);
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
        System.out.println("Server je zaustavljen.");
    }

    public void stopServerThread() throws IOException {
        stopAllThreads();

        serverSocket.close();

        interrupt();
    }

    public ServerSocket getServerSocket() {
        return serverSocket;
    }

    private void stopAllThreads() {
        Controller.getInstance().logoutClients();
        for (ClientThread client : Controller.getInstance().getClientThreads()) {
            try {

                client.getSocket().close();
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }

        }

    }

}
