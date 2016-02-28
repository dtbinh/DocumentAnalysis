/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.dao;

import de.l3s.workive.analysis.entities.Quote;
import de.l3s.workive.analysis.entities.User;
import de.l3s.workive.analysis.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Khaled
 */
public class QuoteDao {
    
    public void saveQuote(Quote qoute) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(qoute);
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
    public void deleteQuote(int quoteId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Quote quote = (Quote) session.load(Quote.class, quoteId);
            session.delete(quote);
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
    public List<Quote> getAllQuotedText(String username,int projectId, int dataId,String pageID) {        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();  
            Query query=null;
            if(!username.equals("all"))
            {
                String queryString = "select quoteID,quotedText,qoutedDivIDs,pageID,date(created) as created,author"
                    + " from wk_analysis_quote where dataID = :dataId and projectID = :projectId and author=:username and pageID=:pageId";
                query = session.createQuery(queryString);
                query.setString("username", username);
                query.setInteger("dataId", dataId);
                query.setInteger("projectId", projectId);
                query.setString("pageId", pageID);
            }else{
                String queryString = "select quoteID,quotedText,qoutedDivIDs,pageID,date(created) as created,author"
                    + " from wk_analysis_quote where dataID = :dataId and projectID = :projectId and pageID=:pageId";
                query = session.createQuery(queryString);
               
                query.setInteger("dataId", dataId);
                query.setInteger("projectId", projectId);
                query.setString("pageId", pageID);
            }
            
            List<Quote> list = query.list();
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
