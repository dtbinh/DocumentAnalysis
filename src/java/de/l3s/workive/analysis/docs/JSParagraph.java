package de.l3s.workive.analysis.docs;

import java.io.Serializable;



public class JSParagraph implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8951332620161187642L;
	Integer page; Integer parnum;
	int paratop; int parabottom;


	public JSParagraph(Integer page, Integer parnum, int paratop, int parabottom) {
		super();
		this.page = page;
		this.parnum = parnum;
		this.paratop = paratop;
		this.parabottom = parabottom;
	}
	
	public Integer getPage() {
		return page;
	}
	public Integer getParnum() {
		return parnum;
	}
	public int getParatop() {
		return paratop;
	}
	public int getParabottom() {
		return parabottom;
	};

}
