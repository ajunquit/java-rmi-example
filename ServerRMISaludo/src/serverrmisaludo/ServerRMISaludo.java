/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serverrmisaludo;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

/**
 *
 * @author ajunq
 */
public class ServerRMISaludo extends UnicastRemoteObject implements ISaludo {

    public ServerRMISaludo() throws RemoteException {
        super();
    }

    public static void main(String[] args) throws RemoteException {
        // publicar, puerto,
        Registry regiregistry = LocateRegistry.createRegistry(8990);
        regiregistry.rebind("reg_saludo", new ServerRMISaludo());
        System.out.println("El servidor esta listo...");
    }

    @Override
    public String Saludar(String nombre) throws RemoteException {
        Date fechaActual = new Date();
        String responseTiempo = Tiempo(fechaActual);
        return responseTiempo + ", " + nombre;
    }

    private String Tiempo(Date fecha) {

        int hora = fecha.getHours();
        String tiempo = null;
        if (hora >= 0 && hora < 12) {
            tiempo = "Buenas días";
        } else if (hora > 12 && hora < 19) {
            tiempo = "Buenas tardes";
        } else {
            tiempo = "Buenas noches";
        }
        return tiempo;
    }

}
