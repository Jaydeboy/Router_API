package com.router.ssa_Office;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.router.ssa_Office.office_List.SSA_List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;



public class Social_Security_Handlers {

    private static final Gson GSON = new GsonBuilder().create();

    public static void getHearingOfficeList(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String json = GSON.toJson(SSA_List.hearingOfficeList);

        resp.setStatus(200);
        resp.setHeader("Content-Type", "application/json");
        resp.getOutputStream().println(json);

    }



}
