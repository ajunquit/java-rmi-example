/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clientrmisaludo;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;
import serverrmisaludo.ISaludo;

/**
 *
 * @author ajunq
 */
public class ClientRMISaludo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws RemoteException, NotBoundException {
       Registry regiregistry = LocateRegistry.getRegistry("localhost", 8990);
        ISaludo suma = (ISaludo)regiregistry.lookup("reg_saludo");
        System.out.println("Ingresar un nombre: ");
        Scanner scanner = new Scanner(System.in);
        String nombreIngresado = scanner.nextLine();
        String total = suma.Saludar(nombreIngresado);
        System.out.println("Respuesta del servidor: " + total);
    }
    
}
