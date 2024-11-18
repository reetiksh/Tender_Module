var ide;
var ide2;
var ide3;

function delBugRow(tName){
	//debugger;
	var table=document.getElementById(tName);
	var rowCount=table.rows.length;
	var flag=false;
	if(rowCount==1 && table.rows[0].cells[0].childNodes[0]!=null && table.rows[0].cells[0].childNodes[0].checked==true){
		table.rows[0].cells[0].childNodes[0].checked=false;
		table.rows[0].cells[1].childNodes[0].value="-1";
		table.rows[0].cells[2].childNodes[0].value="";
		table.style.display="none";
		/*if(document.getElementById("ptStatusF").checked){
			alert("Row 1 cann't be deleted if point status is failed")
			return false;
		}*/
		flag=true;
	}
	else{
		for(var n=1;n<rowCount;n++)
		{	
			var chk=table.rows[n].cells[0].childNodes[0];
			if(chk!=null && chk.checked==true){
				table.deleteRow(n--);
				flag=true;
				rowCount--;
			}
		}
	}
	if(!flag)
	{
		alert("Please select a check box");
		return false;
	}/*else if(table.rows.length==0){
		table=document.getElementById("mainTab");
		table.rows[6].cells[0].style.display="none";
		table.rows[7].cells[0].style.display="none";
		//table.rows[8].cells[0].childNodes[0].innerHTML="";
		table.rows[8].cells[0].childNodes[0].style.display="none";
		table.rows[8].cells[0].childNodes[1].childNodes[1].style.display="none";
		//table.rows[8].cells[0].childNodes[1].childNodes[3].style.display="none";
	}*/
}


function showBugsAssign(){
	var empid=document.getElementById("pointNo").value;
	if(empid=="-1")
	{
		alert("Please enter Point ID");
		document.getElementById("pointNo").focus();
		return false;
	}
	else{
		var url="getAssignBugs.action?id="+empid;
		xhr=createAjax();
		xhr.open('POST',url,false);
		xhr.onreadystatechange=function() {getAssignBugs() } ;
		xhr.send();
	}
}
function back(){
	window.location.href="cancelQC";
}
function displayDesc(){
	var ptNo=document.getElementById("pointNo").value;
	if(ptNo==""){
		alert("Enter Point ID");
		document.getElementById("pointNo").value="";
		document.getElementById("pointDesc").value="";
		document.getElementById("resName").value="";
		document.getElementById("resourceID").value="";
		document.getElementById("pointNo").focus();
		var table=document.getElementById("mainTab");
		table.rows[4].cells[0].style.display="none";
		table.rows[5].cells[0].style.display="none";
		table.rows[5].cells[0].childNodes[0].innerHTML="";
		document.getElementById("ptStatusF").checked=false;
		document.getElementById("ptStatusP").checked=false;
		table.rows[6].cells[0].style.display="none";
		table.rows[7].cells[0].style.display="none";
		table.rows[8].cells[0].childNodes[1].childNodes[1].style.display="none";
		table.rows[8].cells[0].childNodes[0].style.display="none";
		//table.rows[8].cells[0].childNodes[1].childNodes[3].style.display="none";
		deleteRows(table.rows[8].cells[0].childNodes[1].childNodes[1]);
		return false;
	}
	var url="getPointDesc.action?pointNo="+ptNo;
	//var url="getPointDesc.action?pointNo="+ptNo+"&empID=11";
	xhr = createAjax();
	xhr.open('POST',url,false);
	xhr.onreadystatechange=function() {getPointDesc1() } ;
	xhr.send();
}

function getPointDesc1(){

	if (xhr.readyState==4 && xhr.status==200)
	{
		var res=xhr.responseText;

		if(res=="")
		{
			alert("No Data Found..");
			document.getElementById("pointNo").value="";
			document.getElementById("pointDesc").value="";
			document.getElementById("resName").value="";
			document.getElementById("resourceID").value="";
			document.getElementById("pointNo").focus();
			var table=document.getElementById("mainTab");
			table.rows[3].cells[0].style.display="none";
			table.rows[3].cells[1].style.display="none";
			table.rows[4].style.display="none";
			table.rows[5].style.display="none";
			table.rows[4].cells[0].style.display="none";
			table.rows[5].cells[0].style.display="none";
			table.rows[5].cells[0].childNodes[0].innerHTML="";
			document.getElementById("ptStatusF").checked=false;
			document.getElementById("ptStatusP").checked=false;
			table.rows[6].cells[0].style.display="none";
			table.rows[7].cells[0].style.display="none";
			table.rows[8].cells[0].childNodes[1].childNodes[1].style.display="none";
			table.rows[8].cells[0].childNodes[0].style.display="none";
			//table.rows[8].cells[0].childNodes[1].childNodes[3].style.display="none";
			deleteRows(table.rows[8].cells[0].childNodes[1].childNodes[1]);
			return false;
		}
		else
		{
			//debugger;
			var d=res.split("@");
			//alert(res);
			document.getElementById("pointDesc").value=d[0];
			document.getElementById("resName").value=d[1];
			document.getElementById("resourceID").value=d[2];
			if(d[3]=="F")
			{ 
				document.getElementById("ptStatusF").checked=true;
				var data=d[4].split("|");
				var datalen=data.length;
				var tab="<table  border='1' style='width:100%;border-collapse:collapse;/*border-color:ghostwhite;*/'><tr>" +
				"<td class='tabHeader' style='text-align:center;width:2%'>S No.</td><td  class='tabHeader' style='text-align:center;'>Severity Type</td>" +
				"<td  class='tabHeader' style='padding-left:16%;'>Bug Description</td><td  class='tabHeader' style='padding-left: 3%;'>Bug Status</td>" +
				"<td  class='tabHeader' style='padding-left:3%;'>ScreenShots</td></tr>";
				var k=0;
				for(var i=0;i<data.length-1;i=i+5){
					var sevrt=data[i+1].split("~");
					if(sevrt[0]=="-")
						sevrt[0]="-1";
					tab+="<tr><td style='width:2%;text-align:center;'>"+(k+1)+". </td>" +
					"<td style='width:10%;word-wrap: break-word;text-align:left;padding-left:0.5%'>"+sevrt[1]+"</td>" +
					"<td style='width:40%;word-wrap: break-word;padding-left:0.5%'>"+data[i]+"</td>" +
					"<td style=' width:12%;padding-left:0.5%'><select style='width:150px;' class='form-control' id=severity_status"+[k]+" name='severity_status'>" +
					"<option value='-1'>-Select-</option>" +
 					"<option value='P'>Pass</option>" +
					"<option value='F'>Fail</option>" +
					"</select>" +
					"<input type='hidden' name='preSerType' value='"+sevrt[0]+"~"+data[i]+"' />" +
					"<input type='hidden' name='bugs_kid' value='"+data[i+3]+"' />" +
					"</td>";
					if(data[i+4]=="Y")
						tab+="<td style='padding-left:3%;'><input type='button' value='Download' class='buttonOper' id='downloadImage'  style='width:70%'   name='downloadImage' onClick='getImages("+data[i+3]+");'><input type='hidden' name='pr_hasImage' value='N~"+data[i+3]+"'/></td>"
						else
							tab+="<td style='padding-left:3%;'><input type='file' id='screenShots' name='pr_screenShots' class='form-control' style='width:70%' onchange='checkImage(this)'><input type='hidden' name='pr_hasImage' value='N~"+data[i+3]+"'/></td>";
					tab+="</tr>"
						k++;
				}
				showTable('display');
				var table=document.getElementById("mainTab");
				if(d[4]!="noBugs" && datalen!=0){
					table.rows[4].style.display="table-row";
					table.rows[5].style.display="table-row";
					table.rows[4].cells[0].style.display="table-cell";
					table.rows[5].cells[0].style.display="table-cell";
					table.rows[5].cells[0].childNodes[0].style.display="block";
					table.rows[5].cells[0].childNodes[0].innerHTML=tab;
				}else{
					table.rows[4].style.display="none";
					table.rows[5].style.display="none";
				}

				var p=2;
				for(var i=0;i<k;i++){
					if(data[p]==null || data[p]==undefined)
						data[p]="-1";
					document.getElementById('severity_status'+i+'').value=data[p];
					p=p+5;
				}

			}
			else if(d[3]=="P")
			{
				document.getElementById("ptStatusP").checked=true;
				document.getElementById("remark").value=d[4];
				//document.getElementById("remarkTR").style.display="table-row";
				var table=document.getElementById("mainTab");
				table.rows[3].cells[0].style.display="table-cell";
				table.rows[3].cells[1].style.display="table-cell";
				table.rows[4].cells[0].style.display="none";
				table.rows[5].cells[0].style.display="none";
				table.rows[5].cells[0].childNodes[0].innerHTML="";
				table.rows[6].cells[0].style.display="none";
				table.rows[7].cells[0].style.display="none";
				table.rows[8].cells[0].childNodes[1].childNodes[1].style.display="none";
				table.rows[8].cells[0].childNodes[0].style.display="none";
				//table.rows[8].cells[0].childNodes[1].childNodes[3].style.display="none";
				deleteRows(table.rows[8].cells[0].childNodes[1].childNodes[1]);
			}
			else
			{
				var table=document.getElementById("mainTab");
				table.rows[3].cells[0].style.display="none";
				table.rows[3].cells[1].style.display="none";
				table.rows[4].style.display="none";
				table.rows[5].style.display="none";
				table.rows[4].cells[0].style.display="none";
				table.rows[5].cells[0].style.display="none";
				table.rows[5].cells[0].childNodes[0].innerHTML="";
				document.getElementById("ptStatusF").checked=false;
				document.getElementById("ptStatusP").checked=false;
				table.rows[6].cells[0].style.display="none";
				table.rows[7].cells[0].style.display="none";
				table.rows[8].cells[0].childNodes[1].childNodes[1].style.display="none";
				table.rows[8].cells[0].childNodes[0].style.display="none";
				//table.rows[8].cells[0].childNodes[1].childNodes[3].style.display="none";
				deleteRows(table.rows[8].cells[0].childNodes[1].childNodes[1]);
			//	hideRows(table);
			}
			document.getElementById("fetchStatus").value=d[3];
		}
	}
} 

function getMasterSeverity(ide) {

	var url = "getSeverityAction.action?";
	xhr = createAjax();
	xhr.open('POST', url, true);
	xhr.onreadystatechange = function() {
		showMessageinfo(ide);
	};
	xhr.send();
}

function showMessageinfo(ide2) {
	if (xhr.readyState == 4 && xhr.status == 200) {
		var val = xhr.responseText;
		var ph = val.split("~");

		var j=1;

		if(ide2==undefined){
			for(var i=1;i<ph.length;i=i+2){  
				document.getElementById("severity_type[0]").options[j]= new Option(ph[i+1],ph[i]);
				j++;
			}
		}
		if(ide2>=0)
		{

			document.getElementById('severity_type['+ide2+']').options[0]= new Option("--select--","-1");
			for(var i=1;i<ph.length;i=i+2)
			{
				document.getElementById('severity_type['+ide2+']').options[j]= new Option(ph[i+1],ph[i]);

				j++;
			}
		}

	}
}
function showTable(flag){
	//debugger;
	var table=document.getElementById("mainTab");
	var pass=document.getElementById("ptStatusP").checked;
	var fail=document.getElementById("ptStatusF").checked;
	var fetchStatus=document.getElementById("fetchStatus").value;
	var newStatus='';
	if(pass==true){
		//for remarks
		table.rows[3].cells[0].style.display="table-cell";
		table.rows[3].cells[1].style.display="table-cell";
		//for previous row
		table.rows[4].cells[0].style.display="none";
		table.rows[5].cells[0].style.display="none";
		table.rows[5].cells[0].childNodes[0].innerHTML="";
		//for bug details
		table.rows[6].cells[0].style.display="none";
		table.rows[7].cells[0].style.display="none";
		//table.rows[8].cells[0].childNodes[0].innerHTML="";
		table.rows[8].cells[0].childNodes[0].style.display="none";
		table.rows[8].cells[0].childNodes[1].childNodes[1].style.display="none";
		//table.rows[8].cells[0].childNodes[1].childNodes[3].style.display="none";
		deleteRows(table.rows[8].cells[0].childNodes[1].childNodes[1]);
		newStatus='P';
	}
	else if(fail==true)
	{
		//for remarks
		table.rows[3].cells[0].style.display="none";
		table.rows[3].cells[1].style.display="none";
		if(table.rows[3].cells[1].childNodes[1]!=null)
			table.rows[3].cells[1].childNodes[1].value="";
		/*//for previous row
			table.rows[4].cells[0].style.display="table-cell";
			table.rows[5].cells[0].style.display="table-cell";*/
		//table.rows[5].cells[0].childNodes[0].innerHTML="";
		//for bug details
		table.rows[6].cells[0].style.display="table-cell";
		table.rows[7].cells[0].style.display="table-cell";
		table.rows[8].cells[0].childNodes[0].style.display="block";
		table.rows[8].cells[0].childNodes[1].childNodes[1].style.display="inline-block";
		//table.rows[8].cells[0].childNodes[1].childNodes[3].style.display="inline";
		newStatus='F';
	}
	if(fetchStatus==newStatus && flag=='fetch'){
		displayDesc();
	}
}
function deleteRows(table){
	var rowCount=table.rows.length;
	if(rowCount!=1)
	{
		for(var i=1;i<rowCount;i++){
			table.deleteRow(i--);
		}
	}
	table.rows[0].cells[0].childNodes[0].checked=false;
	table.rows[0].cells[1].childNodes[0].value="-1";
	table.rows[0].cells[2].childNodes[0].value="";
}
function hideRows(table,flag){
	var stl="table-row";
	if(flag=='hide')
		stl='none';
	table.rows[3].style.display=stl;
	table.rows[4].style.display=stl;
	table.rows[5].style.display=stl;
	table.rows[6].style.display=stl;
	table.rows[7].style.display=stl;
	table.rows[8].style.display=stl;
	
	
}
function checkImage(image)
{ 
	var hasImage=image.parentElement.childNodes[1];
	var data=hasImage.value.split("~");
	var val="";
	if(data.length==2)
		val="~"+data[1];
	if(image.value.length<0) 
		hasImage.value="N"+val;
	else
	{
		hasImage.value="Y"+val;

	}
}
function getImages(ptNo)
{ 
	//debugger;

//	var ptNo=document.getElementById("pointNo").value;
	var url="downloadScreenShot.action?bugid="+ptNo;
	document.forms[0].action=url;
	document.forms[0].method="POST";
	document.forms[0].submit();
}
