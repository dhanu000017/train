

 var expname=/(.*[a-z]){3,20}/i;
  var pattern = /^([6-9]\d{9})$/;
  var passpattern=/^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,20}$/;
  var ans=document.getElementById("para");

//----------------------un used method----------------------------------

function SubmitSignUpMethod(){
	var First_name=document.getElementById("First_name");
	var Last_name=document.getElementById("Last_name");
	var User_name=document.getElementById("User_name");
	var Mobile_Number=document.getElementById("Mobile_Number");
	var Password=document.getElementById("Password");
	
		 if (expname.test(First_name.value)) {
			console.log(ans)
			
       		} 
       	else {
	
	   		 ans.innerHTML="Incorrect First Name";
	    	 First_name.value="";
      		}
      		
   //------------------------first name checking---------------------------   
   		
      		if (expname.test(Last_name.value)) {
			
       		} 
       	else {
	
	   		 ans.innerHTML="Incorrect Last Name";
	    	 Last_name.value="";
      		}
      		
   //------------------------last name checking---------------------------   		
      		 if (expname.test(User_name.value)) {
			console.log(ans)
			
       		} 
       	else {
	
	   		 ans.innerHTML="Incorrect User Name";
	    	 User_name.value="";
      		}
      		
    //------------------------last name checking---------------------------   	
      		if (pattern.test(Mobile_Number.value)) {
       		} 
       	else {
	
	   		 ans.innerHTML="Incorrect Mobile Number";
	    	 Mobile_Number.value="";
      		}
      		
    //------------------------mobile number checking---------------------------   	

      		if (passpattern.test(Password.value)) {
       		} 
       	else {
	
	   		 ans.innerHTML="Not A Valid Password";
	    	 Password.value="";
      		}
      		
	//------------------------password checking---------------------------   		

	
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){ 
 					window.location.href="UserPage.html"; 
		
		 	}	
		}
	}
		if((First_name.value.length!=0)&&(Last_name.value.length!=0)&&(User_name.value.length!=0)&&(Mobile_Number.value.length!=0)&&(Password.value.length!=0)){
			
		
	var reqparam={};
	reqparam.First_name=document.getElementById("First_name").value;
	reqparam.Last_name=document.getElementById("Last_name").value;
	reqparam.User_name=document.getElementById("User_name").value;
	reqparam.Mobile_Number=document.getElementById("Mobile_Number").value;
	reqparam.Password=document.getElementById("Password").value;
	xhr.open("POST","http://localhost:8080/ServletPro/servlet_Example")
	xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
	console.log(reqparam.User_name);
	xhr.send("FirstName="+reqparam.First_name+"&LastName="+reqparam.Last_name+"&Username="+reqparam.User_name+"&MobileNumber="+reqparam.Mobile_Number+"&password="+reqparam.Password);
	
}
	else{
		ans.innerText="Enter Valid Input";	
	}
}

//----------------------checking sign up method----------------------------------
	function SubmitLoginMethod(){
		var User_na=document.getElementById("User_na");
		var Password2=document.getElementById("Password2");
		
	
      		var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){ 
				console.log(this.responseText);
				console.log("con");
				if(xhr.responseText.startsWith("ADMIN")){
					console.log("admin")
					window.location.href="AdminPage.html";
				}else{
					var res=JSON.parse(this.responseText);
				    var para_login=document.getElementById("para_login");
				    para_login.innerText="User Not Found";
				}
				
				if(res.Status == 200){
					 para_login.innerText="";
					window.location.href="UserPage.html";
				}
			//window.location.href="UserPage.html";
		 	}	
		}
	}
		if((User_na.value.length!=0)&&(Password2.value.length!=0)){
			
		
	var reqparam={};
	reqparam.User_na=document.getElementById("User_na").value;
	reqparam.Password2=document.getElementById("Password2").value;
	xhr.open("POST","http://localhost:8080/ServletPro/login_Servlet")
	xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xhr.send("User_na="+reqparam.User_na+"&Password2="+reqparam.Password2);
	
}
}
		
  