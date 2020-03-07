/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.tutorial;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Windows 10 Pro
 */
public class MySqlCon {
    private String hostname = Constant.DBHOSTNAME;
    private String dbname = Constant.DBNAME;
    private String username = Constant.USERNAME;
    private String password = Constant.DBPASSWORD;
   
    private Connection conn;

    public MySqlCon() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                this.conn=DriverManager.getConnection(
                        "jdbc:mysql://"+this.hostname+":3306/"+this.dbname,this.username,this.password);
            } catch (SQLException ex) {
                Logger.getLogger(MySqlCon.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MySqlCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    public Connection getConn() {
        return conn;
    }
    
    public void closeConn(){
        try {
            this.conn.close();
        } catch (SQLException ex) {
            Logger.getLogger(MySqlCon.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    

}
