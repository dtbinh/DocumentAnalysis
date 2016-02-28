function markblocksForTopic(top)
                {
                	  document.getElementById("browser").contentWindow.removeblocks();
                	  
                	  document.getElementById("browser").contentWindow. doblocks(top);
                	 /* 
                	  for(var i=0;i<3;i++)
                	  {
                		  document.getElementById("browser").contentWindow.addtest(top*30);  
                	  }
                      document.getElementById("browser").contentWindow.testnavi();
                      */
                }

divselections=[];
marks=[];

blocktops=[];
function doblocks(top)
{
	test=[];
	
	if(blocktops[top]!=null)
	for(var i=0;i<blocktops[top].length;i++)
	{
		addblock(blocktops[top][i]);
	}	
	testnavi();

}

function removeoldselections()
{
for(var i=0;i<divselections.length;i++)
{
	if(divselections[i].parentNode!=null){
		divselections[i].parentNode.removeChild(divselections[i]);
		}
	
}	
divselections=[];
}

function removemarks()
{
for(var i=0;i<marks.length;i++)
{
	if(marks[i].parentNode!=null){
		marks[i].parentNode.removeChild(marks[i]);
		}
	
}	
marks=[];
}

function setnavelements(arr,color) {
	
	navicol=document.getElementById("navicol");
	removeoldselections();
	divselections=[];
	removemarks();
	for(var i=0;i<arr.length;i++)
	{
		var para=arr[i];
		var link = document.createElement("a");
		link.id="navtolink_"+i;
		link.href="#para_"+para["idx"];
		link.style="position:absolute;top:"+scale(para["top"],para["page"])+"px;";
		link.para=para;
		
		
		
		page=document.getElementById("page_"+para["page"]);
		
		
			divselect = document.createElement("div");
			
			divselect.style="position:absolute;width:"+window["pagewidth"]+"px;background-color:yellow;opacity:0.5";
		
		page.appendChild(divselect);
		divselect.style.top=para["top"]+"px";
		divselect.style.height=(para["bot"]-para["top"])+"px";
	//	divselect.style.height=(100)+"px";

		divselections[divselections.length]=divselect;
		

		var span= document.createElement("div");
		if(color==null) color="red";
		span.style="background-color:"+color+";width:20px;height:2px;BORDER-RIGHT: blue 1px solid;BORDER-LEFT: blue 1px solid;BORDER-BOTTOM: blue 1px solid;BORDER-TOP: blue 1px solid;opacity:0.7";
		//span.appendChild( document.createTextNode("_________") );
		link.appendChild(span);
		marks[marks.length]=link;
		navicol.appendChild(link);
		
	}
}

barheight=null;
function scale(top,page)
{
	if(barheight==null)
	{
		navicol=document.getElementById("navicol");
		barheight=parseInt(navicol.style.height,10);
	}
pixelperpage=barheight/window["pagenr"];
;

realpixel=top * pixelperpage/
window["pageheight"];


res= parseInt(realpixel+pixelperpage*page);
return res;
}
function setpages(pagenr)
{
window["pagenr"]=pagenr;	
}
function setpageheight(height)
{
window["pageheight"]=height;	
}
function setpagewidth(width)
{
	window["pagewidth"]=width;	
	}
function testnavi()
{
	
	ret=[];
	/*
	for(var i=0;i<10;i++)
	{ 
		idx=Math.floor((Math.random()*allblocks.length)+1);
		ret[i]=allblocks[idx];
		
	}*/
	/*
	for(var i=0;i<allblocks.length;i++)
	{
		para=document.getElementById("para_"+i);
		if(para.innerHTML.toLowerCase().contains("arbeit"))
		{
			ret[ret.length]=allblocks[i];
		}
	}
	*/
	/*
	for(var i=0;i<test.length;i++)
	{
		idx=test[i];
		
			ret[ret.length]=allblocks[idx];
		
	}*/
	for(var i=0;i<allblocks.length;i++)
	{
		para=allblocks[i];
		
		if(test[para["idx"]]!=null)
		{
			ret[ret.length]=allblocks[i];
		}
	}
	setnavelements(ret);
}
test=[];
function addtest(t)
{
	test[t]="hoy";
	}
allblocks=[];
function addPara(pagenr,parnum,paratop,parabottom)
{
	var element=new Array();
	element["idx"]=parnum;
	element["page"]=pagenr;
	element["top"]=paratop;
	element["bot"]=parabottom;
	allblocks[allblocks.length]=element;
}
function removeblocks()
{
	test=new Array();
	removeoldselections();
	removemarks();
	
	var k=0;
	k++;
}
function addblock(t)
{
	test[t]="hoy";
	}

function displayMarksFor(blockids,color)
{
	
	ret=[];
	/*
	for(var i=0;i<10;i++)
	{ 
		idx=Math.floor((Math.random()*allblocks.length)+1);
		ret[i]=allblocks[idx];
		
	}*/
	/*
	for(var i=0;i<allblocks.length;i++)
	{
		para=document.getElementById("para_"+i);
		if(para.innerHTML.toLowerCase().contains("arbeit"))
		{
			ret[ret.length]=allblocks[i];
		}
	}
	*/
	/*
	for(var i=0;i<test.length;i++)
	{
		idx=test[i];
		
			ret[ret.length]=allblocks[idx];
		
	}*/
	for(var i=0;i<allblocks.length;i++)
	{
		var para=allblocks[i];
		
		if(blockids[para["idx"]]!=null)
		{
			ret[ret.length]=allblocks[i];
		}
	}
	setnavelements(ret,color);
}

