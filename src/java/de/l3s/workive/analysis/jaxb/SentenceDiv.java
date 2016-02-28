/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package de.l3s.workive.analysis.jaxb;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Khaled
 */

public class SentenceDiv implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 7566064760019758815L;
	Integer T,B,L,R;
    String divSentences;
   /* List<Integer> saddDiv=new ArrayList<Integer>();
    List<Integer> scloseDiv=new ArrayList<Integer>();
    List<Boolean> sexpectDiv=new ArrayList<Boolean>();*/

    public String getDivSentences() {
        return divSentences;
    }

    public void setDivSentences(String divSentences) {
        this.divSentences = divSentences;
    }

    public Integer getT() {
        return T;
    }

    public void setT(Integer T) {
        this.T = T;
    }

    public SentenceDiv() {
    }

    public Integer getB() {
        return B;
    }

    public void setB(Integer B) {
        this.B = B;
    }

    public Integer getL() {
        return L;
    }

    public void setL(Integer L) {
        this.L = L;
    }

    public Integer getR() {
        return R;
    }

    public void setR(Integer R) {
        this.R = R;
    }
    
    

    public SentenceDiv(Integer T, Integer B, Integer L,String divSentences) {
        this.T = T;
        this.B = B;
        this.L = L;
        this.divSentences=divSentences;
        
    }
    public SentenceDiv(Integer T, Integer B, Integer L,Integer R,String divSentences) {
        this.T = T;
        this.B = B;
        this.L = L;
        //this.R = R;
        this.divSentences=divSentences;
        
    }
    
    public SentenceDiv(SentenceDiv cur, Integer R,String divSentences ) {
        this.T = cur.T;
        this.B = cur.B;
        this.L = cur.L;
        this.R = R;
        this.divSentences=divSentences;
        
    }
   

    
}
