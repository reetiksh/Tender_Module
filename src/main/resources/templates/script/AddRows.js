/**
 * java script file to create dynamic rows on button click
 */
function addRowDD(formName,name,tableID,columns,btn) 
{
        var table = document.getElementById(tableID);
        //debugger;
        var rowCount = table.rows.length;
        var row = $(btn).closest("tr");
        if(name)
        {
        	var cells=$(row).find(".form-control");
        	for(var i=0;i<cells.length;i++){
        		var t=$(cells[i]).val();
        		if(t.trim()==""){
        			alert("Fill Previous row first");
        			$(cells[i]).focus();
        			return false;
        		}
        		
        	}
        }
        var step;
        var c="";
        var rowN = table.insertRow($(row).index()+1);
        $(rowN).attr("class","dataRow");
        $(rowN).html($(row).html());
        $(rowN).find(".form-control").first().focus();
        FindFirst($(table));
} 
function delRow(delBtn) 
{
	 var elem = $(delBtn).parent('td').parent('tr').parent('tbody');
	    $(delBtn).parent('td').parent('tr').remove();
	    FindFirst(elem);
} 
function addButton(formName,name,tableID) 
{
       var table = document.getElementById(tableID);
        var rowCount = table.rows.length;
        var row = table.insertRow(rowCount);
        var counts = rowCount ;
        var cell1 = row.insertCell(0);
        var cols1 = document.createElement("input");
    	cols1.type = "file";
    	cols1.name = name+"[" + counts + "].userImage";
    	cols1.id = formName+"_" +name+"_"+ counts + "__userImage";
    	 cell1.appendChild(cols1);
         cell1 = row.insertCell(1);
        var cols1 = document.createElement("input");
    	cols1.type = "text";
    	cols1.name = name+"[" + counts + "].uiName";
    	cols1.id = formName+"_" +name+"_"+ counts + "__uiName";
        cell1.appendChild(cols1);
       
    }  


  
function addCol(name,tableID,columns,name1,tableID1,columns1) 
{
	   var table = document.getElementById(tableID);
	   var i=0;
	   for(i=0;i<4;i++)
	   {
       var rowCount = table.rows.length;
       var row = table.insertRow(rowCount);
       var counts = rowCount - 1;
       var cell1 = row.insertCell(0);
       var cols1 = document.createElement("label");
       cols1.type = "label";
       cols1.text = name+"[" + counts + "]."+columns[i];
       cols1.value = name+"[" + counts + "]."+columns[i];
       cell1.appendChild(cols1);
       cell1 = row.insertCell(1);
       cols1  = document.createElement("input");
       cols1.type = "text";
       cols1.name = name+"[" + (counts-6-i+1) + "]."+columns[i];
       cols1.value = name+"[" + (counts-6-i+1) + "]."+columns[i];
       cell1.appendChild(cols1);
	   }
	  table = document.getElementById(tableID1);

       var rowCount = table.rows.length;
       var row = table.insertRow(rowCount);
       var counts = rowCount - 1;
       
       var step;
       for (step = 0; step < columns1.length; step++) {
       	var cell1 = row.insertCell(step);
           var cols1 = document.createElement("input");
       	cols1.type = "text";
       	cols1.name = name1+"[" + counts + "]."+columns1[step];
       	cols1.value = name1+"[" + counts + "]."+columns1[step];
       	cell1.appendChild(cols1);
       }
      
       }
function addRowForUtc(formName,flag,tableID,columns,addBtn)
{
        var table = $('#'+tableID).find('tbody')[0];
        debugger;
        var rowCount = table.rows.length;
        var counts = $(addBtn).closest('tr').index();;
        if(flag && counts!=-1)
        {
        	var r1=$(addBtn).closest('tr')[0];
            for(var i=0;i<r1.cells.length;i++){
            	var t=trim(r1.cells[i].childNodes[0].value);
            	switch(r1.cells[i].childNodes[0].type){
            	case  'INPUT':
            	case 'select-one':
            	case 'textarea':
            		var isReq=r1.cells[i].childNodes[0].getAttribute("required");
            		if(isReq=="true" && t==""){
            			alert("Fill Previous row first");
            			r1.cells[i].childNodes[0].focus();
            			return false;
            		}
            	break;
            	}
        		
        	}
        }
        var step;
        var row = table.insertRow(counts+1);
        $(row).attr("class","dataRow");
        var prRow=table.rows[counts];
        for(var i=0;i<prRow.cells.length;i++){
        	var cell1 = row.insertCell(i);
        	if(i!=4){
        			cell1.innerHTML=prRow.cells[i].innerHTML;
        			cell1.style=prRow.cells[i].style;
        			/*if(cell1.childNodes[0].type=="select-one")
        				cell1.childNodes[0].innerHTML="";*/
        	}else if(i==5){
        		cell1.innerHTML='<a class="formbuttonadd Btn View btnIcon btnXSmallIcon add" id="buttonOk" title="Add" '+
        		'onclick="addRowForUtc(\'saveUtcDoc\',true,\'utcRules\',new Array(\'Row\',\'sno\',\'testCon\',\'expRes\',\'acRes\',\'exRes\',\'actRes\'),$(this))">'+
        		'<i class="fa fa-plus"></i></a>'+
        		'<a class="Btn Delete btnXSmallIcon btnIcon del" style="display:none;"  id="buttonOk" title="Remove" onclick="delRow(\'saveUtcDoc\',\'utcRules\',\'utcRules\')">'+
        		'<i class="fa fa-minus"></i></a>';
        	}else{
        			cell1.innerHTML='<input type="file" name="testScreen" id="testScreen"  multiple onchange="checkUploadImage(this)" '+
        				' required=false class="form-control" /><input type="hidden" name="imageData"/> ';
        			cell1.style=prRow.cells[i].style;
        	    	
        		}
        	
        }
        if(flag)
        $(row).find(".form-control").val("");
        row.cells[0].childNodes[0].focus();
        FindFirst(table);
} 