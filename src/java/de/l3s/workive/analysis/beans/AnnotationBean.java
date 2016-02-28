/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import de.l3s.workive.analysis.dao.AnnotationDao;
import de.l3s.workive.analysis.entities.Annotate;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "annotationBean")
@SessionScoped
public class AnnotationBean implements Serializable{
    private String pageid;
    private String annotatedDivId;
    private String annotatedText;
    private String selectedText;   
    private boolean checkBoxActivate=true;
    private boolean onlyUserDataDisplay=false;

    public boolean isOnlyUserDataDisplay() {
        return onlyUserDataDisplay;
    }

    public void setOnlyUserDataDisplay(boolean onlyUserDataDisplay) {
        this.onlyUserDataDisplay = onlyUserDataDisplay;
    }
    
    
    

    public boolean isCheckBoxActivate() {
        return checkBoxActivate;
    }

    public void setCheckBoxActivate(boolean checkBoxActivate) {
        this.checkBoxActivate = checkBoxActivate;
    }
   

    public String getPageid() {
        return pageid;
    }

    public void setPageid(String pageid) {
        this.pageid = pageid;
    }

    public String getAnnotatedDivId() {
        return annotatedDivId;
    }

    public void setAnnotatedDivId(String annotatedDivId) {
        this.annotatedDivId = annotatedDivId;
    }

    public String getAnnotatedText() {
        return annotatedText;
    }

    public void setAnnotatedText(String annotatedText) {
        this.annotatedText = annotatedText;
    }

    public String getSelectedText() {
        return selectedText;
    }

    public void setSelectedText(String selectedText) {
        this.selectedText = selectedText;
    }
    
    public void saveAnnotation(){
        try{
            HttpSession httpSession = SessionBean.getSession();
            
            if(!getAnnotatedText().isEmpty() && !getSelectedText().isEmpty())
            {
                AnnotationDao annotationDao = new AnnotationDao();
                Annotate annotate = new Annotate();
                annotate.setDataID((int) httpSession.getAttribute("dataid"));
                annotate.setProjectID((int) httpSession.getAttribute("projectid"));
                annotate.setPageID((String)httpSession.getAttribute("pageid"));
                annotate.setAnnotatedDivIds(getAnnotatedDivId());
                annotate.setAnnotatedText(getAnnotatedText());
                annotate.setSelectedText(getSelectedText());
                annotate.setAuthor((String) httpSession.getAttribute("username"));
                annotate.setCreated(new Date());
                annotationDao.saveAnnotation(annotate); 
                clearAll();
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Annotation  Saved",
                                ""));
            }
            else{
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_WARN,
                                "Selected text is empty",
                                "Try to select again"));
            }
        }catch(Exception e)
        {
            System.out.println("Save Quote Error: "+e);
        }
    }
     public void deleteAnnotatedText(Annotate annotate){
        AnnotationDao annotatedTextDao = new AnnotationDao();
        annotatedTextDao.deleteAnnotate(annotate.getAnnotateID());
        
        FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Deleted Annotated Text",
                                ""));
    }
   
    public List<Annotate> getAnnotatedTextList(){
        HttpSession httpSession = SessionBean.getSession();
        AnnotationDao annotatedTextDao = new AnnotationDao();
        List<Annotate> list= new ArrayList<Annotate>();
        if(!isOnlyUserDataDisplay()){
            
            list=annotatedTextDao.getAllAnnotatedText((String) httpSession.getAttribute("username"),(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"),(String)httpSession.getAttribute("pageid"));
        }else{
            list=annotatedTextDao.getAllAnnotatedText("all",(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"),(String)httpSession.getAttribute("pageid"));
        }
        return list;
    }
    private void clearAll(){
        setAnnotatedDivId("");
        setAnnotatedText("");
        setPageid("");
        setSelectedText("");
    }

   

   

    
}
