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
@Entity(name="wk_analysis_ner")
public class NER implements Serializable{
 
    @Id
    @GeneratedValue
    private int nerID;
    private int dataID;
    private int projectID;
    private String nerText;
    private String nerType;
    private String nerDivIDs;
    private String pageID;
    @Column(name = "created", nullable = false, columnDefinition = "datetime default CURRENT_TIMESTAMP")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date created;

    public int getNerID() {
        return nerID;
    }

    public void setNerID(int nerID) {
        this.nerID = nerID;
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

    public String getNerText() {
        return nerText;
    }

    public void setNerText(String nerText) {
        this.nerText = nerText;
    }

    public String getNerType() {
        return nerType;
    }

    public void setNerType(String nerType) {
        this.nerType = nerType;
    }

    public String getNerDivIDs() {
        return nerDivIDs;
    }

    public void setNerDivIDs(String nerDivIDs) {
        this.nerDivIDs = nerDivIDs;
    }

    public String getPageID() {
        return pageID;
    }

    public void setPageID(String pageID) {
        this.pageID = pageID;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    
   

    
    
}
