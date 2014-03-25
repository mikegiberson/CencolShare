<%@ include file="../common/header.jsp"%>
<%@ include file="../common/sidebar.jsp"%>
	<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<span class="pull-right">
	
		<form action="" method="get" class="form-inline">
			<input type="text" placeholder="Search User..." name="criteria"
			value="<%
			if(request.getParameter("criteria") != null) {
				out.print(request.getParameter("criteria"));
			}
			%>">
			<a class="btn btn-success btn-sm" href="${pageContext.request.contextPath}/user/create"><i class="fa fa-plus"></i> Add User</a>
		</form>
		
	</span>
	<h1>View Users</h1>
	<hr/>
	<div class="col-md-12">	    
		<c:forEach items="${users}" var="u">
			<h2>${u.firstName} ${u.lastName}</h2>
			<p> ${u.email}, ${u.country}</p>
		    <div>
		        <c:choose>
		        	<c:when test="${u.enabled}">
		        		<span class="label label-success">Enabled</span>
		        	</c:when>
		        	<c:otherwise>
		        		<span class="label label-danger">Disabled</span>
		        	</c:otherwise>
		        </c:choose>
		        <c:choose>
		        	<c:when test="${u.role.toString().equals(\"ADMIN\")}">
		        		<span class="label label-primary">Role: ${u.role.toString()}</span>
		        	</c:when>
		        	<c:when test="${u.role.toString().equals(\"MANAGER\")}">
		        		<span class="label label-info">Role: ${u.role.toString()}</span>
		        	</c:when>		        	
		        	<c:otherwise>
		        		<span class="label label-warning">Role: ${u.role.toString()}</span>
		        	</c:otherwise>
		        </c:choose>
		        
		        
		        
		        <div class="pull-right">
					<a href="${pageContext.request.contextPath}/user/edit/${u.userId}" class="btn btn-sm btn-primary">
			  			<i class="fa fa-pencil"></i>
			  		</a>
		        </div>
		    </div>		
			<hr>
		</c:forEach>
	</div>
	</div>
</div>

<%@ include file="../common/footer.jsp"%>
