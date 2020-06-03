package com.router.controller;

import com.router.handlers.Social_Security_Handler;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Router extends HttpServlet{

    private static final Map<RouteInterceptor, RouteHandler> routes = new HashMap<>();

    static {

        routes.put(new RouteInterceptor("GET /hearing_Office/list"),(req,resp)-> Social_Security_Handler.getHearingOfficeList(req,resp));
        routes.put(new RouteInterceptor("GET /field_Office/list"),(req, resp) -> Social_Security_Handler.getFieldOfficeList(req,resp));

    }

    private void noMatchHandler(HttpServletResponse resp) throws IOException {
        resp.setStatus(404);
        resp.getWriter().println("Route not found");
    }
        //Checks to see if the HTTP URI matches an pre approved HTTP request
    private void genericHandler(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        for(Map.Entry<RouteInterceptor, RouteHandler> route: routes.entrySet()){
            if(route.getKey().matches(req)){
                route.getValue().execute(req, resp);
                return;
            }
        }
        noMatchHandler(resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws  IOException{
        genericHandler(req,resp);
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        genericHandler(req,resp);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws  IOException{
        genericHandler(req,resp);
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
        genericHandler(req,resp);
    }

}
