<%@ include file="..\common\header.jsp"%>

<sec:authorize access="isAuthenticated()"> 
	<%@ include file="../common/sidebar.jsp"%>
</sec:authorize>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<sec:authorize access="isAuthenticated()"> 
	<a href="${pageContext.request.contextPath}/group/create"
		class="btn btn-success pull-right"> <i class="fa fa-users"></i>
		Create new Group
	</a>
	</sec:authorize>
	<h1>
		<b>Result:Groups</b>
	</h1>

	<hr class="colorgraph" />
	<c:if test="${empty requestScope.groups}">
   
   <div class="thumbnail text-info alert alert-info"><b>Sorry! No matching group found. </b></div>
</c:if>
<c:if test="${!empty requestScope.groups}">
	<c:forEach items="${requestScope.groups}" var="grp">
		<!--checkUserInGroup(loggedInUser.groups, grp)
		
		
		-->
		<div class="row">
			<div class="col-sm-2 text-center">
				<a href="${pageContext.request.contextPath}/group/view/${grp.groupId}"><img class="pull-left " width="120px" height="120px" alt=""
					src="${grp.groupImage}"></a>
			</div>
			<div class="col-sm-10">

				<a href="${pageContext.request.contextPath}/group/view/${grp.groupId}">
				<h2 class="text-primary">${grp.groupName}</h2>
				</a>
				<p class="text-info">${grp.groupDescription} </p>
				<span
					class="label label-warning">Members: ${grp.member }</span>
			
<span class="pull-right">
<sec:authorize access="isAuthenticated()">
	<c:if test="${not (grp.user.userId ==loggedInUser.userId)}"> 
	    <c:if test="${grp.isJoined=='0'}">
			<a href="${pageContext.request.contextPath}/group/add/${grp.groupId}?fromSearch=true" class="btn btn-success">
	  			<i class="fa fa-thumbs-up"> Join</i>
	  		</a>
	  	</c:if>
	  	<c:if test="${grp.isJoined=='1'}">
	  		<a href="${pageContext.request.contextPath}/group/remove/${grp.groupId}?fromSearch=true" class="btn btn-danger">
	  			<i class="fa fa-thumbs-down"> Leave</i>
	  		</a>
	  	</c:if>
	  </c:if>  	
</sec:authorize>
				
  		<a href="${pageContext.request.contextPath}/group/view/${grp.groupId}" class="btn btn-primary">
  			<i class="fa fa-arrow-circle-right"> View</i>
  		</a>
			</div>

		</div>
		<hr>
	</c:forEach>
	</c:if>
	<!-- </table> -->
</div>

<%@ include file="..\common\footer.jsp"%>