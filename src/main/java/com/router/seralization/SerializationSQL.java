package com.router.seralization;

import com.router.ssa_Office.HearingOffices.Hearing_Office;
import com.router.ssa_Office.office_List.SSA_List;

import java.sql.*;

public class SerializationSQL {



    public static void toSQL_Database() throws SQLException{

        String uri = "jdbc:mysql://localhost:3306/router_api";
        String pin = "******";
        String password = "******";



        try(Connection conn = DriverManager.getConnection(uri, pin, password);
            Statement myStmt = conn.createStatement()){

            System.out.println("Connection established");


            for(Hearing_Office info : SSA_List.hearingOfficeList.values()){


            }



        }

    }







}
