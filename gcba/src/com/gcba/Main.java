package com.gcba;

import com.gcba.csv.CSVManager;
import com.gcba.db.BolicheManager;
import com.gcba.model.Boliche;
import sun.net.www.protocol.http.HttpURLConnection;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: alejandro
 * Date: 9/19/12
 * Time: 12:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class Main {


    public static void main(String[] args) throws Exception {
            /*
        File f = new File("/tmp/aaaa.csv");
        URL url = new URL("https://recursos-data.buenosaires.gob.ar/locales-bailables/registro-locales-bailables.csv");
//        URL url = new URL("http://www.google.com");
        URLConnection conn = url.openConnection();

        BufferedWriter fos = new BufferedWriter(new FileWriter(f));

        InputStreamReader isr = new InputStreamReader(conn.getInputStream());
        char[] buffer = new char[512];
        int n = isr.read(buffer);
        while(n > 0){
            fos.write(buffer);
            n = isr.read(buffer);
        }
        fos.close();
        isr.close();
        */



        // Levanta todos los boliches del csv al disco
        File data = new File("/home/alejandro/Desktop/registro-locales-bailables.csv");
        List<Boliche> boliches = new CSVManager().processCSV(data);
        for (Boliche boliche : boliches) {
            BolicheManager.getInstance().saveOrUpdate(boliche);
        }


        List<Boliche> result = BolicheManager.getInstance().getBolichesByName("the");
        for (Boliche boliche : result) {
            System.out.println(boliche.getNombre() + " - " + boliche.getDomicilioCalle() + " " + boliche.getDomicilioNumbero());
        }


    }

}
