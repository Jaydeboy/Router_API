package com.router.seralization;

import com.router.ssa_Office.HearingOffices.Hearing_Office;
import com.router.ssa_Office.office_List.SSA_List;

import java.sql.*;

public class SerializationSQL {



    public static void toSQL_Database() throws SQLException{

        String uri = "jdbc:mysql://localhost:3306/router_api";
        String pin = "student";
        String password = "student";



        try(Connection conn = DriverManager.getConnection(uri, pin, password);
            Statement myStmt = conn.createStatement()){

            System.out.println("Connection established");


            for(Hearing_Office info : SSA_List.hearingOfficeList.values()){

                        int rows = myStmt.executeUpdate("insert into Hearing_Office"
                                +"(hearing_Office,ho_code, region, processing_Time) values("
                                +"'"+info.getHearing_Office_Name()+","+info.getHo_Code()+info.getRegion()+
                                +info.getAverage_Processing_Time()+")");

            }



        }

    }







}
