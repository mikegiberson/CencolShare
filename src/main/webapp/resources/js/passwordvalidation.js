/*
Author - Shalin Banjara
Usage - Validating Password
 */

function validatepassword() {
	setPassword = document.getElementById("setpassword").value;
	currPassword = document.getElementById("currentPassword").value;
	newPassword = document.getElementById("newPassword").value;
	confirmPassword = document.getElementById("confirmPassword").value;
	
	if (setPassword != currPassword ) {
		alert ("Current password entered is incorrect.");
		return false;
	}
	if (newPassword != confirmPassword){
		alert ("New password and confirm password does not match.");
		return false;
	}
	else {
		return true;
	}
}