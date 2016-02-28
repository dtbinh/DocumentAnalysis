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
@Entity(name="ga_data")
public class Documents implements Serializable{
    
    @Id
    @GeneratedValue
    private int data_id;
    private String name;
    private String external_key;
    private int data_type_id;
    private int deleted;
    private String description;
    private int original_project;

    public int getData_id() {
        return data_id;
    }

    public void setData_id(int data_id) {
        this.data_id = data_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExternal_key() {
        return external_key;
    }

    public void setExternal_key(String external_key) {
        this.external_key = external_key;
    }

    public int getData_type_id() {
        return data_type_id;
    }

    public void setData_type_id(int data_type_id) {
        this.data_type_id = data_type_id;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getOriginal_project() {
        return original_project;
    }

    public void setOriginal_project(int original_project) {
        this.original_project = original_project;
    }
    
    
    
}
