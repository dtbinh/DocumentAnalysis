/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import de.l3s.workive.analysis.dao.UserDao;
import de.l3s.workive.analysis.entities.User;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String userLogin() {
        UserDao userDao= new UserDao();
        boolean validuser = userDao.getUserById(username,password);
        if (validuser) {
            
            //session.setAttribute("username", username);
            return "/welcome.jsf?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_WARN,
                            "Incorrect Username and Passowrd",
                            "Please enter correct username and Password"));
            return null;
        }
    }
    public String logout() {
        HttpSession session = SessionBean.getSession();
        
        session.invalidate();
        return "login";
    }
     private void clearAll() {
        this.username = "";
        this.password = "";
    }
    
}
