
//disable back button

function deactivateNERButton(){
    document.getElementById("loadNerForm:nerButton").disabled = false;
    document.getElementById("loadNerForm:image").style.display="block";
}  

//detect page id of editor
window.pageid="";
function detectPage(oObject,e)
{
        var id = oObject.id;    
        window.pageid=id;
        document.getElementById("codeselectionform:codepageid").value=window.pageid;
        document.getElementById("quoteform:quotepageid").value=window.pageid;
        document.getElementById("annotateform:annotatepageid").value=window.pageid;
        document.getElementById("commentform:commentpageid").value=window.pageid;
        //document.getElementById("linkupdateform:selectedlinkpageid").value=window.pageid; //error for dialog need to solve
        
        
        //alert('page');
}
window.sentecesid="";
window.divtitle="";
window.flag=new Array();


//detect  id of sentences and mark as blue of editor
function detectMouse(oObject,e)
{
    var button;
    var ctrlPressed=0;
    e = e || window.event;

    if (e.which === null)
    {
        button = (e.button < 2) ? 'left' :
            ((e.button === 4) ? 'middle' : 'right');
    }
    else
    {
        button = (e.which < 2) ? 'left' :
            ((e.which === 2) ? 'middle' : 'right');
    }
    
    if(button==='left')
    {
        //alert(button);
        var id = oObject.id;
        var divs = document.getElementsByTagName('div');
        var actionid;
        var ctrlpress=0;

        /*if(e.ctrlKey==1)
        {
        	alert("ctrl pressed");
        	ctrlpress=1;
        	
        }
        else
        {
        	//alert("ctrl not pressed");
        }*/
        	
        for(var i=0;i<divs.length;i++){
            
        	/*if(divs[i].id===id && (typeof(window.flag[i]) === 'undefined' || window.flag[i] === null || window.flag[i] === 0) ){
                divs[i].style.backgroundColor = "blue";
                divs[i].style.opacity=0.5;
                var title;
                window.flag[i]=1;
               
               actionid="add";
              
	        }
	        else if(divs[i].id===id && window.flag[i]===1)
	        {
	                divs[i].style.backgroundColor = "white";
	                divs[i].style.opacity=0.0;
	                
	                window.flag[i]=0;
	               
	               actionid="remove";
	                
	        }
	      
	    }
	    if(actionid==="add")
	    {
	        window.divtitle+=document.getElementById(id.toString()).title.toString();
	        window.sentecesid +=id+",";
	
	    }
	    else if(actionid==="remove")
	    {
	        window.sentecesid=window.sentecesid.replace(id+",",'');
	        window.divtitle=window.divtitle.replace(document.getElementById(id.toString()).title.toString(),'');
	                 
	    }*/
        	
            if(divs[i].id==id && (typeof(window.flag[i]) == 'undefined' || window.flag[i] == null || window.flag[i] == 0 ) && e.ctrlKey==1){
                    divs[i].style.backgroundColor = "blue";
                    divs[i].style.opacity=0.5;
                    //var title;
                    window.flag[i]=1;//selected id flag is true/ if select it next time then it set as 0 and bg=white
                  
                    actionid="add";
                    
                  //  alert(divs[i].id+' and '+ window.flag[i]);
                  //  window.divtitle+=document.getElementById(id.toString()).title.toString();
                   // window.sentecesid +=id+",";
                    //alert("id select, flag=0 and ctrl=1");
                    
                  
            }
            
            else if(divs[i].id==id && window.flag[i]==1  && e.ctrlKey==1)
            {
                    divs[i].style.backgroundColor = "white";
                    divs[i].style.opacity=0.0;
                    
                    window.flag[i]=0;
                   
                    window.sentecesid =window.sentecesid.replace(id+",",'');
                    window.divtitle =window.divtitle.replace(document.getElementById(id.toString()).title.toString(),'');
                    //alert("id select, flag=1 and ctrl=1");
                   // alert(window.sentecesid);
                    
            }
            else if(divs[i].id==id && (typeof(window.flag[i]) == 'undefined' || window.flag[i] == null || window.flag[i] == 0 ) )
            {
            	divs[i].style.backgroundColor = "blue";
                divs[i].style.opacity=0.5;
                var title;
                window.flag[i]=1;//selected id flag is true/ if select it next time then it set as 0 and bg=white
              
                window.divtitle =document.getElementById(id.toString()).title.toString();
                window.sentecesid =id+",";
               // alert("id select, flag=0 and ctrl=0");
             //   alert(window.sentecesid);
                    
            }
            else if(divs[i].id==id && (window.flag[i]==1 || window.flag[i]==0))
            {
            	divs[i].style.backgroundColor = "blue";
                divs[i].style.opacity=0.5;
                var title;
                window.flag[i]=1;//selected id flag is true/ if select it next time then it set as 0 and bg=white
              
                window.divtitle =document.getElementById(id.toString()).title.toString();
                window.sentecesid =id+",";
               // alert("id select, flag=0 and ctrl=0");
               // alert(window.sentecesid);
                    //alert("id select, flag=1 and ctrl=0");
                    
            }
            if(divs[i].id!=id && (window.flag[i]==1 || window.flag[i]==0) && e.ctrlKey==0)
            {
            	divs[i].style.backgroundColor = "white";
                divs[i].style.opacity=0.0;
                if(window.flag[i]==1)
                {
                	window.sentecesid =window.sentecesid.replace(id+",",'');
                    window.divtitle =window.divtitle.replace(document.getElementById(id.toString()).title.toString(),'');
                    window.flag[i]=0;
                }
                //window.flag[i]=0;
            }
          
        }
        if(actionid==="add")
        {
            window.divtitle+=document.getElementById(id.toString()).title.toString();
            window.sentecesid +=id+",";
           // alert(window.sentecesid);
 
        }
       // alert(window.sentecesid);
        	
    }
    
}

function selectedSentencesofLink()
{
    if(window.sentecesidlink.endsWith(","))
    {
        window.sentecesidlink = window.sentecesidlink.substring(0,window.sentecesidlink.length - 1);
    }
    if(window.sentecesid.endsWith(","))
    {
        window.sentecesid = window.sentecesid.substring(0,window.sentecesid.length - 1);
    }
    //alert(window.sentecesidlink);
    document.getElementById("linkupdateform:lselectedids").value=window.sentecesid;
    document.getElementById("linkupdateform:lselectedtext").value=window.divtitle;
    
    document.getElementById("linkupdateform:selectedlinkids").value=window.sentecesidlink;
    document.getElementById("linkupdateform:selectedlinktext").value=window.divtitlelink;
    
    window.sentecesid="";
    window.divtitle="";
    window.pageid="";
    window.pageidlink="";
    window.sentecesidlink="";
}
function selectedSenteces()
{
    if(window.sentecesid.endsWith(","))
    {
        window.sentecesid = window.sentecesid.substring(0,window.sentecesid.length - 1);
    }
    
    document.getElementById("codeButtonform:codeselecteddiv").value=window.sentecesid;
    document.getElementById("codeButtonform:codeselectedtext").value=window.divtitle;
    
    
    document.getElementById("quoteform:selecteddiv").value=window.sentecesid;
    document.getElementById("quoteform:qselectedtext").value=window.divtitle;
    
   
    document.getElementById("annotateform:annotateselecteddiv").value=window.sentecesid;
    document.getElementById("annotateform:selectedtext").value=window.divtitle;
    
    document.getElementById("commentform:commentselecteddiv").value=window.sentecesid;
    document.getElementById("commentform:cselectedtext").value=window.divtitle;

 
    
  // window.sentecesid="";
  // window.divtitle="";
  // window.pageid="";
    
    
    
}
function SavedIds(sids,sentencetype,aid,pid)
{
	//alert(aid);
    var str_array = sids.split(',');
    var divs = document.getElementsByTagName('div');
    var saveid; 
    var itemsqoute = document.getElementsByName('itemquote');
    var itemsannotate = document.getElementsByName('itemannotation');
    var itemslink = document.getElementsByName('itemlink');
    var itemscomment = document.getElementsByName('itemcomment');
    var itemscode = document.getElementsByName('itemcode');
    var itemsner = document.getElementsByName('itempersonner');
    var itemsORGner = document.getElementsByName('itemorganizationner');
    var itemsLOCner = document.getElementsByName('itemlocationner');
    
    for(var index=0; index<itemsqoute.length;index++)
    {
    	//alert(itemsqoute[index].id + ': '+aid);
    	
    	if(itemsqoute[index].id===aid)
    	{
    		//alert(itemsqoute[index].id);
            document.getElementById(itemsqoute[index].id).style.backgroundColor = "blueviolet";
            document.getElementById(itemsqoute[index].id).style.color = "white";
    	}
    	else
    	{
            document.getElementById(itemsqoute[index].id).style.backgroundColor = "white";
            document.getElementById(itemsqoute[index].id).style.color = "blueviolet";
    	}
    }
    
    for(var index=0; index<itemsannotate.length;index++)
    {
    	
    	if(itemsannotate[index].id===aid)
    	{
    		//alert(itemsannotate[index].id);
            document.getElementById(itemsannotate[index].id).style.backgroundColor = "#0b93d5"; 
            document.getElementById(itemsannotate[index].id).style.color = "white";
    		
    	}
    	else
    	{
    		//alert("false:"+itemsannotate[index].id);
            document.getElementById(itemsannotate[index].id).style.backgroundColor = "white";
            document.getElementById(itemsannotate[index].id).style.color = "#0b93d5";
    		
    	}
    }
    for(var index=0; index<itemscomment.length;index++)
    {
    	if(itemscomment[index].id===aid)
    	{
    		document.getElementById(itemscomment[index].id).style.backgroundColor = "brown";
            document.getElementById(itemscomment[index].id).style.color = "white";
    	}
    	else
    	{
    		document.getElementById(itemscomment[index].id).style.backgroundColor ="white"; 
            document.getElementById(itemscomment[index].id).style.color = "brown";
    	}
    }
    for(var index=0; index<itemscode.length;index++)
    {
    	if(itemscode[index].id===aid)
    	{
    		document.getElementById(itemscode[index].id).style.backgroundColor = "chocolate";
            document.getElementById(itemscode[index].id).style.color = "white";
    	
    	}
    	else
    	{
    		document.getElementById(itemscode[index].id).style.backgroundColor = "white";
            document.getElementById(itemscode[index].id).style.color = "chocolate";
    	}
    }
    for(var index=0; index<itemslink.length;index++)
    {
    	if(itemslink[index].id===aid)
    	{
    		document.getElementById(itemslink[index].id).style.backgroundColor = "green";
            document.getElementById(itemslink[index].id).style.color = "white";
    	}
    	else
    	{
    		document.getElementById(itemslink[index].id).style.backgroundColor =  "white"; 
            document.getElementById(itemslink[index].id).style.color ="green";
    	}
    }
    for(var index=0; index<itemsner.length;index++)
    {
    	if(itemsner[index].id===aid)
    	{
            document.getElementById(itemsner[index].id).style.backgroundColor = "green";
            document.getElementById(itemsner[index].id).style.color = "white";
    	}
    	else
    	{
            document.getElementById(itemsner[index].id).style.backgroundColor =  "white"; 
            document.getElementById(itemsner[index].id).style.color ="green";
    	}
    }
    for(var index=0; index<itemsORGner.length;index++)
    {
    	if(itemsORGner[index].id===aid)
    	{
            document.getElementById(itemsORGner[index].id).style.backgroundColor = "#cc0099";
            document.getElementById(itemsORGner[index].id).style.color = "white";
    	}
    	else
    	{
            document.getElementById(itemsORGner[index].id).style.backgroundColor =  "white"; 
            document.getElementById(itemsORGner[index].id).style.color ="#cc0099";
    	}
    }
    for(var index=0; index<itemsLOCner.length;index++)
    {
    	if(itemsLOCner[index].id===aid)
    	{
            document.getElementById(itemsLOCner[index].id).style.backgroundColor = "midnightblue";
            document.getElementById(itemsLOCner[index].id).style.color = "white";
    	}
    	else
    	{
            document.getElementById(itemsLOCner[index].id).style.backgroundColor =  "white"; 
            document.getElementById(itemsLOCner[index].id).style.color ="midnightblue";
    	}
    }

    
    window.colorflag=new Array();
    var hashflag=0;
    var hashid="";
    for(var i=0;i<divs.length;i++){
        for(var j = 0; j < str_array.length; j++)
        {
            if(divs[i].id===str_array[j])
            {
               	
               colorflag[i]=1;
               if(hashflag==0)
               {
            	   hashid =divs[i].id;
            	   window.location.hash = '#'+divs[i].id;
            	   hashflag=1;
      //      	   alert(hashflag);
               }   
               if(sentencetype==="code")
               {
                    divs[i].style.backgroundColor = "chocolate";
                    divs[i].style.opacity=0.5;
                   // window.location.hash = '#'+divs[i].id;
                    saveid=divs[i].id.toString();
                    
                    //document.getElementById(codeid).style.backgroundColor = "chocolate";
                }    
                else if(sentencetype==="quote")
               {
                    divs[i].style.backgroundColor = "blueviolet";
                    divs[i].style.opacity=0.5;
                   // window.location.hash = '#'+divs[i].id;
                   
                    saveid=divs[i].id.toString();
                } 
                else if(sentencetype==="annotate")
               {
                    divs[i].style.backgroundColor = "#0b93d5";
                    divs[i].style.opacity=0.5;
                   // window.location.hash = '#'+divs[i].id;
                    saveid=divs[i].id.toString();
                } 
                else if(sentencetype==="comment")
               {
                    divs[i].style.backgroundColor = "brown";
                    divs[i].style.opacity=0.5;
                    //window.location.hash = '#'+divs[i].id;
                    saveid=divs[i].id.toString();
                } 
                 else if(sentencetype==="link")
               {
                    divs[i].style.backgroundColor = "green";
                    divs[i].style.opacity=0.5;
                    //window.location.hash = '#'+divs[i].id;
                    saveid=divs[i].id.toString();
                } 
                else if(sentencetype==="personner")
                {
                      divs[i].style.backgroundColor = "green";
                      divs[i].style.opacity=0.5;
                      //window.location.hash = '#'+divs[i].id;
                      saveid=divs[i].id.toString();
                } 
                else if(sentencetype==="organization")
                {
                      divs[i].style.backgroundColor = "#cc0099";
                      divs[i].style.opacity=0.5;
                      //window.location.hash = '#'+divs[i].id;
                      saveid=divs[i].id.toString();
                }   
                else if(sentencetype==="locationner")
                {
                      divs[i].style.backgroundColor = "midnightblue";
                      divs[i].style.opacity=0.5;
                      //window.location.hash = '#'+divs[i].id;
                      saveid=divs[i].id.toString();
                }   
                    
            }
            else
            {
            	if(colorflag[i]===1)
            	{
            		
            	}
            	else{
            		divs[i].style.backgroundColor = "";
            	}

            }
            
        }
    }
   
}

function doactive()
{
   // alert('d');
    document.getElementById("codeselectionform:codebutton").disabled = false;
}
function dodisable()
{
    document.getElementById("codeselectionform:codebutton").disabled = true;
}

