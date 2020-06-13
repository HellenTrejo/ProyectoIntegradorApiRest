package com.example.rest.util;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Instructor
 */
public class ConectaDB {

        public Connection getAcceso() throws Exception {
        	Class.forName("com.mysql.jdbc.Driver");
        	
        	Connection conn = DriverManager.getConnection("jdbc:mysql://node226146-env-6360882.j.layershift.co.uk/proyectocovid","root","ELEmbe26478");
        	//
        	//Connection conn = DriverManager.getConnection("jdbc:mysql://node225371-env-4252036.j.layershift.co.uk/proyectocovid","root","OQBeie83118");
        	//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/proyectocovid","root","mysql");
           	
        return conn;
    }
}
