/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.dao;



import de.l3s.workive.analysis.entities.Code;
import de.l3s.workive.analysis.entities.CodedText;
import de.l3s.workive.analysis.util.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Khaled
 */
public class CodedTextDao {
    public void saveCodeText(CodedText codedText) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(codedText);
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
    public void deleteCode(int codeTextId) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            CodedText codedText = (CodedText) session.load(CodedText.class, codeTextId);
            session.delete(codedText);
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
    public void updateCode(Code code) {
       
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction trns = null;
        try {
            trns = session.beginTransaction();
            session.update(code);
            session.getTransaction().commit();
            //Query query = session.createQuery("update wk_analysis_cod set codename = :codename" +
    			//	" where codeID = :codeId");
            //query.setParameter("codeId", codeId);
            //query.setParameter("codeName", codename);
            //int result = query.executeUpdate();
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
   
    public List<CodedText> getAllCodedText(String username,int projectId, int dataId,String pageID) {        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();  
            Query query=null;
            if(!username.equals("all"))
            {
                String queryString = "select codeTextID,codeName,selectedText,codedDivIds,pageID,date(created) as created,author"
                    + " from wk_analysis_coded_text where dataID = :dataId and projectID = :projectId and author=:username and pageID=:pageId";
                query = session.createQuery(queryString);
                query.setString("username", username);
                query.setInteger("dataId", dataId);
                query.setInteger("projectId", projectId);
                query.setString("pageId", pageID);
            }else{
                String queryString = "select codeTextID,codeName,selectedText,codedDivIds,pageID,date(created) as created,author"
                    + " from wk_analysis_coded_text where dataID = :dataId and projectID = :projectId and pageID=:pageId";
                query = session.createQuery(queryString);
                
                query.setInteger("dataId", dataId);
                query.setInteger("projectId", projectId);
                query.setString("pageId", pageID);
            }
            
            
            List<CodedText> list = query.list();
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
    public List<SelectItem> getAllCodeNames(String username,int projectId, int dataId) {        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();           
            
            String queryString = "select codename"
                    + " from wk_analysis_code where dataID = :dataId and projectID = :projectId";
            Query query = session.createQuery(queryString);
            
            query.setInteger("dataId", dataId);
            query.setInteger("projectId", projectId);
            List<SelectItem> list = query.list();
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
    public List<Code> getAllCodeList(String username,int projectId, int dataId) {        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();           
            
            String queryString =" from wk_analysis_code where dataID = :dataId and projectID = :projectId";
            Query query = session.createQuery(queryString);
            
            query.setInteger("dataId", dataId);
            query.setInteger("projectId", projectId);
            List<Code> list = new ArrayList<Code>();
            for(Object o : query.list()) {
                list.add((Code)o);
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
