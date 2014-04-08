<%@ include file="common/header.jsp"%>

<div class="container"> 
   
<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post" class="col-xs-4 form-signin" role="form"> 
	<h2 class="form-signin-heading">Please sign in</h2>      
    <c:if test="${param.error != null}">        
        <p class="alert alert-danger">
            Invalid username and password, or your account is disabled.
        </p>
    </c:if>
    <c:if test="${param.logout != null}">       
        <p class="alert alert-info">
            You have been logged out.
        </p>
    </c:if>
    <p>
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="form-control"/>	
    </p>
    <p>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="form-control"/>	
    </p>
    <input type="hidden"                        
        name="${_csrf.parameterName}"
        value="${_csrf.token}"/>
    <button class="btn btn-primary" type="submit" class="btn">Log in</button>
    <a class = "btn btn-link" data-toggle="modal" data-target="#forgetPasswordModal">Forgot Password</a>
</form>
</div>

<div class="modal fade" id="forgetPasswordModal" role="dialog">
  <div class="modal-dialog">
    <div class="modal-content">
    <form onsubmit="return resetPassword();">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
        <h4 class="modal-title">Forgot Password</h4>
      </div>
      <div class="modal-body">
        <input type="email" id="email" class="form-control" placeholder="Enter your email address" />
        <span id="result"></span>
      </div>
      <div class="modal-footer">
        <a class="btn btn-default" data-dismiss="modal">Close</a>
        <input type="submit" class="btn btn-primary" value="Reset Password">
      </div>
      </form>
    </div><!-- /.modal-content -->
  </div><!-- /.modal-dialog -->
</div><!-- /.modal -->

<script
	src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
	
<script>
function resetPassword(){
	alert("reset works");
	var email = $("#email").val();
	$("#result").html("");
	var url = "${pageContext.request.contextPath}/resetpassword";
	var obj = {
			email: email
	};
	$.post( url,obj, function( data ) {
		  $("#result").html(data);
		  $("#email").val("");
		});
	return false;
}
</script>
<%@ include file="common/footer.jsp"%>