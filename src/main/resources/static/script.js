
function callAction(name)
{
	document.form.action="updateOI.action?name="+name;
	document.form.submit();
}

//Allow only alphabets
function ValidateAlpha(evt)
{
       var keyCode = (evt.which) ? evt.which : evt.keyCode
        if ((keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && keyCode != 32)
        return false;

   return true;
}


//Allow only Alphanumeric keys
function isValidNumAlpha(evt)
{

	var keyCode = (evt.which) ? evt.which : evt.keyCode
	if ((keyCode>=65 || keyCode<=90) && (keyCode>=97 || keyCode<=122) && (keyCode==32) && (keyCode>=48 || keyCode<=57))
		return false;

	return true;
}

//Only numeric keys
function isNumberKey(evt)
{

	   var keyCode = (evt.which) ? evt.which : evt.keyCode;
	   if (keyCode != 46 && keyCode > 31 && (keyCode < 48 || keyCode > 57))
       return false;

   return true;
}

//Only Email
function checkemail(){
	var testresults;
	var str=document.forms[0].email.value
	if(str.length>0)
	{
			var filter=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/i
			if (filter.test(str))
			testresults=true
			else
			{
				alert("Please input a valid email address!")
				document.forms[0].email.value="";
				document.forms[0].email.focus();
				testresults=false
			}
	}
	else
	{
		testresults=true
	}
	return (testresults)
}

//For ajax Loader
$(function(){
	$(document).ajaxStart(function(){
		$("#wait").css("display","block");
	  });
	});

$(function(){
		$(document).ajaxComplete(function(){
		$("#wait").css("display","none");
		  });
	});

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



//if((Year1>Year2)||((Year1==Year2)&&(Month1 > Month2)) || (((Year1==Year2) && (Month1 == Month2) && Day1 >  Day2)))
if((Year1>Year2)||   ((Year1==Year2)&&(Month1 > Month2)) || ((  (Year1==Year2) && (Month1 == Month2) && (Day1 > Day2 || Day1 == Day2 ))))
   return true;
else
         return false;

}
function daysDifference(st_date,end_date)
{

	var str_st_date  = document.getElementById(st_date).value;
	var str_end_date = document.getElementById(end_date).value;

	var str_day1   = str_st_date.substring(0,2);
	var str_month1 = str_st_date.substring(3,5);
	var str_year1  = str_st_date.substring(6,10);

	var str_day2   = str_end_date.substring(0,2);
	var str_month2 = str_end_date.substring(3,5);
	var str_year2  = str_end_date.substring(6,10);


	var   day1   = parseInt(str_day1);
	var   month1 = parseInt(str_month1);
	var   year1  = parseInt(str_year1);

	var   day2   = parseInt(str_day2);
	var   month2 = parseInt(str_month2);
	var   year2  = parseInt(str_year2);

	var   yeardiff  = year2 - year1;
	var   monthdiff = month2 - month1;
	var   daydiff   = day2  - day1;
	var   count = 0;
	if(daydiff<0||year2<year1||month2<month1)
	{
		//alert("diff");
		return 0;
	}
	if(yeardiff==0&&monthdiff==0)
	{
		return daydiff;
	}

	if(yeardiff>1)
	{
		count = (yeardiff-1)*12;
		yeardiff = 1;

	}
	if(yeardiff == 1)
	{
		count = count + 12 - month1 ;
		count = count + month2;

	}
	if(yeardiff ==0)
	{
		if(monthdiff>1)
		{
			count = count + (monthdiff - 1);
			monthdiff = 1;
		}
		if(monthdiff==1)
		{
			count = count + 1;

		}
	}
	var   year = year1;

	var   mend = 0;
	var   start_month = month1;
	var   daycount = 0;
	daycount = daycount - day1;

	while(count > 0)
	{
		switch(start_month)
		{
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12: 	mend = 31;
		break;
		case 4:
		case 6:
		case 9:
		case 11:    mend = 30;
		break;
		case 2:  	if(year%4==0)
			mend = 29;
		else
			mend = 28;
		break;

		default : alert("Invalid Month...");
		break;
		}

		if(start_month == 12)
		{
			start_month = 1;
			year = year + 1;
			daycount = daycount + mend;
			count = count - 1;
		}
		else
		{
			daycount = daycount + mend;
			count = count - 1;
			start_month = start_month + 1;
		}
	}

	daycount = daycount + day2;

//	alert("daycount::"+daycount);
	return daycount;

}
function  isValidDateFormat(date)
{
	var date = document.getElementById(date).value;

	var m = date.substring(3,5);
	var d = date.substring(0,2);
	var y = date.substring(6,10);

	if(parseInt(d) < 10)
		d="0"+d;
	if(parseInt(m) < 10)
		m="0"+m;

	if((date.length > 10) ||((date.charAt(2)!="-") &&(date.charAt(2)!="/"))||((date.charAt(5)!="-")&&(date.charAt(5)!="/"))||(d>31) ||(m>12) ||(y<1900))
	{
		return false;
	}
	else{

		var m = date.substring(3,5);
		var d = date.substring(0,2);
		var y = date.substring(6,10);

		if (d==0 ||m==0 ||y==0 )
		{
			return false;

		}

		if(m==01||m==03||m==05||m==07||m==08||m==10||m==12)
		{
			var dmax = 31;

		}
		else
			if (m==04||m==06||m==09||m==11)
			{
				var dmax = 30;

			}
			else
			{
				if((y%400==0) || (y%400==0 && y%100!=0)) {
					dmax = 29;
				}
				else dmax = 28;
			}

		if (d>dmax){
			return false;
		}

	}

	return true;
}
//Validity of Amount
function isValidAmount(evt, source){
	evt =(evt)?evt :window.event;
	var charCode =(evt.which)?evt.which :evt.keyCode;
	var amt = source.value;
	var len = parseInt(amt.length);
	var ind = parseInt(amt.indexOf('.'));
	if(isNaN(amt)){
		evt.keyCode = 0;
		source.value = ".00";
	}
	if(charCode == 46){
		if(ind>-1)
			evt.keyCode = 0;
	}
	else if(charCode < 48 || charCode >57)
		evt.keyCode = 0;
	else{
		if((len - ind)>4 && ind > -1)
			evt.keyCode = 0;
	}
}
//valid email

function isValidEMail(controlId){
	var email=trim(document.getElementById(controlId).value);
	if(email!=""){
		var RegExp = /^((([a-z]|[0-9]|!|#|$|%|&|'|\*|\+|\-|\/|=|\?|\^|_|`|\{|\||\}|~)+(\.([a-z]|[0-9]|!|#|$|%|&|'|\*|\+|\-|\/|=|\?|\^|_|`|\{|\||\}|~)+)*)@((((([a-z]|[0-9])([a-z]|[0-9]|\-){0,61}([a-z]|[0-9])\.))*([a-z]|[0-9])([a-z]|[0-9]|\-){0,61}([a-z]|[0-9])\.)[\w]{2,4}|(((([0-9]){1,3}\.){3}([0-9]){1,3}))|(\[((([0-9]){1,3}\.){3}([0-9]){1,3})\])))$/
		if(RegExp.test(email)){
			return true;
		}else{
			document.getElementById(controlId).value="";
			document.getElementById(controlId).focus();
			return false;
		}
	}else{
		document.getElementById(controlId).value="";
	}
}
//Trims a string
function trim(str1){
	var str = new String(str1)
	while(str.indexOf(' ')==0){
		str = str.replace(' ', '');
	}
	len = str.length;
	while(str.lastIndexOf(' ') == len-1 && len > 0){
		str = str.substring(0, len - 1);
		len = str.length;
	}
	return str;
}
//
function isValidUserId(evt,fld){
	var keyCode = (evt.which) ? evt.which : evt.keyCode;
	var a=fld.length;
	if(a==0 && keyCode==64){
		alert("First Character cann't be @");
		return false;
	}
	if((keyCode >=65 && keyCode <=90) || (keyCode >=97 && keyCode <=122))
		return true;
	else if(keyCode >= 48 && keyCode <= 57)
		return true;
	else if(keyCode==46)
		return true;
	else if(keyCode==64)
		return true;

	return false;
}
function newValidateAlpha(evt)
{
	var keyCode = (evt.which) ? evt.which : evt.keyCode
	if ((keyCode < 48 || keyCode > 57) && (keyCode < 65 || keyCode > 90) && (keyCode < 97 || keyCode > 123) && (keyCode != 32))
		return false;
	return true;
}