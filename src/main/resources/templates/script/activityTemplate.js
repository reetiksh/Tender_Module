/**
 * 
 */
function isValidAlpha(fldName)
{
	evt =window.event || arguments.callee.caller.arguments[0];
	var c=	evt.keyCode;
	if(!( (c>=65 && c<=90) ||(c>=97 && c<=122)||(c==32)))
	{
		alert(fldName+" must have alphabets only");

		return false;
	}
	return true;

}
function isValidNumAlpha_Parenthesis(fldName)
{

	debugger;
	evt =window.event || arguments.callee.caller.arguments[0];
	var control=window.event.currentTarget;
	var c= evt.keyCode;
	if(control.value.length==0){
		if(!((c>=65 && c<=90) ||(c>=97 && c<=122) || (c==95) || (c==40 || c==41))){
			alert(fldName+" must start with Alphabet")
			return false;
		}
	}

	if(!((c>=65 && c<=90) ||(c>=97 && c<=122)|| (c==32)|| (c>=48 && c<=57) || (c==95) || (c==40 || c==41) ))
	{
		alert(fldName+" must be alphanumeric");
		return false;
	}
	return true;
}
function isValidNumAlpha_VarName(fldName)
{

	debugger;
	evt =window.event || arguments.callee.caller.arguments[0];
	var control=window.event.currentTarget;
	var c= evt.keyCode;
	if(control.value.length==0){
		if(!((c>=65 && c<=90) ||(c>=97 && c<=122) || (c==95))){
			alert(fldName+" must start with Alphabet")
			return false;
		}
	}

	if(!((c>=65 && c<=90) ||(c>=97 && c<=122)|| (c==32)|| (c>=48 && c<=57) || (c==95) || (c==36) ))
	{
		alert(fldName+" must be alphanumeric");
		return false;
	}
	return true;
}
function isValidNumber(fldName)
{
	ae = arguments.callee.caller.arguments[0]||window.event;
	var c=	ae.keyCode;
	if(!(c>=48 && c<=57))
	{
		alert(fldName+" must be numeric");
		return false;
	}
	return true;
}
function isValidDate()
{
	var crDate=document.getElementById("saveDbDesign_crDate").value;
	var rvDate=document.getElementById("saveDbDesign_rvDate").value;
	if(crDate.length==0)
	{
		alert("Enter created date");
		return false;
	}
	else
		return checkDate(crDate,'Created Date');
	if(rvDate.length==0)
	{
		alert("Enter revised date");
		return false;
	}
	else
		return checkDate(rvDate,'Revised Date');
	return true;

}
function checkDate(date,s)
{
	var day = parseInt(date.substring(0, 2),10);
	var month  = parseInt(date.substring(3, 5),10);
	var year  = parseInt(date.substring(6, 10),10);
	var valid = true;
	if((date.length > 10) ||((date.charAt(3)!="-") ))
	{ 
		alert("Enter valid "+s);
		return false;
	}
	else if((month < 1) || (month > 12))
	{
		alert("month must be 1-12");
		return false;
	}
	else if((day < 1) || (day > 31))
	{
		alert("day must be 1-31");
		return false;
	}
	else if(((month == 4) || (month == 6) || (month == 9) || (month == 11)) && (day > 30))
	{
		alert("month "+month+" must have 30 days");
		return false;
	}
	else if((month == 2) && (((year % 400) == 0) || ((year % 4) == 0)) && ((year % 100) == 0) && (day > 29))
	{
		alert("leap year must have 29 days");
		return false;
	}
	else if((month == 2) && ((year % 100) == 0) && (day > 29))
	{
		alert("Date must be numeric");
		return false;
	}
	else if( (month==2)&& ((day>28) || (day >29)) )
	{	
		alert("month "+month+" must have 28 /29 days");
		return false;
	}
	return true;
}
function isValidRes(fldName)
{
	evt =window.event || arguments.callee.caller.arguments[0];
	var c=	evt.keyCode;
	if(!( (c==83)||(c==115)||(c==70) ||(c==102)))
	{
		alert(fldName+" can be either S or F");
		return false;
	}
	return true;

}
function isMandatory(fldName)
{
	evt =window.event || arguments.callee.caller.arguments[0];
	var c=	evt.keyCode;
	if(!( (c==77)||(c==109)||(c==79) ||(c==111)||(c==78)||(c==110)||(c==65)||(c==97)||(c=='/')))
	{
		alert(fldName+" can be either M or O or N/A");
		return false;
	}
	return true;

}
function dateComparision(dmax,dmin)  
{
	var fDate = document.getElementById(dmax).value; 
	var sDate =  document.getElementById(dmin).value;

	var Month1 = fDate.substring(3,5);
	var Day1 =   fDate.substring(0,2);
	var Year1 =  fDate.substring(6,10);


	var Month2 = sDate.substring(3,5);
	var Day2 =   sDate.substring(0,2);
	var Year2 =  sDate.substring(6,10);



	if((Year1>Year2)||((Year1==Year2)&&(Month1 > Month2)) || (((Year1==Year2) && (Month1 == Month2) && Day1 >  Day2)))            
		return true;
	else
		return false;	

}
function validateDB()
{
	debugger;
	var flag="0";
	var auth=new String(document.getElementById("saveDbDesign_author").value).trim();
	var validBy=new String(document.getElementById("saveDbDesign_validBy").value).trim();
	//alert(validBy);
	if(auth.length==0){
		alert("Enter author name or N/A");
		document.getElementById("saveDbDesign_author").focus();
		return "false";
	}
	if(validBy=="-1"){
		alert("Select Valid By or N/A");
		document.getElementById("saveDbDesign_validBy").focus();
		return "false";
	}
	/*if((dateComparision('tDate','saveDbDesign_crDate'))==false &&  document.getElementById("tDate").value!=document.getElementById("saveDbDesign_crDate").value)
	{
		alert("Created on date must be lesser than Today Date");
		document.getElementById("saveDbDesign_crDate").focus();
		return "false";
	}if((dateComparision('tDate','saveDbDesign_rvDate'))==false && document.getElementById("tDate").value!=document.getElementById("saveDbDesign_rvDate").value)
	{
		alert("Revised on date must be lesser than Today Date");
		document.getElementById("saveDbDesign_rvDate").focus();
		return "false";
	}*/
	/*if(document.getElementById("saveDbDesign_module").value==""){
				alert("Enter module or N/A");
				document.getElementById("saveDbDesign_module").focus();
				return "false";
			}*/
	var table = document.getElementById("procedures");
	var rowCount = table.rows.length;
	var step=0;
	if(flag=="0"){
		var n=table.rows[step].cells[0].childNodes[0];
		var c=table.rows[step].cells[1].childNodes[0];
		var v=table.rows[step].cells[2].childNodes[0];
		var d=table.rows[step].cells[3].childNodes[0];
		var co=table.rows[step].cells[4].childNodes[0];
		var a=table.rows[step].cells[5].childNodes[0];
		if(n!=null && new String(n.value).trim()=="")
		{
			flag="0";
		}else if(c!=null && new String(c.value).trim()=="")
		{
			flag="0";
		}else if(v!=null && new String(v.value).trim()=="")
		{
			flag="0";
		}
		else if(d!=null && new String(d.value).trim()=="")
		{
			flag="0";
		}else if(co!=null && new String(co.value).trim()=="")
		{
			flag="0";
		}
		else if(a!=null && new String(a.value).trim()=="")
		{
			flag="0";
		}
		else{
			flag="1";
		}
	}
	for(step=1;step<rowCount;step++){
		var n=table.rows[step].cells[0].childNodes[0];
		var c=table.rows[step].cells[1].childNodes[0];
		var v=table.rows[step].cells[2].childNodes[0];
		var d=table.rows[step].cells[3].childNodes[0];
		var co=table.rows[step].cells[4].childNodes[0];
		var a=table.rows[step].cells[5].childNodes[0];
		if(n!=null && new String(n.value).trim()=="")
		{
			alert("Enter name or N/A");
			n.focus();
			return "false";
		}if(c!=null && new String(c.value).trim()=="")
		{
			alert("Enter Stored procedures type");
			c.focus();
			return "false";
		}if(v!=null && new String(v.value).trim()=="")
		{
			alert("Enter Input Parameters");
			v.focus();
			return "false";
		}
		if(d!=null && new String(d.value).trim()=="")
		{
			alert("Enter Datatypes");
			d.focus();
			return "false";
		}if(co!=null && new String(co.value).trim()=="")
		{
			alert("Enter Comments");
			co.focus();
			return "false";
		}
		if(a!=null && new String(a.value).trim()=="")
		{
			alert("Enter Algorithm");
			a.focus();
			return "false";
		}
	}

	table = document.getElementById("dbTable");
	rowCount = table.rows.length;
	step=0;
	if(flag=="0"){
		var c=table.rows[step].cells[0].childNodes[0];
		var v=table.rows[step].cells[1].childNodes[0];
		var d=table.rows[step].cells[2].childNodes[0];
		var c1=table.rows[step].cells[3].childNodes[0];
		var l=table.rows[step].cells[4].childNodes[0];
		var m=table.rows[step].cells[5].childNodes[0];
		var ci =table.rows[step].cells[6].childNodes[0];
		var eg=table.rows[step].cells[7].childNodes[0];
		var r=table.rows[step].cells[8].childNodes[0];
		if(c!=null && new String(c.value).trim()=="")
		{
			flag="0";
		}else if(v!=null && new String(v.value).trim()=="")
		{
			flag="0";
		}
		else if(d!=null && new String(d.value).trim()=="")
		{
			flag="0";
		}
		else if(c1!=null && new String(c1.value).trim()=="")
		{
			flag="0";
		}else if(l!=null && new String(l.value).trim()=="")
		{
			flag="0";
		}else if(m!=null && new String(m.value).trim()=="-1")
		{
			flag="0";
		}else if(ci!=null && new String(ci.value).trim()=="")
		{
			flag="0";
		}else if(eg!=null && new String(eg.value).trim()=="")
		{
			flag="0";
		}else if(r!=null && new String(r.value).trim()=="")
		{
			flag="0";
		}
		else{
			flag="1";
		}
	}
	for(step=1;step<rowCount;step++){
		var c=table.rows[step].cells[0].childNodes[0];
		var v=table.rows[step].cells[1].childNodes[0];
		var d=table.rows[step].cells[2].childNodes[0];
		var c1=table.rows[step].cells[3].childNodes[0];
		var l=table.rows[step].cells[4].childNodes[0];
		var m=table.rows[step].cells[5].childNodes[0];
		var ci =table.rows[step].cells[6].childNodes[0];
		var eg=table.rows[step].cells[7].childNodes[0];
		var r=table.rows[step].cells[8].childNodes[0];


		if(c!=null && new String(c.value).trim()=="")
		{
			alert("Enter Table Name");
			c.focus();
			return "false";
		}if(v!=null && new String(v.value).trim()=="")
		{
			alert("Enter Table Purpose");
			v.focus();
			return "false";
		}
		if(d!=null && new String(d.value).trim()=="")
		{
			alert("Enter Field name");
			d.focus();
			return "false";
		}
		if(c1!=null && new String(c1.value).trim()=="")
		{
			alert("Enter Data Type");
			c1.focus();
			return "false";
		}if(l!=null && new String(l.value).trim()=="")
		{
			alert("Enter length");
			l.focus();
			return "false";
		}if(m!=null && new String(m.value).trim()=="-1")
		{
			alert("Enter Mandatory/Optional");
			m.focus();
			return "false";
		}if(ci!=null && new String(ci.value).trim()=="")
		{
			alert("Enter constraints if any");
			ci.focus();
			return "false";
		}if(eg!=null && new String(eg.value).trim()=="")
		{
			alert("Enter examples if any");
			eg.focus();
			return "false";
		}if(r!=null && new String(r.value).trim()=="")
		{
			alert("Enter Remarks if any");
			r.focus();
			return "false";
		}
	}  return flag;
}
function validateForm()
{
	var ptno=document.getElementById("savePtReq_point_no").value;
	var ptdes=document.getElementById("savePtReq_point_des").value;
	var ddes=document.getElementById("savePtReq_detail_des").value;
	//alert(new String(ddes).trim().length);
	if(trim(ptno)==""){
		alert("Enter point no");
		return false;
	}
	else if(ptdes.length==0)
	{
		alert("Enter point description");
		return false;
	}
	else if(new String(ddes).trim().length==0)
	{
		alert("Enter Detail Description");
		document.getElementById("savePtReq_detail_des").focus();
		return false;
	}
	return true;
}

function displayDesc(){
	var ptno=document.getElementById("savePtReq_point_no").value;
	if(ptno.length==0)
	{
		alert("Enter point no");
		return false;
	}
	var url="getPointDesc.action?pointNo="+ptno+"&reqFrom=DD";
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
			alert("No Data Found");
			document.getElementById("savePtReq_point_no").value="";
			document.getElementById("savePtReq_point_des").value="";

			document.getElementById("savePtReq_point_no").focus();
			return false;
		}
		else if(res.indexOf("--")==0){
			   alert(res.substring(2));
			   $(".Delete").trigger("click");
			   return false;
			  }
		else
		{
			var d=res.split("@");
			var arr=new Array("savePtReq_point_des","saveDbDesign_author","saveDbDesign_module");
			for(var i=0;i<d.length;i++)
				document.getElementById(arr[i]).value=d[i];
		}
	}
}
function validateCompDesign()
{
	var flag="0";
	debugger;
	var table = document.getElementById("classProperties");
	var rowCount=$(table).find("tr").length;
	var step=0;
	if(flag=="0"){
		var n=table.rows[step].cells[0].childNodes[0];
		var c=table.rows[step].cells[1].childNodes[0];
		var v=table.rows[step].cells[2].childNodes[0];
		if(n!=null && new String((n.value)).trim().length==0)
		{
			flag="0";
		}else if(c!=null && new String(c.value).trim().length==0)
		{
			flag="0";
		}else if(v!=null && new String(v.value).trim().length==0)
		{
			flag="0";
		}
		else{
			flag="1";
		}
	}
	for(step=1;step<rowCount;step++){
		var n=table.rows[step].cells[0].childNodes[0];
		var c=table.rows[step].cells[1].childNodes[0];
		var v=table.rows[step].cells[2].childNodes[0];
		if(n!=null && new String((n.value)).trim().length==0)
		{
			alert("Enter namespace");
			n.focus();
			return "false";
		}if(c!=null && new String(c.value).trim().length==0)
		{
			alert("Enter class objects");
			c.focus();
			return "false";
		}if(v!=null && new String(v.value).trim().length==0)
		{
			alert("Enter visibility");
			v.focus();
			return "false";
		}
	}
	if(flag=="0"){
		if(document.getElementById("saveCompDesign_pubMethods_0__method").value.trim()=="")
		{
			flag="0";
		}
		else if(document.getElementById("saveCompDesign_pubMethods_0__purpose").value.trim()=="")
		{
	    	flag="0";
		}
		else if(document.getElementById("saveCompDesign_pubMethods_0__rtType").value.trim()=="")
		{
	    	flag="0";
		}
		else if(document.getElementById("saveCompDesign_pubMethods_0__strd_Prdcr").value.trim()=="")
		{
	    	flag="0";
		}
		else{
			flag="1";
		}
	}
	
	table = document.getElementById("parameters");
	rowCount = table.rows.length;
	step=0;
	if(flag=="0"){
		var n=table.rows[step].cells[0].childNodes[0];
		var c=table.rows[step].cells[1].childNodes[0];
		var v=table.rows[step].cells[2].childNodes[0];
		var r=table.rows[step].cells[3].childNodes[0];
		if(n!=null && trim(n.value)=="")
		{
			flag="0";
		}else if(c!=null && new String(c.value).trim().length==0)
		{
			flag="0";
		}else if(v!=null && new String(v.value).trim().length==0)
		{
			flag="0";
		}else if(r!=null && new String(r.value).trim().length==0)
		{
			flag="0";
		}
		else{
			flag="1";
		}
	}
	for(step=1;step<rowCount;step++){
		var n=table.rows[step].cells[0].childNodes[0];
		var c=table.rows[step].cells[1].childNodes[0];
		var v=table.rows[step].cells[2].childNodes[0];
		var r=table.rows[step].cells[3].childNodes[0];
		if(n!=null && trim(n.value)=="")
		{
			alert("Enter name of parameter");
			n.focus();
			return "false";
		}if(c!=null && new String(c.value).trim().length==0)
		{
			alert("Enter Type of parameter");
			c.focus();
			return "false";
		}if(v!=null && new String(v.value).trim().length==0)
		{
			alert("Enter directions");
			v.focus();
			return "false";
		}if(r!=null && new String(r.value).trim().length==0)
		{
			alert("Enter remarks");
			r.focus();
			return "false";
		}
	}
	table = document.getElementById("eleList");
	rowCount = table.rows.length;
	step=0;
	if(flag=="0"){
		var n=table.rows[step].cells[0].childNodes[0];
		var c=table.rows[step].cells[1].childNodes[0];
		var v=table.rows[step].cells[2].childNodes[0];
		var r=table.rows[step].cells[3].childNodes[0];
		var m=table.rows[step].cells[4].childNodes[0];
		var d=table.rows[step].cells[5].childNodes[0];
		if(n!=null && new String(n.value).trim().length==0)
		{
			flag="0";
		}else if(c!=null && new String(c.value).trim().length==0)
		{
			flag="0";
		}else if(v!=null && new String(v.value).trim().length==0)
		{
			flag="0";
		}else if(r!=null && new String(r.value).trim().length==0)
		{
			flag="0";
		}else if(m!=null && new String(m.value).trim().length==0)
		{
			flag="0";
		}else if(d!=null && new String(d.value).trim().length==0)
		{
			flag="0";
		}
		else {
			flag="1";
		}
	}
	for(step=1;step<rowCount;step++){
		var n=table.rows[step].cells[0].childNodes[0];
		var c=table.rows[step].cells[1].childNodes[0];
		var v=table.rows[step].cells[2].childNodes[0];
		var r=table.rows[step].cells[3].childNodes[0];
		var m=table.rows[step].cells[4].childNodes[0];
		var d=table.rows[step].cells[5].childNodes[0];
		if(n!=null && new String(n.value).trim().length==0)
		{
			alert("Enter Field Name");
			n.focus();
			return "false";
		}if(c!=null && new String(c.value).trim().length==0)
		{
			alert("Enter Control object");
			c.focus();
			return "false";
		}if(v!=null && new String(v.value).trim().length==0)
		{
			alert("Enter length");
			v.focus();
			return "false";
		}if(r!=null && new String(r.value).trim().length==0)
		{
			alert("Enter Datatype of field");
			r.focus();
			return "false";
		}if(m!=null && new String(m.value).trim().length==0)
		{
			alert("Enter whether field is mandatory or optional");
			m.focus();
			return "false";
		}if(d!=null && new String(d.value).trim().length==0)
		{
			alert("Enter Description of field");
			d.focus();
			return "false";
		}
	}

	return flag;
}
function showProjCode(){
	var utcName=document.getElementById("saveUtcDoc_utcName").value;
	if(utcName=="-1")
	{
		alert("Select Project Name First.");
		return false;
	}
	document.getElementById('saveUtcDoc_prjName').value=utcName.substring(0,utcName.indexOf('__')); 
	var id=utcName.substring(utcName.indexOf('__')+2);
	var url="getProjectCode.action?prdId="+id;
	//alert(url);
	xhr=createAjax();
	xhr.open('POST',url,false);
	xhr.onreadystatechange=function(){
		showCode();
	} 
	xhr.send(null);
}
function showCode(){
	if (xhr.readyState==4 && xhr.status==200)
	{
		var j=0;
		var res=xhr.responseText;
		if(res==""){
			alert("No Points for selected Project");
			document.getElementById("saveUtcDoc_utcName").value="-1";
			document.getElementById('saveUtcDoc_prjName').value="";
			document.getElementById("saveUtcDoc_prjCode").innerHTML="<option value='-1'>--SELECT--</option>";
			return false;
		}
		document.getElementById("saveUtcDoc_prjCode").innerHTML="";
		var data=res.split("|");
		document.getElementById("saveUtcDoc_prjCode").options[j++]= new Option('---SELECT---','-1');

		for(var i=0;i<data.length-1;i++){
			document.getElementById("saveUtcDoc_prjCode").options[j]= new Option(data[i],data[i]);
			j++;

		} 
	}  	
}
function isValidNumAlphaversion(fldName)
{

	evt =window.event || arguments.callee.caller.arguments[0];
	var c= evt.keyCode;

	if(((c>=64 && c<=90) ||(c>=97 && c<=122)|| (c==32)  ||(c>=33 && c<=45)))
	{
		alert(fldName+" must be numeric");
		return false;
	}
	return true;
}
function saveDD(flag){
	//alert("check ptreq");
	debugger;
	var tabs=$(".status-tab");
	var tab_pane=$(".tab-pane");
	var action=flag;
	if(!validateForm())
	{
			return false;
	}
	//alert("check comp design");
	var isComp=validateCompDesign();
	var isDb=validateDB();
	if(isComp=="false")
	{
		return false;
	}
	if(isDb=="false")
	{
		return false;
	}
	if(isComp=="0" && isDb=="0"){
		alert("Either Component Design or Database design must be filled");
		return false;
	}//alert("check db design");
	if(isComp=="1" || isDb=="1")
	{
		if(confirm("Do You want to save document...")){
			document.forms[0].action="savePtReq.action?reqFrom="+flag+"&action="+action;
			document.forms[0].method="POST";
			document.forms[0].submit();
		}
	}


}
function fetchdata(param) {

	debugger;
	//alert("hello");
	var productId = document.getElementById("productId1").value;
	var customerId = document.getElementById("customerId1").value;
	var wbsname = document.getElementById("wbsname1").value;
	var point_no = document.getElementById("point_no1").value;
	var approvelevel = document.getElementById("approvelevel").value;
	if (productId == " " && point_no=="") {
		alert("Select Product");
		document.getElementById("productId1").focus();
		return false;
	}
	var table = document.getElementById("innertableid");
	table.innerHTML = "";
	var url = "getDocDetail.action?param="+param+"&productId=" + productId + "&customerId="
	+ customerId + "&wbsname=" + wbsname + "&point_no=" + point_no
	+ "&approvelevel=" + approvelevel;
	xhr = createAjax();
	xhr.open('POST', url, true);
	xhr.onreadystatechange = function() {
		showMessage(param);
	};
	xhr.send();
}
function showMessage(param) {
debugger;
	if (xhr.readyState == 4 && xhr.status == 200) {
		debugger;
		var val = xhr.responseText;
		if (val == "") {
			alert("No Record found");
			return;
		}
		var result = JSON.parse(val);
		var table = document.getElementById("innertableid");
		table.innerHTML = "";
		var table1 = document.getElementById("innertableid");
		var k = 0;
		for (var i = 0; i < result.length; i++) {
			//debugger;
			var row = table1.insertRow(k);
			var cell1 = row.insertCell(0);
		/*	cell1.style = "width:5%;text-align:center;"
			cell1.innerHTML = (i + 1) + ".";*/

			/*cell1 = row.insertCell(1);*/
			cell1.style = "width:10%;text-align:center;";
			cell1.innerHTML = "<a class='hst' id='"+result[i][0]+"' count='0'><i class='fa fa-plus-circle'></i></a>    "+result[i][0];

			cell1 = row.insertCell(1);
			cell1.style = "padding:0;";
			cell1.innerHTML = "<textarea class=\"form-control noResize\" readonly=true style=\"width:100%!important;height:100%!important;word-wrap: break-word;\">"
				+ result[i][1] + "</textarea>";
			
		    cell1 = row.insertCell(2);
			cell1.style = "text-align:center";
			cell1.className = "tabHeader";
            if(result[i][4] == 'Z'){
            	result[i][3]="Initiated";
             }
            else if(result[i][4]=="N"){
            	result[i][3]="Not Initiated";
            }
			cell1.innerHTML="<span class='"+result[i][3]+" lebelRound'>"+result[i][3]+"" 
					+"</span>";
			  
			cell1 = row.insertCell(3);
			cell1.style = "width:26%;text-align:center;word-wrap: break-word;";
			var html= "<button type='button' class='Btn create View btnIcon' create='"+result[i][0]+"' onclick='createDoc(\""
				+ result[i][0]
				            + "\",\""+param+"\")' title='Create' ><i style='margin-top:0' class='fa fa-plus'></i></button>"
				            + "&nbsp;&nbsp;<button type='button' class='Btn Edit update btnIcon'" +
				            		" onclick='updateDoc(\""
				            + result[i][0]
				                        + "\",\""+param+"\")' title='Update' update='"+result[i][0]+"'><i style='margin-top:0'  class='fa fa-wrench'></i></button>"
				                        + "&nbsp;&nbsp;<button type='button' class='Btn View view btnIcon' onclick='viewDooc(\""
				                        + result[i][0] + "\",\""+param+"\")' title='View' view='"+result[i][0]+"'><i style='margin-top:0' class='fa fa-search'>" +
				                        		"</i></button><button type='button' class='Btn View approve view btnIcon' onclick='getAction(\""
	         	      				                        + result[i][0] + "\")' style='margin-left:2%' data='"+result[i][0]+"'><i style='margin-top:0' class='fa fa-thumbs-up'>" +
	         	      				                          		"</i></button>";
			if(param=="Design"){
				html+="&nbsp;<button type='button' class='Btn View print btnIcon'  onclick='printDoc(\""
					+ result[i][0]
					            + "\",\""+param+"\")' title='Print' print='"+result[i][0]+"' ><i style='margin-top:0' class='fa fa-print'></i></button>";
			}
			cell1.innerHTML=html;      
			if (result[i][4] == 'N') {
				
				$('[update='+result[i][0]+']').attr("disabled",true);
				$('[view='+result[i][0]+']').attr("disabled",true);
				$('[print='+result[i][0]+']').attr("disabled",true);
				$('[data='+result[i][0]+']').attr("disabled",true);
			}
			else if( result[i][4] == 'A'){
				$('[data='+result[i][0]+']').attr("disabled",true);
				$('[create='+result[i][0]+']').attr("disabled",true);
			}else if(result[i][4] == 'Z' ){
				//$('[data='+result[i][0]+']').attr("disabled",true);
				$('[create='+result[i][0]+']').attr("disabled",true);
			}
			else if(result[i][4] == 'T' & result[i][3]=="Pending"){
				$('[update='+result[i][0]+']').attr("disabled",true);
				$('[create='+result[i][0]+']').attr("disabled",true);
				$('[print='+result[i][0]+']').attr("disabled",true);
				$('[data='+result[i][0]+']').attr("disabled",true);
			}
			else if(result[i][4] == 'T' & result[i][3]=="Requested"){
			
				$('[update='+result[i][0]+']').attr("disabled",true);
				$('[create='+result[i][0]+']').attr("disabled",true);
		
			}
			else if(result[i][4] == 'X'){
				$('[data='+result[i][0]+']').attr("disabled",true);
				$('[print='+result[i][0]+']').attr("disabled",true);
			}
			/*} else if (result[i][2] == 'N') {
				$("button.update,button.view,button.print").attr("disabled",true);
				$("button.update,button.view,button.print").attr("disabled",true);
			}*/
			/*if (result[i][4] == "1" && result[i][3] == "1")
				$("button.update").attr("disabled",true);*/
			$(".btnIcon").css("float","none");
			k++;
		}
		addPagination();
		$(".modal").hide();   
	}
}
function viewDooc(pt,param) {
	debugger;
	sessionStorage.isNewsession = "yes";
	var productId = document.getElementById("productId1").value;
	var customerId = document.getElementById("customerId1").value;
	var wbsname = document.getElementById("wbsname1").value;
	var search = "";
	var approvelevel = document.getElementById("approvelevel").value;
	sessionStorage.approval = approvelevel;
	if (document.getElementById("point_no1").value != "")
		search = "pointno";
	document.getElementById("point_no1").value = pt;

	document.getElementById("isNewSession").value = "view";
	var url="?reqFrom=view&point="+pt+"&search="+search+"&productId="+productId+"&customerId="+customerId+"&wbsname="+wbsname+"&approvelevel="+approvelevel;	
	if(param=="UTC")
		url="viewUTCDoc.action"+url;
	else
		url="viewDesignDoc.action"+url;
	document.forms[0].action=url;
	document.forms[0].method="post";
	document.forms[0].submit();

}

function updateDoc(pt,param){

	sessionStorage.isNewsession="yes";

	var productId=document.getElementById("productId1").value;
	var customerId=document.getElementById("customerId1").value;
	var wbsname=document.getElementById("wbsname1").value;
	var search1="";
	var approvelevel=document.getElementById("approvelevel").value;
	sessionStorage.approval=approvelevel;
	if(document.getElementById("point_no1").value!="")
		search1="pointno";
	document.getElementById("isNewSession").value="update";
	document.getElementById("point_no1").value=pt;
	var url="?reqFrom=update&point="+pt+"&search1="+search1+"&productId="+productId+"&customerId="+customerId+"&wbsname="+wbsname+"&approvelevel="+approvelevel;		
	if(param=="UTC")
		url="updateUtc.action"+url;
	else
		url="updateDesignDoc.action"+url;
	document.forms[0].action=url;
	document.forms[0].method="post";
	document.forms[0].submit();	

}
var ptid;
function createDoc(ptid,param){
	sessionStorage.isNewsession="yes";
	document.getElementById("isNewSession").value="create";
	var productId=document.getElementById("productId1").value;
	var customerId=document.getElementById("customerId1").value;
	var wbsname=document.getElementById("wbsname1").value;
	var search2="";
	var approvelevel=document.getElementById("approvelevel").value;
	sessionStorage.approval=approvelevel;
	if(document.getElementById("point_no1").value!="")
		search2="pointno";

	document.getElementById("point_no1").value=ptid;
	var url="?point="+ptid+"&search2="+search2+"&productId="+productId+"&customerId="+customerId+"&wbsname="+wbsname+"&approvelevel="+approvelevel;	
	if(param=="UTC")
		url="UTCDocNew.action"+url;
	else
		url="designDocNew.action"+url;
	document.forms[0].action=url;	
	document.forms[0].method="get";
	document.forms[0].submit();	
}


function goback(appContext)
{
	document.forms[0].action=appContext;		
	document.forms[0].method="POST";
	document.forms[0].submit();
}
function approvePoint(param){
	//debugger;
	var table = document.getElementById("innertableid");
	if(table.rows.length==0)
		return false;
	var id="";
	var flag=false;
	var isNull=false;
	for(var i=0;i<table.rows.length;i++){
		var chk1=table.rows[i].cells[4].childNodes[1];
		var chk2=table.rows[i].cells[4].childNodes[3];
		if(chk1.tagName=="LABEL" && chk2.tagName=="LABEL"){
			isNull=true;
		}else
			isNull=false;
		if(chk1!=null && chk1.checked)
		{
			flag=true;
			id+=chk1.value+"|1~";
		}

		if(chk2!=null && chk2.checked)
		{
			flag=true;
			id+=chk2.value+"|2~"; 
		}

	}
	if(isNull){
		alert("No records to approve");
		return false;
	}
	if(!flag){
		alert("Select checkbox first");
		return false;
	}
	var url="ddAction.action?approveId="+id+"&param="+param;
	xhr=createAjax();
	xhr.open('POST',url,true);
	xhr.onreadystatechange=function(){
		if(xhr.readyState==4 && xhr.status==200){
			var val=xhr.responseText;
			alert(val);
			if(param=="UTC")
				val="utcDoc";
			else
				val="designDoc";
			window.location.href=val;
		} 
	};
	xhr.send();
}

function resetTable(){
	var table = document.getElementById("innertableid");
	table.innerHTML = "";
}

function ValidateUTDetails(param)
{
	var utcName=document.getElementById("saveUtcDoc_utcName").value;
	var prjName=document.getElementById("saveUtcDoc_prjName").value;
	var prjCode=document.getElementById("saveUtcDoc_prjCode").value;
	var prjVer=document.getElementById("saveUtcDoc_prjVer").value;
	var testType=document.getElementById("saveUtcDoc_testType").value;
	var testEnv=document.getElementById("saveUtcDoc_testEnv").value;
	var crBy=document.getElementById("saveUtcDoc_crBy").value;
	var crOn=document.getElementById("saveUtcDoc_crOn").value;
	var evBy="";
	var evOn="";
	var upBy="";
	var upOn="";
	if(param!="Saved" && param!="Submit"){
		evBy=document.getElementById("saveUtcDoc_evBy").value;
		evOn=document.getElementById("saveUtcDoc_evOn").value;
		upBy=document.getElementById("saveUtcDoc_upBy").value;
		upOn=document.getElementById("saveUtcDoc_upOn").value;
	}
	var purpose=document.getElementById("saveUtcDoc_purpose").value;
	var tDate=document.getElementById("tDate").value;
	if(utcName=="-1")
	{
		alert("Please enter Test Cases for");
		document.getElementById("saveUtcDoc_utcName").focus();
		return false;
	}
	if(trim(prjName).length==0)
	{
		alert("Please enter Project Name ");
		document.getElementById("saveUtcDoc_prjName").focus();
		return false;
	}
	if(trim(prjCode)=="-1")
	{
		alert("Please enter Project Code ");
		document.getElementById("saveUtcDoc_prjCode").focus();
		return false;
	}
	if(trim(prjVer.length)==0)
	{
		alert("Please enter Project Version ");
		document.getElementById("saveUtcDoc_prjVer").focus();
		return false;
	}
	if(trim(testType)=="0")
	{
		alert("Please select testing type ");
		document.getElementById("saveUtcDoc_testType").focus();
		return false;
	}
	if(trim(testEnv).length==0)
	{
		alert("Please enter Test Environment ");
		document.getElementById("saveUtcDoc_testEnv").focus();
		return false;
	}
	if(crBy=="-1")
	{
		alert("Please enter Created By ");
		return false;
	}
	if(param=="Saved" && !(dateComparision('tDate','saveUtcDoc_crOn') || tDate==crOn))
	{
		alert("Created on date must be lesser than Today Date");
		document.getElementById("saveUtcDoc_crOn").focus();
		return false;
	}
	if(upBy=="-1")
	{
		alert("Please select Updated By ");
		return false;
	}
	/*if(param!="Saved" && evOn==""){
		alert("Executed on date cannot be blank");
		document.getElementById("saveUtcDoc_evOn").focus();
		return false;
	}*/
	if(param!="Saved" && trim(evOn)!=""  && !(dateComparision('tDate','saveUtcDoc_evOn') || tDate==evOn))
	{
		alert("Executed on date must be lesser than Today Date");
		document.getElementById("saveUtcDoc_evOn").focus();
		return false;
	}
	/* if(evBy.length==0)
	{
		alert("Please enter Executed By ");
		return false;
	}

	 */	
	if(new String(purpose).trim().length==0)
	{
		alert("Please enter Purpose ");
		document.getElementById("saveUtcDoc_purpose").focus();
		return false;
	}

	if(ValidateRules(param)){
		if(confirm("Do You want to save document...")){
			document.forms[0].action="saveUtcDoc.action?param="+param;
			document.forms[0].method="POST";
			document.forms[0].submit();
		}
	}
	return false;
}
function ValidateRules(param)
{
	//debugger;
	var table = document.getElementById('utcRules');
	var rowCount = table.rows.length;
	var step;
	for (step = 1; step < rowCount; step++) {
		var testCon=table.rows[step].cells[0].childNodes[0].value;
		var expRes=table.rows[step].cells[1].childNodes[0].value;
		var acRes=table.rows[step].cells[2].childNodes[0].value;
		var exRes=table.rows[step].cells[3].childNodes[0].value;
		testCon=new String(testCon).trim();
		expRes=new String(expRes).trim();
		acRes=new String(acRes).trim();
		exRes=new String(exRes).trim();
		if(testCon.length==0)
		{
			alert("Enter Test Condition");
			table.rows[step].cells[1].childNodes[0].focus();
			return false;
		}if(expRes.length==0)
		{
			alert("Enter Expected Result");
			table.rows[step].cells[2].childNodes[0].focus();
			return false;
		}/*if(param!="Saved" && acRes.length==0)
		{
			alert("Enter Actual Result");
			table.rows[step].cells[3].childNodes[0].focus();
			return false;
		}*/
		if(acRes.length!=0 && exRes.length==0)
		{
			alert("Enter Test Case Result");
			table.rows[step].cells[4].childNodes[0].focus();
			return false;
		}
		/* if(exRes.length==0 && actRes.length==0)
		{
			alert("Enter  Result Status");
			return false;
		}  */
	}

	return true;
}
function checkUploadImage(files){
	debugger;
	var count=files.files.length;
	var parent=files.parentElement;
	var param=[];
	param[0]=count;
	for(var i=0,j=1;i<count;i++){
		var f=files.files[i];
		if(!(f.type=="image/png" || f.type=="image/jpg" || f.type=="image/jpeg" || 
				f.type=="application/pdf" || f.type=="application/docx" || f.type=="application/doc" || f.type=="application/xls" || f.type=="application/xlsx")){
			alert("Only PNG,JPG,JPEG,PDF,XLS,DOC,DOCX files allowed");
			files.value="";
			return false;
		}
		param[j++]=f.name;
		//getBase64Image(f,j++)
		$(parent).find("[name='imageData']").val(param);
	}
//	alert(param)
}
function getBase64Image(f,j){
	 var reader = new FileReader();
	 var a="";
	 reader.onloadend = function() {
		  a=reader.result;
		console.log('RESULT', a)
		param[j]=a;
	  }
	  reader.readAsDataURL(f);
}
function showScreenShots(id){
	var val=document.getElementById('saveUtcDoc_prjCode').value;
	var url="viewUTCDoc.action?getImage="+val+"~"+id;
	document.forms[0].action=url;
	document.forms[0].method="POST";
	document.forms[0].submit();
	/*xhr = createAjax();
	xhr.open('POST',url,false);
	xhr.onreadystatechange=function() {
		if (xhr.readyState==4 && xhr.status==200)
		{
			var res=xhr.responseText;
			res=JSON.parse(res);
			var div="<center>";
			//var ul='<ul class="pagination pagination-sm">';
			for(var i=0;i<res.length;i++){
				var data=res[i];
				
				var style="style='display:block;height:200px;width:200px;'";
				
				if(i!=0)
					style="style='display:none;height:200px;width:200px;'";
				div+="<img alt='"+data.name+"' src='data:image/"+data.type+";base64,"+data.image+"' class='images' "+style+" /></div>";
				//ul+=' <li><a href="#">'+(i+1)+'</a></li>';
			}
			//ul+='</ul>';
			div+="</center>";
			$(".modal .modal-body .image").html(div);
			//$(".modal .modal-title").html(pageTitle);
			/* $(".modal .modal-body").html("Content loading please wait...");*/
			/*$(".modal").modal("show");
		    document.getElementById("left").style.display="none"; 
		}
	};
	xhr.send();*/	
}
function showNext(flag){
	debugger;
	var img=$(".images");
	if(flag=='r'){
		var i=0;
		for(i=0;i<img.length;i++){
			if(img[i].style.display=="block"){
				img[i].style.display="none";
				break;
			}
		}
		if((i+1)==img.length-1)
			document.getElementById("right").style.display="none"; 
		document.getElementById("left").style.display="inline"; 
		img[i+1].style.display="block";
	}
	else if(flag=='l'){
		var i=0;
		for(i=img.length-1;i>=0;i--){
			if(img[i].style.display=="block"){
				img[i].style.display="none";
				break;
			}
		}
		if((i-1)==0)
			document.getElementById("left").style.display="none"; 
		document.getElementById("right").style.display="inline"; 
		img[i-1].style.display="block";
	}
}
function printDoc(ptid,param){
	sessionStorage.isNewsession="yes";
	document.getElementById("isNewSession").value="create";
	var productId=document.getElementById("productId1").value;
	var customerId=document.getElementById("customerId1").value;
	var wbsname=document.getElementById("wbsname1").value;
	var search2="";
	var approvelevel=document.getElementById("approvelevel").value;
	sessionStorage.approval=approvelevel;
	if(document.getElementById("point_no1").value!="")
		search2="pointno";

	document.getElementById("point_no1").value=ptid;
	var url="?point="+ptid+"&search2="+search2+"&productId="+productId+"&customerId="+customerId+"&wbsname="+wbsname+"&approvelevel="+approvelevel;	
		url="designDocPrint.action"+url+"&isPrint=print";
	document.forms[0].action=url;	
	document.forms[0].method="POST";
	document.forms[0].submit();	
}