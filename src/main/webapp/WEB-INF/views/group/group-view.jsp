<%@ include file="..\common\header.jsp"%>

<sec:authorize access="isAuthenticated()"> 
	<%@ include file="../common/sidebar.jsp"%>
</sec:authorize>

<div class="col-sm-9 col-sm-offset-3 col-md-9 col-md-offset-2 main">
	<sec:authorize access="isAuthenticated()"> 
	<c:if test=""></c:if>
	<a href="${pageContext.request.contextPath}/group/create"
		class="btn btn-success pull-right"> <i class="fa fa-users"></i>
		Create new Group
	</a>
	</sec:authorize>
	<h1>
		<b>Result:Groups</b>
	</h1>

	<hr class="colorgraph" />
	<div class="row">
			<div class="col-sm-2 text-center">
				<img class="pull-left " width="120px" height="120px" alt=""
					src="${grp.groupImage}">
			</div>
			<div class="col-sm-10">

				<h2 class="text-primary">${grp.groupName}</h2>
				<p class="text-info">${grp.groupDescription} </p>
				<span
					class="label label-warning">Members:1222</span>
			
<span class="pull-right">
<sec:authorize access="isAuthenticated()"> 
	<a href="${pageContext.request.contextPath}/group/edit/${grp.groupId}" class="btn btn-success">
  			<i class="fa fa-thumbs-up"> Join</i></a>
  			<a href="${pageContext.request.contextPath}/group/edit/${grp.groupId}" class="btn btn-danger">
  		<i class="fa fa-thumbs-down"> Leave</i>
  		</a>
</sec:authorize>
				
  		<a href="${pageContext.request.contextPath}/group/delete/${grp.groupId}" class="btn btn-primary">
  			<i class="fa fa-arrow-circle-right"> View</i>
  		</a>
			</div>

		</div>
		<hr>
	
	<!-- </table> -->
</div>

<%@ include file="..\common\footer.jsp"%>
		