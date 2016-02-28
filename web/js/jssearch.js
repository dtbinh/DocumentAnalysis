
function setvisibletext()
{
	var visibletext=document.getElementById("visibletext").checked;
        document.getElementById("quotecolor").style.opacity=visibletext?"1.0":"0.0";
        document.getElementById("anotatecolor").style.opacity=visibletext?"1.0":"0.0";
        document.getElementById("commentcolor").style.opacity=visibletext?"1.0":"0.0";
       // alert("hi");
	var pdfdoc=document.getElementById("pdfdoc");

	var blocks=pdfdoc.getElementsByTagName("div");
        //blocks.replace();
        
	for(var i=0;i<blocks.length;i++)
	{
		var ids=blocks.item(i).id;
                //alert(blocks.item(i));
		if(!ids.startsWith("paragraph_")){continue;}
                blocks.item(i).style.opacity=visibletext?"1.0":"0.0";
                //blocks.item(i).
               // var line=blocks.item(i);
                //alert(line);
               
		
	}
	
	
	
		

}
function setvisibletext1()
{
	var visibletext=document.getElementById("visibletext").checked;
	
	var pdfdoc=document.getElementById("pdfdoc");

	var blocks=pdfdoc.getElementsByTagName("div");
        //blocks.replace();
	for(var i=0;i<blocks.length;i++)
	{
		var ids=blocks.item(i).id;
                alert(id);
		if(!ids.startsWith("paragraph_")){continue;}
                blocks.item(i).style.opacity=visibletext?"1.0":"0.0";
                
               // var line=blocks.item(i);
                //alert(line);
               
		
	}
	
	
	
		

}
function searchpage()
{
	var searchfield=document.getElementById("searchfield");
	var searchstr=searchfield.value;
	var pdfdoc=document.getElementById("pdfdoc");
	var ignorecase=document.getElementById("searchignorecase").checked==true;
	var hyperliks=pdfdoc.getElementsByTagName("a");
	var cursearch=[];
	var curidx=0;
	var firstblock=false;
	var searcharray=[];
	for(var i=0;i<hyperliks.length;i++)
	{
		var hyperlinkid=hyperliks.item(i).name;
		if(!hyperlinkid.startsWith("para_")){continue;}
		var paraid=hyperlinkid.substring(5);
		
		var paragraph=document.getElementById("paragraph_"+paraid);	
		removeblocks();
		removemarks();
		
		var text = paragraph.innerText || paragraph.textContent;
		if((ignorecase&&text.toLowerCase().contains(searchstr.toLowerCase()))||text.contains(searchstr))
		{
			searcharray[paraid]="true";
			
			if(!firstblock){
				curidx=cursearch.length;
			}
			cursearch[cursearch.length]=paraid;
			firstblock=false;
		}
		
	}
	
	searchfield.cursearch=cursearch;
	searchfield.curidx=0;
	if(cursearch.length>0){
	displayMarksFor(searcharray,"yellow");
	
	var paragraph=document.getElementById("paragraph_"+cursearch[0]);	
	paragraph.scrollIntoView(true);
	}
	
}
function searchtext(data)
{
	//var searchfield=document.getElementById("searchfield");
	var searchstr=data;
	var pdfdoc=document.getElementById("pdfdoc");
	var ignorecase=document.getElementById("searchignorecase").checked==true;
	var hyperliks=pdfdoc.getElementsByTagName("a");
	var cursearch=[];
	var curidx=0;
	var firstblock=false;
	var searcharray=[];
	for(var i=0;i<hyperliks.length;i++)
	{
		var hyperlinkid=hyperliks.item(i).name;
		if(!hyperlinkid.startsWith("para_")){continue;}
		var paraid=hyperlinkid.substring(5);
		
		var paragraph=document.getElementById("paragraph_"+paraid);	
		removeblocks();
		removemarks();
		
		var text = paragraph.innerText || paragraph.textContent;
		if((ignorecase&&text.toLowerCase().contains(searchstr.toLowerCase()))||text.contains(searchstr))
		{
			searcharray[paraid]="true";
			
			if(!firstblock){
				curidx=cursearch.length;
			}
			cursearch[cursearch.length]=paraid;
			firstblock=false;
		}
		
	}
	
	searchfield.cursearch=cursearch;
	searchfield.curidx=0;
	if(cursearch.length>0){
	displayMarksFor(searcharray,"yellow");
	
	var paragraph=document.getElementById("paragraph_"+cursearch[0]);	
	paragraph.scrollIntoView(true);
	}
	
}