function makeEditableAndHighlight(colour) {
    
    var range, sel = window.getSelection();
    if (sel.rangeCount && sel.getRangeAt) {
        range = sel.getRangeAt(0);
        
        alert(sel.rangeCount);
        
    }
    document.designMode = "on";
    if (range) {
        sel.removeAllRanges();
        sel.addRange(range);
    }
    // Use HiliteColor since some browsers apply BackColor to the whole block
    if (!document.execCommand("HiliteColor", false, colour)) {
        document.execCommand("BackColor", false, colour);
    }
    document.designMode = "off";
}
function SetProjectId()
{
    document.getElementById("linkform1:linkprojectid").value="1";
    alert(document.getElementById("linkform1:linkprojectid").value);
}
function highlight(colour) {
    var range, sel;
    if (window.getSelection) {
        // IE9 and non-IE
        try {
            if (!document.execCommand("BackColor", false, colour)) {
                makeEditableAndHighlight(colour);
            }
        } catch (ex) {
            makeEditableAndHighlight(colour)
        }
    } else if (document.selection && document.selection.createRange) {
        // IE <= 8 case
        range = document.selection.createRange();
        range.execCommand("BackColor", false, colour);
    }
}

var getComputedStyleProperty;

if (typeof window.getComputedStyle != "undefined") {
    getComputedStyleProperty = function(el, propName) {
        return window.getComputedStyle(el, null)[propName];
    };
} else if (typeof document.documentElement.currentStyle != "undefined") {
    getComputedStyleProperty = function(el, propName) {
        return el.currentStyle[propName];
    };
}

function unhighlight(node, colour) {
    if (!(colour instanceof Colour)) {
        colour = new Colour(colour);
    }

    if (node.nodeType == 1) {
        var bg = node.style.backgroundColor;
        if (bg && colour.equals(new Colour(bg))) {
            node.style.backgroundColor = "";
        }
    }
    var child = node.firstChild;
    while (child) {
        unhighlight(child, colour);
        child = child.nextSibling;
    }
}

function getSelectionCharOffsetsWithin(element) {
    var start = 0, end = 0;
    var sel, range, priorRange;
    if (typeof window.getSelection != "undefined") {
        range = window.getSelection().getRangeAt(0);
        priorRange = range.cloneRange();
        priorRange.selectNodeContents(element);
        priorRange.setEnd(range.startContainer, range.startOffset);
        start = priorRange.toString().length;
        end = start + range.toString().length;
    } else if (typeof document.selection != "undefined" &&
            (sel = document.selection).type != "Control") {
        range = sel.createRange();
        priorRange = document.body.createTextRange();
        priorRange.moveToElementText(element);
        priorRange.setEndPoint("EndToStart", range);
        start = priorRange.text.length;
        end = start + range.text.length;
    }
    return {
        start: start,
        end: end
    };
}

function anotateSelection() {
    var mainDiv = document.getElementById("Content");
    var sel = getSelectionCharOffsetsWithin(mainDiv);
    //alert(sel.start + ": " + sel.end);
    document.getElementById("anotateform:anotatep").value=sel.start;
    document.getElementById("anotateform:anotateq").value=sel.end;
    var content=window.getSelection().getRangeAt(0);
    document.getElementById("anotateform:anotatetext").value=content;
    var range = window.getSelection().getRangeAt(0);
    
    var newNode = document.createElement("mark");
    newNode.style.backgroundColor = "yellow";
    newNode.style.color           = "black";
    range.surroundContents(newNode);
    
}
function commentSelection() {
    var mainDiv = document.getElementById("Content");
    var sel = getSelectionCharOffsetsWithin(mainDiv);
    //alert(sel.start + ": " + sel.end);
    document.getElementById("commentform:commentp").value=sel.start;
    document.getElementById("commentform:commentq").value=sel.end;
    var content=window.getSelection().getRangeAt(0);
    document.getElementById("commentform:selectedtext").value=content;
    document.getElementById("commentform:selectedtext1").value=content;
    
    var range = window.getSelection().getRangeAt(0);
    
    var newNode = document.createElement("mark");
    newNode.style.backgroundColor = "#0b93d5";
    newNode.style.color           = "black";
    range.surroundContents(newNode);
    
   // document.getElementById("commentdialog").show();

}
function codeSelection() {
    
   var content=window.getSelection().getRangeAt(0);
   
   document.getElementById("form2:codeselectiontext1").value=content;
   document.getElementById("form2:codeselectiontext").value=content;
   
    

}

function quoutemake()
{
    var mainDiv = document.getElementById("Content");
    var sel = getSelectionCharOffsetsWithin(mainDiv);
    //alert(sel.start + ": " + sel.end);
    document.getElementById("quoteform:quoutep").value=sel.start;
    document.getElementById("quoteform:quouteq").value=sel.end;
    var content=window.getSelection().getRangeAt(0);
    
    document.getElementById("quoteform:quotetext").value=content;
    
    
    var s = "\"";
    var e ="\"";
    var a = window.getSelection().getRangeAt(0);
    var b = content.toString();
    var z = document.createElement("span");
    //var l2 = prompt("Enter URL:", url);
    //b = b.link(url);
    z.innerHTML=s+b+e;
    a.deleteContents();
     
    //var v = document.createElement("span");
    //v.innerHTML =z.innerHTML+e;
    z.style.color="blue";
    a.insertNode(z);
    
   // z.style.backgroundColor = "blue";
    //z.style.color           = "white";
    //range.surroundContents(z);
    
    
}
function quouteSelection() {
    var mainDiv = document.getElementById("Content");
    var sel = getSelectionCharOffsetsWithin(mainDiv);
    //alert(sel.start + ": " + sel.end);
    document.getElementById("quoteform:quoutep").value=sel.start;
    document.getElementById("quoteform:quouteq").value=sel.end;
    var content=window.getSelection().getRangeAt(0);
    document.getElementById("quoteform:quotetext").value=content;
    var range = window.getSelection().getRangeAt(0);
    var newNode = document.createElement("mark");
    range.surroundContents(newNode);

}


function stylizeHighlightedString() {
  var range               = window.getSelection().getRangeAt(0);
  var selectionContents   = range.extractContents();
  var span                = document.createElement("span");
  span.appendChild(selectionContents);
  span.setAttribute("class","uiWebviewHighlight");

  span.style.backgroundColor = "yellow";
  span.style.color           = "red";

  range.insertNode(span);
}
//var sentecesid;
 
window.pageidlink="";
function detectPagelink(oObject,e)
{
        var id = oObject.id;    
        window.pageidlink=id;
        
        //alert("pageid: "+window.pageidlink);
        document.getElementById("linkupdateform:selectedpagelinkid").value=window.pageidlink;
      //  document.getElementById("commentform:commentpageid").value=window.pageid;
      //  document.getElementById("editorsences:quotepageid").value=window.pageid;
        
        
        //alert(window.sentecesid);
}
window.sentecesidlink="";
window.divtitlelink="";
window.flaglink=new Array();
//window.flag.length=document.getElementsByTagName('div');
//window.flag=new FilledArray(window.flag.length-1, 0);
function detectMouselink(oObject,e)
{
    //alert(oObject.id);
    var button;
    e = e || window.event;

    if (e.which === null)
    {
        button = (e.button < 2) ? 'left' :
            ((e.button == 4) ? 'middle' : 'right');
    }
    else
    {
        button = (e.which < 2) ? 'left' :
            ((e.which === 2) ? 'middle' : 'right');
    }
    
    if(button==='right')
    {
        //alert(button);
        
        var id = oObject.id;
        var divs = document.getElementsByTagName('div');
        for(var i=0;i<divs.length;i++){
            if(divs[i].id===id){
                divs[i].style.backgroundColor = "white";
                divs[i].style.opacity=0.0;
            }
        }
        window.sentecesidlink=window.sentecesidlink.replace(id+",",'');
        
        //alert(window.sentecesid);

        
    }
    else if(button==='left')
    {
        //alert(button);
        var id = oObject.id;
        //alert(document.getElementById(id.toString()).title);
        var divs = document.getElementsByTagName('div');
        var actionid;
       // alert(window.flag[2]);
        for(var i=0;i<divs.length;i++){
            
            if(divs[i].id===id && (typeof(window.flaglink[i]) === 'undefined' || window.flaglink[i] === null || window.flaglink[i] === 0)){
                    divs[i].style.backgroundColor = "blue";
                    divs[i].style.opacity=0.5;
                    var title;
                    window.flaglink[i]=1;
                   // alert(window.flag[i]);
                   actionid="add";
                    
            }
            else if(divs[i].id===id && window.flaglink[i]===1)
            {
                    divs[i].style.backgroundColor = "white";
                    divs[i].style.opacity=0.0;
                    
                    window.flaglink[i]=0;
                   // alert(window.flag[i]);
                   actionid="remove";
                    
            }
          
        }
        if(actionid==="add")
        {
            window.divtitlelink+=document.getElementById(id.toString()).title.toString();
            
           // document.getElementById("editorforlink:selectedlinktext").value=window.divtitlelink;
            
            
            window.sentecesidlink +=id+",";

            
           // alert("sentenceid: "+window.sentecesid);
           // alert("title: "+window.divtitlelink);
            
        }
        else if(actionid==="remove")
        {
            window.sentecesidlink=window.sentecesidlink.replace(id+",",'');
            window.divtitlelink=window.divtitlelink.replace(document.getElementById(id.toString()).title.toString(),'');
           // document.getElementById("editorforlink:selectedlinktext").value=window.divtitlelink;
            
            
           
            
           // alert("sentenceid: "+window.sentecesid);
           // alert("title: "+window.divtitle);
           
        }
    }
}

/*function getID(oObject) 
{
    var id = oObject.id;
    
    
    //oObject.style.backgroundColor = "blue";
    //oObject.style.opacity=0.5;
    //alert(id);
    
    var divs = document.getElementsByTagName('div');
    
    for(var i=0;i<divs.length;i++){
        if(divs[i].id===id){
            
            //document.getElementById("editorsences:selecteddiv").value=id;
            
            divs[i].style.backgroundColor = "blue";
            divs[i].style.opacity=0.5;
        }
        
        
    }
    window.sentecesid +=","+id;
    //alert(window.sentecesid);
    //alert(document.getElementById("editorsences:selecteddiv").value.concat(",").concat(id));
    //id.style.backgroundColor = "yellow";
    //id.style.opacity=0.5;
    //alert("This object's ID attribute is set to \"" + id + "\"."); 
}*/
window.pageid="";
function detectPage(oObject,e)
{
        var id = oObject.id;    
        window.pageid=id;
      //  alert("pageid: "+window.pageid);
        document.getElementById("annotateform:annotatepageid").value=window.pageid;
        document.getElementById("commentform:commentpageid").value=window.pageid;
        document.getElementById("editorsences:quotepageid").value=window.pageid;
        //document.getElementById("listform:selectedpageid").value=window.pageid;
        document.getElementById("linkupdateform:selectedpageid").value=window.pageid;
        
        //alert(window.sentecesid);
}
window.sentecesid="";
window.divtitle="";
window.flag=new Array();
//window.flag.length=document.getElementsByTagName('div');
//window.flag=new FilledArray(window.flag.length-1, 0);
function detectMouse(oObject,e)
{
    //alert(oObject.id);
    var button;
    e = e || window.event;

    if (e.which === null)
    {
        button = (e.button < 2) ? 'left' :
            ((e.button == 4) ? 'middle' : 'right');
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
        //alert(document.getElementById(id.toString()).title);
        var divs = document.getElementsByTagName('div');
        var actionid;
       // alert(window.flag[2]);
        for(var i=0;i<divs.length;i++){
            
            if(divs[i].id===id && (typeof(window.flag[i]) === 'undefined' || window.flag[i] === null || window.flag[i] === 0)){
                    divs[i].style.backgroundColor = "blue";
                    divs[i].style.opacity=0.5;
                    var title;
                    window.flag[i]=1;
                   // alert(window.flag[i]);
                   actionid="add";
                   // alert(id);
                 //  alert("flag"+window.flag[i]);
                    
            }
            else if(divs[i].id===id && window.flag[i]===1)
            {
                    divs[i].style.backgroundColor = "white";
                    divs[i].style.opacity=0.0;
                    
                    window.flag[i]=0;
                    //alert(id);
                    //alert("flag"+window.flag[i]);
                   // alert(window.flag[i]);
                   actionid="remove";
                    
            }
          
        }
        if(actionid==="add")
        {
            window.divtitle+=document.getElementById(id.toString()).title.toString();
           // document.getElementById("form2:codeselectiontext1").value=window.divtitle;
            //document.getElementById("form2:codeselectiontext").value=window.divtitle;
            document.getElementById("selectedcodeform:codeselectiontext").value=window.divtitle;
            document.getElementById("selectedcodeform:codeselectiontext1").value=window.divtitle;
                        //alert(document.getElementById("form2:codeselectiontext").value);
            window.sentecesid +=id+",";

            
           // alert("sentenceid: "+window.sentecesid);
           // alert("title: "+window.divtitle);
            
        }
        else if(actionid==="remove")
        {
            window.sentecesid=window.sentecesid.replace(id+",",'');
            window.divtitle=window.divtitle.replace(document.getElementById(id.toString()).title.toString(),'');
           // document.getElementById("form2:codeselectiontext1").value=window.divtitle;
            //document.getElementById("form2:codeselectiontext").value=window.divtitle;
            document.getElementById("selectedcodeform:codeselectiontext").value=window.divtitle;
            document.getElementById("selectedcodeform:codeselectiontext1").value=window.divtitle;
            
            
           
            
           // alert("sentenceid: "+window.sentecesid);
           // alert("title: "+window.divtitle);
           
        }
    }
    /*if(window.event.ctrlKey)
    {
       if(button==='left')
       {
            alert("ctrl press");
       }
       alert("ctrl press");
    }*/
}

function selectedSenteces()
{
    if(window.sentecesid.endsWith(","))
    {
        window.sentecesid = window.sentecesid.substring(0,window.sentecesid.length - 1);
    }
    if(window.sentecesidlink.endsWith(","))
    {
        window.sentecesidlink = window.sentecesidlink.substring(0,window.sentecesidlink.length - 1);
    }
    document.getElementById("editorsences:selecteddiv").value=window.sentecesid;
    document.getElementById("editorsences:qselectedtext").value=window.divtitle;
    
    document.getElementById("commentform:commentselecteddiv").value=window.sentecesid;
    document.getElementById("commentform:cselectedtext").value=window.divtitle;
    
    document.getElementById("annotateform:annotateselecteddiv").value=window.sentecesid;
    document.getElementById("annotateform:selectedtext").value=window.divtitle;
    
    document.getElementById("linkupdateform:selectedids").value=window.sentecesid;
    document.getElementById("linkupdateform:selectedlinkids").value=window.sentecesidlink;
    
    
    document.getElementById("linkupdateform:selectedtext").value=window.divtitle;
    document.getElementById("linkupdateform:selectedlinktext").value=window.divtitlelink;
    
   // document.getElementById("editorforlink:resourcelinkid").value=document.getElementById("editorforlink:cities").options[document.getElementById("editorforlink:cities").selectedIndex].value;
    
    //alert(document.getElementById("editorforlink:resourcelinkid").value);
    
    //alert(document.getElementById("editorsences:selecteddiv").value);
    window.sentecesid="";
    window.divtitle="";
    window.divtitlelink="";
    window.sentecesidlink="";
    
}
function openlinkwindow(sids)
{
   // alert(sids);
    
    var str_array = sids.split(',');
    var divs = document.getElementsByTagName('div');
    var saveid;
    //document.getElementById("linkupdateform:openlinkwindow").value=rid;
    for(var i=0;i<divs.length;i++){
        for(var j = 0; j < str_array.length; j++)
        {
            if(str_array[j]!=="")
            {    
                if(divs[i].id===str_array[j])
                {
                    //alert(str_array[j]);
                    window.location.hash='anotatepages/editorforlink.xhtml#'+divs[i].id;
                    //window.open('anotatepages/editorforlink.xhtml#'+divs[i].id, 'popupWindow', 'width=700,height=650, dependent=yes, menubar=no, toolbar=no');
                    //window.location.hash = 'anotatepages/editorforlink.xhtml#'+divs[i].id;
                   // document.getElementById(str_array[j]).setAttribute('title',slink);
                   // document.getElementById("tooltiptest").value=comment;
                   divs[i].style.backgroundColor = "green";
                    divs[i].style.opacity=0.5;
                    saveid=divs[i].id.toString();
                }
            }
        }
    }
    
}
function SavedLink(sids,rid,lrid)
{
    var str_array = sids.split(',');
    var str_array_r = lrid.split(',');
    var divs = document.getElementsByTagName('div');
    var saveid;
    document.getElementById("listform:openlinkwindow").value=rid;
    //alert(document.getElementById("listform:openlinkwindow").value);
    for(var i=0;i<divs.length;i++){
        for(var j = 0; j < str_array.length; j++)
        {
            if(divs[i].id===str_array[j])
            {
                divs[i].style.backgroundColor = "green";
                divs[i].style.opacity=0.5;
                window.location.hash = '#'+divs[i].id;
               // document.getElementById(str_array[j]).setAttribute('title',slink);
               // document.getElementById("tooltiptest").value=comment;
                saveid=divs[i].id.toString();
            }
            else
            {
                divs[i].style.backgroundColor = "";
            }
        }
    }
    
   /* for(var i=0;i<divs.length;i++){
        for(var j = 0; j < str_array_r.length; j++)
        {
            if(divs[i].id===str_array_r[j])
            {
                divs[i].style.backgroundColor = "green";
                divs[i].style.opacity=0.5;
                window.location.hash = '#'+divs[i].id;
               // document.getElementById(str_array[j]).setAttribute('title',slink);
               // document.getElementById("tooltiptest").value=comment;
                saveid=divs[i].id.toString();
            }
           
        }
    }*/
 //   alert('d');
}
function SavedComment(sids,comment)
{
    var str_array = sids.split(',');
    var divs = document.getElementsByTagName('div');
    var saveid;
    
    for(var i=0;i<divs.length;i++){
        for(var j = 0; j < str_array.length; j++)
        {
            if(divs[i].id===str_array[j])
            {
                divs[i].style.backgroundColor = "brown";
                divs[i].style.opacity=0.5;
                window.location.hash = '#'+divs[i].id;
                document.getElementById(str_array[j]).setAttribute('title',comment);
               // document.getElementById("tooltiptest").value=comment;
                saveid=divs[i].id.toString();
            }
            else
            {
                divs[i].style.backgroundColor = "";
            }
            
        }
    }
    //document.getElementById(saveid).title=comment;
    //alert(document.getElementById(saveid).title);
}
function SavedQuoted(sids)
{
    //alert(sids);
    var str_array = sids.split(',');
    var divs = document.getElementsByTagName('div');
    for(var i=0;i<divs.length;i++){
        for(var j = 0; j < str_array.length; j++)
        {
            if(divs[i].id===str_array[j])
            {
                divs[i].style.backgroundColor = "blueviolet";
                divs[i].style.opacity=0.5;
                window.location.hash = '#'+divs[i].id;
            }
            else
            {
                divs[i].style.backgroundColor = "";
            }
           
        }
        
    }
    
}
function SavedAnnoted(sids)
{
    //alert(sids);
    var str_array = sids.split(',');
    var divs = document.getElementsByTagName('div');
    for(var i=0;i<divs.length;i++){
        for(var j = 0; j < str_array.length; j++)
        {
            if(divs[i].id===str_array[j])
            {
                divs[i].style.backgroundColor = "#0b93d5";
                divs[i].style.opacity=0.5;
                window.location.hash = '#'+divs[i].id;
            }
            else
            {
                divs[i].style.backgroundColor = "";
            }
           
        }
    }
    
}
/*function RemoveMark(oObject) 
{
    var id = oObject.id;
    //oObject.style.backgroundColor = "blue";
    //oObject.style.opacity=0.5;
    var divs = document.getElementsByTagName('div');
    for(var i=0;i<divs.length;i++){
        if(divs[i].id===id){
      //do stuff here for every divs[i]
            
            divs[i].style.backgroundColor = "white";
            divs[i].style.opacity=0.0;
        }
    }
    window.sentecesid.replace(id+",","");
    alert(window.sentecesid);
    //id.style.backgroundColor = "yellow";
    //id.style.opacity=0.5;
    //alert("This object's ID attribute is set to \"" + id + "\"."); 
}*/
/*$(document).ready(function(){ 
    $('.sentences span').click(function(){
        alert('d');
        $(this).toggleClass('selected');
    });
});*/
var theSelection = '';
function selectFinished() {
	theSelection = document.getSelection();
	theSelectionRange = theSelection.getRangeAt(0);
	theSelectionRect = theSelectionRange.getBoundingClientRect();
	
	var markTop = theSelectionRect.top + theSelectionRect.height;
	var mark1Left = theSelectionRect.left - 10;
	var mark2Left = theSelectionRect.right;
        
        //alert(markTop+":"+mark2Left);
        document.getElementById("x").value=markTop;
        document.getElementById("y").value=mark1Left;
        document.getElementById("z").value=mark2Left;
	
	document.getElementById("markerLeft").style.top = markTop+"px";
	document.getElementById("markerLeft").style.left = mark1Left+"px";
	document.getElementById("markerLeft").style.display = "block";
	
	document.getElementById("markerRight").style.top = markTop+"px";
	document.getElementById("markerRight").style.left = mark2Left+"px";
	document.getElementById("markerRight").style.display = "block";
}
function markSelectedText()
{
    var range = window.getSelection().getRangeAt(0);
    var newNode = document.createElement("mark");
    range.surroundContents(newNode);

    return false;
}
function getTextofEditor()
{
    var content=window.getSelection().getRangeAt(0);
    alert(content);
    return false;
}
function getSelectedWordIndex() {
    if (window.getSelection) {
        var sel = window.getSelection();
        var div = document.getElementById("Content");
    
        if (sel.rangeCount) {
            // Get the selected range
            var range = sel.getRangeAt(0);
    
            // Check that the selection is wholly contained within the div text
            if (range.commonAncestorContainer == div.firstChild) {
                var precedingRange = document.createRange();
                precedingRange.setStartBefore(div.firstChild);
                precedingRange.setEnd(range.startContainer, range.startOffset);
                var textPrecedingSelection = precedingRange.toString();
                var wordIndex = textPrecedingSelection.split(/\s+/).length;
                alert("Word index: " + wordIndex);
            }
        }
    }
}
function saveSelection() {
    if (window.getSelection) {
        sel = window.getSelection();
        if (sel.getRangeAt && sel.rangeCount) {
            var ranges = [];
            for (var i = 0, len = sel.rangeCount; i < len; ++i) {
                ranges.push(sel.getRangeAt(i));
            }
            return ranges;
        }
    } else if (document.selection && document.selection.createRange) {
        return document.selection.createRange();
    }
    return null;
}

function restoreSelection(savedSel) {
    if (savedSel) {
        if (window.getSelection) {
            sel = window.getSelection();
            sel.removeAllRanges();
            for (var i = 0, len = savedSel.length; i < len; ++i) {
                sel.addRange(savedSel[i]);
            }
        } else if (document.selection && savedSel.select) {
            savedSel.select();
        }
        
    }
}

    function getLinksInSelection() {
        var selectedLinks = [];
        var range, containerEl, links, linkRange;
        if (window.getSelection) {
            sel = window.getSelection();
            if (sel.getRangeAt && sel.rangeCount) {
                linkRange = document.createRange();
                for (var r = 0; r < sel.rangeCount; ++r) {
                    range = sel.getRangeAt(r);
                    containerEl = range.commonAncestorContainer;
                    if (containerEl.nodeType != 1) {
                        containerEl = containerEl.parentNode;
                    }
                    if (containerEl.nodeName.toLowerCase() == "a") {
                        selectedLinks.push(containerEl);
                    } else {
                        links = containerEl.getElementsByTagName("a");
                        for (var i = 0; i < links.length; ++i) {
                            linkRange.selectNodeContents(links[i]);
                            if (linkRange.compareBoundaryPoints(range.END_TO_START, range) < 1 && linkRange.compareBoundaryPoints(range.START_TO_END, range) > -1) {
                                selectedLinks.push(links[i]);
                            }
                        }
                    }
                }
                linkRange.detach();
            }
        } else if (document.selection && document.selection.type != "Control") {
            range = document.selection.createRange();
            containerEl = range.parentElement();
            if (containerEl.nodeName.toLowerCase() == "a") {
                selectedLinks.push(containerEl);
            } else {
                links = containerEl.getElementsByTagName("a");
                linkRange = document.body.createTextRange();
                for (var i = 0; i < links.length; ++i) {
                    linkRange.moveToElementText(links[i]);
                    if (linkRange.compareEndPoints("StartToEnd", range) > -1 && linkRange.compareEndPoints("EndToStart", range) < 1) {
                        selectedLinks.push(links[i]);
                    } 
                }
            }
        }
        return selectedLinks;
    }

function createLink() {
    // There's actually no need to save and restore the selection here. This is just an example.
     var savedSel = saveSelection();
     var url = document.getElementById("url").value;
    
    restoreSelection(savedSel); 
    document.execCommand("CreateLink", false, url);
    alert (document.execCommand("CreateLink", false, url));
    var links = getLinksInSelection();
    for (var i = 0; i < links.length; ++i) {
        links[i].style.fontWeight = "bold";
    }
    alert ("done");
}

function createLink2(){
    var url = document.getElementById("url").value;
    var a = window.getSelection().getRangeAt(0);
    var b = a.toString();
    var z = document.createElement("span");
    //var l2 = prompt("Enter URL:", url);
    b = b.link(url);
    z.innerHTML=b;
    a.deleteContents();
    a.insertNode(z); 
}

/*function highlightWordPositions(word, color) {
    var $paras = $('#pdfdoc'),
        $spans,
        _top = 0,
        _left = 0;
    
    $paras.each(function(){
        var $p = $(this),
            regex = new RegExp(word, 'g');
        
        $p.html($p.text().replace(regex, '<span>' + word + '</span>'));
        $spans = $p.find('span');
    
        $spans.each(function(){
            var $span = $(this),
                $offset = $span.offset(),
                $overlay = $('<div class="overlay"/>');
    
            $overlay
                .offset($offset)
                .css({
                    width: $span.innerWidth(),
                    height: $span.innerHeight()
                });
     
            $(document.body).append($overlay);
        });
    });
}*/

$('#term1').keyup(function(event){
    var term = this.value;
    
    if (term == '') {
        $('.overlay').remove();
        return false;
    } else if (term.indexOf(' ') != -1) {
        this.value = term.replace(' ', '');
        return false;
    }
        
    $('.overlay').remove();
    
    highlightWordPositions(term);
});

/*$(document).ready(function(){
  /*$('.selection').click(function(){
        $('.selection').css('background-color', 'transparent');
       $(this).css('background-color', 'yellow');
      
       
         
    }); 
    $('#Content span').click(function(){
        $(this).toggleClass('selected');
         //var a = window.getSelection().getRangeAt(0);
         //alert(a);
    });

});*/

//$(document).ready(function(){

    /*$('#Content').each(function() {
     $(this).html($(this).text().split(/([\.\?!])(?= )/).map(
       function(v){return '<span class=sentence>'+v+'</span>'}
    ));
 });


 $('.sentence').click(function(){
     alert($(this).text());
 });*/
/*
 $(document).ready(function(){  
    $("#Content").each(function() {
        //event.preventDefault();
         var sentences = $(this)
             .text()
             .replace(/([^.!?]*[^.!?\s][.!?]['"]?)(\s|$)/g, 
                      '<span class="sentence">$1</span>$2');
         $(this).html(sentences);
         //event.preventDefault();
     });
   });
*/
    /*$("#pdfdoc").each(function() {
        $(this).html($(this).text().split(/([\.\?!])(?= )/).map(
          function(v){return '<span class=sentence>'+v+'</span>'}
       ));
    });
       
       
    $('.sentence').click(function(){
        alert($(this).text());
    });*/

//});

function selectSentences(){
    //var url = document.getElementById("pdfdoc").innerHTML;
    
    //var z = document.createElement("span");
    //var l2 = prompt("Enter URL:", url);
    //var a=url.replace(/([^.!?]*[^.!?\s][.!?]['"]?)(\s|$)/g, 
      //               '<span class="sentence">$1</span>$2');
    //alert(a);
    //document.getElementById("pdfdoc").innerHTML=a;
    //b = b.link(url);
    //z.innerHTML=b;
    //a.deleteContents();
    //a.insertNode(z); 
    //document.body.innerHTML=document.body.innerHTML/replace(/([^.!?]*[^.!?\s][.!?]['"]?)(\s|$)/g, 
      //               '<span class="sentence">$1</span>$2');
}
