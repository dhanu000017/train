/**
 * 
 */
 
 
 var select0  =  document.getElementById('colors');
var select1  =  document.getElementById('colorss');
var select2  =  document.getElementById('claSS');
var whole2=document.getElementById("whole2");
var trde={};
var train={};
	whole2.style="display:none";
	var trpri;
	var seaDetails;
	 var FromArray=["mathalamparai","erode","sengottai","salem","tiruchendur","chennai","kovai","chengalpattu","madurai"];
 var ToArray=["kadaiyam","palani","chennai","madurai","thirunelveli","ramanathapuram","thoothukudi","tenkasi","sillaraipuravu","kangeyam","uthiyur","dharapuram","rajapalayam","perambalur","chengalpattu","namakkal","karur","dindigul","trichy","tindivanam","virudhunagar","salem","kallalurichi","viluppuram","karaikudi","vilathikulam","samayapuram","melmaruvathur","sankarankoil","tirumangalam","oddanchatram","aruppukkotai","ettaiyapuram"];
 var classes=["FIRST CLASS","SECOND CLASS"];
	for(let i of FromArray){
	console.log('hi')
	let option = document.createElement('option');
	select0.appendChild(option)
	option.setAttribute('class','option');
	option.value = i;
	option.innerhtml=i;
}

for(let i of ToArray){
	console.log('hi')
	let option1 = document.createElement('option');
	select1.appendChild(option1)
	option1.setAttribute('class','option1');
	option1.value = i;
	option1.innerhtml=i;
}

for(let i of classes){
	console.log('i')
	let option2 = document.createElement('option');
	select2.appendChild(option2)
	option2.setAttribute('class','option2');
	option2.value = i;
	option2.innerhtml=i;
}


 
var today = new Date();
	let minDate = today.toISOString().slice(0, 10);
 	today.setDate(today.getDate() + 30);
	let maxDate = today.toISOString().slice(0, 10);
	date1.setAttribute("min", minDate);
	date1.setAttribute("max", maxDate);

let x = document.getElementById("image2")

function booking(){
	var FrDetails=document.getElementById("color");
	var ToDetails=document.getElementById("colo");
	var daDetails=document.getElementById("date1");
	var clasDetails=document.getElementById("cla");
	seaDetails=document.getElementById("sea");
	var can=document.getElementById("can");
		can.style="z-index:-1";
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		console.log(this.readyState);
		
		if((this.readyState==4)){
			if(this.status==200){ 
			console.log(xhr.responseText);
			var greenDiv=document.getElementById("TrainOptions");
			if(JSON.parse(xhr.responseText).length==0){
				console.log(JSON.parse(xhr.responseText).length);
				document.getElementById('trs') ? document.getElementById('trs').remove() : null;
				document.getElementById('trss') ? document.getElementById('trss').remove() : null;
				document.getElementById("image2").style.display="block";
				
		
			}
			else{
				console.log(JSON.parse(xhr.responseText).length);
				x.style.display="none";
				document.getElementById('trs') ? document.getElementById('trs').remove() : null;
				document.getElementById('trss') ? document.getElementById('trss').remove() : null;
				greenDiv.innerHTML=`<div id="trss"><span class="trspara">${"TrainId"}</span><span class="trspara">${"Trainname"}</span><span class="trspara">${"From"}</span><span class="trspara">${"To"}</span><span class="trspara">${"Price"}</span><span class="trspara">${"Duration"}</span></div>`;
				JSON.parse(xhr.responseText).map((ele)=>{
				train=ele;
				greenDiv.innerHTML+=`<div id="trs" onclick="traininOption(this)" data-value=${ele.Price}><span class="trspara">${ele.TrainId}</span><span class="trspara">${ele.Trainname}</span><span class="trspara">${ele.TrainFrom}</span><span class="trspara">${ToDetails.value}</span><span class="trspara trpri">${ele.Price}</span><span class="trspara trpri">${ele.Duration}</span></div>`;
			})		
			}
			
		 	}		
		}
	}
	
	if((FromArray.includes(FrDetails.value))&&(ToArray.includes(ToDetails.value))&&(FrDetails.value!=ToDetails.value)&&(daDetails.value!="")&&(clasDetails.value!="")&&(seaDetails!="")){	
		console.log("entering")	
		var reqparam={};
	reqparam.FrDetails=document.getElementById("color").value;
	reqparam.ToDetails=document.getElementById("colo").value;
	reqparam.daDetails=document.getElementById("date1").value;
	reqparam.clasDetails=document.getElementById("cla").value;
	reqparam.seaDetails=document.getElementById("sea").value;
	xhr.open("POST","user/TicketBooking")
	trde = reqparam;
	xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xhr.send("FrDetails="+reqparam.FrDetails+"&ToDetails="+reqparam.ToDetails+"&daDetails="+reqparam.daDetails+"&clasDetails="+reqparam.clasDetails+"&seaDetails="+reqparam.seaDetails);
		
	}
		
		else{
			FrDetails.value="";
			ToDetails.value="";
			daDetails.value="";
			clasDetails.value="";
			seaDetails.value="";
			alert("Enter Valid Input !");
		}	
		
	
}

function viewTickets(){
	
	var viewTickets=document.getElementById("whol2");
	var Search_Button=document.getElementById("Search_Button");
	var whole2=document.getElementById("whole2");
	var kutty=document.getElementById("kutty");
	var back=document.getElementById("back");
	var AdminKutty2=document.getElementById("AdminKutty2");
	AdminKutty2.style.display="none";
    var succ=document.getElementById("succ");
    kutty.style.display="block"
    succ.style.display="none";
	viewTickets.style.display = "none";
	Search_Button.style.display = "none";
	whole2.style.display="flex";
	back.style.display=""
	back.style.height="915px";
	var xhr=new XMLHttpRequest();
	
	xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
				 console.log(xhr.responseText);
				 kutty.innerHTML="";
				 kutty.innerHTML+=`<div class="cusde"><span class="cudepara">${"TrainId"}</span><span class="cudepara">${"From"}</span><span class="cudepara">${"To"}</span><span class="cudepara">${"Seats"}</span><span class="cudepara">${"Date"}</span><span class="cudepara">${"Time"}</span></div>`;
				JSON.parse(xhr.responseText).map((ele)=>{
					
				kutty.innerHTML+=`<div class="cusde"><span class="cudepara">${ele.TrainId}</span><span class="cudepara">${ele.TrainFrom}</span><span class="cudepara">${ele.TrainTo}</span><span class="cudepara">${ele.NumOfSeats}</span><span class="cudepara">${ele.DateAndTime}</span><span class="cudepara">${ele.Time}</span></div>`;
		 	})
		
			}
		}
	}
	
	xhr.open("POST","user/ViewMyBookedTicket");
	xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xhr.send();
}

function viewbooking(){
	console.log("n")
	var viewTickets=document.getElementById("whol2");
	var Search_Button=document.getElementById("Search_Button");
	var whole2=document.getElementById("whole2");
	var back=document.getElementById("back");
	
	viewTickets.style.display ="flex";
	Search_Button.style.display = "flex";
	Search_Button.style= "z-index:1";
	whole2.style.display="none";
	back.style.height="400px";
}
	
	
	function ViewAllPassangersDetails(){
		var inputfieldsdiv =document.getElementById("inputfieldsdiv");
		inputfieldsdiv.style.display="none";
 		var AdminKutty=document.getElementById("AdminKutty");
		AdminKutty.style.display="block";
 		var xhr=new XMLHttpRequest();
 		xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
			 console.log(xhr.responseText);	
				AdminKutty.innerHTML="";
				AdminKutty.innerHTML+=`<div class="Adminde"><span class="Admindepara">${"Id"}</span><span class="Admindepara">${"user name"}</span><span class="Admindepara">${"firstname"}</span><span class="Admindepara">${"lastname"}</span><span class="Admindepara">${"Mobile Number"}</span><span class="Admindepara">${"Role"}</span></div>`;
					JSON.parse(xhr.responseText).map((ele)=>{
					AdminKutty.innerHTML+=`<div class="Adminde"><span class="Admindepara">${ele.Id}</span><span class="Admindepara">${ele.usname}</span><span class="Admindepara">${ele.firstname}</span><span class="Admindepara">${ele.lastname}</span><span class="Admindepara">${ele.phoneNum}</span><span class="Admindepara">${ele.Role}</span></div>`;
		 	})
		 	
			}
		}
	}
 		xhr.open("POST","user/ViewAllPassengerDe");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.send();
	}


function traininOption(e){
	

		trpri=e.getAttribute("data-value");
	console.log(trpri);
	
	var ticketBookingButton=document.getElementById("ticketBookingButton");
	ticketBookingButton.style.display="block";
	
		var AdminKutty2=document.getElementById("AdminKutty2");
		var Search_Button=document.getElementById("Search_Button");
		Search_Button.style.display="none";
		AdminKutty2.style.display="block";
		console.log(trde);
		
		
		var xhr=new XMLHttpRequest();
 		xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
			var succ=document.getElementById("succ");
				succ.style.display="none";
			var totalPrice=document.getElementById("totalPrice");
			totalPrice.innerText="Total Price Of The Ticket : "+seaDetails.value*trpri;
			}
		}
	}
	

 		xhr.open("POST","user/price");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.send("Price="+train.Price+"&seats="+trde.seaDetails);
			
}

function ViewAllTrainsDetails(){
	var inputfieldsdiv =document.getElementById("inputfieldsdiv");
	inputfieldsdiv.style.display="none";
	var AdminKutty=document.getElementById("AdminKutty");
	AdminKutty.style.display="block";
	var TrainIdForDelete=document.getElementById("TrainIdForDelete");
		TrainIdForDelete.style.display="none";
	var AdminDeletesubmitButton=document.getElementById("AdminDeletesubmitButton");
		AdminDeletesubmitButton.style.display="none";

 		var xhr=new XMLHttpRequest();
 		xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
			 console.log(xhr.responseText);	
				AdminKutty.innerHTML="";
				AdminKutty.innerHTML+=`<div class="Admintrainde"><span class="Admintrdepara">${"TrainId"}</span><span class="Admintrdepara">${"Train name"}</span><span class="Admintrdepara">${"Timing"}</span><span class="Admintrdepara">${"From"}</span><span class="Admintrdepara">${"To"}</span><span class="Admintrdepara">${"Price"}</span><span class="Admintrdepara">${"NumOfSeats"}</span><span class="Admintrdepara">${"FirstClass"}</span><span class="Admintrdepara">${"SecondClass"}</span><span class="Admintrdepara">${"Status"}</span><span class="Admintrdepara">${"Duration"}</span></div>`;
					JSON.parse(xhr.responseText).map((ele)=>{
					AdminKutty.innerHTML+=`<div class="Admintrainde"><span class="Admintrdepara">${ele.TrainId}</span><span class="Admintrdepara">${ele.Trainname}</span><span class="Admintrdepara">${ele.Timing}</span><span class="Admintrdepara">${ele.TrainFrom}</span><span class="Admintrdepara">${ele.TrainTo}</span><span class="Admintrdepara">${ele.Price}</span><span class="Admintrdepara">${ele.NumOfSeats}</span><span class="Admintrdepara">${ele.FirstClass}</span><span class="Admintrdepara">${ele.SecondClass}</span><span class="Admintrdepara">${ele.Status}</span><span class="Admintrdepara">${ele.Duration}</span></div>`;
		 	})
		 	
			}
		}
	}
 		xhr.open("POST","user/ViewAllTrainsDetailses");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.send();
	
}

function ChangeAdminNameAndPass(){
	var inputfieldsdiv =document.getElementById("inputfieldsdiv");
		inputfieldsdiv.style.display="block";
	var AdminKutty=document.getElementById("AdminKutty");
		AdminKutty.style.display="none";
	var TrainIdForDelete=document.getElementById("TrainIdForDelete");
		TrainIdForDelete.style.display="none";
	var AdminDeletesubmitButton=document.getElementById("AdminDeletesubmitButton");
		AdminDeletesubmitButton.style.display="none";
	var NewName=document.getElementById("NewName");
	var NewPass=document.getElementById("NewPass");
		NewName.style.display="block";
		NewPass.style.display="block";
	var AdminsubmitButton=document.getElementById("AdminsubmitButton")
		AdminsubmitButton.style.display="block";
	var heading=document.getElementById("head");
		heading.style.display="block";
	var heading2=document.getElementById("head2");
		heading2.style.display="none";
	var TrainID=document.getElementById("TrainID");
	var TrainNAME=document.getElementById("TrainNAME");
		TrainID.style.display="none";
		TrainNAME.style.display="none";
	var TrainTime=document.getElementById("TrainTime")
		TrainTime.style.display="none";
	var TrainFROM=document.getElementById("TrainFROM");
		TrainFROM.style.display="none";
	var TrainTO=document.getElementById("TrainTO");
		TrainTO.style.display="none";
	var TrainPrice=document.getElementById("TrainPrice")
		TrainPrice.style.display="none";
	var First=document.getElementById("First");
		First.style.display="none";
	var Second=document.getElementById("Second");
		Second.style.display="none";
	var duration=document.getElementById("duration");
		duration.style.display="none";
	var count=document.getElementById("count");
		count.style.display="none";
	var TrainIdForActive=document.getElementById("TrainIdForActive");
		TrainIdForActive.style.display="none";
	var AdminactivesubmitButton=document.getElementById("AdminactivesubmitButton");
		AdminactivesubmitButton.style.display="none";
		
	
	var createStopDiv=document.getElementById("createStopDiv");
		createStopDiv.style.display="none";
	
}
function AdminsubmitButton(){

	var NewName=document.getElementById("NewName");
	var NewPass=document.getElementById("NewPass");
	
	
	var xhr=new XMLHttpRequest();
 		xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
				var heading=document.getElementById("head");
				heading.style.display="block";
			  heading.innerText=xhr.responseText;
			}
		}
	}
	
	
	var reqparam={};
	reqparam.NewName=document.getElementById("NewName").value;
	reqparam.NewPass=document.getElementById("NewPass").value;
 		xhr.open("POST","user/AdminNameAndPass");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.send("NewName="+reqparam.NewName+"&NewPass="+reqparam.NewPass);
	

}


function RemovingATrainFromTheList(){
	var inputfieldsdiv =document.getElementById("inputfieldsdiv");
		inputfieldsdiv.style.display="block";
	var AdminKutty=document.getElementById("AdminKutty");
		AdminKutty.style.display="none";
	var NewName=document.getElementById("NewName");
	var NewPass=document.getElementById("NewPass");
		NewName.style.display="none";
		NewPass.style.display="none";
	var AdminsubmitButton=document.getElementById("AdminsubmitButton")
		AdminsubmitButton.style.display="none";
	var TrainIdForDelete=document.getElementById("TrainIdForDelete");
		TrainIdForDelete.style.display="block";
	var AdminDeletesubmitButton=document.getElementById("AdminDeletesubmitButton");
		AdminDeletesubmitButton.style.display="block";
	var heading=document.getElementById("head");
		heading.style.display="none";
	var heading2=document.getElementById("head2");
		heading2.style.display="block";
	var TrainID=document.getElementById("TrainID");
	var TrainNAME=document.getElementById("TrainNAME");
		TrainID.style.display="none";
		TrainNAME.style.display="none";
	var TrainTime=document.getElementById("TrainTime")
		TrainTime.style.display="none";
	var TrainFROM=document.getElementById("TrainFROM");
		TrainFROM.style.display="none";
	var TrainTO=document.getElementById("TrainTO");
		TrainTO.style.display="none";
	var TrainPrice=document.getElementById("TrainPrice")
		TrainPrice.style.display="none";
	var First=document.getElementById("First");
		First.style.display="none";
	var Second=document.getElementById("Second");
		Second.style.display="none";
	var duration=document.getElementById("duration");
		duration.style.display="none";
	var count=document.getElementById("count");
		count.style.display="none";
	var TrainIdForActive=document.getElementById("TrainIdForActive");
		TrainIdForActive.style.display="none";
	var AdminactivesubmitButton=document.getElementById("AdminactivesubmitButton");
		AdminactivesubmitButton.style.display="none";
	var heading3=document.getElementById("head3");
		heading3.style.display="none";
	
	var createStopDiv=document.getElementById("createStopDiv");
		createStopDiv.style.display="none";
}


function AdminDeletesubmitButton(){
	var TrainIdForDelete=document.getElementById("TrainIdForDelete");
	
		var xhr=new XMLHttpRequest();
 		xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
			var heading2=document.getElementById("head2");
				heading2.style.display="block";
			  heading2.innerText=xhr.responseText;
			}
		}
	}
	
	
	var reqparam={};
	reqparam.TrainIdForDelete=document.getElementById("TrainIdForDelete").value;
 		xhr.open("POST","user/TrainIdForDelete");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.send("TrainIdForDelete="+reqparam.TrainIdForDelete);
	
	
}
	
	
	function AdminactivesubmitButton(){
		
		var TrainIdForActive=document.getElementById("TrainIdForActive");
	
		var xhr=new XMLHttpRequest();
 		xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
			var heading3=document.getElementById("head3");
				heading3.style.display="block";
			  heading3.innerText=xhr.responseText;
			}
		}
	}
	
	
	var reqparam={};
	reqparam.TrainIdForActive=document.getElementById("TrainIdForActive").value;
 		xhr.open("POST","user/ActiveTrain");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.send("TrainIdForActive="+reqparam.TrainIdForActive);
	
		
		
	}
	
	function ticketBookingButton(){
		
		var xhr=new XMLHttpRequest();
 		xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
			var succ=document.getElementById("succ");
			succ.style.display="block";
			succ.innerText=xhr.responseText;
			var ticketBookingButton=document.getElementById("ticketBookingButton");
			ticketBookingButton.style.display="none";
			}
		}
	}
	
	console.log(trde)
	
 		xhr.open("POST","user/booking");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.send("from="+trde.FrDetails+"&to="+trde.ToDetails+"&date="+trde.daDetails+"&class="+trde.clasDetails+"&seats="+trde.seaDetails+"&TrainId="+train.TrainId+"&Trainname="+train.Trainname+"&Timing="+train.Timing+"&Price="+train.Price+"&NumOfSeats="+train.NumOfSeats+"&Duration="+train.Duration);
		
		
		
	}	
	
	function AddTrainDetails(){
	var inputfieldsdiv =document.getElementById("inputfieldsdiv");
		inputfieldsdiv.style.display="block";
	var AdminKutty=document.getElementById("AdminKutty");
		AdminKutty.style.display="none";
	var NewName=document.getElementById("NewName");
	var NewPass=document.getElementById("NewPass");
		NewName.style.display="none";
		NewPass.style.display="none";
	var AdminsubmitButton=document.getElementById("AdminsubmitButton")
		AdminsubmitButton.style.display="none";
	var TrainIdForDelete=document.getElementById("TrainIdForDelete");
		TrainIdForDelete.style.display="none";
	var AdminDeletesubmitButton=document.getElementById("AdminDeletesubmitButton");
		AdminDeletesubmitButton.style.display="none";
	var heading=document.getElementById("head");
		heading.style.display="none";
	var heading2=document.getElementById("head2");
		heading2.style.display="none";
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		var TrainID=document.getElementById("TrainID");
	var TrainNAME=document.getElementById("TrainNAME");
		TrainID.style.display="block";
		TrainNAME.style.display="block";
	var TrainTime=document.getElementById("TrainTime")
		TrainTime.style.display="block";
	var TrainFROM=document.getElementById("TrainFROM");
		TrainFROM.style.display="block";
	var TrainTO=document.getElementById("TrainTO");
		TrainTO.style.display="block";
	var TrainPrice=document.getElementById("TrainPrice")
		TrainPrice.style.display="block";
	var First=document.getElementById("First");
		First.style.display="block";
	var Second=document.getElementById("Second");
		Second.style.display="block";
	var duration=document.getElementById("duration");
		duration.style.display="block";
	var count=document.getElementById("count");
		count.style.display="block";
	var TrainIdForActive=document.getElementById("TrainIdForActive");
		TrainIdForActive.style.display="none";
	var AdminactivesubmitButton=document.getElementById("AdminactivesubmitButton");
		AdminactivesubmitButton.style.display="none";
	var heading3=document.getElementById("head3");
		heading3.style.display="none";
	var createStopDiv=document.getElementById("createStopDiv");
		createStopDiv.style.display="flex";
   
		
		
	}
	
function logout(){
	console.log("logout");
		var xhr=new XMLHttpRequest();
 		xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
			window.location.href="login.html";
			}
		}
	}

 		xhr.open("POST","user/logout");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.send();
}

function back(){
	
	
	window.location.href="UserPage.html";
	
	
	
	
}


function CreateStop(ele){
	console.log(ele.value);
	let parentDiv = document.getElementById("createStopDiv");
	let parentDiv2 = document.getElementById("inputfieldsdiv");

	parentDiv.innerHTML="";
	for(let i=1 ; i<=ele.value ; i++){
		let childDiv = document.createElement("div");
		childDiv.setAttribute('id',`stopDiv${i}`);
		let textInput = document.createElement('input');
		let numInput = document.createElement('input');
		textInput.placeholder="Enter your "+i+" stop";
		numInput.placeholder="Enter your "+i+" stop price";
		textInput.setAttribute('type','text');
		numInput.setAttribute('type','number');
		textInput.setAttribute('id',`stopText${i}`);
		numInput.setAttribute('id',`stopNum${i}`);
		textInput.setAttribute('class','stopText');
		numInput.setAttribute('class','stopNum');
		childDiv.appendChild(textInput);
		childDiv.appendChild(numInput);
		parentDiv.appendChild(childDiv);
	}
	let sub=document.createElement("button");
	sub.setAttribute('id',"sub");
	sub.innerText="Submit"
	sub.setAttribute('onclick',"SubmitTrain()");
	parentDiv.appendChild(sub);
	
}

function SubmitTrain(){
	var TrainID= document.getElementById("TrainID");
	var TrainNAME= document.getElementById("TrainNAME");
	var TrainTime= document.getElementById("TrainTime");
	var TrainFROM= document.getElementById("TrainFROM");
	var TrainTO= document.getElementById("TrainTO");
	var TrainPrice= document.getElementById("TrainPrice");
	var First= document.getElementById("First");
	var Second= document.getElementById("Second");
	var duration= document.getElementById("duration");
	var count= document.getElementById("count");
	
	let parentDiv = document.getElementById("createStopDiv");
	var arrayOfTrain=[];
	for(let i=1; i<=parentDiv.children.length-1;i++){
	let sta=document.getElementById(`stopText${i}`).value;
	let staNum=document.getElementById(`stopNum${i}`).value;
	var obj={"StationName":sta,"StationPrice":staNum}
	arrayOfTrain.push(obj);
	}
	
	var xhr=new XMLHttpRequest();
 		xhr.onreadystatechange=function(){
		console.log(this.readyState);
		if((this.readyState==4)){
			if(this.status==200){
			 console.log(xhr.responseText);	
			 var heading=document.createElement("h1");
			 heading.setAttribute("id","head4");
			 parentDiv.appendChild(heading);
				head4.innerText =xhr.responseText;
		 	
			}
		}
	}
	var reqparam={};
	reqparam.TrainID=document.getElementById("TrainID").value;
	reqparam.TrainNAME=document.getElementById("TrainNAME").value;
	reqparam.TrainTime=document.getElementById("TrainTime").value;
	reqparam.TrainFROM=document.getElementById("TrainFROM").value;
	reqparam.TrainTO=document.getElementById("TrainTO").value;
	reqparam.TrainPrice=document.getElementById("TrainPrice").value;
	reqparam.First= document.getElementById("First").value;
	reqparam.Second= document.getElementById("Second").value;
	reqparam.duration= document.getElementById("duration").value;
	reqparam.count=document.getElementById("count").value;
	
	
 		xhr.open("POST","user/AddTrain");
		xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
		xhr.send("TrainID="+reqparam.TrainID+"&TrainNAME="+reqparam.TrainNAME+"&TrainTime="+reqparam.TrainTime+"&TrainFROM="+reqparam.TrainFROM+"&TrainTO="+reqparam.TrainTO+"&TrainPrice="+reqparam.TrainPrice+"&First="+reqparam.First+"&Second="+reqparam.Second+"&count="+reqparam.count+"&duration="+reqparam.duration+"&array="+JSON.stringify(arrayOfTrain));
	
	
	console.log(arrayOfTrain);
}

function ActiveATrainFromTheList(){
	var inputfieldsdiv =document.getElementById("inputfieldsdiv");
		inputfieldsdiv.style.display="block";
	var AdminKutty=document.getElementById("AdminKutty");
		AdminKutty.style.display="none";
	var NewName=document.getElementById("NewName");
	var NewPass=document.getElementById("NewPass");
		NewName.style.display="none";
		NewPass.style.display="none";
	var AdminsubmitButton=document.getElementById("AdminsubmitButton")
		AdminsubmitButton.style.display="none";
	var TrainIdForDelete=document.getElementById("TrainIdForDelete");
		TrainIdForDelete.style.display="none";
	var AdminDeletesubmitButton=document.getElementById("AdminDeletesubmitButton");
		AdminDeletesubmitButton.style.display="none";
	var heading=document.getElementById("head");
		heading.style.display="none";
	var heading2=document.getElementById("head2");
		heading2.style.display="none";
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		var TrainID=document.getElementById("TrainID");
	var TrainNAME=document.getElementById("TrainNAME");
		TrainID.style.display="none";
		TrainNAME.style.display="none";
	var TrainTime=document.getElementById("TrainTime")
		TrainTime.style.display="none";
	var TrainFROM=document.getElementById("TrainFROM");
		TrainFROM.style.display="none";
	var TrainTO=document.getElementById("TrainTO");
		TrainTO.style.display="none";
	var TrainPrice=document.getElementById("TrainPrice")
		TrainPrice.style.display="none";
	var First=document.getElementById("First");
		First.style.display="none";
	var Second=document.getElementById("Second");
		Second.style.display="none";
	var duration=document.getElementById("duration");
		duration.style.display="none";
	var count=document.getElementById("count");
		count.style.display="none";
	var TrainIdForActive=document.getElementById("TrainIdForActive");
		TrainIdForActive.style.display="block";
	var AdminactivesubmitButton=document.getElementById("AdminactivesubmitButton");
		AdminactivesubmitButton.style.display="block";
	var heading3=document.getElementById("head3");
		heading3.style.display="block";
		
	var stopDiv1=document.getElementById("stopDiv1");
		stopDiv1.style.display="none";
	var sub=document.getElementById("sub");
		sub.style.display="none";
	var heading4=document.getElementById("head4");
		heading4.style.display="none";
	var createStopDiv=document.getElementById("createStopDiv");
		createStopDiv.style.display="none";
	
	
}

function CanTickets(){
	var FrDetails=document.getElementById("color").value="";
	var ToDetails=document.getElementById("colo").value="";
	var daDetails=document.getElementById("date1").value="";
	var clasDetails=document.getElementById("cla").value="";
	seaDetails=document.getElementById("sea").value="";
	var TrainOptions=document.getElementById("TrainOptions").innerText="";
	var Search_Button=document.getElementById("Search_Button");
	var kutty=document.getElementById("kutty");
	var can=document.getElementById("can");
	var AdminKutty2=document.getElementById("AdminKutty2");
	Search_Button.style="z-index:-1"
	kutty.style.display="none";
	AdminKutty2.style.display="none";
	can.style.display="flex";
	
	
	var viewTickets=document.getElementById("whol2");
	var whole2=document.getElementById("whole2");
	let back=document.getElementById("back");
	
	viewTickets.style.display ="flex";
	Search_Button.style.display = "flex";
	Search_Button.style= "z-index:-1";
	whole2.style.display="none";
	back.style.height="400px";
	
	
	
}


function CancellTrain(){
	console.log("cancell");
	var FrDetails=document.getElementById("color");
	var ToDetails=document.getElementById("colo");
	var daDetails=document.getElementById("date1");
	var clasDetails=document.getElementById("cla");
	seaDetails=document.getElementById("sea");
	let can=document.getElementById("can");
	can.style.display="flex";
	var xhr=new XMLHttpRequest();
	xhr.onreadystatechange=function(){
		console.log(this.readyState);
		
		if((this.readyState==4)){
			if(this.status==200){ 
			console.log(xhr.responseText);
			
			
			
		 	}		
		}
	}
	
	if((FromArray.includes(FrDetails.value))&&(ToArray.includes(ToDetails.value))&&(FrDetails.value!=ToDetails.value)&&(daDetails.value!="")&&(clasDetails.value!="")&&(seaDetails!="")){		
		var reqparam={};
	reqparam.FrDetails=document.getElementById("color").value;
	reqparam.ToDetails=document.getElementById("colo").value;
	reqparam.daDetails=document.getElementById("date1").value;
	reqparam.clasDetails=document.getElementById("cla").value;
	reqparam.seaDetails=document.getElementById("sea").value;
	xhr.open("POST","user/CancellTiceket")
	trde = reqparam;
	xhr.setRequestHeader("content-type","application/x-www-form-urlencoded");
	xhr.send("FrDetails="+reqparam.FrDetails+"&ToDetails="+reqparam.ToDetails+"&daDetails="+reqparam.daDetails+"&clasDetails="+reqparam.clasDetails+"&seaDetails="+reqparam.seaDetails+"&TrainId="+train.TrainId+"&Trainname="+train.Trainname+"&Timing="+train.Timing+"&Price="+train.Price+"&NumOfSeats="+train.NumOfSeats+"&Duration="+train.Duration);
		
	}
		
		else{
			FrDetails.value="";
			ToDetails.value="";
			daDetails.value="";
			clasDetails.value="";
			seaDetails.value="";
			alert("Enter Valid Input !");
		}	
		
	
	
	 
}
