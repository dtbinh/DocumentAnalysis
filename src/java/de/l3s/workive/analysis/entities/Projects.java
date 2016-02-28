/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author Khaled
 */
@Entity(name="ga_project")
public class Projects implements Serializable{
    @Id
    @GeneratedValue
    private int project_id;
    private int deleted;
    private String title;
    private String external_key;
    private int creator_id;
    private String abstruct;
    private String description;
    private int is_primary;

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExternal_key() {
        return external_key;
    }

    public void setExternal_key(String external_key) {
        this.external_key = external_key;
    }

    public int getCreator_id() {
        return creator_id;
    }

    public void setCreator_id(int creator_id) {
        this.creator_id = creator_id;
    }

    public String getAbstruct() {
        return abstruct;
    }

    public void setAbstruct(String abstruct) {
        this.abstruct = abstruct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getIs_primary() {
        return is_primary;
    }

    public void setIs_primary(int is_primary) {
        this.is_primary = is_primary;
    }
    
    
    
}
