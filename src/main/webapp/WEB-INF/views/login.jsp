<%@ include file="common/header.jsp"%>

<div class="container"> 
   
<c:url value="/login" var="loginUrl"/>
<form action="${loginUrl}" method="post" class="col-xs-4 form-signin" role="form"> 
	<h2 class="form-signin-heading">Please sign in</h2>      
    <c:if test="${param.error != null}">        
        <p>
            Invalid username and password.
        </p>
    </c:if>
    <c:if test="${param.logout != null}">       
        <p>
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
    <button class="btn btn-lg btn-primary btn-block" type="submit" class="btn">Log in</button>
</form>
</div>

<%@ include file="common/footer.jsp"%>