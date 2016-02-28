/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.dao;


import de.l3s.workive.analysis.entities.NER;
import de.l3s.workive.analysis.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Khaled
 */
public class NERDao {
     public void saveNER(NER ner) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(ner);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    public List<NER> getAllNERText(int dataId, String pageID) {        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();           
            String queryString = "select nerID,nerText,nerDivIDs,nerType,pageID,created"
                    + " from wk_analysis_ner where dataID = :dataId and pageID=:pageID";
            Query query = session.createQuery(queryString);
            query.setString("pageID", pageID);
            query.setInteger("dataId", dataId);
            
            List<NER> list = query.list();
            if (list.size() > 0) {
                return list;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    } 
    public List<NER> getAllNERTextbyType(int dataId, String pageID,String nerType) {        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();           
            String queryString = "select nerID,nerText,nerDivIDs,nerType,pageID,date(created) as created"
                    + " from wk_analysis_ner where dataID = :dataId and pageID=:pageID and nerType=:nerType";
            Query query = session.createQuery(queryString);
            query.setString("pageID", pageID);
            query.setInteger("dataId", dataId);
            query.setString("nerType", nerType);
            List<NER> list = query.list();
            if (list.size() > 0) {
                return list;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return null;
    } 
}
