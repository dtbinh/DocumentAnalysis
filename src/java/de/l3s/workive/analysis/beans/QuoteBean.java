/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import de.l3s.workive.analysis.dao.QuoteDao;
import de.l3s.workive.analysis.entities.Quote;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "quoteBean")
@SessionScoped
public class QuoteBean implements Serializable{
    
    private String quotedDivId;
    private String pageid;
    private String quotedText;
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

    public String getQuotedDivId() {
        return quotedDivId;
    }

    public void setQuotedDivId(String quotedDivId) {
        this.quotedDivId = quotedDivId;
    }

    public String getPageid() {
        return pageid;
    }

    public void setPageid(String pageid) {
        this.pageid = pageid;
    }

    public String getQuotedText() {
        return quotedText;
    }

    public void setQuotedText(String quotedText) {
        this.quotedText = quotedText;
    }
    
    public void saveQuote(){
        try{
            HttpSession httpSession = SessionBean.getSession();
        
            if(!getQuotedDivId().isEmpty())
            {
                QuoteDao quoteDao = new QuoteDao();
                Quote quote = new Quote();
                quote.setDataID((int) httpSession.getAttribute("dataid"));
                quote.setProjectID((int) httpSession.getAttribute("projectid"));
                quote.setPageID((String) httpSession.getAttribute("pageid"));
                quote.setQoutedDivIDs(getQuotedDivId());
                quote.setQuotedText(getQuotedText());
                //quote.setAuthor("");
                quote.setCreated(new Date());
                quote.setAuthor((String) httpSession.getAttribute("username"));
                quoteDao.saveQuote(quote); 
                clearAll();
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Quote Saved",
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
      public List<Quote> getQuotedTextList(){
        HttpSession httpSession = SessionBean.getSession();
        QuoteDao quoteTextDao = new QuoteDao();
        List<Quote> list=null;
        if(!isOnlyUserDataDisplay()){
            list=quoteTextDao.getAllQuotedText((String) httpSession.getAttribute("username"),(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"),(String) httpSession.getAttribute("pageid"));
        }else{
            list=quoteTextDao.getAllQuotedText("all",(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"),(String) httpSession.getAttribute("pageid"));
        }
        
        return list;
    }
    public void deleteQuotedText(int quoteId){
        QuoteDao quoteTextDao = new QuoteDao();
        quoteTextDao.deleteQuote(quoteId);
        FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Deleted Quoted Text",
                                ""));
    }
    private void clearAll(){
        this.pageid="";
        this.quotedDivId="";
        this.quotedText="";
    }
    
    
}
