	var count =0;
	var count1 =0;
	var selectedRowForDelete='';
	var checkedKey='';
	var newRowCount=0;
	var wbsselectData="";
//onkeypress="alphaNumChat(this)"

 $(function() {
	debugger;
       $(".datepicker").datepicker({
		  changeMonth: true,
		  dateFormat: "dd/mm/yy",
	      changeYear: true,
	      buttonImage: "images/calendar.gif",
	     /*  showOn: "button", */
	     /*  yearRange: "2000-2025", */
	      beforeShowDay: function(date) {
		       var show = true;
		       if(date.getDay()==6||date.getDay()==0) show=false
		       return [show];
		}
	});

    }); 
function alphaNumChat(key)
{
	debugger;
	 var keycode =(key.which) ? key.which : key.keyCode;
	ae = arguments.callee.caller.arguments[0]||window.event;
	var c= ae.keyCode;
	//alert(c);
	if(((c>=40 && c<=90) ||(c>=97 && c<=122)|| (c==32)  ||(c==33) ||(c==35) || (c==36) ) ){
	return true;
	}else{
		//key.target.value='';
		key.key="";
		key.keycode="";
	return false;
	}
	/*if(((c>=40 && c<=90) ||(c>=97 && c<=122)|| (c==32)  ||(c==33) ||(c==35) || (c==36) ))
		return true;
	else
	{
		alert("The entered special character not allowed");
		aevent.keyCode=0;
		aevent.key='';
		aevent.target.value='';
		return false;
	}*/
	//%37
//"34
//&38
//' 39
	
	//evt =window.event || arguments.callee.caller.arguments[0];
	//	var c= evt.keyCode;
	//evt.keyCode=(!((c>=65 && c<=90) ||(c>=97 && c<=122)|| (c==32)|| (c>=48 && c<=57) ))? evt.keyCode :0;
}


	function removeDiv()
	{ 
		$('#viewwbsrecordsTableDiv').html('');
		$('#viewAdHocTabTableDiv').html('');
	}
	function buttonDisable(ID)
	{
		document.getElementById("view").disabled=ID;
		document.getElementById("save").disabled=ID;
		document.getElementById("cancel").disabled=ID;
	}
	function  viewAllWBS()
	{			
				buttonDisable(true);
				var table = document.getElementById("WBSDetail");
			   	var rowCount=table.rows.length;
			   	var x=rowCount-1;
			    if(document.getElementById("wbsname1").value=="" || document.getElementById("customerId1").value=="" || document.getElementById("productId1").value=="" || document.getElementById("project_phase"+x).value=="" || document.getElementById("module"+x).value=="")
				{
			    	alert("Please Select all fields...!!");
			    	buttonDisable(false);
					return false;
			   	}
			    var url="viewWbsData.action?wbsname="+document.getElementById("wbsname1").value+"&customer="+document.getElementById("customerId1").value+"&product="+document.getElementById("productId1").value+"&projectphase="+document.getElementById("project_phase"+x).value+"&module="+document.getElementById("module"+x).value;;
			    
				xhr = createAjax();
				xhr.open('POST',url,false);
				xhr.onreadystatechange=viewWbsData ;
				xhr.send();
	}
	function viewWbsData()  
	{    debugger;
		if (xhr.readyState==4 && xhr.status==200)
		{
			var res=xhr.responseText;
			var data=res.split('@'); 
			var data1;
			var header='<!--<div style="overflow-x:scroll;overflow-y:hidden">-->'+'<table id=\"viewwbsrecords\" class=\"table pretty\" style=\"border-color: inherit;width: 100%;\"  border=\"1\">'+
						'<thead>'+
						'<tr align=\"center\" class=\"headerRow\">'+
						'<th align=\"center\" style=\" width:120px;\">WBS Name</th>'+
						'<th align=\"center\" style=\" width:110px;\">Customer</th>'+
						'<th align=\"center\" style=\" width:130px\">Product</th>'+
						'<th align=\"center\" style=\" width:110px;\">Phase</th>'+
						'<th align=\"center\" style=\" width:50px;\">Module</th>'+
						'<th align=\"center\" style=\" width:50px; \">WBS-ID</th>'+
						'<th align=\"center\" style=\" width:480px;\">Activity Description</th>'+
						'<th align=\"center\" style=\" width:50px;\">Activity Code</th>'+
						'<th align=\"center\" style=\" width:480px;\">Activity Name</th>'+
						'<th align=\"center\" style=\" width:120px;\">Empolyee</th>'+
						'<th align=\"center\" style=\" width:50px;\">To Date</th>'+
						'<th align=\"center\" style=\" width:50px;\">From Date</th>'+
						'<th align=\"center\" style=\" width:50px;\">WBS Status</th>'+
						'<th align=\"center\" style=\" width:50px;\">Port Date</th>'+
						'<th align=\"center\" style=\" width:50px;\">Release Date</th>'+
						'<th align=\"center\" style=\" width:50px;\">Porting Status</th>'+
						'<th align=\"center\" style=\" width:50px;\">Release Status</th>'+
						'<th align=\"center\" style=\" width:50px;\">QC Status</th>'+
						'<th align=\"center\" style=\" width:50px;\">Multiple Factor</th>'+
						'<th align=\"center\" style=\" width:50px;\">Authorization Status</th>'+
						'<th align=\"center\" style=\" width:50px;\">Wbs Entry by</th>'+
						'</tr>'+
						'</thead>'+
						'<tbody id=\"viewwbs\"></tbody>'+
						'</table>'+
						'<!--</div>-->';
			$('#viewwbsrecordsTableDiv').html(header);
			var table = document.getElementById("viewwbsrecords");
			var tbody = document.getElementById("viewwbsrecords").getElementsByTagName("TBODY")[0];
			for(var i=1;i<data.length;i++)
			{
                          debugger;
				data1=data[i].split("~");
				var row = document.createElement("TR");
				var rowCount = tbody.rows.length;		
				var row = tbody.insertRow(rowCount);
				row.className="tableRow";
				for(var j=1;j<data1.length;j++)
				{	
					if(j==1)
					{
						var td1 = document.createElement("TD")
						td1.innerHTML = data1[j];
						td1.align='center';
						td1.height='40px';
						row.appendChild(td1);   
					}
					else if(j==7)
					{
						var td1 = document.createElement("TD")
						td1.style="padding:0";
						var strHtml7 = "<textarea rows=\"2\" cols=\"50\" class=\"form-Control noResize\" style=\"width:380px\" readonly>"+data1[j]+"</textarea>";
						td1.innerHTML = strHtml7
						row.appendChild(td1);
					}
					else 
					{
						var td1 = document.createElement("TD")
						td1.innerHTML = data1[j];
						td1.align='center';
						row.appendChild(td1);
					}
				}
			}
		}
		pageination();
		buttonDisable(false);
		$(".modal").modal("show");
	}
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
	// for View WBS Records Pagination 	
	function pageination() 
	{
			var table = $("#viewwbsrecords").dataTable({
				"bProcessing": false,
		        "bServerSide": false,
		        "sort": "position",
		        "sPaginationType": "full_numbers",
		        "lengthMenu": [5, 10, 20, 50, 100],
		        "pageLength": 5,
		        "responsive": true,
			} ); 
		new $.fn.dataTable.FixedHeader( table, {
	        top: false,
	    } );
	}

	$(function() {
//		adddatepicker();
//		disabledatepicker();
	});
	//for disable DatePicker
	function disabledatepicker()
	{
		$(".totalTime").blur(function(){
			if($(this).val()!=''){
			  var id=$(this).attr('id');
			  var rCount=id.substring(9,id.length);
			  $("#startdate"+rCount).datetimepicker("destroy");
			  $("#enddate"+rCount).datetimepicker("destroy");
			}else{
				var id=$(this).attr('id');
				  var rCount=id.substring(9,id.length);
				  $("#startdate"+rCount).datetimepicker({
					  closeOnTimeSelect:true,
					  format:'d/m/Y H:i',
					  minTime:'10:00 AM',
					  maxTime: '8:35 PM',
					  scrollDefaultNow:true,
					  formatTime: 'g:i A',
					  step:5,
				  });
				  $("#enddate"+rCount).datetimepicker({
					  closeOnTimeSelect:true,
					  format:'d/m/Y H:i',
					  minTime:'10:00 AM',
					  maxTime: '8:35 PM',
					  scrollDefaultNow:true,
					  formatTime: 'g:i A',
					  step:5,
				  });
			}	
		});
	}
	// for datetimePicker
	function adddatepicker(){
		$( ".datepicker" ).datetimepicker({
			closeOnTimeSelect:true,
			format:'d/m/Y H:i',
			minTime:'10:00 AM',
			maxTime: '8:35 PM',
			scrollDefaultNow:true,
			formatTime: 'g:i A',
			step:5,
		});
	}
	function adddatepicker(tmFlag){

		//var date=new Date();
		//var hrs=date.getHours();
		//var min=date.getMinutes();
		//if(hrs<=9)
		//	hrs="0"+hrs;
		//if(min<=9)
		//	min="0"+min;
		//var ampm=(date.getHours() >= 12) ? "" : "AM";
		//var minTime=hrs+":"+min;
		//if(ampm!="")
		//	minTime+=" "+ampm;
		if(tmFlag!=null && tmFlag=='adhoc')
		{
			minTime="10:00 AM";
			$( ".datepicker" ).datetimepicker({
				closeOnTimeSelect:true,
				format:'d/m/Y H:i',
				minTime:minTime,
				maxTime: '8:35 PM',
				maxDate:date,
				scrollDefaultNow:true,
				formatTime: 'g:i A',
				step:5,
			});
			/*var dateArr=$( ".datepicker" );
			for(var i=0,j=0;i<dateArr.length;i=i+2){
				var dateFld1=dateArr[i];
				var dateFld2=dateArr[i+1];
				var minTime1="10:00 AM";
				if(i!=0){
					minTime1=dateArr[i-1].value;
					minTime1=minTime1.split(" ")[1];
				}
				$(dateFld1).datetimepicker({
					closeOnTimeSelect:true,
					format:'d/m/Y H:i',
					minTime:minTime1,
					maxTime: '8:35 PM',
					maxDate:date,
					scrollDefaultNow:true,
					formatTime: 'g:i A',
					step:5,
				});
				$(dateFld2).datetimepicker({
					closeOnTimeSelect:true,
					format:'d/m/Y H:i',
					minTime:minTime1,
					maxTime: '8:35 PM',
					maxDate:date,
					scrollDefaultNow:true,
					formatTime: 'g:i A',
					step:5,
				});
				
			}*/
			
		}else{

			$( ".datepicker" ).datetimepicker({
				closeOnTimeSelect:true,
				format:'d/m/Y H:i',
				//minTime:minTime,
				minTime:'08:00 AM',
				maxTime: '9:00 PM',
				//minDate:date,
				//maxDate:date,
				scrollDefaultNow:true,
				formatTime: 'g:i A',
				step:5,
			});
		}
		
	}
	// for select Data
	function getSelectData(rowCount)
	{
		newRowCount=rowCount;
		xhr = createAjax();
		xhr.open('POST','GetSelectData',false);
		xhr.onreadystatechange=dataResponseHandler ;
		xhr.send();
	}
	function dataResponseHandler()
	{
	  if (xhr.readyState==4 && xhr.status==200)
	  {
		  	var res = xhr.responseText;
			var resArr= res.split("@");
			wbsselectData=resArr;
			allWBSselectData(newRowCount,resArr);
			if(document.getElementById("wbsname"+newRowCount)!=null)
				document.getElementById("wbsname"+newRowCount).focus();
			
	  }
	}
	// for WBS Select Data
	function allWBSselectData(newRowCount,resArr)
	{
		//var customer=resArr[0].split("~");
		var product=resArr[0].split("~");
		var phase=resArr[1].split("~");
		var severity=resArr[3].split("~");
//		var wbs=resArr[3].split("~");
		
		
		//document.getElementById("wbsname"+newRowCount).options[0]= new Option("---select---"," ");
		 if(document.getElementById("productId"+newRowCount)!=null)
			document.getElementById("productId"+newRowCount).options[0]= new Option("---Select---"," ");
		if(document.getElementById("project_phase"+newRowCount)!=null)
		document.getElementById("project_phase"+newRowCount).options[0]= new Option("---Select---"," ");
		//document.getElementById("customerId"+newRowCount).options[0]= new Option("---select---"," ");
		if(document.getElementById("severity"+newRowCount)!=null)
			document.getElementById("severity"+newRowCount).options[0]= new Option("---Select---","-1");
			
		
		var j=1;
		/*for(var i=1;i<wbs.length;i=i+2)
		{
			document.getElementById("wbsname"+newRowCount).options[j]= new Option(wbs[i+1],wbs[i]);
	        j++;
		}
		
		var j=1;
		for(var i=1;i<customer.length;i=i+2)
		{
			document.getElementById("customerId"+newRowCount).options[j]= new Option(customer[i+1],customer[i]);
	        j++;
		}
		*/
		var j=1;
		 if(document.getElementById("productId"+newRowCount)!=null)
		 {
			 for(var i=1;i<product.length;i=i+2)
		 	{
			document.getElementById("productId"+newRowCount).options[j]= new Option(product[i+1],product[i]);
	        j++;
		 	}
		 }
		var j=1;
		if(document.getElementById("project_phase"+newRowCount)!=null){
			for(var i=1;i<phase.length;i=i+2)
		 	{
		  		document.getElementById("project_phase"+newRowCount).options[j]= new Option(phase[i+1],phase[i]);
		        j++;
		 	}
	 	}
	 if(document.getElementById("activity_code"+newRowCount)!=null){
		 if(newRowCount==1)
		 {
		  document.getElementById("activity_code"+newRowCount).value=resArr[2];
		 }
		else
	 	{
		  tempcount=newRowCount-1;
		  var temp=document.getElementById("activity_code"+tempcount).value;
		  document.getElementById("activity_code"+newRowCount).value=+temp+1;
	 	}
	 }
	 if(document.getElementById("severity"+newRowCount)!=null){
		 j=1;
		 for(var i=1;i<severity.length;i=i+2)
		 {
			 document.getElementById("severity"+newRowCount).options[j]= new Option(severity[i+1],severity[i]);
			 j++;
		 }
	 }
	}
	// for delete table  row
	function deleteRowTable(delBtn) 
	{
		debugger;
		if(delBtn=="timeSheet"){
		var table = document.getElementById(delBtn);
		var tbody = document.getElementById(delBtn).getElementsByTagName("TBODY")[0];
//		var row = document.createElement("TR");
		var rowCount = table.rows.length;
		var prRow;
		var selectcounter=0;
		if(rowCount!=0){
			//var prRow=table.rows[rowCount-1];
			for(var i=1;i<rowCount;i++){
				ptRow=table.rows[i];
				//alert("selected "+ ptRow.cells[0].childNodes[0].checked); 
				
				 if(ptRow.cells[0].childNodes[0] != undefined && ptRow.cells[0].childNodes[0].checked == true){
					ptRow.remove();
					rowCount--;
					selectcounter++;
					}
					
				/*else if(document.getElementById("select" + i).checked=undefined)
				{
					return false;
				}
				else{
					alert("No row is select for the deletion");
		//		return;
				}*/
					
				/*if(prRow.cells[i].childNodes[0]!=null && prRow.cells[i].childNodes[0].value.trim()==""){
						alert("Please enter value in :"+prRow.cells[i].childNodes[0].placeholder);
						//prRow.cells[i].childNodes[0].focus();
						return false;
				}*/
			}
			if(selectcounter<1)
				alert("No row is select for the deletion");
		}

		}else{
	            var elem = $(delBtn).parent('td').parent('tr').parent('tbody');
		    $(delBtn).parent('td').parent('tr').remove();
		    FindFirst(elem);

		}
	}



	// for add table row

		function addRow(tableId,th) {
		debugger;
			
			// buttonDisable(true);
			var table = document.getElementById(tableId);
			var tbody = document.getElementById(tableId).getElementsByTagName(
					"TBODY")[0];
			var row = document.createElement("TR");

			var rowCount = table.rows.length;

			var x = rowCount - 1;

			 //if (document.getElementById("wbsname1").value == ""
			//		|| document.getElementById("customerId1").value == ""
			if (document.getElementById("customerId1").value == ""
					|| document.getElementById("productId1").value == ""
					|| document.getElementById("project_phase1").value == ""
					|| document.getElementById("activity_code" + x).value == ""
					|| document.getElementById("activity_name" + x).value == ""
					|| document.getElementById("module" + x).value == ""
					//|| document.getElementById("contractId" + x).value == ""
					|| document.getElementById("contractId" + x).value == ""//){
					//||(document.getElementById("isParent" + x).checked == false
					&&( document.getElementById("wbs_complexity" + x).value == "-1"
					|| document.getElementById("wbs_planmandays" + x).value == ""
					|| document.getElementById("wbs_bug" + x).value == "-1"
					|| document.getElementById("wbs_payment" + x).value == "-1"
					|| document.getElementById("wbs_Enterby" + x).value == "-1"
					|| (document.getElementById("wbs_EntrybyName" + x).value == "" ||document.getElementById("wbs_EntrybyName" + x).value == "-1")
					)){//) {
			alert("Please Fill Previous Row First...!!");
				return false;
			} else{

				var strHtml5 = "<textarea class=\"form-control noResize\" name=\"activity_code\" maxlength=\"100\" " +
						"id=\"activity_code"+rowCount+"\" placeholder=\"Activity Code\" rows=\"2\"	cols=\"50\"  " +
								" style=\"width: 100% !important;    max-width: 100px; height: 100% !important\" readonly ></textarea>";
				var strHtml6 = "<textarea  class=\"form-control noResize\" name=\"activity_name\" id=\"activity_name"+rowCount+"\" " +
						"placeholder=\"Activity Name\" style=\"width:100% !important;height:100% !important;\" onkeypress=\"return alphaNumChat(event)\" onblur=\"sanitize(this)\"></textarea>";

/*				var strHtml6 = "<SELECT class=\"form-control\" id=\"activity_name"+rowCount+"\" name=\"Activity Name\"  style=\"width:100%;min-width:80px;\"> ";
				strHtml6 = strHtml6 + "<option value=\"0\">---Select---</option> ";
				strHtml6 = strHtml6 + "</SELECT> ";*/
				var strHtml7 = "<SELECT id=\"module"+rowCount+"\" class=\"form-control\" name=\"module\"  style=\"width:100%;min-width:150px;\"> ";
				strHtml7 = strHtml7 + "</SELECT> ";
				var strHtml15 = "<SELECT id=\"contractId"+rowCount+"\" class=\"form-control\" name=\"contractId\"  style=\"width:100%;min-width:150px;\"> ";
				strHtml15= strHtml15 + "</SELECT> ";
				 
				//var strHtml8="<select id=\"parent_id"+rowCount+"\" name=\"parent_Id\" class=\"form-control\" ></select>" +
				//		"<input type=\"hidden\" value=\"-1\" id=\"parent_id_count"+rowCount+"\" name=\"parent_Id_count\"  style=' width: 100% !important; height: 55px!important;' />";
				var strHtml8="<textarea style=\"width: 100% !important; height: 55px !important\"  rows=\"2 \" cols=\"50 \" class=\"form-control noResize\" "+
		               					" class=\"form-control\"  placeholder=\"Activity Description\" " +
						            " id=\"parent_id"+rowCount+"\" name=\"parent_Id\" style=\' width: 100% !important; height: 55px!important;' onkeypress=\"return alphaNumChat(event)\" onblur=\"sanitize(this)\"></textarea>" +
							    "<input type=\"hidden\" value=\"-1\" id=\"parent_id_count"+rowCount+"\" name=\"parent_Id_count\"  style=' width: 100% !important; height: 55px!important;' />";
				//onchange=\"setParentId(this)\"
				var strHtml14 = "<select id=\"wbs_srs"+rowCount+"\" name=\"wbs_srs\"  class=\"form-control\" >"+
								"<option value=\"0\">--Select--</option>"+
								"<option value=\"Yes\">Yes</option>"+
								"<option value=\"No\">No</option>"+
								"</select>";

				var strHtml9 = "<select id=\"wbs_complexity"+rowCount+"\" name=\"wbs_complexity\"  class=\"form-control\"  onchange=\"getEmpList("+rowCount+",'employees_emp_kid')\">"+
								"<option value=\"-1\">--Select--</option>"+
								"<option value=\"S\">Simple</option>"+
								"<option value=\"M\">Medium</option>"+
								"<option value=\"C\">Complex</option>"+
								"</select>";
				
				
				var strHtml10 = "<input class=\"form-control\" type=\"text\""+
								"name=\"wbs_planmandays\"  id=\"wbs_planmandays"+rowCount+"\" "+
								"placeholder=\"Plan Man Days\" size=\"30\" maxlength=\"2\" " +
								"style=\"max-width:100px;\" onkeypress=\"return isNumberKey(event)\"/>"
				
				var strHtml11 = "<select id=\"severity"+rowCount+"\" name=\"severity\" onchange=\"getEmpList("+rowCount+",'employees_emp_kid')\" class=\"form-control\" style=\"width: 120px; height: 30px;\">";
				
				var strHtml12 = "<input type='checkbox' id='isParent"+rowCount+"' name='isParent' onchange=\"disableFlds1('"+rowCount+"');\" />"+
								"<input type=\"hidden\" id=\'sub_activity_details"+rowCount+"\' name=\"sub_activity_details\" /><a class=\"Btn View\" id=\"view\" onclick=\"showsubTable('WBSDetail',this)\" style=\"padding: 5px 0;\">" +
								<!--"<input type=\"hidden\" id=\'parent_id"+rowCount+"\' name=\"parent_id\" />" +-->
 						" <i class=\"glyphicon glyphicon-thumbs-up\" style=\"margin-right: 6px;\"></i><span>Sub Task</span></a>";
				
				var strHtml13 = $('.addButtonTd').first().html();

				var strHtml24 = "<select id=\"wbs_bug"+rowCount+"\" name=\"wbs_bug\" class=\"form-control\" style=\"width: 120px; height: 30px;\">"+
								"<option value=\"0\">--Select--</option>"+
								"<option value=\"Y\">Yes</option>"+
								"<option value=\"N\">No</option>"+
								"</select>";
				var strHtml25 = "<select id=\"wbs_payment"+rowCount+"\" name=\"wbs_payment\" class=\"form-control\" style=\"width: 120px; height: 30px;\">"+
								"<option value=\"0\">--Select--</option>"+
								"<option value=\"Y\">Yes</option>"+
								"<option value=\"N\">No</option>"+
								"</select>";
				var strHtml16 = "<select id=\"wbs_enterby"+rowCount+"\" name=\"wbs_enterby\" class=\"form-control\" style=\"width: 120px; height: 30px;\" onchange=\"getEmpList("+rowCount+",'wbs_entrybyEName')\">"+
								"<option value=\"0\">--Select--</option>"+
								"<option value=\"E\">Employee</option>"+
								"<option value=\"C\">Company</option>"+
									"</select>";
				var strHtml18 = "<input type=\"text\"  name=\"wbs_entrybyCName\" class=\"form-control \" maxlength=\"100\" id=\"wbs_entrybyCName"+rowCount+"\"  size=\"50\" style=\"width:150px;\" > <select id=\"wbs_entrybyEName"+rowCount+"\" name=\"wbs_entrybyEName\" class=\"form-control\" style=\"width: 120px; height: 30px;\">";
				var strHtml19 = "<select id=\"employees_emp_kid"+rowCount+"\" name=\"employees_emp_kid\" class=\"form-control\" style=\"width: 120px; height: 30px;\">";
				var strHtml20 = "<input type=\"text\"  name=\"fromDate\" class=\"datepicker\" maxlength=\"100\" id=\"fromDate"+rowCount+"\" placeholder=\"Plan Start Date\" size=\"30\" style=\"width:150px;\" >";
				var strHtml21 = "<input type=\"text\"  name=\"toDate\" class=\"datepicker\" maxlength=\"100\" id=\"toDate"+rowCount+"\" placeholder=\"Plan End Date\" size=\"30\" style=\"width:150px;\" >";
				//row.appendChild(td3);
				//row.appendChild(td2);
				//row.appendChild(td1);
				//row.appendChild(td4);
				$(table).append('<tr class="dataRow">'+
								'<td style="padding: 0;max-width:150px;min-width:150px;">'+strHtml7+'</td>'+
								'	<td style="padding: 0;text-align: center;">'+strHtml15+'</td>'+
								'<td style="padding: 0;max-width:150px;min-width:150px;">'+strHtml5+'</td>'+
								'	<td style="padding: 0px;">'+strHtml6+'	</td>'+
								'	<td style="padding: 0;">'+strHtml14+'</td>'+
								'	<td style="padding: 0;text-align:center;">'+strHtml12+'</td>'+
								'	<td style="padding: 0;">'+strHtml8+'</td>'+
								'	<td style="padding: 0;">'+strHtml11+'</td>'+
								'	<td style="padding: 0;">'+strHtml9+'</td>'+
								'	<td style="padding: 0;">'+strHtml24+'</td>'+
								'	<td style="padding: 0;">'+strHtml25+'</td>'+
								'	<td style="padding: 0;">'+strHtml16+'</td>'+

								'	<td style="padding: 0;">'+strHtml18+'</td>'+
								'	<td style="padding: 0;">'+strHtml19+'</td>'+
								'		<td style="padding: 0;">'+strHtml10+'</td>'+				
								'	<td style="padding: 0;">'+strHtml20+'</td>'+
								'	<td style="padding: 0;">'+strHtml21+'</td>'+
								'		<td class="addButtonTd">'+strHtml13+'</td>'+
								'	</tr>')
				FindFirst(tbody);
				//tbody.appendChild(row);
				count1 = parseInt(count1) + 1;
				allWBSselectData(rowCount, wbsselectData);
				document.getElementById("module" + rowCount).innerHTML = document.getElementById("module" + x).innerHTML;
				/*document.getElementById("customerId" + rowCount).innerHTML = document.getElementById("customerId" + x).innerHTML;
				document.getElementById("wbsname" + rowCount).value = document.getElementById("wbsname" + x).value;*/
				document.getElementById("module" + rowCount).value = document.getElementById("module" + x).value;
				getContractName(document.getElementById("customerId1"),rowCount)
				//document.getElementById("contractId" + rowCount).value = document.getElementById("contractId" + x).value;
				document.getElementById("activity_name" + rowCount).focus();
				//addParentId(rowCount);
				$(table).find("td").css("padding:0;");
				//alert("x"+x);
				//alert("rowCount"+rowCount);
				//$('#wbs_complexity'+ rowCount).hide();
				//$('#wbs_planmandays'+ rowCount).hide();
				//$('#severity'+ rowCount).hide();
				//$("td:nth-child(8)").hide();	
				//$("td:nth-child(9)").hide();	
				//$("td:nth-child(10)").hide();		
					$("td:nth-child(3)").hide();

					$('#wbs_EntrybyEName'+rowCount).hide();	
					$('#wbs_EntrybyCName'+rowCount).hide();	
			}
		} 
	 
	function addRowTable(tableId)
	{
		debugger;
		alert("inside add row table");
		var table = document.getElementById(tableId);
		var tbody = document.getElementById(tableId).getElementsByTagName("TBODY")[0];
		var row = document.createElement("TR");
		var rowCount = table.rows.length;
		var row = table.insertRow(rowCount);
		var cell1 = row.insertCell(0);
		
			if(rowCount>10)
			{
				alert("Not Add more then 12 fields");
				return;
			}
			else
			{
				var element1 = document.createElement("input");
				element1.type = "checkbox";
				element1.name = "select";
				element1.id = "select"+count1;
				element1.class="form-control";
				cell1.appendChild(element1);
				cell1.style.width="5%" ;

				var td1 = document.createElement("TD")
				var id3="\"colType"+count1+"\"";
				var strHtml3 = "<SELECT name=\"colType\" class=\"form-control\"> ";
					strHtml3 = strHtml3 + "<option value=\"String\" selected >String</option> "; 	
					strHtml3 = strHtml3 + "<option value=\"Boolean\">Boolean</option> "; 	
					strHtml3 = strHtml3 + "<option value=\"Date\">Date</option> ";
					strHtml3 = strHtml3 + "</SELECT> ";
					
				td1.innerHTML = strHtml3.replace(/!count1!/g,count1);
				td1.style.width='20%';
				row.appendChild(td1);
				count1 = parseInt(count1) + 1;
			}
	}

	function workAssign(id)
	{
		if(document.getElementById("resourceId").value=="-1")
		{
				alert("Please Select Resource Name");
				return false;
	  	}
		var val=confirm("Are you Sure Save Assign Work");
		if(val)
		{
				document.form.action="saveWorkAssign.action?id="+id;
				document.form.submit();
		}
	}
	function saveWbsEntry()
	{
		if(parseInt(count)>0)
		{
			alert("WBS Entry saving is in process please wait!!!");
			return 0;
		}
		var table = document.getElementById("WBSDetail");
		var rowCount = table.rows.length;
		for(var i=1;i<rowCount;i++)
		{
			if(i==1){

				/*if(document.getElementById("wbsname"+i).value==" ")
				{
					alert("Please Fill wbsname");
					document.getElementById("wbsname"+i).focus();
					return false;
				}
				else*/ if(document.getElementById("customerId"+i).value==" ")
				{
					alert("Please Select Customer");
					document.getElementById("customerId"+i).focus();
					return false;
				}
				else if(document.getElementById("productId"+i).value==" ")
				{
					alert("Please Select product");
					document.getElementById("productId"+i).focus();
					return false;
				}
				if(document.getElementById("project_phase"+i).value==" ")
				{
					alert("Please Select project_phase");
					document.getElementById("project_phase"+i).focus();
					return false;
				}
			}
			
			 if(document.getElementById("module"+i).value==" ")
			{
				alert("Please Select module");
				document.getElementById("module"+i).focus();
				return false;
			}
			else if(document.getElementById("contractId"+i).value=="" || document.getElementById("contractId"+i).value=="0"  )
			{
				alert("Please Fill contractId ");
				document.getElementById("contractId"+i).focus();
				return false;
			}
			else if(document.getElementById("activity_code"+i).value=="")
			{
				alert("Please Fill activity_code ");
				document.getElementById("activity_code"+i).focus();
				return false;
			}
			else if(document.getElementById("activity_name"+i).value=="")
			{
				alert("Please Fill activity_name ");
				document.getElementById("activity_name"+i).focus();
				return false;
			}else if(document.getElementById("isParent"+i).checked==false)
			{
				/*if(document.getElementById("severity"+i).value=="-1")
				{
					alert("Please select severity type ");
					document.getElementById("severity"+i).focus();
					return false;
				}
				if(document.getElementById("wbs_complexity"+i).value=="-1")
				{
					alert("Please select complexity");
					document.getElementById("wbs_complexity"+i).focus();
					return false;
				}
				if(document.getElementById("wbs_planmandays"+i).value=="")
				{
					alert("Please fill plan man days ");
					document.getElementById("wbs_planmandays"+i).focus();
					return false;
				}*/
			}

		}
		
		var a=confirm("Are You Sure To Save Records..!!");
		if(a)
		{
			count=1;
			var url="";
			for(var i=1;i<rowCount;i++)
			{
				if(i==1){
					url+="productId="+document.getElementById("productId"+i).value
					+"&customerId="+document.getElementById("customerId"+i).value
					//+"&wbsname="+document.getElementById("wbsname"+i).value+
					+"&wbsname=99&project_phase="+document.getElementById("project_phase"+i).value+"&";
					//alert(url);
				}
				url+="module="+document.getElementById("module"+i).value+
				"&activity_code="+document.getElementById("activity_code"+i).value+"&activity_name="
				+ encodeURIComponent(document.getElementById("activity_name"+i).value);

				if(document.getElementById("isParent"+i)!=null && document.getElementById("isParent"+i).checked)
				{
					url+="&severity=-1&wbs_complexity=-1&wbs_planmandays=0&isParent=Y";
					/*document.getElementById("severity"+i).value="-1";
					document.getElementById("wbs_planmandays"+i).value="0";
					document.getElementById("wbs_complexity"+i).value="-1";*/

				}
				else
				{
					url+="&severity="+document.getElementById("severity"+i).value+"&wbs_complexity="+document.getElementById("wbs_complexity"+i).value+
					"&wbs_planmandays="+document.getElementById("wbs_planmandays"+i).value+"&isParent=N";
					//	document.getElementById("isParent"+i).value='N';
				}
				url+="&parent_Id="+document.getElementById("parent_id"+i).value;
				if(document.getElementById("parent_id"+i).value=="")
					url+="&parent_Id_count=-1";
				else
					url+="&parent_Id_count=" +document.getElementById("parent_id_count"+i).value;


				
				if(document.getElementById("sub_activity_details"+i).value=="")
					url+="&sub_activity_details='NA'";
				else
					url+="&sub_activity_details="+document.getElementById("sub_activity_details"+i).value;

				
	
				url+="&wbs_srs="+document.getElementById("wbs_srs"+i).value;
				url+="&contractId="+document.getElementById("contractId"+i).value;

				url+="&wbs_bug="+document.getElementById("wbs_bug"+i).value;
				url+="&wbs_payment="+document.getElementById("wbs_payment"+i).value;
				url+="&wbs_enterby="+document.getElementById("wbs_enterby"+i).value;
				url+="&wbs_entrybyCName="+document.getElementById("wbs_entrybyCName"+i).value;
				url+="&wbs_entrybyEName="+document.getElementById("wbs_entrybyEName"+i).value;
				url+="&employees_emp_kid="+document.getElementById("employees_emp_kid"+i).value;
				url+="&fromDate="+document.getElementById("fromDate"+i).value;
				url+="&toDate="+document.getElementById("toDate"+i).value;

				if(i!=rowCount-1)
					url+="&";
				//alert(url);
			}
			document.getElementById("save").disabled=true;
			document.getElementById("view").disabled=true;
			document.getElementById("cancel").disabled=true;

			url="createWBS.action?"+url;
			xhr = createAjax();
			xhr.open('POST',url,false);
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					var res=xhr.responseText;
					if(res=='ss'){
						alert("Entry saved successfully");
					count=0;
					}
					else {
						alert("Entry not saved");
						count=0;
					}
					window.location.href="WBSEntryScreen.action";
				}
			};
			xhr.send();

		}
	}
	// for show assign work
	function showWorkAssign()
	{
debugger;
		if(document.getElementById("ResourceSelect").value=="-1")
		{
			alert("Please Select Resource Name First");	
			var myNode = document.getElementById("innertableid");
			myNode.align="center";
			myNode.innerHTML = '';
		 	document.getElementById("adHoc").disabled=true;
			document.getElementById("viewAdHoc").disabled=true;
		}
		else{
			var id=document.getElementById("ResourceSelect").value;
			var url="getAssignedData.action?id="+id;
			xhr = createAjax();
		    xhr.open('POST',url,false);
		    xhr.onreadystatechange=getAssignData ;
		    xhr.send();
		}	
	}
	function dateCompare(row)
	{
		var startDate=document.getElementById("startdate"+row).value;
		var endDate=document.getElementById("enddate"+row).value;
		if(document.getElementById("startdate"+row).value=="" || document.getElementById("enddate"+row).value=="")
		{
			alert("Please Fill Dates First");	
			document.getElementById("startdate"+row).value="";
			document.getElementById("enddate"+row).value="";
			document.getElementById("totaltime"+row).value="";
			document.getElementById("totaltime"+row).readOnly=true;
		}
		else
		{
			var splitStartDate = startDate.split(' ');
			var splitEndDate = endDate.split(' ');

			var startDateArray = splitStartDate[0].split('/');
			var endDateArray = splitEndDate[0].split('/');

			var startDateTime = new Date(startDateArray[2] + '/ ' + startDateArray[1] + '/' + startDateArray[0] + ' ' + splitStartDate[1]);
			var endDateTime = new Date(endDateArray[2] + '/ ' + endDateArray[1] + '/' + endDateArray[0] + ' ' + splitEndDate[1]);

			if (startDateTime > endDateTime)
			{
				alert('End date should be Greater than start date.');
				document.getElementById("startdate"+row).value="";
				document.getElementById("enddate"+row).value="";
				document.getElementById("startdate"+row).focus();
			}
			else 
			{
				newRowCount=row;
				var url="getDateDiff.action?startDate='"+startDate+"'&endDate='"+endDate+"'";
				xhr = createAjax();
				xhr.open('POST',url,false);
				xhr.onreadystatechange=getdateCompare ;
				xhr.send();
			}
		}
	}
	function getdateCompare()
	{
		if (xhr.readyState==4 && xhr.status==200)
		{
			var res=xhr.responseText;
			if(parseInt(res)<=630)
			{
				document.getElementById("totaltime"+newRowCount).value=res;
				document.getElementById("totaltime"+newRowCount).readOnly=true;
				document.getElementById("remark"+newRowCount).focus();
			}
			else
			{
				alert("Start Date and End date should be Same ... !!!")
				document.getElementById("startdate"+newRowCount).value="";
				document.getElementById("enddate"+newRowCount).value="";
				document.getElementById("totaltime"+newRowCount).value="";
				document.getElementById("startdate"+newRowCount).focus();
			}
		
		}
	}
	function disableDates(row)
	{
		var totalvalue=document.getElementById("totaltime"+row).value;
		
		if(totalvalue.length>0)
		{
			var startdate=document.getElementById("startdate"+row).value;
			var tempDate=new Date(startdate.substring(6,10)+"/"+startdate.substring(3,5)+"/"+startdate.substring(0,2)+" "+startdate.substring(11,16));
			var dates=startdate.split(" ");
			var limit="20:30:00";
			if(startdate=="")
			{
				alert("Please Enter Start Date First");
				document.getElementById("startdate"+row).value="";
				document.getElementById("enddate"+row).value="";
				document.getElementById("totaltime"+row).value="";
				document.getElementById("startdate"+row).readOnly=false;
				document.getElementById("enddate"+row).readOnly=false;
				document.getElementById("startdate"+row).focus();
			}
			else
			{
				if(totalvalue>=60)
				{
					if(totalvalue>630)
					{
							alert("Your End Date Cross The Day Limit");
							document.getElementById("startdate"+row).value="";
							document.getElementById("enddate"+row).value="";
							document.getElementById("totaltime"+row).value="";
							document.getElementById("startdate"+row).readOnly=false;
							document.getElementById("enddate"+row).readOnly=false;
							document.getElementById("startdate"+row).focus();
					}
					else
					{
						var minutes=tempDate.getMinutes()+parseInt(totalvalue);
						var hours=tempDate.getHours()+parseInt(minutes/60);
						minutes=minutes%60;

						var exceed=hours+":"+minutes+":"+"00";

						if(exceed>limit)
						{
							alert("Your time is Greater than ofc Time please enter right time");
							document.getElementById("startdate"+row).value="";
							document.getElementById("enddate"+row).value="";
							document.getElementById("totaltime"+row).value="";
							document.getElementById("startdate"+row).readOnly=false;
							document.getElementById("enddate"+row).readOnly=false;
						}
						else
						{
							document.getElementById("enddate"+row).value=dates[0]+" "+hours+":"+minutes;
							document.getElementById("startdate"+row).readOnly=true;
							document.getElementById("enddate"+row).readOnly=true;
						}
					}
				}
				else if(totalvalue<60)
				{
					var datetime=tempDate.getMinutes()+(+totalvalue);
						if(datetime>=60)
						{
							var hours=tempDate.getHours()+parseInt(datetime/60);
							var minutes=datetime%60;
							if(parseInt(minutes)==0)
							{
								minutes="00";
							}
							var exceed=hours+":"+minutes+":"+"00";
							if(exceed>limit)
							{
								alert("Your time is Greater than ofc Time please enter right time");
								document.getElementById("startdate"+row).value="";
								document.getElementById("enddate"+row).value="";
								document.getElementById("totaltime"+row).value="";
								document.getElementById("startdate"+row).readOnly=false;
								document.getElementById("enddate"+row).readOnly=false;
								document.getElementById("startdate"+row).focus();
							}
							else
							{
								document.getElementById("enddate"+row).value=dates[0]+" "+hours+":"+minutes;
								document.getElementById("startdate"+row).readOnly=true;
								document.getElementById("enddate"+row).readOnly=true;
							}
							
						}
						else
						{
							var exceed=tempDate.getHours()+":"+datetime;":"+"00";
							if(exceed>limit)
							{
								alert("Your End Date and time is Greater than ofc Time please enter right time");
								document.getElementById("startdate"+row).value="";
								document.getElementById("enddate"+row).value="";
								document.getElementById("totaltime"+row).value="";
								document.getElementById("startdate"+row).readOnly=false;
								document.getElementById("enddate"+row).readOnly=false;
								document.getElementById("startdate"+row).focus();
							}
							else
							{
								document.getElementById("enddate"+row).value=dates[0]+" "+tempDate.getHours()+":"+datetime;
								document.getElementById("startdate"+row).readOnly=true;
								document.getElementById("enddate"+row).readOnly=true;
							}
							
						}	
				}
			}
		}
		else
		{
			document.getElementById("startdate"+row).readOnly=false;
			document.getElementById("enddate"+row).readOnly=false;
			document.getElementById("startdate"+row).value="";
			document.getElementById("enddate"+row).value="";
			document.getElementById("startdate"+row).focus();
		}
	}

	function addTimeSheetRow(tableId)
	{
		debugger;
		var table = document.getElementById(tableId);
		var tbody = document.getElementById(tableId).getElementsByTagName("TBODY")[0];
//		var row = document.createElement("TR");
		var rowCount = table.rows.length;
		if(rowCount!=0){
			var prRow=table.rows[rowCount-1];
			for(var i=1;i<prRow.cells.length-1;i++){
					//commented on 6-12-22
					/*if(prRow.cells[i].childNodes[0]!=null && prRow.cells[i].childNodes[0].value.trim()==""){
					alert("Please enter value in :"+prRow.cells[i].childNodes[0].placeholder);
					//prRow.cells[i].childNodes[0].focus();
					return false;
				}*/
			}
		}
		var row = table.insertRow(rowCount);
		var cell1 = row.insertCell(0);
		var element1 = document.createElement("input");
		element1.type = "checkbox";
		element1.name = "select";
		//element1.id = "select"+count1;
		element1.id = "select"+rowCount;
		element1.class="form-control";
		cell1.appendChild(element1);
		
		var td2 = document.createElement("TD")
		var id2="\"colRem"+count1+"\"";
		var strHtml2 = "<select name=\"productlife\" class=\"form-control \" id=\"productlife"+rowCount+"\"  style=\"width:250px;\"><option value=\"-1\">--Select--</option></select>";
		td2.innerHTML = strHtml2.replace(/!count1!/g,count1);
			
	var td3 = document.createElement("TD")
		var id3="\"colRem"+count1+"\"";
		var strHtml3 = "<input type=\"text\"  name=\"startdate\" class=\"form-control datepicker \" maxlength=\"100\" id=\"startdate"+rowCount+"\" placeholder=\"Actual Start Date\" size=\"30\" set autocomplete=\"off\" style=\"width:150px;\" >";
		td3.innerHTML = strHtml3.replace(/!count1!/g,count1);

		var td4 = document.createElement("TD")
		var id4="\"colRem"+count1+"\"";
		var strHtml4 = "<input type=\"text\" name=\"enddate\" class=\"form-control datepicker\"  id=\"enddate"+rowCount+"\" placeholder=\"Actaul End Date\" size=\"30\"onblur=\"dateCompare('"+rowCount+"')\" set autocomplete=\"off\" style=\"width:150px;\" >";
		td4.innerHTML = strHtml4.replace(/!count1!/g,count1);

		var td5 = document.createElement("TD")
		var id5="\"colRem"+count1+"\"";
		var strHtml5 = "<input type=\"text\" readonly name=\"totaltime\" class=\"form-control totalTime\"  maxlength=\"100\" id=\"totaltime"+rowCount+"\" placeholder=\"Total Time\" size=\"30\" onchange=\"disableDates('"+rowCount+"')\" style=\"width:100px;\"  >";
		td5.innerHTML = strHtml5.replace(/!count1!/g,count1);


		var td6 = document.createElement("TD")
		var id6="\"colRem"+count1+"\"";
		var strHtml6 = "<input type=\"text\"  name=\"remark\" class=\"form-control\"  id=\"remark"+rowCount+"\" placeholder=\"Remarks\" size=\"30\" style=\"width:400px;\"   >";
		td6.innerHTML = strHtml6.replace(/!count1!/g,count1);

		var td7 = document.createElement("TD")
	 	var id7="\"colRem"+count1+"\"";
	 	var strHtml7 = "<input type=\"checkbox\"  name=\"workStatus\"  id=\"workStatus"+rowCount+"\">";
	 	td7.innerHTML = strHtml7.replace(/!count1!/g,count1);
	 
		row.appendChild(td2);
		row.appendChild(td3);
		row.appendChild(td4);
		row.appendChild(td5);
		row.appendChild(td6);
		row.appendChild(td7);
		allproductselectData(rowCount, wbsselectData);
		adddatepicker();
		disabledatepicker();
	}

	function getAssignData()
	{
		if (xhr.readyState==4 && xhr.status==200)
		{
			var res=xhr.responseText;
			if(res=="")
			{
				var myNode = document.getElementById("headertable_dev").getElementsByTagName("TBODY")[0];
				myNode.align="center";
				myNode.innerHTML = 'No Record Found';
			}
			else
			{
				var data=res.split('@');
				var data1;
				var myNode = document.getElementById("headertable_dev").getElementsByTagName("TBODY")[0];
				myNode.innerHTML = '';
				if(data[0]=="support"){
					var arr=new Array("65px","65px","65px","370px","370px","80px","40px");
					for(var i=1;i<data.length;i++)
					{
						data1=data[i].split("~");
						var row=myNode.insertRow(myNode.rows.length);
						for(var j=1;j<data1.length-1;j++){
							var cell=row.insertCell(j-1);
							var style="width:"+arr[j-1]+";";
							if(j==4 || j==5)
								style+="text-align:left;";
							else
								style+="text-align:center;";
							cell.style=style;
							if(j==4)
							{
								var strHtml1 ="<textarea rows=\"2\" cols=\"42\" readonly style=\"text-align:left;" +
										"width:100%;height:100%;word-wrap: break-word;resize:none;\">"+data1[j]+"</textarea>";
								cell.innerHTML=strHtml1;
							}else if(j==5){
									var strHtml1 ="<textarea rows=\"2\" cols=\"42\" readonly style=\"text-align:center;" +
								"width:100%;height:100%;word-wrap: break-word;resize:none;\">"+data1[j]+"</textarea>";
									cell.innerHTML=strHtml1;
							}
							else{
								cell.innerHTML=data1[j];
							}
						}
					}
					document.getElementById("headertable_dev").style.display="none";
					document.getElementById("headertable_qc").style.display="inline-table";
					document.getElementById("adHoc").disabled=false;
					document.getElementById("viewAdHoc").disabled=false;
					return false;
				}
				document.getElementById("headertable_dev").style.display="inline-table";
				document.getElementById("headertable_qc").style.display="none";
				for(var i=1;i<data.length;i++)
				{
					data1=data[i].split("~");
					var table = document.getElementById("headertable_dev").getElementsByTagName("TBODY")[0];
					var tbody = document.getElementById("headertable_dev")
					var row = document.createElement("TR");
					var rowCount = table.rows.length;
					var row = table.insertRow(rowCount);
					for(var j=1;j<data1.length;j++)
					{  
						if(j==1)
						{
							var td1 = document.createElement("TD")
							td1.innerHTML = data1[j];
							/*td1.style.width='65px';*/
							td1.align='center';
							row.appendChild(td1);
						}
						else if(j==2)
						{
							var td1 = document.createElement("TD")
							td1.innerHTML = data1[j];
							/*td1.style.width='65px';*/
							td1.align='center';
							row.appendChild(td1);
						}
						else if(j==3)
						{
							var td1 = document.createElement("TD")
							td1.innerHTML = data1[j];
							/*td1.style.width='75px';*/
							td1.align='center';
							row.appendChild(td1);
						}
						else if(j==4)
						{
							var td1 = document.createElement("TD")
							/*var strHtml1 ='<span style="max-width:140px" class="wordWrap" title="'+data1[j]+'" > '+data1[j]+"</span>";*/
							
							var strHtml1 ="<textarea rows=\"2\" cols=\"42\" readonly class=\" noResize\" style=\"width: 100% !important; height=100% !important;\"\">"+data1[j]+"</textarea>";
							td1.innerHTML = strHtml1;
							td1.style.padding='0';
							row.appendChild(td1);
						}
						else if(j==5)
						{
							/*var td1 = document.createElement("TD")
							var strHtml1 ="";
							if(data1[j]=="-")
								strHtml1="<textarea rows=\"2\" cols=\"42\" readonly class=\"form-control noResize\" style=\"text-align:center;\">"+data1[j]+"</textarea>";
							else
								strHtml1="<textarea rows=\"2\" cols=\"42\" readonly class=\"form-control noResize\" style=\"\">"+data1[j]+"</textarea>";
							td1.innerHTML = strHtml1;
							td1.style.width='350px';*/
							/*row.appendChild(td1);*/
						}
						else if(j==6)
						{
							var td1 = document.createElement("TD")
							td1.innerHTML = data1[j];
							/*td1.style.width='65px';*/
							td1.align='center';
							row.appendChild(td1);
						}
						else if(j==7)
						{
							var td1 = document.createElement("TD")
							td1.innerHTML = data1[j];
							/*td1.style.width='65px';*/
							td1.align='center';
							row.appendChild(td1);
						}
						else if(j==8)
						{
							var td1 = document.createElement("TD")
							td1.innerHTML = data1[j];
							/*td1.style.width='65px';*/
							td1.align='center';
							row.appendChild(td1);
						}
						else if(j==9)
						{
							var td1 = document.createElement("TD")
							td1.innerHTML = data1[j];
							/*td1.style.width='65px';*/
							td1.align='center';
							row.appendChild(td1);
						}else if(j==10)
						{
							/*var td1 = document.createElement("TD")
							td1.innerHTML = data1[j];
							td1.style.width='40px';
							td1.align='center';
							row.appendChild(td1);*/
						}
						else
						{
							var newA = document.createElement('button');
							newA.setAttribute('data-target',"#myModal");
							newA.setAttribute('class',"buttonSave");
							newA.setAttribute('data-toggle',"modal");
							newA.setAttribute('class',"fa fa-book");
							/*newA.serAttribute('style', "height:25px;");*/
							newA.setAttribute('onclick',"setWBSId('"+data1[j]+"','normalTM')");
							//newA.setAttribute('style',"width:80px;font-size:8pt");
							/*newA.innerHTML = "Time Sheet";*/
							//newA.style.backgroundColor="#9A5252";
							//td1.style.height='35px';ewA.i
							row.appendChild(newA);
						}
					}
				}
				addPagination();
			}
			document.getElementById("adHoc").disabled=false;
			document.getElementById("viewAdHoc").disabled=false;
			
		}
	}


	function setEditFlag(id,row)
	{
		var editid=document.getElementById("editid").value;
		editid += id+",";
		document.getElementById("editid").value=editid;
		document.getElementById("Edit"+row).disabled=true;
		//document.getElementById("startdate"+row).disabled=false;
		//document.getElementById("enddate"+row).disabled=false;
		//document.getElementById("totaltime"+row).disabled=false;
		document.getElementById("remark"+row).disabled=false;
		adddatepicker();	
	}
	function setWBSId(id,flag) 
	{
	  	document.getElementById("wbsname").innerHTML="";
	 	document.getElementById("customerId").innerHTML="";
	 	document.getElementById("productId").innerHTML="";
	 	document.getElementById("wbsname").disabled=false;
	 	document.getElementById("customerId").disabled=false;
	 	document.getElementById("productId").disabled=false;
	 
		getSelectData('');
	 	
		if(flag=='adHocTM')
		{
			 var resourseid=document.getElementById("ResourceSelect").value;
			 	if(resourseid!="")
				 {
			 		document.getElementById("flag").value=flag;
			 		document.getElementById("commonId").value=resourseid;
		 			adHocWork();
				 }
			 	else
			 	{
			 		alert("please select Resourse First..!!!");
			 		return;
			 	}
		}
		else if(flag=="normalTM")
		{
				document.getElementById("commonId").value = id;
				var url="fetchTimeSheetData.action?id="+id;
				xhr = createAjax();
				xhr.open('POST',url,false);
				xhr.onreadystatechange=fetchTimeSheetData ;
				xhr.send();
		}
	}
	function adHocWork()
	{
		var table = document.getElementById("timeSheet");
		var tbody = document.getElementById("timeSheet").getElementsByTagName("TBODY")[0];
		var row = document.createElement("TR");
		var rowCount = table.rows.length;
		if(rowCount>=1){
			var r=rowCount-1;
			if(document.getElementById("productId"+r).value==" " || 
					document.getElementById("customerId"+r).value==" " || 
					document.getElementById("wbsname"+r).value==" " || 
					document.getElementById("startdate"+r).value=="" || 
					document.getElementById("enddate"+r).value=="" ){
				alert("Please fill previous row first");
				return false;
			}
		}	
		var row = table.insertRow(rowCount);
		var cell1 = row.insertCell(0);
		if(rowCount==0){
			cell1.innerHTML="&nbsp;";
			cell1.style.width="1%";
		}
		else{
			var element1 = document.createElement("input");
			element1.type = "checkbox";
			element1.name = "select";
			element1.id = "select"+count1;
			element1.class="form-control";
			cell1.appendChild(element1);
			cell1.style.width="1%";
		}
		var td3 = document.createElement("TD")
		var id3="\"colRem"+count1+"\"";
		var strHtml3 = "<input type=\"text\" readonly  name=\"startdate\" class=\"form-control datepicker \" maxlength=\"100\" id=\"startdate"+rowCount+"\" placeholder=\"Actual Start Date\" size=\"30\" set autocomplete=\"off\" style=\"/*width: 130px;*/\">";
		td3.innerHTML = strHtml3.replace(/!count1!/g,count1);
		td3.style.width="125px";
		var td4 = document.createElement("TD")
		var id4="\"colRem"+count1+"\"";
		var strHtml4 = "<input type=\"text\" readonly  name=\"enddate\" class=\"form-control datepicker\"  id=\"enddate"+rowCount+"\" placeholder=\"Actaul End Date\" size=\"30\"onblur=\"dateCompare('"+rowCount+"')\" set autocomplete=\"off\" style=\"/*width: 130px;*/\">";
		td4.innerHTML = strHtml4.replace(/!count1!/g,count1);
		td4.style.width="125px";

		var td5 = document.createElement("TD")
		var id5="\"colRem"+count1+"\"";
		var strHtml5 = "<input type=\"text\" name=\"totaltime\" class=\"form-control totalTime\" readonly  maxlength=\"100\" id=\"totaltime"+rowCount+"\" placeholder=\"Total Time\" size=\"30\" onchange=\"disableDates('"+rowCount+"')\" style=\"/*width: 130px;*/\" >";
		td5.innerHTML = strHtml5.replace(/!count1!/g,count1);
		td5.style.width="125px";


		var td6 = document.createElement("TD")
		var id6="\"colRem"+count1+"\"";
		var strHtml6 = "<input type=\"text\"  name=\"remark\" class=\"form-control\"  id=\"remark"+rowCount+"\" placeholder=\"Remarks\" size=\"30\" style=\"/*width:400px*/\"  >";
		td6.innerHTML = strHtml6.replace(/!count1!/g,count1);
		td6.style.width="400px";


		var td7 = document.createElement("TD")
		var id7="\"colRem"+count1+"\"";
		var strHtml7 = "<select id=\"productId"+rowCount+"\"  class=\"form-control\" name=\"productId\"  style=\"/*width: 130px;*/\" onchange=\"getCustomers('"+rowCount+"')\"></select>";
		td7.innerHTML = strHtml7.replace(/!count1!/g,count1);
		td7.style.width="125px";

		var td8 = document.createElement("TD")
		var id8="\"colRem"+count1+"\"";
		var strHtml8 = "<select id=\"customerId"+rowCount+"\"  class=\"form-control\" name=\"customerId\"  style=\"/*width: 130px;*/\" onchange=\"getWBSName('"+rowCount+"')\"></select>";
		td8.innerHTML = strHtml8.replace(/!count1!/g,count1);
		td8.style.width="125px";

		var td9 = document.createElement("TD")
		var id9="\"colRem"+count1+"\"";
		var strHtml9 = "<select id=\"wbsname"+rowCount+"\"  class=\"form-control\"  name=\"wbsname\"  style=\"/*width: 130px;*/\"></select>";
		td9.innerHTML = strHtml9.replace(/!count1!/g,count1);
		td9.style.width="125px";

		row.appendChild(td7);
		row.appendChild(td8);
		row.appendChild(td9);
		row.appendChild(td3);
		row.appendChild(td4);
		row.appendChild(td5);
		row.appendChild(td6);
		getSelectData(rowCount)
		adddatepicker('adhoc');
		disabledatepicker();
		document.getElementById("timeSheetTable").style.display="none";
		document.getElementById("adhocTable").style.display="block";
		table.style.width="100%";
	}

	function fetchTimeSheetData()
	{
		debugger;
		if (xhr.readyState==4 && xhr.status==200)
		{
			var res=xhr.responseText;
			var r=res.charAt(0);
		  	if(r=="#")
			  {
			   res=res.substring(1);
			   var data=res.split("~");
			   document.getElementById("productId").value=data[0];
			   getCustomers('');
			   document.getElementById("customerId").value=data[1];
			   getWBSName('');
			   document.getElementById("wbsname").value=data[2];
			   document.getElementById("wbsname").disabled=true;
			   document.getElementById("customerId").disabled=true;
			   document.getElementById("productId").disabled=true;
			   document.getElementById("wbsid").value=data[3];
			   document.getElementById("wbsid").disabled=true;
	   
				document.getElementById("flag").value="N";
				
				var table = document.getElementById("timeSheet");
				var tbody = document.getElementById("timeSheet").getElementsByTagName("TBODY")[0];
				var row = document.createElement("TR");
				var rowCount = table.rows.length;
				var row = table.insertRow(rowCount);
				var cell1 = row.insertCell(0);

				var td2 = document.createElement("TD")
				var id2="\"colRem"+count1+"\"";
				var strHtml2 = "<select name=\"productlife\" class=\"form-control \" id=\"productlife"+rowCount+"\" style=\"width:250px;\" ></select>";
				td2.innerHTML = strHtml2.replace(/!count1!/g,count1);
				row.appendChild(td2);	
				allproductselectData(rowCount, wbsselectData);
				
				var td3 = document.createElement("TD")
				var id3="\"colRem"+count1+"\"";
				var strHtml3 = "<input type=\"text\" name=\"startdate\" class=\"form-control datepicker \" maxlength=\"100\" id=\"startdate"+rowCount+"\" placeholder=\"Actual Start Date\" set autocomplete=\"off\" size=\"30\" style=\"width:200px;\">";
				td3.innerHTML = strHtml3.replace(/!count1!/g,count1);

				var td4 = document.createElement("TD")
				var id4="\"colRem"+count1+"\"";
				var strHtml4 = "<input type=\"text\" name=\"enddate\" class=\"form-control datepicker\"  id=\"enddate"+rowCount+"\" placeholder=\"Actaul End Date\" size=\"30\"onblur=\"dateCompare('"+rowCount+"')\" set autocomplete=\"off\" style=\"width:200px;\">";
				td4.innerHTML = strHtml4.replace(/!count1!/g,count1);

				var td5 = document.createElement("TD")
				var id5="\"colRem"+count1+"\"";
				var strHtml5 = "<input type=\"text\" name=\"totaltime\" readonly class=\"form-control totalTime\"  maxlength=\"100\" id=\"totaltime"+rowCount+"\" placeholder=\"Total Time\" size=\"30\" onchange=\"disableDates('"+rowCount+"')\" style=\"width:200px;\" >";
				td5.innerHTML = strHtml5.replace(/!count1!/g,count1);


				var td6 = document.createElement("TD")
				var id6="\"colRem"+count1+"\"";
				var strHtml6 = "<input type=\"text\"  name=\"remark\" class=\"form-control\"  id=\"remark"+rowCount+"\" placeholder=\"Remarks\" size=\"30\" style=\"width:400px\"  >";
				td6.innerHTML = strHtml6.replace(/!count1!/g,count1);
				var td7 = document.createElement("TD")
			   	var id7="\"colRem"+count1+"\"";
			   	var strHtml7 = "<input type=\"checkbox\"  name=\"workStatus\"  id=\"workStatus"+rowCount+"\">";
			   	td7.innerHTML = strHtml7.replace(/!count1!/g,count1);

						   
				row.appendChild(td3);
				row.appendChild(td4);
				row.appendChild(td5);
				row.appendChild(td6);
				row.appendChild(td7);
				
			 	document.getElementById("timeSheetTable").style.display="block";
				document.getElementById("adhocTable").style.display="none";
				table.style="width: 85%;";
			}
			else
			{
					var record=res.split("@");
					var myNode = document.getElementById("timeSheet");
					myNode.innerHTML = '';
					var date=new Date(getConvertDate('normal',''));
					var data=record[0].split("~");
				    document.getElementById("productId").value=data[0];
				    getCustomers('');
				    document.getElementById("customerId").value=data[1];
				    getWBSName('');
				    document.getElementById("wbsname").value=data[2];
				    document.getElementById("wbsname").disabled=true;
				    document.getElementById("customerId").disabled=true;
				    document.getElementById("productId").disabled=true;
	    			    document.getElementById("wbsid").value=data[3];
	                            document.getElementById("wbsid").disabled=true;
				    for(var num1=1;num1<record.length;num1++)
				    {
				    	var record1=record[num1].split("~");
				    	var table = document.getElementById("timeSheet");
			    		var tbody = document.getElementById("timeSheet").getElementsByTagName("TBODY")[0];
			    		var row = document.createElement("TR");
			    		var rowCount = table.rows.length;
			    		
			    		var row = table.insertRow(rowCount);
			    		var cell1 = row.insertCell(0);
			    		
				    	for(var num2=1;num2<record1.length;num2++)
				    	{
				    		var xyz = new Date(record1[5].substr(0,10));
				    		if(date - xyz === 0 || date-xyz<=432000000)
				    		{	
								if(num2==1)
								{
								var td2 = document.createElement("TD")
								var id2="\"colRem"+count1+"\"";
								var strHtml2 = "<select name=\"productlife\" class=\"form-control \" id=\"productlife"+rowCount+"\" style=\"width:250px;\" disabled=true></select>";
								td2.innerHTML = strHtml2.replace(/!count1!/g,count1);
								row.appendChild(td2);
								
								allproductselectData(rowCount, wbsselectData);

								var td3 = document.createElement("TD");
					    			var id3="\"colRem"+count1+"\"";
					    			var strHtml3 = "<input type=\"text\" name=\"startdate\" class=\"form-control datepicker \" maxlength=\"100\" id=\"startdate"+rowCount+"\" value=\""+getConvertDate('DDMMYYYY',record1[num2])+"\" placeholder=\"Actual Start Date\" size=\"30\" style=\"width:150px;\" set autocomplete=\"off\" disabled=true >";
					    			td3.innerHTML = strHtml3.replace(/!count1!/g,count1);
					    			row.appendChild(td3);

								}
								else if(num2==2)
								{
									var td4 = document.createElement("TD");
					    			var id4="\"colRem"+count1+"\"";
					    			var strHtml4 = "<input type=\"text\" name=\"enddate\" class=\"form-control datepicker\"  id=\"enddate"+rowCount+"\" value=\""+getConvertDate('DDMMYYYY',record1[num2])+"\"  placeholder=\"Actaul End Date\" size=\"30\"onblur=\"dateCompare('"+rowCount+"')\" style=\"width:150px;\" set autocomplete=\"off\" disabled=true >";
					    			td4.innerHTML = strHtml4.replace(/!count1!/g,count1);
					    			row.appendChild(td4);

									
								}
								else if(num2==3)
								{
									var td5 = document.createElement("TD");
					    			var id5="\"colRem"+count1+"\"";
					    			var strHtml5 = "<input type=\"text\" name=\"totaltime\" readonly class=\"form-control totalTime\"  maxlength=\"100\" id=\"totaltime"+rowCount+"\" value=\""+record1[num2]+"\" placeholder=\"Total Time\" size=\"30\" onchange=\"disableDates('"+rowCount+"')\" style=\"width:100px;\" disabled=true >";
					    			td5.innerHTML = strHtml5.replace(/!count1!/g,count1);
					    			row.appendChild(td5);


								}
								else if(num2==4)
								{
									var td6 = document.createElement("TD");
					    			var id6="\"colRem"+count1+"\"";
					    			var strHtml6 = "<input type=\"text\"   name=\"remark"+record1[6]+"\" class=\"form-control\"  id=\"remark"+rowCount+"\" value=\""+record1[num2]+"\" placeholder=\"Remarks\" size=\"30\" style=\"width:400px;\" disabled=true  >";
					    			td6.innerHTML = strHtml6.replace(/!count1!/g,count1);
					    			row.appendChild(td6);
					    			
								}
								/*else if(num2==5)
								{
									var td2 = document.createElement("TD")
									var id2="\"colRem"+count1+"\"";
									var strHtml2 = "<select name=\"productlife\" class=\"form-control \" id=\"productlife"+rowCount+"\"  style=\"width:200px;\"><option value=\"-1\">--Select--</option></select>";
									td2.innerHTML = strHtml2.replace(/!count1!/g,count1);
									row.appendChild(td2);
								}*/	
								else if(num2==6)
								{
									var td7 = document.createElement("TD");
									 var strHtml7 = "<input type=\"submit\"  id=\"Edit"+rowCount+"\" value=\"Edit\" class=\"buttonSave\" "+
										"onclick=\"setEditFlag('"+record1[num2]+"','"+rowCount+"')\" style=\"width:50px;\">";
									td7.innerHTML = strHtml7.replace(/!count1!/g,count1);
					    			row.appendChild(td7);
								}
								else if(num2==7)
								{
									document.getElementById("productlife"+rowCount).value=record1[num2];
									document.getElementById("productlife"+rowCount).disabled=true;
								}
								
				    		}
				    		else
				    		{
				    			/*if(num2==1)
								{
				    				var td3 = document.createElement("TD")
					    			var id3="\"colRem"+count1+"\"";
					    			var strHtml3 = "<input type=\"text\"  name=\"startdate\" class=\"form-control  \" maxlength=\"100\" id=\"startdate\" value=\""+getConvertDate('DDMMYYYY',record1[num2])+"\" placeholder=\"Actual Start Date\" size=\"30\" style=\"width:200px;\" disabled=true >";
					    			td3.innerHTML = strHtml3.replace(/!count1!/g,count1);
					    			row.appendChild(td3);

								}*/
									if(num2==1)
								{
								var td2 = document.createElement("TD")
								var id2="\"colRem"+count1+"\"";
								var strHtml2 = "<select name=\"productlife\" class=\"form-control \" id=\"productlife"+rowCount+"\" style=\"width:250px;\" disabled=true></select>";
								td2.innerHTML = strHtml2.replace(/!count1!/g,count1);
								row.appendChild(td2);
								
								allproductselectData(rowCount, wbsselectData);

								var td3 = document.createElement("TD");
					    			var id3="\"colRem"+count1+"\"";
					    			var strHtml3 = "<input type=\"text\" name=\"startdate\" class=\"form-control datepicker \" maxlength=\"100\" id=\"startdate"+rowCount+"\" value=\""+getConvertDate('DDMMYYYY',record1[num2])+"\" placeholder=\"Actual Start Date\" size=\"30\" set autocomplete=\"off\" style=\"width:150px;\" disabled=true >";
					    			td3.innerHTML = strHtml3.replace(/!count1!/g,count1);
					    			row.appendChild(td3);

								}
								else if(num2==2)
								{
									var td4 = document.createElement("TD")
					    			var id4="\"colRem"+count1+"\"";
					    			var strHtml4 = "<input type=\"text\" name=\"enddate\" class=\"form-control \"  id=\"enddate\" value=\""+getConvertDate('DDMMYYYY',record1[num2])+"\"  placeholder=\"Actaul End Date\" size=\"30\"  style=\"width:200px;\" set autocomplete=\"off\" disabled=true >";
					    			td4.innerHTML = strHtml4.replace(/!count1!/g,count1);
					    			row.appendChild(td4);

									
								}
								else if(num2==3)
								{
									var td5 = document.createElement("TD")
					    			var id5="\"colRem"+count1+"\"";
					    			var strHtml5 = "<input type=\"text\" readonly name=\"totaltime\" class=\"form-control\"  maxlength=\"100\" id=\"totaltime\" value=\""+record1[num2]+"\" placeholder=\"Total Time\" size=\"30\" style=\"width:200px;\" disabled=true >";
					    			td5.innerHTML = strHtml5.replace(/!count1!/g,count1);
					    			row.appendChild(td5);
								}
								else if(num2==4)
								{
									var td6 = document.createElement("TD")
					    			var id6="\"colRem"+count1+"\"";
					    			var strHtml6 = "<input type=\"text\"  name=\"remark\" class=\"form-control\"  id=\"remark\" value=\""+record1[num2]+"\" placeholder=\"Remarks\" style=\"width:400px;\" size=\"30\" disabled=true  >";
					    			td6.innerHTML = strHtml6.replace(/!count1!/g,count1);
					    			row.appendChild(td6);
					    			
								}
								else if(num2==7)
								{
									document.getElementById("productlife"+rowCount).value=record1[num2];
									document.getElementById("productlife"+rowCount).disabled=true;
								}
				    		}
				    	}
				      	document.getElementById("flag").value="E";
				    }
				 	document.getElementById("timeSheetTable").style.display="block";
					document.getElementById("adhocTable").style.display="none";
					table.style="width: 85%;";
			}
		  	adddatepicker('normal');
	    	disabledatepicker();
			
		}
	}
	function getConvertDate(id,date)
	{
		if(id=="normal")
		{
			var date=new Date();
		    var day = date.getDate();
		    var month =date.getMonth() + 1;
		    var year = date.getFullYear();
		    if(day<10) {
		    	day='0'+day
		    } 
		
		    if(month<10) {
		    	month='0'+month
		    } 
		   var date1= year+ "/" + month + "/" + day;
		   
		}
		else if(id=="DDMMYYYY")
		{
			if(date!='0')
			{
				temp=date.split(" ");
				
				tempdate=temp[0].split('/');
		    	var date1= tempdate[2]+ "/" + tempdate[1] + "/" + tempdate[0]+" "+temp[1];
			}
			else
			{
				var date1=date;
			}
		}
		else if(id=="DD/MM/YYYY")
		{
			var date=new Date();
		    var day = date.getDate();
		    var month =date.getMonth() + 1;
		    var year = date.getFullYear();
		    if(day<10) {
		    	day='0'+day
		    } 
		
		    if(month<10) {
		    	month='0'+month
		    } 
		   var date1= day+ "/" + month + "/" + year;
			
		}
		
		return date1;
	}

	function saveTimeSheet()
	{
		debugger;
		var id=document.getElementById("commonId").value;
		var flag=document.getElementById("flag").value;
		var table = document.getElementById("timeSheet");
		var tbody = document.getElementById("timeSheet").getElementsByTagName("TBODY")[0];
		var row = document.createElement("TR");
		var rowCount = table.rows.length;
		var workStaus="";
		var product=document.getElementById("productId").value;
	 	var customer=document.getElementById("customerId").value;
	 	var wbs=document.getElementById("wbsname").value;
	 	var date=new Date();
		var dd = date.getDate();
		var mm = date.getMonth()+1; //January is 0!
		var yyyy = date.getFullYear();
		if(dd<10){
		    dd='0'+dd;
		} 
		if(mm<10){
		    mm='0'+mm;
		} 
		var today = mm+'/'+dd+'/'+yyyy;
		var hrs=date.getHours();
		var min=date.getMinutes();
		if(hrs<=9)
			hrs="0"+hrs;
		if(min<=9)
			min="0"+min;
		var ampm=(date.getHours() >= 12) ? "" : "AM";
		var minTime=hrs+":"+min+" "+ampm;
		var date=new Date(today+" "+minTime);
		if(flag=='N' || flag=='E')
		{
			var editid="";
			if(product==" "){
			   alert("Select Product");
			   document.getElementById("productId").focus();
			   return false;
			}
			  else if(customer==" "){
			   alert("Select Customer");
			   document.getElementById("customerId").focus();
			   return false;
			}
			  else if(wbs==" "){
			   alert("Select WBS Name");
			   document.getElementById("wbsname").focus();
			   return false;
			}
			for(var i=0;i<rowCount;i++)
			{
				var productlife=document.getElementById("productlife"+i);
				var startDate=document.getElementById("startdate"+i);
				var endDate=document.getElementById("enddate"+i);
				var remark=document.getElementById("remark"+i);
				if(startDate==null || endDate==null || remark==null){
					continue;
				}
				if(startDate.value=="" || endDate.value=="" ||
						document.getElementById("totaltime"+i).value==""  || remark.value.trim()=="" || document.getElementById("productlife"+i).value =="" )
				{
					alert("InComplete  Entries !!");
					return false;
				}
				if((document.getElementById("Edit"+i)==null || document.getElementById("Edit"+i).disabled==false)
						&& startDate.disabled==false && endDate.disabled==false){
					var splitStartDate = startDate.value.split(' ');
					var splitEndDate = endDate.value.split(' ');

					var startDateArray = splitStartDate[0].split('/');
					var endDateArray = splitEndDate[0].split('/');
					var sd=startDateArray[2] + '/' + startDateArray[1] + '/' + startDateArray[0];
					var ed=endDateArray[2] + '/' + endDateArray[1] + '/' + endDateArray[0];
					
					var startDateTime = new Date(startDateArray[2] + '/' + startDateArray[1] + '/' + startDateArray[0] + ' ' + splitStartDate[1]);
					var endDateTime = new Date(endDateArray[2] + '/' + endDateArray[1] + '/' + endDateArray[0] + ' ' + splitEndDate[1]);
					/*if(startDateTime < date && startDateTime!=date){
						alert("Start Date must be greater than current date-time");
						document.getElementById("startdate"+i).value="";
						document.getElementById("startdate"+i).focus();
						return false;
					}if(endDateTime < date && endDateTime!=date){
						alert("End Date must be greater than current date-time");
						//document.getElementById("enddate"+i).value="";
						document.getElementById("enddate"+i).focus();
						return false;
					}*/
					for(var j=i;j<rowCount;j++){
						if(i!=j && document.getElementById("startdate"+j)!=null &&  document.getElementById("enddate"+j)!=null){
							var stdate=document.getElementById("startdate"+j).value;
							var endate=document.getElementById("enddate"+j).value;
							var s=stdate.split(' ');
							var e=endate.split(' ');
							var s1=s[0].split('/');
							var e1=e[0].split('/');
							var s2= new Date(s1[2] + '/' + s1[1] + '/' + s1[0] + ' ' + s[1]);
							var e2 = new Date(e1[2] + '/' + e1[1] + '/' + e1[0] + ' ' + e[1]);
							var sd1=s1[2] + '/' + s1[1] + '/' + s1[0];
							var ed1=e1[2] + '/' + e1[1] + '/' + e1[0];
							if(sd1==sd && stdate==startDate.value){
								alert("Start date and time  not equal to other records");
								document.getElementById("startdate"+j).value="";
								document.getElementById("startdate"+j).focus();
								return false;
							}
							if(ed1==ed && s2<=endDateTime){
								alert("Start date and time  must be greater than to date and time of other records");
								document.getElementById("startdate"+j).value="";
								document.getElementById("enddate"+j).value="";
								document.getElementById("startdate"+j).focus();
								return false;
							}
							if(endate==endDate.value){
								alert("End date not equal to other records");
								document.getElementById("enddate"+j).value="";
								document.getElementById("startdate"+j).value="";
								document.getElementById("startdate"+j).focus();
								return false;
							}
						}
					}
				}else if(flag=="E" && editid==""){
					 editid=document.getElementById("editid").value;
					   
				}
				if(workStaus=="" && document.getElementById("workStatus"+i)!=null && document.getElementById("workStatus"+i).checked==true)
					workStaus="C";
		  	}
	  		document.newForm.action="saveTimeSheet.action?id="+id+"&flag="+flag+"&workStatus="+workStaus+
	  		"&productId="+product+"&customerId="+customer+"&wbsname="+wbs+"&editId="+editid;
	  		//console.log(document.newForm.action)
			document.newForm.method="POST";
	  		document.newForm.submit();
		}
		else if(flag=='E')
		{
			var count=0;
			if(product==" "){
			   alert("Select Product");
			   document.getElementById("productId").focus();
			   return false;
			  }
			  else if(customer==" "){
			   alert("Select Customer");
			   document.getElementById("customerId").focus();
			   return false;
			  }
			  else if(wbs==" "){
			   alert("Select WBS Name");
			   document.getElementById("wbsname").focus();
			   return false;
			  }
			for(var i=0;i<rowCount;i++)
			{
				if(document.getElementById("startdate"+i)!=null && document.getElementById("enddate"+i)!=null && document.getElementById("totaltime"+i)!=null) 
				{
					if(document.getElementById("startdate"+i).disabled==false && document.getElementById("enddate"+i).disabled == false && document.getElementById("totaltime"+i).disabled ==false)
					{							
						if(document.getElementById("startdate"+i).value=="" || document.getElementById("enddate"+i).value=="" || document.getElementById("totaltime"+i).value=="" )
						{
							alert("InComplete Entries !!");
							return;
						}
						else
						{
						
					    if(document.getElementById("workStatus"+i).checked==true)
					       	workStaus="C";
					    else
					     	workStaus="";
	      
					    count=0;
					    var editid=document.getElementById("editid").value;
					    document.newForm.action="saveTimeSheet.action?id="+id+"&flag="+flag+"&editId="+editid+"&workStatus="+workStaus+"&productId="+product+"&customerId="+customer+"&wbsname="+wbs+"";;
	 					document.newForm.method="POST";
						document.newForm.submit();
						}
					}
					else
					{
						count=count+1;
					}
					
				}
				else
				{
					count=count+1;
				}
			}	
			if(count==rowCount)
			{
					alert("No Record For Save...!! Please Enter Data ");
			}
		}
		 else if(flag=='adHocTM')
		 {
			 for(var i=0;i<rowCount;i++)
			 {
				 var product=document.getElementById("productId"+i);
				 var customer=document.getElementById("customerId"+i);
				 var remark=document.getElementById("remark"+i).value;
				 var wbs=document.getElementById("wbsname"+i);
				 if(product!=null && product.value==" "){
					 alert("Select Product");
					 document.getElementById("productId").focus();
					 return false;
				 }
				 else if(customer!=null && customer.value==" "){
					 alert("Select Customer");
					 document.getElementById("customerId").focus();
					 return false;
				 }
				 else if(wbs!=null && wbs.value==" "){
					 alert("Select WBS Name");
					 document.getElementById("wbsname").focus();
					 return false;
				 }
				 if((document.getElementById("startdate"+i)!=null && document.getElementById("startdate"+i).value=="") || 
						 (document.getElementById("enddate"+i)!=null && document.getElementById("enddate"+i).value=="") ||
						 (document.getElementById("totaltime"+i)!=null && document.getElementById("totaltime"+i).value=="" ))
				 {
					 alert("InComplete Entries !!");
					 return;
				 }
				 if(document.getElementById("startdate"+i)!=null && document.getElementById("enddate"+i)!=null)
				 {
					 var startDate=document.getElementById("startdate"+i).value;
					 var endDate=document.getElementById("enddate"+i).value;
					 var splitStartDate = startDate.split(' ');
					 var splitEndDate = endDate.split(' ');

					 var startDateArray = splitStartDate[0].split('/');
					 var endDateArray = splitEndDate[0].split('/');

					 var sd=startDateArray[2] + '/' + startDateArray[1] + '/' + startDateArray[0];
					 var ed=endDateArray[2] + '/' + endDateArray[1] + '/' + endDateArray[0];

					 var startDateTime = new Date(startDateArray[2] + '/' + startDateArray[1] + '/' + startDateArray[0] + ' ' + splitStartDate[1]);
					 var endDateTime = new Date(endDateArray[2] + '/' + endDateArray[1] + '/' + endDateArray[0] + ' ' + splitEndDate[1]);

					 for(var j=i;j<rowCount;j++){
						 if(i!=j && document.getElementById("startdate"+j)!=null &&  document.getElementById("enddate"+j)!=null){
							 var stdate=document.getElementById("startdate"+j).value;
							 var endate=document.getElementById("enddate"+j).value;
							 var s=stdate.split(' ');
							 var e=endate.split(' ');
							 var s1=s[0].split('/');
							 var e1=e[0].split('/');
							 var s2= new Date(s1[2] + '/' + s1[1] + '/' + s1[0] + ' ' + s[1]);
							 var e2 = new Date(e1[2] + '/' + e1[1] + '/' + e1[0] + ' ' + e[1]);
							 var sd1=s1[2] + '/' + s1[1] + '/' + s1[0];
							 var ed1=e1[2] + '/' + e1[1] + '/' + e1[0];
							 if(sd1==sd && stdate==startDate){
								 alert("Start date and time  not equal to other records");
								 document.getElementById("startdate"+j).value="";
								 document.getElementById("startdate"+j).focus();
								 return false;
							 }
							 if(ed1==ed && s2<endDateTime){
								 alert("Start date and time  must be greater than to date and time of other records");
								 document.getElementById("startdate"+j).value="";
								 document.getElementById("startdate"+j).focus();
								 return false;
							 }
							 if(endate==endDate){
								 alert("End date not equal to other records");
								 document.getElementById("enddate"+j).value="";
								 document.getElementById("startdate"+j).value="";
								 document.getElementById("startdate"+j).focus();
								 return false;
							 }
						 }
					 }
				 }
				 if(remark.trim()==""){
					 alert("Remark cannot be blank");
					 document.getElementById("remark"+i).focus();
					 return false;
				 }
			 }
			 document.newForm.action="saveTimeSheet.action?id="+id+"&flag="+flag; 
			 document.newForm.method="POST";
			 document.newForm.submit();
		 }
	}
	function closeTimeSheet()
	{
		var myNode = document.getElementById("timeSheet");
		myNode.innerHTML = '';
	  	document.getElementById("flag").value=" ";
	  	document.getElementById("editid").value="";
	  	document.getElementById("commonId").value="";

	}
	//for show All Ad-Hoc Records 
	function viewAdHocTimeSheet()
	{
		var emp_id=document.getElementById("ResourceSelect").value;
		if(emp_id!=" ")
		{
			var url="fetchAdhocData.action?id="+emp_id;
			xhr = createAjax();
			xhr.open('POST',url,false);
			xhr.onreadystatechange=fetchAdhocData ;
			xhr.send();
		}
	}
	function fetchAdhocData()
	{
		if (xhr.readyState==4 && xhr.status==200)
	 	 {
			var res=xhr.responseText;
			
			if(res=="")
			{
				$('#viewAdHocTabTableDiv').html('No Record Found');
			}
			else
			{
				var data=res.split('@');
				$('#viewAdHocTabTableDiv').html('<table id=\"viewAdHocTab\" style=\"width: 100%;\" class=\"responstable display nowrap dataTable IdataTable dtr-inline\" role=\"grid\"  border=\"1\">'
					     +'<thead class=\"headerRow\">'
					     +'<tr align=\"center\" height=\"40px\">'
					     +'<th align=\"center\" style=\" width:10%;\">Product</th>'
					     +'<th align=\"center\" style=\" width:10%;\">Customer</th>'
					     +'<th align=\"center\" style=\" width:10%;\">WBS Name</th>'
					     +'<th align=\"center\" style=\" width:10%;\">Start Date</th>'
					     +'<th align=\"center\" style=\" width:10%;\">End Date</th>'
					     +'<th align=\"center\" style=\" width:10%\">Total Time</th>'
					     +'<th align=\"center\" style=\" width:40%;\">Remarks</th></tr></thead>'
					     + '<tbody id=\"viewwbs\"></tbody></table>');
				var table = document.getElementById("viewAdHocTab");
			    var tbody = document.getElementById("viewAdHocTab").getElementsByTagName("TBODY")[0];
			    for(var i=1;i<data.length;i++)
				{
					var data1=data[i].split("~");
					var row = document.createElement("TR");
					var rowCount = tbody.rows.length;
					var row = tbody.insertRow(rowCount);
					row.className="tableRow";
					for(var j=0;j<data1.length;j++){
						if(j==0)
					
					     {
					      var td1 = document.createElement("TD")
					      td1.innerHTML = data1[j];
					      td1.style.width='10%';
						  td1.height='10px';
					      td1.align='center';
					      row.appendChild(td1);
					     }
					     else if(j==1)
					     {
					      var td1 = document.createElement("TD")
					      td1.innerHTML = data1[j];
					      td1.style.width='10%';
					      td1.height='10px';
					      td1.align='center';
					      row.appendChild(td1);
					     }
					     else if(j==2)
					     {
					      var td1 = document.createElement("TD")
					      td1.innerHTML = data1[j];
					      td1.style.width='10%';
					      td1.height='10px';
					      td1.align='center';
					      row.appendChild(td1);
					     }
					     else if(j==3)
					     {
					      var td1 = document.createElement("TD")
					      td1.innerHTML = data1[j];
					      td1.style.width='10%';
					      td1.height='10px';
					      td1.align='center';
					      row.appendChild(td1);
					     }
					     else if(j==4)
					     {
					      var td1 = document.createElement("TD")
					      td1.innerHTML = data1[j];
					      td1.style.width='10%';
					      td1.align='center';
					      row.appendChild(td1);
					     }
					     else if(j==5)
					     {
					      var td1 = document.createElement("TD")
					      td1.innerHTML = data1[j];
					      td1.style.width='10%';
					      td1.align='center';
					      row.appendChild(td1);
					     }
					     else if(j==6)
					     {
					      var td1 = document.createElement("TD")
					      var strHtml1 ="<textarea rows=\"2\" class=\"form-control noResize\" cols=\"90\" readonly>"+data1[j]+"</textarea>";
					      td1.innerHTML = strHtml1;
					      td1.style.width='40%';
					      row.appendChild(td1);
					     }
					  }
	     		}
			}
		}
		pageination1();
	}
	//for Ad-Hoc Records Pagination 	
	function pageination1() 
	{
			var table = $("#viewAdHocTab").dataTable({
				"bProcessing": false,
		        "bServerSide": false,
		        "sort": "position",
		        "sPaginationType": "full_numbers",
		        "lengthMenu": [5, 10, 20, 50, 100],
		        "pageLength": 5,
		        "responsive": true,
			} ); 
		new $.fn.dataTable.FixedHeader( table, {
	        top: false,
	    } );
	}

	/*Auth WBS JSP METHODS*/

	//for check all Check Box
	function checkAll(size)
	{
		var i = size;
		var text = (document.getElementById("SelectAll").value);
		if(text == "Select all")
		{
			$(".ckeckbox").attr("checked",true);
			$(".ckeckbox").trigger("click");
			document.getElementById("SelectAll").value = 'deSelect all' ;
				
		}
		else
		{
			$(".ckeckbox").attr("checked",false);
			$(".ckeckbox").trigger("click");
			document.getElementById("SelectAll").value = 'Select all' ;
		}
		$(".checkbox").trigger("click");
	}


	//Save Auth Jsp
	function saveAuthData(mode,size)
	{
				document.getElementById("auth").disabled=true;
				document.getElementById("cancel").disabled=true;
				var id = $("#selectId").val();
				/*var check = 0;
				var inc = 0;
				var i = size;
				document.getElementById("selectId").value ="";*/
				/*for(var chk = 0; chk<i; chk++)
				{
					if(document.getElementById("chk"+chk)!=null && document.getElementById("chk"+chk).checked)
	    			{
						check++;
					}
				}

				for(var l=0;l<i;l++)
				{
					if(document.getElementById("chk"+l)!=null && document.getElementById("chk"+l).checked)
	    			{
						var pbkid = document.getElementById("chk"+l).value;
						if(inc == check-1)
							id += pbkid;
						else
							id += pbkid+",";				
						inc++;

					}
				}
				*/
				if(id == "")
				{
					message="notSelected";
					showMessageDiv(message);
					return;
				}
				else
				{    
					/*if(mode=='auth')
					{
						var a=confirm("Are You Sure To Authorize Record..!!");
						if(a)
						{
							document.form.action="AuthWBSScreen.action?authFlag=auth&id="+id;
							document.form.submit();
						}
					}
					else
					{
						var a=confirm("Are You Sure To Reject the Records..!!");
						if(a)
						{
								document.form.action="AuthWBSScreen.action?authFlag=delete&id="+id;
								document.form.submit();
						}
					}
					 */
					var productId=document.getElementById("productId").value;
					var customerId=document.getElementById("customerId").value;
					var wbsnameid=document.getElementById("wbsname").value;
					var projectPhaseId=document.getElementById("project_phase").value;
					var url="";
					if(mode=='auth')
					{
						url="AuthWBSScreen.action?authFlag=auth&id="+id;//var a=confirm("Are You Sure To Authorize Record..!!");
						/*if(a)
						{
							//document.form.action="AuthWBSScreen.action?authFlag=auth&id="+id+"&productId="+productId+"&customerId="+customerId+"&wbsnameId="+wbsnameid+"&projectPhaseId="+projectPhaseId;
							//document.form.submit();
							url="AuthWBSScreen.action?authFlag=auth&id="+id;
						}*/
					}
					else
					{
						var a=confirm("Are You Sure To Reject the Records..!!");
						if(a)
						{
							//	document.form.action="AuthWBSScreen.action?authFlag=delete&id="+id+"&productId="+productId+"&customerId="+customerId+"&wbsnameId="+wbsnameid+"&projectPhaseId="+projectPhaseId;;
							//	document.form.submit();
							url="AuthWBSScreen.action?authFlag=delete&id="+id;
						}
					}
					xhr = createAjax();
					xhr.open('POST',url,false);
					xhr.onreadystatechange=function(){
						if(xhr.readyState==4 && xhr.status==200){
							var res=xhr.responseText;
							res=JSON.parse(res);
							if(res.message=="success"){
								window.location.href="ShowAuthWBSScreen.action?productId="+productId+"&customerId="+customerId+"&wbsnameId="+wbsnameid+"&projectPhaseId="+projectPhaseId;
							}else{
								alert(res.errorMessage);
								window.location.reload();
							}
						}
					};
					xhr.send();

				}	
	}

	//Save WORK ASSIGN JSP
	function saveWorkAssignData(size)
	{
		var id = "";
		var check = 0;
		var inc = 0;
		var i = size;
		
		for(var chk = 0; chk<i; chk++)
				{
					if(document.getElementById("chk"+chk).checked)
					{
						check++;
					}
				}
				for(var l=0;l<i;l++)
				{
					if(document.getElementById("chk"+l).checked)
					{
						var pbkid = document.getElementById("chk"+l).value;
				
		/*				if(document.getElementById("resourceId"+pbkid).value=="-1")
						{
								alert("Please Select Resource Name First");
								return false;
					   	
						}
		*/	if(document.getElementById("resourceId"+pbkid).value=="-1")
		{
			alert("Please Select Resource Name First");
			document.getElementById("resourceId"+pbkid).focus();
			return false;

		}			
			if(document.getElementById("wbs_complexity"+pbkid)!=null && document.getElementById("wbs_complexity"+pbkid).value=="-1")
						{
								alert("Please Select Complexity");
								return false;
					   	
						}
						if(document.getElementById("wbs_PlanManDays"+pbkid)!=null && document.getElementById("wbs_PlanManDays"+pbkid).value=="")
						{
								alert("Please enter mandays");
								return false;
					   	
						}
						/*var value=document.getElementById("multiplefactor"+pbkid).value;
						if(+value<=0 || +value>1 )
						{
							alert("Multiple Factor is not in Range..! Value Must be between 0.1 To 1");
							document.getElementById("multiplefactor"+pbkid).value='1';
							return false;
						}*/
						var releaseDate=document.getElementById("releaseDate"+pbkid).value;
					    if(releaseDate=="")
					    {
					      alert("Please select Release Date");
					      return false;
					    }
					    else
					    {
					    var toDate= document.getElementById("toDate"+pbkid).value;
					      var f=checkReleaseDate(toDate,releaseDate);
					      if(f==false)
					       return false;
					    }
					    var portDate=document.getElementById("portDate"+pbkid).value;
					    if(portDate=="")
					    {
					      alert("Please select Port Date");
					      return false;
					    }
						if(inc == check-1)
							id += pbkid;
						else
							id += pbkid+",";				
						inc++;

					}
				}
				
				if(id == "")
				{
					alert("No row is Selected");
					return;
				}
				else
				{    
						var a=confirm("Are You Sure To Assign Work..!!");
						if(a)
						{	
							document.getElementById("save").disabled=true;
							document.getElementById("cancel").disabled=true;
							$("#assignId").val(id);
							var resourceID=document.getElementById("resourceId").value;
							document.forms[0].action="saveWorkAssign.action?id="+id+"&resourceId="+resourceID;
//							document.forms[0].action="saveWorkAssign.action?id="+id+"&resourceId="+document.getElementById("resourceId").value;
							document.forms[0].submit();
						}
				}	
	}

	function adddatepicker1(){
		$(".datepicker1").datepicker({
			  changeMonth: true,
			  dateFormat: "dd/mm/yy",
		      changeYear: true,
		 });
	}	
	function editschedule(id)
	{
		
		var editid=document.getElementById("editid").value;
		
		editid += id+",";
		document.getElementById("editid").value=editid;
		document.getElementById("resourceId"+id).disabled=false;
		document.getElementById("fromDate"+id).disabled=false;
		document.getElementById("toDate"+id).disabled=false;
		adddatepicker1();
	}
	function saveReSchduleJsp()
	{
		var editid=document.getElementById("editid").value;
		alert(editid);
		if(editid!= "")
		{
			document.newForm.action="saveReschedule.action?editId="+editid+"";	
			document.newForm.method="POST";
			document.newForm.submit();
		}
		
	}
	function filterRecord()
	{ 	
		var emp_kid=document.getElementById("emp_kid").value;
		if(emp_kid=="-1")
		{
			alert("Select Resource Name");		
			return false;
		}
		document.newForm.action="wbsReschedule.action";	
		document.newForm.method="POST";
		document.newForm.submit();
	}

	function generateReport()
	{
		var dd=document.form.workDate.value;
		var currentDate = new Date();
		var pareseDate= Date.parse(dd);
		if(pareseDate > currentDate)
		  {
		     alert('Date should be less than current Date');
		     document.getElementById('workDate').value=null;
		     return false;
		  }
		
		if(dd ==null || dd == "")
			{
			alert("please select Report Date");
			return false;
			}
		else
			{
			document.form.action="WBSDailyReport.action";	
			document.form.method="POST";
			document.form.submit();
			}
			}	
			
	function checkReleaseDate(toDate,releaseDate)
	{
		var d=toDate.substring(0,2);
		var m=toDate.substring(3,5);
		var y=toDate.substring(6,10);
		var d1=releaseDate.substring(0,2);
		var m1=releaseDate.substring(3,5);
		var y1=releaseDate.substring(6,10);
		if((m==1)||(m==3)||(m==5)||(m==7)||(m==8)||(m==10)||(m==12))
		{
			d=d*1;
			if(d>24)
			{
				m++;
				d=((d+7)-31);
			}
			else
				d=d+7;
			if(m==12)
			{
				m=1;
				y++;
			}
			
		}
		else if((m==4)||(m==6)||(m==9)||(m==11))
		{
			d=d*1;
			if(d>23)
			{
				m++;
				d=d+7-30;
			}
			else
				d=d+7;
			
		}
		else if(m==2)
		{
			d=d*1;
			if(((y % 400) == 0) || ((y % 4) == 0) && ((y % 100) == 0))
			{
				if(d>22)
				{
					m++;
					d=d+7-29;
				}
			}else if(d>21)
			{
				m++;
				d=d+7-28;
			}
			else
				d=d+7;
			
		}
		var cd=d+"/"+m+"/"+y;
		d1=d1*1;m1=m1*1;y1=y1*1;
		//alert(cd+"    "+releaseDate);
		/*
		if((releaseDate==cd)||((d1>=d)&&(m1>=m)&&(y1>=y))|| ((d>=d1) && (m1>=m) && (y1>=y)))
			return true;
		else
		{
			alert("Release date must be more than 7 days from completion date");
			return false;
		}
		*/
	}
	function getCustomers(rCnt){

		var pid=document.getElementById("productId"+rCnt).value;
		var url="getSelectedCustomer?productId="+pid;

		xhr = createAjax();
		xhr.open('POST',url,false);
		xhr.onreadystatechange=function(){setCustomers(rCnt);} ;
		xhr.send();
	}

	function setCustomers(cnt){
debugger;
		if(xhr.readyState==4 && xhr.status==200){
			var res=xhr.responseText;
			if(document.getElementById("customerId"+cnt)!=null){
				document.getElementById("customerId"+cnt).innerHTML="";
				document.getElementById("customerId"+cnt).options[0]= new Option("---select---"," ");
			}
			if (document.getElementById("module"+cnt) != null) {
				document.getElementById("module"+cnt).innerHTML="";
				document.getElementById("module"+cnt).options[0]= new Option("---select---"," ");
			}
			if(document.getElementById("wbsname"+cnt)!=null)
				document.getElementById("wbsname"+cnt).innerHTML="";
			if(res !="")
			{
				var data=res.split("@");
				var customer=data[0].split("~");
				var module=data[1].split("~");
				var j=1;
				if( document.getElementById("customerId"+cnt)!=null){
					for(var i=1;i<customer.length;i=i+2)
					{
						document.getElementById("customerId"+cnt).options[j]= new Option(customer[i+1],customer[i]);
						j++;
					}
				}
				var j=1;
				if(document.getElementById("module"+cnt)!=null){
					var j=1;
					for(var i=1;i<module.length;i=i+2)
					{
						document.getElementById("module"+cnt).options[j]= new Option(module[i+1],module[i]);
						j++;
					}
				}
			}
		}
	}

	function getWBSName(rCnt){
		var pid=document.getElementById("productId"+rCnt).value;
		var cid=document.getElementById("customerId"+rCnt).value;
		var url="getSelectedWBSName?customerId="+cid+"&productId="+pid;

		xhr = createAjax();
		xhr.open('POST',url,false);
		xhr.onreadystatechange=function(){setWBSName(rCnt);} ;
		xhr.send();
	}
	function setWBSName(cnt){
		if(xhr.readyState==4 && xhr.status==200){
			var res=xhr.responseText;
			document.getElementById("wbsname"+cnt).innerHTML="";
			document.getElementById("wbsname"+cnt).options[0]= new Option("---select---"," ");
			if(res !="")
			{
				var wbs=res.split("~");
				var j=1;

				for(var i=1;i<wbs.length;i=i+2)
				{
					document.getElementById("wbsname"+cnt).options[j]= new Option(wbs[i+1],wbs[i]);
					j++;
				}
			}
		}
	}

	function showPointDesc(reqFrom){
		var pointId=document.getElementById("pointNo").value;
		if(pointId==""){
			alert("Enter point Id");
			document.getElementById("headertable").innerHTML="";

			return false;
		}
		var url="getPortStatus.action?pointId="+pointId+"&reqFrom="+reqFrom;
		xhr=createAjax();
		xhr.open('POST',url,false);
		xhr.onreadystatechange=function(){setPointDesc(pointId,reqFrom);} ;
		xhr.send();
	}
	function setPointDesc(pointId,reqFrom){
		if(xhr.readyState==4 && xhr.status==200){
			var res=xhr.responseText;
			if(res=="~1"){
				alert("Status Already Updated as Success");
				document.getElementById("headertableBody").innerHTML="";
				document.getElementById("pointNo").value="";
				return false;
			}
			else
				if(res !="")
				{
					var status="Release Status";
					var date="Release Date";
					var statusFld="releaseStatus";
					var dateFld="releaseDate";
					if(reqFrom=="PortStatus")
					{
						status="Porting Status";
						date="Porting Date";
						statusFld="portStatus";
						dateFld="portDate";
					}
					var arrData=res.split("||");
					if(arrData[0]!=""){
						alert(arrData[0]);
						if(arrData[1]==""){
							document.getElementById("headertableBody").innerHTML="";
							document.getElementById("pointNo").value="";
							return;
						}else{
							arrData=arrData[1].split("$$");
						}
					}else{
						arrData=arrData[1].split("$$");
					}
					var data="";
					var tabData="";
					var status=[];
					var portDt=[];
					for(var i=0;i<arrData.length-1;i++){
						data=arrData[i].split("~");

						tabData+="<tr align='center'>"+
						"<td>"+
						data[1]+
						"</td>"+
						"</td>"+"<td align='center'>"+
						data[5]+
						"</td>"+
						"<td align='center'><span style=\"max-width:140px\"" +
						" class=\"wordWrap\" title=\""+data[4]+"\">"+
						data[4]+"</span>"+
						"</td>"+"<td align='center''>"+
						data[6]+
						"</td>"+
						"<td align='center'>"+
						data[7]+
						"</td>"+
						"<td align='center'>"+
						data[8]+"<input type='hidden'  id='hiddenDate"+i+"' value='"+data[11]+"' />"+
						"</td>"+
						"<td align='center'>"+
						"<input type=\"text\" id=\""+dateFld+i+"\"     " +
								"  readonly  name=\""+dateFld+"\"     " +
								" class=\"datepicker dateControl "+dateFld+"\"   required=\"true\"  />"+
						"</td>"+
						"<td align='center'>"+
						"<select id=\""+statusFld+i+"\" name=\""+statusFld+"\" class=\"form-control\" value=\""+data[2]+"\" />"
						+"<option value=\"-1\">--Select--</option>"+
						"<option value=\"Y\">Yes</option>"+
						"<option value=\"N\">No</option>" +
						"<option value=\"X\">Not Applicable</option>";
						tabData+="</select><input type='hidden' id='wbsid"+i+"' value='"+data[10]+"'/>"+
						
						"</td>"+"</tr>";
						status[i]=data[2];
						portDt[i]=data[3];
					}
					
					//document.getElementById("headertable").style.display="block";
					$("#headertable").show();
					document.getElementById("headertableBody").innerHTML=tabData;
					for(var i=0;i<status.length;i++){
						document.getElementById(statusFld+i).value=status[i];
						addPort(portDt[i],dateFld+i);
					}
				}
				else{
					alert("No Data Found");
					document.getElementById("headertableBody").innerHTML="";
					//document.getElementById("updateButton").style.display="none";

					document.getElementById("pointNo").value="";
					return false;
				}
		}
	}
	function saveEffortEst(){
		var rowCount=document.getElementById("innertableid").rows.length;
		var step=0;
		var flag=false;
		var res="";
		var id="";
		for(step=0;step<rowCount;step++)
		{
			if(document.getElementById("chk"+step).checked==true)
			{
				flag=true;
				id=document.getElementById("dataid"+step).value;
				var cmp=document.getElementById("comp"+id).value;
				var days=document.getElementById("days"+id).value;
				if(cmp=="")
				{
					alert("Please select complexity");
					return false;
				}
				else if(days=="")
				{
					alert("Enter no of plan days");
					return false;
				}
				else
				{
					res+=id+"@"+cmp+"@"+days+"|";
				}

			}
		}
		if(flag==false)
		{
			alert("Select check box");
			return false;
		}
		var url="getAuthData?isSave=true&data="+res;
		xhr = createAjax();
		xhr.open('POST',url,false);
		xhr.onreadystatechange=function(){
			var r=xhr.responseText;
			if(r=="1")
			{
				alert("Entries updated successfully");

			}
			else
			{
				alert("Enteries not updated successfiully");
			}
			window.location.href="";
		} ;
		xhr.send();
	}
	function getWbsPlanDate(toDate,days){
	debugger;
		var days1=days;

		//alert(days1);
		if(days1 < 4)
			days1=0;
		else{
			days1=(parseInt(days)/8);
			days1=Math.round(days1);
		}
		//alert(toDate.getDays());
		//const weekday = ["Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"];
		//const d = new Date();
		//let day = weekday[d.getDay()];
		//var daysval=
		//if(toDate.getDays()=="")
		var d=toDate.substring(0,2);
		var m=toDate.substring(3,5);
		var y=toDate.substring(6,10);
		
		
		if((m==1)||(m==3)||(m==5)||(m==7)||(m==8)||(m==10)||(m==12))
		{
			d=d*1;
			d=d+days1;
			if(d>31)
			{
				m++;
				d=(d-31);
			}
			if(m>12)
			{
				m=1;
				y++;
			}

		}
		else if((m==4)||(m==6)||(m==9)||(m==11))
		{
			d=d*1;
			d=d+days1;
			if(d>30)
			{
				m++;
				d=d-30;
			}
		}
		else if(m==2)
		{
			d=d*1;
			d=d+days1;
			if(((y % 400) == 0) || ((y % 4) == 0) && ((y % 100) != 0))
			{
				if(d>29)
				{
					m++;
					d=d-29;
				}
			}else if(d>28)
			{
				m++;
				d=d-28;
			}

		}
		if(d.length!=2 && d<=9)
			d="0"+d;
		if(m.length!=2 && m<=9)
			m="0"+m;
		var cd=d+"/"+m+"/"+y;
		return cd;
	} 

	 function DatePost(id)
	 {

			  var d1 = new Date(); 
			/*var dateval= d1.getDay(); 
		 	var dd = d1.getDate();
			var mm = d1.getMonth()+1; //January is 0!
			var yyyy = d1.getFullYear();
			if(dd<10){
			    dd='0'+dd;
			} 
			if(mm<10){
			    mm='0'+mm;
			} 
			var today = dd+'/'+mm+'/'+yyyy;
			if(dateval==6){
			 	today= getWbsPlanDate(today,16);
		 	}
		 	if(dateval==0)
		 	{
		 		today= getWbsPlanDate(today,8);
		 	}*/
			
			  var p=document.getElementById("portDate"+id).value;
			  var r=document.getElementById("releaseDate"+id).value;
			 var a=document.getElementById("fromDate"+id).value;
			var b=document.getElementById("toDate"+id).value;
			 d2 = new Date(a.substring(6,10)+"-"+a.substring(3,5)+"-"+a.substring(0,2)); 
			 var Dayf =d2.getDay();
			 d3 = new Date(b.substring(6,10)+"-"+b.substring(3,5)+"-"+b.substring(0,2)); 
			 var Dayt =d3.getDay();
		     var stdate= a;
		     var enddate= b;
		     var enddate1=enddate;
		     var temp=stdate;
		     var d=temp.substring(0,2);
		     var m=temp.substring(3,5);
		     var y=temp.substring(6,10);
		     var d1=enddate.substring(0,2);
		     var m1=enddate.substring(3,5);
		     var y1=enddate.substring(6,10);
		     var d2=enddate1.substring(0,2);
		     var m2=enddate1.substring(3,5);
		     var y2=enddate1.substring(6,10);

		 while(((y1>y)||((y1==y)&&(m1 > m)) ||((y1==y) && (m1 == m) && (d1 >d))))
			 {
			 temp= getWbsPlanDate(temp,8);
		 	tempday= new Date(temp.substring(6,10)+"-"+temp.substring(3,5)+"-"+temp.substring(0,2)).getDay(); 
		 	if(tempday==6)
		 	{
		 		temp= getWbsPlanDate(temp,16);
		 		enddate= getWbsPlanDate(enddate,16);
		 		
		 	}
		 	if(tempday==0)
		 	{
		 		temp= getWbsPlanDate(temp,8);
		  		enddate= getWbsPlanDate(enddate,8);
		  	
		 	}
		 	 d=temp.substring(0,2);
		 	 m=temp.substring(3,5);
		 	 y=temp.substring(6,10);
		 	 d1=enddate.substring(0,2);
		 	 m1=enddate.substring(3,5);
		 	 y1=enddate.substring(6,10);
		 	 d2=enddate1.substring(0,2);
		     m2=enddate1.substring(3,5);
		     y2=enddate1.substring(6,10);

			 }enddate1= getWbsPlanDate(enddate,80);
			var portdate = getWbsPlanDate(enddate,56);
			var toDay= new Date(portdate.substring(6,10)+"-"+portdate.substring(3,5)+"-"+portdate.substring(0,2)).getDay() +1 ; 
		 	if(toDay==6){
			 	portdate= getWbsPlanDate(portdate,16);
		 	}
		 	if(toDay==0)
		 	{
		  		portdate= getWbsPlanDate(portdate,8);
		 	}

			var releasedate = getWbsPlanDate(enddate,80);
			var toDay= new Date(releasedate.substring(6,10)+"-"+releasedate.substring(3,5)+"-"+releasedate.substring(0,2)).getDay() +1; 
		 	if(toDay==6){
			 	releasedate= getWbsPlanDate(releasedate,16);
		 	}
		 	if(toDay==0)
		 	{
		  		releasedate= getWbsPlanDate(releasedate,8);
		 	}
			var toDay= new Date(enddate.substring(6,10)+"-"+enddate.substring(3,5)+"-"+enddate.substring(0,2)).getDay() +1; 
		 	if(toDay==6){
			 	enddate= getWbsPlanDate(enddate,16);
		 	}
		 	if(toDay==0)
		 	{
		  		enddate= getWbsPlanDate(enddate,8);
		 	}
		 	 document.getElementById("toDate"+id).value=enddate;
		  if(!dateComparision("portDate"+id,"toDate"+id))
		  {
			  document.getElementById("portDate"+id).value=portdate;
			  document.getElementById("releaseDate"+id).value=releasedate ;
		  }
		 
	 }
	 
	 var id1;
	 var ide;
	 function resetphase(id1) {

		 document.getElementById("project_phase" + id1).value = " ";
	 }


	 function checkprojectphase(ide) {

		 var wbsname1 = document.getElementById("wbsname" + ide).value;
		 var customerId1 = document.getElementById("customerId" + ide).value;
		 var productId1 = document.getElementById("productId" + ide).value;

		 if (productId1 == "" || customerId1 == "" || wbsname1 == "") {
			 document.getElementById("project_phase" + ide).value = " ";
			 return;
		 }

		 var url = "getphasestatus.action?productId1=" + productId1
		 + "&customerId1=" + customerId1 + "&wbsname1=" + wbsname1;

		 xhr = createAjax();
		 xhr.open('POST', url, true);
		 xhr.onreadystatechange = function() {
			 showMessage3(ide);
		 };
		 xhr.send();

	 }

	 function showMessage3(ide) {

		 if (xhr.readyState == 4 && xhr.status == 200) {
			 var val = xhr.responseText;

			 if (val.length <= 2) {
				 alert("No active phase  is available");
				 return false;
			 }

			 var ph = val.split("~");
			 alert("Active Phase is " + ph[2]);

			 document.getElementById("project_phase" + ide).value = ph[1];
			 //document.getElementById("project_phase"+ide).options[0] = new Option(ph[2], ph[1]);

		 }
	 }
	 function saveViewWBS(){
		 var table = document.getElementById("WBSDetail");
		 var rowCount=table.rows.length;
		 var x=rowCount-1;
		 var url="viewWbsData.action?wbsname="+document.getElementById("wbsname"+x).value+"&customer="+document.getElementById("customerId"+x).value+"&product="+document.getElementById("productId"+x).value+"&projectphase="+document.getElementById("project_phase"+x).value+"&module="+document.getElementById("module"+x).value+"&isDownload=save"
		 document.forms[0].method="post";
		 document.forms[0].action=url;
		 document.forms[0].submit();

	 }
	 function addParentId(rowCount){
		 //var r=rowCount-1;
		 //
		 var parentIdValue=new Array();
		 for(var i=1;i<=rowCount;i++){
			 if(document.getElementById("parent_id"+i)==null){
				 continue;
			 }parentIdValue[i-1]=document.getElementById("parent_id"+i).value;
		 }
		 var data=null;
		 var wbsname=document.getElementById("wbsname1").value
		 var customer=document.getElementById("customerId1").value
		 var product=document.getElementById("productId1").value
		 var project_phase=document.getElementById("project_phase1").value;
		 var module=document.getElementById("module1").value;
		 if(product=="" || customer=="" || wbsname=="" || project_phase=="" || module==""){
			 //alert("Please Select all fields...!!");
			 return false;
		 }
		 var url="getParentIdName.action?wbsname="+wbsname+"&customer="+customer+"&product="+product+"&project_phase="+project_phase+
		 "&module="+module+"&parentId=";
		 xhr = createAjax();
		 xhr.open('POST',url,false);
		 xhr.onreadystatechange=function(){
			 if(xhr.readyState==4 && xhr.status==200){
				 var res=xhr.responseText;
				 res=res.split("~");
				 if(res[0]=="success"){
					 data=res[1].split("|");

				 }
			 }
		 };
		 xhr.send();
		 for(var i=2;i<=rowCount;i++){
			 var select=document.getElementById("parent_id"+i);
			 if(select==null){
				 continue;
			 }
			 var k=0;
			 select.innerHTML="";
			 select.options[k++]=new Option("--Select Activity--","-1");
			 var parentId1=document.getElementById("parent_id1");
			 if(parentId1.value!="" && i!=1){
				 select.options[k++]= new Option(parentId1.value,document.getElementById("parent_id_count1").value);
			 }
			 for(var j=1;j<i;j++){
				 var actCode=document.getElementById("activity_code"+j);
				 var actName=document.getElementById("activity_name"+j);
				 if(document.getElementById("isParent"+j)!=null && document.getElementById("isParent"+j).checked ==true && actCode!=null && actName!=null )
					 select.options[k++]= new Option(actName.value,actCode.value);


			 }
			 if(data!=null){
				 for(var j=0;j<data.length-1;j=j+2){
					 select.options[k++]= new Option(data[j+1],data[j]);
				 }

			 }
			 if(i!=1 && (parentIdValue[i-1]=="" || parentIdValue[i-1]==null))
				 parentIdValue[i-1]="-1";
			 select.value=parentIdValue[i-1];
		 }
		 /*for(var r=1;r<rowCount;r++){
						var actCode=document.getElementById("activity_code"+r);
						var actName=document.getElementById("activity_name"+r);
						if(actCode!=null && actName!=null )
							document.getElementById("paent_id"+r).append("<option value='"+actName.value+"' label='"+actCode.value+"'>");
					}*/
	 }
	 function setParentIdData(parentId){
		 
		 var wbsname=document.getElementById("wbsname1").value
		 var customer=document.getElementById("customerId1").value
		 var product=document.getElementById("productId1").value
		 var project_phase=document.getElementById("project_phase1").value;
		 var module=document.getElementById("module1").value;
		 if(product=="" || customer=="" || wbsname=="" || project_phase=="" || module==""){
			 alert("Please Select all fields...!!");
			 return false;
		 }
		 var url="getParentIdName.action?wbsname="+wbsname+"&customer="+customer+"&product="+product+"&project_phase="+project_phase+
		 "&module="+module+"&parentId="+parentId.value;
		 xhr = createAjax();
		 xhr.open('POST',url,false);
		 xhr.onreadystatechange=function(){
			 if(xhr.readyState==4 && xhr.status==200){
				 var res=xhr.responseText;
				 res=res.split("~");
				 if(res[0]=="success"){
					 if(parentId.id=="parent_id1"){
						 var data=res[1].split("|");
						 clearChildren('listid1');
						 for(var i=0;i<data.length-1;i+=2)
							 $('datalist#listid1').append("<option value='"+data[i+1]+"' label='"+data[i]+"'>");
						 document.getElementById("parent_id_count1").value=res[1];
					 }else{
						 parentId.parentElement.childNodes[1].value=parentId.value+"~"+parentId.options[parentId.selectedIndex].text;
					 }
				 }else{
					 alert("You cannot add this parent Activity");
					 parentId.value="";
				 }
			 }
		 };
		 xhr.send();
		 //alert(document.getElementsByName("fruits")[0].options[document.getElementsByName("fruits")[0].selectedIndex].value);

	 }
	 function setParentId(parentId){
		 //
		 if(parentId.id=="parent_id1"){
			 document.getElementById("parent_id_count1").value=document.getElementById("listid1").childNodes[0].label;
			 if(document.getElementById("parent_id1").value=="")
				 clearChildren('listid1');
		 }else{
			 parentId.parentElement.childNodes[1].value=parentId.value+"~"+parentId.options[parentId.selectedIndex].text;
		 }
	 }
	 function clearChildren( parent_id ) {
		 if(document.getElementById( parent_id )!=null){ var childArray = document.getElementById( parent_id ).children;
		 if ( childArray.length > 0 ) {
			 document.getElementById( parent_id ).removeChild( childArray[ 0 ] );
			 clearChildren( parent_id );
		 }}
	 }

	 function disableFlds(i){
		 if(document.getElementById("isParent"+i)!=null && document.getElementById("isParent"+i).checked==true){
			 document.getElementById("wbs_complexity"+i).value="-1";
			 document.getElementById("severity"+i).value="-1";
			 document.getElementById("wbs_planmandays"+i).value="0";
			 document.getElementById("wbs_complexity"+i).disabled=true;
			 document.getElementById("severity"+i).disabled=true;
			 document.getElementById("wbs_planmandays"+i).disabled=true;
		 }else{
			 document.getElementById("wbs_complexity"+i).disabled=false;
			 document.getElementById("severity"+i).disabled=false;
			 document.getElementById("wbs_planmandays"+i).disabled=false;
		 }
	 }
	 function backToDashBoard(url){
		 window.location.href=url;
	 }
	 
	 function CallAfterTable()
	 {
		  $('input[type="search"][aria-controls]').addClass('form-control').css({width:'180px',display:'inline-block'}).before('<i class="fa fa-search ico"></i>').attr('placeholder','Search');
	      $('select[aria-controls]').addClass('form-control').css({width:'72px',display:'inline-block'}).before('<i class="fa fa-cog ico"></i>');
	      $('select[aria-controls]').addClass('form-control').css('padding','0!important')
	      
	     
	 }
	 function CallAfterTableWBS()
	 { //alert("CallAfterTableWBS");
		  $('input[type="search"][aria-controls]').addClass('form-control').css({width:'120px',display:'inline-block'}).before('<i class="fa fa-search ico"></i>').attr('placeholder','Search');
	      $('select[aria-controls]').addClass('form-control').css({width:'72px',display:'inline-block'}).before('<i class="fa fa-cog ico"></i>');
	      $('select[aria-controls]').addClass('form-control').css('padding','0!important')
	      
	     
	 }
	 function FindFirst(elem) {
		   
		   if ($(elem).find('.dataRow').length == 1)
		    	$(elem).find('.dataRow').find('.del').hide();
		    else
		    	$(elem).find('.dataRow').find('.del').show();
		}

function addsubRow(tableId,th) {
debugger;
		var table = document.getElementById(tableId);
		var tbody = document.getElementById(tableId).getElementsByTagName(
					"TBODY")[0];
		var row = document.createElement("TR");
		var rowCount = table.rows.length;
		var x = rowCount - 1;
			if (document.getElementById("wbsname1").value == ""
					|| document.getElementById("customerId1").value == ""
					|| document.getElementById("productId1").value == ""
					|| document.getElementById("project_phase1").value == ""
					|| document.getElementById("activity_name1").value == ""
					|| document.getElementById("module1").value == ""
					//||(document.getElementById("isParent1").checked == false)
					) {
			alert("Please Fill Previous Row First...!!");
				return false;
			} else{
				var strHtml6 = "<textarea  class=\"form-control noResize\" name=\"sub_activity_name\" id=\"sub_activity_name"+rowCount+"\" " +
						"placeholder=\"Activity Name\" style=\"width:auto !important;height:auto% !important;\" onblur=\"addParentId("+table.rows.length+")\" onkeypress=\"return alphaNumChat(event)\"></textarea>" +
						"<input type=\"hidden\" value=\"-1\" id=\"subparent_id_count"+rowCount+"\" name=\"subparent_Id_count\"  style=' width: 100% !important; height: 55px!important;' />";
				//onchange=\"setParentId(this)\"
				var strHtml9 = "<select id=\"sub_wbs_complexity"+rowCount+"\" name=\"sub_wbs_complexity\"  class=\"form-control\" >"+
								"<option value=\"-1\">--Select--</option>"+
								"<option value=\"S\">Simple</option>"+
								"<option value=\"M\">Medium</option>"+
								"<option value=\"C\">Complex</option>"+
								"</select>";
				
				
				var strHtml10 = "<input class=\"form-control\" type=\"text\""+
								"name=\"sub_wbs_planmandays\"  id=\"sub_wbs_planmandays"+rowCount+"\" "+
								"placeholder=\"Plan Man Days\" size=\"30\" maxlength=\"2\" " +
								"style=\"max-width:100px;\" onkeypress=\"return isNumberKey(event)\"/>"
				
				var strHtml11 = "<select id=\"sub_severity"+rowCount+"\" name=\"sub_severity\" class=\"form-control\" style=\"width: 120px; height: 30px;\">";
				
				var strHtml13 = $('.addButtonTd1').first().html();
				if(strHtml13==undefined){
				strHtml13="<a class=\"Btn View btnXSmallIcon add subactbtnadd\" title=\"Add\" "+
									"onclick=\"addsubRow('WBSDetail1',this)\" style=\"display: inline-block;\"> "+
									" <i class=\"fa fa-plus\"></i></a> "+
								 "<a class=\"Btn Delete btnXSmallIcon del subactbtndel\" title=\"Remove\" onclick=\"deleteRowTable(this);addParentId(document.getElementById('WBSDetail').rows.length)\" style=\"display: none;\"> "+
								 "<i class=\"fa fa-minus\"></i></a>";
								
				}
				$(table).append('<tr class="dataRow">'+
								
								'	<td style="padding: 0px;">'+strHtml6+'	</td>'+
								'	<td style="padding: 0;">'+strHtml11+'</td>'+
								'	<td style="padding: 0;">'+strHtml9+'</td>'+
								'		<td style="padding: 0;">'+strHtml10+'</td>'+
								'		<td class="addButtonTd1">'+strHtml13+'</td>'+
								'	</tr>')
				FindFirst(tbody);
				//tbody.appendChild(row);
				count1 = parseInt(count1) + 1;
				suballWBSselectData(rowCount, wbsselectData);

				document.getElementById("sub_activity_name" + rowCount).focus();
				//addParentId(rowCount);
				$(table).find("td").css("padding:0;");
			}
		} 
function getsubSelectData(rowCount)
{
	newRowCount=rowCount;
	xhr = createAjax();
	xhr.open('POST','GetSelectData',false);
	xhr.onreadystatechange=subdataResponseHandler ;
	xhr.send();
}
function subdataResponseHandler()
{
  if (xhr.readyState==4 && xhr.status==200)
  {
	  	var res = xhr.responseText;
		var resArr= res.split("@");
		wbsselectData=resArr;
		suballWBSselectData(newRowCount,resArr);
		if(document.getElementById("wbsname"+newRowCount)!=null)
			document.getElementById("wbsname"+newRowCount).focus();
		
  }
}
// for WBS Select Data
function suballWBSselectData(newRowCount,resArr)
{
	var severity=resArr[3].split("~");
	
	if(document.getElementById("sub_severity"+newRowCount)!=null){
		document.getElementById("sub_severity"+newRowCount).options[0]= new Option("---Select---","-1");
	 j=1;
	 for(var i=1;i<severity.length;i=i+2)
	 {
		 document.getElementById("sub_severity"+newRowCount).options[j]= new Option(severity[i+1],severity[i]);
		 j++;
	 }
 }
}

function getproductSelectData(rowCount)
	{	debugger;
		newRowCount=rowCount;
		xhr = createAjax();
		xhr.open('POST','GetSelectData',false);
		xhr.onreadystatechange=productdataResponseHandler ;
		xhr.send();
	}
function productdataResponseHandler()
	{
		debugger;
	  if (xhr.readyState==4 && xhr.status==200)
	  {
		  	var res = xhr.responseText;
			var resArr= res.split("@");
			wbsselectData=resArr;
			allproductselectData(newRowCount,resArr);
			if(document.getElementById("productlife"+newRowCount)!=null)
				document.getElementById("productlife"+newRowCount).focus();
			
	  }
	}
function allproductselectData(newRowCount,resArr)
	{
		debugger;
		var product=resArr[4].split("~");
		if(document.getElementById("productlife"+newRowCount)!=null)
			document.getElementById("productlife"+newRowCount).options[0]= new Option("---select---"," ");
			var j=1;
		 if(newRowCount=="")
		 	newRowCount=0;
		 if(document.getElementById("productlife"+newRowCount)!=null)
		 {
			 for(var i=1;i<product.length;i=i+2)
		 	{
				document.getElementById("productlife"+newRowCount).options[j]= new Option(product[i+1],product[i]);
	        	j++;
		 	}
		 }
	}
// for select Product customer Data
	function getSelectDatapro(rowCount)
	{
	debugger;
		newRowCount=rowCount;
		xhr = createAjax();
		xhr.open('POST','getSelectProdCust',false);
		xhr.onreadystatechange=dataResponseHandlerprod ;
		xhr.send();
	}
	function dataResponseHandlerprod()
	{
	debugger;
	  if (xhr.readyState==4 && xhr.status==200)
	  {
		  	var res = xhr.responseText;
			var resArr= res.split("@");
			wbsselectData=resArr;
			allProdcusselectData(newRowCount,resArr);
			document.getElementById("productId").focus();
			
	  }
	}
	// for contract master Select Data
	function allProdcusselectData(newRowCount,resArr)
	{
	debugger;	
		var product=resArr[0].split("~");
		var customer=resArr[1].split("~");
		
		if(document.getElementById("productId")!=null)
			document.getElementById("productId").options[0]= new Option("---Select---"," ");
		if(document.getElementById("customerId")!=null)
			document.getElementById("customerId").options[0]= new Option("---Select---"," ");

		
		var j=1;
		for(var i=1;i<customer.length;i=i+2)
		{
			document.getElementById("customerId").options[j]= new Option(customer[i+1],customer[i]);
	        j++;
		}
		
		var j=1;
		 if(document.getElementById("productId")!=null)
		 {
			 for(var i=1;i<product.length;i=i+2)
		 	{
			document.getElementById("productId").options[j]= new Option(product[i+1],product[i]);
	        j++;
		 	}
		 }
	}

function getCustomerspro(){
debugger;
		var pid=document.getElementById("productId").value;
		var url="getSelectedCustomer?productId="+pid;

		xhr = createAjax();
		xhr.open('POST',url,false);
		xhr.onreadystatechange=function(){setCustomerspro();} ;
		xhr.send();
	}
function setCustomerspro(){
debugger;
		if(xhr.readyState==4 && xhr.status==200){
			var res=xhr.responseText;
			if(document.getElementById("customerId")!=null){
				document.getElementById("customerId").innerHTML="";
				document.getElementById("customerId").options[0]= new Option("---Select---"," ");
			}
			
			if(res !="")
			{
				var data=res.split("@");
				var customer=data[0].split("~");
				var j=1;
				if( document.getElementById("customerId")!=null){
					for(var i=1;i<customer.length;i=i+2)
					{
						document.getElementById("customerId").options[j]= new Option(customer[i+1],customer[i]);
						j++;
					}
				}
			}
		}
	}

function saveContractMaster()
	{
		var prodId,custId,contName,contDesc,contDate,contAmt;
		prodId=document.getElementById("productId").value;
		custId=document.getElementById("customerId").value;
		contName=document.getElementById("contractName").value;
		contDesc=document.getElementById("contractDesc").value;
		contDate=document.getElementById("contractDate").value;
		contAmt=document.getElementById("contractAmount").value;

		if(prodId==" "){
			alert("Please Select product");
			document.getElementById("productId").focus();
			return false;
		}else if(custId==" "){
			alert("Please Select Customer");
			document.getElementById("customerId").focus();
			return false;
		}else if(contName.trim()==" "){
			alert("Please Fill Contract Name");
			document.getElementById("contractName").focus();
			return false;
		}else if(contDesc==" "){
			alert("Please Fill Contract Description");
			document.getElementById("contractDesc").focus();
			return false;
		}else if(contDate==""){
			alert("Please Fill Contract Date ");
			document.getElementById("contractDate").focus();
			return false;
		}else if(contAmt==""){
			alert("Please Fill Contract Amount ");
			document.getElementById("contractAmount").focus();
			return false;
		}
		var url="";
		url="saveContractData.action?prodId="+prodId+"&custId="+custId+"&contName="+contName+"&contDesc="+contDesc+"&contDate="+contDate+"&contAmt="+contAmt;
		alert(url);
		var a=confirm("Are You Sure To Save Records..!!");
		if(a)
		{
			xhr = createAjax();
			xhr.open('POST',url,false);
			xhr.onreadystatechange=function(){
				if(xhr.readyState==4 && xhr.status==200){
					var res=xhr.responseText;
					if(res=='success'){
						alert("Entry saved successfully");
						window.location.href="contractMaster.action";
					}else if(res=='contractNameduplicate'){ 

						alert("Contract Name "+contName+" already exist so please enter Other Name");
						document.getElementById("contractName").value="";
						document.getElementById("contractName").focus();
						return false;
					}else{
						alert("Entry not saved");
						window.location.href="contractMaster.action";
					}
				}
			};
			xhr.send();

		}
	}

function getContractName(id,rowcount){
debugger;
		var pid=id.value;
		if(pid==" ")
		{
			document.getElementById("contractId"+rowcount).innerHTML="";
			document.getElementById("contractId"+rowcount).options[0]= new Option("---Select---"," ");
			return false;
		}	
		var url="getSelectedCustomer?productId="+pid+"&contractName=list";
		xhr = createAjax();
		xhr.open('POST',url,false);
		xhr.onreadystatechange=function(){setContractName(rowcount);} ;
		xhr.send();
	}
function setContractName(rowcount){
debugger;
		if(rowcount=="")
			rowcount=1;
			
		if(xhr.readyState==4 && xhr.status==200){
			var res=xhr.responseText;
			//alert(res);
			if(document.getElementById("contractId"+rowcount)!=null){
				document.getElementById("contractId"+rowcount).innerHTML="";
				document.getElementById("contractId"+rowcount).options[0]= new Option("---Select---","0");
				document.getElementById("contractId"+rowcount).options[1]= new Option("Not Applicable","-1");
			}
			
			if(res !="s" )
			{
				var data=res.split("@");
				var customer=data[0].split("~");
				var j=2;
				if(document.getElementById("contractId"+rowcount)!=null){
					for(var i=1;i<customer.length;i=i+2)
					{
						document.getElementById("contractId"+rowcount).options[j]= new Option(customer[i+1],customer[i]);
						j++;
					}
				}
			}else if(res == "s") {
				document.getElementById("contractId"+rowcount).options[1]= new Option("Not Applicable","-1");
			}
		}
	}
//Save WORK ASSIGN JSP
function sanitize(key)
{
	debugger;
var myStr = key.value;
if (typeof myStr === "" && myStr.trim().length === 0) {
  console.log("Empty!");
}
else{
	//alert("input string "+myStr);
}
var sanitizestring="";
for (var i = 0; i < myStr.length; i++) {
 // console.log(string.charCodeAt(i));
 c=myStr.charCodeAt(i);
 	if(((c>=40 && c<=90) ||(c>=97 && c<=122)|| (c==32)  ||(c==33) ||(c==35) || (c==36) ) ){
		sanitizestring+=myStr[i];
	}else{
		//key.target.value='';
		key.key="";
		key.keycode="";
		sanitizestring+="";
	}
	}
//alert("sanitizestring"+sanitizestring);
key.value=sanitizestring;
return 0;
}


function getEmpList(rCnt,screen){
		debugger;
		if (screen=='wbs_entrybyEName')
		{
			var pid=document.getElementById("wbs_enterby"+rCnt).value;
			if(pid=='C')
			{
				$('#wbs_entrybyEName'+rCnt).hide();	
				
				$('#wbs_entrybyCName'+rCnt).show();	
			}else if(pid=='E'){
				$('#wbs_entrybyCName'+rCnt).hide();	
				
				$('#wbs_entrybyEName'+rCnt).show();
			}
		}

		var url="getEmployeeList";
		xhr = createAjax();
		xhr.open('POST',url,false);
		xhr.onreadystatechange=function(){setEMPList(rCnt,screen);};
		xhr.send();
	
}
function setEMPList(cnt,screen){
		debugger;
		//alert("1");
		if(xhr.readyState==4 && xhr.status==200){
			var res=xhr.responseText;
			//alert(res);
				document.getElementById(screen+cnt).innerHTML="";
				document.getElementById(screen+cnt).options[0]= new Option("--Select--"," ");
			
			if(res !="")
			{
				var wbs=res.split("~");
				//alert(wbs);
				var j=1;

				for(var i=1;i<wbs.length;i=i+2)
				{
					document.getElementById(screen+cnt).options[j]= new Option(wbs[i],wbs[i+1]);
					j++;
				}
			}
		}
	}