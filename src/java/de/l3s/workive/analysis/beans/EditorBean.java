/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.beans;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import de.l3s.workive.analysis.dao.NERDao;
import de.l3s.workive.analysis.docs.FileUtils;
import de.l3s.workive.analysis.docs.JSParagraph;
import de.l3s.workive.analysis.docs.XMLUtils;
import de.l3s.workive.analysis.entities.NER;
import de.l3s.workive.analysis.jaxb.Block;
import de.l3s.workive.analysis.jaxb.Document;
import de.l3s.workive.analysis.jaxb.Line;
import de.l3s.workive.analysis.jaxb.Page;
import de.l3s.workive.analysis.jaxb.Par;
import de.l3s.workive.analysis.jaxb.Sentences;
import de.l3s.workive.analysis.jaxb.Formatting;
import de.l3s.workive.analysis.jaxb.CharParams;
import de.l3s.workive.analysis.jaxb.Text;
import de.l3s.workive.analysis.ner.GermanNER;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Khaled
 */
@ManagedBean (name = "editorBean")
@SessionScoped
public final class EditorBean implements Serializable{
    Document document;
    Page fpage = null;
    List<Page> pages;
    private Integer maxpagewidth;
    
    List<JSParagraph> jspars = new ArrayList<JSParagraph>();
    private int dataid;
    private String username;
    
    private int firstPage;
    private int numOfPages;
    private int loadedPage;
    private GermanNER ner = new GermanNER();
    private boolean nerExtraction;
    private static List<NER> nerList = new ArrayList<NER>();
    StanfordCoreNLP pipeline;
    
    
    

    public boolean isNerExtraction() {
        return nerExtraction;
    }

    public void setNerExtraction(boolean nerExtraction) {
        this.nerExtraction = nerExtraction;
    }


    public int getFirstPage() {
        return firstPage;
    }

    public void setFirstPage(int firstPage) {
        this.firstPage = firstPage;
    }
    
    public int getLoadedPage() {
        return loadedPage;
    }

    public void setLoadedPage(int loadedPage) {
        this.loadedPage = loadedPage;
    }

    public int getNumOfPages() {
        return numOfPages;
    }

    public void setNumOfPages(int numOfPages) {
        this.numOfPages = numOfPages;
    }

    
         
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public int getDataid() {
        return dataid;
    }

    public void setDataid(int dataid) {
        this.dataid = dataid;
    }
    
    public Page getFpage() {
        return fpage;
    }

    public void setFpage(Page fpage) {
        this.fpage = fpage;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public Integer getMaxpagewidth() {
        return maxpagewidth;
    }

    public void setMaxpagewidth(Integer maxpagewidth) {
        this.maxpagewidth = maxpagewidth;
    }

   
    
    public EditorBean() {
             
        setFirstPage(1);
        setNerExtraction(false);
        setLoadedPage(getFirstPage());
        HttpSession httpSession = SessionBean.getSession();
        httpSession.setAttribute("pageid", "page_"+getLoadedPage());
        /*NERDao nerDao= new NERDao();
        if(nerDao.getAllNERText( getDataid(), "page_"+getLoadedPage())==null)
        {
             setNerExtraction(true);
        }
        else{
             setNerExtraction(false);
        }*/
          
    }
    
    public void init(int min)
    {
        HttpSession httpSession = SessionBean.getSession();
        setUsername((String) httpSession.getAttribute("username"));
        setDataid((int) httpSession.getAttribute("dataid"));
        NERDao nerDao= new NERDao();
      
        
        XMLUtils xu = new XMLUtils();
	                
        try {

            String contents;
            Client client = Client.create();
            WebResource r = client.resource("http://greymane.l3s.uni-hannover.de:8089/WorkiveGUI/api/management/document/get/xmlpages?accessToken=gutearbeit&id="+getDataid()+"&minPage="+getLoadedPage()+"&maxPage="+getLoadedPage());                                  
            contents = r.get(String.class);
            /*contents = FileUtils.read(new File(
                                "E:\\Java Program\\documents\\KS02_002_023.xml"));*/
            contents = contents
                      .replace(
                                "xmlns=\"http://www.abbyy.com/FineReader_xml/FineReader6-schema-v1.xml\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.abbyy.com/FineReader_xml/FineReader6-schema-v1.xml http://www.abbyy.com/FineReader_xml/FineReader6-schema-v1.xml\"",
                               "");
           document = xu.read(contents, Document.class);
           setNumOfPages(document.getPagesCount());
           traverse(document);

            } catch (Exception e) {
                 System.out.println("Document loading error: "+e);
        }	           
    }
    
    public void nextPage(){
        if(getLoadedPage()!=getNumOfPages()){
            setLoadedPage(getLoadedPage()+1);
        }
        else{
            setLoadedPage(getNumOfPages());
        }
        HttpSession httpSession = SessionBean.getSession();
        httpSession.setAttribute("pageid", "page_"+getLoadedPage());
         
        init(getLoadedPage());
        
    }
    
    public void loadEntities(){
        
        if(pipeline==null)
        {
            pipeline = ner.initNER();
        }
        NERDao nerDao= new NERDao();
        for(int i=1;i<=getNumOfPages();i++){
            setLoadedPage(i);
            if(nerDao.getAllNERText( getDataid(), "page_"+getLoadedPage())==null)
            {
                nerList = new ArrayList<NER>();
                init(i);
                ner.NERAnnotation(nerList, pipeline);
            }
        }
        setLoadedPage(1);
        setNerExtraction(false);
        
        
    }
    public void prevPage(){
        if(getLoadedPage()!=getFirstPage()){
            setLoadedPage(getLoadedPage()-1);
        }
        else{
            setLoadedPage(getFirstPage());
        }
        HttpSession httpSession = SessionBean.getSession();
        httpSession.setAttribute("pageid", "page_"+getLoadedPage());
            
        init(getLoadedPage());
        
    }
    public List<Integer> getPageList(){
        List<Integer> list = new ArrayList<Integer>();
        for(int i=1;i<getNumOfPages();i++){
            list.add(i);
        }
        return list;
    }
    public void selectedPage(){
        HttpSession httpSession = SessionBean.getSession();
        httpSession.setAttribute("pageid", "page_"+getLoadedPage());
        init(getLoadedPage());
        RequestContext context = RequestContext.getCurrentInstance();   	
    	context.update("editorform");
    	context.update("listform");
        
        
    }
        
    public void traverse(Document doc) {
		
        fpage = null;
        int parnum = 1,pagenr = 1,pagelimit=30, pageid=1;
        pages = doc.getPage();
        maxpagewidth=0;        
        StringBuilder fulltext = new StringBuilder();     
        ArrayList<Page> npages=new ArrayList<Page>(); 
        
        for (Page page : doc.getPage()) {
            int sentencenum=0;
            if (fpage == null) {
                    fpage = page;
            }
            if(--pagelimit<=0){continue;}
            npages.add(page);
            page.setPageloadId(pageid);
            pageid++;
            page.setScaledHeight(scale(page.getHeight()));
            page.setScaledWidth(scale(page.getWidth()));
            if(maxpagewidth<page.getScaledwidth()&&page.getScaledwidth()<700){maxpagewidth=page.getScaledwidth();}
            for (Block block : page.getBlock()) {
                Text text = block.getText();
                if (block.getBlockType().equals("Text") && text != null) {
                    for (Par par : text.getPar()) {
                        List<Sentences> sentences=new ArrayList<Sentences>();
                        par.setSentence(sentences);
                        StringBuilder parastr = new StringBuilder();
                        boolean gotpara = false;
                        int paratop = 0, parabottom = 0  ,flag=0;
                        Line lastline = null;
                        Sentences cursentence=null;
                        StringBuilder sentencetxt=new StringBuilder();
                        for (Line line : par.getLine()) {

                            line.setST(scale(line.getT()));
                            line.setSL(scale(line.getL()));
                            lastline = line;
                            line.setFontsize(scale(line.getB() - line.getT()));
                            StringBuilder linestr = new StringBuilder();
                            if (!gotpara) {
                                    paratop = scale(line.getT());
                            }
                            Integer lastcarT=null;
                            Integer lastcarR=null;
                            Integer lastcarB=null;
                            Integer lastcarL=null;
                            for (Formatting formatting : line.getFormatting()) {
                                for (CharParams cp : formatting.getCharParams()) {
                                    if (cursentence==null)
                                    {
                                        cursentence=new Sentences();
                                        cursentence.addDiv(scale(cp.getT()),scale(cp.getB()),scale(cp.getL()),null);
                                    }
                                    else if(cursentence!=null && flag==2)
                                    {
                                       // cursentence.setSentencestring(sentencetxt.toString());
                                        cursentence.addDiv(scale(cp.getT()),scale(cp.getB()),scale(cp.getL()),null);
                                        flag=1;
                                    }
                                    String curchar = cp.getContent();
                                    parastr.append(curchar);
                                    linestr.append(curchar);
                                    sentencetxt.append(curchar);
                                    if(curchar.equals(".") || curchar.equals(",") || curchar.equals(";") || curchar.equals("?"))
                                    {
                                        cursentence.closeDiv(scale(cp.getT()),scale(cp.getB()),scale(cp.getR()),sentencetxt.toString());
                                        cursentence.setSentencestring(sentencetxt.toString());
                                        cursentence.setId(sentencenum);
                                        NER ner = new NER();
                                        
                                        ner.setDataID(getDataid());
                                        ner.setNerDivIDs("sentences_"+sentencenum);
                                        ner.setPageID("page_"+getLoadedPage());
                                        ner.setNerText(sentencetxt.toString());
                                        ner.setProjectID(1);
                                        ner.setDataID(getDataid());

                                        nerList.add(ner);
                                        sentencetxt=new StringBuilder();
                                        sentences.add(cursentence);
                                        cursentence=null;
                                        flag=1;
                                        
                                        sentencenum++;
                                    }
                                    else if(flag==0)
                                    {
                                        flag=1;
                                    }

                                    lastcarT= scale(cp.getT());
                                    lastcarB=scale(cp.getB());
                                    lastcarR=scale(cp.getR());
                                    lastcarL=scale(cp.getL());
                                }
                            }
                            parastr.append("\n");
                            if (!gotpara) {

                                    gotpara = true;
                            }
                            if(cursentence!=null)
                            {
                                if(flag==1)
                                {
                                    cursentence.setSentencestring(sentencetxt.toString());
                                    cursentence.closeDiv(lastcarT,lastcarB,lastcarR,sentencetxt.toString());
                                    flag=2;
                                }
                            }
                            line.setStringval(linestr.toString());

                        }
                        if(cursentence!=null)
                        {
                              sentences.add(cursentence);
                              cursentence.setId(sentencenum);
                        }
                        String tempsid="sentence_1";
                        int sids=0;
                        for(Sentences s:sentences)
                        {
                            
                            System.out.println("s: "+s.getSentencestring());
                            
                            sids++;
                        }
                        if (lastline != null) {
                                parabottom = scale(lastline.getB());
                        }
                        StringBuilder cleanedtext = new StringBuilder();
                        String cleaned = cleanedtext.toString().trim();
                        if (cleaned.length() > 2) {
                                if(fulltext.length()>0) fulltext.append(" ");
                                fulltext.append(cleaned.toLowerCase());
                        }
                        par.setValid(true);
                        par.setId(parnum);
                        par.setPage(pagenr);
                        par.setTop(paratop);
                        par.setBottom(parabottom);
                        par.setStringval(parastr.toString());
                        addParagraph(pagenr, parnum, par, paratop, parabottom);

                        if (parastr.toString().toLowerCase()
                                        .contains("meinung")) {
                        } 
                        parnum++;
                    }
                }
            }
            pagenr++;
        }
        doc.getPage().clear();
        doc.getPage().addAll(npages);
        doc.setPagesCount(npages.size());
        
    }
    public Integer scale(Integer m) {
        return m / 4;
    }
    
    public String addParagraph(Integer page, Integer parnum, Par par, int paratop, int parabottom) 
    {
        String retstr = "";
        JSParagraph npar;
        jspars.add(npar = new JSParagraph(page, parnum, paratop, parabottom));
        return retstr;
    }
    
    
}
