package com.router.controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class RouteInterceptor {

    private final String request;
    private final List<String> path;

    //(CRUD) /SSA_Hearing/list
    public RouteInterceptor(String route){
        //splits the uri into two parts 1. CRUD 2. request
        String[] parts = route.split(" ");
        //stores the HTTP request
        request = parts[0];
        //The request Array is mines the HTTP reuest into a string
        String rest = Arrays.stream(parts).skip(1).collect(Collectors.joining(" "));
       // splits the string into a list
        path = splitUri(rest);
    }
    //splits the uri based on "/"
    private List<String> splitUri(String rest){
        return Arrays.stream(rest.split("/")).filter(x -> !x.isEmpty())
                    .collect(Collectors.toList());
    }
    public boolean matches(HttpServletRequest req){
        //gets the(GET,POST, PUT), gets the whole URL request
        //Overloads the matches method
        return matches(req.getMethod(),req.getRequestURI());

    }
    //ensure the initial path == the inputed uri
    private boolean matches(String method, String uri) {


        if (!request.equalsIgnoreCase(method)){
            return false;
        }
        //splits the URI via splitUri method
        List<String> provideUri = splitUri(uri);
        if(provideUri.size() != path.size()){
            return false;
        }

        for(int i = 0; i < provideUri.size();i++){
            String provideBit = provideUri.get(i);
            String patternBit = path.get(i);

            if(patternBit.startsWith(":")){
                continue;
            }
            if(!patternBit.equalsIgnoreCase(provideBit)){
                return false;
            }

        }
        return true;
    }


}

