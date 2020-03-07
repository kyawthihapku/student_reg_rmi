/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorial;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author Windows 10 Pro
 */
public interface StuentRegIF extends Remote{
    
    public boolean createStudent(Student student) throws RemoteException;
    public ArrayList<Student> showall() throws RemoteException;
    
}
