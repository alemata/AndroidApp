package com.gcba.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import javax.persistence.EntityManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;


public class DBManager {

    public static final String CONFIG_FILENAME = "/home/alemata/PruebasAndroid/AndroidApp/gcba/src/com/gcba/db/hibernate.cfg.xml";
    public static DBManager instance = null;
    private Session currentSession;

    public static DBManager getInstance(){
        if(instance == null){
            instance = new DBManager();
        }
        return instance;
    }

    private DBManager() {
        try{
            init();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void init() throws Exception {
        FileInputStream fis = null;
        try {
            Configuration cfg = new Configuration();
            cfg.configure(new File(CONFIG_FILENAME));
            SessionFactory sessionFactory = cfg.buildSessionFactory();
            currentSession = sessionFactory.openSession();
        } finally {
            if (fis != null) {
                fis.close();
            }
        }


    }


    public Session getCurrentSession(){
        return currentSession;
    }



}
