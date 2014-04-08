
<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<h1>Change Password</h1>
	<hr class="colorgraph" />

	<form class="form-horizontal col-sm-10" role="form" method="post" onsubmit="return matchPassword();"
		action="${pageContext.request.contextPath}/profile/resetpassword">
		
		<div class="form-group" >
		<span id="errorPassword" class="col-sm-7 control-label" style="color: red">${error }</span>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="col-sm-4 control-label">Old
				Password</label>
			<div class="col-sm-6">
				<input type="password" class="form-control" name="oldPassword"
					placeholder="Enter old password">
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="col-sm-4 control-label">New
				Password</label>
			<div class="col-sm-6">
				<input type="password" id="newPassword" class="form-control" name="newPassword"
					placeholder="Enter new password">
			</div>
		</div>

		<div class="form-group">
			<label for="inputPassword" class="col-sm-4 control-label">Retype
				Password</label>
			<div class="col-sm-6">
				<input type="password" id="retypePassword" class="form-control" name="retypePassword"
					placeholder="Retype new password">
			</div>
		</div>

		<div class="form-group">
			<span class="col-sm-4 control-label"></span>
			<div class="col-sm-6">
				<button type="submit" class="btn btn-success">Save Changes</button>
				<a href="${pageContext.request.contextPath}/profile"
					class="btn btn-default">Cancel</a>
			</div>
		</div>

	</form>
</div>


<script>
function matchPassword(){
	var newPassword = $("#newPassword").val();
	var retypePassword = $("#retypePassword").val();
	if(newPassword === retypePassword){
		return true;
	}
	else{
		$("#errorPassword").html("Password did not match");
	}
	console.log(newPassword);
	console.log(retypePassword);
	return false;	
}
</script>

<%@ include file="../common/footer.jsp"%>