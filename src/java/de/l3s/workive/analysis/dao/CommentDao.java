/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.dao;


import de.l3s.workive.analysis.entities.Comment;
import de.l3s.workive.analysis.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Khaled
 */
public class CommentDao {
    public void saveComment(Comment comment) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(comment);
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
    public void deleteComment(int commentId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Comment comment = (Comment) session.load(Comment.class, commentId);
            session.delete(comment);
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
    public List<Comment> getAllCommentedText(String username,int projectId, int dataId,String pageID) {        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction(); 
            Query query=null;
            if(!username.equals("all"))
            {
                 String queryString = "select commentID,commentedText,commentedDivIds,selectedText,pageID,date(created) as created,author"
                    + " from wk_analysis_comment where dataID = :dataId and projectID = :projectId and author=:username and pageID=:pageId";
                query = session.createQuery(queryString);
                query.setString("username", username);
                query.setInteger("dataId", dataId);
                query.setInteger("projectId", projectId);
                query.setString("pageId", pageID);
            }else{
                 String queryString = "select commentID,commentedText,commentedDivIds,selectedText,pageID,date(created) as created,author"
                    + " from wk_analysis_comment where dataID = :dataId and projectID = :projectId and pageID=:pageId";
                query = session.createQuery(queryString);
                
                query.setInteger("dataId", dataId);
                query.setInteger("projectId", projectId);
                query.setString("pageId", pageID);
            }
           
            List<Comment> list = query.list();
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
