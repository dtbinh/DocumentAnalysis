/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import de.l3s.workive.analysis.dao.NERDao;
import de.l3s.workive.analysis.entities.NER;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "nerBean")
@SessionScoped
public class NERBean implements Serializable{
    
    private String pageID="page_1";
    private int dataID;
    
        private boolean checkBoxPersonActivate=true;
    private boolean checkBoxOrganizationActivate=true;
    private boolean checkBoxLocationActivate=true;

    public boolean isCheckBoxPersonActivate() {
        return checkBoxPersonActivate;
    }

    public void setCheckBoxPersonActivate(boolean checkBoxPersonActivate) {
        this.checkBoxPersonActivate = checkBoxPersonActivate;
    }

    public boolean isCheckBoxOrganizationActivate() {
        return checkBoxOrganizationActivate;
    }

    public void setCheckBoxOrganizationActivate(boolean checkBoxOrganizationActivate) {
        this.checkBoxOrganizationActivate = checkBoxOrganizationActivate;
    }

    public boolean isCheckBoxLocationActivate() {
        return checkBoxLocationActivate;
    }

    public void setCheckBoxLocationActivate(boolean checkBoxLocationActivate) {
        this.checkBoxLocationActivate = checkBoxLocationActivate;
    }
    

    
    public int getDataID() {
        return dataID;
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
    }

   

    public String getPageID() {
        return pageID;
    }

    public void setPageID(String pageID) {
        this.pageID = pageID;
    }
    
    public List<NER> getPersonEntities(){ 
        HttpSession httpSession = SessionBean.getSession();
        NERDao nerDao= new NERDao();
        List<NER> list = nerDao.getAllNERTextbyType((int) httpSession.getAttribute("dataid"), (String) httpSession.getAttribute("pageid"),"I-PER");
        
        return list;
    }
    public List<NER> getLocationEntities(){
        HttpSession httpSession = SessionBean.getSession();
        NERDao nerDao= new NERDao();
        List<NER> list = nerDao.getAllNERTextbyType((int) httpSession.getAttribute("dataid"), (String) httpSession.getAttribute("pageid"),"I-LOC");
        return list;
    }
    public List<NER> getOrganizationEntities(){
        HttpSession httpSession = SessionBean.getSession();
        NERDao nerDao= new NERDao();
        List<NER> list = nerDao.getAllNERTextbyType((int) httpSession.getAttribute("dataid"), (String) httpSession.getAttribute("pageid"),"I-ORG");
        return list;
    }
            
    
    
}
