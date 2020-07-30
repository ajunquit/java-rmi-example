/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package serverrmisaludo;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ajunq
 */
public interface ISaludo extends Remote{
    public String Saludar(String nombre) throws RemoteException;
}
