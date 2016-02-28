/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import de.l3s.workive.analysis.dao.DocumentDao;
import de.l3s.workive.analysis.entities.Documents;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.component.editor.Editor;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "documentBean")
@SessionScoped
public class DocumentBean implements Serializable{
    @ManagedProperty(value="#{editorBean}")
    private EditorBean editor;

    public EditorBean getEditor() {
        return editor;
    }

    public void setEditor(EditorBean editor) {
        this.editor = editor;
    }

    public DocumentBean() {
    }
      
    public List<Documents> getDocumentList(){
        HttpSession httpSession = SessionBean.getSession();
        DocumentDao documentDao = new DocumentDao();
        List<Documents> list=documentDao.getDocuments((Integer) httpSession.getAttribute("userid"));
        return list;
    }
    public void documentEditor(int dataid,int projectid){
        System.out.println("test");
        
        HttpSession httpSession = SessionBean.getSession();
        FacesContext context = FacesContext.getCurrentInstance();
        //String dataid= (String)context.getExternalContext().getSessionMap().get("data_id");
        //String projectid= (String)context.getExternalContext().getSessionMap().get("project_id");
        System.out.println(dataid);
        httpSession.setAttribute("dataid", dataid);
        httpSession.setAttribute("projectid", projectid);
       
        editor.init(1);
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("/DocumentAnalysis/index.jsf");
        } catch (IOException e) {
              
            System.out.println("Page redirect error"+e);
            e.printStackTrace();
        }
    }
    public String documentMenu(){
        
        return "/DocumentAnalysis/welcome.jsf?faces-redirect=true";
    }
}
