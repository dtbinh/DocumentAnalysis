/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;


import de.l3s.workive.analysis.dao.CodeDao;
import de.l3s.workive.analysis.dao.CodedTextDao;
import de.l3s.workive.analysis.entities.Code;
import de.l3s.workive.analysis.entities.CodedText;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpSession;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "codedTextBean")
@SessionScoped
public class CodedTextBean implements Serializable{
    private String pageid;
    private String codedDivId;
    private String codededText;
    private String selectedText;
    private boolean checkBoxActivate=true;
    private boolean onlyUserDataDisplay=false;
    
    private List<Code> code;

    public List<Code> getCode() {
        
        HttpSession httpSession = SessionBean.getSession();
        CodedTextDao codedTextDao = new CodedTextDao();
        code=codedTextDao.getAllCodeList((String) httpSession.getAttribute("username"),(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"));
        
        return code;
    }

    public void setCode(List<Code> code) {
        this.code = code;
    }
    

    public boolean isOnlyUserDataDisplay() {
        return onlyUserDataDisplay;
    }

    public void setOnlyUserDataDisplay(boolean onlyUserDataDisplay) {
        this.onlyUserDataDisplay = onlyUserDataDisplay;
    }
    
    private List<Code> filteredCode;

    public List<Code> getFilteredCode() {
        return filteredCode;
    }

    public void setFilteredCode(List<Code> filteredCode) {
        this.filteredCode = filteredCode;
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

    public String getCodedDivId() {
        return codedDivId;
    }

    public void setCodedDivId(String codedDivId) {
        this.codedDivId = codedDivId;
    }

    public String getCodededText() {
        return codededText;
    }

    public void setCodededText(String codededText) {
        this.codededText = codededText;
    }

    public String getSelectedText() {
        return selectedText;
    }

    public void setSelectedText(String selectedText) {
        this.selectedText = selectedText;
    }
    public void saveCodedText(){
        try{
            HttpSession httpSession = SessionBean.getSession();

            if(!getCodededText().isEmpty() && !getSelectedText().isEmpty())
            {
                CodedTextDao codedTextDao = new CodedTextDao();
                CodedText codedText = new CodedText();
                codedText.setDataID((int) httpSession.getAttribute("dataid"));
                codedText.setProjectID((int) httpSession.getAttribute("projectid"));
                codedText.setPageID((String) httpSession.getAttribute("pageid"));
                codedText.setCodedDivIds(getCodedDivId());
                codedText.setCodeName(getCodededText());
                codedText.setSelectedText(getSelectedText());
                codedText.setAuthor((String) httpSession.getAttribute("username"));
                codedText.setCreated(new Date());
                codedTextDao.saveCodeText(codedText); 
                clearAll();
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Coded Text  Saved",
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
    public void deleteCodedText(int codeId){
        CodedTextDao codedTextDao = new CodedTextDao();
        codedTextDao.deleteCode(codeId);
        FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Deleted Coded Text",
                                ""));
    }
    public void codeNameChangeListener(ValueChangeEvent event) {
        
        setCodededText(event.getNewValue().toString());
        
    }
    public List<CodedText> getCodedTextList(){
        HttpSession httpSession = SessionBean.getSession();
        CodedTextDao codedTextDao = new CodedTextDao();
        List<CodedText> list = new ArrayList<CodedText>();
        if(!isOnlyUserDataDisplay()){
            list=codedTextDao.getAllCodedText((String) httpSession.getAttribute("username"),(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"),(String) httpSession.getAttribute("pageid")); 
        }else{
             list=codedTextDao.getAllCodedText("all",(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"),(String) httpSession.getAttribute("pageid"));
        }
        
        return list;
    }
    public List<SelectItem> getCodeNameList(){
        HttpSession httpSession = SessionBean.getSession();
        CodedTextDao codedTextDao = new CodedTextDao();
        List<SelectItem> list=codedTextDao.getAllCodeNames((String) httpSession.getAttribute("username"),(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"));
        return list;
    }
    public List<Code> getCodeListManages(){
        HttpSession httpSession = SessionBean.getSession();
        CodedTextDao codedTextDao = new CodedTextDao();
        List<Code> list=codedTextDao.getAllCodeList((String) httpSession.getAttribute("username"),(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"));
        
        return list;
    }
    public void onCodeEdit(RowEditEvent event) {
        int codeId= ((Code) event.getObject()).getCodeID();
        String codename=((Code) event.getObject()).getCodename();
        
        CodedTextDao codedTextDao = new CodedTextDao();
        codedTextDao.updateCode((Code) event.getObject());
        FacesMessage msg = new FacesMessage("Code Name Updated", codename);
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     public void onCodeCancel(RowEditEvent event) {
        int codeId= ((Code) event.getObject()).getCodeID();
        //FacesMessage msg = new FacesMessage("Car Edited", );
        //FacesContext.getCurrentInstance().addMessage(null, msg);
    }
     
    private void clearAll(){
       this.codedDivId="";     
       this.pageid="";
       this.selectedText="";
    }

}
