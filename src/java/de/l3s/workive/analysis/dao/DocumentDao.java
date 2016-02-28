/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.dao;


import de.l3s.workive.analysis.entities.Documents;
import de.l3s.workive.analysis.util.HibernateUtil;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Khaled
 */
public class DocumentDao {
    private int projectID;

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
    }
    
    
    public List<Documents> getDocuments(int userID) {        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();           
            
            String queryString = "select data_id ,original_project,name,description"
                    + " from ga_data where data_id IN (492,292,661,804)" ;
            Query query = session.createQuery(queryString);
            
            
            List<Documents> list = query.list();
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
    public void setSelectedProject(int projectID){
        setProjectID(projectID);
    }
}
