/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.dao;


import de.l3s.workive.analysis.entities.Annotate;
import de.l3s.workive.analysis.util.HibernateUtil;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Khaled
 */
public class AnnotationDao {
    
    public void saveAnnotation(Annotate annotate) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(annotate);
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
    public void deleteAnnotate(int annotateId) {
      
     
       Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Annotate annotatedText = (Annotate) session.load(Annotate.class, annotateId);
            session.delete(annotatedText);
            session.getTransaction().commit();
            System.out.println("deleted id "+annotateId);
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
    public List<Annotate> getAllAnnotatedText(String username,int projectId, int dataId,String pageID) {        
        //Transaction trns = null;
        
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            Query query=null;
            if(!username.equals("all"))
            {
                String queryString = "from wk_analysis_annotate where dataID = :dataId and projectID = :projectId and author=:username and pageID=:pageid";
                query = session.createQuery(queryString);
                query.setString("username", username);
                query.setInteger("dataId", dataId);
                query.setInteger("projectId", projectId);
                query.setString("pageid", pageID);
            }
            else{
                String queryString = "from wk_analysis_annotate where dataID = :dataId and projectID = :projectId and pageID=:pageid";
                query = session.createQuery(queryString);
                query.setInteger("dataId", dataId);
                query.setInteger("projectId", projectId);
                query.setString("pageid", pageID);
            }
            List<Annotate> list = new ArrayList<Annotate>();
            for(Object o : query.list()) {
                list.add((Annotate)o);
            }
           
            
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
