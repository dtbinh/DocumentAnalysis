/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.l3s.workive.analysis.ner;

import de.l3s.workive.analysis.dao.NERDao;
import de.l3s.workive.analysis.entities.NER;
import de.l3s.workive.analysis.util.HibernateUtil;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.util.CoreMap;
import edu.stanford.nlp.util.Triple;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.Transaction;


/**
 *
 * @author Khaled
 */
public class GermanNER {
    private static final Properties props = new Properties();
    private StanfordCoreNLP pipeline;
    final String dir = System.getProperty("user.dir");
    
    public StanfordCoreNLP initNER()
    {
    	//props.put("ner.model", "E:\\Java Program\\JarFiles\\dewac_175m_600.crf.ser.gz");
        props.put("ner.model","/home/ansary/ner/dewac_175m_600.crf.ser.gz");
        props.put("ner.useSUTime", "false");
        props.put("ner.applyNumericClassifiers", "false");
        pipeline = new StanfordCoreNLP(props);      
        return pipeline;
    }
    public List<Entity> extractEntities(CoreMap sentence) {
        List<Entity> entityList = new ArrayList<Entity>();

        CoreLabel prevEntity = null;
        String tag="";

        for (CoreLabel token : sentence.get(TokensAnnotation.class)) {
            String entityTag = token.get(NamedEntityTagAnnotation.class);
           
            //System.out.println(entityTag);
            if (entityTag.compareToIgnoreCase("I-ORG") == 0
                    || entityTag.compareToIgnoreCase("I-PER") == 0
                    || entityTag.compareToIgnoreCase("I-LOC") == 0
                    || entityTag.compareToIgnoreCase("MISC") == 0) 
            {
                 
                if (prevEntity != null) {
                    if (prevEntity.get(NamedEntityTagAnnotation.class)
                            .compareToIgnoreCase(entityTag) == 0
                            && prevEntity.endPosition() == token
                                                            .beginPosition() - 1) 
                    {
                        prevEntity.setEndPosition(token.endPosition());
                        prevEntity.set(TextAnnotation.class,prevEntity.get(TextAnnotation.class) + " " + token.get(TextAnnotation.class));
                    } 
                    else {
                        Triple<String, Integer, Integer> triple=new Triple<String, Integer, Integer>(
                        prevEntity.get(TextAnnotation.class),prevEntity.beginPosition(), prevEntity.endPosition());
                        entityList.add(new Entity(triple,tag));
                        prevEntity = token;
                        tag=entityTag;
                        
                        
                    }
                } 
                else 
                {
                    prevEntity = token;
                    tag=entityTag;
                }
            }
        }

        if (prevEntity != null) {
            
            Triple<String, Integer, Integer> triple=new Triple<String, Integer, Integer>(
            prevEntity.get(TextAnnotation.class),prevEntity.beginPosition(), prevEntity.endPosition());
                        entityList.add(new Entity(triple,tag));
                        tag="";
        }
        return entityList;
    }
    public void NERAnnotation(List<NER> nerList, StanfordCoreNLP pipeline){
        
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            
        
            for(NER nerData:nerList){
                Annotation document = new Annotation(nerData.getNerText());  
                pipeline.annotate(document);
                List<CoreMap> entities = document.get(SentencesAnnotation.class);
                for(CoreMap entity: entities) {
                    List<Entity> triple = new ArrayList<Entity>();
                    triple = extractEntities(entity);

                    for(int i=0;i<triple.size();i++)
                    {
                        System.out.println("entities: "+triple.get(i).nerentities.first()+" type "+triple.get(i).getNertype());

                        NER ner = new NER();
                        ner.setNerText(triple.get(i).nerentities.first());
                        ner.setNerType(triple.get(i).getNertype());
                        ner.setNerDivIDs(nerData.getNerDivIDs());
                        ner.setPageID(nerData.getPageID());
                        ner.setDataID(nerData.getDataID());
                        ner.setProjectID(nerData.getProjectID());
                        ner.setCreated(new Date());
                        //NERDao nerDao = new NERDao();
                        trns = session.beginTransaction();
                        session.save(ner);
                        session.getTransaction().commit();
                        //nerDao.saveNER(ner);

                    }
                }
           }
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }    
       
    }
}
