/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "userBean")
@SessionScoped
public class UserBean implements Serializable{
    private boolean activeUser;
    @ManagedProperty(value="#{annotationBean}")
    private AnnotationBean annotationBean;
    @ManagedProperty(value="#{codedTextBean}")
    private CodedTextBean codeTextBean;
    @ManagedProperty(value="#{commentBean}")
    private CommentBean commentBean;
    @ManagedProperty(value="#{quoteBean}")
    private QuoteBean quoteBean;

    public QuoteBean getQuoteBean() {
        return quoteBean;
    }

    public void setQuoteBean(QuoteBean quoteBean) {
        this.quoteBean = quoteBean;
    }

    public CommentBean getCommentBean() {
        return commentBean;
    }

    public void setCommentBean(CommentBean commentBean) {
        this.commentBean = commentBean;
    }

    
    public CodedTextBean getCodeTextBean() {
        return codeTextBean;
    }

    public void setCodeTextBean(CodedTextBean codeTextBean) {
        this.codeTextBean = codeTextBean;
    }
    
    public boolean isActiveUser() {
        return activeUser;
    }

    public void setActiveUser(boolean activeUser) {
        this.activeUser = activeUser;
    }

    public AnnotationBean getAnnotationBean() {
        return annotationBean;
    }

    public void setAnnotationBean(AnnotationBean annotationBean) {
        this.annotationBean = annotationBean;
    }
    
    public void activatedDisplayedUserValue(){
        if(isActiveUser()){
            annotationBean.setOnlyUserDataDisplay(true);
            codeTextBean.setOnlyUserDataDisplay(true);
            commentBean.setOnlyUserDataDisplay(true);
            quoteBean.setOnlyUserDataDisplay(true);
        }else{
            annotationBean.setOnlyUserDataDisplay(false);
            codeTextBean.setOnlyUserDataDisplay(false);
            commentBean.setOnlyUserDataDisplay(false);
            quoteBean.setOnlyUserDataDisplay(false);
        }
            
        
    }
    
}
