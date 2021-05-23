function requiredFields()
{
	var id=document.registrationForm.id.value;
	var name=document.registrationForm.name.value;
	var age=document.registrationForm.age.value;
	var gender=document.registrationForm.gender.value;
	var team=document.registrationForm.team.value;
	
	if(id==null || id=="")
	{
	alert("Name cant be blank");
	return false;
	}
	if(name==null || name=="")
	{
	alert("Name cant be blank");
	return false;
	}
	if(age==null || age=="")
	{
	alert("Name cant be blank");
	return false;
	}
	if(gender==null || gender=="")
	{
	alert("Name cant be blank");
	return false;
	}
	if(team==null || team=="")
		{
		alert("Name cant be blank");
		return false;
		}
	
	if(age>40 || age<20)
		{
		alert("your age should between 20 and 40");
		return false;
		}
	return true;
	}
$document.ready(function()
		{
	$("home2").click(function()
			{
		$("submit").hide();
			});
		});
