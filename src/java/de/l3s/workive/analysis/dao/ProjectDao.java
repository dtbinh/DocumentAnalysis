/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.dao;

import de.l3s.workive.analysis.entities.Projects;
import de.l3s.workive.analysis.util.HibernateUtil;
import java.util.List;
import javax.faces.model.SelectItem;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Khaled
 */
public class ProjectDao {
    
    public List<Projects> getProjects(String userID) {        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();           
            
            String queryString = "select project_id,title,description"
                    + " from ga_project where creator_id = :userID";
            Query query = session.createQuery(queryString);
            query.setString("userID", userID);
            
            List<Projects> list = query.list();
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
