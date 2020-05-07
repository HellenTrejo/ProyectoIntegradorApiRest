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
        	//Connection conn = DriverManager.getConnection("jdbc:mysql://node218902-env-6669914.j.layershift.co.uk/rest","root","MMBeir11727");
        	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3307/bd_proyectointegrador","root","mysql");
           	
        return conn;
    }
}
