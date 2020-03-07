/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorial;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 Pro
 */
public class ServerStudent extends UnicastRemoteObject{
    public static void main(String[] args) {
        try {
            java.rmi.registry.LocateRegistry.createRegistry(1099);
            StuentRegIF studentreg = new StudentRegImpl();
            Naming.rebind("rmi://"+Constant.RMIHOSTNAME+"/"+Constant.RMISERVICENAME, studentreg);
            System.err.println("Server ready");
        } catch (RemoteException | MalformedURLException ex) {
            Logger.getLogger(ServerStudent.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println(ex);
        }
    }
    
}
