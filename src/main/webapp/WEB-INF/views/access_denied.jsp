<%@ include file="common/header.jsp"%>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">

	<div class="alert alert-danger">
		<strong>That doesn't seem right!</strong>
	
	<c:choose>
	  <c:when test="${param['error'] == 'NO_ACCESS.jsp'}">
	    You are not authorized to access this file
	  </c:when>
	  <c:when test="${param['error'] == 'LOGIN_FAILURE.jsp'}">
	    You dont have access to the file you requested.
	  </c:when>
	  <c:otherwise>
	    Please try again later.
	  </c:otherwise>
	</c:choose>
			
			
	</div>
	<a class="pull-right" style="padding: 9px"
		onclick="window.history.back()">Go Back</a>
</div>
</div>

<%@ include file="common/footer.jsp"%>