/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rs.ac.bg.fon.ai.nprog.mavenClient.thread;

import rs.ac.bg.fon.ai.nprog.mavenClient.controller.Controller;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Hall;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Movie;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.MovieMarathon;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Reservation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.Showtime;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.domain.User;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.transfer.RequestObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.transfer.ResponseObject;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.Operation;
import rs.ac.bg.fon.ai.nprog.mavenCommonLib.util.ResponseStatus;

/**
 *
 * @author Ivona
 */
public class CommunicationWithServer extends Thread {

    Socket socket;
    ObjectInputStream objectInputStream;
    ObjectOutputStream objectOutputStream;

    public CommunicationWithServer() {
    }

    @Override
    public void run() {
        while (true) {
            ResponseObject responseObject = receiveResponse();
            System.out.println("PRIMIO SAM ODGOVOR");
            switch (responseObject.getOperation()) {
                case Operation.OPERATION_NADJI_RADNIKA: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        Controller.getInstance().loginSuccess((User) responseObject.getData());
                    } else {
                        Controller.getInstance().loginFailed();
                    }
                }
                break;
                case Operation.OPERATION_VRATI_SALE: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        try {
                            Controller.getInstance().hallLoadingSuccess((List< Hall>) responseObject.getData());
                        } catch (Exception ex) {
                            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Controller.getInstance().hallLoadingFailed();
                    }
                }
                break;
                case Operation.OPERATION_VRATI_FILMOVE: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        try {
                            Controller.getInstance().movieLoadingSuccess((List< Movie>) responseObject.getData());
                        } catch (Exception ex) {
                            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Controller.getInstance().movieLoadingFailed();
                    }
                }
                break;
                case Operation.OPERATION_VRATI_REZERVACIJE: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        try {
                            Controller.getInstance().reservationLoadingSuccess((List<Reservation>) responseObject.getData());
                        } catch (Exception ex) {
                            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Controller.getInstance().reservationLoadingFailed();
                    }
                }
                break;
                case Operation.OPERATION_VRATI_REZERVACIJE_PO_KRITERIJUMU: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        try {
                            Controller.getInstance().reservationLoadingSuccess((List<Reservation>) responseObject.getData());
                        } catch (Exception ex) {
                            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Controller.getInstance().reservationLoadingFailed();
                    }
                }
                break;
                case Operation.OPERATION_VRATI_FILMSKE_MARATONE: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        try {
                            Controller.getInstance().movieMarathonLoadingSuccess((List<MovieMarathon>) responseObject.getData());
                        } catch (Exception ex) {
                            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Controller.getInstance().movieMarathonLoadingFailed();
                    }
                }
                break;
                case Operation.OPERATION_VRATI_FILMSKE_MARATONE_PO_KRITERIJUMU: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        try {
                            Controller.getInstance().movieMarathonLoadingSuccess((List<MovieMarathon>) responseObject.getData());
                        } catch (Exception ex) {
                            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Controller.getInstance().movieMarathonLoadingFailed();
                    }
                }
                break;
                case Operation.OPERATION_VRATI_FILMOVE_PO_KRITERIJUMU: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        try {
                            Controller.getInstance().movieLoadingSuccess((List< Movie>) responseObject.getData());
                        } catch (Exception ex) {
                            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Controller.getInstance().movieLoadingFailed();
                    }
                }
                break;
                case Operation.OPERATION_VRATI_PROJEKCIJE_PO_KRITERIJUMU: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        try {
                            Controller.getInstance().showtimeLoadingSuccess((List<Showtime>) responseObject.getData());
                        } catch (Exception ex) {
                            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        Controller.getInstance().showtimeLoadingFailed();
                    }
                }
                break;
                case Operation.OPERATION_KREIRAJ_FILM: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        Controller.getInstance().movieSaved();
                        System.out.println("Sacuvan je...");
                    } else {
                        Controller.getInstance().movieIsNotSaved();
                        System.out.println("Nije sacuvan...");
                    }
                }
                break;
                case Operation.OPERATION_KREIRAJ_REZERVACIJU: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        Controller.getInstance().reservationSaved();
                        System.out.println("Sacuvan je...");
                    } else {
                        Controller.getInstance().reservationIsNotSaved();
                        System.out.println("Nije sacuvan...");
                    }
                }
                break;
                case Operation.OPERATION_KREIRAJ_PROJEKCIJU: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        Controller.getInstance().showtimeSaved();
                        System.out.println("Sacuvan je...");
                    } else {
                        Controller.getInstance().showtimeIsNotSaved();
                        System.out.println("Nije sacuvan...");
                    }
                }
                break;
                case Operation.OPERATION_KREIRAJ_MARATON: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        Controller.getInstance().movieMarathonSaved();
                        System.out.println("Sacuvan je...");
                    } else {
                        Controller.getInstance().movieMarathtonIsNotSaved();
                        System.out.println("Nije sacuvan...");
                    }
                }
                break;
                case Operation.OPERATION_OBRISI_PROJEKCIJU: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        Controller.getInstance().showtimeDeleted();
                        System.out.println("Obrisan je maraton...");
                    } else {
                        Controller.getInstance().showtimeNotDeleted();
                        System.out.println("Nije obrisan maraton....");
                    }
                }
                break;
                case Operation.OPERATION_OBRISI_REZERVACIJU: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        Controller.getInstance().reservationDeleted();
                        System.out.println("Obrisana je rezervacija...");
                    } else {
                        Controller.getInstance().reservationNotDeleted();
                        System.out.println("Nije obrisana rezervacija...");
                    }
                }
                break;
                case Operation.OPERATION_IZMENI_PROJEKCIJU: {
                    if (responseObject.getStatus() == ResponseStatus.SUCCESS) {
                        Controller.getInstance().showtimeUpdated();
                        System.out.println("Izmenjena projekcija...");
                    } else {
                        Controller.getInstance().showtimeNotUpdated();
                        System.out.println("Projekcija nije izmenjena");
                    }
                }
                break;
                case Operation.OPERATION_LOGOUT: {
//                    System.out.println("SVE JE OKEJ");
                    JOptionPane.showMessageDialog(null, "Server nije dostupan.");
                    System.exit(0);
                }
                break;
            }
        }

    }

    private ResponseObject receiveResponse() {
        try {
            return (ResponseObject) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Server nije dostupan.");
            System.exit(0);
        }
        return null;
    }

    public void sendClientRequest(RequestObject requestObject) {
        try {
            objectOutputStream.writeObject(requestObject);
            objectOutputStream.flush();
        } catch (IOException ex) {
            System.out.println("Exception");
            JOptionPane.showMessageDialog(null, "Server nije dostupan.");
            System.exit(0);
            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void connect(int portNumber) throws Exception {
        try {
            socket = new Socket("localhost", portNumber);
            Controller.getInstance().startLoginForm();
            initializeStreams();

        } catch (IOException ex) {
            Controller.getInstance().serverIsNotActive();
            throw new Exception("Server is not active");

        }
    }

    private void initializeStreams() {
        try {
            objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            objectInputStream = new ObjectInputStream(socket.getInputStream());
        } catch (IOException ex) {
            Logger.getLogger(CommunicationWithServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
