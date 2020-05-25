package com.router.seralization;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;




public class SerializationSQL {



    public static void getSQLDatabase() throws SQLException{

        String uri = "jdbc:mysql://localhost:3306/social_security_data";
        String pin = "******";
        String password = "******";



        try(Connection conn = DriverManager.getConnection(uri, pin, password);
            Statement myStmt = conn.createStatement()){

            System.out.println("Connection established");




            }


        }

    public static void upDateSQLDatabase() throws SQLException{

        String uri = "jdbc:mysql://localhost:3306/social_security_data";
        String pin = "******";
        String password = "******";



        try(Connection conn = DriverManager.getConnection(uri, pin, password);
            Statement myStmt = conn.createStatement()){

            System.out.println("Connection established");




        }


    }
}








