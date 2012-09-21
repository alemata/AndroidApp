package com.gcba.db;

import com.gcba.model.Boliche;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LikeExpression;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: alejandro
 * Date: 9/19/12
 * Time: 12:57 PM
 * To change this template use File | Settings | File Templates.
 */
public class BolicheManager {

    private static BolicheManager instance = null;

    public static BolicheManager getInstance(){
        if(instance == null){
            instance = new BolicheManager();
        }
        return instance;
    }

    private BolicheManager(){

    }


    public void saveOrUpdate(Boliche boliche){
        beginDBAction();
        getSession().save(boliche);
        afterDBAction();
    }

    public Boliche get(Long id){
        return (Boliche) getSession().get(Boliche.class, id);
    }

    public void delete(Long id){
        Boliche b = new Boliche();
        b.setId(id);
        delete(b);
    }

    public void delete(Boliche boliche){
        beginDBAction();
        getSession().delete(boliche);
        afterDBAction();
    }

    public List<Boliche> getBolichesByName(String name){
        Criteria criteria = getSession().createCriteria(Boliche.class);
        criteria.add(Restrictions.ilike("nombre", name, MatchMode.ANYWHERE));
        List result = criteria.list();
        return result;
    }

    private Session getSession() {
        return DBManager.getInstance().getCurrentSession();
    }

    private void beginDBAction(){
        getSession().beginTransaction();
    }

    private void afterDBAction(){
        getSession().getTransaction().commit();
    }
}
