/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.l3s.workive.analysis.docs;


import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Khaled
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



/**
 *
 * @author Khaled
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "line"
})
@XmlRootElement(name = "Sentences")
class Sentences implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3304704144353383228L;
	int page; 
    

   
    public Integer getSentencetop() {
        return sentencetop;
    }

    public void setSentencetop(Integer sentencetop) {
        this.sentencetop = sentencetop;
    }

    public Integer getSentencebottom() {
        return sentencebottom;
    }

    public void setSentencebottom(Integer sentencebottom) {
        this.sentencebottom = sentencebottom;
    }

    public Integer getSentenceleft() {
        return sentenceleft;
    }

    public void setSentenceleft(Integer sentenceleft) {
        this.sentenceleft = sentenceleft;
    }

    public Integer getSentenceright() {
        return sentenceright;
    }

    public void setSentenceright(Integer sentenceright) {
        this.sentenceright = sentenceright;
    }
    int sentencenum;
    String sentencestring;
    Integer sentencetop; 
    Integer sentencebottom;
    Integer sentenceleft;    
    Integer sentenceright;
    
    public Sentences(int page,int sentencenum, String sentencestring, Integer sentencetop, Integer sentencebottom, Integer sentenceleft, Integer sentenceright) {
        super();
        this.page = page;
        this.sentencenum = sentencenum;
        this.sentencestring = sentencestring;
        this.sentencetop = sentencetop;
        this.sentencebottom = sentencebottom;
        this.sentenceleft = sentenceleft;
        this.sentenceright = sentenceright;
    }
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSentencenum() {
        return sentencenum;
    }

    public void setSentencenum(int sentencenum) {
        this.sentencenum = sentencenum;
    }

    

    public void setSentencetop(int sentencetop) {
        this.sentencetop = sentencetop;
    }

    

    public void setSentencebottom(int sentencebottom) {
        this.sentencebottom = sentencebottom;
    }
  

    public void setSentenceleft(int sentenceleft) {
        this.sentenceleft = sentenceleft;
    }

   
    public void setSentenceright(int sentenceright) {
        this.sentenceright = sentenceright;
    }
    

    public String getSentencestring() {
        return sentencestring;
    }

    public void setSentencestring(String sentencestring) {
        this.sentencestring = sentencestring;
    }
    
}
