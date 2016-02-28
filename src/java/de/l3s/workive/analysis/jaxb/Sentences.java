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

public class Sentences implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -183427682886509917L;

	int page; 
    
    List<SentenceDiv> adddiv =new ArrayList<SentenceDiv>();
   // List<SentenceDiv> closediv;
    //List<SentenceDiv> expectdiv;
  //  private SentenceDiv divrect;
    Integer id;
    private SentenceDiv curdiv;
    
    /*public List<SentenceDiv> getClosediv() {
        return closediv;
    }*/

       

    public List<SentenceDiv> getAdddiv() {
        
        return adddiv;
    }

    /*public void setAdddiv(List<SentenceDiv> adddiv) {
        
        
        this.adddiv = adddiv;
    }*/
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
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
    public void addDiv(Integer sentencetop, Integer sentencebottom,Integer sentenceleft,String divstring)
    {
        adddiv.add(curdiv=new SentenceDiv(sentencetop,sentencebottom,sentenceleft,null));
        this.sentencetop = sentencetop;
        this.sentencebottom = sentencebottom;
        this.sentenceleft = sentenceleft;
        
    }
    public void closeDiv( Integer sentencetop, Integer sentencebottom,Integer sentenceright,String divstring)
    {
        this.sentencetop = sentencetop;
        this.sentencebottom = sentencebottom;
        this.sentenceright = sentenceright;
        adddiv.add(new SentenceDiv(curdiv,sentenceright,divstring));
        curdiv.setDivSentences(null);
        //curdiv.
        //closediv.add(new SentenceDiv(curdiv,sentenceright));
        
    }
    public void expectnewdiv(Integer sentencetop, Integer sentencebottom,Integer sentenceleft,Integer sentenceright,String divstring)
    {
        //expectdiv.add(new SentenceDiv(t));
        adddiv.add(curdiv=new SentenceDiv(sentencetop,sentencebottom,sentenceleft,null));
    }

    @Override
    public String toString() {
        return sentencestring; //To change body of generated methods, choose Tools | Templates.
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
    
   /* public Sentences(int page,int sentencenum, String sentencestring, Integer sentencetop, Integer sentencebottom, Integer sentenceleft, Integer sentenceright) {
        super();
        this.page = page;
        this.sentencenum = sentencenum;
        this.sentencestring = sentencestring;
        this.sentencetop = sentencetop;
        this.sentencebottom = sentencebottom;
        this.sentenceleft = sentenceleft;
        this.sentenceright = sentenceright;
    }*/
    
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
