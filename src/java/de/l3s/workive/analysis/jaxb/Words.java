package de.l3s.workive.analysis.jaxb;

import java.util.ArrayList;
import java.util.List;

public class Words {
	int wordid;
	String wordstring;
	Integer wL;
	Integer wT;
	Integer wB;
	Integer wRR;
	Integer wTT;
	Integer wBB;
	boolean highlightedword;
	String wordtype;
	
	
	
	
	
	
	public String getWordtype() {
		return wordtype;
	}


	public void setWordtype(String wordtype) {
		this.wordtype = wordtype;
	}


	public boolean isHighlightedword() {
		return highlightedword;
	}


	public void setHighlightedword(boolean highlightedword) {
		this.highlightedword = highlightedword;
	}
	List<WordDev> curword = new ArrayList<WordDev>();
	
	
	
	public Words() {
		super();
	}


	public Words(Integer wL, Integer wT, Integer wB) {
		super();
		this.wL = wL;
		this.wT = wT;
		this.wB = wB;
	}
	
	
	public Words(String wordstring, Integer wRR, Integer wTT, Integer wBB) {
		super();
		this.wordstring = wordstring;
		this.wRR = wRR;
		this.wTT = wTT;
		this.wBB = wBB;
	}




	public List<WordDev> getCurword() {
		return curword;
	}


	public void setCurword(List<WordDev> curword) {
		this.curword = curword;
	}


	public int getWordid() {
		return wordid;
	}
	public void setWordid(int wordid) {
		this.wordid = wordid;
	}
	public String getWordstring() {
		return wordstring;
	}
	public void setWordstring(String wordstring) {
		this.wordstring = wordstring;
	}
	public Integer getwL() {
		return wL;
	}
	public void setwL(Integer wL) {
		this.wL = wL;
	}
	public Integer getwT() {
		return wT;
	}
	public void setwT(Integer wT) {
		this.wT = wT;
	}
	public Integer getwB() {
		return wB;
	}
	public void setwB(Integer wB) {
		this.wB = wB;
	}
	public Integer getwRR() {
		return wRR;
	}
	public void setwRR(Integer wRR) {
		this.wRR = wRR;
	}
	public Integer getwTT() {
		return wTT;
	}
	public void setwTT(Integer wTT) {
		this.wTT = wTT;
	}
	public Integer getwBB() {
		return wBB;
	}
	public void setwBB(Integer wBB) {
		this.wBB = wBB;
	}


	
	
}
