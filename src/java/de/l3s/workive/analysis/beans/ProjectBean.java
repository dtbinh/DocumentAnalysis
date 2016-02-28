/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import de.l3s.workive.analysis.dao.ProjectDao;
import de.l3s.workive.analysis.entities.Projects;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "projectBean")
@SessionScoped
public class ProjectBean implements Serializable{
    public List<Projects> getProjectList(){
        HttpSession httpSession = SessionBean.getSession();
        ProjectDao projectDao = new ProjectDao();
        List<Projects> list=projectDao.getProjects((String) httpSession.getAttribute("username"));
        return list;
    }
}
