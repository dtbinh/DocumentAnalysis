/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import de.l3s.workive.analysis.dao.CommentDao;
import de.l3s.workive.analysis.entities.Comment;
import java.io.Serializable;
import java.util.ArrayList;
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
@ManagedBean (name = "commentBean")
@SessionScoped
public class CommentBean implements Serializable{
    private String pageid;
    private String commentedDivId;
    private String commentedText;
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

    public String getCommentedDivId() {
        return commentedDivId;
    }

    public void setCommentedDivId(String commentedDivId) {
        this.commentedDivId = commentedDivId;
    }

    public String getCommentedText() {
        return commentedText;
    }

    public void setCommentedText(String commentedText) {
        this.commentedText = commentedText;
    }

    public String getSelectedText() {
        return selectedText;
    }

    public void setSelectedText(String selectedText) {
        this.selectedText = selectedText;
    }
    
    public void saveComment(){
        try{
            HttpSession httpSession = SessionBean.getSession();

            if(!getCommentedText().isEmpty() && !getSelectedText().isEmpty())
            {
                CommentDao commentDao = new CommentDao();
                Comment comment = new Comment();
                comment.setDataID((int) httpSession.getAttribute("dataid"));
                comment.setProjectID((int) httpSession.getAttribute("projectid"));
                comment.setPageID((String) httpSession.getAttribute("pageid"));
                comment.setCommentedDivIds(getCommentedDivId());
                comment.setCommentedText(getCommentedText());
                comment.setSelectedText(getSelectedText());
                comment.setAuthor((String) httpSession.getAttribute("username"));
                comment.setCreated(new Date());
                commentDao.saveComment(comment); 
                clearAll();
                FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Comment  Saved",
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
    public List<Comment> getCommentedTextList(){
        HttpSession httpSession = SessionBean.getSession();
        CommentDao commentTextDao = new CommentDao();
        List<Comment> list=new ArrayList<Comment>();
        if(!isOnlyUserDataDisplay()){
            list=commentTextDao.getAllCommentedText((String) httpSession.getAttribute("username"),(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"),(String) httpSession.getAttribute("pageid"));
        }else{
            list=commentTextDao.getAllCommentedText("all",(int) httpSession.getAttribute("projectid"),(int) httpSession.getAttribute("dataid"),(String) httpSession.getAttribute("pageid"));
        }
        
        return list;
    }
    public void deleteCommentedText(int codeId){
        CommentDao codedTextDao = new CommentDao();
        codedTextDao.deleteComment(codeId);
        FacesContext.getCurrentInstance().addMessage(
                        null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO,
                                "Deleted Commented Text",
                                ""));
    }
    private void clearAll(){
       this.commentedDivId="";
       this.commentedText="";
       this.pageid="";
       this.selectedText="";
    }
    
}
