/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorial;

import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 Pro
 */
public class StudentRegImpl extends UnicastRemoteObject implements StuentRegIF,Serializable{

    @Override
    public boolean createStudent(Student student) throws RemoteException {
        try {
            MySqlCon mySqlCon = new MySqlCon();
            String sql = "INSERT INTO student (id,roll_no,name,nrc,address,phoneno,email,year,major,gender) VALUES (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = mySqlCon.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, 0);
            preparedStatement.setString(2, student.getRoll_no());
            preparedStatement.setString(3, student.getName());
            preparedStatement.setString(4,student.getNrc());
            preparedStatement.setString(5, student.getAddress());
            preparedStatement.setString(6,student.getPhoneno());
            preparedStatement.setString(7,student.getEmail());
            preparedStatement.setString(8,student.getYear());
            preparedStatement.setString(9,student.getMajor());
            preparedStatement.setString(10,student.getGender());
           

          
            preparedStatement.executeUpdate();
            mySqlCon.closeConn();
            System.out.println(student);
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(StudentRegImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public ArrayList<Student> showall() throws RemoteException {
        try {
            ArrayList<Student> studentList = new ArrayList<>();
            MySqlCon mySqlCon = new MySqlCon();
            String sql = "SELECT * FROM student";
            PreparedStatement preparedStatement = mySqlCon.getConn().prepareStatement(sql);
            ResultSet res = preparedStatement.executeQuery();
            
            while(res.next()){
                Student student = new Student();
                 student.setId(res.getInt(1));
                 student.setName(res.getString(2));
                 student.setRoll_no(res.getString(3));
                 student.setNrc(res.getString(4));
                 student.setAddress(res.getString(5));
                 student.setPhoneno(res.getString(6));
                 student.setEmail(res.getString(7));
                 student.setYear(res.getString(8));
                 student.setMajor(res.getString(9));
                 student.setGender(res.getString(10));
                 
                 
                 studentList.add(student);
            }
            mySqlCon.closeConn();
            return studentList;
        } catch (SQLException ex) {
            Logger.getLogger(StudentRegImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    

    
}
