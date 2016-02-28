/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Khaled
 */
@Entity(name="wk_analysis_comment")
public class Comment implements Serializable {
    
    @Id
    @GeneratedValue
    private int commentID;
    private int dataID;
    private int projectID;
    private String commentedText;
    private String selectedText;
    private String commentedDivIds;
    private String pageID;
    private String author;
    
    @Column(name = "created", nullable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date created;

    public int getCommentID() {
        return commentID;
    }

    public void setCommentID(int commentID) {
        this.commentID = commentID;
    }

    public int getDataID() {
        return dataID;
    }

    public void setDataID(int dataID) {
        this.dataID = dataID;
    }

    public int getProjectID() {
        return projectID;
    }

    public void setProjectID(int projectID) {
        this.projectID = projectID;
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

    public String getCommentedDivIds() {
        return commentedDivIds;
    }

    public void setCommentedDivIds(String commentedDivIds) {
        this.commentedDivIds = commentedDivIds;
    }

    public String getPageID() {
        return pageID;
    }

    public void setPageID(String pageID) {
        this.pageID = pageID;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

   
    
    
}
