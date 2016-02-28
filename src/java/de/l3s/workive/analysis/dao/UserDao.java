/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.dao;

import de.l3s.workive.analysis.beans.SessionBean;
import de.l3s.workive.analysis.entities.User;
import de.l3s.workive.analysis.util.HibernateUtil;
import javax.servlet.http.HttpSession;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Khaled
 */
public class UserDao {
    public void addUser(User user) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(user);
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
     public boolean getUserById(String username,String password) {

        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from ga_user where username = :username and password = :password";
            Query query = session.createQuery(queryString);
            query.setString("username", username);
            query.setString("password", password);
            User user = (User) query.uniqueResult();
            
            if (user!=null) {
                HttpSession httpSession = SessionBean.getSession();
                httpSession.setAttribute("username", user.getUsername());
                httpSession.setAttribute("userid", user.getUserid());
                return true;
            }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return false;
    }
    
 
}
