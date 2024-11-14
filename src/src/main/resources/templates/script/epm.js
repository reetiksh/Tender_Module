function createAjax()
{

  if (window.XMLHttpRequest)
  {// code for IE7+, Firefox, Chrome, Opera, Safari
  return new XMLHttpRequest();
  }
else
  {// code for IE6, IE5
   return new ActiveXObject("Microsoft.XMLHTTP");
  }
  return false;
}

function sendAjaxRequest(url)
{
    xhr = createAjax();
    xhr.open('POST',url,false);
    xhr.onreadystatechange=myResponseHandler ;
    xhr.send();
}
function myResponseHandler()
{
  if (xhr.readyState==4 && xhr.status==200)
  {
	  document.getElementById("body").innerHTML=xhr.responseText;
  }
}
function displaylogbtn(){
	var x = document.getElementById("logoutbtn");
	if(x.style.display=="none"){
		x.style.display="block";
		x.parentElement.parentElement.style.display='table-row';
	}else
	{
		x.style.display="none";
		x.parentElement.parentElement.style.display='none';
	}
}

function deleteRowTable(tableID) 
{

	selectedRowForDelete='';
	var table = document.getElementById(tableID);
	var rowCount = table.rows.length;
	if( rowCount>0)
	{
		for(var i=0; i<rowCount; i++)
		{
			var row = table.rows[i];
			var chkbox = row.cells[0].childNodes[0];
			if(null != chkbox && true == chkbox.checked) 
			{
				selectedRowForDelete=selectedRowForDelete+chkbox.value+"!";
				checkedKey=checkedKey+chkbox.id+"!";
				table.deleteRow(i);
				rowCount--;
				i--;
				count1--;
			}
			else
			{
				selectedRowForDelete='';
			}
		}
	}
	else{
		alert('Please Select Row For Delete!');	 
		return false;
	}
}

function saveSlaScreen() {


	var customerId1 = document.getElementById("customerId1").value;
	var product1 = document.getElementById("productId1").value;
	//var orderNo = document.getElementById("orderNo").value;
	var orderNo = "0";

	if (product1 == " ") {
		alert("please select product ");
		return false;
	}

	if (customerId1 == " ") {
		alert("please select customer ");
		return false;
	}
	if (orderNo == "-1") {
		alert(" please select orderNo");
		return false;
	}
	/*if (orderNo=="0") {
		alert("Invalid Order No.");
		return false;
	}*/

     var table = document.getElementById("SlaDetail");
	var tbody = document.getElementById("SlaDetail").getElementsByTagName(
	"TBODY")[0];
	var row = document.createElement("TR");

	var rowCount = table.rows.length;

	if(rowCount>0){
	
	var row = table.rows[0];
	var selbox1 = row.cells[0].childNodes[0];
	var combox1 = row.cells[1].childNodes[0];
	var daybox1 = row.cells[2].childNodes[0];
	var replyhour1 = row.cells[3].childNodes[0];
    var  temphour1= row.cells[4].childNodes[0];
    
	if(selbox1.value=="-1"){
		alert("select severity type..");
		return false;

	}
	if(combox1.value=="-1"){
		alert("select Complexity type..");
		return false;

	}

	if(daybox1.value=="" || daybox1.value==" "){
		alert("Enter Permanent Solution in Hours");
		return false; 
		}
	if(replyhour1.value=="" || replyhour1.value==" "){
		alert("Enter First reply in Hours");
		return false; 
		}
	if(temphour1.value=="" || temphour1.value==" "){
		alert("Enter Temporary Solution in Hours");
		return false; 
		}

	var x = rowCount - 1;
   for (var i = 1; i < rowCount; i++) {

		var row = table.rows[i];
		var selbox = row.cells[0].childNodes[0];
		var combox = row.cells[1].childNodes[0];
		var daybox = row.cells[2].childNodes[0];
		var replyhour = row.cells[3].childNodes[0];
		var temphour = row.cells[4].childNodes[0];

		if (selbox != null && selbox.value== "-1") {
			alert("select severity type..");
			return false;

		}
		if (daybox.value=="" || daybox.value==" " ) {
			alert("Enter No. Of Days");
			return false;
		}
		if(daybox.value=="" || daybox.value==" "){
		alert("Enter Permanent Solution in Hours");
		return false; 
		}
		if(replyhour.value=="" || replyhour.value==" "){
			alert("Enter First reply in Hours");
			return false; 
			}
		if(temphour.value=="" || temphour.value==" "){
			alert("Enter Temporary Solution in Hours");
			return false; 
			}

	}

	for (var i = 0; i < rowCount; i++) {

		var row = table.rows[i];
		var selbox = row.cells[1].childNodes[0].value;// selbox.value
		
		for (var j = i+1; j < rowCount; j++) {

			var rowN = table.rows[j];
			var selbox1 = rowN.cells[0].childNodes[0].value;
   			var combox1 = rowN.cells[1].childNodes[0].value;;// selbox.value  
			if(selbox==selbox1 && combox==combox1 ){
				alert("Duplicate Entry Exist");
				return false;
				}
		}

	}
	}
	var url = "saveSLAScreenData.action?customerId1=" + customerId1
	+ "&product1=" + product1 + "&orderNo=" + orderNo;

	document.forms[0].method = "post";
	document.forms[0].action = url;
	document.forms[0].submit();
}

function validnumber(field) {

	/*var orderno=document.getElementById("orderNo").value;
	if(orderno=="-1" || orderno=="")
	{

		alert("First Select Order No");
		var orderno=document.getElementById("orderNo").focus();
		return false;

	}*/

	var numVal= document.getElementById(field).value;
	if(isNaN(numVal)){

		alert("Hours must be in numeric");
		document.getElementById(field).value="";

		return false

	}

}


function resetAllValue()
{
	var table = document.getElementById('SlaDetail');
	var rowCount = table.rows.length;
	var row = table.rows[0];
	var selbox = row.cells[1].childNodes[0].value="-1";
	var daybox = row.cells[2].childNodes[0].value="";
	var estid = row.cells[3].childNodes[0].value="";
	var replyhour = row.cells[4].childNodes[0].value="";
	var temphour = row.cells[5].childNodes[0].value="";
	
	var table = document.getElementById('SlaDetail');
	var rowCount = table.rows.length;
if(rowCount>0){
	for(var i=1; i<rowCount; i++){
		var row = table.rows[i];
		table.deleteRow(i);
		rowCount--;
		i--;
		count1--;
	}
}
}



