/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.test;

import de.l3s.workive.analysis.entities.User;
import de.l3s.workive.analysis.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;



/**
 *
 * @author Khaled
 */
public class Test {
    
    public static void main(String args[]){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        User user= new User();
        user.setPassword("123");
        user.setEmail("khaled@l3s.de");
        user.setUsername("Khaled");
        session.save(user);
        transaction.commit();
        
    }
}
