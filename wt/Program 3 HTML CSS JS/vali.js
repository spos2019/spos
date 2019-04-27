// JavaScript Document
function validate(){

	
if(document.StudentRegistration.Full_Name.value=="")
	{
		alert("Please provide your name");
		document.StudentRegistration.Full_Name.focus();
		return false;	
	}
	
	if(document.StudentRegistration.Last_Name.value=="")
	{
		alert("Please provide your name");
		document.StudentRegistration.Last_Name.focus();
		return false;	
	}
	
	if(document.StudentRegistration.BirthDate.value=="")
	{
		alert("Please provide your Birthday");
		document.StudentRegistration.BirthDate.focus();
		return false;	
	}
	
var email = document.StudentRegistration.Email_Id.value;

atpos = email.indexOf("@");

dotpos = email.lastIndexOf(".");

 if (email == "" || atpos < 1 || ( dotpos - atpos < 2 )) 
 {
     alert("Please enter correct email ID")
     document.StudentRegistration.Email_Id.focus() ;
     return false;
 }
		







 if( document.StudentRegistration.Mobile_Number.value == "" ||  isNaN( document.StudentRegistration.Mobile_Number.value) ||
           document.StudentRegistration.Mobile_Number.value.length != 10 )
   {
     alert( "Please provide a Mobile No in the format 123. and max length is 10" );
     document.StudentRegistration.Mobile_Number.focus() ;
     return false;
   }
		
if ( ( StudentRegistration.Gender[0].checked == false ) && ( StudentRegistration.Gender[1].checked == false ) )
	{
		alert ( "Please choose your Gender: Male or Female" );
		return false;
	} 
	if(document.StudentRegistration.Address.value=="")
	{
		alert("Please provide your Address");
		document.StudentRegistration.Address.focus();
		return false;	
	}
	
	return true;
}
