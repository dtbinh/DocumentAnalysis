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


/**
 *
 * @author Khaled
 */
@Entity(name="wk_analysis_annotate")
public class Annotate implements Serializable {
    
    @Id
    @GeneratedValue
    private int annotateID;
    private int dataID;
    private int projectID;
    private String annotatedText;
    private String selectedText;
    private String annotatedDivIds;
    private String pageID;
    private String author;
    
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    @Column(name = "created", nullable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    private Date created;

    public int getAnnotateID() {
        return annotateID;
    }

    public void setAnnotateID(int annotateID) {
        this.annotateID = annotateID;
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

    public String getAnnotatedDivIds() {
        return annotatedDivIds;
    }

    public void setAnnotatedDivIds(String annotatedDivIds) {
        this.annotatedDivIds = annotatedDivIds;
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
