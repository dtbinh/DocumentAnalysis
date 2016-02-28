/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import de.l3s.workive.analysis.dao.CodeDao;
import de.l3s.workive.analysis.entities.Code;
import java.io.Serializable;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "codeBean")
@SessionScoped
public class CodeBean implements Serializable{
    private String codename;

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }
    
    public void saveCodeName(){
        try{
            HttpSession httpSession = SessionBean.getSession();

            if(!getCodename().isEmpty())
            {
                CodeDao codeDao = new CodeDao();
                Code code = new Code();
                code.setDataID((int) httpSession.getAttribute("dataid"));
                code.setProjectID((int) httpSession.getAttribute("projectid"));
                code.setCodename(getCodename());
                code.setAuthor((String) httpSession.getAttribute("username"));
                code.setCreated(new Date());
                codeDao.saveCode(code); 
                
                clearAll();
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Code Saved",
                                ""));
            }
            else{
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Code Text is empty",
                                ""));
            }
        }catch(Exception e)
        {
            System.out.println("Save Quote Error: "+e);
        }
    }
    private void clearAll(){
      this.codename="";
    }

}
