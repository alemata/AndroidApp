package com.gcba.csv;

import com.gcba.model.Boliche;
import com.sun.xml.internal.messaging.saaj.util.CharReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVManager {

    private static final String TMP_FILE = "/home/alemata/PruebasAndroid/AndroidApp/gcba/resources/fileFormatted.csv";

    public List<Boliche> processCSV(File sourceFile){
        File tmp = new File(TMP_FILE);
        try{
            fixCSV(sourceFile, tmp);
            return parseCSV(tmp);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    private void fixCSV(File sourceFile, File targetFile) throws IOException {
        boolean isOpened = false;

        FileReader fr = new FileReader(sourceFile);
        BufferedReader br = new BufferedReader(fr);

        FileWriter fw = new FileWriter(targetFile);
        BufferedWriter bw = new BufferedWriter(fw);

        char[] buffer = new char[512];
        int n = br.read(buffer);
        while (n > 0) {
            for (int i = 0; i < n; i++) {
                if (buffer[i] == '"') {
                    isOpened = !isOpened;
                } else if (isOpened && ((buffer[i] == '\n') || (buffer[i] == '\r'))) {
                    buffer[i] = ' ';
                }
            }
            bw.write(buffer, 0, n);
            n = br.read(buffer);
        }

        bw.close();
        fw.close();
        br.close();
        fr.close();
    }

    private List<Boliche> parseCSV(File file) throws Exception {
        List<Boliche> result = new ArrayList<Boliche>();

        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line = br.readLine();    // descartar la primera linea -> es el encabezado
        line = br.readLine();
        while (line != null) {
            Boliche boliche = processLine(line);
            if (boliche != null) {
                result.add(boliche);
            }
            line = br.readLine();
        }

        br.close();
        fr.close();

        return result;
    }

    private Boliche processLine(String line) {
        try {
            String[] fields = line.split(";");

            Boliche boliche = new Boliche();
            boliche.setNumeroRegistro(Integer.parseInt(fields[0]));
            boliche.setNombre(fields[1]);
            boliche.setDomicilioCalle(fields[2]);
            boliche.setDomicilioNumbero(fields[3]);
            boliche.setNumeroExpediente(fields[4]);

            if (!fields[5].isEmpty()) {
                int endIndex = fields[5].indexOf("personas");
                if (endIndex == -1) {
                    endIndex = fields[5].indexOf(" ");
                }
                if (endIndex != -1) {
                    String cantidad = fields[5].substring(0, endIndex).trim();
                    boliche.setCapacidad(Integer.parseInt(cantidad));
                } else{
                    boliche.setCapacidad(0);
                }
            }
            boliche.setClase(fields[6]);
            boliche.setEstado(fields[7]);
            return boliche;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
