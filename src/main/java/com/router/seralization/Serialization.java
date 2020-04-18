package com.router.seralization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.router.ssa_Office.office_List.SSA_List;

import java.io.*;

public class Serialization {

    private BufferedReader br;
    private BufferedWriter bf;
    private FileWriter fw;


    private static final Gson GSON = new GsonBuilder().create();


    private  void toFile() throws IOException {

        File file = new File("test.txt");
            if(!fileSearch(file)) {

                try{
                     String json = GSON.toJson(SSA_List.hearingOfficeList.values());
                     bf.write(json);
                }finally {
                    bf.close();
                    fw.close();
                }
            }else{
                readFile();
            }
    }
    private void readFile() throws IOException {
        File file = new File("test.txt");
        if(!fileSearch(file)) {

            try{

                



            }finally {

            }
        }else{
            readFile();
        }

    }
    private boolean fileSearch(File inFile){
            return inFile.exists();
    }
}
